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
 * Date: 14-Nov-17
 * Time: 07:07
 */

public class DataControlScope extends XMLElement {


    public DataControlScope(Element element) {
        super(element);

    }

    public void setShared(){
        addOrRemove(TagNames.ISOLATED, TagNames.SHARED);

    }
    public void setIsolated(){
        addOrRemove(TagNames.SHARED, TagNames.ISOLATED);
    }

    private void addOrRemove(String remove, String add){
        List<Element> elements = element.getChildren(add);
        if(!elements.isEmpty())return;

        elements = element.getChildren(remove);
        if(!elements.isEmpty()) elements.get(0).remove();

        addChildElement(add);
    }
}
