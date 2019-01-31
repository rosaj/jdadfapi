package com.jdadfapi.ui.databindings;

import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import com.jdadfapi.model.Model;
import com.jdadfapi.model.applicationmodule.ApplicationModule;
import com.jdadfapi.ui.Page;
import com.jdadfapi.ui.ViewController;
import com.jdadfapi.ui.binding.Iterator;
import de.pdark.decentxml.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 02-Aug-18
 * Time: 11:02
 */

public class DataControlUsages extends XMLElement {
    List<BC4JDataControl> bc4JDataControls = new ArrayList<>();
    public DataControlUsages(Element element) {
        super(element);
        loadTree();
    }
    void loadTree(){
        List<Element> elements = element.getChildren(TagNames.BC4J_DATA_CONTROL);
        if(elements != null && elements.size()>0) {
            for (Element el : elements) bc4JDataControls.add(new BC4JDataControl(el));
        }
    }

    public List<BC4JDataControl> getBc4JDataControls() {
        return bc4JDataControls;
    }

    public BC4JDataControl findBC4JDataControl(String dataControl){
        for (BC4JDataControl bc4JDataControl : bc4JDataControls) {
            if(dataControl.equals(bc4JDataControl.getId()))return bc4JDataControl;
        }

        return null;
    }

    public boolean addBC4JDataControlIfNeeded(Page page, Model model){

        List<String> amsToAdd = new ArrayList<>();

        for(Iterator iter : page.getPageDefinition().getExecutables().getIterators()){
            String dataControl = iter.getDataControl();

            if(findBC4JDataControl(dataControl) == null && !amsToAdd.contains(dataControl))
                amsToAdd.add(dataControl);
        }

        if(amsToAdd.isEmpty())return false;

        //Am ne postoji i triba inicializirat

        for(String dataControl : amsToAdd) {

            BC4JDataControl dc = new BC4JDataControl(addChildElement(TagNames.BC4J_DATA_CONTROL));

            dc.setConfiguration(dataControl.replace("DataControl", "Local"));
            dc.setFactoryClass("oracle.adf.model.bc4j.DataControlFactoryImpl");
            dc.setSupportsFindMode("true");
            dc.setSupportsRangesize("true");
            dc.setSupportsResetState("true");
            dc.setSupportsSortCollection("true");
            dc.setSupportsTransactions("true");
            dc.setId(dataControl);
            dc.setSyncMode("Immediate");
            dc.setXmlns("http://xmlns.oracle.com/adfm/datacontrol");

            String amName = dataControl.replace("DataControl","");
            ApplicationModule am = model.getApplicationModule(amName);

            if(am == null) throw new RuntimeException("Unable to locate application module " + amName);

            dc.setPackage(am.getPackage());

            bc4JDataControls.add(dc);
        }
        return true;
    }

}
