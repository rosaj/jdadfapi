package com.jdadfapi.ui.binding;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Nov-17
 * Time: 22:59
 */

public class Iterator extends XMLElement {
    public Iterator(Element element) {
        super(element);

    }
    public String getBinds (){
        return getAttrValue(AttributeNames.BINDS);
    }

    public String getRangeSize (){
        return getAttrValue(AttributeNames.RANGE_SIZE);
    }
    public String getDataControl (){
        return getAttrValue(AttributeNames.DATA_CONTROL);
    }
    public String getChangeEventPolicy (){
        return getAttrValue(AttributeNames.CHANGE_EVENT_POLICY);
    }
  /*
    public String get (){
        return getAttrValue(AttributeNames.);
    }
      public void set (String value){
        setAttrValue(AttributeNames. ,value);
    }

*/

    public void setBinds (String value){
        setAttrValue(AttributeNames.BINDS ,value);
    }
    public void setRangeSize (String value){
        setAttrValue(AttributeNames.RANGE_SIZE ,value);
    }
    public void setDataControl (String value){
        setAttrValue(AttributeNames.DATA_CONTROL ,value);
    }
    public void setChangeEventPolicy (String value){
        setAttrValue(AttributeNames.CHANGE_EVENT_POLICY ,value);
    }




}
