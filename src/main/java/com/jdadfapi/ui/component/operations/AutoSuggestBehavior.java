package com.jdadfapi.ui.component.operations;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 28-Feb-19
 * Time: 12:34
 */

public class AutoSuggestBehavior extends Component {

    public AutoSuggestBehavior(Element element, Component parent) {
        super(element, parent);
    }


    public AutoSuggestBehavior() {
        this(null);
    }

    public AutoSuggestBehavior(Component parent) {
        super(new Element(ComponentMapper.getComponentName(AutoSuggestBehavior.class)), parent);
    }

    public void setSuggestItems(String value){
        setAttrValue(AttributeNames.SUGGEST_ITEMS, value);
    }
    public String getSuggestItems(){
        return getAttrValue(AttributeNames.SUGGEST_ITEMS);
    }


    public void setSuggestedItems(String value){
        setAttrValue(AttributeNames.SUGGESTED_ITEMS, value);
    }
    public String getSuggestedItems(){
        return getAttrValue(AttributeNames.SUGGESTED_ITEMS);
    }


    public void setSmartList(String value){
        setAttrValue(AttributeNames.SMART_LIST, value);
    }
    public String getSmartList(){
        return getAttrValue(AttributeNames.SMART_LIST);
    }

    public void setMaxSuggestedItems(String value){
        setAttrValue(AttributeNames.MAX_SUGGESTED_ITEMS, value);
    }
    public String getMaxSuggestedItems(){
        return getAttrValue(AttributeNames.MAX_SUGGESTED_ITEMS);
    }


}
