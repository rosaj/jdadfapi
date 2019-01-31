package com.jdadfapi.ui.taskflow;

import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Nov-17
 * Time: 20:11
 */

public class Behaviour  extends XMLElement{
    private static String INLINE_POPUP = "inline-popup";

    private static String EXTERNAL_WINDOW = "external-window";

    public enum DisplayType{
        INLINE_POPUP,
        EXTERNAL_WINDOW
    }
    Element parent;



    public Behaviour(Element element) {
        super(element);
        this.parent = element.getParentElement();
    }


    public void setRunAsDialog(boolean asDialog){

        if(!asDialog)parent.removeNode(element);

        else if(asDialog && element.getParentElement() == null)parent.addNode(element);

    }


    public boolean isRunAsDialog(){
        return element.getParentElement()!=null;
    }


    public void setDisplayType(DisplayType type){
        if(!isRunAsDialog())setRunAsDialog(true);
        element.clearChildren();
        Element displayType = new Element(TagNames.DISPLAY_TYPE);
        String tagName = INLINE_POPUP;
        if(type.equals(DisplayType.EXTERNAL_WINDOW))tagName = EXTERNAL_WINDOW;

        displayType.addNode(new Element(tagName));
        element.addNode(displayType);

    }
    public DisplayType getDisplayType(){
        DisplayType dp = DisplayType.EXTERNAL_WINDOW;

        if (!element.getChildren().isEmpty()) {
            Element displayType = element.getChildren().get(0);
            if(!displayType.getChildren().isEmpty()){
                if(INLINE_POPUP.equals(displayType.getChildren().get(0).getBeginName())) dp = DisplayType.INLINE_POPUP;
            }
        }

        return dp;
    }



}
