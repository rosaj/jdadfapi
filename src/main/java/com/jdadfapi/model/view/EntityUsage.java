package com.jdadfapi.model.view;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.model.common.AttrArray;
import com.jdadfapi.model.common.DesignTimeXMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 04-Dec-17
 * Time: 13:54
 */

public class EntityUsage extends DesignTimeXMLElement{

    public EntityUsage(Element element) {
        super(element);
    }



    public AttrArray getDstAttributes(){
        return getDesignTimeAttrArray(AttributeNames._DST_ATTRIBUTES);
    }

    public AttrArray getSrcAttributes(){
        return getDesignTimeAttrArray(AttributeNames._SRC_ATTRIBUTES);
    }

    public String getFirstDstAttribute(){
        return getItemAttrArrayValue(AttributeNames._DST_ATTRIBUTES);
    }

    public String getFirstSrcAttribute(){
        return getItemAttrArrayValue(AttributeNames._SRC_ATTRIBUTES);
    }

    public void addDstAttribute(String value){
        addAttrArryItem(AttributeNames._DST_ATTRIBUTES,value);
    }


    public void addSrcAttribute(String value){
        addAttrArryItem(AttributeNames._SRC_ATTRIBUTES,value);
    }

    public void clearDstAttributes(){
        AttrArray dst = getDstAttributes();
        if(dst != null){
            dst.clearAll();
        }
    }
    public void clearSrcAttributes(){
        AttrArray src = getSrcAttributes();
        if(src != null){
           src.clearAll();
        }
    }

/*
    public String getDstAttributes(){
        return getItemAttrArrayValue(AttributeNames._DST_ATTRIBUTES);
    }

    public String getSrcAttributes(){
        return getItemAttrArrayValue(AttributeNames._SRC_ATTRIBUTES);
    }
*/
    private String getItemAttrArrayValue(String name){
        AttrArray attrArray = getDesignTimeAttrArray(name);

        if(attrArray==null) return null;
        if(attrArray.getItems().isEmpty()) return null;
        return attrArray.getItems().get(0).getValue();
    }

/*
    public void setDstAttributes(String value){
         setItemAttrArrayValue(AttributeNames._DST_ATTRIBUTES, value);
    }
    public void setSrcAttributes(String value){
        setItemAttrArrayValue(AttributeNames._SRC_ATTRIBUTES, value);
    }


    private void setItemAttrArrayValue(String name, String value){
//TODO: IMPLEMENTI THIS METHOND
      //  getDesignTimeAttr()
    }*/


    public String getName(){
        return getAttrValue(AttributeNames.NAME_UPPER);
    }
    public String getEntity(){
        return getAttrValue(AttributeNames.ENTITY);
    }
    public String getJoinType(){return getAttrValue(AttributeNames.JOIN_TYPE);}
    public String getReadOnly(){return getAttrValue(AttributeNames.READ_ONLY_UPPER);}

    public String getDeleteParticipant(){return getAttrValue(AttributeNames.DELETE_PARTICIPANT);}
    public String getReference(){  return getAttrValue(AttributeNames.REFERENCE);}
    public String getSourceUsage(){return getAttrValue(AttributeNames.SOURCE_USAGE);}
    public String getAssociationEnd(){return getAttrValue(AttributeNames.ASSOCIATION_END);}
    public String getAssociation(){return getAttrValue(AttributeNames.ASSOCIATION);}



    public void setName(String value){
        setAttrValue(AttributeNames.NAME_UPPER, value);
    }
    public void setEntity(String value){
        setAttrValue(AttributeNames.ENTITY, value);
    }
    public void setJoinType(String value){setAttrValue(AttributeNames.JOIN_TYPE, value);}
    public void setReadOnly(String value){setAttrValue(AttributeNames.READ_ONLY_UPPER, value);}

    public void setDeleteParticipant(String value){setAttrValue(AttributeNames.DELETE_PARTICIPANT, value);}
    public void setReference(String value){  setAttrValue(AttributeNames.REFERENCE, value);}
    public void setSourceUsage(String value){setAttrValue(AttributeNames.SOURCE_USAGE, value);}
    public void setAssociationEnd(String value){setAttrValue(AttributeNames.ASSOCIATION_END, value);}
    public void setAssociation(String value){setAttrValue(AttributeNames.ASSOCIATION, value);}

    public String getEntitySimpleName(){
        return getSimple(getEntity());
    }
    public String getSourceUsageSimpleName(){
        return getSimple(getSourceUsage());
    }

}
