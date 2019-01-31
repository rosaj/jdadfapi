package com.jdadfapi.ui.component.textandselection;

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
 * Time: 07:36
 */

public class InputText extends InputUIComponent {
    public InputText(Element element, Component parent) {
        super(element, parent);
    }

    public InputText(Component parent) {
        super(new Element(ComponentMapper.getComponentName(InputText.class)),parent);
    }

    public InputText() {
        this(null);
    }


    public String getRows (){
        return getAttrValue(AttributeNames.ROWS );
    }
    public void setRows (String value){
        setAttrValue(AttributeNames.ROWS , value);
    }

    public String getDimensionsFrom (){
        return getAttrValue(AttributeNames.DIMENSIONS_FROM );
    }
    public void setDimensionsFrom (String value){
        setAttrValue(AttributeNames.DIMENSIONS_FROM , value);
    }

    public String getSecret (){
        return getAttrValue(AttributeNames.SECRET );
    }
    public void setSecret (String value){
        setAttrValue(AttributeNames.SECRET , value);
    }

    public String getWrap (){
        return getAttrValue(AttributeNames.WRAP );
    }
    public void setWrap (String value){
        setAttrValue(AttributeNames.WRAP , value);
    }



}
