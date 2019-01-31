package com.jdadfapi.ui.databindings;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 09-Nov-17
 * Time: 20:53
 */

public class BC4JDataControl extends XMLElement {

    public BC4JDataControl(Element element) {
        super(element);
    }

    public String getApplicationName (){
        return getAttrValue(AttributeNames.APPLICATION_NAME );
    }
    public void setApplicationName (String value){
        setAttrValue(AttributeNames.APPLICATION_NAME , value);
    }

    public String getConfiguration (){
        return getAttrValue(AttributeNames.CONFIGURATION );
    }
    public void setConfiguration (String value){
        setAttrValue(AttributeNames.CONFIGURATION , value);
    }

    public String getExceptionMode (){
        return getAttrValue(AttributeNames.EXCEPTION_MODE );
    }
    public void setExceptionMode (String value){
        setAttrValue(AttributeNames.EXCEPTION_MODE , value);
    }

    public String getFactoryClass (){
        return getAttrValue(AttributeNames.FACTORY_CLASS );
    }
    public void setFactoryClass (String value){
        setAttrValue(AttributeNames.FACTORY_CLASS , value);
    }

    public String getPackage (){
        return getAttrValue(AttributeNames.PACKAGE );
    }
    public void setPackage (String value){
        setAttrValue(AttributeNames.PACKAGE , value);
    }

    public String getSupportsFindMode (){
        return getAttrValue(AttributeNames.SUPPORTS_FIND_MODE );
    }
    public void setSupportsFindMode (String value){
        setAttrValue(AttributeNames.SUPPORTS_FIND_MODE , value);
    }

    public String getSupportsRangesize (){
        return getAttrValue(AttributeNames.SUPPORTS_RANGESIZE );
    }
    public void setSupportsRangesize (String value){
        setAttrValue(AttributeNames.SUPPORTS_RANGESIZE , value);
    }

    public String getSupportsResetState (){
        return getAttrValue(AttributeNames.SUPPORTS_RESET_STATE );
    }
    public void setSupportsResetState (String value){
        setAttrValue(AttributeNames.SUPPORTS_RESET_STATE , value);
    }

    public String getSupportsSortCollection (){
        return getAttrValue(AttributeNames.SUPPORTS_SORT_COLLECTION );
    }
    public void setSupportsSortCollection (String value){
        setAttrValue(AttributeNames.SUPPORTS_SORT_COLLECTION , value);
    }

    public String getSupportsTransactions (){
        return getAttrValue(AttributeNames.SUPPORTS_TRANSACTIONS );
    }
    public void setSupportsTransactions (String value){
        setAttrValue(AttributeNames.SUPPORTS_TRANSACTIONS , value);
    }

    public String getSyncMode (){
        return getAttrValue(AttributeNames.SYNC_MODE );
    }
    public void setSyncMode (String value){
        setAttrValue(AttributeNames.SYNC_MODE , value);
    }

    public String getTransactionName (){
        return getAttrValue(AttributeNames.TRANSACTION_NAME );
    }
    public void setTransactionName (String value){
        setAttrValue(AttributeNames.TRANSACTION_NAME , value);
    }

    public String getValidateAtBindings (){
        return getAttrValue(AttributeNames.VALIDATE_AT_BINDINGS );
    }
    public void setValidateAtBindings (String value){
        setAttrValue(AttributeNames.VALIDATE_AT_BINDINGS , value);
    }

    public String getXmlns (){
        return getAttrValue(AttributeNames.XMLNS );
    }
    public void setXmlns (String value){
        setAttrValue(AttributeNames.XMLNS , value);
    }

}
