package com.jdadfapi.model.entity.association;

import com.jdadfapi.TagNames;
import com.jdadfapi.model.Model;
import com.jdadfapi.model.common.NamedModelDocument;
import de.pdark.decentxml.Document;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Node;
import de.pdark.decentxml.XMLTokenizer;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 08-Jun-18
 * Time: 07:01
 */

public class Association extends NamedModelDocument {

    private AssociationEnd associationEnd;
    private AssociationEnd otherAssociationEnd;

    public Association(Document document, String path, Model model) {
        super(document, path, model);
        loadTree();
    }

    private void loadTree(){
        for(Node n: document.getRootElement().getNodes()){
            if(n.getType().equals(XMLTokenizer.Type.ELEMENT)){
                Element e = (Element)n;
                switch (e.getName()){
                    case TagNames.ASSOCIATION_END     :resolveAssociationEnd(e);break;
                    //TODO: Ostatak
                    default: log(e);
                }
            }
        }
    }
    private void resolveAssociationEnd(Element e){
        if(associationEnd == null) associationEnd = new AssociationEnd(e);
        else otherAssociationEnd = new AssociationEnd(e);
    }

    public AssociationEnd getAssociationEnd() {
        return associationEnd;
    }

    public AssociationEnd getOtherAssociationEnd() {
        return otherAssociationEnd;
    }

    public AssociationEnd getByOwner(String owner) {
        if(owner.equals(getAssociationEnd().getOwner())) return getAssociationEnd();
        else if(owner.equals(getOtherAssociationEnd().getOwner())) return getOtherAssociationEnd();
        return null;
    }

    public AssociationEnd getAssociationEnd(String name){
        if(name.equals(associationEnd.getName()))return  associationEnd;
        else if(name.equals(otherAssociationEnd.getName()))return otherAssociationEnd;
        return null;
    }


}
