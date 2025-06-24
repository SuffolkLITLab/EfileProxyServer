
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.requestdaterequest;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.requestdaterequest package. 
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

    private final static QName _RequestCourtDateRequestMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/requestdaterequest", "RequestCourtDateRequestMessageAugmentationPoint");
    private final static QName _RequestCourtDateRequestMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/requestdaterequest", "RequestCourtDateRequestMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.requestdaterequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestCourtDateRequestMessageType }
     * 
     */
    public RequestCourtDateRequestMessageType createRequestCourtDateRequestMessageType() {
        return new RequestCourtDateRequestMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/requestdaterequest", name = "RequestCourtDateRequestMessageAugmentationPoint")
    public JAXBElement<Object> createRequestCourtDateRequestMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_RequestCourtDateRequestMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestCourtDateRequestMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RequestCourtDateRequestMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/requestdaterequest", name = "RequestCourtDateRequestMessage")
    public JAXBElement<RequestCourtDateRequestMessageType> createRequestCourtDateRequestMessage(RequestCourtDateRequestMessageType value) {
        return new JAXBElement<RequestCourtDateRequestMessageType>(_RequestCourtDateRequestMessage_QNAME, RequestCourtDateRequestMessageType.class, null, value);
    }

}
