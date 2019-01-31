package com.jdadfapi.ui.binding;

import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 10-Nov-17
 * Time: 19:31
 */

public class Parameters extends XMLElement {
    private List<Parameter> parameters = new ArrayList<>();
    public Parameters(Element element) {
        super(element);
        loadTree();
    }
    private void loadTree(){
        List<Element> elements = element.getChildren(TagNames.PARAMETER);
        for(Element e : elements){
            parameters.add(new Parameter(e));
        }
    }

    public List<Parameter> getParameters() {
        return parameters;
    }
    public Parameter addParameter(String id, String value){
        Parameter parameter = new Parameter(addChildElement(TagNames.PARAMETER));
        parameter.setValue(value);
        parameter.setId(id);
        parameters.add(parameter);
        return parameter;
    }
}
