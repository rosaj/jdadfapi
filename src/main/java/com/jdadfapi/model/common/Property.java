package com.jdadfapi.model.common;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 17-Jan-18
 * Time: 17:19
 */

public class Property extends XMLElement {
    private boolean translatable;
    public Property(Element element,boolean translatable) {
        super(element);
        this.translatable = translatable;
    }
    public void setName(String value) {
        setAttrValue(AttributeNames.NAME_UPPER, value);
    }
    public String getName() {
        return getAttrValue(AttributeNames.NAME_UPPER);
    }

    public void setValue(String value) {
        if(translatable) setAttrValue(AttributeNames.RES_ID, value);
        else setAttrValue(AttributeNames.VALUE_UPPER, value);
    }
    public String getValue() {
        if(translatable) return getAttrValue(AttributeNames.RES_ID);
        return getAttrValue(AttributeNames.VALUE_UPPER);
    }

    public boolean isTranslatable() {
        return translatable;
    }
}
