package edu.suffolk.litlab.efsp.ecfcodes;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import org.junit.jupiter.api.Test;
import org.oasis_open.docs.codelist.ns.genericode._1.CodeListDocument;
import org.oasis_open.docs.codelist.ns.genericode._1.Column;

public class CodeDocIteratorTest {

  @Test
  public void testReadStandardCodeDoc() throws Exception {
    compareIteratorVsXmlStreamReader("/genericode_examples/casecategory.xml");
  }

  @Test
  public void testReadMinimal() throws Exception {
    compareIteratorVsXmlStreamReader("/genericode_examples/casecategory-weird.xml");
  }

  private void compareIteratorVsXmlStreamReader(String filename) throws Exception {
    List<Map<String, String>> list = new ArrayList<>();
    var iterator = CodeDocIterator.setup(this.getClass().getResourceAsStream(filename));
    iterator.forEachRemaining(list::add);

    List<Map<String, String>> xsrList = new ArrayList<>();
    var xsrIterator = xmlStreamReader(this.getClass().getResourceAsStream(filename));
    xsrIterator.iter.forEachRemaining(xsrList::add);

    assertThat(iterator.getVersion()).isEqualTo(xsrIterator.version);

    for (int i = 0; i < list.size(); i++) {
      assertThat(list.get(i)).isEqualTo(xsrList.get(i));
    }
  }

  record XmlStuff(String version, Iterator<Map<String, String>> iter) {}

  private XmlStuff xmlStreamReader(InputStream inStream) throws Exception {
    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    XMLStreamReader xsr = xmlInputFactory.createXMLStreamReader(inStream);
    Unmarshaller u = JAXBContext.newInstance(CodeListDocument.class).createUnmarshaller();
    CodeListDocument doc = u.unmarshal(xsr, CodeListDocument.class).getValue();
    // Get the only parts of the type we need: the new version number, and a mapping between column
    // names and values.
    Iterator<Map<String, String>> rows =
        doc.getSimpleCodeList().getRow().stream()
            .map(
                r -> {
                  Map<String, String> rowVals = new HashMap<>();
                  for (var v : r.getValue()) {
                    Column c = (Column) v.getColumnRef();
                    rowVals.put(c.getId(), v.getSimpleValue().getValue());
                  }
                  return rowVals;
                })
            .iterator();
    return new XmlStuff(doc.getIdentification().getVersion(), rows);
  }
}
