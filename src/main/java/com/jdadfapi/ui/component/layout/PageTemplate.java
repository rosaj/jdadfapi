package com.jdadfapi.ui.component.layout;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.ui.Page;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 29-Nov-17
 * Time: 19:34
 */

public class PageTemplate extends LayoutComponent {
    public PageTemplate(Element element, Component parent) {
        super(element, parent);
    }

    public PageTemplate(){
        this(null);
    }
    public PageTemplate(Component parent){
        this(new Element(ComponentMapper.getComponentName(PageTemplate.class)),parent);
    }

    public String getAttributeChangeListener (){
        return getAttrValue(AttributeNames.ATTRIBUTE_CHANGE_LISTENER );
    }
    public void setAttributeChangeListener (String value){
        setAttrValue(AttributeNames.ATTRIBUTE_CHANGE_LISTENER , value);
    }

    public String getBinding (){
        return getAttrValue(AttributeNames.BINDING );
    }
    public void setBinding (String value){
        setAttrValue(AttributeNames.BINDING , value);
    }

    public String getPartialTriggers (){
        return getAttrValue(AttributeNames.PARTIAL_TRIGGERS );
    }
    public void setPartialTriggers (String value){
        setAttrValue(AttributeNames.PARTIAL_TRIGGERS , value);
    }

    public String getRendered (){
        return getAttrValue(AttributeNames.RENDERED );
    }
    public void setRendered (String value){
        setAttrValue(AttributeNames.RENDERED , value);
    }

    public String getValue (){
        return getAttrValue(AttributeNames.VALUE );
    }
    public void setValue (String value){
        setAttrValue(AttributeNames.VALUE , value);
    }

    public String getViewId (){
        return getAttrValue(AttributeNames.VIEW_ID );
    }
    public void setViewId (String value){
        setAttrValue(AttributeNames.VIEW_ID , value);
    }

    @Override
    public Facet getOrCreateFacet(String name) {
        return super.getOrCreateFacet(name);
    }
}
