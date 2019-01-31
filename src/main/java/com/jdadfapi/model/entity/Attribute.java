package com.jdadfapi.model.entity;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.model.common.NamedXMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 03-Dec-17
 * Time: 20:26
 */

public class Attribute extends NamedXMLElement {
    private Entity entity;
    public Attribute(Element element, Entity entity) {
        super(element);
        this.entity = entity;
    }


    public Entity getEntity() {
        return entity;
    }

    public String getIsEffectiveDateSequenceFlag (){
        return getAttrValue(AttributeNames.IS_EFFECTIVE_DATE_SEQUENCE_FLAG );
    }
    public void setIsEffectiveDateSequenceFlag (String value){
        setAttrValue(AttributeNames.IS_EFFECTIVE_DATE_SEQUENCE_FLAG , value);
    }

    public String getIsEffectiveDateSequence (){
        return getAttrValue(AttributeNames.IS_EFFECTIVE_DATE_SEQUENCE );
    }
    public void setIsEffectiveDateSequence (String value){
        setAttrValue(AttributeNames.IS_EFFECTIVE_DATE_SEQUENCE , value);
    }

    public String getPrimaryKey (){
        return getAttrValue(AttributeNames.PRIMARY_KEY );
    }
    public void setPrimaryKey (String value){
        setAttrValue(AttributeNames.PRIMARY_KEY , value);
    }

    public void setDomain(String value){
        setAttrValue(AttributeNames.DOMAIN, value);
    }
    public String getDomain(){
        return getAttrValue(AttributeNames.DOMAIN);
    }

    public String getRetrievedOnUpdate (){
        return getAttrValue(AttributeNames.RETRIEVED_ON_UPDATE );
    }
    public void setRetrievedOnUpdate (String value){
        setAttrValue(AttributeNames.RETRIEVED_ON_UPDATE , value);
    }

    public String getRetrievedOnInsert (){
        return getAttrValue(AttributeNames.RETRIEVED_ON_INSERT );
    }
    public void setRetrievedOnInsert (String value){
        setAttrValue(AttributeNames.RETRIEVED_ON_INSERT , value);
    }

    public String getChangeIndicator (){
        return getAttrValue(AttributeNames.CHANGE_INDICATOR );
    }
    public void setChangeIndicator (String value){
        setAttrValue(AttributeNames.CHANGE_INDICATOR , value);
    }

    public String getHistoryColumn (){
        return getAttrValue(AttributeNames.HISTORY_COLUMN );
    }
    public void setHistoryColumn (String value){
        setAttrValue(AttributeNames.HISTORY_COLUMN , value);
    }

    public String getIsUnique (){
        return getAttrValue(AttributeNames.IS_UNIQUE );
    }
    public void setIsUnique (String value){
        setAttrValue(AttributeNames.IS_UNIQUE , value);
    }
    public String getTableName (){
        return getAttrValue(AttributeNames.TABLE_NAME );
    }
    public void setTableName (String value){
        setAttrValue(AttributeNames.TABLE_NAME, value);
    }

    public String getDisplayAsAttribute (){
        return getSchemaBPAttr(TagNames.DISPLAY_AS_ATTRIBUTE );
    }
    public void setDisplayAsAttribute (String value){
        setSchemaBPAttr(TagNames.DISPLAY_AS_ATTRIBUTE , value);
    }

    public void setDisplaySize(String value){
        setDesignTimeAttr(AttributeNames._DISPLAY_SIZE,value);
    }
    public String getDisplaySize(){
        return getDesignTimeAttr(AttributeNames._DISPLAY_SIZE);
    }

    public String getColumnName(){
        return getAttrValue(AttributeNames.COLUMN_NAME);
    }
    public void setColumnName(String value){
        setAttrValue(AttributeNames.COLUMN_NAME, value);
    }



}
