package com.jdadfapi.ui.component.operations;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 09-Nov-17
 * Time: 18:41
 */

public class ConvertNumber extends Converter {

    public ConvertNumber(Element element, Component parent) {
        super(element, parent);
    }

    public ConvertNumber() {
        this(null);
    }

    public ConvertNumber(Component parent) {
        super(new Element(ComponentMapper.getComponentName(ConvertNumber.class)), parent);
    }


    public String getLocale (){
        return getAttrValue(AttributeNames.LOCALE );
    }
    public void setLocale (String value){
        setAttrValue(AttributeNames.LOCALE , value);
    }

    public String getPattern (){
        return getAttrValue(AttributeNames.PATTERN );
    }
    public void setPattern (String value){
        setAttrValue(AttributeNames.PATTERN , value);
    }

    public String getCurrencyCode (){
        return getAttrValue(AttributeNames.CURRENCY_CODE );
    }
    public void setCurrencyCode (String value){
        setAttrValue(AttributeNames.CURRENCY_CODE , value);
    }

    public String getCurrencySymbol (){
        return getAttrValue(AttributeNames.CURRENCY_SYMBOL );
    }
    public void setCurrencySymbol (String value){
        setAttrValue(AttributeNames.CURRENCY_SYMBOL , value);
    }

    public String getGroupingUsed (){
        return getAttrValue(AttributeNames.GROUPING_USED );
    }
    public void setGroupingUsed (String value){
        setAttrValue(AttributeNames.GROUPING_USED , value);
    }

    public String getIntegerOnly (){
        return getAttrValue(AttributeNames.INTEGER_ONLY );
    }
    public void setIntegerOnly (String value){
        setAttrValue(AttributeNames.INTEGER_ONLY , value);
    }

    public String getMinIntegerDigits (){
        return getAttrValue(AttributeNames.MIN_INTEGER_DIGITS );
    }
    public void setMinIntegerDigits (String value){
        setAttrValue(AttributeNames.MIN_INTEGER_DIGITS , value);
    }

    public String getMaxIntegerDigits (){
        return getAttrValue(AttributeNames.MAX_INTEGER_DIGITS );
    }
    public void setMaxIntegerDigits (String value){
        setAttrValue(AttributeNames.MAX_INTEGER_DIGITS , value);
    }

    public String getMinFractionDigits (){
        return getAttrValue(AttributeNames.MIN_FRACTION_DIGITS );
    }
    public void setMinFractionDigits (String value){
        setAttrValue(AttributeNames.MIN_FRACTION_DIGITS , value);
    }

    public String getMaxFractionDigits (){
        return getAttrValue(AttributeNames.MAX_FRACTION_DIGITS );
    }
    public void setMaxFractionDigits (String value){
        setAttrValue(AttributeNames.MAX_FRACTION_DIGITS , value);
    }

    public String getRoundingMode (){
        return getAttrValue(AttributeNames.ROUNDING_MODE );
    }
    public void setRoundingMode (String value){
        setAttrValue(AttributeNames.ROUNDING_MODE , value);
    }

    public String getNegativePrefix (){
        return getAttrValue(AttributeNames.NEGATIVE_PREFIX );
    }
    public void setNegativePrefix (String value){
        setAttrValue(AttributeNames.NEGATIVE_PREFIX , value);
    }

    public String getNegativeSuffix (){
        return getAttrValue(AttributeNames.NEGATIVE_SUFFIX );
    }
    public void setNegativeSuffix (String value){
        setAttrValue(AttributeNames.NEGATIVE_SUFFIX , value);
    }

    public String getRefreshCondition (){
        return getAttrValue(AttributeNames.REFRESH_CONDITION );
    }
    public void setRefreshCondition (String value){
        setAttrValue(AttributeNames.REFRESH_CONDITION , value);
    }

    public String getDisabled (){
        return getAttrValue(AttributeNames.DISABLED );
    }
    public void setDisabled (String value){
        setAttrValue(AttributeNames.DISABLED , value);
    }

    public String getHintPattern (){
        return getAttrValue(AttributeNames.HINT_PATTERN );
    }
    public void setHintPattern (String value){
        setAttrValue(AttributeNames.HINT_PATTERN , value);
    }

    public String getMessageDetailConvertCurrency (){
        return getAttrValue(AttributeNames.MESSAGE_DETAIL_CONVERT_CURRENCY );
    }
    public void setMessageDetailConvertCurrency (String value){
        setAttrValue(AttributeNames.MESSAGE_DETAIL_CONVERT_CURRENCY , value);
    }

    public String getMessageDetailConvertNumber (){
        return getAttrValue(AttributeNames.MESSAGE_DETAIL_CONVERT_NUMBER );
    }
    public void setMessageDetailConvertNumber (String value){
        setAttrValue(AttributeNames.MESSAGE_DETAIL_CONVERT_NUMBER , value);
    }

    public String getMessageDetailConvertPattern (){
        return getAttrValue(AttributeNames.MESSAGE_DETAIL_CONVERT_PATTERN );
    }
    public void setMessageDetailConvertPattern (String value){
        setAttrValue(AttributeNames.MESSAGE_DETAIL_CONVERT_PATTERN , value);
    }

    public String getMessageDetailConvertPercent (){
        return getAttrValue(AttributeNames.MESSAGE_DETAIL_CONVERT_PERCENT );
    }
    public void setMessageDetailConvertPercent (String value){
        setAttrValue(AttributeNames.MESSAGE_DETAIL_CONVERT_PERCENT , value);
    }



}
