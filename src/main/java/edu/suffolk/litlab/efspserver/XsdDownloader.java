package edu.suffolk.litlab.efspserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
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
 * relative paths on the server. Runs like: <code>
 * java -cp efspserver-with-deps.jar edu.suffolk.litlab.efspserver.XsdDownloader https://example.tylertech.cloud/EFM/Schema/ECF-4.0-FilingReviewMDEService.wsdl ecf"
 * </code> Then move all of the ecf files into src/main/resources/wsdl/, and point the
 * FilingReviewMDE URL to it. <a href="https://github.com/pablod/xsd-downloader">Github here</a>
 *
 * @author https://github.com/pablod
 */
public class XsdDownloader {

  public XsdDownloader(String downloadPrefix) {
    this.downloadPrefix = downloadPrefix;
  }

  private Map<String, String> fileNamesByprocessedUrls = new HashMap<String, String>();

  private final String downloadPrefix;

  private String downloadXsdRecurse(final String xsdUrl, final String pastUrl)
      throws IOException, ParserConfigurationException, SAXException, TransformerException {

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware(true);
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = null;
    String workedUrl = "";

    try {
      if (fileNamesByprocessedUrls.containsKey(xsdUrl)) {
        // Don't actually need to check this!
        return xsdUrl;
      }
      System.out.println("Download " + xsdUrl + " (past url is " + pastUrl + ")");
      doc = db.parse(xsdUrl);
      workedUrl = xsdUrl;
    } catch (FileNotFoundException ex) {
      try {
        workedUrl = normalizeUrl(xsdUrl, pastUrl);
      } catch (URISyntaxException e) {
        e.printStackTrace();
        return null;
      }
      if (fileNamesByprocessedUrls.containsKey(workedUrl)) {
        // This is also a duplicate of something else we have!
        return workedUrl;
      }
      doc = db.parse(workedUrl);
    }

    System.out.println("workedURL: " + workedUrl);

    String outputFileName = downloadPrefix;
    if (fileNamesByprocessedUrls.size() > 0) {
      outputFileName = outputFileName + "-" + fileNamesByprocessedUrls.size();
    }
    outputFileName = outputFileName + ".xsd";
    fileNamesByprocessedUrls.put(workedUrl, outputFileName);

    processElementRecurse(doc.getDocumentElement(), workedUrl);

    File outputFile = new File(outputFileName);
    TransformerFactory trf = TransformerFactory.newInstance();
    Transformer tr = trf.newTransformer();
    Source source = new DOMSource(doc);
    Result result = new StreamResult(outputFile);
    tr.transform(source, result);
    return workedUrl;
  }

  private static String normalizeUrl(String xsdUrl, final String pastUrl)
      throws URISyntaxException {
    String baseUrl = pastUrl.substring(0, pastUrl.lastIndexOf('/') + 1);
    return new URI(baseUrl + xsdUrl).normalize().toString();
  }

  private void processElementRecurse(final Element node, String pastUrl)
      throws IOException, ParserConfigurationException, SAXException, TransformerException {
    NodeList nodeList = node.getChildNodes();
    int len = nodeList.getLength();
    for (int i = 0; i < len; i++) {
      Node childNode = nodeList.item(i);
      if (childNode instanceof Element) {
        Element childElement = (Element) childNode;
        String locAttribute = "";
        if ((childElement.getLocalName().equals("import")
            || childElement.getLocalName().equals("include"))) {
          if ("http://www.w3.org/2001/XMLSchema".equals(childElement.getNamespaceURI())) {
            locAttribute = "schemaLocation";
          } else if ("http://schemas.xmlsoap.org/wsdl/".equals(childElement.getNamespaceURI())) {
            locAttribute = "location";
          } else {
            System.out.println("ERROR: unknown namespace?: " + childElement.getNamespaceURI());
          }
        } else {
          processElementRecurse(childElement, pastUrl);
          continue;
        }

        String schLoc = childElement.getAttribute(locAttribute);
        System.out.println("New " + locAttribute + " Element Found: " + schLoc);
        String workedUrl = downloadXsdRecurse(schLoc, pastUrl);
        String newLoc = fileNamesByprocessedUrls.get(workedUrl);
        if (newLoc != null) {
          childElement.setAttribute(locAttribute, newLoc);
        }
      }
    }
  }

  /**
   * Main method, pass in the URL to find the WSDL, and the xsd prefix that everything is changed
   * to.
   */
  public static void main(final String[] in_args) {
    String[] args;
    if (in_args.length == 1) {
      String only = in_args[0];
      args = only.split(" ");
    } else {
      args = in_args;
    }
    if (args.length != 2) {
      System.out.println("Only two parameters: 1--wsdl-url 2--xsds-prefix");
      System.out.println("You passed " + List.of(args).stream().collect(Collectors.joining(", ")));
      return;
    }
    String xsdUrl = args[0];
    String filePrefix = args[1];
    System.out.println("XsdUrl: " + xsdUrl);
    System.out.println("filePrefix: " + filePrefix);
    XsdDownloader xsdDownloader = new XsdDownloader(filePrefix);
    try {
      xsdDownloader.downloadXsdRecurse(xsdUrl, "");
    } catch (IOException | ParserConfigurationException | SAXException | TransformerException e) {
      e.printStackTrace();
    }
  }
}
