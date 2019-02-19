package com.jdadfapi.model.view;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 19-Feb-19
 * Time: 18:35
 */

public class ViewCriteriaUsage extends XMLElement {
    public ViewCriteriaUsage(Element element) {
        super(element);
    }



    public String getName(){
        return getAttrValue(AttributeNames.NAME_UPPER);
    }
    public void setName(String value){
        setAttrValue(AttributeNames.NAME_UPPER,value);
    }


    public String getFullName(){
        return getAttrValue(AttributeNames.FULL_NAME);
    }
    public void setFullName(String value){
        setAttrValue(AttributeNames.FULL_NAME,value);
    }

}
