package com.jdadfapi.model.view;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import com.jdadfapi.model.common.AttrArray;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Node;
import de.pdark.decentxml.XMLTokenizer;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 07-Dec-17
 * Time: 18:00
 */

public class LOVUIHints extends XMLElement {

    private AttrArray attrArray;
    public LOVUIHints(Element element) {
        super(element);
        loadTree();
    }
    private void loadTree(){
        for(Node n: element.getNodes()){
            if(n.getType().equals(XMLTokenizer.Type.ELEMENT)){
                Element e = (Element)n;
                switch (e.getName()){
                    case TagNames.ATTR_ARRAY:resolveAttrArray(e);break;
                    case TagNames.DISPLAY_CRITERIA:resolveDisplayCriteria(e);break;
                    default: log(e);
                }
            }
        }
    }
    private void resolveAttrArray(Element e){
        attrArray = new AttrArray(e);
    }
    private void resolveDisplayCriteria(Element e){
        //TODO: DISPLAY CRITERIA
    }
    public boolean hasListDisplayAttrNames(){
        return attrArray != null;
    }

    public AttrArray getListDisplayAttrNames() {
        return attrArray;
    }


    public String getListType (){
        return getAttrValue(AttributeNames.LIST_TYPE );
    }
    public void setListType (String value){
        setAttrValue(AttributeNames.LIST_TYPE , value);
    }

    public String getMRUCount (){
        return getAttrValue(AttributeNames.MRU_COUNT );
    }
    public void setMRUCount (String value){
        setAttrValue(AttributeNames.MRU_COUNT , value);
    }

    public String getNullValueFlag (){
        return getAttrValue(AttributeNames.NULL_VALUE_FLAG );
    }
    public void setNullValueFlag (String value){
        setAttrValue(AttributeNames.NULL_VALUE_FLAG , value);
    }

    public String getComboRowCountHint (){
        return getAttrValue(AttributeNames.COMBO_ROW_COUNT_HINT );
    }
    public void setComboRowCountHint (String value){
        setAttrValue(AttributeNames.COMBO_ROW_COUNT_HINT , value);
    }

    public String getListRangeSize (){
        return getAttrValue(AttributeNames.LIST_RANGE_SIZE );
    }
    public void setListRangeSize (String value){
        setAttrValue(AttributeNames.LIST_RANGE_SIZE , value);
    }

    public String getComboAttributeCount (){
        return getAttrValue(AttributeNames.COMBO_ATTRIBUTE_COUNT );
    }
    public void setComboAttributeCount (String value){
        setAttrValue(AttributeNames.COMBO_ATTRIBUTE_COUNT , value);
    }

    public String getNullValueId (){
        return getAttrValue(AttributeNames.NULL_VALUE_ID );
    }
    public void setNullValueId (String value){
        setAttrValue(AttributeNames.NULL_VALUE_ID , value);
    }



}
