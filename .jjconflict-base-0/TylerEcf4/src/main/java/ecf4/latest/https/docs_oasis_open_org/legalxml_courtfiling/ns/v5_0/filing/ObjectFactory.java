
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filing;

import javax.xml.namespace.QName;
import ecf4.latest.gov.niem.release.niem.niem_core._4.DocumentType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filing package. 
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

    private final static QName _FilingConnectedDocument_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing", "FilingConnectedDocument");
    private final static QName _FilingLeadDocument_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing", "FilingLeadDocument");
    private final static QName _FilingMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing", "FilingMessage");
    private final static QName _FilingMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing", "FilingMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filing
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FilingMessageType }
     * 
     */
    public FilingMessageType createFilingMessageType() {
        return new FilingMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing", name = "FilingConnectedDocument")
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
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing", name = "FilingLeadDocument")
    public JAXBElement<DocumentType> createFilingLeadDocument(DocumentType value) {
        return new JAXBElement<DocumentType>(_FilingLeadDocument_QNAME, DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing", name = "FilingMessage")
    public JAXBElement<FilingMessageType> createFilingMessage(FilingMessageType value) {
        return new JAXBElement<FilingMessageType>(_FilingMessage_QNAME, FilingMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing", name = "FilingMessageAugmentationPoint")
    public JAXBElement<Object> createFilingMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_FilingMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
