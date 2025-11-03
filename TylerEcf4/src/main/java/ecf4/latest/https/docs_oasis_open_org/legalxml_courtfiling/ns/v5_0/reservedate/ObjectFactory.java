
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reservedate;

import javax.xml.namespace.QName;
import ecf4.latest.gov.niem.release.niem.niem_core._4.DateRangeType;
import ecf4.latest.gov.niem.release.niem.proxy.xsd._4.Duration;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reservedate package. 
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

    private final static QName _ReserveCourtDateMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reservedate", "ReserveCourtDateMessageAugmentationPoint");
    private final static QName _EstimatedDuration_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reservedate", "EstimatedDuration");
    private final static QName _PotentialStartTimeRange_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reservedate", "PotentialStartTimeRange");
    private final static QName _ReserveCourtDateMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reservedate", "ReserveCourtDateMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reservedate
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReserveCourtDateMessageType }
     * 
     */
    public ReserveCourtDateMessageType createReserveCourtDateMessageType() {
        return new ReserveCourtDateMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reservedate", name = "ReserveCourtDateMessageAugmentationPoint")
    public JAXBElement<Object> createReserveCourtDateMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_ReserveCourtDateMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reservedate", name = "EstimatedDuration")
    public JAXBElement<Duration> createEstimatedDuration(Duration value) {
        return new JAXBElement<Duration>(_EstimatedDuration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reservedate", name = "PotentialStartTimeRange")
    public JAXBElement<DateRangeType> createPotentialStartTimeRange(DateRangeType value) {
        return new JAXBElement<DateRangeType>(_PotentialStartTimeRange_QNAME, DateRangeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveCourtDateMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReserveCourtDateMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reservedate", name = "ReserveCourtDateMessage")
    public JAXBElement<ReserveCourtDateMessageType> createReserveCourtDateMessage(ReserveCourtDateMessageType value) {
        return new JAXBElement<ReserveCourtDateMessageType>(_ReserveCourtDateMessage_QNAME, ReserveCourtDateMessageType.class, null, value);
    }

}
