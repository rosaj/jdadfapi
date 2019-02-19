package com.jdadfapi.model;

import com.jdadfapi.TagNames;
import com.jdadfapi.model.applicationmodule.ApplicationModule;
import com.jdadfapi.model.common.Item;
import com.jdadfapi.model.entity.Attribute;
import com.jdadfapi.model.entity.Entity;
import com.jdadfapi.model.entity.association.Association;
import com.jdadfapi.model.entity.association.AssociationEnd;
import com.jdadfapi.model.resourceboundle.ResourceBundle;
import com.jdadfapi.model.view.EntityUsage;
import com.jdadfapi.model.view.ViewAttribute;
import com.jdadfapi.model.view.ViewObject;
import com.jdadfapi.model.view.viewlink.ViewLink;
import com.jdadfapi.model.view.viewlink.ViewLinkDefEnd;
import de.pdark.decentxml.Document;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.XMLParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Nov-17
 * Time: 10:56
 */

public class Model {

    private List<Entity> entities;
    private List<ViewObject> viewObjects;
    private List<ApplicationModule> ams;
    private List<ResourceBundle> resourceBundles;
    private List<Association> associations;
    private List<ViewLink> viewLinks;
    String path;
    private Document jpr;

    private static final String REG_EX = "ABCDEFGHIJKLMNJOPRSTUVZYX";

    /*
        public Model(String path,List<Entity> entities,
                     List<ViewObject> viewObjects,
                     List<ApplicationModule> ams,
                     List<ResourceBundle> resourceBundles,
                     List<Association> associations,
                     List<ViewLink> viewLinks) {
            this.entities = entities;
            this.viewObjects = viewObjects;
            this.ams = ams;
            this.resourceBundles = resourceBundles;
            this.associations = associations;
            this.viewLinks = viewLinks;
            this.path = path;

        }
    */
    public Model(String path) {
        this.path = path;
    }



    public static Model loadModel(String path) {
        File f = new File(path);
        File ph = null;
        Document jpr = null;
        for (File file : f.listFiles()) {
            if (file.getName().equals("src")) ph = file;
            else  if (file.getName().endsWith(".jpr")){
                try {
                    jpr = XMLParser.parse(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        List<Entity> entities = new ArrayList<>();
        List<ViewObject> viewObjects = new ArrayList<>();
        List<ApplicationModule> ams = new ArrayList<>();
        List<ResourceBundle> resourceBundles = new ArrayList<>();
        List<Association> associations = new ArrayList<>();
        List<ViewLink> viewLinks = new ArrayList<>();

        Model model = new Model(path);
        recursive(ph, entities, viewObjects, ams, resourceBundles, associations,viewLinks, model);


      //  Model model = new Model(path, entities, viewObjects, ams, resourceBundles, associations, viewLinks);
        model.entities = entities;
        model.viewObjects = viewObjects;
        model.ams = ams;
        model.resourceBundles = resourceBundles;
        model.associations = associations;
        model.viewLinks = viewLinks;
        model.jpr = jpr;
        return model;
    }

    private static void recursive(File f, List<Entity> entities,
                                  List<ViewObject> viewObjects,
                                  List<ApplicationModule> ams,
                                  List<ResourceBundle> resourceBundles,
                                  List<Association> associations,
                                  List<ViewLink> viewLinks, Model model) {
        if (f.listFiles() == null) return;

        for (File file : f.listFiles()) {
            if (file.isFile()) {
                if (file.getName().endsWith(".xml")) {

                    try {
                        Document document = XMLParser.parse(file);
                        switch (document.getRootElement().getName()) {
                            case TagNames.APPLICATION_MODULE:
                                ams.add(new ApplicationModule(document, file.getAbsolutePath(),model));
                                break;
                            case TagNames.VIEW_OBJECT:
                                viewObjects.add(new ViewObject(document, file.getAbsolutePath(),model));
                                break;
                            case TagNames.ENTITY:
                                entities.add(new Entity(document, file.getAbsolutePath(),model));
                                break;
                            case TagNames.ASSOCIATION:
                                associations.add(new Association(document, file.getAbsolutePath(),model));
                                break;
                            case TagNames.VIEW_LINK:
                                viewLinks.add(new ViewLink(document, file.getAbsolutePath(),model));
                                break;
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (file.getName().endsWith(".properties")) resourceBundles.add(new ResourceBundle(file));
            }
            recursive(file, entities, viewObjects, ams, resourceBundles,associations,viewLinks, model);
        }
    }

    public Entity getEntity(String name) {
        for (Entity en : entities) {
            if (name.equals(en.getName())) return en;
        }

        return null;
    }

    public ViewObject getViewObject(String name) {
        for (ViewObject vo : viewObjects) {
            if (name.equals(vo.getName())) return vo;
        }

        return null;
    }

    public ApplicationModule getApplicationModule(String name) {
        for (ApplicationModule am : ams) {
            if (name.equals(am.getName())) return am;
        }

        return null;
    }
    public Association getAssociation(String name){
        for(Association a : associations){
            if(name.equals(a.getName())) return a;
        }
        return  null;
    }
    public ViewLink getViewLink(String name){
        for(ViewLink v : viewLinks){
            if(name.equals(v.getName()))return v;
        }
        return null;
    }
    public List<ApplicationModule> getApplicationModules() {
        return ams;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<ViewObject> getViewObjects() {
        return viewObjects;
    }

    public List<ResourceBundle> getResourceBundles() {
        return resourceBundles;
    }

    public List<Association> getAssociations() {
        return associations;
    }

    public List<ViewLink> getViewLinks() {
        return viewLinks;
    }

    public String getPath() {
        return path;
    }


    public ViewObject createViewObject(String path, String name, ViewObject.Type type){
        String temp = getPath()+"\\src\\";
        if(!temp.endsWith("\\"))temp+="\\";

        ViewObject vo = ViewObject.createViewObject(this, temp + path, name, type);
        vo.setLabel(vo.getPackage() + "." + vo.getName() + "_LABEL");





        ResourceBundle bundle = getResourceBundles().get(0);
        vo.setResourceBundle(getDefaultPackage()+"."+ bundle.getName());

        addNameToBundle(bundle, name, vo.getLabel());

        vo.save();
        viewObjects.add(vo);

        return vo;
    }

    public ViewObject createSQLViewObject(String path, String name, String sql){
        ViewObject vo = createViewObject(path, name, ViewObject.Type.SQL);
        vo.setSqlQuery(sql);
        List<String> names = extractSqlColumnNames(sql);

        for (String s : names) {
            String attrName = s.toLowerCase();
            String vAname = "";
            for(String n : attrName.split("_")){
                vAname += n.substring(0, 1).toUpperCase() + n.substring(1);
                s = s.toUpperCase();
                ViewAttribute va = vo.addViewAttribute(vAname);
                va.setAliasName(s);
                va.setExpression(s);
            }

        }


        return vo;
    }


    public  ViewObject createEntitysViewObject(String path, String name, Entity mainEntity, List<Entity> refEntitys){
        ViewObject vo = createViewObject(path, name, ViewObject.Type.Entity);

        EntityUsage mainEntityUsage = vo.addEntityUsage(mainEntity);
        for (Attribute attribute : mainEntity.getAttributes()) {
            vo.addViewAttribute(attribute,mainEntityUsage);
        }
        if(refEntitys != null){
            for (Entity refEntity : refEntitys) {
                EntityUsage eu = vo.addEntityUsage(refEntity);

                Association assoc = findAssociationForEntityUsage(this, mainEntity, refEntity);
                if(assoc == null ) assoc = findAssociationForEntityUsage(mainEntity.getModel(), mainEntity, refEntity);
                if(assoc == null ) assoc = findAssociationForEntityUsage(refEntity.getModel(), mainEntity, refEntity);
                if(assoc == null)
                    throw new RuntimeException("Association for " + mainEntity + ", " + refEntity + " not found!");

                eu.setAssociation(assoc.getPackagedName());
                eu.setAssociationEnd(eu.getAssociation()+"."+assoc.getByOwner(refEntity.getPackagedName()).getName());
                eu.setSourceUsage(vo.getPackagedName() + "." + mainEntityUsage.getName());

                for (Item item : assoc.getByOwner(refEntity.getPackagedName()).getAttributes()) {
                    eu.addDstAttribute(item.getValue());
                }

                String join = "INNER JOIN";

                for (Item item : assoc.getByOwner(mainEntity.getPackagedName()).getAttributes()) {
                    eu.addSrcAttribute(item.getValue());
                    String attrName = item.getValue();
                    if(attrName.contains(".")) attrName = attrName.substring(attrName.lastIndexOf(".") + 1);
                    if(!"true".equals(mainEntity.getAttribute(attrName).getIsNotNull())) join = "LEFT OUTER JOIN";

                }

                eu.setReadOnly("true");
                eu.setReference("true");
                eu.setDeleteParticipant("false");
                eu.setJoinType(join);
            }
        }


        for (Attribute attribute : mainEntity.getAttributes()) {
            if ("true".equals(attribute.getPrimaryKey())) {
                vo.addKeyAttribute(attribute.getName());
            }
        }

        vo.save();
        return vo;
    }


    private Association findAssociationForEntityUsage(Model model, Entity mainEntity, Entity refEntity){
      //  System.out.println("FIND ASSOC:" +model.path+", "+mainEntity+" : "+refEntity);
        String mainOwner = mainEntity.getPackage();
        if(mainOwner == null || mainOwner.trim().isEmpty()) mainOwner = mainEntity.getName();
        else mainOwner += "." + mainEntity.getName();


        String refOwner = refEntity.getPackage();
        if(refOwner == null || refOwner.trim().isEmpty()) refOwner = refEntity.getName();
        else refOwner += "." + refEntity.getName();
        //System.out.println("MAIN OWNER "+mainOwner);
       // System.out.println("REF OWNER "+refOwner);
        for (Association association : model.getAssociations()) {
            AssociationEnd assocEnd = association.getByOwner(refOwner);
            if (assocEnd != null && "true".equals(assocEnd.getSource()) && association.getByOwner(mainOwner)!=null  ) {
                return association;
            }
        }


        return null;
    }


    public ViewLink createViewLink(String path,String name, Association association, ViewObject vo1, ViewObject vo2){

        String temp = getPath()+"\\src\\";
        if(!temp.endsWith("\\"))temp+="\\";

        ViewLink viewLink = ViewLink.createViewLink(this, temp+path,name);

        viewLink.setEntityAssociation(association.getPackage() + "." + association.getName());
        viewLink.setLabel(viewLink.getPackage() + "." + viewLink.getName() + "_LABEL");

        ViewLinkDefEnd defEnd = viewLink.createViewLinkDefEnd();
        ViewLinkDefEnd otherDefEnd = viewLink.createOtherViewLinkDefEnd();

        AssociationEnd assocEnd = association.getAssociationEnd();
        AssociationEnd otherAssocEnd = association.getOtherAssociationEnd();
        cloneAssocEndToViewEnd(assocEnd, defEnd,vo1);
        cloneAssocEndToViewEnd(otherAssocEnd, otherDefEnd,vo2);
        ResourceBundle bundle = getResourceBundles().get(0);

        String defaultPackage = getDefaultPackage();
        viewLink.setResourceBundle(defaultPackage+"."+ bundle.getName());

        addNameToBundle(bundle, name, viewLink.getLabel());
        viewLink.save();

        viewLinks.add(viewLink);
        return viewLink;
    }

    private void addNameToBundle(ResourceBundle bundle, String name, String key){

        for (int pos = 0; pos < REG_EX.length(); pos++) {
            String ch = REG_EX.charAt(pos) + "";
            name = name.replace(ch, " " + ch);
        }
        name = name.trim();

        bundle.setText(key, name);
        bundle.save();
    }

    private void cloneAssocEndToViewEnd(AssociationEnd assocEnd, ViewLinkDefEnd defEnd, ViewObject viewObject){
        defEnd.setName(assocEnd.getName());
        defEnd.setCardinality(assocEnd.getCardinality());
        defEnd.setSource(assocEnd.getSource());
        defEnd.setOwner(viewObject.getPackage()+"."+viewObject.getName());
        defEnd.isUpdatable(assocEnd.isUpdatable());
        defEnd.setFinderName(assocEnd.getFinderName());
        for (Item item : assocEnd.getAttributes()) {
            defEnd.addAttributes(item.getValue());
        }

    }
    public String getDefaultPackage(){
        return getDefaultPackage(jpr);

    }

    public static String getDefaultPackage(Document jpr){
        if(jpr == null)return null;
        List<Element> values = jpr.getRootElement().getChildren("value");
        if(values.size()==0 )return null;

        for(Element e : values){
            if("defaultPackage".equals(e.getAttributeValue("n")))return e.getAttributeValue("v");
        }
        return null;
    }

    private String getValue(String name){
        if(jpr == null)return null;
        List<Element> values = jpr.getRootElement().getChildren("value");
        if(values.size()==0 )return null;

        for(Element e : values){
            if(name.equals(e.getAttributeValue("n")))return e.getAttributeValue("v");
        }
        return null;
    }

    public String getDefaultRowImplClass(){
        String rowClass = getValue("oracle.jbo.extends.viewRow");
        if(rowClass != null)return rowClass;
        return "oracle.jbo.server.ViewRowImpl";
    }
    public String getDefaultViewObjectImplClass(){
        String voClass = getValue("oracle.jbo.extends.viewObj");
        if(voClass != null)return voClass;
        return "oracle.jbo.server.ViewObjectImpl";
    }
    public String getDefaultViewObjectDefClass(){
        String defClass = getValue("oracle.jbo.extends.viewDef");
        if(defClass != null)return defClass;
        return "oracle.jbo.server.ViewDefImpl";
    }


    public static List<String> extractSqlColumnNames(String query){
        query = query.toLowerCase().replaceAll("  ", " ").replaceAll(" ,",",");


        query = query.substring(query.indexOf("select") + 6, query.lastIndexOf("from"));

        int bracket = query.indexOf("(");
        Stack<Character> stack = new Stack<>();
        while(bracket > -1){
            for(int i = bracket; i< query.length(); i++){
                char c = query.charAt(i);
                if(c == '(') stack.push('(');
                else if(c == ')') stack.pop();
                if(stack.isEmpty()){
                    query = query.substring(0,bracket)+query.substring(i+1);
                    bracket = query.indexOf("(");
                    break;
                }
            }

        }

        String[] cols = query.split(",");

        List<String> names = new ArrayList<>();
        for(String name : cols){
            name  = name.trim();
            int index = name.lastIndexOf(" ");
            if(index > -1) name = name.substring(index);
            names.add(name.trim());
        }


       /*
        Pattern p = Pattern.compile("\\s*\\w+,");
        Pattern p1 = Pattern.compile("\\s+\\w+\\s+from");
        Matcher m = p.matcher(query);
        Matcher m1 = p1.matcher(query);
        String colsOnly="";
        while(m.find()){colsOnly+=(m.group().trim());
            System.out.println(m.group());}
        while(m1.find()){
            System.out.println("m1: "+m1.group());
            colsOnly+=(m1.group().substring(0,m1.group().length()-4).trim());}
        String[] cols = colsOnly.split(",");

        */
        return names;
    }

}
