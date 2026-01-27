
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.feesrequest;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.feesrequest package. 
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

    private final static QName _GetFeesCalculationRequestMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/feesrequest", "GetFeesCalculationRequestMessage");
    private final static QName _GetFeesCalculationRequestMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/feesrequest", "GetFeesCalculationRequestMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.feesrequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFeesCalculationRequestMessageType }
     * 
     */
    public GetFeesCalculationRequestMessageType createGetFeesCalculationRequestMessageType() {
        return new GetFeesCalculationRequestMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFeesCalculationRequestMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFeesCalculationRequestMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/feesrequest", name = "GetFeesCalculationRequestMessage")
    public JAXBElement<GetFeesCalculationRequestMessageType> createGetFeesCalculationRequestMessage(GetFeesCalculationRequestMessageType value) {
        return new JAXBElement<GetFeesCalculationRequestMessageType>(_GetFeesCalculationRequestMessage_QNAME, GetFeesCalculationRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/feesrequest", name = "GetFeesCalculationRequestMessageAugmentationPoint")
    public JAXBElement<Object> createGetFeesCalculationRequestMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetFeesCalculationRequestMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
