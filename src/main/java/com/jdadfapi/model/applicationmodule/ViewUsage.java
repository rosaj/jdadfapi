package com.jdadfapi.model.applicationmodule;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 10-Nov-17
 * Time: 21:14
 */

public class ViewUsage extends XMLElement {
    private ApplicationModule applicationModule;
    public ViewUsage(Element element, ApplicationModule am) {
        super(element);
        this.applicationModule = am;
    }

    public String getName (){
        return getAttrValue(AttributeNames.NAME_UPPER );
    }
    public void setName (String value){
        setAttrValue(AttributeNames.NAME_UPPER , value);
    }

    public String getViewObjectName (){
        return getAttrValue(AttributeNames.VIEW_OBJECT_NAME );
    }
    public void setViewObjectName (String value){
        setAttrValue(AttributeNames.VIEW_OBJECT_NAME , value);
    }

    public String getEntityName (){
        return getAttrValue(AttributeNames.ENTITY_NAME );
    }
    public void setEntityName (String value){
        setAttrValue(AttributeNames.ENTITY_NAME , value);
    }

    public String getHidden (){
        return getAttrValue(AttributeNames.HIDDEN );
    }
    public void setHidden (String value){
        setAttrValue(AttributeNames.HIDDEN , value);
    }

    public String getFetchMode (){
        return getAttrValue(AttributeNames.FETCH_MODE );
    }
    public void setFetchMode (String value){
        setAttrValue(AttributeNames.FETCH_MODE , value);
    }

    public String getFetchSize (){
        return getAttrValue(AttributeNames.FETCH_SIZE_UPPER );
    }
    public void setFetchSize (String value){
        setAttrValue(AttributeNames.FETCH_SIZE_UPPER , value);
    }

    public String getMaxFetchSize (){
        return getAttrValue(AttributeNames.MAX_FETCH_SIZE );
    }
    public void setMaxFetchSize (String value){
        setAttrValue(AttributeNames.MAX_FETCH_SIZE , value);
    }

    public String getAccessMode (){
        return getAttrValue(AttributeNames.ACCESS_MODE );
    }
    public void setAccessMode (String value){
        setAttrValue(AttributeNames.ACCESS_MODE , value);
    }

    public String getRangeSize (){
        return getAttrValue(AttributeNames.RANGE_SIZE );
    }
    public void setRangeSize (String value){
        setAttrValue(AttributeNames.RANGE_SIZE , value);
    }

    public String getRangePagingCacheFactor (){
        return getAttrValue(AttributeNames.RANGE_PAGING_CACHE_FACTOR );
    }
    public void setRangePagingCacheFactor (String value){
        setAttrValue(AttributeNames.RANGE_PAGING_CACHE_FACTOR , value);
    }

    public String getQuery (){
        return getAttrValue(AttributeNames.QUERY );
    }
    public void setQuery (String value){
        setAttrValue(AttributeNames.QUERY , value);
    }

    public String getSelectList (){
        return getAttrValue(AttributeNames.SELECT_LIST );
    }
    public void setSelectList (String value){
        setAttrValue(AttributeNames.SELECT_LIST , value);
    }

    public String getFromList (){
        return getAttrValue(AttributeNames.FROM_LIST );
    }
    public void setFromList (String value){
        setAttrValue(AttributeNames.FROM_LIST , value);
    }

    public String getWhere (){
        return getAttrValue(AttributeNames.WHERE );
    }
    public void setWhere (String value){
        setAttrValue(AttributeNames.WHERE , value);
    }

    public String getOrderBy (){
        return getAttrValue(AttributeNames.ORDER_BY );
    }
    public void setOrderBy (String value){
        setAttrValue(AttributeNames.ORDER_BY , value);
    }

    public ApplicationModule getApplicationModule() {
        return applicationModule;
    }

    @Override
    public String toString() {
        return getName();
    }

    public String getViewObjectSimpleName(){
        return getSimple(getViewObjectName());
    }



}
