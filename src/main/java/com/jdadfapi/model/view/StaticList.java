package com.jdadfapi.model.view;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 20-Feb-19
 * Time: 09:27
 */

public class StaticList extends XMLElement {
    public StaticList(Element element) {
        super(element);
    }

    public void setColumns(String value){
        setAttrValue(AttributeNames.COLUMNS_UPPER, value);
    }
    public String getColumns(){
        return getAttrValue(AttributeNames.COLUMNS_UPPER);
    }

    public void setRows(String value){
        setAttrValue(AttributeNames.ROWS_UPPER, value);
    }
    public String getRows(){
        return getAttrValue(AttributeNames.ROWS_UPPER);
    }


}
