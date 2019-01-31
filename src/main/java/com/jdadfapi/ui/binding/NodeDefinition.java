package com.jdadfapi.ui.binding;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 10-Nov-17
 * Time: 14:57
 */

public class NodeDefinition extends XMLElement {
    private AttrNames attrNames;
    public NodeDefinition(Element element) {
        super(element);
        List<Element> attrs = element.getChildren(TagNames.ATTR_NAMES);
        if(!attrs.isEmpty()) attrNames = new AttrNames(attrs.get(0));
    }

    public AttrNames getAttrNames() {
        return attrNames;
    }
    public AttrNames createAttrNames(){
        if(attrNames == null){
            attrNames = new AttrNames(addChildElement(TagNames.ATTR_NAMES));
        }
        return attrNames;
    }

    public boolean hasAttrNames(){
        return attrNames != null;
    }


    public String getName (){
        return getAttrValue(AttributeNames.NAME_UPPER );
    }
    public void setName (String value){
        setAttrValue(AttributeNames.NAME_UPPER , value);
    }

    public String getDefName (){
        return getAttrValue(AttributeNames.DEF_NAME );
    }
    public void setDefName (String value){
        setAttrValue(AttributeNames.DEF_NAME , value);
    }

    public String getClosedIcon (){
        return getAttrValue(AttributeNames.CLOSED_ICON );
    }
    public void setClosedIcon (String value){
        setAttrValue(AttributeNames.CLOSED_ICON , value);
    }

    public String getDiscrName (){
        return getAttrValue(AttributeNames.DISCR_NAME );
    }
    public void setDiscrName (String value){
        setAttrValue(AttributeNames.DISCR_NAME , value);
    }

    public String getDiscrValue (){
        return getAttrValue(AttributeNames.DISCR_VALUE );
    }
    public void setDiscrValue (String value){
        setAttrValue(AttributeNames.DISCR_VALUE , value);
    }

    public String getDTViewInstanceName (){
        return getAttrValue(AttributeNames.DT_VIEW_INSTANCE_NAME );
    }
    public void setDTViewInstanceName (String value){
        setAttrValue(AttributeNames.DT_VIEW_INSTANCE_NAME , value);
    }

    public String getIcon (){
        return getAttrValue(AttributeNames.ICON_UPPER );
    }
    public void setIcon (String value){
        setAttrValue(AttributeNames.ICON_UPPER , value);
    }

    public String getOpenIcon (){
        return getAttrValue(AttributeNames.OPEN_ICON );
    }
    public void setOpenIcon (String value){
        setAttrValue(AttributeNames.OPEN_ICON , value);
    }

    public String getRegion (){
        return getAttrValue(AttributeNames.REGION );
    }
    public void setRegion (String value){
        setAttrValue(AttributeNames.REGION , value);
    }

    public String getTargetIterator (){
        return getAttrValue(AttributeNames.TARGET_ITERATOR );
    }
    public void setTargetIterator (String value){
        setAttrValue(AttributeNames.TARGET_ITERATOR , value);
    }

    public String getRangeSize (){
        return getAttrValue(AttributeNames.RANGE_SIZE );
    }
    public void setRangeSize (String value){
        setAttrValue(AttributeNames.RANGE_SIZE , value);
    }


    public String getDefNameSimpleName(){
        return getSimple(getDefName());
    }

}
