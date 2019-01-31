package com.jdadfapi.ui.taskflow;

import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 14-Nov-17
 * Time: 07:26
 */

public class InputParameterDefinition extends XMLElement {

    //TODO: NAPRAVIT OBJEKTE ?
    private Element name;
    private Element value;
    private Element paramClass;
    private Element required;

    //TODO: Ostali parametri

    public InputParameterDefinition(Element element) {
        super(element);
    }
    public String getName (){
        if(name == null)return null;
        return name.getText();
    }
    public void setName (String value){
        if(name == null){
            name = new Element(TagNames.NAME);
            element.addNode(name);
        }
        name.setText(value);
    }

    public String getValue (){
        if(value == null)return null;
        return value.getText();
    }

    public void setValue (String value){
        if(this.value == null){
            this.value = new Element(TagNames.VALUE);
            if(name==null)  element.addNode(this.value);
            else element.addNode(0, this.value);
        }
        this.value.setText(value);
    }

    public void setRequired (boolean required){
        if(required){
            if(isRequired())return;
            this.required = new Element(TagNames.REQUIRED);
            element.addNode(this.required);
        }
        else{
            if(!isRequired())return;
            this.required.remove();
            this.required = null;
        }

    }
    public boolean isRequired (){
        return required!=null;
    }


    public String getParamClass (){
        if(paramClass==null)return null;
        return paramClass.getText();

    }
    public void setParamClass (String value){
        if(paramClass == null){
            paramClass = new Element(TagNames.CLASS);
            if(isRequired())
                element.addNode(element.nodeIndexOf(element.getChildren(TagNames.REQUIRED).get(0)), paramClass);
            else element.addNode(paramClass);
        }
        paramClass.setText(value);
    }
}
