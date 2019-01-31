package com.jdadfapi.model.view;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.model.common.NamedXMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 04-Jan-18
 * Time: 09:16
 */

public class Variable extends NamedXMLElement {
    public Variable(Element element) {
        super(element);

    }

    public String getKind (){
        return getAttrValue(AttributeNames.KIND );
    }
    public void setKind (String value){
        setAttrValue(AttributeNames.KIND , value);
    }
    //TODO: ostali atts
}
