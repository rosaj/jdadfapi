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
 * Date: 09-Nov-17
 * Time: 01:19
 */

public class AttrNames extends XMLElement {
    private List<Item> items = new ArrayList<>();

    public AttrNames(Element element) {
        super(element);
        loadTree();
    }
    private void loadTree(){
        List<Element> elements = element.getChildren(TagNames.ITEM);
        if(!elements.isEmpty()){
            for(Element e : elements) items.add(new Item(e));
        }

    }

    public Item createItem(String value){
        Item item = new Item(addChildElement(TagNames.ITEM));
        item.setValue(value);
        items.add(item);
        return item;
    }

    public Item getItem(){

        if(items.size()>0)
        return items.get(0);
        return null;
    }

    public List<Item> getItems() {
        return items;
    }
    public Item getItem(String value){
        for(Item item : items)
            if(item.getValue().equals(value))return item;
        return null;
    }
}
