package com.jdadfapi.ui.binding;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import de.pdark.decentxml.Element;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Dec-17
 * Time: 23:03
 */

public class TaskFlowBinding extends XMLElement {
    private Parameters parameters;
    public TaskFlowBinding(Element element) {
        super(element);
        loadTree();
    }
    private void loadTree(){
        List<Element> elements = element.getChildren(TagNames.PARAMETERS);
        if(!elements.isEmpty()){
            parameters = new Parameters(elements.get(0));
        }
    }

    public Parameters getParameters() {
        return parameters;
    }

    public String getXmlns (){
        return getAttrValue(AttributeNames.XMLNS );
    }
    public void setXmlns (String value){
        setAttrValue(AttributeNames.XMLNS , value);
    }

    public String getActivation (){
        return getAttrValue(AttributeNames.ACTIVATION );
    }
    public void setActivation (String value){
        setAttrValue(AttributeNames.ACTIVATION , value);
    }

    public String getTaskFlowId (){
        return getAttrValue(AttributeNames.TASK_FLOW_ID );
    }
    public void setTaskFlowId (String value){
        setAttrValue(AttributeNames.TASK_FLOW_ID , value);
    }

    public String getParametersMap (){
        return getAttrValue(AttributeNames.PARAMETERS_MAP );
    }
    public void setParametersMap (String value){
        setAttrValue(AttributeNames.PARAMETERS_MAP , value);
    }

    public String getRefresh (){
        return getAttrValue(AttributeNames.REFRESH );
    }
    public void setRefresh (String value){
        setAttrValue(AttributeNames.REFRESH , value);
    }

    public String getRefreshConditionUpper (){
        return getAttrValue(AttributeNames.REFRESH_CONDITION_UPPER );
    }
    public void setRefreshConditionUpper (String value){
        setAttrValue(AttributeNames.REFRESH_CONDITION_UPPER , value);
    }

    public String getRemoteConnectionName (){
        return getAttrValue(AttributeNames.REMOTE_CONNECTION_NAME );
    }
    public void setRemoteConnectionName (String value){
        setAttrValue(AttributeNames.REMOTE_CONNECTION_NAME , value);
    }

}
