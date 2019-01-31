package com.jdadfapi.model.common;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 07-Dec-17
 * Time: 18:07
 */

public class Item extends XMLElement {
    public Item(Element element) {
        super(element);
    }
    public String getValue(){
        return getAttrValue(AttributeNames.VALUE_UPPER);
    }

    public void setValue(String value){
        setAttrValue(AttributeNames.VALUE_UPPER, value);
    }

    public void remove(){
        element.remove();
    }

    @Override
    public String toString() {
        return getValue() == null ? super.toString() : getValue();
    }
}
