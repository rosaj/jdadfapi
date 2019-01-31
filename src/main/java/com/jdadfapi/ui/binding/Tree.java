package com.jdadfapi.ui.binding;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import com.jdadfapi.model.applicationmodule.ViewUsage;
import com.jdadfapi.model.view.ViewObject;
import de.pdark.decentxml.Element;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 10-Nov-17
 * Time: 14:56
 */

public class Tree extends AttributeValue {
    private NodeDefinition definition;
    public Tree(Element element) {
        super(element);
        List<Element> def = element.getChildren(TagNames.NODE_DEFINITION);
        if(!def.isEmpty()) definition = new NodeDefinition(def.get(0));

    }

    public NodeDefinition getDefinition() {
        return definition;
    }


    public String getAccessorFolder (){
        return getAttrValue(AttributeNames.ACCESSOR_FOLDER );
    }
    public void setAccessorFolder (String value){
        setAttrValue(AttributeNames.ACCESSOR_FOLDER , value);
    }

    public NodeDefinition createDefinition(ViewUsage viewUsage){

        if(definition!=null)return definition;
        definition = new NodeDefinition(addChildElement(TagNames.NODE_DEFINITION));

        definition.setDefName(viewUsage.getViewObjectName());
        definition.setName(this.getId()+"0");
        return definition;
    }
}
