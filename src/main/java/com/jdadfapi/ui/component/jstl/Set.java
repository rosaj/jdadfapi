package com.jdadfapi.ui.component.jstl;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import com.jdadfapi.ui.component.core.View;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 29-Nov-17
 * Time: 15:35
 */

public class Set extends Component {
    public Set(Element element, Component parent) {
        super(element, parent);
    }
    public Set(){
        this(null);

    }
    public Set(Component parent){
            this(new Element(ComponentMapper.getComponentName(Set.class)),parent);
    }
    public String getVar (){
        return getAttrValue(AttributeNames.VAR );
    }
    public void setVar (String value){
        setAttrValue(AttributeNames.VAR , value);
    }

    public String getValue (){
        return getAttrValue(AttributeNames.VALUE );
    }
    public void setValue (String value){
        setAttrValue(AttributeNames.VALUE , value);
    }

}
