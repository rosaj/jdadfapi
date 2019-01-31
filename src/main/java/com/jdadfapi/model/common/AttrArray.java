package com.jdadfapi.model.common;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import com.jdadfapi.model.common.Item;
import de.pdark.decentxml.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 07-Dec-17
 * Time: 18:03
 */

public class AttrArray extends XMLElement {
    private List<Item> items = new ArrayList<>();
    public AttrArray(Element element) {
        super(element);
        loadTree();
    }

    private  void loadTree(){
        List<Element> elements = element.getChildren(TagNames.ITEM);
        for(Element e : elements){
            items.add(new Item((e)));
        }
    }
    public String getName(){
        return getAttrValue(AttributeNames.NAME_UPPER);
    }
    public void setName(String value){
        setAttrValue(AttributeNames.NAME_UPPER, value);
    }

    public List<Item> getItems() {
        return items;
    }
    public void removeItem(Item item){
        if(items.remove(item)){
            item.remove();
        }
    }
    public void removeItem(String value){
        for(Item item : items){
            if(value.equals(item.getValue())){
                removeItem(item);
                return;
            }
        }
    }

    public void clearAll(){

        if(getItems() != null){
            for (Item item : getItems()) {
                item.remove();
            }
            getItems().clear();
        }
    }

    public Item addItem(String value){
        Element e = new Element(TagNames.ITEM);
        element.addNode(e);

        Item item = new Item(e);
        item.setValue(value);

        items.add(item);
        return item;
    }
}
