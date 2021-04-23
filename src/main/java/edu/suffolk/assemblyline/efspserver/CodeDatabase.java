package edu.suffolk.assemblyline.efspserver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.oasis_open.docs.codelist.ns.genericode._1.CodeListDocument;
import org.oasis_open.docs.codelist.ns.genericode._1.Column;
import org.oasis_open.docs.codelist.ns.genericode._1.Key;
import org.oasis_open.docs.codelist.ns.genericode._1.Row;
import org.oasis_open.docs.codelist.ns.genericode._1.Value;

public class CodeDatabase {

  private Map<String, Map<String, String>> locationCodes;
  private Map<String, Map<String, String>> versionCodes;
  private Map<String, Map<String, String>> errorCodes;
  private Map<String, Map<String, String>> countryCodes;
  private Map<String, Map<String, String>> stateCodes;
  private Map<String, Map<String, String>> dataFieldConfigCodes;
  
  
  private Optional<Map<String, Map<String, String>>> readCodes(String fileName) {
    try {
      if (fileName.endsWith(".zip")) {
        ZipFile zip = new ZipFile(fileName);
        // This works because there should only be a single xml in the zip
        ZipEntry entry = zip.entries().asIterator().next(); 
        Map<String, Map<String, String>> codes = readCodes(zip.getInputStream(entry));
        zip.close();
        return Optional.of(codes); 
      } else if (fileName.endsWith(".xml")) {
        FileInputStream is = new FileInputStream(fileName);
        Map<String, Map<String, String>> codes = readCodes(is);
        is.close();
        return Optional.of(codes); 
      } else {
        System.err.println("Wasn't able to load codes from " + fileName + "!");
        return Optional.empty();
      }
    } catch (JAXBException jaxEx) {
      System.err.println("Wasn't able to load codes from " + fileName + "!");
      return Optional.empty();

    } catch (FileNotFoundException ex) {
      return Optional.empty();
    } catch (IOException ioEx) {
      return Optional.empty();
    }
  }

  /**
   * Reads any genericode XML file into a usable dataframe-like Map.
   * Genericode spec is at https://www.oasis-open.org/committees/download.php/24288/oasis-code-list-representation-genericode.pdf
   *
   * @param fileName The path to the XML file
   * @return a map from Keys to Rows, which are maps from column names to the values
   * @throws JAXBException if the file isn't actually a genericode object
   */
  private Map<String, Map<String, String>> readCodes(InputStream inStream) throws JAXBException {
    Map<String, Map<String, String>> codes = new HashMap<String, Map<String, String>>();
    
    JAXBContext jc = JAXBContext.newInstance(CodeListDocument.class);
    Unmarshaller u = jc.createUnmarshaller();
    JAXBElement<CodeListDocument> doc = 
        (JAXBElement<CodeListDocument>) u.unmarshal(inStream); 
    CodeListDocument trueDoc = doc.getValue();
    
    Map<String, Integer> columnIndices = new HashMap<String, Integer>();
    Map<String, String> defaultColValues = new HashMap<String, String>();
    for (Object obj : trueDoc.getColumnSet().getColumnChoice()) {
      if (!(obj instanceof Column)) {
        continue;
      }
      Column col = (Column) obj;
      // TODO(brycew): do something with all of the column information
      columnIndices.put(col.getId(), defaultColValues.size());
      defaultColValues.put(col.getId(), "");  // If no value in is a row, it should be a string?
    }
    Object keyObj = trueDoc.getColumnSet().getKeyChoice().get(0);
    String keyId = "";
    if (keyObj instanceof Key) {
      keyId = ((Key) keyObj).getColumnRef().get(0).getRef().toString();
    }
    
    for (Row r : trueDoc.getSimpleCodeList().getRow()) {
      Map<String, String> rowsVals = new HashMap<String, String>(defaultColValues);
      String keyString = "";
      for (Value v : r.getValue()) {
        // TODO(brycew): will all be simple values?
        rowsVals.put(v.getColumnRef().toString(), v.getSimpleValue().getValue());
        if (v.getColumnRef().toString().equals(keyId)) {
          keyString = v.getSimpleValue().getValue();
        }
      }
      if (keyString.equals("")) {
        continue;
      }
      codes.put(keyString, defaultColValues);
    }
    return codes;
  }

  /**
   * Writes a CSV file from the given codes map object. Mostly for easy viewing of the codes.
   */
  public void writeCsv(Map<String, Map<String, String>> codes, 
                              String outFileName) throws IOException {
    File outFile = new File(outFileName);
    BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

    writer.append(String.join(";", codes.keySet()));
    
    List<String> colOrder = new ArrayList<String>();
    for (Map.Entry<String, Map<String, String>> entry : codes.entrySet()) {
      colOrder.add(entry.getKey()); 
      writer.append(entry.getKey());
      writer.append(";");
    }
    writer.newLine();
    
    for (Map.Entry<String, Map<String, String>> entry : codes.entrySet()) {
      for (String col : colOrder) {
        writer.append(entry.getValue().get(col));
        writer.append(";");
      }
      writer.newLine();
    }

    writer.close();
  }

  public void updateAllCodes() {
    
  }
  
  /** Reads the database information from files.
   *
   * @param locationFile File with court location genericode information, either as Zip or XML
   * @param versionFile File with information about other codes for a specific court
   * @return
   */
  public boolean loadFromFiles(String locationFile, String versionFile) {
    Optional<Map<String, Map<String, String>>> maybeLocCodes = readCodes(locationFile);
    Optional<Map<String, Map<String, String>>> maybeVerCodes = readCodes(versionFile);
    if (maybeLocCodes.isEmpty() || maybeVerCodes.isEmpty()) {
      System.err.println("Loc codes empty?: " + maybeLocCodes.isEmpty() + 
          ", Ver codes empty?: " + maybeVerCodes.isEmpty());
      return false;
    }
    locationCodes = maybeLocCodes.get();
    versionCodes = maybeVerCodes.get();
    return true;
  }
}
