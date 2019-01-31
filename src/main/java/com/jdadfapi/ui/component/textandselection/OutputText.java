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
 * Time: 15:37
 */

public class OutputText extends UIComponent {
    public OutputText(Element element, Component parent) {
        super(element, parent);
    }

    public OutputText(Component parent) {
        super(new Element(ComponentMapper.getComponentName(OutputText.class)),parent);
    }

    public OutputText() {
        this(null);
    }

    public String getRefreshCondition (){
        return getAttrValue(AttributeNames.REFRESH_CONDITION );
    }
    public void setRefreshCondition (String value){
        setAttrValue(AttributeNames.REFRESH_CONDITION , value);
    }


    public String getEscape (){
        return getAttrValue(AttributeNames.ESCAPE );
    }
    public void setEscape (String value){
        setAttrValue(AttributeNames.ESCAPE , value);
    }

    public String getConverter (){
        return getAttrValue(AttributeNames.CONVERTER );
    }
    public void setConverter (String value){
        setAttrValue(AttributeNames.CONVERTER , value);
    }

    public String getDescription (){
        return getAttrValue(AttributeNames.DESCRIPTION );
    }
    public void setDescription (String value){
        setAttrValue(AttributeNames.DESCRIPTION , value);
    }

    public String getTruncateAt (){
        return getAttrValue(AttributeNames.TRUNCATE_AT );
    }
    public void setTruncateAt (String value){
        setAttrValue(AttributeNames.TRUNCATE_AT , value);
    }

    public String getNoWrap (){
        return getAttrValue(AttributeNames.NO_WRAP );
    }
    public void setNoWrap (String value){
        setAttrValue(AttributeNames.NO_WRAP , value);
    }

}
