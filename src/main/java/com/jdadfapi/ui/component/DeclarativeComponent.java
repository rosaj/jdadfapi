package com.jdadfapi.ui.component;

import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Nov-17
 * Time: 12:06
 */

public class DeclarativeComponent extends Component {

    public DeclarativeComponent(Element element, Component parent){
        super(element, parent);
    }
    public DeclarativeComponent(String tagName) {
        super(new Element(tagName),null);
    }
    public DeclarativeComponent(String tagName,Component parent) {
        super(new Element(tagName),parent);
    }
    public String getCustomValue(String name){
        return getAttrValue(name);
    }
    public void setCustomValue(String name, String value){
        setAttrValue(name, value);
    }
}
