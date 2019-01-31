package com.jdadfapi.ui.binding;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLDocument;
import com.jdadfapi.ui.Page;
import com.jdadfapi.ui.ViewController;
import de.pdark.decentxml.Document;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Node;
import de.pdark.decentxml.XMLTokenizer;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Nov-17
 * Time: 09:42
 */

public class PageDef extends XMLDocument {

    private Executables executables;
    private Bindings bindings;
    private Parameters parameters;
    private Page page;

    public PageDef(Page page, Document document, String path) {
        super(document, path);
        this.page = page;
        loadTree();
    }

    private void loadTree(){

        List<Node> nodes = element.getNodes();
        if(nodes != null && nodes.size()>0){
            for(Node node : nodes){
                if(node.getType().equals(XMLTokenizer.Type.ELEMENT)){
                    Element e = (Element) node;
                    switch (e.getName()){
                        case TagNames.PARAMETERS   : resolveParameters(e); break;
                        case TagNames.EXECUTABLES  : resolveExecutables(e); break;
                        case TagNames.BINDINGS     : resolveBindings(e); break;
                        default:log(e);
                    }
                }
            }
        }

        if(parameters == null)resolveParameters(null);
        if(executables == null)resolveExecutables(null);
        if(bindings == null)resolveBindings(null);

    }

    private void resolveParameters(Element e){
        if(e == null){
            e = addChildElement(TagNames.PARAMETERS);
        }
        parameters = new Parameters(e);
    }

    private void resolveExecutables(Element e){
        if(e == null){
            e = addChildElement(TagNames.EXECUTABLES);
        }
        executables = new Executables(e);
    }
    private void resolveBindings (Element e){
        if(e == null){
            e = addChildElement(TagNames.BINDINGS);
        }
        bindings = new Bindings(e);
    }


    public String getXmlns (){
        return getAttrValue(AttributeNames.XMLNS );
    }
    public void setXmlns (String value){
        setAttrValue(AttributeNames.XMLNS , value);
    }

    public String getVersion (){
        return getAttrValue(AttributeNames.VERSION );
    }
    public void setVersion (String value){
        setAttrValue(AttributeNames.VERSION , value);
    }

    public String getPackage (){
        return getAttrValue(AttributeNames.PACKAGE );
    }
    public void setPackage (String value){
        setAttrValue(AttributeNames.PACKAGE , value);
    }

    public Executables getExecutables() {
        return executables;
    }

    public Bindings getBindings() {
        return bindings;
    }

    public Parameters getParameters() {
        return parameters;
    }

    @Override
    public void save() {
        boolean save = notifyDataBindings();
        super.save();
        if(save)page.getViewController().getDataBindings().save();
    }

    @Override
    public void saveFormatted() {
        boolean save = notifyDataBindings();
        super.saveFormatted();
        if(save)page.getViewController().getDataBindings().saveFormatted();
    }
    private boolean notifyDataBindings(){
        ViewController vc = page.getViewController();
        if(vc != null && vc.getDataBindings() != null){
            return vc.getDataBindings().addPage(page);
        }
        return false;
    }

    public Page getPage() {
        return page;
    }
}

/*
     Element root = document.getRootElement();
        List<Element> elements = root.getChildren(TagNames.PARAMETERS);
        Element e = null;
        if(elements != null && elements.size()>0)e = elements.get(0);
        else{
            e = new Element(TagNames.PARAMETERS);
            root.addNode(e);
        }


        elements = root.getChildren(TagNames.EXECUTABLES);
        e = null;
        if(elements != null && elements.size()>0)e = elements.get(0);
        else{
            e = new Element(TagNames.EXECUTABLES);
            root.addNode(e);
        }

        executables = new Executables(e);

        elements = root.getChildren(TagNames.BINDINGS);
        e = null;
        if(elements != null && elements.size()>0)e = elements.get(0);
        else{
            e = new Element(TagNames.BINDINGS);
            root.addNode(e);
        }
        bindings = new Bindings(e);

        */