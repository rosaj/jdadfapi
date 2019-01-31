package com.jdadfapi.ui.component.core;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Dec-17
 * Time: 18:08
 */

public class SelectItems extends Component {
    public SelectItems(Element element, Component parent) {
        super(element, parent);
    }
    public SelectItems(Component parent){
        this(new Element(ComponentMapper.getComponentName(SelectItems.class)),parent);
    }
    public SelectItems(){
        this(null);
    }

    public String getValue (){
        return getAttrValue(AttributeNames.VALUE );
    }
    public void setValue (String value){
        setAttrValue(AttributeNames.VALUE , value);
    }

    public String getBinding (){
        return getAttrValue(AttributeNames.BINDING );
    }
    public void setBinding (String value){
        setAttrValue(AttributeNames.BINDING , value);
    }

    public String getItemDescription (){
        return getAttrValue(AttributeNames.ITEM_DESCRIPTION );
    }
    public void setItemDescription (String value){
        setAttrValue(AttributeNames.ITEM_DESCRIPTION , value);
    }

    public String getItemValue (){
        return getAttrValue(AttributeNames.ITEM_VALUE );
    }
    public void setItemValue (String value){
        setAttrValue(AttributeNames.ITEM_VALUE , value);
    }

    public String getItemLabelEscaped (){
        return getAttrValue(AttributeNames.ITEM_LABEL_ESCAPED );
    }
    public void setItemLabelEscaped (String value){
        setAttrValue(AttributeNames.ITEM_LABEL_ESCAPED , value);
    }

    public String getItemLabel (){
        return getAttrValue(AttributeNames.ITEM_LABEL );
    }
    public void setItemLabel (String value){
        setAttrValue(AttributeNames.ITEM_LABEL , value);
    }

    public String getItemDisabled (){
        return getAttrValue(AttributeNames.ITEM_DISABLED );
    }
    public void setItemDisabled (String value){
        setAttrValue(AttributeNames.ITEM_DISABLED , value);
    }

    public String getVar (){
        return getAttrValue(AttributeNames.VAR );
    }
    public void setVar (String value){
        setAttrValue(AttributeNames.VAR , value);
    }
}
