package com.jdadfapi.ui;

import com.jdadfapi.FileUtils;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLDocument;
import com.jdadfapi.ui.binding.PageDef;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import com.jdadfapi.ui.component.layout.Facet;
import com.jdadfapi.ui.component.layout.Form;
import com.jdadfapi.ui.component.layout.PageTemplate;
import com.jdadfapi.ui.component.templating.CFacet;
import com.jdadfapi.ui.component.templating.Composition;
import com.jdadfapi.ui.databindings.DataBindingsPage;
import com.jdadfapi.ui.databindings.PageDefinitionUsages;
import com.jdadfapi.ui.databindings.PageMap;
import com.jdadfapi.ui.taskflow.View;
import de.pdark.decentxml.*;
import de.pdark.decentxml.dtd.DocType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 05-Nov-17
 * Time: 08:35
 */

public class Page extends XMLDocument {

    private Component root;

    private ViewController viewController;
    private String name;
    private PageDef pageDef;

    protected Page(Document document, String path) {
        super(document, path);

        int index = path.lastIndexOf("\\");
        if(index == -1 ) index = path.lastIndexOf("/");
        this.name     = path.substring(index+1);

//        root = new UIComponent(document.getRootElement(),null);

        try {
            Class c = ComponentMapper.getComponentClass(document.getRootElement().getBeginName());
            root = (Component) c.getConstructor(Element.class,Component.class).newInstance(document.getRootElement(),null);

        } catch (Exception e1) {
            e1.printStackTrace();
        }


    }
    public Component getRoot(){
        return root;
    }

    public static Page load(String path){
        Page page;
        try {
            Document doc = XMLParser.parse(new File(path));

            page = new Page(doc,path);

            path = path.replace("public_html\\WEB-INF","adfmsrc").replace(".jsff","PageDef.xml").replace(".jsf","PageDef.xml");
            File f = new File(path);


            if(!f.exists())return page;

            Document defDoc = XMLParser.parse(f);
            page.pageDef = new PageDef(page, defDoc,path);
        } catch (Exception e) {
            throw new RuntimeException(path,e);

        }
        return page;
    }

    static Page createPage(String path,String name, boolean isFragment){

        String extension = ".jsff";
        if(!isFragment) extension = ".jsf";

        if(!name.endsWith(extension))name += extension;

        if(!path.endsWith("\\"))path = path+"\\";
        path = path + name;

        File file  = new File(path);
        FileUtils.checkOrCreateDirectory(file);

        try {
            if(!file.createNewFile()) throw new RuntimeException("STRANICA VEC POSTOJI");
            Document document = new Document();
            document.setVersion("1.0");
            document.setEncoding("UTF-8");
            if(isFragment){

                return  createFragment(path,document);
            }
            else{
                return createPage(path,document);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Page createFragment(String fullPath, Document document){
        Element el = new Element(ComponentMapper.getComponentName(Composition.class));
        Composition composition = new Composition(el,null);
        composition.setXmlnsUi("http://java.sun.com/jsf/facelets");
        document.setRootNode(el);

        return new Page(document,fullPath);
    }
    private static Page createPage(String fullPath, Document document){

        DocType docType = new DocType();
        docType.setName("html");
        document.setDocType(docType);
        document.addNode(docType);
        docType.setValue("<!DOCTYPE html>");

        Element el = new Element(ComponentMapper.getComponentName(com.jdadfapi.ui.component.core.View.class));
        com.jdadfapi.ui.component.core.View view = new com.jdadfapi.ui.component.core.View(el,null);
        view.setXmlnsF("http://java.sun.com/jsf/core");
        view.setXmlnsAf("http://xmlns.oracle.com/adf/faces/rich");
        document.setRootNode(el);

        com.jdadfapi.ui.component.layout.Document afDocument = new com.jdadfapi.ui.component.layout.Document();
        afDocument.setId("d1");

        int index = fullPath.lastIndexOf("\\");
        if(index == -1 ) index = fullPath.lastIndexOf("/");
        afDocument.setTitle( fullPath.substring(index+1));

        view.addChild(afDocument);
        Component messages = new Component(new Element("af:messages"), afDocument);
        messages.setId("m1");

        //TODO: DODAT af:messages
   //     Form form = new Form();
    //    form.setId("f1");

//        afDocument.addChild(form);

        return new Page(document, fullPath);
    }

    public PageDef createPageDef(){
        if(getPageDefinition() != null) return getPageDefinition();//throw new RuntimeException("Definion file za stranicu vec postoji");

        String filePath =  path.replace("public_html\\WEB-INF","adfmsrc").replace(".jsff","").replace(".jsf","")+"PageDef.xml";

        if(filePath.contains("\\public_html")){
            if(viewController == null) throw new RuntimeException("ViewController nije postavljen, nemore se saznat default package");
            String ph = "public_html";
            //int index = filePath.indexOf(ph);
            //String first = filePath.substring(0,index);
            //index += ph.length();
            //String second = filePath.substring(index);

          //  if(!first.endsWith("\\")) first += "\\";

            String defPackage = viewController.getDefaultPackage();
            if(defPackage== null)defPackage="";
            //"pageDefs" folder se more postavit u viewController-u, default je "pageDefs" ako ni nis posavljeno
            defPackage = defPackage.replace(".","\\")+"\\pageDefs";

            filePath = filePath.replace(ph, defPackage);

            //"pageDefs" folder se more postavit u viewController-u, default je "pageDefs" ako ni nis posavljeno
            //filePath =first+"adfmsrc\\"+defPackage+second; //filePath.replace("\\public_html","adfmsrc\\"); //hr\\istratech\\mish\\test\\view\\pageDefs");

        }

        File file = new File (filePath);
        FileUtils.checkOrCreateDirectory(file);

        try {
            if(!file.createNewFile())throw new RuntimeException("DATOTEKA VEC POSTOJI "+filePath);

            Document document = new Document();
            document.setVersion("1.0");
            document.setEncoding("UTF-8");
            Element pageDefinition = new Element(TagNames.PAGE_DEFINITION);
            document.setRootNode(pageDefinition);

            pageDef = new PageDef(this, document,filePath);
            pageDef.setXmlns("http://xmlns.oracle.com/adfm/uimodel");
            pageDef.setVersion("12.2.1.16.48");

            String temp = filePath.replace("\\",".").replace("/",".");


            temp = temp.replace(".xml", "");
            temp = temp.substring(temp.indexOf("adfmsrc.")+8);

            int dot = temp.lastIndexOf(".");


            pageDef.setId(temp.substring(dot+1));
            pageDef.setPackage(temp.substring(0,dot));



            return pageDef;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


      //  return null;
    }






    public < T extends Component> List <T> getComponents(Class<T> type){

      return  getRoot().getComponents(type);
    }
    public < T extends Component> List <T> getComponentsByTagName(String tagName){
        return getRoot().getComponentsByTagName(tagName);
    }

    public ViewController getViewController(){
        return viewController;
    }

    public void setViewController(ViewController viewController){
        this.viewController = viewController;
    }

    public List<TaskFlow> getTaskFlows(){
        if(viewController == null)throw new RuntimeException("Nije postavljen viewController");
        List<TaskFlow> taskFlows = new ArrayList<>();
    //    String simpleName = getSimpleName();
        String webContentPath = getWebContentPath();
        for(TaskFlow tf : viewController.getTaskFlows()){
           for(View view:  tf.getViews()){

                if(view.getPage().equals(webContentPath)){
                    taskFlows.add(tf);
                //    break;
                }

           }
        }
        return  taskFlows;
    }
    public String getName(){
        return name;
    }
    public String getSimpleName(){
        return name.replace(".jsff","").replace(".jsf","");
    }

    public PageDef getPageDefinition(){

        if(pageDef == null && viewController !=null){
            DataBindings dataBindings = viewController.getDataBindings();
            if(dataBindings!=null){
                DataBindingsPage pageMap =  dataBindings.findPageMapPageByPath(this.getWebContentPath());
                if(pageMap!=null){
                    DataBindingsPage pageDefinitionUsage = dataBindings.findPageDefinitionUsagePage(pageMap.getUsageId());
                    if(pageDefinitionUsage!=null){
/*
                        String defaultPath = viewController.getDefaultPackage();
                        if(defaultPath==null)defaultPath = "";
                        defaultPath = defaultPath.replace(".","\\");
*/
                        String dataBindingsPath = path.substring(0, path.indexOf("public_html"))+"adfmsrc\\";//+defaultPath+"\\";

//                        dataBindingsPath = dataBindingsPath.replace("\\\\","\\");

                        String pDefPath = dataBindingsPath + pageDefinitionUsage.getPath().replace(".","\\")+".xml";

                        File f = new File(pDefPath);

                        try {
                            Document defDoc = XMLParser.parse(f);
                            pageDef = new PageDef(this, defDoc,pDefPath);
                        } catch (IOException e) {

                            System.out.println("CANNOT PARSE PAGEDEF "+ pDefPath+"\n" + e.getMessage());
                        }

                    }
                }

            }
        }

        return pageDef;
    }
    public String getWebContentPath(){

        return "/"+path.substring(path.indexOf("public_html")+12).replace("\\","/");
    }

    public boolean isTemplate(){
        return getRoot() != null && getRoot().getTagName().equals(TagNames.PAGE_TEMPLATE_DEF);
    }
    public boolean isFragment(){
        return path.endsWith(".jsff");
    }

    public boolean hasPageTemplate(){
       return getPageTemplate()!=null;
    }

    public PageTemplate getPageTemplate(){
        /*
        if(root instanceof Composition){
            for(Component c : root.getChildren()){
                if(c instanceof PageTemplate)return (PageTemplate) c;

            }
        }
        else if(root instanceof com.jdadfapi.ui.component.core.View){
            List<com.jdadfapi.ui.component.layout.Document> documents =  root.getComponents(com.jdadfapi.ui.component.layout.Document.class);
            if(documents.isEmpty())return null;

            for(Component c :  documents.get(0).getChildren()){
                if(c instanceof PageTemplate)return (PageTemplate) c;
            }

        }
        // TODO: pageTemplate more imat page template
        return null;
        */
        if(root == null)return null;
       List<PageTemplate> pageTemplates = root.getComponents(PageTemplate.class);
       if(pageTemplates.isEmpty())return null;
       return pageTemplates.get(0);
    }


    public void setPageTemplate(Page pageTemplate){
        if(!pageTemplate.isTemplate())return;

        PageTemplate template = getPageTemplate();
        if(template == null){
            template = new PageTemplate();
            template.generateId();
            if(isFragment())
                root.addChild(template);
            else root.getComponents(com.jdadfapi.ui.component.layout.Document.class).get(0).addChild( template);

        }
        else{
            for(Component c : template.getChildren()){
                template.removeChild(c);
            }
        }
        template.setViewId(pageTemplate.getWebContentPath());


        List<CFacet> facets = pageTemplate.getComponents(CFacet.class);
        for(CFacet facet : facets){
            Facet f = new Facet(template);
            f.setName(facet.getFacetName());
        }

    }

    @Override
    public String toString() {
        return getName();
    }
}

