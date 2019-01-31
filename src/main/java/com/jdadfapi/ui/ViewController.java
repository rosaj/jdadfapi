package com.jdadfapi.ui;

import com.jdadfapi.Workspace;
import com.jdadfapi.model.Model;
import de.pdark.decentxml.Document;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.XMLParser;

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
 * Time: 15:21
 */

public class ViewController {
    /*
    List<File> pages;
    List<File> taskFlows;
    Map<String, PageMap> pagesMap = new HashMap<>();
    Map<String, TaskFlow> taskFlowsMap = new HashMap<>();
    */
    private List<Page> pages ;
    private List<TaskFlow> taskFlows ;
    private DataBindings dataBindings;
    private String path;
    private Document jpr;
    private Workspace workspace;
/*
    private ViewController(List<File> pages, List<File> taskFlows) {
        this.pages = pages;
        this.taskFlows = taskFlows;
    }
*/
    private ViewController( List<Page> pages, List<TaskFlow> taskFlows ){
        this.pages = pages;
        this.taskFlows = taskFlows;
        for(Page p : pages)p.setViewController(this);
        for(TaskFlow t: taskFlows)t.setViewController(this);

    }
    public static ViewController loadViewController(String path){

        File f = new File(path);
        File ph =  null;
        DataBindings db = null;
        Document jpr = null;
        for(File file : f.listFiles()){
            String fileName = file.getName();
           if(fileName.equals("public_html"))ph = file;
           else if(fileName.equals("adfmsrc")) db = findDataBindings(file);
           else if (fileName.endsWith(".jpr")){
               try {
                   jpr = XMLParser.parse(file);
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
        List<File> pageFiles = new ArrayList<>();
        List<File> taskFlowFiles = new ArrayList<>();

        recursive(ph,pageFiles,taskFlowFiles);

        List<Page> pages = new ArrayList<>();
        List<TaskFlow> taskFlows = new ArrayList<>();

        for(File pageFile : pageFiles) pages.add(Page.load(pageFile.getAbsolutePath()));

        for(File taskFlowFile : taskFlowFiles)taskFlows.add(TaskFlow.load(taskFlowFile.getAbsolutePath()));

        ViewController vc = new ViewController(pages,taskFlows);
        vc.dataBindings = db;
        if(vc.dataBindings!=null) vc.dataBindings.setViewController(vc);
        vc.path = path;
        vc.jpr = jpr;

        return vc;
    }
    private static void recursive(File f, List<File> list,List<File> taskFlows ){
        if(f == null || f.listFiles() == null)return;
        for(File file : f.listFiles()){
            String name = file.getName();
            if(name.contains(".jsf"))list.add(file);
            if(name.endsWith(".xml")&& !name.endsWith("-config.xml") && !name.equals("web.xml") && !name.equals("trinidad-skins.xml"))taskFlows.add(file);
            recursive(file,list,taskFlows);
        }
    }
    private static DataBindings findDataBindings(File directory){
        File file = findFile(directory,"DataBindings.cpx");
        if(file == null) return null;
        try {
            Document document = XMLParser.parse(file);

            DataBindings db = new DataBindings(document,file.getAbsolutePath());
            return db;
        } catch (IOException e) {
            e.printStackTrace();

        }

        return null;
    }
    private static File findFile(File directory, String name){
        if(directory.getName().equals(name))return directory;
        if(directory.listFiles()==null)return null;
        for(File file: directory.listFiles()){
            if(file.getName().equals(name))return file;
            File childFile = findFile(file,name);
            if(childFile!=null)return childFile;
        }
        return null;
    }
/*
    public PageMap getPage(String name){
        PageMap t = pagesMap.get(name);
        if(t!= null) return t;

        for(File f: pages){
            if(f.getName().equals(name)){
                PageMap p = PageMap.load(f.getAbsolutePath());
                p.setViewController(this);
                pagesMap.put(name,p);
                return p;
            }
        }
        return null;
    }
*/
    public Page getPage(String name){
        for(Page p: pages){
            if(p.getName().equals(name))return p;
        }

        return null;
    }
/*
    public TaskFlow getTaskFlow(String name){
        TaskFlow t = taskFlowsMap.get(name);
        if(t!= null) return t;

        for(File f: taskFlows){
            if(f.getName().equals(name)){
             TaskFlow tf = TaskFlow.load(f.getAbsolutePath());
             tf.setViewController(this);
             taskFlowsMap.put(name,tf);
             return tf;
            }

        }
        return null;
    }
*/
    public TaskFlow getTaskFlow(String name){
        for(TaskFlow tf : taskFlows){
            if(tf.getId().equals(name))return tf;
        }

        return null;
    }

    public List<Page> getPages() {
        return pages;
    }

    public List<Page> getTemplatePages(){
        List<Page> pgs = new ArrayList<>();
        for(Page p : pages){
            if(p.isTemplate()) pgs.add(p);
        }

        return pgs;
    }

    public List<TaskFlow> getTaskFlows() {
        return taskFlows;
    }

    public List<TaskFlow> getTaskFlowDefinitions(){
        return getTaskFlows(TaskFlow.TaskFlowType.DEFINITION);
    }

    public List<TaskFlow> getTaskFlowTeplates(){
        return getTaskFlows(TaskFlow.TaskFlowType.TEMPLATE);
    }

    private List<TaskFlow> getTaskFlows(TaskFlow.TaskFlowType taskFlowType){
        List<TaskFlow> tfs = new ArrayList<>();

        for(TaskFlow tf : taskFlows){
            if(tf.getTaskFlowType().equals(taskFlowType)) tfs.add(tf);
        }

        return tfs;
    }


    public DataBindings getDataBindings() {
        return dataBindings;
    }

    public Page createPage(String pagePackage, String name, boolean isFragment){
        String temp = this.path;
   //     if(!temp.endsWith("\\"))temp = temp+"\\";
        temp+="\\public_html\\WEB-INF\\";
        if(pagePackage.trim().isEmpty() )temp = temp.replace("WEB-INF\\","");
        pagePackage = temp +pagePackage;
        Page page = Page.createPage(pagePackage, name, isFragment);
        page.setViewController(this);
        pages.add(page);
        return page;
    }

    public TaskFlow createTaskFlow(String tfPackage, String name){

        String temp = this.path;
        if(!temp.endsWith("\\"))temp = temp+"\\";
        temp+="public_html\\WEB-INF\\";
        tfPackage = temp +tfPackage;
        TaskFlow taskFlow = TaskFlow.createTaskFlow(tfPackage, name);
        taskFlow.setViewController(this);

        taskFlows.add(taskFlow);
        return taskFlow;
    }

    public String getDefaultPackage(){
      return Model.getDefaultPackage(jpr);
    }
    public Workspace getWorkspace(){
        return workspace;
    }
    public void internalSetWorkspace(Workspace w){
        this.workspace = w;
    }

    public String getPath() {
        return path;
    }

    /*
    public DataBindings createDataBindings(){
        if(dataBindings!=null) throw new RuntimeException("DataBindings already exist");
        String filePath = path+"\\adfmsrc\\"+getDefaultPackage().replace(".","\\")+"\\DataBindings.cpx";

        File file  = new File(filePath);
        FileUtils.checkOrCreateDirectory(file);
        try {
            file.createNewFile();
            Document document = new Document();
            document.setVersion("1.0");
            document.setEncoding("UTF-8");

            Element a = new Element(TagNames.APPLICATION);
            document.setRootNode(a);

            a.addNode(new Element(TagNames.PAGE_MAP));
            a.addNode(new Element(TagNames.PAGE_DEFINITION_USAGES));

            Application application = new Application(a);
            application.setXmlns("http://xmlns.oracle.com/adfm/application");
            application.setVersion("12.2.1.16.48");
            application.setId("DataBindings");
            application.setSeparateXMLFiles("false");
            application.setPackage(getDefaultPackage());
            application.setClientType("Generic");

            dataBindings = new DataBindings(document, file.getAbsolutePath());
            dataBindings.setViewController(this);
            //TODO: dodat ga u adfm.xml file

            return dataBindings;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

*/

    /*
    public List<PageMap> getPageMaps(){
        List<PageMap> pgs = new ArrayList<>();

        for(File f: pages){
            if(pagesMap.get(f.getName())!=null){
                pgs.add(pagesMap.get(f.getName()));
            }
            else{
                PageMap pg = PageMap.load(f.getAbsolutePath());
                pg.setViewController(this);
                pagesMap.put(f.getName(),pg);
                pgs.add(pg);
            }
        }

        return pgs;
    }


    public List<TaskFlow> getTaskFlows(){
        List<TaskFlow> tfs = new ArrayList<>();

        for(File f: taskFlows){
            if(taskFlowsMap.get(f.getName())!=null){
                tfs.add(taskFlowsMap.get(f.getName()));
            }
            else{
                TaskFlow tf = TaskFlow.load(f.getAbsolutePath());
                tf.setViewController(this);
                taskFlowsMap.put(f.getName(),tf);
                tfs.add(tf);
            }
        }

        return tfs;
    }
    */
}
