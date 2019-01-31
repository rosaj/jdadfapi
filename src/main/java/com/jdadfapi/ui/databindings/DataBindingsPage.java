package com.jdadfapi.ui.databindings;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 02-Aug-18
 * Time: 08:41
 */

public class DataBindingsPage extends XMLElement {
    public DataBindingsPage(Element element) {
        super(element);
    }

    public String getPath(){
        return getAttrValue(AttributeNames.PATH);
    }
    public void setPath(String value){
        setAttrValue(AttributeNames.PATH , value);
    }

    public String getUsageId(){
        return getAttrValue(AttributeNames.USAGE_ID);
    }
    public void setUsageId(String value){
        setAttrValue(AttributeNames.USAGE_ID,value);
    }

    @Override
    public String toString() {
        String path = getPath();
        if(path!=null)return path;
        return super.toString();
    }
}
