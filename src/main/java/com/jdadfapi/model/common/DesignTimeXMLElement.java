package com.jdadfapi.model.common;

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
 * Date: 06-Dec-17
 * Time: 21:55
 */

public class DesignTimeXMLElement extends XMLElement {
    protected DesignTime designTime;

    public DesignTimeXMLElement(Element element) {
        super(element);
        loadTree();
    }
    private void loadTree(){
        for(Node n: element.getNodes()){
            if(n.getType().equals(XMLTokenizer.Type.ELEMENT)){
                Element e = (Element)n;
                switch (e.getName()){
                    case TagNames.DESIGN_TIME : resolveDesignTime(e);break;
                    case TagNames.PROPERTIES  : break;//resolveProperties(e);break;
                    default: log(e);
                }
            }
        }
    }

    private void resolveDesignTime(Element e){
        designTime = new DesignTime(e);
    }
    protected void setDesignTimeAttr(String name, String value){
        ensureDesignTime();
        designTime.setDesignAttrValue(name,value);
    }
    protected String getDesignTimeAttr(String name){
        if(designTime == null)return null;
        return designTime.getDesignAttrValue(name);
    }

    protected AttrArray getDesignTimeAttrArray(String name) {
        if(designTime == null)return null;
        return designTime.getAttrArray(name);
    }
    protected AttrArray addAttrArryItem(String attrArrayName, String value){
        ensureDesignTime();
        return designTime.addAttrArrayItem(attrArrayName, value);
    }
    private void ensureDesignTime(){
        if(designTime == null){
            /*
            Element e = new Element(TagNames.DESIGN_TIME);
            element.addNode(e);*/
            designTime = new DesignTime(addChildElement(TagNames.DESIGN_TIME));
        }
    }

}
