
package tyler.ecf.extensions.servicetypesresponsemessage;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.extensions.servicetypesresponsemessage package. 
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

    private final static QName _ServiceType_QNAME = new QName("urn:tyler:ecf:extensions:ServiceTypesResponseMessage", "ServiceType");
    private final static QName _ServiceTypesResponseMessage_QNAME = new QName("urn:tyler:ecf:extensions:ServiceTypesResponseMessage", "ServiceTypesResponseMessage");
    private final static QName _ServiceCodeID_QNAME = new QName("urn:tyler:ecf:extensions:ServiceTypesResponseMessage", "ServiceCodeID");
    private final static QName _Description_QNAME = new QName("urn:tyler:ecf:extensions:ServiceTypesResponseMessage", "Description");
    private final static QName _IsEmailRequired_QNAME = new QName("urn:tyler:ecf:extensions:ServiceTypesResponseMessage", "IsEmailRequired");
    private final static QName _IsStreetAddressRequired_QNAME = new QName("urn:tyler:ecf:extensions:ServiceTypesResponseMessage", "IsStreetAddressRequired");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.extensions.servicetypesresponsemessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceTypeType }
     * 
     */
    public ServiceTypeType createServiceTypeType() {
        return new ServiceTypeType();
    }

    /**
     * Create an instance of {@link ServiceTypesResponseMessageType }
     * 
     */
    public ServiceTypesResponseMessageType createServiceTypesResponseMessageType() {
        return new ServiceTypesResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceTypeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceTypeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:ServiceTypesResponseMessage", name = "ServiceType")
    public JAXBElement<ServiceTypeType> createServiceType(ServiceTypeType value) {
        return new JAXBElement<ServiceTypeType>(_ServiceType_QNAME, ServiceTypeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceTypesResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceTypesResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:ServiceTypesResponseMessage", name = "ServiceTypesResponseMessage")
    public JAXBElement<ServiceTypesResponseMessageType> createServiceTypesResponseMessage(ServiceTypesResponseMessageType value) {
        return new JAXBElement<ServiceTypesResponseMessageType>(_ServiceTypesResponseMessage_QNAME, ServiceTypesResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:ServiceTypesResponseMessage", name = "ServiceCodeID")
    public JAXBElement<TextType> createServiceCodeID(TextType value) {
        return new JAXBElement<TextType>(_ServiceCodeID_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:ServiceTypesResponseMessage", name = "Description")
    public JAXBElement<TextType> createDescription(TextType value) {
        return new JAXBElement<TextType>(_Description_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:ServiceTypesResponseMessage", name = "IsEmailRequired")
    public JAXBElement<Boolean> createIsEmailRequired(Boolean value) {
        return new JAXBElement<Boolean>(_IsEmailRequired_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:ServiceTypesResponseMessage", name = "IsStreetAddressRequired")
    public JAXBElement<Boolean> createIsStreetAddressRequired(Boolean value) {
        return new JAXBElement<Boolean>(_IsStreetAddressRequired_QNAME, Boolean.class, null, value);
    }

}
