package com.jdadfapi.ui;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.FileUtils;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLDocument;
import com.jdadfapi.ui.taskflow.*;
import de.pdark.decentxml.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Nov-17
 * Time: 15:49
 */

public class TaskFlow extends XMLDocument {

    //TODO: Dodat sve ostale
    private static final String[] TAG_ORDER = {
            TagNames.TEMPLATE_REFERENCE,
            TagNames.DEFAULT_ACTIVITY,
            TagNames.DATA_CONTROL_SCOPE,
            TagNames.INPUT_PARAMETER_DEFINITION,
            TagNames.MANAGED_BEAN,
            TagNames.VIEW,
            TagNames.TASK_FLOW_CALL,
            TagNames.CONTROL_FLOW_RULE,
            TagNames.USE_PAGE_FRAGMENTS,
    };



    private Element  definition;
    private DefaultActivity defaultActivity;
    private List<View> views = new ArrayList<>();
    private List<TaskFlowCall> taskFlowCalls = new ArrayList<>();
    private List<ControlFlowRule> controlFlowRules = new ArrayList<>();
    private List<ManagedBean> managedBeans = new ArrayList<>();
    private List<InputParameterDefinition> inputParameters = new ArrayList<>();
    private ViewController viewController;
    private TaskFlowType taskFlowType;
    private TemplateReference templateReference;
    private DataControlScope dataControlScope;

    public enum TaskFlowType {
        TEMPLATE,
        DEFINITION
    }

    protected TaskFlow(Document document, String path){
        super(document, path);
        List<Element> elements = document.getRootElement().getChildren(TagNames.TASK_FLOW_DEFINITION);
        if(!elements.isEmpty()) {
            definition = elements.get(0);
            taskFlowType = TaskFlowType.DEFINITION;
        }
        else{

            this.definition = document.getRootElement().getChildren(TagNames.TASK_FLOW_TEMPLATE).get(0);
            taskFlowType = TaskFlowType.TEMPLATE;
        }

        loadTree();
    }

    public static TaskFlow load(String path){
        TaskFlow taskFlow = null;
        try {
            Document doc = XMLParser.parse(new File(path));
            taskFlow = new TaskFlow(doc,path);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return taskFlow;
    }

    static TaskFlow createTaskFlow(String path,String name){
        if(!name.endsWith(".xml"))name += ".xml";

        if(!path.endsWith("\\"))path = path+"\\";
        path = path + name;
     //  System.out.println(path);

        File file  = new File(path);
        FileUtils.checkOrCreateDirectory(file);
        try {
            if(!file.createNewFile()) throw new RuntimeException("TASK FLOW VEC POSTOJI");
            Document document = new Document();
            document.setVersion("1.0");
            document.setEncoding("windows-1250");

            Element root = new Element(TagNames.ADFC_CONFIG);
            root.addAttribute(AttributeNames.XMLNS,"http://xmlns.oracle.com/adf/controller");
            root.addAttribute(AttributeNames.VERSION, "1.2");

            document.setRootNode(root);

            String simpleName = name.replace(".xml","");

            Element definition = new Element(TagNames.TASK_FLOW_DEFINITION);
            definition.setAttribute(AttributeNames.ID,simpleName);

             root.addNode(definition);

             TaskFlow tf = new TaskFlow(document,path);
             return tf;



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

      //return null;
    }

    private void loadTree(){

        for (Node n: definition.getNodes()) {
            if(n.getType().equals(XMLTokenizer.Type.ELEMENT)){
                Element e = (Element)n;

                switch (e.getName()){
                    case TagNames.DEFAULT_ACTIVITY :resolveDefaultActivity(e);break;
                    case TagNames.VIEW             :resolveView(e);break;
                    case TagNames.TASK_FLOW_CALL   :resolveTaskFlowCall(e);break;
                    case TagNames.CONTROL_FLOW_RULE:resolveControlFlowRule(e);break;
                    case TagNames.MANAGED_BEAN     :resolveManagedBean(e);break;
                    case TagNames.TEMPLATE_REFERENCE: resolveTemplateReference(e);break;
                    case TagNames.DATA_CONTROL_SCOPE:resolveDataControlScope(e);break;
                    case TagNames.INPUT_PARAMETER_DEFINITION:resolveInputParameterDefinition(e);break;
                    case TagNames.USE_PAGE_FRAGMENTS: break;
                    default: log(e);
                }

            }
        }

    }
    private void resolveDefaultActivity(Element e){
        defaultActivity = new DefaultActivity(e);
    }
    private void resolveView(Element e){
        views.add(new View(e));
    }
    private void resolveTaskFlowCall(Element e){
        taskFlowCalls.add(new TaskFlowCall(e));
    }
    private void resolveControlFlowRule(Element e){
        controlFlowRules.add(new ControlFlowRule(e));
    }
    private void resolveManagedBean(Element e){managedBeans.add(new ManagedBean(e));}

    private void resolveTemplateReference(Element e){
        templateReference = new TemplateReference(e);
    }
    private void resolveDataControlScope(Element e){
        dataControlScope = new DataControlScope(e);
    }
    private void resolveInputParameterDefinition(Element e){
        inputParameters.add(new InputParameterDefinition(e));
    }

    public boolean isUseFragments(){
        return !definition.getChildren(TagNames.USE_PAGE_FRAGMENTS).isEmpty();
    }
    public void setUseFragments(boolean useFragments){
        if(useFragments){
            if(definition.getChildren(TagNames.USE_PAGE_FRAGMENTS).isEmpty())definition.addNode(new Element(TagNames.USE_PAGE_FRAGMENTS));
        }
        else{
            if(!definition.getChildren(TagNames.USE_PAGE_FRAGMENTS).isEmpty()) definition.removeNode(definition.getChildren(TagNames.USE_PAGE_FRAGMENTS).get(0));
        }

    }


    public DefaultActivity getDefaultActivity() {
        return defaultActivity;
    }
    public boolean hasDefaultActivity(){return defaultActivity!=null;}
    public boolean hasTemplateReference(){

        return templateReference!=null;
    }

    public TemplateReference getTemplateReference() {
        return templateReference;
    }

    public void setTemplateReference(TaskFlow taskFlow) {

        if(taskFlow == null){
            log("REMOVE REFERENCE");
            if(templateReference == null)return;
            templateReference = null;
            definition.getChildren(TagNames.TEMPLATE_REFERENCE).get(0).remove();
            return;

        }
        if(taskFlow.getTaskFlowType().equals(TaskFlowType.DEFINITION)){

            log("TASK FLOW REFERENCE MORA BIT TEMPLATE");
            return;
        }
        if(templateReference== null){
            Element e = new Element(TagNames.TEMPLATE_REFERENCE);
            definition.addNode(0, e);
            templateReference = new TemplateReference(e);

        }

        templateReference.setId(taskFlow.getId());
        templateReference.setDocument(taskFlow.getWebContentPath());

    }

    public List<View> getViews(){
        return views;
    }
    public List<TaskFlowCall>getTaskFlowCalls(){
        return taskFlowCalls;
    }
    public List<ControlFlowRule> getControlFlowRules(){
        return controlFlowRules;
    }

    public List<ManagedBean> getManagedBeans() {
        return managedBeans;
    }

    public List<InputParameterDefinition> getInputParameters() {
        return inputParameters;
    }

    public String getId(){
        return definition.getAttributeValue(AttributeNames.ID);
    }
    public void setId(String value){
        definition.setAttribute(AttributeNames.ID,value);
    }
    public ViewController getViewController(){
        return viewController;
    }

    public void setViewController(ViewController viewController){
        this.viewController = viewController;
    }


    public List<Page> getPages(){
        if(viewController == null)throw new RuntimeException("Nije postavljen viewController");
        List<Page> pages = new ArrayList<>();
        for(Page p :  viewController.getPages()){
            for(View view : views){
             //   if( p.getSimpleName().equals(view.getId())){
                if(p.getWebContentPath().equals(view.getPage())){
                    pages.add(p);
                    break;
                }
            }

        }

        return pages;
    }

    public TaskFlowCall findTaskFlowReference(String id){
       for ( TaskFlowCall tfc :  getTaskFlowCalls()){
           if(tfc.getTaskFlowReference().getId().equals(id))return tfc;
       }
       return null;
    }
    public ControlFlowRule createControlFlowRule(String fromActivity){

        Element e = new Element(TagNames.CONTROL_FLOW_RULE);
        e.addNode(new Element(TagNames.FROM_ACTIVITY_ID));
        int index = getLastIndexOfElement(definition,TagNames.CONTROL_FLOW_RULE,TAG_ORDER) +1;
        /*
        List<Element> children = definition.getChildren(TagNames.USE_PAGE_FRAGMENTS);
        if(children != null && !children.isEmpty()){
            Element child = children.get(0);
            index = definition.nodeIndexOf(child);
        }
        if(index == -1)  definition.addNode(e);
        else definition.addNode(index,e);
*/
        definition.addNode(index, e);

        ControlFlowRule cfr = new ControlFlowRule(e);


        String id = getUniqueId();
        cfr.setId(id);

        cfr.setFromActivity(fromActivity);
        controlFlowRules.add(cfr);
        return cfr;
    }

    public TaskFlowCall createTaskFlowCall(TaskFlow tf){

        if(hasTaskFlowCall(tf.getId()))return null;

        TaskFlowCall tfc = createTaskFlowCall(tf.getId());
        tfc.getTaskFlowReference().setDocument(tf.getWebContentPath());
        return tfc;
    }

    public TaskFlowCall createTaskFlowCall(String id){

        Element e  = new Element(TagNames.TASK_FLOW_CALL);

        Element tfRef = new Element(TagNames.TASK_FLOW_REFERENCE);

        Element doc = new Element(TagNames.DOCUMENT);
        Element idEl = new Element(TagNames.ID);
        idEl.setText(id);

        tfRef.addNode(doc);
        tfRef.addNode(idEl);

        e.addNode(tfRef);

        //List<Element> children = definition.getChildren(TagNames.TASK_FLOW_CALL);
        int index = getLastIndexOfElement(definition,TagNames.TASK_FLOW_CALL, TAG_ORDER)+1;
        /*
        if(children != null && !children.isEmpty()){
            int last = 0;
            if(children.size()>1)last = children.size()-1;
            Element child = children.get(last);
            index = definition.nodeIndexOf(child)+1;

        }

        if(index == -1) {
            children = definition.getChildren(TagNames.USE_PAGE_FRAGMENTS);
            if(children != null && !children.isEmpty()){
                Element child = children.get(0);
                index = definition.nodeIndexOf(child);
            }
        }

        if(index != -1)definition.addNode(index,e);
        else definition.addNode(e);
        */
        definition.addNode(index, e);

        TaskFlowCall tfc = new TaskFlowCall(e);
        tfc.setId(id);

        taskFlowCalls.add(tfc);

        return tfc;
    }
    public DefaultActivity setDefaultActivity(View view){
        if(defaultActivity != null){
            defaultActivity.setDefaultActivity(view.getId());
            return defaultActivity;

        }
        Element e = new Element(TagNames.DEFAULT_ACTIVITY);

        int index = getLastIndexOfElement(definition,TagNames.DEFAULT_ACTIVITY, TAG_ORDER)+1;
        /*
        if(hasTemplateReference()){
            List<Element> list = definition.getChildren(TagNames.TEMPLATE_REFERENCE);
            if(!list.isEmpty()){
                Element tmp =  list.get(list.size()-1);
                index = definition.nodeIndexOf(tmp)+1;
            }
        }
*/
        definition.addNode(index,e);
        this.defaultActivity = new DefaultActivity(e);
        defaultActivity.setDefaultActivity(view.getId());
        return defaultActivity;
    }
    public View addView(Page page){

        for(View v : views){
            if(v.getPage().equals(page.getWebContentPath())){
                return v;
 //              throw new RuntimeException("page vec postoji");

            }
        }
        int index = getLastIndexOfElement(definition,TagNames.VIEW, TAG_ORDER)+1;

        //if(hasDefaultActivity())index = definition.nodeIndexOf(definition.getChildren(TagNames.DEFAULT_ACTIVITY).get(0))+1;
        //else if(hasTemplateReference())index = definition.nodeIndexOf(definition.getChildren(TagNames.TEMPLATE_REFERENCE).get(0))+1;

        Element e = new Element(TagNames.VIEW);
        View view = new View(e);
        definition.addNode(index, e);

        view.setId(page.getSimpleName());
        view.setPage(page.getWebContentPath());

        views.add(view);
        return view;
    }
    public InputParameterDefinition addInputParameter(String name, String value, String paramClass){
        Element e = new Element(TagNames.INPUT_PARAMETER_DEFINITION);

        int i = getLastIndexOfElement(definition,TagNames.INPUT_PARAMETER_DEFINITION, TAG_ORDER);

        //if(hasDefaultActivity()) i = definition.nodeIndexOf(definition.getChildren(TagNames.DEFAULT_ACTIVITY).get(0));
        //else if(hasTemplateReference()) i = definition.nodeIndexOf(definition.getChildren(TagNames.TEMPLATE_REFERENCE).get(0));
        definition.addNode(i, e);



        InputParameterDefinition ipd = new InputParameterDefinition(e);
        inputParameters.add(ipd);

        ipd.setId(getUniqueId());

        ipd.setName(name);
        ipd.setValue(value);
        ipd.setParamClass(paramClass);

        return ipd;
    }

    @Override
    public String toString() {
        return this.getId();
    }
    /*
    public String getWebInfPath(){

       return "/"+path.substring(path.indexOf("WEB-INF")).replace("\\","/");
    }
    */
    public String getWebContentPath(){

        return "/"+path.substring(path.indexOf("public_html")+12).replace("\\","/");
    }

    public boolean hasTaskFlowCall(String id){
        for(TaskFlowCall tfc : taskFlowCalls){
            if(id.equals(tfc.getId()))return true;
        }
        return false;
    }


    public TaskFlowCall findTaksFlowCall(String id){
        for(TaskFlowCall tfc : taskFlowCalls){
            if(id.equals(tfc.getId()))return tfc;
        }
        return null;
    }

    public boolean hasControlFlowRule(String name){
        for(ControlFlowRule flowRule : controlFlowRules){
            if(flowRule.getFromActivity().equals(name))return true;
        }

        return false;
    }
    public ControlFlowRule findControlFlowRule(String name){
        for(ControlFlowRule flowRule : controlFlowRules){
            if(flowRule.getFromActivity().equals(name))return flowRule;
        }

        return null;
    }

    public DataControlScope getDataControlScope() {
        return dataControlScope;
    }

    public boolean hasDataControlScope(){
        return dataControlScope!=null;
    }

    public DataControlScope addDataControlScope(){

        if(hasDataControlScope()) return dataControlScope;

        Element e = new Element(TagNames.DATA_CONTROL_SCOPE);
        int i = getLastIndexOfElement(definition,TagNames.DATA_CONTROL_SCOPE, TAG_ORDER)+1;
//        if(hasDefaultActivity())i++;
        definition.addNode(i, e);

        dataControlScope = new DataControlScope(e);
        return dataControlScope;
    }
    public void removeDataControlScope(){
        if(!hasDataControlScope())return;
        dataControlScope = null;
        definition.getChildren(TagNames.DATA_CONTROL_SCOPE).get(0).remove();

    }
    public void removeTaskFlowCall(TaskFlowCall  taskFlowCall ){
        if(taskFlowCalls.remove(taskFlowCall)){
            taskFlowCall.remove();
            String id = taskFlowCall.getId();
            for (ControlFlowRule controlFlowRule : new ArrayList<>(getControlFlowRules())) {
                for (ControlFlowCase controlFlowCase :  new ArrayList<>(controlFlowRule.getControlFlowCases())) {
                    if(id.equals(controlFlowCase.getToActivityId())){
                        controlFlowRule.removeControlFlowCase(controlFlowCase);
                    }
                }
            }
        }
    }



    public void removeControlFlowRule(ControlFlowRule controlFlowRule){
        if(getControlFlowRules().remove(controlFlowRule)){
            controlFlowRule.remove();
        }
    }

    public TaskFlowType getTaskFlowType() {
        return taskFlowType;
    }

    private String getUniqueId(){
        int id =  getUniqueId(definition);

        return "__"+id;
    }


    private int getUniqueId(Element element){
        int id = 1;

        for (Element n: element.getChildren()) {
                String elId = n.getAttributeValue("id");
                if(elId!=null){
                    int elIdNum = id;
                    try{
                         elIdNum = Integer.parseInt( elId.replace( "__",""));
                    }catch (java.lang.NumberFormatException nfe){
                        // ovo je neki id task flowa ili nesto
                        //System.out.println(nfe);
                    }
                        if(elIdNum > id) id = elIdNum;
                        else if(elIdNum == id) id++;

                        if(n.hasChildren()){
                            for (Element child : n.getChildren()) {
                                int uniq = getUniqueId(child);
                                if(uniq == id)id++;
                                else if(uniq>id)id = uniq+1;
                            }
                        }
                }
        }
        return id;
    }
}