package com.jdadfapi.ui.taskflow;

import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Nov-17
 * Time: 20:04
 */

public class TaskFlowCall extends XMLElement {

    private TaskFlowReference taskFlowReference;
    private Behaviour behaviour;
    public TaskFlowCall(Element element) {
        super(element);
        List<Element> reference = element.getChildren(TagNames.TASK_FLOW_REFERENCE);
        if(!reference.isEmpty()) taskFlowReference = new TaskFlowReference(reference.get(0));
        List<Element> behaviours = element.getChildren(TagNames.RUN_AS_DIALOG);
        if(!behaviours.isEmpty()) behaviour = new Behaviour(behaviours.get(0));
    }

    public TaskFlowReference getTaskFlowReference() {
        return taskFlowReference;
    }

    public Behaviour getBehaviour() {
        return behaviour;
    }
    public boolean hasBehaviour(){return behaviour!=null;}
    public Behaviour createBehaviour(){
        behaviour = new Behaviour(addChildElement(TagNames.RUN_AS_DIALOG));
        return behaviour;
    }

}
