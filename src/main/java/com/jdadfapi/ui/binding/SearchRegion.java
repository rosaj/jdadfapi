package com.jdadfapi.ui.binding;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Nov-17
 * Time: 22:59
 */

public class SearchRegion extends XMLElement {
    public SearchRegion(Element element) {
        super(element);
    }


    public String getCriteria (){
        return getAttrValue(AttributeNames.CRITERIA);
    }
    public String getBinds (){
        return getAttrValue(AttributeNames.BINDS);
    }
    public String getCustomizer (){
        return getAttrValue(AttributeNames.CUSTOMIZER);
    }
    public String getInitialQueryOverridden (){
        return getAttrValue(AttributeNames.INITIAL_QUERY_OVERRIDDEN);
    }
    public void setInitialQueryOverridden (String value){
        setAttrValue(AttributeNames.INITIAL_QUERY_OVERRIDDEN ,value);
    }
    public void setCriteria (String value){
        setAttrValue(AttributeNames.CRITERIA ,value);
    }

    public void setCustomizer (String value){
        setAttrValue(AttributeNames.CUSTOMIZER ,value);
    }

    public void setBinds (String value){
        setAttrValue(AttributeNames.BINDS ,value);
    }


    public String getRefreshCondition (){
        return getAttrValue(AttributeNames.REFRESH_CONDITION_UPPER );
    }
    public void setRefreshCondition (String value){
        setAttrValue(AttributeNames.REFRESH_CONDITION_UPPER , value);
    }

    public String getRefreshAfter (){
        return getAttrValue(AttributeNames.REFRESH_AFTER );
    }
    public void setRefreshAfter (String value){
        setAttrValue(AttributeNames.REFRESH_AFTER , value);
    }

    public String getDefaultQuickSearchAttrName (){
        return getAttrValue(AttributeNames.DEFAULT_QUICK_SEARCH_ATTR_NAME );
    }
    public void setDefaultQuickSearchAttrName (String value){
        setAttrValue(AttributeNames.DEFAULT_QUICK_SEARCH_ATTR_NAME , value);
    }

    public String getTrackQueryPerformed (){
        return getAttrValue(AttributeNames.TRACK_QUERY_PERFORMED );
    }
    public void setTrackQueryPerformed (String value){
        setAttrValue(AttributeNames.TRACK_QUERY_PERFORMED , value);
    }


}
