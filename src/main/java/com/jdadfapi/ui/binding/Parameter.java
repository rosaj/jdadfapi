package com.jdadfapi.ui.binding;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Dec-17
 * Time: 23:17
 */

public class Parameter extends XMLElement {
    public Parameter(Element element) {
        super(element);
    }
    public String getValue (){
        return getAttrValue(AttributeNames.VALUE );
    }
    public void setValue (String value){
        setAttrValue(AttributeNames.VALUE , value);
    }
}
