package com.jdadfapi.ui.binding;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 09-Nov-17
 * Time: 01:09
 */

public class AttributeValues extends AttributeValue {
    private AttrNames attrNames;

    public AttributeValues(Element element) {
        super(element);
        List<Element> elements = element.getChildren(TagNames.ATTR_NAMES);
        if(!elements.isEmpty()) attrNames = new AttrNames(elements.get(0));
    }

    public String getIterBinding(){
        return getAttrValue(AttributeNames.ITER_BINDING);
    }
    public void setIterBinding(String value){
        setAttrValue(AttributeNames.ITER_BINDING, value);
    }

    public AttrNames createAttrNames(){
        if(attrNames!=null)return attrNames;
        attrNames = new AttrNames(addChildElement(TagNames.ATTR_NAMES));
        return attrNames;
    }

    public AttrNames getAttrNames() {
        return attrNames;
    }
}
