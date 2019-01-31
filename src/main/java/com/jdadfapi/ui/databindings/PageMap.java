package com.jdadfapi.ui.databindings;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.TagNames;
import com.jdadfapi.XMLElement;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.TagName;
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
 * Time: 22:27
 */

public class PageMap extends XMLElement {
    List<DataBindingsPage> dataBindingsPages = new ArrayList<>();
    public PageMap(Element element) {
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
                        case TagNames.PAGE : resolvePage(e); break;
                        default:log(e);
                    }
                }
            }
        }

    }
    private void resolvePage(Element e){
        dataBindingsPages.add(new DataBindingsPage(e));
    }
    public DataBindingsPage addPage(String usageId, String path){
        DataBindingsPage page = new DataBindingsPage(addChildElement(TagNames.PAGE));
        dataBindingsPages.add(page);
        page.setUsageId(usageId);
        page.setPath(path);
        return page;
    }

    public DataBindingsPage findPage(String id){
        for (DataBindingsPage dataBindingsPage : dataBindingsPages) {
            if(id.equals(dataBindingsPage.getUsageId()))return dataBindingsPage;
        }
        return null;
    }
    public DataBindingsPage findPageByPath(String path){
        for (DataBindingsPage dataBindingsPage : dataBindingsPages) {
            if(path.equals(dataBindingsPage.getPath())) return dataBindingsPage;
        }
        return null;
    }

    public List<DataBindingsPage> getDataBindingsPages() {
        return dataBindingsPages;
    }
}
