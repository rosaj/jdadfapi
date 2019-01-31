package com.jdadfapi.ui.component.templating;

import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 29-Nov-17
 * Time: 20:01
 */

public class CFacetName extends TemplateComponent {
    public CFacetName(Element element, Component parent) {
        super(element, parent);
    }
    public CFacetName(){
        this(null);
    }
    public CFacetName(Component parent){
        this(new Element(ComponentMapper.getComponentName(CFacetName.class)), parent);
    }
    public String getText(){
        return element.getText();
    }
    public void setText(String value){
        element.setText(value);
    }
}
