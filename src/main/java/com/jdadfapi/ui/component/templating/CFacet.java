package com.jdadfapi.ui.component.templating;

import com.jdadfapi.ui.component.Component;
import de.pdark.decentxml.Element;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 29-Nov-17
 * Time: 19:56
 */

public class CFacet extends TemplateComponent {
    public CFacet(Element element, Component parent) {
        super(element, parent);
    }

    public String getFacetName(){
       List<CFacetName> components = getComponents(CFacetName.class);
       if(components.isEmpty())return null;
       return components.get(0).getText();
    }
    public void setFacetName(String value){
        List<CFacetName> components = getComponents(CFacetName.class);
        if(components.isEmpty()) {
            CFacetName facetName = new CFacetName(this);
            facetName.setText(value);
        }
        else
        components.get(0).setText(value);
    }
}
