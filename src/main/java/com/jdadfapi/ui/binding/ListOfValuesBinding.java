package com.jdadfapi.ui.binding;

import com.jdadfapi.AttributeNames;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Dec-17
 * Time: 17:46
 */

public abstract class ListOfValuesBinding extends AttributeValue {
    public ListOfValuesBinding(Element element) {
        super(element);
    }

    public String getListOperMode() {
        return getAttrValue(AttributeNames.LIST_OPER_MODE);
    }

    public void setListOperMode(String value) {
        setAttrValue(AttributeNames.LIST_OPER_MODE, value);
    }

    public String getSelectionAttr() {
        return getAttrValue(AttributeNames.SELECTION_ATTR);
    }

    public void setSelectionAttr(String value) {
        setAttrValue(AttributeNames.SELECTION_ATTR, value);
    }

    public String getDelimiter() {
        return getAttrValue(AttributeNames.DELIMITER);
    }

    public void setDelimiter(String value) {
        setAttrValue(AttributeNames.DELIMITER, value);
    }

    public String getListIter() {
        return getAttrValue(AttributeNames.LIST_ITER);
    }

    public void setListIter(String value) {
        setAttrValue(AttributeNames.LIST_ITER, value);
    }

    public String getSelectItemValueMode() {
        return getAttrValue(AttributeNames.SELECT_ITEM_VALUE_MODE);
    }

    public void setSelectItemValueMode(String value) {
        setAttrValue(AttributeNames.SELECT_ITEM_VALUE_MODE, value);
    }

    public String getStaticList() {
        return getAttrValue(AttributeNames.STATIC_LIST);
    }

    public void setStaticList(String value) {
        setAttrValue(AttributeNames.STATIC_LIST, value);
    }

    public String getUses() {
        return getAttrValue(AttributeNames.USES);
    }

    public void setUses(String value) {
        setAttrValue(AttributeNames.USES, value);
    }


    public String getDTSupportsMRU() {
        return getAttrValue(AttributeNames.DT_SUPPORTS_MRU);
    }

    public void setDTSupportsMRU(String value) {
        setAttrValue(AttributeNames.DT_SUPPORTS_MRU, value);
    }
}
