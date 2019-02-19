package com.jdadfapi.model.view;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.FileUtils;
import com.jdadfapi.TagNames;
import com.jdadfapi.model.common.AttrArray;
import com.jdadfapi.model.Model;
import com.jdadfapi.model.entity.Entity;
import com.jdadfapi.model.entity.Attribute;
import com.jdadfapi.model.common.Item;
import com.jdadfapi.model.common.NamedModelDocument;
import com.jdadfapi.model.view.viewlink.ViewLink;
import com.jdadfapi.model.view.viewlink.ViewLinkDefEnd;
import de.pdark.decentxml.*;
import de.pdark.decentxml.dtd.DocType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Nov-17
 * Time: 10:12
 */

public class ViewObject extends NamedModelDocument {
    //TODO: Dodat sve ostale
    private static final String[] TAG_ORDER = {
            TagNames.DESIGN_TIME,
            TagNames.PROPERTIES,
            TagNames.VARIABLE,
            TagNames.VIEW_ACCESSOR,
            TagNames.SQL_QUERY,
            TagNames.LIST_BINDING,
            TagNames.ENTITY_USAGE,
            TagNames.VIEW_ATTRIBUTE,
            TagNames.ATTR_ARRAY,
            TagNames.VIEW_LINK_ACCESSOR,
            TagNames.CLIENT_ROW_INTERFACE,
            TagNames.RESOURCE_BUNDLE,
            TagNames.SORT_CRITERIA
    };

    static DocType viewObjectDocType;
    static{

        /*
        <!DOCTYPE ViewObject SYSTEM "jbo_03_01.dtd">
        <!---->
         */
        viewObjectDocType = new DocType();
        viewObjectDocType.setDocTypeType(DocType.DocTypeType.SYSTEM);
        viewObjectDocType.setName(TagNames.VIEW_OBJECT);
        viewObjectDocType.setSystemLiteral("jbo_03_01.dtd");
    //    System.out.println(viewObjectDocType.toString());
    }

    public enum Type{
        Entity,
        Programatic,
        SQL,
        StaticList
    }

    private List<ViewAttribute> viewAttributes = new ArrayList<>();
    private List<ListBinding> listBindings = new ArrayList<>();
    private List<ViewAccessor> viewAccessors = new ArrayList<>();
    private List<ViewLinkAccessor> viewLinkAccessors = new ArrayList<>();
    private List<EntityUsage> entityUsages = new ArrayList<>();
    private List<Variable> variables = new ArrayList<>();
    private List<ViewCriteria> viewCriterias = new ArrayList<>();
    private LOVUIHints lovuiHints;
    private AttrArray keyAttributes;
    private SQLQuery sqlQuery;

    public ViewObject(Document document, String path, Model model) {
        super(document, path,model);
        loadTree();

    }
/*
    private static ViewObject load(String path) {
        ViewObject viewObject = null;
        try {
            Document doc = XMLParser.parse(new File(path));
            viewObject = new ViewObject(doc, path);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return viewObject;
    }
*/
    private void loadTree() {

        for (Node n : document.getRootElement().getNodes()) {
            if (n.getType().equals(XMLTokenizer.Type.ELEMENT)) {
                Element e = (Element) n;
                switch (e.getName()) {
                    case TagNames.VIEW_ACCESSOR     : resolveViewAccessor(e);break;
                    case TagNames.LIST_BINDING      : resolveListBinding(e);break;
                    case TagNames.ENTITY_USAGE      : resolveEntityUsage(e);break;
                    case TagNames.VIEW_ATTRIBUTE    : resolveViewAttribute(e);break;
                    case TagNames.ATTR_ARRAY        : resolveAttrArray(e);break;
                    case TagNames.RESOURCE_BUNDLE   : resolveResourceBundle(e);break;
                    case TagNames.PROPERTIES        : resolveProperties(e);break;
                    case TagNames.SORT_CRITERIA     : resolveSortCriteria(e);break;
                    case TagNames.LOV_UI_HINTS      : resolveLOVUIHints(e);break;
                    case TagNames.VARIABLE          : resolveVariable(e); break;
                    case TagNames.SQL_QUERY         : resolveSQLQuery(e); break;
                    case TagNames.VIEW_CRITERIA     : resolveViewCriteria(e); break;
                    default:log(e);
                }
            }
        }

    }

    private void resolveViewCriteria(Element e) {
        viewCriterias.add(new ViewCriteria(e));
    }


    private void resolveViewAccessor(Element e) {
        viewAccessors.add(new ViewAccessor(e));
    }

    private void resolveListBinding(Element e) {
        listBindings.add(new ListBinding(e));
    }

    private void resolveEntityUsage(Element e) {
        entityUsages.add(new EntityUsage(e));
    }

    private void resolveViewAttribute(Element e) {
        viewAttributes.add(new ViewAttribute(e));
    }

    private void resolveAttrArray(Element e) {
        AttrArray attrArray = new AttrArray(e);
       if(AttributeNames.KEY_ATTRIBUTES.equals(attrArray.getName())){
           keyAttributes = attrArray;
       }
       //TODO: ELSE OTHER ATTRARRAY AKO IMA
    }


    private void resolveSortCriteria(Element e) {
        //TODO: SORT CRITERIA
    }

    private void resolveLOVUIHints(Element e) {
        lovuiHints = new LOVUIHints(e);
    }


    private void resolveVariable(Element e) {
        variables.add(new Variable(e));
    }

    private void resolveSQLQuery(Element e){
        sqlQuery = new SQLQuery(e);
    }

    public boolean hasLOVUIHints() {
        return lovuiHints != null;
    }

    public LOVUIHints getLOVUIHints() {
        return lovuiHints;
    }

    public List<ViewAttribute> getViewAttributes() {
        return viewAttributes;
    }

    public List<ListBinding> getListBindings() {
        return listBindings;
    }

    public String getSqlQuery() {
        return sqlQuery == null ? null: sqlQuery.getSql();
    }
    public void setSqlQuery(String value){
        if(sqlQuery == null) sqlQuery = new SQLQuery(insertNewElement(TagNames.SQL_QUERY));
        sqlQuery.setSql(value);
    }

    public AttrArray getKeyAttributes() {
        return keyAttributes;
    }
    public void addKeyAttribute(String name){
        if(keyAttributes == null){
/*            Element e = new Element(TagNames.ATTR_ARRAY);

            int index = getLastIndexOfElement(TagNames.ATTR_ARRAY, TAG_ORDER)+1;
            element.addNode(index, e);
            */
            keyAttributes = new AttrArray(insertNewElement(TagNames.ATTR_ARRAY));
            keyAttributes.setName(AttributeNames.KEY_ATTRIBUTES);
        }
        keyAttributes.addItem(name);
    }
    public void removeKeyAttribute(String name){
        if(keyAttributes != null) keyAttributes.removeItem(name);
    }

    public ViewAccessor createViewAccessor(ViewObject lovVO) {
/*
        int index =  getLastIndexOfElement(TagNames.VIEW_ACCESSOR, TAG_ORDER);

        if (!viewAccessors.isEmpty()) index = getLastIndexOf(TagNames.VIEW_ACCESSOR);
        else if (hasProperties()) index = getLastIndexOf(TagNames.PROPERTIES);
        else if (hasDesignTime()) index = getLastIndexOf(TagNames.DESIGN_TIME);

        Element e = new Element(TagNames.VIEW_ACCESSOR);

        element.addNode(++index, e);*/
        ViewAccessor viewAccessor = new ViewAccessor(insertNewElement(TagNames.VIEW_ACCESSOR));
        viewAccessor.setName(lovVO.getName());
        viewAccessor.setViewObjectName(lovVO.getPackage() + "." + lovVO.getName());
        viewAccessor.setRowLevelBinds("true");

        viewAccessors.add(viewAccessor);
        return viewAccessor;
    }
    public ViewLinkAccessor createViewLinkAccessor(ViewLink viewLink){
  /*
        int index = getLastIndexOfElement(TagNames.VIEW_LINK_ACCESSOR, TAG_ORDER);

        Element e = new Element(TagNames.VIEW_LINK_ACCESSOR);
        element.addNode(++index, e);
*/
        ViewLinkAccessor viewLinkAccessor = new ViewLinkAccessor(insertNewElement(TagNames.VIEW_LINK_ACCESSOR));

        String owner = getPackagedName();
        ViewLinkDefEnd defEnd = viewLink.getViewLinkDefEnd();
        if(owner.equals(defEnd.getOwner()))defEnd = viewLink.getOtherViewLinkDefEnd();

        viewLinkAccessor.setName(defEnd.getName());
        viewLinkAccessor.setViewLink(viewLink.getPackage() + "." + viewLink.getName());
        if(defEnd.getCardinality().equals("-1"))viewLinkAccessor.setType("oracle.jbo.RowIterator");
        else {
            viewLinkAccessor.setType(getModel().getDefaultRowImplClass());
            viewLinkAccessor.setReversed("true");
            defEnd.setAccessor("true");
        }

        viewLinkAccessor.setIsUpdateable("false");

        viewLinkAccessors.add(viewLinkAccessor);

        return viewLinkAccessor;
    }

    public List<ViewCriteria> getViewCriterias() {
        return viewCriterias;
    }

    public List<ViewAccessor> getViewAccessors() {
        return viewAccessors;
    }

    public List<ViewLinkAccessor> getViewLinkAccessors() {
        return viewLinkAccessors;
    }

    public ViewAttribute getViewAttribute(String name) {
        for (ViewAttribute viewAttribute : viewAttributes) {
            if (viewAttribute.getName().equals(name)) return viewAttribute;
        }
        return null;
    }

    public ListBinding getListBinding(String name) {
        for (ListBinding listBinding : listBindings) {
            if (listBinding.getName().equals(name)) return listBinding;
        }
        return null;
    }

    public ListBinding createListBinding(ViewAccessor viewAccessor, ViewAttribute viewAttribute, ViewObject lovVO) {

     /*   Element e = new Element(TagNames.LIST_BINDING);

        int index = getLastIndexOfElement(TagNames.LIST_BINDING, TAG_ORDER);

        if (!listBindings.isEmpty()) index = getLastIndexOf(TagNames.LIST_BINDING);

        else if (!getViewAccessors().isEmpty()) index = getLastIndexOf(TagNames.VIEW_ACCESSOR);
        else if (hasProperties()) index = getLastIndexOf(TagNames.PROPERTIES);
        else if (hasDesignTime()) index = getLastIndexOf(TagNames.DESIGN_TIME);

        element.addNode(++index, e);*/

        ListBinding listBinding = new ListBinding(insertNewElement(TagNames.LIST_BINDING));

        listBinding.createAttrNames().addItem(viewAttribute.getName());
        listBinding.createAttrExpressions();
        listBinding.createDerivedAttrNames();
        listBinding.createListAttrNames();
        listBinding.createListDisplayAttrNames();

        listBinding.setName("LOV_" + viewAttribute.getName());
        listBinding.setListVOName(viewAccessor.getName());
        listBinding.setListRangeSize("10");


        viewAttribute.setLOVName(listBinding.getName());

        viewAttribute.setControlType("choice");

        if (lovVO.hasLOVUIHints()) {

            LOVUIHints lovuiHints = lovVO.getLOVUIHints();

            String val;

            val = lovuiHints.getListRangeSize();
            if (val != null) listBinding.setListRangeSize(val);

            val = lovuiHints.getComboRowCountHint();
            if (val != null) listBinding.setComboRowCountHint(val);

            val = lovuiHints.getNullValueFlag();
            if (val != null) listBinding.setNullValueFlag(val);

            val = lovuiHints.getMRUCount();
            if (val != null) listBinding.setMRUCount(val);

            if (lovuiHints.hasListDisplayAttrNames()) {
                List<Item> items = lovuiHints.getListDisplayAttrNames().getItems();
                if (!items.isEmpty()) {
                    AttrArray displayNames = listBinding.getListDisplayAttrNames();
                    for (Item i : items) {
                        displayNames.addItem(i.getValue());
                    }
                }

            }
            viewAttribute.setControlType(resolveComponent(lovuiHints.getListType()));

        }

        listBinding.createDisplayCriteria();
        listBindings.add(listBinding);
        return listBinding;
    }

    public Variable createVariable(String name, String kind, String type) {
  /*      Element e = new Element(TagNames.VARIABLE);

        int index = getLastIndexOfElement(TagNames.VARIABLE, TAG_ORDER)+1;
        element.addNode(index, e);
*/
        Variable variable = new Variable(insertNewElement(TagNames.VARIABLE));

        variable.setName(name);
        variable.setKind(kind);
        variable.setType(type);

        variables.add(variable);
        return variable;

    }


    public ViewAccessor getViewAccessor(String name) {
        for (ViewAccessor viewAccessor : viewAccessors) {
            if (viewAccessor.getName().equals(name)) return viewAccessor;
        }
        return null;
    }
    public ViewLinkAccessor getViewLinkAccessor(String name){
        for (ViewLinkAccessor viewLinkAccessor: viewLinkAccessors) {
            if (viewLinkAccessor.getName().equals(name)) return viewLinkAccessor;
        }
        return null;
    }
    public List<EntityUsage> getEntityUsages() {
        return entityUsages;
    }

    public EntityUsage getEntityUsage(String name) {
        for (EntityUsage eu : entityUsages) {
            if (eu.getName().equals(name)) return eu;
        }
        return null;
    }

    public List<Variable> getVariables() {
        return variables;
    }
    public Variable getVariable(String name) {

        for (Variable v : variables) {
            if(name.equals(v.getName())) return v;
        }

        return null;
    }

    /*
    private int getLastIndexOf(String name) {
        List<Element> elements = element.getChildren(name);
        if (elements.isEmpty()) return 0;
        return element.nodeIndexOf(elements.get(elements.size() - 1));
    }*/

    private String resolveComponent(String code) {
        if ("105".equals(code)) return "choice";
        else if ("109".equals(code)) return "combo";
        else if ("113".equals(code)) return "combo_lov";
        else if ("108".equals(code)) return "input_text_lov";
        else if ("114".equals(code)) return "list";
        else if ("111".equals(code)) return "radio";
        return "choice";

    }



    public String getExtends() {
        return getAttrValue(AttributeNames.EXTENDS);
    }
    public String getExtendsSimple(){
        return getSimple(getExtends());
    }
    public String getComponentClass (){
        return getAttrValue(AttributeNames.COMPONENT_CLASS );
    }
    public void setComponentClass (String value){
        setAttrValue(AttributeNames.COMPONENT_CLASS , value);
    }

    public String getOrderBy (){
        return getAttrValue(AttributeNames.ORDER_BY );
    }
    public void setOrderBy (String value){
        setAttrValue(AttributeNames.ORDER_BY , value);
    }

    public String getBindingStyle (){
        return getAttrValue(AttributeNames.BINDING_STYLE );
    }
    public void setBindingStyle (String value){
        setAttrValue(AttributeNames.BINDING_STYLE , value);
    }

    public String getCustomQuery (){
        return getAttrValue(AttributeNames.CUSTOM_QUERY );
    }
    public void setCustomQuery (String value){
        setAttrValue(AttributeNames.CUSTOM_QUERY , value);
    }

    public String getRowClass (){
        return getAttrValue(AttributeNames.ROW_CLASS );
    }
    public void setRowClass (String value){
        setAttrValue(AttributeNames.ROW_CLASS , value);
    }

    public String getDefClass (){
        return getAttrValue(AttributeNames.DEF_CLASS );
    }
    public void setDefClass (String value){
        setAttrValue(AttributeNames.DEF_CLASS , value);
    }

    public String getFetchMode (){
        return getAttrValue(AttributeNames.FETCH_MODE );
    }
    public void setFetchMode (String value){
        setAttrValue(AttributeNames.FETCH_MODE , value);
    }

    public String getFetchSize (){
        return getAttrValue(AttributeNames.FETCH_SIZE_UPPER );
    }
    public void setFetchSize (String value){
        setAttrValue(AttributeNames.FETCH_SIZE_UPPER , value);
    }

    public String getPageIterMode (){
        return getAttrValue(AttributeNames.PAGE_ITER_MODE );
    }
    public void setPageIterMode (String value){
        setAttrValue(AttributeNames.PAGE_ITER_MODE , value);
    }

    //TODO: OSTALI ATTRIBUTI

    public void setIsExpertMode(String value) {
        setDesignTimeAttr(AttributeNames._IS_EXPERT_MODE, value);
    }

    public String getIsExpertMode(){
        return getDesignTimeAttr(AttributeNames._IS_EXPERT_MODE);
    }

    public void setObjectSuperClassName(String value) {
        setDesignTimeAttr(AttributeNames._OBJECT_SUPER_CLASS_NAME, value);
    }

    public String getObjectSuperClassName(){
        return getDesignTimeAttr(AttributeNames._OBJECT_SUPER_CLASS_NAME);
    }


    public void setExtends(String value){setAttrValue(AttributeNames.EXTENDS, value);}
    public String getSelectListFlags() {
        return getAttrValue(AttributeNames.SELECT_LIST_FLAGS);
    }
    public void setSelectListFlags(String value) {
        setAttrValue(AttributeNames.SELECT_LIST_FLAGS, value);
    }

    public String getFromListFlags() {
        return getAttrValue(AttributeNames.FROM_LIST_FLAGS);
    }
    public void setFromListFlags(String value) {
        setAttrValue(AttributeNames.FROM_LIST_FLAGS, value);
    }

    public String getWhereFlags() {
        return getAttrValue(AttributeNames.WHERE_FLAGS);
    }
    public void setWhereFlags(String value) {
        setAttrValue(AttributeNames.WHERE_FLAGS, value);
    }

    public String getSelectAllAttributes() {
        return getAttrValue(AttributeNames.SELECT_ALL_ATTRIBUTES);
    }
    public void setSelectAllAttributes(String value) {
        setAttrValue(AttributeNames.SELECT_ALL_ATTRIBUTES, value);
    }
    public EntityUsage addEntityUsage(Entity entity){
        int counter = 1;
        String name = entity.getName();
        while(getEntityUsage(name)!= null){
            name = entity.getName()+counter;
            ++counter;
        }
        EntityUsage eu = new EntityUsage(insertNewElement(TagNames.ENTITY_USAGE));
        eu.setName(name);
        eu.setEntity(entity.getPackagedName());

        entityUsages.add(eu);
        return eu;
    }

    public ViewAttribute addViewAttribute(String name){
        ViewAttribute va = new ViewAttribute(insertNewElement(TagNames.VIEW_ATTRIBUTE));
        setViewAttributeName(va, name);
        va.setAliasName("VIEW_ATTR");

        va.setIsUpdateable("false");
        va.setIsPersistent("false");
        va.setPrecisionRule("true");

        viewAttributes.add(va);
        return va;
    }
    public ViewAttribute addViewAttribute(Attribute attribute, EntityUsage entityUsage){
        ViewAttribute va = new ViewAttribute(insertNewElement(TagNames.VIEW_ATTRIBUTE));

        setViewAttributeName(va, attribute.getName());
        if("true".equals(attribute.getIsUnique()))va.setIsUnique("true");
        if("true".equals(attribute.getIsNotNull()))va.setIsNotNull("true");
        va.setEntityAttrName(attribute.getName());

       // EntityUsage entityUsage = findEntityUsageByEntity(attribute.getEntity().getPackage()+"."+attribute.getEntity().getName());
      //  if(entityUsage == null) entityUsage = addEntityUsage(attribute.getEntity());
        va.setEntityUsage(entityUsage.getName());
        setViewAttributeAliasName(va, attribute.getColumnName());
        if(!"true".equals(attribute.getIsUpdateable())) va.setIsUpdateable(attribute.getIsUpdateable());
        va.setPrecisionRule("true");

        viewAttributes.add(va);
        return va;
    }

    private void setViewAttributeName(ViewAttribute viewAttribute, String name) {
        int counter = 1;
        String temp = name;
        while(getViewAttribute(temp)!= null){
            temp = name + counter;
            ++counter;
        }
        viewAttribute.setName(temp);
    }


    private void setViewAttributeAliasName(ViewAttribute viewAttribute, String name) {
        int counter = 1;
        String temp = name;

        while(getViewAttributeByAliasName(temp)!= null){
            temp = name + counter;
            ++counter;
        }
        viewAttribute.setAliasName(temp);
    }
    public ViewAttribute getViewAttributeByAliasName(String alias){
        for (ViewAttribute attribute : getViewAttributes()) {
            if(alias.equals(attribute.getAliasName()))return attribute;
        }
        return null;
    }

    public List<EntityUsage> findEntityUsagesByEntity(String entity) {
        List<EntityUsage> usagesByEntity = new ArrayList<>();
        for (EntityUsage entityUsage : getEntityUsages()) {
            if (entity.equals(entityUsage.getEntity())) usagesByEntity.add(entityUsage);
        }
        return usagesByEntity;
    }
    public static ViewObject createViewObject(Model model, String path, String name, Type type){
        if(!name.endsWith(".xml"))name += ".xml";

        if(!path.endsWith("\\"))path = path+"\\";
        path = path + name;

        File file  = new File(path);
        FileUtils.checkOrCreateDirectory(file);

        try {
            if(!file.createNewFile()) throw new RuntimeException("ViewObject VEC POSTOJI");
            Document document = new Document();
            document.setVersion("1.0");
            document.setEncoding("windows-1250");
            document.setDocType(viewObjectDocType);


            Element root = new Element(TagNames.VIEW_OBJECT);

            document.setRootNode(root);

            ViewObject vo = new ViewObject(document, path, model);
            vo.setXmlns("http://xmlns.oracle.com/bc4j");
            vo.setName(name.replace(".xml",""));
            vo.setVersion("12.2.1.16.48");
            vo.setInheritPersonalization("merge");
            vo.setBindingStyle("OracleName");



            if(type == Type.Entity){
                vo.setSelectListFlags("1");
                vo.setFromListFlags("1");
                vo.setCustomQuery("false");
                vo.setSelectAllAttributes("false");
                vo.setWhereFlags("1");


            }
            else if(type == Type.SQL){
                vo.setCustomQuery("true");

            }
            //TODO: ELSE IF Za sve ostale tipove vo-a


            vo.setRowClass(model.getDefaultRowImplClass());
            vo.setComponentClass(model.getDefaultViewObjectImplClass());
            vo.setDefClass(model.getDefaultViewObjectDefClass());

            vo.setFetchMode("FETCH_AS_NEEDED");
            vo.setFetchSize("13");
            vo.setPageIterMode("Full");


            return vo;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //return null;
    }

    private Element insertNewElement(String tagName) {
        int index = getLastIndexOfElement(tagName, TAG_ORDER) + 1;
        return addChildElement(index, tagName);
    }

}
