package com.jdadfapi.ui.binding;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Node;
import de.pdark.decentxml.XMLTokenizer;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Dec-17
 * Time: 01:14
 */

public class BooleanBinding extends XMLElement {

    private AttrNames attrNames;
    private ValueList valueList;

    public BooleanBinding(Element element) {
        super(element);
        loadTree();
    }

    private void loadTree(){
        for(Node n: element.getNodes()){
            if(n.getType().equals(XMLTokenizer.Type.ELEMENT)){
                Element e = (Element)n;
                switch (e.getName()){
                    case TagNames.ATTR_NAMES : resolveAttrNames(e);break;
                    case TagNames.VALUE_LIST  : resolveValueList(e);break;
                    default: log(e);
                }
            }
        }
    }
    private void resolveAttrNames(Element e){
        attrNames = new AttrNames(e);
    }
    private void resolveValueList(Element e){
        valueList = new ValueList(e);
    }

    public AttrNames getAttrNames() {
        return attrNames;
    }

    public ValueList getValueList() {
        return valueList;
    }

    public void createAttrValue(String value){
        if(attrNames == null){
            attrNames = new AttrNames(addChildElement(TagNames.ATTR_NAMES));
            attrNames.createItem(value);
        }
        else if(attrNames.getItem(value)==null) attrNames.createItem(value);

    }
    public ValueList createValueList(String valueTrue, String valueFalse){
        if( valueList == null){
            valueList = new ValueList(addChildElement(TagNames.VALUE_LIST));
            valueList.createItem(valueTrue);
            valueList.createItem(valueFalse);
        }
        return valueList;
    }
    public void setIterBinding(String value){
        setAttrValue(AttributeNames.ITER_BINDING,value);
    }
    public String getIterBinding(){
        return getAttrValue(AttributeNames.ITER_BINDING);
    }

    public void setStaticList(String value){
        setAttrValue(AttributeNames.STATIC_LIST,value);
    }
    public String getStaticList(){
        return getAttrValue(AttributeNames.STATIC_LIST);
    }
    public void seDTSupportsMRU(String value){
        setAttrValue(AttributeNames.DT_SUPPORTS_MRU,value);
    }
    public String getDTSupportsMRU(){
        return getAttrValue(AttributeNames.DT_SUPPORTS_MRU);
    }

    //TODO: OSTALI PROPERTY


}
