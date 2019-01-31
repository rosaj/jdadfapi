package com.jdadfapi.ui.component.layout;

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
 * Date: 05-Nov-17
 * Time: 12:32
 */

public class Facet extends Component {
    public Facet(Element element, Component parent) {
        super(element, parent);
    }

    public Facet(Component parent) {
        super(new Element(ComponentMapper.getComponentName(Facet.class)),parent);
    }

    public Facet() {
        this(null);
    }
    public String getName(){
        return getAttrValue(AttributeNames.NAME);
    }
    public void setName(String  value){
        setAttrValue(AttributeNames.NAME,value);
    }
}
