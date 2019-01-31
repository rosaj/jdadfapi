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
 * Date: 08-Nov-17
 * Time: 07:29
 */

public class PanelGroupLayout extends LayoutComponent {
    public PanelGroupLayout(Element element, Component parent) {
        super(element, parent);
    }

    public PanelGroupLayout(Component parent) {
        super(new Element(ComponentMapper.getComponentName(PanelGroupLayout.class)),parent);
    }

    public PanelGroupLayout() {
        this(null);
    }
    public String getHalign (){
        return getAttrValue(AttributeNames.HALIGN );
    }
    public void setHalign (String value){
        setAttrValue(AttributeNames.HALIGN , value);
    }

    public String getValign (){
        return getAttrValue(AttributeNames.VALIGN );
    }
    public void setValign (String value){
        setAttrValue(AttributeNames.VALIGN , value);
    }

    public String getLayout (){
        return getAttrValue(AttributeNames.LAYOUT );
    }
    public void setLayout (String value){
        setAttrValue(AttributeNames.LAYOUT , value);
    }

    public String getLandmark (){
        return getAttrValue(AttributeNames.LANDMARK );
    }
    public void setLandmark (String value){
        setAttrValue(AttributeNames.LANDMARK , value);
    }

}
