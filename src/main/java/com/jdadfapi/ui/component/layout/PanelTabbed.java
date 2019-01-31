package com.jdadfapi.ui.component.layout;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import com.jdadfapi.ui.component.UIComponent;
import com.jdadfapi.ui.component.generalcontrols.Link;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 08-Nov-17
 * Time: 17:05
 */

public class PanelTabbed extends LayoutComponent {
    public PanelTabbed(Element element, Component parent) {
        super(element, parent);
    }

    public PanelTabbed(Component parent) {
        super(new Element(ComponentMapper.getComponentName(PanelTabbed.class)),parent);
    }

    public PanelTabbed() {
        this(null);
    }

    public String getPosition (){
        return getAttrValue(AttributeNames.POSITION );
    }
    public void setPosition (String value){
        setAttrValue(AttributeNames.POSITION , value);
    }

    public String getTabRemoval (){
        return getAttrValue(AttributeNames.TAB_REMOVAL );
    }
    public void setTabRemoval (String value){
        setAttrValue(AttributeNames.TAB_REMOVAL , value);
    }

    public String getDimensionsFrom (){
        return getAttrValue(AttributeNames.DIMENSIONS_FROM );
    }
    public void setDimensionsFrom (String value){
        setAttrValue(AttributeNames.DIMENSIONS_FROM , value);
    }

    public String getMaxTabSize (){
        return getAttrValue(AttributeNames.MAX_TAB_SIZE );
    }
    public void setMaxTabSize (String value){
        setAttrValue(AttributeNames.MAX_TAB_SIZE , value);
    }

    public String getMinTabSize (){
        return getAttrValue(AttributeNames.MIN_TAB_SIZE );
    }
    public void setMinTabSize (String value){
        setAttrValue(AttributeNames.MIN_TAB_SIZE , value);
    }

    public String getTruncationStyle (){
        return getAttrValue(AttributeNames.TRUNCATION_STYLE );
    }
    public void setTruncationStyle (String value){
        setAttrValue(AttributeNames.TRUNCATION_STYLE , value);
    }

    public String getChildCreation (){
        return getAttrValue(AttributeNames.CHILD_CREATION );
    }
    public void setChildCreation (String value){
        setAttrValue(AttributeNames.CHILD_CREATION , value);
    }

}
