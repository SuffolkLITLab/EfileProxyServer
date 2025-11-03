
package ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.serviceinformationresponsemessage_4;

import javax.xml.namespace.QName;
import ecf4.latest.gov.niem.niem.niem_core._2.EntityType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.serviceinformationresponsemessage_4 package. 
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

    private final static QName _ServiceInformationResponseMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:ServiceInformationResponseMessage-4.0", "ServiceInformationResponseMessage");
    private final static QName _ServiceRecipient_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:ServiceInformationResponseMessage-4.0", "ServiceRecipient");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.serviceinformationresponsemessage_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceInformationResponseMessageType }
     * 
     */
    public ServiceInformationResponseMessageType createServiceInformationResponseMessageType() {
        return new ServiceInformationResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceInformationResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceInformationResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:ServiceInformationResponseMessage-4.0", name = "ServiceInformationResponseMessage")
    public JAXBElement<ServiceInformationResponseMessageType> createServiceInformationResponseMessage(ServiceInformationResponseMessageType value) {
        return new JAXBElement<ServiceInformationResponseMessageType>(_ServiceInformationResponseMessage_QNAME, ServiceInformationResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:ServiceInformationResponseMessage-4.0", name = "ServiceRecipient")
    public JAXBElement<EntityType> createServiceRecipient(EntityType value) {
        return new JAXBElement<EntityType>(_ServiceRecipient_QNAME, EntityType.class, null, value);
    }

}
