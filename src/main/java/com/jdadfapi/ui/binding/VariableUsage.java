package com.jdadfapi.ui.binding;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 01-Oct-18
 * Time: 14:59
 */

public class VariableUsage extends XMLElement{
    public VariableUsage(Element element) {
        super(element);
    }

    public String getDataControl (){
        return getAttrValue(AttributeNames.DATA_CONTROL );
    }
    public void setDataControl (String value){
        setAttrValue(AttributeNames.DATA_CONTROL , value);
    }

    public String getBinds (){
        return getAttrValue(AttributeNames.BINDS );
    }
    public void setBinds (String value){
        setAttrValue(AttributeNames.BINDS , value);
    }

    public String getName(){
        return getAttrValue(AttributeNames.NAME_UPPER );
    }
    public void setName (String value){
        setAttrValue(AttributeNames.NAME_UPPER , value);
    }

    public String getIsQueriable (){
        return getAttrValue(AttributeNames.IS_QUERIABLE );
    }
    public void setIsQueriable (String value){
        setAttrValue(AttributeNames.IS_QUERIABLE , value);
    }

    public String getDefaultValue (){
        return getAttrValue(AttributeNames.DEFAULT_VALUE );
    }
    public void setDefaultValue (String value){
        setAttrValue(AttributeNames.DEFAULT_VALUE , value);
    }

    public String getAttrLoad (){
        return getAttrValue(AttributeNames.ATTR_LOAD );
    }
    public void setAttrLoad (String value){
        setAttrValue(AttributeNames.ATTR_LOAD , value);
    }

    public String getDiscrColumn (){
        return getAttrValue(AttributeNames.DISCR_COLUMN );
    }
    public void setDiscrColumn (String value){
        setAttrValue(AttributeNames.DISCR_COLUMN , value);
    }

    public String getIsNotNull (){
        return getAttrValue(AttributeNames.IS_NOT_NULL );
    }
    public void setIsNotNull (String value){
        setAttrValue(AttributeNames.IS_NOT_NULL , value);
    }

    public String getIsPersistent (){
        return getAttrValue(AttributeNames.IS_PERSISTENT );
    }
    public void setIsPersistent (String value){
        setAttrValue(AttributeNames.IS_PERSISTENT , value);
    }

    public String getIsUnique (){
        return getAttrValue(AttributeNames.IS_UNIQUE );
    }
    public void setIsUnique (String value){
        setAttrValue(AttributeNames.IS_UNIQUE , value);
    }

    public String getIsUpdateable (){
        return getAttrValue(AttributeNames.IS_UPDATEABLE );
    }
    public void setIsUpdateable (String value){
        setAttrValue(AttributeNames.IS_UPDATEABLE , value);
    }

    public String getIsVisible (){
        return getAttrValue(AttributeNames.IS_VISIBLE );
    }
    public void setIsVisible (String value){
        setAttrValue(AttributeNames.IS_VISIBLE , value);
    }

    public String getPrecision (){
        return getAttrValue(AttributeNames.PRECISION );
    }
    public void setPrecision (String value){
        setAttrValue(AttributeNames.PRECISION , value);
    }

    public String getPrecisionRule (){
        return getAttrValue(AttributeNames.PRECISION_RULE );
    }
    public void setPrecisionRule (String value){
        setAttrValue(AttributeNames.PRECISION_RULE , value);
    }

    public String getPrimaryKey (){
        return getAttrValue(AttributeNames.PRIMARY_KEY );
    }
    public void setPrimaryKey (String value){
        setAttrValue(AttributeNames.PRIMARY_KEY , value);
    }

    public String getScale (){
        return getAttrValue(AttributeNames.SCALE );
    }
    public void setScale (String value){
        setAttrValue(AttributeNames.SCALE , value);
    }

    public String getSourceName (){
        return getAttrValue(AttributeNames.SOURCE_NAME );
    }
    public void setSourceName (String value){
        setAttrValue(AttributeNames.SOURCE_NAME , value);
    }

    public String getSourceType (){
        return getAttrValue(AttributeNames.SOURCE_TYPE );
    }
    public void setSourceType (String value){
        setAttrValue(AttributeNames.SOURCE_TYPE , value);
    }
}
