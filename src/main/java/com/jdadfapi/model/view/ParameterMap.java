package com.jdadfapi.model.view;

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
 * Date: 01-Oct-18
 * Time: 16:09
 */

public class ParameterMap extends XMLElement {
    private List<PIMap> piMaps = new ArrayList<>();
    public ParameterMap(Element element) {
        super(element);
        loadTree();
    }

    private void loadTree() {

        for (Node n : element.getNodes()) {
            if (n.getType().equals(XMLTokenizer.Type.ELEMENT)) {
                Element e = (Element) n;
                switch (e.getName()) {
                    case TagNames.PI_MAP     : resolvePiMap(e);break;
                    default:log(e);
                }
            }
        }

    }

    private void resolvePiMap(Element e) {
        piMaps.add(new PIMap(e));
    }

    public List<PIMap> getPiMaps() {
        return piMaps;
    }
    public PIMap getPiMap(String varName){
        for (PIMap piMap : piMaps) {
            if(piMap.getVariable().equals( varName))return piMap;
        }
        return null;
    }
    public PIMap createPiMap(String varName, String expression){
        PIMap piMap = new PIMap(addChildElement(TagNames.PI_MAP));

        piMap.setVariable(varName);
        piMap.createTransientExpression(expression);

        piMaps.add(piMap);
        return piMap;
    }
    public boolean remove(PIMap piMap){
        if(piMaps.remove(piMap)){
            piMap.remove();
            return true;
        }
        return false;
    }
}
