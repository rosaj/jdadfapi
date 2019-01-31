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
 * Time: 20:30
 */

public class ControlFlowCase extends XMLElement {

    public ControlFlowCase(Element element) {
        super(element);
    }
    protected ControlFlowCase(Element element, boolean init){
        super(element);
        if(init){
            addChildElement(TagNames.FROM_OUTCOME);
            addChildElement(TagNames.TO_ACTIVITY_ID);
        }
    }
    public String getFromOutcome(){
        return element.getChildren(TagNames.FROM_OUTCOME).get(0).getText();
    }
    public ControlFlowCase  setFromOutcome(String value){
        element.getChildren(TagNames.FROM_OUTCOME).get(0).setText(value);
        return this;
    }
    public String getToActivityId(){
        return element.getChildren(TagNames.TO_ACTIVITY_ID).get(0).getText();
    }
    public ControlFlowCase setToActivitiyId(String value){
        element.getChildren(TagNames.TO_ACTIVITY_ID).get(0).setText(value);
        return this;
    }

}
