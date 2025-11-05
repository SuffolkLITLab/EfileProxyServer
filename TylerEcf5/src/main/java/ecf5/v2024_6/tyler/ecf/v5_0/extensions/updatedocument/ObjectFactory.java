
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.updatedocument;

import javax.xml.namespace.QName;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.DocumentType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.tyler.ecf.v5_0.extensions.updatedocument package. 
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

    private final static QName _ReviewedLeadDocument_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:updatedocument", "ReviewedLeadDocument");
    private final static QName _ReviewedConnectedDocument_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:updatedocument", "ReviewedConnectedDocument");
    private final static QName _UpdateDocumentMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:updatedocument", "UpdateDocumentMessage");
    private final static QName _UpdateDocumentMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:updatedocument", "UpdateDocumentMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.tyler.ecf.v5_0.extensions.updatedocument
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateDocumentMessageType }
     * 
     */
    public UpdateDocumentMessageType createUpdateDocumentMessageType() {
        return new UpdateDocumentMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:updatedocument", name = "ReviewedLeadDocument")
    public JAXBElement<DocumentType> createReviewedLeadDocument(DocumentType value) {
        return new JAXBElement<DocumentType>(_ReviewedLeadDocument_QNAME, DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:updatedocument", name = "ReviewedConnectedDocument")
    public JAXBElement<DocumentType> createReviewedConnectedDocument(DocumentType value) {
        return new JAXBElement<DocumentType>(_ReviewedConnectedDocument_QNAME, DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateDocumentMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateDocumentMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:updatedocument", name = "UpdateDocumentMessage")
    public JAXBElement<UpdateDocumentMessageType> createUpdateDocumentMessage(UpdateDocumentMessageType value) {
        return new JAXBElement<UpdateDocumentMessageType>(_UpdateDocumentMessage_QNAME, UpdateDocumentMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:updatedocument", name = "UpdateDocumentMessageAugmentationPoint")
    public JAXBElement<Object> createUpdateDocumentMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_UpdateDocumentMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
