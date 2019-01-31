package com.jdadfapi.model.applicationmodule;

import com.jdadfapi.TagNames;
import com.jdadfapi.model.Model;
import com.jdadfapi.model.common.NamedModelDocument;
import com.jdadfapi.model.view.ViewObject;
import de.pdark.decentxml.Document;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Node;
import de.pdark.decentxml.XMLTokenizer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Nov-17
 * Time: 11:03
 */

public class ApplicationModule extends NamedModelDocument {
    List<ViewUsage> viewUsages = new ArrayList<>();
    public ApplicationModule(Document document, String path, Model model) {
        super(document, path,model);
        loadTree();
    }

    private void loadTree(){

        for(Node n: document.getRootElement().getNodes()){
            if(n.getType().equals(XMLTokenizer.Type.ELEMENT)){
                Element e = (Element)n;
                switch (e.getName()){
                    case TagNames.VIEW_USAGE        :resolveViewUsage(e);break;
                    case TagNames.VIEW_LINK_USAGE   :resolveViewLinkUsage(e);break;
                    default: log(e);
                    }
                }
            }
    }

    private void resolveViewUsage(Element e){
        viewUsages.add(new ViewUsage(e,this));
    }
    private void resolveViewLinkUsage(Element e){
        //TODO: VIEW_LINK_USAGE
    }

    public List<ViewUsage> getViewUsages() {
        return viewUsages;
    }
    public List<ViewUsage> findViewUsages(ViewObject viewObject) {
        String  viewObjectName = viewObject.getPackage()+"."+viewObject.getName();
        List<ViewUsage> vs = new ArrayList<>();
        for(ViewUsage viewUsage: viewUsages){
            if(viewObjectName.equals(viewUsage.getViewObjectName())) vs.add(viewUsage);
        }
        return vs;
    }
    public ViewUsage findViewUsage(String viewObjectName) {

        for(ViewUsage viewUsage: viewUsages){
            if(viewObjectName.equals(viewUsage.getName())) return viewUsage;
        }

        return null;
    }
}




