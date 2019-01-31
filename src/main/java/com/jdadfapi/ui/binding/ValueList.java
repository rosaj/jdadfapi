package com.jdadfapi.ui.binding;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Dec-17
 * Time: 01:32
 */

public class ValueList extends AttrNames {
    public ValueList(Element element) {
        super(element);
    }
    public void setName(String value){
        setAttrValue(AttributeNames.NAME_UPPER, value);
    }
    public String getName(){
        return getAttrValue(AttributeNames.NAME_UPPER);
    }
}
