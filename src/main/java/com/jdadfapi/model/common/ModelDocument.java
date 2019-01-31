package com.jdadfapi.model.common;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLDocument;
import com.jdadfapi.model.Model;
import de.pdark.decentxml.Document;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 10-Nov-17
 * Time: 07:33
 */

public class ModelDocument extends XMLDocument {
    private Model model;
    public ModelDocument(Document document, String path, Model model) {
        super(document, path);
        this.model = model;
    }

    public String getName(){
        return getAttrValue(AttributeNames.NAME_UPPER);
    }
    public void setName(String value){
        setAttrValue(AttributeNames.NAME_UPPER,value);
    }
    public String getVersion (){
        return getAttrValue(AttributeNames.VERSION_UPPER );
    }
    public void setVersion (String value){
        setAttrValue(AttributeNames.VERSION_UPPER , value);
    }

    public String getXmlns (){
        return getAttrValue(AttributeNames.XMLNS );
    }
    public void setXmlns (String value){
        setAttrValue(AttributeNames.XMLNS , value);
    }

    public String getInheritPersonalization (){
        return getAttrValue(AttributeNames.INHERIT_PERSONALIZATION );
    }
    public void setInheritPersonalization (String value){
        setAttrValue(AttributeNames.INHERIT_PERSONALIZATION , value);
    }

    public String getPackage(){
        String packageName = path.substring(path.indexOf("\\src\\")+5).replace("\\",".");
        packageName = packageName.substring(0,packageName.indexOf(getName())-1);
        return packageName;
    }

    public String getPackagedName(){
        String pack = getPackage();
        if(pack == null || pack.trim().isEmpty()) pack = getName();
        else pack += "." + getName();
        return pack;
    }
    public Model getModel() {
        return model;
    }

    @Override
    public String toString() {
        return getName();
    }
}
