
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.schedulerequest;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.schedulerequest package. 
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

    private final static QName _GetCourtScheduleRequestMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/schedulerequest", "GetCourtScheduleRequestMessage");
    private final static QName _GetCourtScheduleRequestMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/schedulerequest", "GetCourtScheduleRequestMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.schedulerequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCourtScheduleRequestMessageType }
     * 
     */
    public GetCourtScheduleRequestMessageType createGetCourtScheduleRequestMessageType() {
        return new GetCourtScheduleRequestMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCourtScheduleRequestMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCourtScheduleRequestMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/schedulerequest", name = "GetCourtScheduleRequestMessage")
    public JAXBElement<GetCourtScheduleRequestMessageType> createGetCourtScheduleRequestMessage(GetCourtScheduleRequestMessageType value) {
        return new JAXBElement<GetCourtScheduleRequestMessageType>(_GetCourtScheduleRequestMessage_QNAME, GetCourtScheduleRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/schedulerequest", name = "GetCourtScheduleRequestMessageAugmentationPoint")
    public JAXBElement<Object> createGetCourtScheduleRequestMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetCourtScheduleRequestMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
