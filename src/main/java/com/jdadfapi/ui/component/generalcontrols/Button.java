package com.jdadfapi.ui.component.generalcontrols;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import com.jdadfapi.ui.component.UIComponent;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 08-Nov-17
 * Time: 07:22
 */

public class Button extends Command {
    public Button(Element element, Component parent) {
        super(element, parent);
    }

    public Button(Component parent) {
        super(new Element(ComponentMapper.getComponentName(Button.class)),parent);
    }

    public Button() {
        this(null);
    }
    public String getActionDelivery (){
        return getAttrValue(AttributeNames.ACTION_DELIVERY );
    }
    public void setActionDelivery (String value){
        setAttrValue(AttributeNames.ACTION_DELIVERY , value);
    }
}
