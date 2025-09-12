package edu.suffolk.litlab.efsp.ecfcodes;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.oasis_open.docs.codelist.ns.genericode._1.CodeListDocument;
import org.oasis_open.docs.codelist.ns.genericode._1.ColumnSet;
import org.oasis_open.docs.codelist.ns.genericode._1.Identification;

/**
 * A class that iterates over Genericode XML files using constant memory.
 *
 * <p>Call <code>CodeDocIterator.setup()</code> to create the class, and then just treat it like any
 * normal iterator.
 *
 * <p>See <a
 * href="https://docs.oasis-open.org/codelist/genericode/v1.0/os/genericode-v1.0-os.html">the
 * Genericode spec</a> for more information about the XML structure this class expects, and <a
 * href="https://docs.oracle.com/en/java/javase/21/docs/api/java.xml/javax/xml/stream/XMLEventReader.html">the
 * XmlEventReader docs</a> for more information about how we navigate XML.
 *
 * <p>The default XmlReaderStream would load in the entire XML file at once, and some of the files
 * that we read in can be rather large, around 800MB (2.5GB when read in memory).
 */
public class CodeDocIterator implements Iterator<Map<String, String>> {

  private static final XMLInputFactory xmlFactory = XMLInputFactory.newInstance();
  // For some reason, the elements don't have namespaces? so we just ignore them.
  private static final QName ID_TAG = new QName("Identification");
  private static final QName COLUMN_SET_TAG = new QName("ColumnSet");
  private static final QName ROW_TAG = new QName("Row");
  private static final QName VALUE_TAG = new QName("Value");
  private static final QName COLUMN_REF_TAG = new QName("ColumnRef");
  private static final QName SIMPLE_VALUE_TAG = new QName("SimpleValue");

  private final XMLEventReader reader;
  /// From the Identification / Version tags.
  private final String version;
  private final ColumnSet columnSet;

  private Map<String, String> nextRow;

  public static CodeDocIterator setup(InputStream input) throws CodeDocException {
    try {
      XMLEventReader reader = xmlFactory.createXMLEventReader(input);
      var unmarshaller = JAXBContext.newInstance(CodeListDocument.class).createUnmarshaller();
      var version = findAndParse(reader, unmarshaller, ID_TAG, Identification.class).getVersion();
      var columnSet = findAndParse(reader, unmarshaller, COLUMN_SET_TAG, ColumnSet.class);
      var iterator = new CodeDocIterator(reader, version, columnSet);
      iterator.findNextRow();
      return iterator;
    } catch (Exception ex) {
      throw new CodeDocException("Error when starting to parse code list: ", ex);
    }
  }

  /**
   * Seeks to and parses the given clazz whole from the XML.
   *
   * <p>Needs to be a fully self-contained class, i.e. no references to other ids or XML objects.
   * Right now only used for <code>&lt;Identification&gt;</code> and <code>&lt;ColumnSet&gt;</code>.
   */
  private static <T> T findAndParse(
      XMLEventReader reader, Unmarshaller u, QName name, Class<T> clazz)
      throws XMLStreamException, JAXBException {
    XMLEvent event = reader.peek();
    while (event != null && !isStartOfElement(event, name)) {
      reader.next();
      event = reader.peek();
    }
    if (event == null) {
      throw new RuntimeException("Reached EOF but couldn't find " + name);
    }
    return u.unmarshal(reader, clazz).getValue();
  }

  private static boolean isStartOfElement(XMLEvent event, QName tagName) {
    if (event instanceof StartElement start) {
      return start.getName().equals(tagName);
    }
    return false;
  }

  /**
   * Gets the version of the CodeDoc, i.e.
   * &lt;Identification&gt;&lt;Version&gt;84D2F1B7...^lt;/Version&gt;
   */
  public String getVersion() {
    return version;
  }

  @Override
  public boolean hasNext() {
    return nextRow != null;
  }

  /** Returns a row of the genericode object, as a map from the Column Id to its value. */
  @Override
  public Map<String, String> next() {
    var toReturn = this.nextRow;
    try {
      findNextRow();
    } catch (Exception ex) {
      this.nextRow = null;
    }
    return toReturn;
  }

  /** See {@link #setup(InputStream)} for how to actually instantiate this object. */
  private CodeDocIterator(XMLEventReader reader, String version, ColumnSet columnSet) {
    this.reader = reader;
    this.version = version;
    this.columnSet = columnSet;
  }

  private void findNextRow() throws XMLStreamException {
    try {
      var something = reader.next();
      while (something != null) {
        XMLEvent event = reader.peek();
        if (isStartOfElement(event, ROW_TAG)) {
          this.nextRow = getRowValues();
          return;
        }
        something = reader.next();
      }
      this.nextRow = null;
    } catch (NoSuchElementException ex) {
      this.nextRow = null;
    }
  }

  private Map<String, String> getRowValues() throws XMLStreamException {
    StartElement valueElem = seekToElement(reader, VALUE_TAG, ROW_TAG);
    var map = new HashMap<String, String>(columnSet.getColumnChoice().size());
    while (valueElem != null) {
      String columnRef = valueElem.getAttributeByName(COLUMN_REF_TAG).getValue();
      seekToElement(reader, SIMPLE_VALUE_TAG, VALUE_TAG);
      String simpleValue = reader.getElementText();
      map.put(columnRef, simpleValue);

      valueElem = seekToElement(reader, VALUE_TAG, ROW_TAG);
    }
    return map;
  }

  private static StartElement seekToElement(XMLEventReader reader, QName name, QName stopName)
      throws XMLStreamException {
    XMLEvent event = reader.nextEvent();
    while (event != null) {
      if (event instanceof StartElement start && start.getName().equals(name)) {
        return start;
      }
      if (event instanceof EndElement end && end.getName().equals(stopName)) {
        return null;
      }
      event = reader.nextEvent();
    }
    return null;
  }
}
