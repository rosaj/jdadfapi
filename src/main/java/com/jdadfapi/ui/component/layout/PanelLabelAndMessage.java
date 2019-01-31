package com.jdadfapi.ui.component.layout;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Dec-17
 * Time: 08:11
 */

public class PanelLabelAndMessage extends LayoutComponent {
    public PanelLabelAndMessage(Element element, Component parent) {
        super(element, parent);
    }
    public PanelLabelAndMessage(Component parent){
        this(new Element(ComponentMapper.getComponentName(PanelLabelAndMessage.class)),parent);
    }
    public PanelLabelAndMessage(){
        this(null);
    }


    public String getLabel(){
        return getAttrValue(AttributeNames.LABEL);
    }

    public void setLabel(String value){
        setAttrValue(AttributeNames.LABEL,value);
    }
    public String getShowRequired (){
        return getAttrValue(AttributeNames.SHOW_REQUIRED );
    }
    public void setShowRequired (String value){
        setAttrValue(AttributeNames.SHOW_REQUIRED , value);
    }

    //TODO: OSTALI PROPERTIES

}
