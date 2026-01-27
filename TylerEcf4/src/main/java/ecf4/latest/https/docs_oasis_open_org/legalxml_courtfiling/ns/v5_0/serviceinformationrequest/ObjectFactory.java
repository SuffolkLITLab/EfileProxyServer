
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.serviceinformationrequest;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.serviceinformationrequest package. 
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

    private final static QName _GetServiceInformationRequestMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/serviceinformationrequest", "GetServiceInformationRequestMessage");
    private final static QName _GetServiceInformationRequestMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/serviceinformationrequest", "GetServiceInformationRequestMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.serviceinformationrequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetServiceInformationRequestMessageType }
     * 
     */
    public GetServiceInformationRequestMessageType createGetServiceInformationRequestMessageType() {
        return new GetServiceInformationRequestMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceInformationRequestMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetServiceInformationRequestMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/serviceinformationrequest", name = "GetServiceInformationRequestMessage")
    public JAXBElement<GetServiceInformationRequestMessageType> createGetServiceInformationRequestMessage(GetServiceInformationRequestMessageType value) {
        return new JAXBElement<GetServiceInformationRequestMessageType>(_GetServiceInformationRequestMessage_QNAME, GetServiceInformationRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/serviceinformationrequest", name = "GetServiceInformationRequestMessageAugmentationPoint")
    public JAXBElement<Object> createGetServiceInformationRequestMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetServiceInformationRequestMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
