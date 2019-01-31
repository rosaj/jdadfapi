package com.jdadfapi;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.TagName;
import com.sun.xml.internal.ws.util.StringUtils;
import de.pdark.decentxml.Attribute;
import de.pdark.decentxml.Element;
import de.pdark.decentxml.Namespace;
import org.w3c.dom.Attr;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Nov-17
 * Time: 10:33
 */

public class XMLElement  {

    private static final int LINE_LIMIT = 120;

    protected Element element;

    public XMLElement(Element element) {
        this.element = element;

    }

    public String getId(){
        return getAttrValue(AttributeNames.ID);
    }
    public void setId(String value){
        setAttrValue(AttributeNames.ID,value);
    }



    public String getAttrValue(String attr){
        return element.getAttributeValue(attr);
    }


    public void setAttrValue(String name, String value){
        if(element.getAttribute(name)!=null){
            if(value == null) {
                element.removeAttribute(name);
                return;
            }
            element.setAttribute(name,value);
        }
        else{
            if(value == null)return;
  //          String preSpace = " ";
/*            List<Attribute> attrs = element.getAttributes();
            if(attrs.size() == 0){
                element.addAttribute(name,value);
                return;
            }

            for(Attribute a : attrs){
                if(a.getPreSpace().length()> preSpace.length())preSpace = a.getPreSpace();
            }

  */
            Attribute attr = new Attribute(name, value);
            element.addAttribute(attr);
        //    attr.setPreSpace(getPreSpace(name, value));


        }

    }
    private static String asEmptyString(String string){
        int ln = string.length();
        StringBuilder sb = new StringBuilder(ln);
        for (int i = 0; i < ln; i++) sb.append(" ");
        return sb.toString();
    }
    protected void log(Element e){
      //  System.out.println(this.getClass().getSimpleName() +": no method for " +e.getName());
    }
    protected void log(String text){
        System.out.println(text);
    }


    protected Element addChildElement(String tag){
        Element e = new Element(tag);
        element.addNode(e);
        return e;
    }


    protected Element addChildElement(int index, String tag){
        Element e = new Element(tag);
        element.addNode(index, e);
        return e;
    }

    public static void setPreSpace(Element element){
        List<Attribute> attrs = element.getAttributes();
        if(attrs != null){
            for (Attribute attr : attrs) {
                attr.setPreSpace(getPreSpace(element,attr));
            }
        }
    }

    private static String getPreSpace(Element element,   Attribute attr){

        List<Attribute> attributes = element.getAttributes();
        if(attributes.size() == 1){
            if(!attrGoesToNewLine(element)) return " ";
        }

        String level = ADFXMLWriter.indent;

        Element parent = element.getParentElement();
        while( parent != null){
            level += ADFXMLWriter.indent;
            parent = parent.getParentElement();
        }

        if(!attrGoesToNewLine(element)){
            Namespace ns = element.getNamespace();

            if(ns != null && !ns.getPrefix().isEmpty())level += asEmptyString(ns.getPrefix());

            level += asEmptyString(element.getBeginName())+"  " ;// mesto za < i jos jedno prazno mesto

            int lineLn = level.length();

            int index = attributes.indexOf(attr);
            //ako je prvi onda je " "
            if(index == 0) return " ";

            for(int i = index -1 ; i > -1 ; i--){
                Attribute cur = attributes.get(i);
                // 4-> ="" i razmak
                lineLn += cur.getName().length() + 4 + cur.getValue().length();
                //razmak izmedu attrs je " " i ako je veci od tega onda je to prvi u redu
                if(!" ".equals(cur.getPreSpace()))break;
            }



            /*
            for (int i = attributes.size()-1; i>=0; i--){
                Attribute cur = attributes.get(i);
                if(!" ".equals(cur.getPreSpace()))break;
                lineLn += cur.getName().length() + 4 + cur.getValue().length();
            }
            */

         //   lineLn -= 5; ?

            //Attribute prev = attributes.get(attributes.size() - 1);
            //int ln = prev.getPreSpace().length();

        //    if(attributes.size() == 2) ln += level.length();

       //     ln += prev.getName().length() + 3 + prev.getValue().length();

            // 4-> ="" i razmak
            if(lineLn + 4 + attr.getName().length()+ attr.getValue().length()> LINE_LIMIT){
                return "\n" + level.substring(ADFXMLWriter.indent.length());
            }
            return " ";


        }
        else{
            level = "\n" + level;
        }

        return level;
    }
    public void remove(){
        element.remove();
    }
    private static boolean attrGoesToNewLine(Element element){
        String name = element.getBeginName();
        Namespace namespace = element.getNamespace();
        if(namespace != null && !namespace.getPrefix().isEmpty()) name = namespace.getPrefix() + ":" + name;
        return newLiners.contains(name);
    }


    protected String getSimple( String name){
        if(name != null){
            int dot = name.lastIndexOf(".");
            if(dot>-1){
                name = name.substring(dot + 1);
            }
        }
        return name;
    }

    private static final List<String> newLiners = Arrays.asList(
            TagNames.VIEW_OBJECT,
            TagNames.PROPERTIES,
            TagNames.SCHEMA_BASED_PROPERTIES,
            TagNames.LABEL,
            TagNames.LABEL_PLURAL,
            TagNames.FMT_FORMAT,
            TagNames.DISPLAYWIDTH,
            TagNames.CONTROLTYPE,
            TagNames.CLIENT_ROW_INTERFACE,
            TagNames.CLIENT_INTERFACE,
            TagNames.PARAMETER_UPPER,
            TagNames.METHOD,
            TagNames.RETURN,
            TagNames.SORT,
            TagNames.PROPERTY,
            TagNames.FMT_FORMATTER,
            TagNames.ENTITY_USAGE,
            TagNames.DESIGN_TIME,
            TagNames.VIEW_ATTRIBUTE,
            TagNames.RESOURCE_BUNDLE,
            TagNames.PROPERTIES_BUNDLE,
            TagNames.VIEW_ACCESSOR,
            TagNames.LIST_BINDING,
            TagNames.VIEW_USAGE,
            TagNames.VIEW_LINK_USAGE,
            TagNames.VIEW_LINK_ACCESSOR,
            TagNames.VIEW_LINK,
            TagNames.VIEW_LINK_DEF_END,
            TagNames.JBO_PROJECT,
            TagNames.TRANSIENT_EXPRESSION,

            TagNames.ENTITY,
            TagNames.ASSOCIATION,
            TagNames.ASSOCIATION_END,
            TagNames.ATTRIBUTE,
            TagNames.ACCESSOR_ATTRIBUTE,
            TagNames.Key,
            NamespaceNames.VALIDATION + ":" + TagNames.UNIQUE_KEY_VALIDATION_BEAN,
            NamespaceNames.VALIDATION + ":" + TagNames.RES_EXPRESSIONS,
            NamespaceNames.VALIDATION + ":" + TagNames.EXPRESSION

    );

}
