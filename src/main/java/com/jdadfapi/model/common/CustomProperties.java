package com.jdadfapi.model.common;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import com.jdadfapi.model.common.Property;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Node;
import de.pdark.decentxml.XMLTokenizer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 17-Jan-18
 * Time: 17:19
 */

public class CustomProperties extends XMLElement {
    private List<Property> translatableProperties = new ArrayList<>();
    private List<Property> nonTranslatableProperties = new ArrayList<>();
    public CustomProperties(Element element) {
        super(element);
        loadTree();
    }
    private void loadTree(){
        for (Node n : element.getNodes()) {
            if (n.getType().equals(XMLTokenizer.Type.ELEMENT)) {
                Element e = (Element) n;
                switch (e.getName()) {
                    case TagNames.PROPERTY     : resolveProperty(e);break;
                    default:log(e);
                }
            }
        }

    }

    private void resolveProperty(Element e) {
        if(e.getAttribute(AttributeNames.RES_ID)!=null) translatableProperties.add(new Property(e,true));
        else nonTranslatableProperties.add(new Property(e,false));
    }


    public List<Property> getNonTranslatableProperties() {
        return nonTranslatableProperties;
    }

    public List<Property> getTranslatableProperties() {
        return translatableProperties;
    }

    public void createTranslatableProperty(String name, String resId) {
        createProperty(name, resId, true);
    }

    public void createNonTranslatableProperty(String name, String value) {
        createProperty(name, value, false);
    }

    private void createProperty(String name, String value, boolean translatable) {
        Property p = new Property(addChildElement(TagNames.PROPERTY),translatable);
        p.setName(name);
        p.setValue(value);

        if(translatable) translatableProperties.add(p);
        else nonTranslatableProperties.add(p);

    }
    public Property getProperty(String name){
        for(Property p : translatableProperties)
            if(p.getName().equals(name)) return p;

        for(Property p : nonTranslatableProperties)
            if(p.getName().equals(name)) return p;
        return null;
    }
}
