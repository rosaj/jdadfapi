package com.jdadfapi;

import com.jdadfapi.Saver;
import com.jdadfapi.ui.component.UIComponent;
import de.pdark.decentxml.Document;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.XMLDeclaration;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Nov-17
 * Time: 07:28
 */

public class XMLDocument extends XMLElement{

    protected Document document ;
    protected String path;

    protected XMLDocument(Document document, String path) {
        super(document.getRootElement());
        this.document = document;
        this.path     = path;

       // this.path = "test.xml";
    }
    public void save(){

        if(path.endsWith(".jsf")){
            XMLDeclaration xmlDeclaration = document.getXmlDeclaration();
            xmlDeclaration.setVersionQuote('\'');
            xmlDeclaration.setEncodingQuote('\'');
        }

        Saver.save(document,path);
    }
    public void saveFormatted() {
      //  Saver.saveFormatted(document,path);
        save();
    }
/*
    public void setPath(String path){
        this.path  = path;
    }
    */
    protected int getLastIndexOfElement(String tagName,String[] orderedTagNames){
        return getLastIndexOfElement(element, tagName, orderedTagNames);
    }

    protected static int getLastIndexOfElement(Element element, String tagName, String[] orderedTagNames){
        int index = 0;
        boolean found = false;
        for(String name : orderedTagNames){
            if(name.equals(tagName)){
                found = true;
                break;
            }
            index++;
        }
        if(!found){
            index = orderedTagNames.length-1;
        }
        List<Element> elements ;
        for(int i = index ; i>=0; i--) {
            elements = element.getChildren(orderedTagNames[i]);
            if(!elements.isEmpty()) return element.nodeIndexOf(elements.get(elements.size() - 1));
        }

        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        if( super.equals(obj)){
            return true;
        }
        if (obj instanceof XMLDocument) {
            return path.equals(((XMLDocument) obj).path);
        }
        return false;
    }
}
