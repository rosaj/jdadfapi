package com.jdadfapi.ui.binding;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 09-Nov-17
 * Time: 01:21
 */

public class Item extends XMLElement {
    public Item(Element element) {
        super(element);
    }

    public String getValue(){
        return getAttrValue(AttributeNames.VALUE_UPPER);
    }
    public void setValue(String value){
         setAttrValue(AttributeNames.VALUE_UPPER,value);
    }

    public String getBinds(){
        return getAttrValue(AttributeNames.BINDS);
    }
    public void setBinds(String value){
        setAttrValue(AttributeNames.BINDS,value);
    }
    public String getCustomInputHandler(){
        return getAttrValue(AttributeNames.CUSTOM_INPUT_HANDLER);
    }
    public void setCustomInputHandler(String value){
        setAttrValue(AttributeNames.CUSTOM_INPUT_HANDLER,value);
    }

}
