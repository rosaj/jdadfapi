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
 * Date: 05-Nov-17
 * Time: 11:53
 */

public class Link extends Command {
    public Link(Element element, Component parent) {
        super(element, parent);
    }

    public Link(Component parent) {
            super(new Element(ComponentMapper.getComponentName(Link.class)),parent);
    }

    public Link() {
        this(null);
    }


    public String getIconDelivery (){
        return getAttrValue(AttributeNames.ICON_DELIVERY );
    }

    public void setIconDelivery (String value){
        setAttrValue(AttributeNames.ICON_DELIVERY , value);
    }

}
