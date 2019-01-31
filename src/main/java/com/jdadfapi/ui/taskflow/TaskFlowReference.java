package com.jdadfapi.ui.taskflow;

import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Nov-17
 * Time: 20:06
 */

public class TaskFlowReference extends XMLElement {
    public TaskFlowReference(Element element) {
        super(element);
    }

    @Override
    public String getId() {
        List<Element> elements = element.getChildren(TagNames.ID);
        if(elements.isEmpty())return null;
        return elements.get(0).getText();
    }

    @Override
    public void setId(String value) {
        List<Element> elements = element.getChildren(TagNames.ID);
        if(elements.isEmpty()){
            Element id = new Element(TagNames.ID);
            id.setText(value);
            element.addNode(id);
        }
        else{
            elements.get(0).setText(value) ;
        }
    }

    public String getDocument() {

        List<Element> elements = element.getChildren(TagNames.DOCUMENT);
        if(elements.isEmpty())return null;
        return elements.get(0).getText();
    }


    public void setDocument(String value) {
        List<Element> elements = element.getChildren(TagNames.DOCUMENT);
        if(elements.isEmpty()){
            Element document = new Element(TagNames.DOCUMENT);
            document.setText(value);
            element.addNode(0, document);
        }
        else
        elements.get(0).setText(value) ;
    }

}
