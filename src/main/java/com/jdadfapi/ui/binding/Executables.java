package com.jdadfapi.ui.binding;

import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import com.jdadfapi.model.applicationmodule.ViewUsage;
import com.jdadfapi.ui.TaskFlow;
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
 * Time: 22:49
 */

public class Executables extends XMLElement {
    private List<Iterator> iterators = new ArrayList<>();
    private List<SearchRegion> searchRegions = new ArrayList<>();
    private List<TaskFlowBinding> taskFlowBindings = new ArrayList<>();
    private VariableIterator variableIterator;

    public Executables(Element element) {
        super(element);
        loadTree();
    }
    private void loadTree(){

        List<Node> nodes = element.getNodes();
        if(nodes != null && nodes.size()>0){
            for(Node node : nodes){
                if(node.getType().equals(XMLTokenizer.Type.ELEMENT)){
                    Element e = (Element) node;
                    switch (e.getName()){
                        case TagNames.ITERATOR              : resolveIterator(e); break;
                        case TagNames.SEARCH_REGION         : resolveSearchRegion(e); break;
                        case TagNames.VARIABLE_ITERATOR     : resolveVariableIterator(e); break;
                        case TagNames.TASK_FLOW             : resolveTaskFlow(e); break;
                        default:log(e);
                            //TODO: OSTALI SLUCAJEVI

                    }

                }
            }
        }

        //Inint variable iteratora ako ga ni
        if(variableIterator == null) {
            Element e = new Element(TagNames.VARIABLE_ITERATOR);
            element.addNode(e);
            variableIterator = new VariableIterator(e);
            variableIterator.setId("variables");
        }


    }
    private void resolveIterator(Element e){
        iterators.add(new Iterator(e));
    }
    private void resolveSearchRegion(Element e){
        searchRegions.add(new SearchRegion(e));
    }
    private void resolveVariableIterator(Element e){
        variableIterator = new VariableIterator(e);
    }
    private void resolveTaskFlow ( Element e){
        taskFlowBindings.add(new TaskFlowBinding(e));
    }


    public List<Iterator> getIterators() {
        return iterators;
    }

    public List<SearchRegion> getSearchRegions() {
        return searchRegions;
    }

    public VariableIterator getVariableIterator() {
        return variableIterator;
    }
    public Iterator findIterator(String name){
        for(Iterator iter : iterators){
            if(iter.getId().equals(name))return iter;
        }

        return null;
    }
    public Iterator findIteratorBinds(String bindName){
        for(Iterator iter : iterators){
            if(iter.getBinds().equals(bindName))return iter;
        }

        return null;
    }

    public SearchRegion findSearchRegion(Iterator iter) {
        for(SearchRegion s : searchRegions){
            if(s.getBinds().equals(iter.getId()))return s;
        }
        return  null;
    }
    public SearchRegion findSearchRegion(String name) {
        for(SearchRegion s : searchRegions){
            if(s.getId().equals(name))return s;
        }
        return  null;
    }

    public Iterator createIterator(ViewUsage viewUsage){

        Iterator i = new Iterator(addChildElement(TagNames.ITERATOR));
        iterators.add(i);
        String name = viewUsage.getName();
        i.setBinds(name);
        i.setRangeSize("25");
        i.setDataControl(viewUsage.getApplicationModule().getName()+"DataControl");
        i.setId(name+"Iterator");

        return i;
    }

    public SearchRegion createSearchRegion (Iterator iterator){
        SearchRegion sr = new SearchRegion(addChildElement(TagNames.SEARCH_REGION));

        sr.setBinds(iterator.getId());
        sr.setCriteria("");
        sr.setCustomizer("oracle.jbo.uicli.binding.JUSearchBindingCustomizer");
        sr.setId(iterator.getBinds() + "Query");

        searchRegions.add(sr);

        return sr;
    }

    public TaskFlowBinding createTaskFlowBinding(){
        TaskFlowBinding tfb = new TaskFlowBinding(addChildElement(TagNames.TASK_FLOW));
        tfb.setXmlns("http://xmlns.oracle.com/adf/controller/binding");

        taskFlowBindings.add(tfb);
        return tfb;
    }

    public TaskFlowBinding createTaskFlowBinding(TaskFlow taskFlow){
        TaskFlowBinding tfb = createTaskFlowBinding();

        String id = taskFlow.getId().replaceAll("[-#]", "").toLowerCase();

        int i = 1;
        while(!isTFBUnique(id+i))i++;

        tfb.setId(id + i);
        tfb.setActivation("deferred");
        tfb.setTaskFlowId(taskFlow.getWebContentPath() + "#" + taskFlow.getId());

        return tfb;
    }

    private boolean isTFBUnique(String id){
        for(TaskFlowBinding tfb : taskFlowBindings){
            if(id.equals(tfb.getId()))return false;
        }
        return true;
    }

}

/*

        List<Element> list = element.getChildren(TagNames.ITERATOR);

        if(list != null && list.size()>0){
            for(Element e : list)iterators.add(new Iterator(e));
        }
        list = element.getChildren(TagNames.SEARCH_REGION);
        if(list != null && list.size()>0){
            for(Element e : list)searchRegions.add(new SearchRegion(e));
        }

        list = element.getChildren(TagNames.VARIABLE_ITERATOR);
        Element e = null;
        if(list != null && list.size()>0){
            e = list.get(0);
        }
        if(e == null) {
            e = new Element(TagNames.VARIABLE_ITERATOR);
            element.addNode(e);
        }
        variableIterator = new VariableIterator(e);
        if(variableIterator.getId()==null)variableIterator.setId("variables");

        list = element.getChildren(TagNames.TASK_FLOW);
        if(list != null && list.size()>0 ){
            for(Element tf : list){

            }
        }


 */