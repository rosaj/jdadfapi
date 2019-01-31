package com.jdadfapi.ui.component.templating;

import com.jdadfapi.AttributeNames;
import com.jdadfapi.XMLElement;
import com.jdadfapi.ui.component.Component;
import com.jdadfapi.ui.component.ComponentMapper;
import com.jdadfapi.ui.component.layout.Facet;
import de.pdark.decentxml.Element;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 08-Nov-17
 * Time: 16:18
 */

public class Composition extends Component{



    public Composition(Element element, Component parent) {

        super(element, parent);
    }

    public Composition(Component parent) {
        super(new Element(ComponentMapper.getComponentName(Composition.class)),parent);
    }

    public Composition (){
        this(null);
    }

    public String getTemplate(){
        return getAttrValue(AttributeNames.TEMPLATE);
    }
    public void setTemplate(String value){
        setAttrValue(AttributeNames.TEMPLATE, value);
    }

    public String getXmlnsUi(){
        return getAttrValue(AttributeNames.XMLNS_UI);
    }
    public void setXmlnsUi(String value){
        setAttrValue(AttributeNames.XMLNS_UI, value);
    }
    public String getXmlnsF (){
        return getAttrValue(AttributeNames.XMLNS_F );
    }
    public void setXmlnsF (String value){
        setAttrValue(AttributeNames.XMLNS_F ,value);
    }

    public String getXmlnsAf (){
        return getAttrValue(AttributeNames.XMLNS_AF );
    }
    public void setXmlnsAf (String value){
        setAttrValue(AttributeNames.XMLNS_AF ,value);
    }
//TODO: REMOVE I DODAT METODU SA key, value
    public String getXmlnsMc (){
        return getAttrValue(AttributeNames.XMLNS_MC );
    }
    public void setXmlnsMc (String value){
        setAttrValue(AttributeNames.XMLNS_MC ,value);
    }

    public void setXmlns(String key, String value){
        setAttrValue(key, value);
    }
    public String getXmlns(String key){
        return getAttrValue(key);
    }


}
