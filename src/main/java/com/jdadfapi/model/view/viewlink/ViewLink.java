package com.jdadfapi.model.view.viewlink;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.FileUtils;
import com.jdadfapi.TagNames;
import com.jdadfapi.model.Model;
import com.jdadfapi.model.common.NamedModelDocument;
import de.pdark.decentxml.*;
import de.pdark.decentxml.dtd.DocType;

import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 19-Jun-18
 * Time: 12:01
 */

public class ViewLink extends NamedModelDocument {
    static DocType viewLinkDocType;
    static{
        viewLinkDocType = new DocType();
        viewLinkDocType.setDocTypeType(DocType.DocTypeType.SYSTEM);
        viewLinkDocType.setName(TagNames.VIEW_LINK);
        viewLinkDocType.setSystemLiteral("jbo_03_01.dtd");
    }

    private ViewLinkDefEnd viewLinkDefEnd;
    private ViewLinkDefEnd otherViewLinkDefEnd;

    public ViewLink(Document document, String path, Model model) {
        super(document, path, model);
        loadTree();
    }

    private void loadTree(){
        for(Node n: document.getRootElement().getNodes()){
            if(n.getType().equals(XMLTokenizer.Type.ELEMENT)){
                Element e = (Element)n;
                switch (e.getName()){
                    case TagNames.VIEW_LINK_DEF_END     :resolveViewLinkDefEnd(e);break;
                    //TODO: Ostatak
                    default: log(e);
                }
            }
        }
    }
    private void resolveViewLinkDefEnd(Element e){
        if(viewLinkDefEnd == null)viewLinkDefEnd = new ViewLinkDefEnd(e);
        else otherViewLinkDefEnd = new ViewLinkDefEnd(e);
    }

    public void setEntityAssociation(String value){
        setAttrValue(AttributeNames.ENTITY_ASSOCIATION,value);
    }

    public String getEntityAssociation(){
        return getAttrValue(AttributeNames.ENTITY_ASSOCIATION);
    }




    public static ViewLink createViewLink( Model model, String path, String name){
        if(!name.endsWith(".xml"))name += ".xml";

        if(!path.endsWith("\\"))path = path+"\\";
        path = path + name;
     //   System.out.println(path);
        File file  = new File(path);
        FileUtils.checkOrCreateDirectory(file);
        try {
            if(!file.createNewFile()) throw new RuntimeException("ViewLink VEC POSTOJI");
            Document document = new Document();
            document.setVersion("1.0");
            document.setEncoding("windows-1250");
            document.setDocType(viewLinkDocType);

          //  document.addNode(viewLinkDocType.createClone());
           // document.addNode(new Text(""));

            Element root = new Element(TagNames.VIEW_LINK);
            document.setRootNode(root);

            ViewLink vl = new ViewLink(document, path, model);
            vl.setName(name.replace(".xml",""));
            vl.setXmlns("http://xmlns.oracle.com/bc4j");
            vl.setVersion("12.2.1.16.48");
            vl.setInheritPersonalization("merge");
            return vl;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //return null;
    }
    public ViewLinkDefEnd createViewLinkDefEnd(){
        if(viewLinkDefEnd == null){
           // Element e = new Element(TagNames.VIEW_LINK_DEF_END);
          // element.addNode(e);
            viewLinkDefEnd = new ViewLinkDefEnd(addChildElement(TagNames.VIEW_LINK_DEF_END));
        }
        return viewLinkDefEnd;
    }
    public ViewLinkDefEnd createOtherViewLinkDefEnd(){
        if(otherViewLinkDefEnd == null){
         //   Element e = new Element(TagNames.VIEW_LINK_DEF_END);
          //  element.addNode(e);
            otherViewLinkDefEnd = new ViewLinkDefEnd(addChildElement(TagNames.VIEW_LINK_DEF_END));
        }
        return otherViewLinkDefEnd;
    }

    public ViewLinkDefEnd getViewLinkDefEnd() {
        return viewLinkDefEnd;
    }

    public ViewLinkDefEnd getOtherViewLinkDefEnd() {
        return otherViewLinkDefEnd;
    }

}
