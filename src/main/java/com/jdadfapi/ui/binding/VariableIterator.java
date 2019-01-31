package com.jdadfapi.ui.binding;

import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Node;
import de.pdark.decentxml.XMLTokenizer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Nov-17
 * Time: 23:02
 */

public class VariableIterator extends XMLElement {
    private List<VariableUsage> variableUsages = new ArrayList<>();
    public VariableIterator(Element element) {
        super(element);
        loadTree();
    }

    private void loadTree() {

        List<Node> nodes = element.getNodes();
        if (nodes != null && nodes.size() > 0) {
            for (Node node : nodes) {
                if (node.getType().equals(XMLTokenizer.Type.ELEMENT)) {
                    Element e = (Element) node;
                    switch (e.getName()) {
                        case TagNames.VARIABLE_USAGE:
                            resolveVariableUsage(e);
                            break;
                        default:
                            log(e);

                    }

                }
            }
        }
    }

    private void resolveVariableUsage(Element e) {
        variableUsages.add(new VariableUsage(e));
    }

    public List<VariableUsage> getVariableUsages() {
        return variableUsages;
    }
    public VariableUsage getVariableUsage(String name){
        for (VariableUsage variableUsage : variableUsages) {
            if(variableUsage.getName().equals(name))return variableUsage;
        }
        return null;
    }
}
