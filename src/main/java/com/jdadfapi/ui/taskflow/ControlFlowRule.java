package com.jdadfapi.ui.taskflow;

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
 * Date: 05-Nov-17
 * Time: 20:26
 */

public class ControlFlowRule extends XMLElement {
    List<ControlFlowCase> controlFlowCases = new ArrayList<>();

    public ControlFlowRule(Element element) {
        super(element);
        if(element.getChildren(TagNames.CONTROL_FLOW_CASE) == null)return;
        for(Element child: element.getChildren(TagNames.CONTROL_FLOW_CASE))
            controlFlowCases.add(new ControlFlowCase(child));
    }

    public String getFromActivity(){
        return element.getChildren(TagNames.FROM_ACTIVITY_ID).get(0).getText();
    }
    public void setFromActivity(String value){
        element.getChildren(TagNames.FROM_ACTIVITY_ID).get(0).setText(value);
    }

    public List<ControlFlowCase> getControlFlowCases() {
        return controlFlowCases;
    }

    public ControlFlowCase createControlFlowCase(){

        Element child = addChildElement(TagNames.CONTROL_FLOW_CASE);

        String id = this.getId();
        if(!controlFlowCases.isEmpty())
        id = controlFlowCases.get(controlFlowCases.size()-1).getId();

        id = "__"+(Integer.parseInt(id.replace("__",""))+1);

        ControlFlowCase cfc = new ControlFlowCase(child,true);
        cfc.setId(id);

        controlFlowCases.add(cfc);

        return cfc;
    }
    public boolean hasControlFlowCase (String name){
        for(ControlFlowCase flowCase : controlFlowCases){
            if(flowCase.getFromOutcome().equals(name))return true;
        }

        return false;
    }
    public ControlFlowCase findControlFlowRule(String name) {
        for (ControlFlowCase flowCase : controlFlowCases) {
            if (flowCase.getFromOutcome().equals(name)) return flowCase;
        }

        return null;
    }


    public void removeControlFlowCase(ControlFlowCase controlFlowCase){
        if (getControlFlowCases().remove(controlFlowCase)) {
            controlFlowCase.remove();
        }
        if(getControlFlowCases().isEmpty())remove();
    }


    }
