
package ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusresponsemessage_4;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusresponsemessage_4 package. 
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

    private final static QName _FilingStatusResponseMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FilingStatusResponseMessage-4.0", "FilingStatusResponseMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusresponsemessage_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FilingStatusResponseMessageType }
     * 
     */
    public FilingStatusResponseMessageType createFilingStatusResponseMessageType() {
        return new FilingStatusResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingStatusResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingStatusResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FilingStatusResponseMessage-4.0", name = "FilingStatusResponseMessage")
    public JAXBElement<FilingStatusResponseMessageType> createFilingStatusResponseMessage(FilingStatusResponseMessageType value) {
        return new JAXBElement<FilingStatusResponseMessageType>(_FilingStatusResponseMessage_QNAME, FilingStatusResponseMessageType.class, null, value);
    }

}
