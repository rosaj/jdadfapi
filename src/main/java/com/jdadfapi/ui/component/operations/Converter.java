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
 * Date: 15-Nov-17
 * Time: 15:26
 */

public class Converter extends Component {

    public Converter(){
        this(null);
    }

    public Converter (Component parent){
        super(new Element(ComponentMapper.getComponentName(Converter.class)), parent);
    }


    public Converter(Element element, Component parent) {
        super(element, parent);
    }

    public String getType(){
        return getAttrValue(AttributeNames.TYPE);
    }
    public void setType(String value){
        setAttrValue(AttributeNames.TYPE, value);
    }
}
