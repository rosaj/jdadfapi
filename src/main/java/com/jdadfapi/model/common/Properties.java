package com.jdadfapi.model.common;

import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Node;
import de.pdark.decentxml.XMLTokenizer;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 03-Dec-17
 * Time: 19:09
 */

public class Properties extends XMLElement {
    protected SchemaBasedProperties schemaBasedProperties;
    protected CustomProperties customProperties;

    public Properties(Element element) {
        super(element);
        loadTree();
    }
    private void loadTree(){
        for(Node n: element.getNodes()){
            if(n.getType().equals(XMLTokenizer.Type.ELEMENT)){
                Element e = (Element)n;
                switch (e.getName()){
                    case TagNames.SCHEMA_BASED_PROPERTIES: resolveSchemaBasedProperties(e);break;
                    case TagNames.CUSTOM_PROPERTIES      : resolveCustomProperties(e);break;
                    default: log(e);
                }
            }
        }
    }
    private void resolveSchemaBasedProperties(Element e){
        schemaBasedProperties = new SchemaBasedProperties(e);
    }
    private void resolveCustomProperties(Element e){
        customProperties = new CustomProperties(e);
    }

    public SchemaBasedProperties getSchemaBasedProperties() {
        return schemaBasedProperties;
    }

    public CustomProperties getCustomProperties() {
        return customProperties;
    }

    protected void ensureCustomProperties(){
        if (customProperties == null) {
//            Element e = new Element(TagNames.CUSTOM_PROPERTIES);
  //          element.addNode(e);
            customProperties = new CustomProperties(addChildElement(TagNames.CUSTOM_PROPERTIES));
        }
    }

    protected void ensureSchemaBP(){
        if(schemaBasedProperties == null){
       //     Element e = new Element(TagNames.SCHEMA_BASED_PROPERTIES);
       //     element.addNode(e);
            schemaBasedProperties = new SchemaBasedProperties(addChildElement(TagNames.SCHEMA_BASED_PROPERTIES));
        }
    }
    /*
    static Properties ensureProperties(Properties properties, Element parent){
        if(properties == null){
            Element e = new Element(TagNames.PROPERTIES);
            int index = 1;
            if(parent.getChildren(TagNames.DESIGN_TIME).isEmpty())index = 0;
            parent.addNode(index,e);

            properties = new Properties(e);
        }
      //  properties.ensureSchemaBP();

        return properties;
    }
    */
    public void setSchemaBasedPropertiesValue(String name, String value){
        ensureSchemaBP();
        schemaBasedProperties.setSBPAttrValue(name,value);
    }
    public String getSchemaBasedPropertiesValue(String name){
        if(schemaBasedProperties == null)return null;
        return schemaBasedProperties.getSBPAttrValue(name);
    }
}
