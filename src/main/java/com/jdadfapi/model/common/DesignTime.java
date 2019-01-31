package com.jdadfapi.model.common;

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
 * Date: 10-Nov-17
 * Time: 14:39
 */

public class DesignTime extends XMLElement {
    List<Attr> attrs = new ArrayList<>();
    List<AttrArray> attrArrays = new ArrayList<>();

    public DesignTime(Element element) {
        super(element);

        for(Element e : element.getChildren(TagNames.ATTR)) attrs.add(new Attr(e));
        for(Element e : element.getChildren(TagNames.ATTR_ARRAY)) attrArrays.add(new AttrArray(e));
    }

    public List<Attr> getAttrs() {
        return attrs;
    }
    public Attr addNewAttr(String name, String value){
      //  Element e = new Element(TagNames.ATTR);
       // element.addNode(e);
        Attr attr = new Attr(addChildElement(TagNames.ATTR));

        attr.setName(name);
        attr.setValue(value);

        attrs.add(attr);
        return attr;
    }
    public Attr getAttr(String name){
        for(Attr attr : attrs){
            if(attr.getName().equals(name))return attr;
        }
        return null;
    }

    public void setDesignAttrValue(String name , String value){
        Attr attr = getAttr(name);
        if(attr == null){
             addNewAttr(name, value);
        } else attr.setValue(value);

    }
    public String getDesignAttrValue(String name){
        Attr attr = getAttr(name);
        if(attr == null)return null;
        return attr.getValue();
    }

    public AttrArray getAttrArray(String name){
        for(AttrArray a : attrArrays){
            if(name.equals(a.getName()))return a;
        }
        return null;
    }
    public AttrArray addAttrArrayItem(String attrArrayName, String value){
        AttrArray attrArray = getAttrArray(attrArrayName);
        if (attrArray == null) {
         //   Element e = new Element(TagNames.ATTR_ARRAY);
            // element.addNode(e);
            attrArray = new AttrArray(addChildElement(TagNames.ATTR_ARRAY));
            attrArray.setName(attrArrayName);
            attrArrays.add(attrArray);
        }
        attrArray.addItem(value);
        return attrArray;
    }
    //TODO: Ostalo ca se tice attrarray
}
