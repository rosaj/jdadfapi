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
 * Time: 19:57
 */

public class View extends XMLElement {


    public View(Element element) {
        super(element);
    }
    public String getPage(){
        return  element.getChildren(TagNames.PAGE).get(0).getText();
    }
    public void setPage(String name){
       List<Element> elements =  element.getChildren(TagNames.PAGE);
       Element page  = null;
       if(elements.isEmpty()){
           page = addChildElement(TagNames.PAGE);
       } else page = elements.get(0);
        page.setText(name);
    }
}
