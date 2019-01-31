package com.jdadfapi.model.view;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Text;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 01-Oct-18
 * Time: 16:09
 */

public class TransientExpression extends XMLElement {
    public TransientExpression(Element element) {
        super(element);
    }

    public void setName(String value){
        setAttrValue(AttributeNames.NAME_UPPER, value);
    }
    public String getName(){
        return getAttrValue(AttributeNames.NAME_UPPER);
    }
    public void setValue(String value){
        if(value == null)value = "";
        element.setText("<![CDATA[" + value + "]]>");
    }
    public String getValue(){
        return element.getText();
    }
}
