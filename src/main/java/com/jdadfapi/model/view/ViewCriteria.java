package com.jdadfapi.model.view;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import com.jdadfapi.model.common.Properties;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Node;
import de.pdark.decentxml.XMLTokenizer;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 19-Feb-19
 * Time: 18:22
 */

public class ViewCriteria extends XMLElement {
    private Properties properties;

    public ViewCriteria(Element element) {
        super(element);
        loadTree();
    }

    private void loadTree() {

        for (Element e : element.getChildren()) {
            switch (e.getName()) {
                case TagNames.PROPERTIES: resolveProperties(e);
                    break;
                default:
                    log(e);
            }
        }
    }

    private void resolveProperties(Element e) {
        properties = new Properties(e);
    }


    public String getName(){
        return getAttrValue(AttributeNames.NAME_UPPER);
    }
    public void setName(String value){
        setAttrValue(AttributeNames.NAME_UPPER,value);
    }

    public String getViewObjectName(){
        return getAttrValue(AttributeNames.VIEW_OBJECT_NAME);
    }
    public void setViewObjectName(String value){
        setAttrValue(AttributeNames.VIEW_OBJECT_NAME,value);
    }


    public String getConjunction(){
        return getAttrValue(AttributeNames.CONJUNCTION);
    }
    public void setConjunction(String value){
        setAttrValue(AttributeNames.CONJUNCTION,value);
    }

    public String getMode(){
        return getAttrValue(AttributeNames.MODE);
    }
    public void setMode(String value){
        setAttrValue(AttributeNames.MODE,value);
    }
    //TODO: OSTALI PROPERTIES i CustomProperties ViewCriteriaRow ViewCriteriaItem itd




    @Override
    public String toString() {
        return getName() != null ? getName(): super.toString();
    }

}
