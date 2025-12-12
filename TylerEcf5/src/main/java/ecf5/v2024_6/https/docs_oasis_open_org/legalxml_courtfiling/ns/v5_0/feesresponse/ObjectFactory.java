
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.feesresponse;

import javax.xml.namespace.QName;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.AmountType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.feesresponse package. 
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

    private final static QName _FeesCalculationAmount_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/feesresponse", "FeesCalculationAmount");
    private final static QName _GetFeesCalculationResponseMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/feesresponse", "GetFeesCalculationResponseMessage");
    private final static QName _GetFeesCalculationResponseMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/feesresponse", "GetFeesCalculationResponseMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.feesresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFeesCalculationResponseMessageType }
     * 
     */
    public GetFeesCalculationResponseMessageType createGetFeesCalculationResponseMessageType() {
        return new GetFeesCalculationResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/feesresponse", name = "FeesCalculationAmount")
    public JAXBElement<AmountType> createFeesCalculationAmount(AmountType value) {
        return new JAXBElement<AmountType>(_FeesCalculationAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFeesCalculationResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFeesCalculationResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/feesresponse", name = "GetFeesCalculationResponseMessage")
    public JAXBElement<GetFeesCalculationResponseMessageType> createGetFeesCalculationResponseMessage(GetFeesCalculationResponseMessageType value) {
        return new JAXBElement<GetFeesCalculationResponseMessageType>(_GetFeesCalculationResponseMessage_QNAME, GetFeesCalculationResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/feesresponse", name = "GetFeesCalculationResponseMessageAugmentationPoint")
    public JAXBElement<Object> createGetFeesCalculationResponseMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetFeesCalculationResponseMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
