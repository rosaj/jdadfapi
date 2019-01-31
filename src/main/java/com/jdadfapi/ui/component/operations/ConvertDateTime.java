package com.jdadfapi.ui.component.operations;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 15-Nov-17
 * Time: 15:21
 */

public class ConvertDateTime extends Converter {

    public ConvertDateTime(Element element, Component parent) {
        super(element, parent);
    }

    public ConvertDateTime() {
        this(null);
    }

    public ConvertDateTime(Component parent) {
        super(new Element(ComponentMapper.getComponentName(ConvertDateTime.class)), parent);
    }


    public String getPattern(){
        return getAttrValue(AttributeNames.PATTERN);
    }
    public void setPattern(String value){
        setAttrValue(AttributeNames.PATTERN, value);
    }

    //TODO: OSTALO

}
