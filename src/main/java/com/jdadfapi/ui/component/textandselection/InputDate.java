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
 * Time: 15:25
 */

public class InputDate extends InputUIComponent {
    public InputDate(Element element, Component parent) {
        super(element, parent);
    }

    public InputDate(Component parent) {
        super(new Element(ComponentMapper.getComponentName(InputDate.class)),parent);
    }

    public InputDate() {
        this(null);
    }
    public String getReturnListener (){
        return getAttrValue(AttributeNames.RETURN_LISTENER );
    }
    public void setReturnListener (String value){
        setAttrValue(AttributeNames.RETURN_LISTENER , value);
    }

    public String getAction (){
        return getAttrValue(AttributeNames.ACTION );
    }
    public void setAction (String value){
        setAttrValue(AttributeNames.ACTION , value);
    }

    public String getActionListener (){
        return getAttrValue(AttributeNames.ACTION_LISTENER );
    }
    public void setActionListener (String value){
        setAttrValue(AttributeNames.ACTION_LISTENER , value);
    }

    public String getChooseId (){
        return getAttrValue(AttributeNames.CHOOSE_ID );
    }
    public void setChooseId (String value){
        setAttrValue(AttributeNames.CHOOSE_ID , value);
    }

    public String getTimeZoneList (){
        return getAttrValue(AttributeNames.TIME_ZONE_LIST );
    }
    public void setTimeZoneList (String value){
        setAttrValue(AttributeNames.TIME_ZONE_LIST , value);
    }

    public String getDisabledMonths (){
        return getAttrValue(AttributeNames.DISABLED_MONTHS );
    }
    public void setDisabledMonths (String value){
        setAttrValue(AttributeNames.DISABLED_MONTHS , value);
    }

    public String getDisabledDaysOfWeek (){
        return getAttrValue(AttributeNames.DISABLED_DAYS_OF_WEEK );
    }
    public void setDisabledDaysOfWeek (String value){
        setAttrValue(AttributeNames.DISABLED_DAYS_OF_WEEK , value);
    }

    public String getDisabledDays (){
        return getAttrValue(AttributeNames.DISABLED_DAYS );
    }
    public void setDisabledDays (String value){
        setAttrValue(AttributeNames.DISABLED_DAYS , value);
    }

    public String getMaxValue (){
        return getAttrValue(AttributeNames.MAX_VALUE );
    }
    public void setMaxValue (String value){
        setAttrValue(AttributeNames.MAX_VALUE , value);
    }

    public String getMinValue (){
        return getAttrValue(AttributeNames.MIN_VALUE );
    }
    public void setMinValue (String value){
        setAttrValue(AttributeNames.MIN_VALUE , value);
    }

}
