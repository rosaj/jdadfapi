package com.jdadfapi.model.entity;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.model.Model;
import com.jdadfapi.model.common.NamedModelDocument;
import de.pdark.decentxml.Document;
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
 * Date: 06-Nov-17
 * Time: 11:08
 */

public class Entity extends NamedModelDocument {

    List<Attribute> attributes = new ArrayList<>();
    List<AccessorAttribute> accessorAttributes = new ArrayList<>();
    List<Key> keys = new ArrayList<>();
    List<UniqueKeyValidationBean> uniqueKeyValidations = new ArrayList<>();

    public Entity(Document document, String path, Model model) {
        super(document, path,model);
        loadTree();
    }


    private void loadTree(){
        for(Node n: document.getRootElement().getNodes()){
            if(n.getType().equals(XMLTokenizer.Type.ELEMENT)){
                Element e = (Element)n;
                switch (e.getName()){
                    case TagNames.ATTRIBUTE     :resolveAttribute(e);break;
                    case TagNames.Key           :resolveKey(e);break;
                    case TagNames.UNIQUE_KEY_VALIDATION_BEAN:resolveUniqueKeyValidation(e);break;
                    case TagNames.ACCESSOR_ATTRIBUTE:resolveAccessorAttribute(e);break;
                    //TODO: Ostatak
                    default: log(e);
                }
            }
        }
    }
    private void resolveAttribute(Element e){
        attributes.add(new Attribute(e,this));
    }
    private void resolveKey(Element e){
        keys.add(new Key(e));
    }
    private void resolveUniqueKeyValidation(Element e){

        uniqueKeyValidations.add(new UniqueKeyValidationBean(e));
    }

    private void resolveAccessorAttribute(Element e) {
        accessorAttributes.add(new AccessorAttribute(e));
    }
    public List<Attribute> getAttributes() {
        return attributes;
    }

    public List<AccessorAttribute> getAccessorAttributes() {
        return accessorAttributes;
    }

    public List<Key> getKeys() {
        return keys;
    }

    public List<UniqueKeyValidationBean> getUniqueKeyValidations() {
        return uniqueKeyValidations;
    }

    public Attribute getAttribute(String name){
        for(Attribute attribute : attributes){
            if(attribute.getName().equals(name))return attribute;
        }
        return null;
    }

    public AccessorAttribute getAccessorAttribute(String name){
        for(AccessorAttribute at : accessorAttributes){
            if(name.equals(at.getName()))return at;
        }
        return null;
    }

    public Key getKey(String name){
        for(Key key : keys){
            if(key.getName().equals(name))return key;
        }
        return null;
    }
    public UniqueKeyValidationBean getUniqueKeyValidation(String name){
        for(UniqueKeyValidationBean uniqueKeyValidationBean : uniqueKeyValidations){
            if(uniqueKeyValidationBean.getName().equals(name))return uniqueKeyValidationBean;
        }
        return null;
    }

    public String getDBObjectName(){
        return getAttrValue(AttributeNames.DB_OBJECT_NAME);
    }
    public void setDBObjectName(String value){
        setAttrValue(AttributeNames.DB_OBJECT_NAME,value);
    }

}
