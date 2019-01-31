package com.jdadfapi.ui.component;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Attribute;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Node;
import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Nov-17
 * Time: 08:42
 */

public class UIComponent extends Component{



    public UIComponent(Element element,Component parent) {
        super(element,parent);

    }

    public UIComponent(Component parent) {
        this(new Element(ComponentMapper.getComponentName(UIComponent.class)), parent);
    }

    public UIComponent() {
        this(null);
    }


    public String getShortDesc(){
        return getAttrValue(AttributeNames.SHORT_DESC);
    }

    public String getRequired(){
        return getAttrValue(AttributeNames.REQUIRED);
    }
    public String getValue(){
        return getAttrValue(AttributeNames.VALUE);
    }

    public String getPartialTriggers(){
        return getAttrValue(AttributeNames.PARTIAL_TRIGGERS);
    }
    public String getReadOnly(){
        return getAttrValue(AttributeNames.READ_ONLY);
    }
    public String getVisible(){
        return getAttrValue(AttributeNames.VISIBLE);
    }
    public String getStyleClass(){
        return getAttrValue(AttributeNames.STYLE_CLASS);
    }
    public String getInlineStyle(){
        return getAttrValue(AttributeNames.INLINE_STYLE);
    }
    public String getBinding(){
        return getAttrValue(AttributeNames.BINDING);
    }
    public String getRendered(){
        return getAttrValue(AttributeNames.RENDERED);
    }
    public String getClientComponent(){
        return getAttrValue(AttributeNames.CLIENT_COMPONENT);
    }
    public String getAttributeChangeListener(){
        return getAttrValue(AttributeNames.ATTRIBUTE_CHANGE_LISTENER);
    }
    public String getDisabled (){
        return getAttrValue(AttributeNames.DISABLED );
    }


    public void setShortDesc(String value){
        setAttrValue(AttributeNames.SHORT_DESC,value);
    }
    public void setRequired(String value){
        setAttrValue(AttributeNames.REQUIRED,value);
    }
    public void setValue(String value){
        setAttrValue(AttributeNames.VALUE,value);
    }
    public void setPartialTriggers(String value){
        setAttrValue(AttributeNames.PARTIAL_TRIGGERS,value);
    }
    public void setReadOnly(String value){
         setAttrValue(AttributeNames.READ_ONLY,value);
    }
    public void setVisible(String value){
        setAttrValue(AttributeNames.VISIBLE,value);
    }
    public void setStyleClass(String value){
        setAttrValue(AttributeNames.STYLE_CLASS,value);
    }
    public void setInlineStyle(String value){
        setAttrValue(AttributeNames.INLINE_STYLE,value);
    }
    public void setBinding(String value){
        setAttrValue(AttributeNames.BINDING,value);
    }
    public void setRendered(String value){
        setAttrValue(AttributeNames.RENDERED,value);
    }
    public void setClientComponent(String value){
        setAttrValue(AttributeNames.CLIENT_COMPONENT,value);
    }
    public void setAttributeChangeListener(String value){
        setAttrValue(AttributeNames.ATTRIBUTE_CHANGE_LISTENER,value);
    }
    public void setDisabled (String value){
        setAttrValue(AttributeNames.DISABLED , value);
    }

    public String getUnsecure (){
        return getAttrValue(AttributeNames.UNSECURE );
    }
    public void setUnsecure (String value){
        setAttrValue(AttributeNames.UNSECURE , value);
    }

    public String getAttributeValue(String name){
        return getAttrValue(name);
    }
    public void setAttributeValue(String name,String value){
        setAttrValue(name,value);
    }



    /*
    public String get (){
        return getAttrValue(AttributeNames. );
    }

    public void set (String value){
        setAttrValue(AttributeNames. , value);
    }

    */
}
