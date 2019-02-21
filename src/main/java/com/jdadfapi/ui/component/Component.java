package com.jdadfapi.ui.component;

import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import com.jdadfapi.ui.component.core.Attribute;
import com.jdadfapi.ui.component.core.View;
import com.jdadfapi.ui.component.layout.Facet;
import com.jdadfapi.ui.component.templating.Composition;
import com.jdadfapi.ui.component.textandselection.InputUIComponent;
import com.jdadfapi.ui.component.textandselection.OutputText;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 08-Nov-17
 * Time: 16:24
 */

public class Component extends XMLElement {

    Component parent;
    List<Component> children;

    public Component(Element element, Component parent) {
        super(element);
        if(element.getParent() == null && parent!=null)parent.addChild(this);
        this.parent = parent;

        children = new ArrayList<>();
        for(Element e :  element.getChildren()){
            Class c = ComponentMapper.getComponentClass(e.getBeginName());

            Component child = null;
            try {
                child = (Component) c.getConstructor(Element.class,Component.class).newInstance(e,this);

            } catch (Exception e1) {
                throw new RuntimeException(e1);
            }

            children.add(child);
        }

    }

    private Attribute findAttributeByName(String name){
        List<Attribute> attributes = getComponents(Attribute.class);

        for (Attribute attribute : attributes) {
            if(attribute.getName().equals(name)) return attribute;
        }

        return null;
    }


    public String getAttribute(String name) {

        Attribute attribute = findAttributeByName(name);
        if(attribute != null) return attribute.getValue();

        return null;
    }
    public void setAttribute(String name, String value){

        Attribute attribute = findAttributeByName(name);

        if(attribute == null){
            attribute = new Attribute(this);
        }

        attribute.setValue(value);
    }


    public <T extends  Component> T getParent() {
        return (T)parent;
    }

    public <T extends Component> T findParent(Class parentClass){

        Component p = this;
        while (p.getParent()!= null){
            p = p.getParent();
            if(parentClass.isInstance(p))return (T) p;
        }
        return null;
    }


    public void setParent(Component parent){
        this.parent = parent;
        if(parent == null) {
            element.setParent(null);
            element.remove();
            return;
        }
        element.setParent(parent.element);
    }
    public void addChild(Component child){
        //if(child.parent == parent) return;
        if(child.parent != null)child.remove();
        child.setParent(this);
        element.addNode(child.element);
        children.add(child);
    }
    public void addChild(int index,Component child){
        // if(child.parent == parent) return;
        element.addNode(index, child.element);
        child.setParent(this);
        children.add(index,child);
    }
    public boolean removeChild(Component child){
        boolean isRemove  = element.removeNode(child.element);
        if(!isRemove)return false;
        children.remove(child);
        child.setParent(null);
        return true ;
    }
    public boolean removeChild(int index){
        Node node = element.removeNode(index);
        if(node == null) return false;
        Component child = findByNode(node);
        children.remove(child);
        child.setParent(null);

        return true ;
    }

    /*
    public void setParent(Component parent){

        setParent(parent, -1);

    }
    private void setParent(Component parent, int index){
        if(this.parent  == parent)return;

        if(this.parent != null){
            Component temp = this.parent;
            this.parent = null;
            temp.removeChild(this);
        }

        this.parent = parent;

        if(parent != null){
            if (index < 0) {
                parent.addChild(this);
            }
            else {
                parent.addChild(index, this);
            }
            element.setParent(parent.element);
        }


    }
    public void addChild(Component child){

    //    if(child.parent != null)
     //       parent.removeChild(child);

        child.setParent(this);


        element.addNode(child.element);
        children.add(child);
    }
    public void addChild(int index,Component child){

 //       if(child.parent != null)
  //          parent.removeChild(child);

        child.setParent(this);

        element.addNode(index, child.element);
        children.add(index,child);
    }
    public boolean removeChild(Component child){
        boolean isRemove  = element.removeNode(child.element);
        if(!isRemove)return false;

        children.remove(child);
        child.setParent(null);

        return true;
    }
    public boolean removeChild(int index){
        Node node = element.getNode(index);

        Component child = findByNode(node);

        removeChild(child);

        return true ;
    }

    */

    public List<Component> getChildren (){ return children; }
    public String getTagName(){
        return element.getBeginName();
    }




    public <T extends Component>  List<T> getComponents(Class<T> type){

        List<Component> components = new ArrayList<>();
        for(Component component : children){
            if(type.isInstance(component))components.add(component);
            List<T> childComponents = component.getComponents(type);
            if(!childComponents.isEmpty())components.addAll(childComponents);
        }
        return  ( List<T>)components;
    }



    Component findByNode(Node node){
        for(Component component : children){
            if(node.equals(component.element))return component;
            Component childFind = component.findByNode(node);
            if(childFind!=null) return childFind;
        }
        return null;
    }





    public < T extends Component> List <T> getComponentsByTagName(String tagName){

        List<Component> components = new ArrayList<>();
        for(Component component : children){
            if(tagName.equals(component.getTagName()))components.add(component);
            List<T> childComponents = component.getComponentsByTagName(tagName);
            if(!childComponents.isEmpty())components.addAll(childComponents);
        }
        return ( List<T>)components;

    }

    public List<Facet> getFacets(){
        List<Facet> facets = new ArrayList<>();
        for(Component c : children){
            if(c instanceof Facet)facets.add((Facet) c);
        }
        return facets;
    }
    public Facet getFacet(String name){
        for(Facet f: getFacets()){
            if(f.getName().equals(name))return f;
        }

        return null;
    }

    protected Facet getOrCreateFacet(String name){
        Facet facet = getFacet(name);
        if(facet == null){
            facet = new Facet(this);
            facet.setName(name);

        }
        return facet;
    }


    public String toString () {
        StringBuilder buffer = new StringBuilder(128);
        toString(buffer, 1);
        buffer.setLength(buffer.length() - 1);
        return buffer.toString();
    }

    void toString (StringBuilder buffer, int indent) {
        buffer.append(getTagName());
        buffer.append('\n');


        for (int i = 0, n = children.size(); i < n; i++) {
            for (int ii = 0; ii < indent; ii++)
                buffer.append("|  ");
            Component child = children.get(i);
            if(!child.getChildren().isEmpty())

                child.toString(buffer, indent + 1);
            else {
                buffer.append(child.getTagName());
                buffer.append('\n');
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Component)) return false;

        Component component = (Component) o;

        return element.equals(component.element);
    }

    @Override
    public int hashCode() {
        return element.hashCode();
    }

    public void generateId(){
        String name = this.getClass().getSimpleName();
        name = name.replaceAll(REG_EX, "").toLowerCase();
        if(parent == null){
            setId(name+"1");
            return;
        }
        Component par = findParent(View.class);
        if(par == null) par = findParent(Composition.class);

        if(par !=null){

              List<? extends Component>  components = par.getComponents(this.getClass());
              int counter = components.size();

              //provjerit za sve dali je id jedinstven na stranici
              components = par.getChildren();

              String id = name+(counter);
              while(!iskUniqueId(id,components)) id = name + (++counter);
                setId(id);
        }

    }
    private boolean iskUniqueId(String id, List<? extends Component> components ){
        for(Component c : components){
            if(id.equals(c.getId())) return false;
        }

        return true;
    }

    private static final String REG_EX = "[abcdefghijklmnoprstuvzyx]";
}
