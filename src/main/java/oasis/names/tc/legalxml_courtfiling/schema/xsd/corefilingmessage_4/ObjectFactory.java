
package oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4;

import javax.xml.namespace.QName;
import gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4 package. 
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

    private final static QName _CoreFilingMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CoreFilingMessage-4.0", "CoreFilingMessage");
    private final static QName _FilingConfidentialityIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CoreFilingMessage-4.0", "FilingConfidentialityIndicator");
    private final static QName _FilingConnectedDocument_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CoreFilingMessage-4.0", "FilingConnectedDocument");
    private final static QName _FilingLeadDocument_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CoreFilingMessage-4.0", "FilingLeadDocument");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CoreFilingMessageType }
     * 
     */
    public CoreFilingMessageType createCoreFilingMessageType() {
        return new CoreFilingMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoreFilingMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoreFilingMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CoreFilingMessage-4.0", name = "CoreFilingMessage")
    public JAXBElement<CoreFilingMessageType> createCoreFilingMessage(CoreFilingMessageType value) {
        return new JAXBElement<CoreFilingMessageType>(_CoreFilingMessage_QNAME, CoreFilingMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CoreFilingMessage-4.0", name = "FilingConfidentialityIndicator")
    public JAXBElement<Boolean> createFilingConfidentialityIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_FilingConfidentialityIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CoreFilingMessage-4.0", name = "FilingConnectedDocument")
    public JAXBElement<DocumentType> createFilingConnectedDocument(DocumentType value) {
        return new JAXBElement<DocumentType>(_FilingConnectedDocument_QNAME, DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CoreFilingMessage-4.0", name = "FilingLeadDocument")
    public JAXBElement<DocumentType> createFilingLeadDocument(DocumentType value) {
        return new JAXBElement<DocumentType>(_FilingLeadDocument_QNAME, DocumentType.class, null, value);
    }

}
