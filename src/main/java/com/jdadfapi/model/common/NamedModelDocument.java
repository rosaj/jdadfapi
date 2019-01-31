package com.jdadfapi.model.common;

import com.jdadfapi.TagNames;
import com.jdadfapi.model.Model;
import de.pdark.decentxml.Document;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Node;
import de.pdark.decentxml.XMLTokenizer;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 10-Nov-17
 * Time: 07:44
 */

public class NamedModelDocument extends ModelDocument {
    protected DesignTime designTime;
    protected Properties properties;
    protected ResourceBundle resourceBundle;
//    protected ResourceBundle
    public NamedModelDocument(Document document, String path, Model model) {
        super(document, path, model);
        loadTree();
    }

    private void loadTree(){
        for(Node n: element.getNodes()){
            if(n.getType().equals(XMLTokenizer.Type.ELEMENT)){
                Element e = (Element)n;
                switch (e.getName()){
                    case TagNames.DESIGN_TIME : resolveDesignTime(e);break;
                    case TagNames.PROPERTIES  : resolveProperties(e);break;
                    case TagNames.RESOURCE_BUNDLE:resolveResourceBundle(e);break;
                    default: log(e);
                }
            }
        }
    }

    protected void resolveProperties(Element e){
        properties = new Properties(e);
    }
    protected void resolveDesignTime(Element e){
        designTime = new DesignTime(e);

    }
    protected void resolveResourceBundle(Element e){
        resourceBundle = new ResourceBundle(e);
    }

    public boolean hasDesignTime(){
        return designTime != null;
    }
    public boolean hasProperties(){
        return properties != null;
    }

    protected void setDesignTimeAttr(String name, String value){
        if(designTime == null){
   //         Element e = new Element(TagNames.DESIGN_TIME);
 //           element.addNode(0,e);
            designTime = new DesignTime(addChildElement(TagNames.DESIGN_TIME));
        }
        designTime.setDesignAttrValue(name,value);
    }
    protected String getDesignTimeAttr(String name){
        if(designTime == null)return null;
        return designTime.getDesignAttrValue(name);
    }

    protected void setSBPValue(String name, String value){
      //  properties = Properties.ensureProperties(properties, element);
        ensureProperties().setSchemaBasedPropertiesValue(name, value);
    }
    protected String getSBPValue(String name){
        if(properties == null)return null;
        if(properties.getSchemaBasedProperties() == null)return null;
        return properties.getSchemaBasedPropertiesValue(name);
    }

    public Property getCustomProperty(String name) {
        if(properties == null)return null;
        if(properties.getCustomProperties()==null)return null;
        return properties.getCustomProperties().getProperty(name);
    }

    public void setTranslatableProperty(String name, String value) {
        //properties = Properties.ensureProperties(properties, element);
        ensureProperties().ensureCustomProperties();
        Property property = getCustomProperty(name);
        if(property==null) properties.getCustomProperties().createTranslatableProperty(name, value);
        else property.setValue(value);
    }

    public void setNonTranslatableProperty(String name, String value) {
        //properties = Properties.ensureProperties(properties, element);
        ensureProperties().ensureCustomProperties();
        Property property = getCustomProperty(name);
        if(property==null) properties.getCustomProperties().createNonTranslatableProperty(name, value);
        else property.setValue(value);
    }

    public void setResourceBundle(String value){
        if(resourceBundle == null){
 //           Element e = new Element(TagNames.RESOURCE_BUNDLE);
   //         element.addNode(e);
            resolveResourceBundle(addChildElement(TagNames.RESOURCE_BUNDLE));
        }
        resourceBundle.setPropertiesBundle(value);
    }
    public String getResourceBundle(){
        if(resourceBundle == null)return null;
        return resourceBundle.getPropertiesBundle();
    }


    public void setLabel(String value){
        setSBPValue(TagNames.LABEL,value);
    }
    public String getLabel(){
        return getSBPValue(TagNames.LABEL);
    }

    Properties ensureProperties(){
        if (properties == null) {
            int index = hasDesignTime() ? 1 : 0;
            properties = new Properties(addChildElement(index, TagNames.PROPERTIES));
        }
        return properties;
    }
}
