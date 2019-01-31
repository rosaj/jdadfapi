package com.jdadfapi.ui.component.core;

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
 * Time: 18:33
 */

public class View extends Component {

    public View(Element element, Component parent) {
        super(element, parent);
    }

    public View(Component parent) {
        super(new Element(ComponentMapper.getComponentName(View.class)),parent);
    }

    public View() {
        this(null);
    }

    public String getLocale (){
        return getAttrValue(AttributeNames.LOCALE );
    }
    public String getRenderKidId (){
        return getAttrValue(AttributeNames.RENDER_KID_ID );
    }
    public String getAfterPhase (){
        return getAttrValue(AttributeNames.AFTER_PHASE );
    }
    public String getBeforePhase (){
        return getAttrValue(AttributeNames.BEFORE_PHASE );
    }

    public void setLocale (String value){
        setAttrValue(AttributeNames.LOCALE ,value);
    }
    public void setRenderKidId (String value){
        setAttrValue(AttributeNames.RENDER_KID_ID ,value);
    }
    public void setAfterPhase (String value){
        setAttrValue(AttributeNames.AFTER_PHASE ,value);
    }
    public void setBeforePhase (String value){
        setAttrValue(AttributeNames.BEFORE_PHASE ,value);
    }

    public void getXmlnsF (String value){
       getAttrValue(AttributeNames.XMLNS_F );
    }
    public void setXmlnsF (String value){
        setAttrValue(AttributeNames.XMLNS_F ,value);
    }

    public void getXmlnsAf (String value){
        getAttrValue(AttributeNames.AFTER_PHASE );
    }
    public void setXmlnsAf (String value){
        setAttrValue(AttributeNames.XMLNS_AF ,value);
    }
    public void setXmlns(String tag, String value) {
        setAttrValue("xmlns:"+tag,value);
    }
    public String getXmlns(String tag){
        return getAttrValue("xmlns:"+tag);
    }
}
