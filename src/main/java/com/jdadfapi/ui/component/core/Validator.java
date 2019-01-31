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
 * Date: 08-Nov-17
 * Time: 17:41
 */

public class Validator extends Component {

    public Validator(Element element, Component parent) {
        super(element, parent);
    }

    public Validator(Component parent){
        super(new Element(ComponentMapper.getComponentName(Validator.class)),parent);
    }

    public Validator() {
         this(null);
    }
    public String getBinding (){
        return getAttrValue(AttributeNames.BINDING );
    }
    public void setBinding (String value){
        setAttrValue(AttributeNames.BINDING , value);
    }

    public String getValidatorId (){
        return getAttrValue(AttributeNames.VALIDATOR_ID );
    }
    public void setValidatorId (String value){
        setAttrValue(AttributeNames.VALIDATOR_ID , value);
    }

}
