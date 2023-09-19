
package oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FilingStatusQueryMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FilingStatusQueryMessage-4.0", "FilingStatusQueryMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FilingStatusQueryMessageType }
     * 
     */
    public FilingStatusQueryMessageType createFilingStatusQueryMessageType() {
        return new FilingStatusQueryMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingStatusQueryMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingStatusQueryMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FilingStatusQueryMessage-4.0", name = "FilingStatusQueryMessage")
    public JAXBElement<FilingStatusQueryMessageType> createFilingStatusQueryMessage(FilingStatusQueryMessageType value) {
        return new JAXBElement<FilingStatusQueryMessageType>(_FilingStatusQueryMessage_QNAME, FilingStatusQueryMessageType.class, null, value);
    }

}
