
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.serviceinformationresponse;

import javax.xml.namespace.QName;
import gov.niem.release.niem.niem_core._4.EntityType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.serviceinformationresponse package. 
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

    private final static QName _GetServiceInformationResponseMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/serviceinformationresponse", "GetServiceInformationResponseMessage");
    private final static QName _GetServiceInformationResponseMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/serviceinformationresponse", "GetServiceInformationResponseMessageAugmentationPoint");
    private final static QName _ServiceRecipient_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/serviceinformationresponse", "ServiceRecipient");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.serviceinformationresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetServiceInformationResponseMessageType }
     * 
     */
    public GetServiceInformationResponseMessageType createGetServiceInformationResponseMessageType() {
        return new GetServiceInformationResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceInformationResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetServiceInformationResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/serviceinformationresponse", name = "GetServiceInformationResponseMessage")
    public JAXBElement<GetServiceInformationResponseMessageType> createGetServiceInformationResponseMessage(GetServiceInformationResponseMessageType value) {
        return new JAXBElement<GetServiceInformationResponseMessageType>(_GetServiceInformationResponseMessage_QNAME, GetServiceInformationResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/serviceinformationresponse", name = "GetServiceInformationResponseMessageAugmentationPoint")
    public JAXBElement<Object> createGetServiceInformationResponseMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetServiceInformationResponseMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/serviceinformationresponse", name = "ServiceRecipient")
    public JAXBElement<EntityType> createServiceRecipient(EntityType value) {
        return new JAXBElement<EntityType>(_ServiceRecipient_QNAME, EntityType.class, null, value);
    }

}
