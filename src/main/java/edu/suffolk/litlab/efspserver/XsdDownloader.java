package edu.suffolk.litlab.efspserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Downloaded the FilingReviewMDE wsdl, necessary for it to run faster. Slightly modified to handle
 * relative paths on the server.
 * Runs like:
 * mvn exec:java -Dexec.args="https://illinois-stage.tylerhost.net/EFM/Schema/ECF-4.0-FilingReviewMDEService.wsdl ecf"
 * Then move all of the ecf files into src/main/resources/wsdl/, and point the FilingReviewMDE 
 * URL to it.
 * <a href="https://github.com/pablod/xsd-downloader">Github here</a>
 *
 * @author c 
 */
public class XsdDownloader {

  public static class XsdNameSpaceContext implements NamespaceContext {

    private final Map<String, String> nameSpaceUrisByPrefixes;

    public XsdNameSpaceContext() {
      nameSpaceUrisByPrefixes = new HashMap<String, String>();
      nameSpaceUrisByPrefixes.put("xsd", "http://www.w3.org/2001/XMLSchema");
    }

    public String getNamespaceURI(final String prefix) {
      return nameSpaceUrisByPrefixes.get(prefix);
    }

    public String getPrefix(final String namespaceUri) {
      return null;
    }

    public Iterator<String> getPrefixes(final String namespaceUri) {
      return null;
    }

  }

  /** Main method, pass in the URL to find the WSDL, and the xsd prefix 
   * that everything is changed to. */
  public static void main(final String[] args) {
    if (args.length != 2) {
      System.out.println("Only two parameters: 1--wsdl-url 2--xsds-prefix");
      return;
    }
    System.out.println(args[0]);
    System.out.println(args[1]);
    String xsdUrl = args[0];
    String filePrefix = args[1];
    XsdDownloader xsdDownloader = new XsdDownloader();
    xsdDownloader.setDownloadPrefix(filePrefix);
    try {
      xsdDownloader.downloadXsdRecurse(xsdUrl, "");
    } catch (TransformerConfigurationException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (TransformerException e) {
      e.printStackTrace();
    }
  }

  Map<String, String> fileNamesByprocessedUrls = new HashMap<String, String>();

  private String downloadPrefix;

  private void downloadXsdRecurse(final String xsdUrl, final String pastUrl)
      throws IOException, ParserConfigurationException, SAXException, TransformerException {

    String outputFileName = downloadPrefix;
    if (fileNamesByprocessedUrls.size() > 0) {
      outputFileName = outputFileName + "-" + fileNamesByprocessedUrls.size();
    }
    outputFileName = outputFileName + ".xsd";
    fileNamesByprocessedUrls.put(xsdUrl, outputFileName);
    System.out.println("Download " +  xsdUrl + " (past url is " + pastUrl + ")");

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware(true);
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = null;
    String workedUrl = "";
    try {
      doc = db.parse(xsdUrl);
      workedUrl = xsdUrl;
    } catch (FileNotFoundException ex) {
      String baseUrl = pastUrl.substring(0, pastUrl.lastIndexOf('/') + 1);
      doc = db.parse(baseUrl + xsdUrl);
      workedUrl = baseUrl + xsdUrl;
    }
    processElementRecurse(doc.getDocumentElement(), workedUrl);

    File outputFile = new File(outputFileName);
    TransformerFactory trf = TransformerFactory.newInstance();
    Transformer tr = trf.newTransformer();
    Source source = new DOMSource(doc);
    Result result = new StreamResult(outputFile);
    tr.transform(source, result);
  }

  private void processElementRecurse(final Element node, String pastUrl)
      throws IOException, ParserConfigurationException, SAXException, TransformerException {
    NodeList nl = node.getChildNodes();
    for (int i = 0, n = nl.getLength(); i < n; i++) {
      Node childNode = nl.item(i);
      if (childNode instanceof Element) {
        Element childElement = (Element) childNode;
        if ("http://www.w3.org/2001/XMLSchema".equals(childElement.getNamespaceURI())
            && (childElement.getLocalName().equals("import") 
                || childElement.getLocalName().equals("include"))) {
          System.out.println("New Element Found");
          String schLoc = childElement.getAttribute("schemaLocation");
          if (!fileNamesByprocessedUrls.containsKey(schLoc)) {
            downloadXsdRecurse(schLoc, pastUrl);
            String newLoc = fileNamesByprocessedUrls.get(schLoc);
            if (newLoc != null) {
              childElement.setAttribute("schemaLocation", newLoc);
            }
          } else {
            String newLoc = fileNamesByprocessedUrls.get(schLoc);
            childElement.setAttribute("schemaLocation", newLoc);
          }
        } else if ("http://schemas.xmlsoap.org/wsdl/".equals(childElement.getNamespaceURI())
            && (childElement.getLocalName().equals("import") 
                || childElement.getLocalName().equals("include"))) {
          System.out.println("WSDL Found");
          String schLoc = childElement.getAttribute("location");
          if (!fileNamesByprocessedUrls.containsKey(schLoc)) {
            downloadXsdRecurse(schLoc, pastUrl);
            String newLoc = fileNamesByprocessedUrls.get(schLoc);
            if (newLoc != null) {
              childElement.setAttribute("location", newLoc);
            }
          } else {
            String newLoc = fileNamesByprocessedUrls.get(schLoc);
            childElement.setAttribute("location", newLoc);
          }
        } else {
          processElementRecurse(childElement, pastUrl);
        }
      }
    }
  }

  public void setDownloadPrefix(final String downloadPrefix) {
    this.downloadPrefix = downloadPrefix;
  }

}