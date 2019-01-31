package com.jdadfapi.model.common;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 03-Dec-17
 * Time: 19:09
 */

public class SchemaBasedProperties extends XMLElement {
    private static List<String> TEXT_TAGS = new ArrayList<>();
    static {
        TEXT_TAGS.add(TagNames.LABEL);
        TEXT_TAGS.add(TagNames.LABEL_PLURAL);
        TEXT_TAGS.add(TagNames.TOOLTIP);
        TEXT_TAGS.add(TagNames.FMT_FORMATTER);
        TEXT_TAGS.add(TagNames.FMT_FORMAT);
    }


    public SchemaBasedProperties(Element element) {
        super(element);
    }

    public void setSBPAttrValue(String name, String value){
        if(value == null){
            XMLElement el = getElement(name,false);
            if(el==null)return;
            el.remove();
            return;
        }
        getElement(name, true).setAttrValue(getAttrName(name), value);
    }
    public String getSBPAttrValue(String name){
        XMLElement e = getElement(name, false);
        if(e == null)return null;
        return e.getAttrValue(getAttrName(name));

    }

    private XMLElement getElement(String name, boolean init){
        List<Element> values = element.getChildren(name);
        if(values.isEmpty()){
            if(init){
                /*
                Element e = new Element(name);
                element.addNode(e);
                return e;*/
                return new XMLElement(addChildElement(name));
            }
            return null;
        }
        return  new XMLElement(values.get(0));
    }

    protected String getAttrName(String name){
        String attrName = AttributeNames.VALUE_UPPER;
        if(TEXT_TAGS.contains(name)) attrName = AttributeNames.RES_ID;
        else if(TagNames.PROPERTIES_BUNDLE.equals(name))attrName = AttributeNames.PPROPERTIES_FILE;
        return attrName;
    }
}
