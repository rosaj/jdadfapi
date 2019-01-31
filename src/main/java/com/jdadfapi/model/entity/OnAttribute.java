package com.jdadfapi.model.entity;

import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import com.jdadfapi.model.common.Item;
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
 * Date: 16-Feb-18
 * Time: 11:36
 */

public class OnAttribute extends XMLElement {

    private List<Item> items = new ArrayList();
    public OnAttribute(Element element) {
        super(element);
        loadTree();
    }

    private void loadTree() {
        for(Node n: element.getNodes()){
            if(n.getType().equals(XMLTokenizer.Type.ELEMENT)){
                Element e = (Element)n;
                switch (e.getName()){
                    case TagNames.ITEM     :resolveItem(e);break;
                    default: log(e);
                }
            }
        }
    }

    private void resolveItem(Element e) {
        items.add(new Item((e)));
    }

    public List<Item> getItems() {
        return items;
    }

}
