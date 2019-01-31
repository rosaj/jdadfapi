package com.jdadfapi.model.entity;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 19-Jun-18
 * Time: 10:27
 */

public class AccessorAttribute extends XMLElement {
    public AccessorAttribute(Element element) {
        super(element);
    }

    public String getName (){
        return getAttrValue(AttributeNames.NAME_UPPER );
    }
    public void setName (String value){
        setAttrValue(AttributeNames.NAME_UPPER , value);
    }

    public String getAssociation (){
        return getAttrValue(AttributeNames.ASSOCIATION );
    }
    public void setAssociation (String value){
        setAttrValue(AttributeNames.ASSOCIATION , value);
    }

    public String getAssociationEnd (){
        return getAttrValue(AttributeNames.ASSOCIATION_END );
    }
    public void setAssociationEnd (String value){
        setAttrValue(AttributeNames.ASSOCIATION_END , value);
    }

    public String getAssociationOtherEnd (){
        return getAttrValue(AttributeNames.ASSOCIATION_OTHER_END );
    }
    public void setAssociationOtherEnd (String value){
        setAttrValue(AttributeNames.ASSOCIATION_OTHER_END , value);
    }

    public String getType (){
        return getAttrValue(AttributeNames.TYPE_UPPER );
    }
    public void setType (String value){
        setAttrValue(AttributeNames.TYPE_UPPER , value);
    }

    public String getIsUpdateable (){
        return getAttrValue(AttributeNames.IS_UPDATEABLE );
    }
    public void setIsUpdateable (String value){
        setAttrValue(AttributeNames.IS_UPDATEABLE , value);
    }
}
