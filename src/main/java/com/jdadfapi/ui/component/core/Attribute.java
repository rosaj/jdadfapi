package com.jdadfapi.ui.component.core;

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
 * Time: 09:08
 */

public class Attribute extends Component {
    public Attribute(Element element, Component parent) {
        super(element, parent);
    }

    public Attribute(Component parent) {
        super(new Element(ComponentMapper.getComponentName(Attribute.class)),parent);
    }

    public Attribute() {
        this(null);
    }



    private void reportNoChildren(){
        throw new RuntimeException("Attribute cannot have any children.");
    }

    @Override
    public void addChild(Component child) {
        reportNoChildren();
    }

    @Override
    public void addChild(int index, Component child) {
        reportNoChildren();
    }

    @Override
    protected Element addChildElement(String tag) {
        reportNoChildren();
        return null;
    }

    @Override
    protected Element addChildElement(int index, String tag) {
        reportNoChildren();
        return null;
    }

    public void setName(String value){
        setAttrValue(AttributeNames.NAME, value);
    }
    public String getName(){
        return getAttrValue(AttributeNames.NAME);
    }


    public void setValue(String value){
        setAttrValue(AttributeNames.VALUE, value);
    }
    public String getValue(){
        return getAttrValue(AttributeNames.VALUE);
    }



}
