package com.jdadfapi.model.view;

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
 * Date: 01-Oct-18
 * Time: 16:09
 */

public class PIMap extends XMLElement {
    private TransientExpression transientExpression;
    public PIMap(Element element) {
        super(element);
        loadTree();
    }


    private void loadTree() {

        for (Node n : element.getNodes()) {
            if (n.getType().equals(XMLTokenizer.Type.ELEMENT)) {
                Element e = (Element) n;
                switch (e.getName()) {
                    case TagNames.TRANSIENT_EXPRESSION :resolveTransientExpression(e);break;
                    default:log(e);
                }
            }
        }

    }

    private void resolveTransientExpression(Element e) {
        transientExpression = new TransientExpression(e);
    }

    public void setVariable(String value){
        setAttrValue(AttributeNames.VARIABLE, value);
    }
    public String getVariable(){
        return getAttrValue(AttributeNames.VARIABLE);
    }

    public TransientExpression getTransientExpression() {
        return transientExpression;
    }
    public TransientExpression createTransientExpression(String expression){
        if(transientExpression == null){
            transientExpression = new TransientExpression(addChildElement(TagNames.TRANSIENT_EXPRESSION));
            transientExpression.setName("ExpressionScript");
        }
        transientExpression.setValue(expression);
        return transientExpression;
    }

}
