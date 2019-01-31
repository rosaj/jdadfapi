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
 * Time: 07:38
 */

public class InputUIComponent extends UIComponent {
    public InputUIComponent(Element element, Component parent) {
        super(element, parent);
    }

    public InputUIComponent(Component parent) {
        super(new Element(ComponentMapper.getComponentName(InputUIComponent.class)),parent);
    }

    public InputUIComponent() {
        this(null);
    }



    public String getColumns (){
        return getAttrValue(AttributeNames.COLUMNS );
    }
    public void setColumns (String value){
        setAttrValue(AttributeNames.COLUMNS , value);
    }

    public String getShowRequired (){
        return getAttrValue(AttributeNames.SHOW_REQUIRED );
    }
    public void setShowRequired (String value){
        setAttrValue(AttributeNames.SHOW_REQUIRED , value);
    }

    public String getChanged (){
        return getAttrValue(AttributeNames.CHANGED );
    }
    public void setChanged (String value){
        setAttrValue(AttributeNames.CHANGED , value);
    }

    public String getChangedDesc (){
        return getAttrValue(AttributeNames.CHANGED_DESC );
    }
    public void setChangedDesc (String value){
        setAttrValue(AttributeNames.CHANGED_DESC , value);
    }

    public String getEditable (){
        return getAttrValue(AttributeNames.EDITABLE );
    }
    public void setEditable (String value){
        setAttrValue(AttributeNames.EDITABLE , value);
    }

    public String getAccessKey (){
        return getAttrValue(AttributeNames.ACCESS_KEY );
    }
    public void setAccessKey (String value){
        setAttrValue(AttributeNames.ACCESS_KEY , value);
    }

    public String getLabelAndAccessKey (){
        return getAttrValue(AttributeNames.LABEL_AND_ACCESS_KEY );
    }
    public void setLabelAndAccessKey (String value){
        setAttrValue(AttributeNames.LABEL_AND_ACCESS_KEY , value);
    }

    public String getSimple (){
        return getAttrValue(AttributeNames.SIMPLE );
    }
    public void setSimple (String value){
        setAttrValue(AttributeNames.SIMPLE , value);
    }

    public String getHelpTopicId (){
        return getAttrValue(AttributeNames.HELP_TOPIC_ID );
    }
    public void setHelpTopicId (String value){
        setAttrValue(AttributeNames.HELP_TOPIC_ID , value);
    }

    public String getRequiredMessageDetail (){
        return getAttrValue(AttributeNames.REQUIRED_MESSAGE_DETAIL );
    }
    public void setRequiredMessageDetail (String value){
        setAttrValue(AttributeNames.REQUIRED_MESSAGE_DETAIL , value);
    }

    public String getPlaceholder (){
        return getAttrValue(AttributeNames.PLACEHOLDER );
    }
    public void setPlaceholder (String value){
        setAttrValue(AttributeNames.PLACEHOLDER , value);
    }

    public String getContentStyle (){
        return getAttrValue(AttributeNames.CONTENT_STYLE );
    }
    public void setContentStyle (String value){
        setAttrValue(AttributeNames.CONTENT_STYLE , value);
    }

    public String getLabelStyle (){
        return getAttrValue(AttributeNames.LABEL_STYLE );
    }
    public void setLabelStyle (String value){
        setAttrValue(AttributeNames.LABEL_STYLE , value);
    }

    public String getAutoComplete (){
        return getAttrValue(AttributeNames.AUTO_COMPLETE );
    }
    public void setAutoComplete (String value){
        setAttrValue(AttributeNames.AUTO_COMPLETE , value);
    }

    public String getAutoTab (){
        return getAttrValue(AttributeNames.AUTO_TAB );
    }
    public void setAutoTab (String value){
        setAttrValue(AttributeNames.AUTO_TAB , value);
    }

    public String getRefreshCondition (){
        return getAttrValue(AttributeNames.REFRESH_CONDITION );
    }
    public void setRefreshCondition (String value){
        setAttrValue(AttributeNames.REFRESH_CONDITION , value);
    }

    public String getUsage (){
        return getAttrValue(AttributeNames.USAGE );
    }
    public void setUsage (String value){
        setAttrValue(AttributeNames.USAGE , value);
    }

    public String getImmediate (){
        return getAttrValue(AttributeNames.IMMEDIATE );
    }
    public void setImmediate (String value){
        setAttrValue(AttributeNames.IMMEDIATE , value);
    }

    public String getConverter (){
        return getAttrValue(AttributeNames.CONVERTER );
    }
    public void setConverter (String value){
        setAttrValue(AttributeNames.CONVERTER , value);
    }

    public String getMaximumLength (){
        return getAttrValue(AttributeNames.MAXIMUM_LENGTH );
    }
    public void setMaximumLength (String value){
        setAttrValue(AttributeNames.MAXIMUM_LENGTH , value);
    }

    public String getValueChangedListener (){
        return getAttrValue(AttributeNames.VALUE_CHANGED_LISTENER );
    }
    public void setValueChangedListener (String value){
        setAttrValue(AttributeNames.VALUE_CHANGED_LISTENER , value);
    }

    public String getProtectionKey (){
        return getAttrValue(AttributeNames.PROTECTION_KEY );
    }
    public void setProtectionKey (String value){
        setAttrValue(AttributeNames.PROTECTION_KEY , value);
    }

    public String getLabel(){
        return getAttrValue(AttributeNames.LABEL);
    }

    public void setLabel(String value){
        setAttrValue(AttributeNames.LABEL,value);
    }

    public String getAutoSubmit(){
        return getAttrValue(AttributeNames.AUTO_SUBMIT);
    }
    public void setAutoSubmit(String value){
        setAttrValue(AttributeNames.AUTO_SUBMIT,value);
    }



}
