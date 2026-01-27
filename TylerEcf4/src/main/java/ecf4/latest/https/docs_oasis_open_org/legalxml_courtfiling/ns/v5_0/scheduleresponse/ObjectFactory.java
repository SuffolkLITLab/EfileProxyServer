
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.scheduleresponse;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.scheduleresponse package. 
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

    private final static QName _GetCourtScheduleResponseMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/scheduleresponse", "GetCourtScheduleResponseMessage");
    private final static QName _GetCourtScheduleResponseMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/scheduleresponse", "GetCourtScheduleResponseMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.scheduleresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCourtScheduleResponseMessageType }
     * 
     */
    public GetCourtScheduleResponseMessageType createGetCourtScheduleResponseMessageType() {
        return new GetCourtScheduleResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCourtScheduleResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCourtScheduleResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/scheduleresponse", name = "GetCourtScheduleResponseMessage")
    public JAXBElement<GetCourtScheduleResponseMessageType> createGetCourtScheduleResponseMessage(GetCourtScheduleResponseMessageType value) {
        return new JAXBElement<GetCourtScheduleResponseMessageType>(_GetCourtScheduleResponseMessage_QNAME, GetCourtScheduleResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/scheduleresponse", name = "GetCourtScheduleResponseMessageAugmentationPoint")
    public JAXBElement<Object> createGetCourtScheduleResponseMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetCourtScheduleResponseMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
