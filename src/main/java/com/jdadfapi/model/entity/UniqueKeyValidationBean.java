package com.jdadfapi.model.entity;

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
 * Date: 31-Jan-18
 * Time: 11:18
 */

public class UniqueKeyValidationBean extends XMLElement {
    private OnAttribute onAttribute;
    public UniqueKeyValidationBean(Element element) {
        super(element);
        loadTree();
    }

    private void loadTree(){
        for(Node n: element.getNodes()){
            if(n.getType().equals(XMLTokenizer.Type.ELEMENT)){
                Element e = (Element)n;
                switch (e.getName()){
                    case TagNames.ON_ATTRIBUTES     :resolveOnAttributes(e);break;
                    case TagNames.RES_EXPRESSIONS   :resolveResExpressions(e);break;
                    default: log(e);
                }
            }
        }
    }
    private void resolveOnAttributes(Element e){
        onAttribute = new OnAttribute(e);
    }
    private void resolveResExpressions(Element e){
        //TODO: reslolve tag
    }

    public OnAttribute getOnAttribute() {
        return onAttribute;
    }


    public String getName (){
        return getAttrValue(AttributeNames.NAME_UPPER );
    }
    public void setName (String value){
        setAttrValue(AttributeNames.NAME_UPPER , value);
    }

    public String getResId (){
        return getAttrValue(AttributeNames.RES_ID );
    }
    public void setResId (String value){
        setAttrValue(AttributeNames.RES_ID , value);
    }

    public String getKeyName (){
        return getAttrValue(AttributeNames.KEY_NAME );
    }
    public void setKeyName (String value){
        setAttrValue(AttributeNames.KEY_NAME , value);
    }
//TODO: OSTALO
}
