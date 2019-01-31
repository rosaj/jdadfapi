package com.jdadfapi.ui.component.textandselection;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.ui.component.ComponentMapper;
import com.jdadfapi.ui.component.Component;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Nov-17
 * Time: 08:46
 */

public class InputComboboxListOfValues extends InputListOfValues {
    public InputComboboxListOfValues(Element element, Component parent) {
        super(element, parent);
    }

    public InputComboboxListOfValues(Component parent) {
        super(new Element(ComponentMapper.getComponentName(InputComboboxListOfValues.class)),parent);
    }

    public InputComboboxListOfValues() {
        this(null);
    }


    public String getVar (){
        return getAttrValue(AttributeNames.VAR );
    }
    public void setVar (String value){
        setAttrValue(AttributeNames.VAR , value);
    }

    public String getSearchDialog (){
        return getAttrValue(AttributeNames.SEARCH_DIALOG );
    }
    public void setSearchDialog (String value){
        setAttrValue(AttributeNames.SEARCH_DIALOG , value);
    }

    public String getContentDelivery (){
        return getAttrValue(AttributeNames.CONTENT_DELIVERY );
    }
    public void setContentDelivery (String value){
        setAttrValue(AttributeNames.CONTENT_DELIVERY , value);
    }

}
