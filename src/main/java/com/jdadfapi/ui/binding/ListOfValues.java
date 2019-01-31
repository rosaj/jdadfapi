package com.jdadfapi.ui.binding;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Nov-17
 * Time: 23:49
 */

public class ListOfValues extends ListOfValuesBinding {
    public ListOfValues(Element element) {
        super(element);
    }

   public String getSearchCriteria (){
        return getAttrValue(AttributeNames.SEARCH_CRITERIA );
    }
   public void setSearchCriteria (String value){
        setAttrValue(AttributeNames.SEARCH_CRITERIA , value);
    }

}
