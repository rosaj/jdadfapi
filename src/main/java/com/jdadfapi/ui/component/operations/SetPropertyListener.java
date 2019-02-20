package com.jdadfapi.ui.component.operations;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 20-Feb-19
 * Time: 10:09
 */

public class SetPropertyListener extends Component {
    public SetPropertyListener(Element element, Component parent) {
        super(element, parent);
    }


    public SetPropertyListener() {
        this(null);
    }

    public SetPropertyListener(Component parent) {
        super(new Element(ComponentMapper.getComponentName(SetPropertyListener.class)), parent);
    }


    public String getType(){
        return getAttrValue(AttributeNames.TYPE);
    }
    public void setType(String value){
        setAttrValue(AttributeNames.TYPE, value);
    }



    public String getFrom(){
        return getAttrValue(AttributeNames.FROM);
    }
    public void setFrom(String value){
        setAttrValue(AttributeNames.FROM, value);
    }



    public String getTo(){
        return getAttrValue(AttributeNames.TO);
    }
    public void setTo(String value){
        setAttrValue(AttributeNames.TO, value);
    }

}
