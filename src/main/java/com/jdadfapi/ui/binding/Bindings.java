package com.jdadfapi.ui.binding;

import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import com.jdadfapi.model.applicationmodule.ViewUsage;
import com.jdadfapi.model.view.ViewAttribute;
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
 * Time: 22:56
 */

public class Bindings extends XMLElement {
    private List<ListOfValuesBinding> listOfValuesBindings = new ArrayList<>();
    private List<AttributeValues> attributeValues = new ArrayList<>();;
    private List<Tree> trees = new ArrayList<>();
    private List<BooleanBinding> booleanBindings = new ArrayList<>();
    public Bindings(Element element) {
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
                        case TagNames.TREE              : resolveTree(e); break;
                        case TagNames.ATTRIBUTE_VALUES  : resolveAttributeValues(e); break;
                        case TagNames.METHOD_ACTION     : resolveMethodAction(e); break;
                        case TagNames.LIST_OF_VALUES    : resolveListOfValues(e); break;
                        case TagNames.BOOLEAN_BINDINGS  : resolveBooleanBindings(e); break;
                        default:log(e);
                        //TODO: OSTALI SLUCAJEVI

                    }

                }
            }
        }
    }

    private void resolveTree(Element e){
        trees.add(new Tree(e));
    }
    private void resolveAttributeValues(Element e){
        attributeValues.add(new AttributeValues(e));

    }
    private void resolveMethodAction(Element e){

    }

    private void resolveListOfValues(Element e){
        listOfValuesBindings.add(new ListOfValues(e));
    }
    private void resolveBooleanBindings(Element e){
        booleanBindings.add(new BooleanBinding(e));
    }

    public List<ListOfValuesBinding> getListOfValuesBindings() {
        return listOfValuesBindings;
    }

    public ListOfValuesBinding findListOfValuesBinding(String name){
        for(ListOfValuesBinding lov : listOfValuesBindings){
            if(lov.getId().equals(name))return lov;
        }

        return null;
    }
    public Tree findTreeBinding(String id){
        for(Tree tree : trees){
            if(tree.getId().equals(id))return tree;
        }
        return null;
    }
    public List<AttributeValues> getAllAttributeValues() {
        return attributeValues;
    }
    public List<AttributeValues> getAttributeValues(Iterator iterator){
        return getAttributeValues(iterator.getId());
    }

    public List<Tree> getTrees() {
        return trees;
    }

    public List<AttributeValues> getAttributeValues(String iteratorName){
        List<AttributeValues> list = new ArrayList<>();
        for(AttributeValues av : attributeValues){
            if(av.getIterBinding().equals(iteratorName))list.add(av);
        }
        return list;
    }
    public AttributeValues createAttributeValues(Iterator iterator, String value){
        return createAttributeValues(iterator.getId(), value);
    }
    public AttributeValues createAttributeValues(String iteratorName, String value){
        AttributeValues av = new AttributeValues(addChildElement(TagNames.ATTRIBUTE_VALUES));
        av.setIterBinding(iteratorName);
        av.setId(value);
        attributeValues.add(av);
        return av;
    }

    public void createAttributeValue(String iteratorName, String value){
        createAttributeValues(iteratorName, value).createAttrNames().createItem(value);

    }

    public void createAttributeValue(Iterator iterator,  String value){
        createAttributeValue(iterator.getId(), value);

    }

    public AttributeValue getAttributeValue(String name){

        for(AttributeValue av : attributeValues){
            if(av.getId().equals(name))return av;
        }

        return null;
    }

    public boolean hasAttributeValue(String name){
        return getAttributeValue(name)!=null;
    }
    /*
      <list IterBinding="MloyVbodovaViewIterator" StaticList="false" Uses="LOV_Oznaka" id="Oznaka"
              DTSupportsMRU="true" SelectItemValueMode="ListObject"/>

     */

    private <T extends ListOfValuesBinding> T createListOfValuesBinding(Iterator iterator, ViewAttribute viewAttribute, Class<T> clazz){
        try {

            String name = TagNames.LIST;
            if(clazz.equals(ListOfValues.class)) name = TagNames.LIST_OF_VALUES;

            ListOfValuesBinding bind = clazz.getConstructor(Element.class).newInstance(addChildElement(0,name));

            bind.setIterBinding(iterator.getId());
            bind.setUses(viewAttribute.getLOVName());
            bind.setId(viewAttribute.getName());
            bind.setStaticList("false");

            listOfValuesBindings.add(bind);

            return (T)bind;
        } catch (Exception e) {
            return null;
        }
    }

    public ListOfValues createListOfValuesBinding(Iterator iterator, ViewAttribute viewAttribute){
        return createListOfValuesBinding(iterator, viewAttribute, ListOfValues.class);
    }
    public com.jdadfapi.ui.binding.List createListBinding(Iterator iterator, ViewAttribute viewAttribute){
        com.jdadfapi.ui.binding.List list = createListOfValuesBinding(iterator, viewAttribute, com.jdadfapi.ui.binding.List.class);
        list.setDTSupportsMRU("true");
        list.setSelectItemValueMode("ListObject");
        return list;
    }

    public Tree createTreeBindings(Iterator iterator, ViewUsage viewUsage){
        Tree tree = new Tree(addChildElement(TagNames.TREE));
        tree.setIterBinding(iterator.getId());
        tree.setId(iterator.getBinds());
        tree.createDefinition(viewUsage);
        trees.add(tree);
        return tree;
    }
    public BooleanBinding createBooleanBinding(String iteratorName, String attrName,String valueTrue, String valueFalse){
        BooleanBinding bb = new BooleanBinding(addChildElement(TagNames.BOOLEAN_BINDINGS));
        bb.setIterBinding(iteratorName);
        bb.setId(attrName);
        bb.seDTSupportsMRU("false");
        bb.setStaticList("true");
        bb.createAttrValue(attrName);
        bb.createValueList(valueTrue,valueFalse);

        booleanBindings.add(bb);
        return bb;
    }
    public BooleanBinding createBooleanBinding(String iteratorName,String attrName){
        return createBooleanBinding(iteratorName, attrName, "true", "false");
    }
    public BooleanBinding createBooleanBinding(Iterator iterator, String attrName){
        return createBooleanBinding(iterator.getId(), attrName);
    }
    public BooleanBinding createBooleanBinding(Iterator iterator, String attrName,String valueTrue, String valueFalse){
        return createBooleanBinding(iterator.getId(), attrName,valueTrue,valueFalse);
    }

    public List<BooleanBinding> getBooleanBindings() {
        return booleanBindings;
    }

    public List<AttributeValues> getAttributeValues() {
        return attributeValues;
    }
    public BooleanBinding getBooleanBinding(String id){
        for (BooleanBinding booleanBinding : booleanBindings) {
            if(booleanBinding.getId().equals(id))return booleanBinding;
        }
        return null;
    }
}
