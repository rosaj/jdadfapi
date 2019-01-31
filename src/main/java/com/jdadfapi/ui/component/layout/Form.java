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
 * Time: 16:56
 */

public class Form extends LayoutComponent {

    public Form(Element element, Component parent) {
        super(element, parent);
    }

    public Form(Component parent) {
        super(new Element(ComponentMapper.getComponentName(Form.class)),parent);
    }

    public Form() {
        this(null);
    }
    public String getDefaultCommand (){
        return getAttrValue(AttributeNames.DEFAULT_COMMAND );
    }
    public void setDefaultCommand (String value){
        setAttrValue(AttributeNames.DEFAULT_COMMAND , value);
    }

    public String getUsesUpload (){
        return getAttrValue(AttributeNames.USES_UPLOAD );
    }
    public void setUsesUpload (String value){
        setAttrValue(AttributeNames.USES_UPLOAD , value);
    }

    public String getTargetFrame (){
        return getAttrValue(AttributeNames.TARGET_FRAME );
    }
    public void setTargetFrame (String value){
        setAttrValue(AttributeNames.TARGET_FRAME , value);
    }




}
