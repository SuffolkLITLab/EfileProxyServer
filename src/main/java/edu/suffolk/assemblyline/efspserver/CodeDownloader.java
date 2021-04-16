package edu.suffolk.assemblyline.efspserver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CodeDownloader {

  public static Document loadCodesXml(String fileName) throws Exception {
    File file = new File(fileName);
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(file);
    doc.getDocumentElement().normalize();
    return doc;
  }

  public static Optional<Node> getSubElement(Node node, String subelementName) {
    if (!node.hasChildNodes()) {
      return Optional.empty();
    }
    for (int i = 0; i < node.getChildNodes().getLength(); i++) {
      Node childNode = node.getChildNodes().item(i);
      if (childNode.getNodeName() != null && childNode.getNodeName().equals(subelementName)) {
        return Optional.of(childNode);
      }
    }
    return Optional.empty();
  }

  public static List<Node> getAllSubElements(Node node, String subelementName) {
    List<Node> fullList = new ArrayList<Node>();
    if (!node.hasChildNodes()) {
      return fullList;
    }

    for (int i = 0; i < node.getChildNodes().getLength(); i++) {
      Node childNode = node.getChildNodes().item(i);
      if (childNode.getNodeName() != null && childNode.getNodeName().equals(subelementName)) {
        fullList.add(childNode);
      }
    }
    return fullList;
  }

  public static Optional<String> getAttribute(Node node, String attrName) {
    if (node.getAttributes() != null && node.getAttributes().getLength() == 0) {
      return Optional.empty();
    }
    Node attr = node.getAttributes().getNamedItem(attrName);
    if (attr != null) {
      return Optional.of(attr.getNodeValue());
    }
    return Optional.empty();
  }

  public static void writeCsv(Document codeXml, String outFileName) throws IOException {
    File outFile = new File(outFileName);
    BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

    // Write all the Columns to the CSV
    NodeList nodeList = codeXml.getElementsByTagName("CodeList").item(0).getChildNodes();
    Optional<NodeList> maybeColumns = Optional.empty();
    Optional<NodeList> maybeRows = Optional.empty();
    for (int i = 0; i < nodeList.getLength(); i++) {
      String name = nodeList.item(i).getNodeName();
      System.out.println(
          "Val: "
              + name
              + ", "
              + nodeList.item(i).getNodeName()
              + ", "
              + nodeList.item(i).getNodeType());
      if (name != null && name.equals("ColumnSet")) {
        maybeColumns = Optional.of(nodeList.item(i).getChildNodes());
      } else if (name != null && name.equals("SimpleCodeList")) {
        maybeRows = Optional.of(nodeList.item(i).getChildNodes());
      }
    }

    // TODO(brycew): would like to do something more functional, but NodeList is lacking
    // constructors or functional items
    NodeList columnsList = maybeColumns.orElseThrow();

    Map<String, Integer> columnIndices = new HashMap<String, Integer>();
    ArrayList<String> defaultColValues = new ArrayList<String>();
    for (int i = 0; i < columnsList.getLength(); i++) {
      Node node = columnsList.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        System.out.println(
            "Cols: " + node.getNodeName() + ", " + node.getNodeValue() + ", " + node.getNodeType());
        Optional<Node> maybeChild = getSubElement(node, "ShortName");
        Optional<String> maybeId = getAttribute(node, "Id");
        maybeId.ifPresent(
            (id) -> {
              columnIndices.put(id, defaultColValues.size());
              defaultColValues.add(id);
            });

        if (maybeChild.isPresent()) {
          Node nameNode = maybeChild.get();
          writer.append(nameNode.getTextContent());
          if (i < columnsList.getLength() - 1) {
            writer.append(';');
          }
        }
      }
    }
    writer.newLine();

    // Write each row
    NodeList rowList = maybeRows.orElseThrow();

    for (int i = 0; i < rowList.getLength(); i++) {
      ArrayList<String> theseColValues = new ArrayList<String>(defaultColValues);
      Node node = rowList.item(i);
      if (node.getNodeType() != Node.ELEMENT_NODE) {
        continue;
      }
      List<Node> allValues = getAllSubElements(node, "Value");
      for (Node n : allValues) {
        Optional<String> maybeId = getAttribute(n, "ColumnRef");
        Optional<Node> maybeVal = getSubElement(n, "SimpleValue");
        if (maybeId.isPresent() && maybeVal.isPresent()) {
          int idx = columnIndices.get(maybeId.get());
          theseColValues.set(idx, maybeVal.get().getTextContent());
        }
      }
      writer.append(String.join(";", theseColValues));
      writer.newLine();
    }

    writer.close();
  }

  public static void readCodes() throws Exception {
    // TODO(brycew): ready directly from zip as well
    Document doc = loadCodesXml("testing_codes/locations.xml");
    writeCsv(doc, "testing_codes/locations.csv");
  }

  /**
   * https://stackoverflow.com/a/1485730/11416267
   *
   * @return
   */
  public static InputStream getHtml(String urlToRead, String authHeader) throws Exception {
    URL url = new URL(urlToRead);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("tyl-efm-api", authHeader);
    return conn.getInputStream();
  }

  public static void download() throws Exception {
    HeaderSigner signer = new HeaderSigner();
    String signedTime = signer.signedCurrentTime();
    // TODO(brycew): make this an env variable somehow
    String baseUrl = "https://illinois-stage.tylerhost.net";
    List<String> codeUrls = Arrays.asList(
        "/CodeService/codes/version/",
        "/CodeService/codes/location/"
        );

    for (String urlSuffix : codeUrls) {
      InputStream urlStream = getHtml(baseUrl + urlSuffix, signedTime); 
      // Write out the zip file
      FileOutputStream fileOut = new FileOutputStream(urlSuffix.replace('/', '_') + ".zip");
      long length = urlStream.transferTo(fileOut);
      System.out.println(length + " bytes transfered for " + urlSuffix);
    }

    // TODO(brycew): use GetPolicy to get all of these specific URLs
    //"/CodeService/codes/error/",
    //"/CodeService/codes/country/",
    //"/CodeService/codes/state/",
    //"/CodeService/codes/filingstatus/",
    //"/CodeService/codes/datafield/"
    
    // TODO(brycew): use the version codes to check the checksums of each table, 
    // then see if we need to update
  }

  public static void main(String[] args) throws Exception {
    //readCodes();
    download();
  }
}
