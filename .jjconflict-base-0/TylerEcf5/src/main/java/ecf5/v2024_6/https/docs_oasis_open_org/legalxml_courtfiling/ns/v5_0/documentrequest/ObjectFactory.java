
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.documentrequest;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.documentrequest package. 
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

    private final static QName _DocumentQueryCriteria_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentrequest", "DocumentQueryCriteria");
    private final static QName _GetDocumentRequestMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentrequest", "GetDocumentRequestMessage");
    private final static QName _GetDocumentRequestMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentrequest", "GetDocumentRequestMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.documentrequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DocumentQueryCriteriaType }
     * 
     */
    public DocumentQueryCriteriaType createDocumentQueryCriteriaType() {
        return new DocumentQueryCriteriaType();
    }

    /**
     * Create an instance of {@link GetDocumentRequestMessageType }
     * 
     */
    public GetDocumentRequestMessageType createGetDocumentRequestMessageType() {
        return new GetDocumentRequestMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentQueryCriteriaType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentQueryCriteriaType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentrequest", name = "DocumentQueryCriteria")
    public JAXBElement<DocumentQueryCriteriaType> createDocumentQueryCriteria(DocumentQueryCriteriaType value) {
        return new JAXBElement<DocumentQueryCriteriaType>(_DocumentQueryCriteria_QNAME, DocumentQueryCriteriaType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDocumentRequestMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetDocumentRequestMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentrequest", name = "GetDocumentRequestMessage")
    public JAXBElement<GetDocumentRequestMessageType> createGetDocumentRequestMessage(GetDocumentRequestMessageType value) {
        return new JAXBElement<GetDocumentRequestMessageType>(_GetDocumentRequestMessage_QNAME, GetDocumentRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentrequest", name = "GetDocumentRequestMessageAugmentationPoint")
    public JAXBElement<Object> createGetDocumentRequestMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetDocumentRequestMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
