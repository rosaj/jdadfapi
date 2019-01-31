package com.jdadfapi.ui.component.generalcontrols;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.UIComponent;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Nov-17
 * Time: 11:53
 */

public class Command extends UIComponent {
    public Command(Element element, Component parent) {
        super(element, parent);
    }

    public Command(Component parent) {
        super(parent);
    }

    public Command() {
        super();
    }

    public String getAction (){
        return getAttrValue(AttributeNames.ACTION );
    }
    public void setAction (String value){
        setAttrValue(AttributeNames.ACTION , value);
    }

    public String getText (){
        return getAttrValue(AttributeNames.TEXT );
    }
    public void setText (String value){
        setAttrValue(AttributeNames.TEXT , value);
    }

    public String getPartialSubmit (){
        return getAttrValue(AttributeNames.PARTIAL_SUBMIT );
    }
    public void setPartialSubmit (String value){
        setAttrValue(AttributeNames.PARTIAL_SUBMIT , value);
    }

    public String getUseWindow (){
        return getAttrValue(AttributeNames.USE_WINDOW );
    }
    public void setUseWindow (String value){
        setAttrValue(AttributeNames.USE_WINDOW , value);
    }

    public String getReturnListener (){
        return getAttrValue(AttributeNames.RETURN_LISTENER );
    }
    public void setReturnListener (String value){
        setAttrValue(AttributeNames.RETURN_LISTENER , value);
    }

    public String getLaunchListener (){
        return getAttrValue(AttributeNames.LAUNCH_LISTENER );
    }
    public void setLaunchListener (String value){
        setAttrValue(AttributeNames.LAUNCH_LISTENER , value);
    }

    public String getImmediate (){
        return getAttrValue(AttributeNames.IMMEDIATE );
    }
    public void setImmediate (String value){
        setAttrValue(AttributeNames.IMMEDIATE , value);
    }

    public String getActionListener (){
        return getAttrValue(AttributeNames.ACTION_LISTENER );
    }
    public void setActionListener (String value){
        setAttrValue(AttributeNames.ACTION_LISTENER , value);
    }

    public String getDestination (){
        return getAttrValue(AttributeNames.DESTINATION );
    }
    public void setDestination (String value){
        setAttrValue(AttributeNames.DESTINATION , value);
    }

    public String getIcon (){
        return getAttrValue(AttributeNames.ICON );
    }
    public void setIcon (String value){
        setAttrValue(AttributeNames.ICON , value);
    }

    public String getIconPosition (){
        return getAttrValue(AttributeNames.ICON_POSITION );
    }
    public void setIconPosition (String value){
        setAttrValue(AttributeNames.ICON_POSITION , value);
    }

    public String getSelected (){
        return getAttrValue(AttributeNames.SELECTED );
    }
    public void setSelected (String value){
        setAttrValue(AttributeNames.SELECTED , value);
    }

    public String getTargetFrame (){
        return getAttrValue(AttributeNames.TARGET_FRAME );
    }
    public void setTargetFrame (String value){
        setAttrValue(AttributeNames.TARGET_FRAME , value);
    }

    public String getWindowEmbedStyle (){
        return getAttrValue(AttributeNames.WINDOW_EMBED_STYLE );
    }
    public void setWindowEmbedStyle (String value){
        setAttrValue(AttributeNames.WINDOW_EMBED_STYLE , value);
    }

    public String getWindowModalityType (){
        return getAttrValue(AttributeNames.WINDOW_MODALITY_TYPE );
    }
    public void setWindowModalityType (String value){
        setAttrValue(AttributeNames.WINDOW_MODALITY_TYPE , value);
    }

    public String getWindowHeight (){
        return getAttrValue(AttributeNames.WINDOW_HEIGHT );
    }
    public void setWindowHeight (String value){
        setAttrValue(AttributeNames.WINDOW_HEIGHT , value);
    }

    public String getWindowWidth (){
        return getAttrValue(AttributeNames.WINDOW_WIDTH );
    }
    public void setWindowWidth (String value){
        setAttrValue(AttributeNames.WINDOW_WIDTH , value);
    }

    public String getAccessKey (){
        return getAttrValue(AttributeNames.ACCESS_KEY );
    }
    public void setAccessKey (String value){
        setAttrValue(AttributeNames.ACCESS_KEY , value);
    }

    public String getTextAndAccessKey (){
        return getAttrValue(AttributeNames.TEXT_AND_ACCESS_KEY );
    }
    public void setTextAndAccessKey (String value){
        setAttrValue(AttributeNames.TEXT_AND_ACCESS_KEY , value);
    }

    public String getHoverIcon (){
        return getAttrValue(AttributeNames.HOVER_ICON );
    }
    public void setHoverIcon (String value){
        setAttrValue(AttributeNames.HOVER_ICON , value);
    }

    public String getDepressedIcon (){
        return getAttrValue(AttributeNames.DEPRESSED_ICON );
    }
    public void setDepressedIcon (String value){
        setAttrValue(AttributeNames.DEPRESSED_ICON , value);
    }

    public String getDisabledIcon (){
        return getAttrValue(AttributeNames.DISABLED_ICON );
    }
    public void setDisabledIcon (String value){
        setAttrValue(AttributeNames.DISABLED_ICON , value);
    }


}
