package com.jdadfapi;

import com.sun.org.apache.xerces.internal.dom.DeferredDocumentImpl;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import de.pdark.decentxml.*;
import de.pdark.decentxml.dtd.DocTypeAttributeList;
import de.pdark.decentxml.dtd.DocTypeElement;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @author: Robert
 * Date: 06-Nov-17
 * Time: 07:25
 */

public class Saver {

    private static boolean format = true;

    public static void setFormatting(boolean isFormatting) {
        format = isFormatting;
    }

    public static synchronized void save(Document document, String path) {

        OutputStream os = null;
        Writer w = null;
        Writer writer = null;
        try {
            os = (new FileOutputStream(new File(path)));
            w = new OutputStreamWriter(os, "windows-1250");

         //   writer = new ADFXMLWriter(w);
           // writer.setIndent("    ");

       //     System.out.println(document.getRootElement().getPostSpace());
          //  document.getDocType().add(new Text(" ViewObject SYSTEM \"jbo_03_01.dtd\"> "));
         //   document.addNode( document.getDocType());

         //   document.toXML(writer);
            if (format) {
                writer = new ADFXMLWriter(w);
                ((ADFXMLWriter) writer).writeDocument(document);
            }
            else{
                writer = new XMLWriter(w);
                document.toXML((XMLWriter)writer);
            }
            writer.flush();
            w.flush();
            os.flush();
            writer.close();
            w.close();
            os.close();
        } catch (Exception e) {
            try {
                w.close();
                os.close();
                writer.close();

            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
            throw new RuntimeException(e);
        }
    }

    /**
     * @Deprecated use <code>save(document, path)</code> instead
     * @param document
     * @param path
     */
    @Deprecated
    public static synchronized void saveFormatted(Document document, String path) {
        save(document, path);
/*
        FileOutputStream outputStream = null;
        try {
            save(document, path);

            if (!format) return;
            File fXmlFile = new File(path);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setIgnoringElementContentWhitespace(false);

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            DeferredDocumentImpl doc = (DeferredDocumentImpl) dBuilder.parse(fXmlFile);

            OutputFormat format = new OutputFormat(doc);
            format.setIndenting(true);
            if (document.getEncoding() != null) format.setEncoding(document.getEncoding());



            outputStream = new FileOutputStream(new File(path));
            XMLSerializer serializer = new XMLSerializer(outputStream, format);

            serializer.serialize(doc);

            outputStream.flush();
            outputStream.close();


        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (outputStream != null) outputStream.close();
            } catch (IOException io) {
                throw new RuntimeException(io);
            }
            throw new RuntimeException(e);
        }
        */
    }
}

/*
            File fXmlFile = new File(path);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setIgnoringElementContentWhitespace(false);

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            DeferredDocumentImpl doc = (DeferredDocumentImpl) dBuilder.parse(fXmlFile);

            OutputFormat format = new OutputFormat(doc);
            format.setIndenting(true);
            if(document.getEncoding()!= null)format.setEncoding(document.getEncoding());

            outputStream =  new FileOutputStream(new File(path));
            XMLSerializer serializer = new XMLSerializer(outputStream, format);

            serializer.serialize(doc);

            outputStream.close();

 */

/*

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse(new InputSource(new InputStreamReader(new FileInputStream(
                    path))));

            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.setOutputProperty(OutputKeys.METHOD, "xml");
            xformer.setOutputProperty(OutputKeys.INDENT, "yes");
            xformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            xformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            Source source = new DOMSource(doc);
            Result result = new StreamResult(new File(path));
            xformer.transform(source, result);

 */
/*


            final InputSource src = new InputSource(new InputStreamReader(new FileInputStream( path)));

            final Node doc = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().parse(src).getDocumentElement();

            final DOMImplementationRegistry registry = DOMImplementationRegistry
                    .newInstance();
            final DOMImplementationLS impl = (DOMImplementationLS) registry
                    .getDOMImplementation("LS");
            final LSSerializer writer = impl.createLSSerializer();
            LSOutput output = impl.createLSOutput();
            outputStream =  new FileOutputStream(new File(path));
            output.setByteStream(outputStream);

            writer.getDomConfig().setParameter("format-pretty-print",
                    Boolean.TRUE);
            writer.getDomConfig().setParameter("xml-declaration", true);

            writer.write(doc, output);

 */

/*
            final InputSource src = new InputSource(new InputStreamReader(new FileInputStream( path)));

            final Node doc = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().parse(src).getDocumentElement();

            final DOMImplementationRegistry registry = DOMImplementationRegistry
                    .newInstance();
            final DOMImplementationLS impl = (DOMImplementationLS) registry
                    .getDOMImplementation("LS");
            final LSSerializer writer = impl.createLSSerializer();
            LSOutput output = impl.createLSOutput();
            outputStream =  new FileOutputStream(new File(path));
            output.setByteStream(outputStream);

            writer.getDomConfig().setParameter("format-pretty-print",
                    Boolean.TRUE);
            writer.getDomConfig().setParameter("xml-declaration", true);

            writer.write(doc, output);
*/