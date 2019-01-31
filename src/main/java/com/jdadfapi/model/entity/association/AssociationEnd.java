package com.jdadfapi.model.entity.association;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.model.common.AttrArray;
import com.jdadfapi.model.common.DesignTimeXMLElement;
import com.jdadfapi.model.common.Item;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Node;
import de.pdark.decentxml.XMLTokenizer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 08-Jun-18
 * Time: 07:06
 */

public class AssociationEnd extends DesignTimeXMLElement {

    private AttrArray attrArray;

    public AssociationEnd(Element element) {
        super(element);
        loadTree();
    }
    private void loadTree(){
        for(Node n: element.getNodes()){
            if(n.getType().equals(XMLTokenizer.Type.ELEMENT)){
                Element e = (Element)n;
                switch (e.getName()){
                    case TagNames.DESIGN_TIME : break;
                    case TagNames.ATTR_ARRAY  : resolveAttrArray(e);break;
                    default: log(e);
                }
            }
        }

    }

    private void  resolveAttrArray(Element e){
        attrArray = new AttrArray(e);
    }

    public List<Item> getAttributes(){
        if(attrArray == null) return new ArrayList<Item>();
        return  attrArray.getItems();
    }
    public void addAttributes(String value){
        attrArray = addAttrArryItem(AttributeNames.ATTRIBUTES, value);
    }


    public AttrArray getAttrArray() {
        return attrArray;
    }

    public String isUpdatable(){
        return getDesignTimeAttr(AttributeNames._IS_UPDATABLE);
    }
    public String getAggregation(){
        return getDesignTimeAttr(AttributeNames._AGGREGATION);
    }

    public String getFinderName(){
        return getDesignTimeAttr(AttributeNames._FINDER_NAME);
    }

    public String getForeignKey(){
        return getDesignTimeAttr(AttributeNames._FOREIGN_KEY);
    }

    public String getAccessor(){
        return getDesignTimeAttr(AttributeNames._ACCESSOR);
    }
    public void setAccessor(String value){
        setDesignTimeAttr(AttributeNames._ACCESSOR, value);
    }

    public void isUpdatable(String value){
        setDesignTimeAttr(AttributeNames._IS_UPDATABLE, value);
    }
    public void setAggregation(String value){
        setDesignTimeAttr(AttributeNames._AGGREGATION, value);
    }

    public void setFinderName(String value){
        setDesignTimeAttr(AttributeNames._FINDER_NAME, value);
    }

    public void setForeignKey(String value){
        setDesignTimeAttr(AttributeNames._FOREIGN_KEY, value);
    }

    public String getName(){
        return getAttrValue(AttributeNames.NAME_UPPER);
    }

    public String getCardinality(){
        return getAttrValue(AttributeNames.CARDINALITY);
    }

    public String getSource(){
        return getAttrValue(AttributeNames.SOURCE);
    }
    public String getOwner(){
        return getAttrValue(AttributeNames.OWNER);
    }
    public String getOwnerSimple(){
        return getSimple(getOwner());
    }

    public void setName(String value){
        setAttrValue(AttributeNames.NAME_UPPER, value);
    }

    public void setCardinality(String value){
        setAttrValue(AttributeNames.CARDINALITY, value);
    }

    public void setSource(String value){
        setAttrValue(AttributeNames.SOURCE, value);
    }
    public void setOwner(String value){
        setAttrValue(AttributeNames.OWNER, value);
    }
    //TODO: OSTALE ATTR AKO IMA, a ima

    public String hasOwner(){
        return getAttrValue(AttributeNames.HAS_OWNER);
    }
    public void setHasOwner(String value){
        setAttrValue(AttributeNames.HAS_OWNER,value);
    }

    public String getLockLevel(){
        return getAttrValue(AttributeNames.LOCK_LEVEL);
    }
    public void setLockLevel(String value){
        setAttrValue(AttributeNames.LOCK_LEVEL, value);
    }
    
}
