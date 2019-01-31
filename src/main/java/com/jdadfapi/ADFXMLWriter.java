package com.jdadfapi;

import de.pdark.decentxml.*;
import de.pdark.decentxml.dtd.DocType;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 27-Aug-18
 * Time: 21:47
 */

public class ADFXMLWriter extends Writer {
    private final Writer writer;

    public ADFXMLWriter(Writer writer) {
      this.writer = writer;
    }

    public void close() throws IOException {
        this.writer.close();
    }

    public void flush() throws IOException {
        this.writer.flush();
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        this.writer.write(cbuf, off, len);
    }

    public void write(Node node, String s) throws IOException {
        this.writer.write(s);
    }

    public void writeDocument(Document document) throws IOException {

        XMLDeclaration xmlDeclaration = document.getXmlDeclaration();
        writer.write(xmlDeclaration.toXML());

        DocType docType = document.getDocType();
        if(docType != null){
            nl();
            writer.write("<!DOCTYPE " + docType.getName());
            if(docType.getSystemLiteral()  != null) writer.write( " " + docType.getDocTypeType().name() + " \"" + docType.getSystemLiteral() + "\"");
            writer.write(">");
            if(docType.getSystemLiteral()  != null){
                nl();
                writer.write("<!---->");
            }
        }
        writeNode(document.getRootElement());

    }

    public void writeNode(Node node) throws IOException {
        if(node instanceof  Element){
            level++;

            Element e = (Element) node;

            XMLElement.setPreSpace(e);

            String tag = e.getName();

            if (e.getNamespace() != null && e.getNamespace() != Namespace.NO_NAMESPACE) {
                tag = e.getNamespace().getPrefix() + ":" + e.getName();
            }

            nl();
            indent();
            writer.write("<" + tag);
            for (Attribute attribute : e.getAttributes()) {
              //  writer.write(attribute.getPreSpace() + attribute.getName() + "=\"" + attribute.getValue() + "\"");
                writeAttributeValue(attribute);
            }
            if(!e.hasChildren() && !e.hasNodes()){
                String text = e.getText();
                if(text == null || text.isEmpty())  writer.write("/>");
                else writer.write(">" + text + "</" + tag + ">");
            }
            else if(e.hasNodes() && !e.hasChildren()){
                StringBuilder buffer = new StringBuilder();

                for (Node cn : e.getNodes()) {

                    if (XMLUtils.isText(cn)) {
                        String text = ((Text)cn).getText();
                        if(cn.getType() == XMLTokenizer.Type.CDATA){
                            text =  "<![CDATA[" + text + "]]>";
                        }
                        buffer.append(text);

                    } else if (XMLUtils.isElement(cn)) {
                        buffer.append(((Element)cn).getText());
                    } else if (cn.getType() == XMLTokenizer.Type.ENTITY) {
                        buffer.append(((Entity)cn).getText());
                    }
                }

                writer.write(">" + buffer.toString()+ "</" + tag + ">");

            }
            else{
                writer.write(">");
                for (Node element : e.getNodes()) {
                    writeNode(element);
                }
                nl();
                indent();
                writer.write("</"+tag+">");
            }
            level --;

        }
        else{
            if(node instanceof  ProcessingInstruction || node instanceof Comment){
                level++;
                nl();
                indent();
                writer.write(node.toXML());
                level--;
            }
            else{
             //   writer.write(node.toXML());
              //  System.out.println("ELSE "+node.getClass()+" " +node.getType()+" " +node.toXML());
              ///  nl();
            }

        }
    }

    public void writeAttributeValue(Attribute attribute) throws IOException {
        String value = attribute.getValue();
        char quoteChar = (char) attribute.getQuoteChar();



        writer.write(attribute.getPreSpace());
        String prefix = attribute.getNamespace().getPrefix();
        if (prefix.length() != 0) {
            writer.write(prefix);
            writer.write(":");
        }

        writer.write(attribute.getName());
        writer.write(attribute.getEqualsSpace());
        char[] buffer = new char[]{quoteChar};
        String s = new String(buffer);
        writer.write( s);



        int pos = 0;
        int start = pos;

        for(String escapeQuote = quoteChar == '"' ? "&quot;" : "&apos;"; pos < value.length(); ++pos) {
            char c = value.charAt(pos);
            String escape = null;
            if (c == quoteChar) {
                escape = escapeQuote;
            } else if (c == '&') {
                escape = "&amp;";
            } else if (c == '<') {
                escape = "&lt;";
            } else if (c == '>') {
                escape = "&gt;";
            }

            if (escape != null) {
                if (pos != start) {
                    this.write(value.substring(start, pos));
                }

                this.write( escape);
                start = pos + 1;
            }
        }

        if (start < pos) {
            this.write(value.substring(start, pos));
        }
        writer.write(s);
    }

    public void nl() throws IOException {
        writer.write("\n");
    }
    public void indent() throws IOException {
        for(int i = 0; i < this.level; ++i) {
            this.writer.write(this.indent);
        }

    }

    public static String indent = "    ";

    private int level = -1;
}


