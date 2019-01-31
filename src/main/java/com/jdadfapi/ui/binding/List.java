package com.jdadfapi.ui.binding;

import com.jdadfapi.AttributeNames;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Dec-17
 * Time: 17:49
 */

public class List extends ListOfValuesBinding {
    public List(Element element) {
        super(element);
    }

    public String getMRUCount (){
        return getAttrValue(AttributeNames.MRU_COUNT );
    }
    public void setMRUCount (String value){
        setAttrValue(AttributeNames.MRU_COUNT , value);
    }

    public String getMRUId (){
        return getAttrValue(AttributeNames.MRU_ID );
    }
    public void setMRUId (String value){
        setAttrValue(AttributeNames.MRU_ID , value);
    }

}
