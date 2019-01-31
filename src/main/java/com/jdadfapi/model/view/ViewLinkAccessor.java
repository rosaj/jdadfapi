package com.jdadfapi.model.view;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 25-Jul-18
 * Time: 09:03
 */

public class ViewLinkAccessor extends XMLElement {
    public ViewLinkAccessor(Element element) {
        super(element);
    }
    public String getName (){
        return getAttrValue(AttributeNames.NAME_UPPER );
    }
    public void setName (String value){
        setAttrValue(AttributeNames.NAME_UPPER , value);
    }

    public String getViewLink (){
        return getAttrValue(AttributeNames.VIEW_LINK );
    }
    public void setViewLink (String value){
        setAttrValue(AttributeNames.VIEW_LINK , value);
    }

    public String getType (){
        return getAttrValue(AttributeNames.TYPE_UPPER );
    }
    public void setType (String value){
        setAttrValue(AttributeNames.TYPE_UPPER , value);
    }

    public String getReversed(){
        return getAttrValue(AttributeNames.REVERSED );
    }
    public void setReversed(String value){
        setAttrValue(AttributeNames.REVERSED , value);
    }
    public String getIsUpdateable (){
        return getAttrValue(AttributeNames.IS_UPDATEABLE );
    }
    public void setIsUpdateable (String value){
        setAttrValue(AttributeNames.IS_UPDATEABLE , value);
    }

}
