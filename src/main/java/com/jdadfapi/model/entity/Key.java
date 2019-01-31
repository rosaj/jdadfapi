package com.jdadfapi.model.entity;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.model.common.AttrArray;
import com.jdadfapi.model.common.DesignTimeXMLElement;
import de.pdark.decentxml.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 31-Jan-18
 * Time: 10:54
 */

public class Key extends DesignTimeXMLElement {

    List<AttrArray> attrArray = new ArrayList<>();
    public Key(Element element) {
        super(element);

    }
    public String getName (){
        return getAttrValue(AttributeNames.NAME_UPPER );
    }
    public void setName (String value){
        setAttrValue(AttributeNames.NAME_UPPER , value);
    }

    public String getAltKey (){
        return getAttrValue(AttributeNames.ALT_KEY );
    }
    public void setAltKey (String value){
        setAttrValue(AttributeNames.ALT_KEY , value);
    }

    public String getPrimaryKey (){
        return getAttrValue(AttributeNames.PRIMARY_KEY );
    }
    public void setPrimaryKey (String value){
        setAttrValue(AttributeNames.PRIMARY_KEY , value);
    }
    public String getIsUnique (){
        return getDesignTimeAttr(AttributeNames._IS_UNIQUE );
    }
    public void setIsUnique (String value){
        setDesignTimeAttr(AttributeNames._IS_UNIQUE , value);
    }

    public String getDBObjectName (){
        return getDesignTimeAttr(AttributeNames._DB_OBJECT_NAME );
    }
    public void setDBObjectName (String value){
        setDesignTimeAttr(AttributeNames._DB_OBJECT_NAME , value);
    }

    public AttrArray getAttributes (){
        return getAttrArray(AttributeNames.ATTRIBUTES );
    }

    //TODO: ODVOJIT U POSEBNAN ITERFACE DA JE KOD NA JEDNIN MESTU
    private AttrArray getAttrArray(String name){
        for(AttrArray a : attrArray){
            if(a.getName().equals(name))return a;
        }
        return null;
    }
}
