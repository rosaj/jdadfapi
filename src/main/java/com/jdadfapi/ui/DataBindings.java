package com.jdadfapi.ui;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLDocument;
import com.jdadfapi.model.applicationmodule.ApplicationModule;
import com.jdadfapi.ui.binding.Iterator;
import com.jdadfapi.ui.binding.PageDef;
import com.jdadfapi.ui.databindings.*;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.TagName;
import de.pdark.decentxml.Document;
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
 * Date: 08-Nov-17
 * Time: 21:33
 */

public class DataBindings extends XMLDocument {
/*
    List<PageMap> pageMaps = new ArrayList<>();
    List<PageDefinitionUsages> pageDefinitionUsages = new ArrayList<>();
    List<BC4JDataControl> bc4JDataControls ;
    */
    ViewController viewController;
    PageMap pageMap;
    PageDefinitionUsages pageDefinitionUsages;
    DataControlUsages dataControlUsages;

    public DataBindings(Document document, String path) {
        super(document, path);
        loadTree();
    }


    private void loadTree(){


        List<Node> nodes = element.getNodes();
        if(nodes != null && nodes.size()>0){
            for(Node node : nodes){
                if(node.getType().equals(XMLTokenizer.Type.ELEMENT)){
                    Element e = (Element) node;
                    switch (e.getName()){
                        case TagNames.PAGE_MAP                : resolvePageMap(e); break;
                        case TagNames.PAGE_DEFINITION_USAGES  : resolvePageDefinitionUsages(e); break;
                        case TagNames.DATA_CONTROL_USAGES     : resolveDataControlUsages(e); break;
                        default:log(e);
                    }
                }
            }
        }

    }


    private void resolvePageMap(Element e){
        pageMap = new PageMap(e);
        /*
        List<Element> pages = e.getChildren(TagNames.PAGE);
        if(!pages.isEmpty()){
            for(Element page : pages) pageMaps.add(new PageMap(page));
        }*/

    }
    private void resolvePageDefinitionUsages(Element e){
        pageDefinitionUsages = new PageDefinitionUsages(e);
        /*
        List<Element> pages = e.getChildren(TagNames.PAGE);
        if(!pages.isEmpty()){
            for(Element page : pages) pageDefinitionUsages.add(new PageDefinitionUsages(page));
        }*/

    }
    private void resolveDataControlUsages(Element e){
        dataControlUsages = new DataControlUsages(e);
    }

    public PageMap getPageMap() {
        return pageMap;
    }

    public PageDefinitionUsages getPageDefinitionUsages() {
        return pageDefinitionUsages;
    }

    public DataControlUsages getDataControlUsages() {
        return dataControlUsages;
    }

    public String getXmlns (){
        return getAttrValue(AttributeNames.XMLNS );
    }
    public void setXmlns (String value){
        setAttrValue(AttributeNames.XMLNS , value);
    }

    public String getSeparateXMLFiles (){
        return getAttrValue(AttributeNames.SEPARATE_XML_FILES );
    }
    public void setSeparateXMLFiles (String value){
        setAttrValue(AttributeNames.SEPARATE_XML_FILES , value);
    }

    public String getPackage (){
        return getAttrValue(AttributeNames.PACKAGE );
    }
    public void setPackage (String value){
        setAttrValue(AttributeNames.PACKAGE , value);
    }

    public String getVersion (){
        return getAttrValue(AttributeNames.VERSION );
    }
    public void setVersion (String value){
        setAttrValue(AttributeNames.VERSION , value);
    }

    public String getClientType (){
        return getAttrValue(AttributeNames.CLIENT_TYPE );
    }
    public void setClientType (String value){
        setAttrValue(AttributeNames.CLIENT_TYPE , value);
    }

    public String getPageMapClass (){
        return getAttrValue(AttributeNames.PAGE_MAP_CLASS );
    }
    public void setPageMapClass (String value){
        setAttrValue(AttributeNames.PAGE_MAP_CLASS , value);
    }

    public String getRootAMDefName (){
        return getAttrValue(AttributeNames.ROOT_AM_DEF_NAME );
    }
    public void setRootAMDefName (String value){
        setAttrValue(AttributeNames.ROOT_AM_DEF_NAME , value);
    }

    public String getErrorHandlerClass (){
        return getAttrValue(AttributeNames.ERROR_HANDLER_CLASS );
    }
    public void setErrorHandlerClass (String value){
        setAttrValue(AttributeNames.ERROR_HANDLER_CLASS , value);
    }

    public String getEventDispatcher (){
        return getAttrValue(AttributeNames.EVENT_DISPATCHER );
    }
    public void setEventDispatcher (String value){
        setAttrValue(AttributeNames.EVENT_DISPATCHER , value);
    }

    public String getBasePageDefPackageName (){
        return getAttrValue(AttributeNames.BASE_PAGE_DEF_PACKAGE_NAME );
    }
    public void setBasePageDefPackageName (String value){
        setAttrValue(AttributeNames.BASE_PAGE_DEF_PACKAGE_NAME , value);
    }


    /*
            private void addPage_Old(com.jdadfapi.ui.Page page){
                String id = page.getPageDefinition().getPackage()+"."+page.getPageDefinition().getId().replace(".","_");

                if(pageMaps != null){
                    if(findPageMap(id)!=null)return;

                }
                if(pageDefinitionUsages != null){
                    if(findPageDefinitionUsage(id) != null) return;
                }

                //TODO: definitionFactories : factory za region binding stranice

                List<Element> elements = element.getChildren(TagNames.PAGE_MAP);
                Element pageMap = null;
                if(elements == null || elements.size() == 0){
                    pageMap = new Element(TagNames.PAGE_MAP);
                    element.addNode(pageMap);
                }
                if(pageMap == null) pageMap = elements.get(0);

                elements = element.getChildren(TagNames.PAGE_DEFINITION_USAGES);
                Element pageDef = null;
                if(elements == null || elements.size() == 0){
                    pageDef = new Element(TagNames.PAGE_DEFINITION_USAGES);
                    element.addNode(pageDef);
                }
                if(pageDef == null) pageDef = elements.get(0);

                Element ePm = new Element(TagNames.PAGE);
                pageMap.addNode(ePm);
                PageMap pm = new PageMap(ePm);


                Element ePdu = new Element(TagNames.PAGE);
                pageDef.addNode(ePdu);

                PageDefinitionUsages pdu = new PageDefinitionUsages(ePdu);
                PageDef pageDefinition = page.getPageDefinition();

                pdu.setPath(pageDefinition.getPackage()+"."+pageDefinition.getId());
                pdu.setId(id);

                pm.setPath(page.getWebContentPath());
                pm.setUsageId(pdu.getId());

                pageDefinitionUsages.add(pdu);
                pageMaps.add(pm);


                if (bc4JDataControls == null) {
                    Element dcUsages = new Element(TagNames.DATA_CONTROL_USAGES);
                    element.addNode(dcUsages);
                    bc4JDataControls = new ArrayList<>();
                }

               List<String> amsToAdd = new ArrayList<>();

               for(Iterator iter : page.getPageDefinition().getExecutables().getIterators()){
                   String dataControl = iter.getDataControl();
                   boolean exist = false;

                   for(BC4JDataControl dc : bc4JDataControls ){

                       if(dc.getId().equals(dataControl)){
                          exist = true;
                          break;
                       }
                   }
                   if(!exist){
                       if(!amsToAdd.contains(dataControl)) amsToAdd.add(dataControl);
                   }

               }

               if(amsToAdd.isEmpty())return;

               //Am ne postoji i triba inicializirat



                elements = element.getChildren(TagNames.DATA_CONTROL_USAGES);
                Element dcUsages = elements.get(0);

                for(String dataControl : amsToAdd) {

                    Element e = new Element(TagNames.BC4J_DATA_CONTROL);
                    dcUsages.addNode(e);

                    BC4JDataControl dc = new BC4JDataControl(e);

                    dc.setConfiguration(dataControl.replace("DataControl", "Local"));
                    dc.setFactoryClass("oracle.adf.model.bc4j.DataControlFactoryImpl");
                    dc.setSupportsFindMode("true");
                    dc.setSupportsRangesize("true");
                    dc.setSupportsResetState("true");
                    dc.setSupportsSortCollection("true");
                    dc.setSupportsTransactions("true");
                    dc.setId(dataControl);
                    dc.setSyncMode("Immediate");
                    dc.setXmlns("http://xmlns.oracle.com/adfm/datacontrol");

                    String amName = dataControl.replace("DataControl","");
                    ApplicationModule am = viewController
                                                        .getWorkspace()
                                                        .getModel()
                                                        .getApplicationModule(amName);

                    if(am == null) throw new RuntimeException("Unable to locate application module " + amName);



                    dc.setPackage(am.getPackage());

                    bc4JDataControls.add(dc);
                }

            }
            */
    public boolean addPage(Page page){
        PageDef pageDef = page.getPageDefinition();
        String id = generateId(page);

        // mozda da se provjeri am-s i regije dali triba dodat u databindings
        if(containsPage(page)){
            return checkDataControlUsages(page) || checkDefinitionFactories(page);
        }

        ensurePageMap();
        ensurePageDefinitionUsages();

        pageDefinitionUsages.addPage(id, pageDef.getPackage() + "." + pageDef.getId());
        pageMap.addPage(id, page.getWebContentPath());

        checkDataControlUsages(page);
        checkDefinitionFactories(page);
        return true;
    }
    public boolean checkDataControlUsages(Page page){
       return ensureDataControlUsages().addBC4JDataControlIfNeeded(page, viewController.getWorkspace().getModel());
    }

    public boolean checkDefinitionFactories(Page page){
        return false;
    }
    private PageMap ensurePageMap(){
        if(pageMap == null){
            resolvePageMap(ensureChildElement(TagNames.PAGE_MAP));
        }

        return pageMap;
    }
    private PageDefinitionUsages ensurePageDefinitionUsages(){
        if(pageDefinitionUsages == null){
            resolvePageDefinitionUsages(ensureChildElement(TagNames.PAGE_DEFINITION_USAGES));
        }
        return pageDefinitionUsages;
    }
    private DataControlUsages ensureDataControlUsages(){
        if(dataControlUsages == null){
            resolveDataControlUsages(ensureChildElement(TagNames.DATA_CONTROL_USAGES));
        }
        return dataControlUsages;
    }
    private Element ensureChildElement(String tag){
        List<Element> elements = element.getChildren(tag);
        if(elements == null || elements.size() == 0){
            return addChildElement(tag);
        }

        return element.getChildren(tag).get(0);
    }

    public boolean containsPage(Page page){
        String id = generateId(page);
        DataBindingsPage dataBindingsPage = findPageMapPage(id);
        if(page == null) dataBindingsPage = findPageDefinitionUsagePage(id);
        return dataBindingsPage != null;
    }

    private String generateId(Page page){
        PageDef pageDef = page.getPageDefinition();
        String id = (pageDef.getPackage()+"."+pageDef.getId()).replace(".","_");
        return id;
    }
    public DataBindingsPage findPageMapPage(String id){
        return pageMap == null ? null : pageMap.findPage(id);

    }
    public DataBindingsPage findPageMapPageByPath(String webContent){
        return pageMap == null ? null : pageMap.findPageByPath(webContent);
    }
    public DataBindingsPage findPageDefinitionUsagePage(String id){
        return pageDefinitionUsages == null ? null : pageDefinitionUsages.findPage(id);
    }


    public ViewController getViewController() {
        return viewController;
    }

    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }



}
/*

 List<Element> elements = element.getChildren(TagNames.PAGE_MAP);
      if(elements != null && elements.size()>0){
          for(Element e : elements) pageMaps.add(new PageMap(e));
      }

      elements = element.getChildren(TagNames.PAGE_DEFINITION_USAGES);
      if(elements != null && elements.size()>0){
        for(Element e : elements) pageDefinitionUsages.add(new PageDefinitionUsages(e));
      }



      elements = element.getChildren(TagNames.DATA_CONTROL_USAGES);
        if(elements != null && elements.size()>0){
            bc4JDataControls = new ArrayList<>();
            elements = elements.get(0).getChildren(TagNames.BC4J_DATA_CONTROL);

            if(elements != null && elements.size()>0) {
                for (Element e : elements) bc4JDataControls.add(new BC4JDataControl(e));
            }
        }

 */