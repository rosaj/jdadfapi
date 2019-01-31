package com.jdadfapi.ui.component.layout;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Dec-17
 * Time: 23:39
 */

public class Region extends LayoutComponent {
    public Region(Element element, Component parent) {
        super(element, parent);
    }
    public Region(Component parent){
        this(new Element(ComponentMapper.getComponentName(Region.class)),parent);
    }
    public Region(){
        this(null);
    }

    public void setValue(String value){
        setAttrValue(AttributeNames.VALUE, value);
    }


    //TODO: OSTALI
}
