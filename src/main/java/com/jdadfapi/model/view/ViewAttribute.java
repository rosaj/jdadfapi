package com.jdadfapi.model.view;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.model.common.NamedXMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Nov-17
 * Time: 10:31
 */

public class ViewAttribute extends NamedXMLElement {

    public ViewAttribute(Element element) {
        super(element);
    }






    public String getEntityAttrName (){
        return getAttrValue(AttributeNames.ENTITY_ATTR_NAME );
    }
    public void setEntityAttrName (String value){
        setAttrValue(AttributeNames.ENTITY_ATTR_NAME , value);
    }

    public String getEntityUsage (){
        return getAttrValue(AttributeNames.ENTITY_USAGE );
    }
    public void setEntityUsage (String value){
        setAttrValue(AttributeNames.ENTITY_USAGE , value);
    }

    public String getAliasName (){
        return getAttrValue(AttributeNames.ALIAS_NAME );
    }
    public void setAliasName (String value){
        setAttrValue(AttributeNames.ALIAS_NAME , value);
    }


    public String getExpression (){
        return getAttrValue(AttributeNames.EXPRESSION );
    }
    public void setExpression (String value){
        setAttrValue(AttributeNames.EXPRESSION , value);
    }

    public String getLOVName (){
        return getAttrValue(AttributeNames.LOV_NAME );
    }
    public void setLOVName (String value){
        setAttrValue(AttributeNames.LOV_NAME , value);
    }


    public String getIsUnique (){
        return getAttrValue(AttributeNames.IS_UNIQUE );
    }
    public void setIsUnique (String value){
        setAttrValue(AttributeNames.IS_UNIQUE , value);
    }


    public String getEntityDiscrColumn (){
        return getAttrValue(AttributeNames.ENTITY_DISCR_COLUMN );
    }
    public void setEntityDiscrColumn (String value){
        setAttrValue(AttributeNames.ENTITY_DISCR_COLUMN , value);
    }






    public String getPassivate (){
        return getAttrValue(AttributeNames.PASSIVATE );
    }
    public void setPassivate (String value){
        setAttrValue(AttributeNames.PASSIVATE , value);
    }

    public String getSDOHidden (){
        return getAttrValue(AttributeNames.SDO_HIDDEN );
    }
    public void setSDOHidden (String value){
        setAttrValue(AttributeNames.SDO_HIDDEN , value);
    }


    public String getCategory (){
        return getSchemaBPAttr(TagNames.CATEGORY );
    }
    public void setCategory (String value){
        setSchemaBPAttr(TagNames.CATEGORY , value);
    }



    public String getOverrideAttr (){
        return getDesignTimeAttr(AttributeNames._OVERRIDE_ATTR );
    }
    public void setOverrideAttr (String value){
        setDesignTimeAttr(AttributeNames._OVERRIDE_ATTR , value);
    }

}
