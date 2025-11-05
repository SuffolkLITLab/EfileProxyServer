
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.requestdateresponse;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.requestdateresponse package. 
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

    private final static QName _CourtDate_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/requestdateresponse", "CourtDate");
    private final static QName _RequestCourtDateResponseMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/requestdateresponse", "RequestCourtDateResponseMessage");
    private final static QName _RequestCourtResponseMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/requestdateresponse", "RequestCourtResponseMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.requestdateresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CourtDateType }
     * 
     */
    public CourtDateType createCourtDateType() {
        return new CourtDateType();
    }

    /**
     * Create an instance of {@link RequestCourtDateResponseMessageType }
     * 
     */
    public RequestCourtDateResponseMessageType createRequestCourtDateResponseMessageType() {
        return new RequestCourtDateResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtDateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtDateType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/requestdateresponse", name = "CourtDate")
    public JAXBElement<CourtDateType> createCourtDate(CourtDateType value) {
        return new JAXBElement<CourtDateType>(_CourtDate_QNAME, CourtDateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestCourtDateResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RequestCourtDateResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/requestdateresponse", name = "RequestCourtDateResponseMessage")
    public JAXBElement<RequestCourtDateResponseMessageType> createRequestCourtDateResponseMessage(RequestCourtDateResponseMessageType value) {
        return new JAXBElement<RequestCourtDateResponseMessageType>(_RequestCourtDateResponseMessage_QNAME, RequestCourtDateResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/requestdateresponse", name = "RequestCourtResponseMessageAugmentationPoint")
    public JAXBElement<Object> createRequestCourtResponseMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_RequestCourtResponseMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
