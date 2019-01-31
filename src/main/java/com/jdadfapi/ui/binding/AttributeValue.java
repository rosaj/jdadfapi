package com.jdadfapi.ui.binding;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 10-Nov-17
 * Time: 15:35
 */

public class AttributeValue extends XMLElement {
    public AttributeValue(Element element) {
        super(element);
    }

    public String getIterBinding (){
        return getAttrValue(AttributeNames.ITER_BINDING );
    }
    public void setIterBinding (String value){
        setAttrValue(AttributeNames.ITER_BINDING , value);
    }

    public String getCustomInputHandler (){
        return getAttrValue(AttributeNames.CUSTOM_INPUT_HANDLER );
    }
    public void setCustomInputHandler (String value){
        setAttrValue(AttributeNames.CUSTOM_INPUT_HANDLER , value);
    }

    public String getApplyValidation (){
        return getAttrValue(AttributeNames.APPLY_VALIDATION );
    }
    public void setApplyValidation (String value){
        setAttrValue(AttributeNames.APPLY_VALIDATION , value);
    }

    public String getViewable (){
        return getAttrValue(AttributeNames.VIEWABLE );
    }
    public void setViewable (String value){
        setAttrValue(AttributeNames.VIEWABLE , value);
    }

    public String getNullValueId (){
        return getAttrValue(AttributeNames.NULL_VALUE_ID );
    }
    public void setNullValueId (String value){
        setAttrValue(AttributeNames.NULL_VALUE_ID , value);
    }

    public String getUseRowHints (){
        return getAttrValue(AttributeNames.USE_ROW_HINTS );
    }
    public void setUseRowHints (String value){
        setAttrValue(AttributeNames.USE_ROW_HINTS , value);
    }

    public String getChangeEventPolicy (){
        return getAttrValue(AttributeNames.CHANGE_EVENT_POLICY );
    }
    public void setChangeEventPolicy (String value){
        setAttrValue(AttributeNames.CHANGE_EVENT_POLICY , value);
    }


    public String getTrackInput (){
        return getAttrValue(AttributeNames.TRACK_INPUT );
    }
    public void setTrackInput (String value){
        setAttrValue(AttributeNames.TRACK_INPUT , value);
    }

}
