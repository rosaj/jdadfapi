package com.jdadfapi.model.view;

import com.jdadfapi.AttributeNames;
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
 * Date: 06-Nov-17
 * Time: 10:46
 */

public class ViewAccessor extends XMLElement {
    private ParameterMap parameterMap;
    private List<ViewCriteriaUsage> viewCriteriaUsages = new ArrayList<>();
    public ViewAccessor(Element element) {
        super(element);
        loadTree();
    }


    private void loadTree() {

        for (Node n : element.getNodes()) {
            if (n.getType().equals(XMLTokenizer.Type.ELEMENT)) {
                Element e = (Element) n;
                switch (e.getName()) {
                    case TagNames.PARAMETER_MAP     : resolveParameterMap(e);break;
                    case TagNames.VIEW_CRITERIA_USAGE: resolveViewCriteriaUsage(e);break;
                    default:log(e);
                }
            }
        }

    }

    private void resolveViewCriteriaUsage(Element e) {
        viewCriteriaUsages.add(new ViewCriteriaUsage(e));
    }

    private void resolveParameterMap(Element e) {
        parameterMap = new ParameterMap(e);
    }

    public String getName(){
        return getAttrValue(AttributeNames.NAME_UPPER);
    }
    public void setName(String value){
        setAttrValue(AttributeNames.NAME_UPPER,value);
    }
    public String getViewObjectName(){
        return getAttrValue(AttributeNames.VIEW_OBJECT_NAME);
    }
    public void setViewObjectName (String value){
        setAttrValue(AttributeNames.VIEW_OBJECT_NAME,value);
    }
    public String getRowLevelBinds(){
        return getAttrValue(AttributeNames.ROW_LEVEL_BINDS);
    }
    public void setRowLevelBinds(String value){
        setAttrValue(AttributeNames.ROW_LEVEL_BINDS,value);
    }
    //TODO: POPRAVIT!!! WHAT?

    public String getViewObjectSimpleName(){
        return getSimple(getViewObjectName());
    }


    public List<ViewCriteriaUsage> getViewCriteriaUsages() {
        return viewCriteriaUsages;
    }

    public ViewCriteriaUsage addViewCriteraUsage(ViewCriteria viewCriteria){
        ViewCriteriaUsage vcu = new ViewCriteriaUsage(addChildElement(0, TagNames.VIEW_CRITERIA_USAGE));

        vcu.setName(viewCriteria.getName());
        vcu.setFullName(viewCriteria.getViewObjectName()+"."+viewCriteria.getName());

        viewCriteriaUsages.add(vcu);

        return vcu;
    }

    public ParameterMap getParameterMap() {
        return parameterMap;
    }
    public ParameterMap createParameterMap(){
        if(parameterMap == null){
            resolveParameterMap(addChildElement(TagNames.PARAMETER_MAP));
        }
        return parameterMap;
    }
}
