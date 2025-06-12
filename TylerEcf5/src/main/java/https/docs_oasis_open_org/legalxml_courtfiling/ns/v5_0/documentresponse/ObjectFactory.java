
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.documentresponse;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.documentresponse package. 
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

    private final static QName _GetDocumentResponseMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentresponse", "GetDocumentResponseMessage");
    private final static QName _GetDocumentResponseMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentresponse", "GetDocumentResponseMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.documentresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDocumentResponseMessageType }
     * 
     */
    public GetDocumentResponseMessageType createGetDocumentResponseMessageType() {
        return new GetDocumentResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDocumentResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetDocumentResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentresponse", name = "GetDocumentResponseMessage")
    public JAXBElement<GetDocumentResponseMessageType> createGetDocumentResponseMessage(GetDocumentResponseMessageType value) {
        return new JAXBElement<GetDocumentResponseMessageType>(_GetDocumentResponseMessage_QNAME, GetDocumentResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentresponse", name = "GetDocumentResponseMessageAugmentationPoint")
    public JAXBElement<Object> createGetDocumentResponseMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetDocumentResponseMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
