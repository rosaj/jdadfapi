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
 * Time: 17:28
 */

public class ShowDetailItem extends LayoutComponent {
    public ShowDetailItem(Element element, Component parent) {
        super(element, parent);
    }

    public ShowDetailItem(Component parent) {
        super(new Element(ComponentMapper.getComponentName(ShowDetailItem.class)),parent);
    }

    public ShowDetailItem() {
        this(null);
    }


   public String getText (){
        return getAttrValue(AttributeNames.TEXT );
    }
    public void setText (String value){
        setAttrValue(AttributeNames.TEXT , value);
    }

    public String getDisclosed (){
        return getAttrValue(AttributeNames.DISCLOSED );
    }
    public void setDisclosed (String value){
        setAttrValue(AttributeNames.DISCLOSED , value);
    }

    public String getFlex (){
        return getAttrValue(AttributeNames.FLEX );
    }
    public void setFlex (String value){
        setAttrValue(AttributeNames.FLEX , value);
    }

    public String getInflexibleHeight (){
        return getAttrValue(AttributeNames.INFLEXIBLE_HEIGHT );
    }
    public void setInflexibleHeight (String value){
        setAttrValue(AttributeNames.INFLEXIBLE_HEIGHT , value);
    }

    public String getStretchChildren (){
        return getAttrValue(AttributeNames.STRETCH_CHILDREN );
    }
    public void setStretchChildren (String value){
        setAttrValue(AttributeNames.STRETCH_CHILDREN , value);
    }

    public String getBadge (){
        return getAttrValue(AttributeNames.BADGE );
    }
    public void setBadge (String value){
        setAttrValue(AttributeNames.BADGE , value);
    }

    public String getRemove (){
        return getAttrValue(AttributeNames.REMOVE );
    }
    public void setRemove (String value){
        setAttrValue(AttributeNames.REMOVE , value);
    }

    public String getDisclosureListener (){
        return getAttrValue(AttributeNames.DISCLOSURE_LISTENER );
    }
    public void setDisclosureListener (String value){
        setAttrValue(AttributeNames.DISCLOSURE_LISTENER , value);
    }

    public String getItemListener (){
        return getAttrValue(AttributeNames.ITEM_LISTENER );
    }
    public void setItemListener (String value){
        setAttrValue(AttributeNames.ITEM_LISTENER , value);
    }

    public String getIcon (){
        return getAttrValue(AttributeNames.ICON );
    }
    public void setIcon (String value){
        setAttrValue(AttributeNames.ICON , value);
    }

    public String getDepressedIcon (){
        return getAttrValue(AttributeNames.DEPRESSED_ICON );
    }
    public void setDepressedIcon (String value){
        setAttrValue(AttributeNames.DEPRESSED_ICON , value);
    }

    public String getHoverIcon (){
        return getAttrValue(AttributeNames.HOVER_ICON );
    }
    public void setHoverIcon (String value){
        setAttrValue(AttributeNames.HOVER_ICON , value);
    }

    public String getDisabledIcon (){
        return getAttrValue(AttributeNames.DISABLED_ICON );
    }
    public void setDisabledIcon (String value){
        setAttrValue(AttributeNames.DISABLED_ICON , value);
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

    public String getDisplayIndex (){
        return getAttrValue(AttributeNames.DISPLAY_INDEX );
    }
    public void setDisplayIndex (String value){
        setAttrValue(AttributeNames.DISPLAY_INDEX , value);
    }

    public String getImmediate (){
        return getAttrValue(AttributeNames.IMMEDIATE );
    }
    public void setImmediate (String value){
        setAttrValue(AttributeNames.IMMEDIATE , value);
    }

    public String getPersist (){
        return getAttrValue(AttributeNames.PERSIST );
    }
    public void setPersist (String value){
        setAttrValue(AttributeNames.PERSIST , value);
    }

    public String getDontPersist (){
        return getAttrValue(AttributeNames.DONT_PERSIST );
    }
    public void setDontPersist (String value){
        setAttrValue(AttributeNames.DONT_PERSIST , value);
    }

    public String getIconDelivery (){
        return getAttrValue(AttributeNames.ICON_DELIVERY );
    }
    public void setIconDelivery (String value){
        setAttrValue(AttributeNames.ICON_DELIVERY , value);
    }



}
