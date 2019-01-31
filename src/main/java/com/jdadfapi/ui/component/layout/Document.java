package com.jdadfapi.ui.component.layout;

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
 * Date: 07-Nov-17
 * Time: 18:47
 */

public class Document extends LayoutComponent {
    public Document(Element element, Component parent) {
        super(element, parent);
    }

    public Document(Component parent) {
        super(new Element(ComponentMapper.getComponentName(Document.class)),parent);
    }

    public Document() {
        this(null);
    }


   public String getInitialFocusId (){
        return getAttrValue(AttributeNames.INITIAL_FOCUS_ID );
    }
    public void setInitialFocusId (String value){
        setAttrValue(AttributeNames.INITIAL_FOCUS_ID , value);
    }

    public String getMaximized (){
        return getAttrValue(AttributeNames.MAXIMIZED );
    }
    public void setMaximized (String value){
        setAttrValue(AttributeNames.MAXIMIZED , value);
    }

    public String getTitle (){
        return getAttrValue(AttributeNames.TITLE );
    }
    public void setTitle (String value){
        setAttrValue(AttributeNames.TITLE , value);
    }

    public String getLargeIconSource (){
        return getAttrValue(AttributeNames.LARGE_ICON_SOURCE );
    }
    public void setLargeIconSource (String value){
        setAttrValue(AttributeNames.LARGE_ICON_SOURCE , value);
    }

    public String getSmallIconSource (){
        return getAttrValue(AttributeNames.SMALL_ICON_SOURCE );
    }
    public void setSmallIconSource (String value){
        setAttrValue(AttributeNames.SMALL_ICON_SOURCE , value);
    }

    public String getFailedConnectionText (){
        return getAttrValue(AttributeNames.FAILED_CONNECTION_TEXT );
    }
    public void setFailedConnectionText (String value){
        setAttrValue(AttributeNames.FAILED_CONNECTION_TEXT , value);
    }

    public String getTheme (){
        return getAttrValue(AttributeNames.THEME );
    }
    public void setTheme (String value){
        setAttrValue(AttributeNames.THEME , value);
    }

    public String getUncommittedDataWarning (){
        return getAttrValue(AttributeNames.UNCOMMITTED_DATA_WARNING );
    }
    public void setUncommittedDataWarning (String value){
        setAttrValue(AttributeNames.UNCOMMITTED_DATA_WARNING , value);
    }

    public String getOnunload (){
        return getAttrValue(AttributeNames.ON_UNLOAD );
    }
    public void setOnunload (String value){
        setAttrValue(AttributeNames.ON_UNLOAD , value);
    }

    public String getStateSaving (){
        return getAttrValue(AttributeNames.STATE_SAVING );
    }
    public void setStateSaving (String value){
        setAttrValue(AttributeNames.STATE_SAVING , value);
    }



}
