package com.jdadfapi.ui.component.textandselection;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import com.jdadfapi.ui.component.UIComponent;
import com.jdadfapi.ui.component.generalcontrols.Link;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 14-Nov-17
 * Time: 15:32
 */

public class SelectBooleanCheckbox extends InputUIComponent {
    public SelectBooleanCheckbox(Element element, Component parent) {
        super(element, parent);
    }

    public SelectBooleanCheckbox(Component parent) {
        super(new Element(ComponentMapper.getComponentName(SelectBooleanCheckbox.class)),parent);
    }

    public SelectBooleanCheckbox() {
        this(null);
    }
    public String getText(){
        return getAttrValue(AttributeNames.TEXT);
    }
    public  void setText(String value){
        setAttrValue(AttributeNames.TEXT, value);
    }
    //TODO: IMPLEMENT
}
