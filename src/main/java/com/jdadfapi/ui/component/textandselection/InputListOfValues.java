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
 * Time: 14:51
 */

public class InputListOfValues extends InputUIComponent {
    public InputListOfValues(Element element, Component parent) {
        super(element, parent);
    }

    public InputListOfValues(Component parent) {
        super(new Element(ComponentMapper.getComponentName(InputListOfValues.class)),parent);
    }

    public InputListOfValues() {
        this(null);
    }

    public String getModel (){
        return getAttrValue(AttributeNames.MODEL );
    }
    public void setModel (String value){
        setAttrValue(AttributeNames.MODEL , value);
    }

    public String getReturnPopupDataValue (){
        return getAttrValue(AttributeNames.RETURN_POPUP_DATA_VALUE );
    }
    public void setReturnPopupDataValue (String value){
        setAttrValue(AttributeNames.RETURN_POPUP_DATA_VALUE , value);
    }
/*
    public String getEditable (){
        return getAttrValue(AttributeNames.EDITABLE );
    }
    public void setEditable (String value){
        setAttrValue(AttributeNames.EDITABLE , value);
    }
*/
    public String getResultsTableColumnStretching (){
        return getAttrValue(AttributeNames.RESULTS_TABLE_COLUMN_STRETCHING );
    }
    public void setResultsTableColumnStretching (String value){
        setAttrValue(AttributeNames.RESULTS_TABLE_COLUMN_STRETCHING , value);
    }

    public String getPopupTitle (){
        return getAttrValue(AttributeNames.POPUP_TITLE );
    }
    public void setPopupTitle (String value){
        setAttrValue(AttributeNames.POPUP_TITLE , value);
    }

    public String getSearchDesc (){
        return getAttrValue(AttributeNames.SEARCH_DESC );
    }
    public void setSearchDesc (String value){
        setAttrValue(AttributeNames.SEARCH_DESC , value);
    }

    public String getEditMode (){
        return getAttrValue(AttributeNames.EDIT_MODE );
    }
    public void setEditMode (String value){
        setAttrValue(AttributeNames.EDIT_MODE , value);
    }

    public String getCreatePopupId (){
        return getAttrValue(AttributeNames.CREATE_POPUP_ID );
    }
    public void setCreatePopupId (String value){
        setAttrValue(AttributeNames.CREATE_POPUP_ID , value);
    }

    public String getLaunchPopupListener (){
        return getAttrValue(AttributeNames.LAUNCH_POPUP_LISTENER );
    }
    public void setLaunchPopupListener (String value){
        setAttrValue(AttributeNames.LAUNCH_POPUP_LISTENER , value);
    }

    public String getReturnPopupListener (){
        return getAttrValue(AttributeNames.RETURN_POPUP_LISTENER );
    }
    public void setReturnPopupListener (String value){
        setAttrValue(AttributeNames.RETURN_POPUP_LISTENER , value);
    }

    public String getReturnPopupDataListener (){
        return getAttrValue(AttributeNames.RETURN_POPUP_DATA_LISTENER );
    }
    public void setReturnPopupDataListener (String value){
        setAttrValue(AttributeNames.RETURN_POPUP_DATA_LISTENER , value);
    }

}
