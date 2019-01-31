package com.jdadfapi.model.common;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 10-Nov-17
 * Time: 14:39
 */

public class Attr extends XMLElement {
    public Attr(Element element) {
        super(element);
    }

    public String getName(){
        return getAttrValue(AttributeNames.NAME_UPPER);
    }
    public void setName(String value){
        setAttrValue(AttributeNames.NAME_UPPER,value);
    }

    public String getValue(){
        return getAttrValue(AttributeNames.VALUE_UPPER);
    }
    public void setValue(String value){
        setAttrValue(AttributeNames.VALUE_UPPER,value);
    }
}
