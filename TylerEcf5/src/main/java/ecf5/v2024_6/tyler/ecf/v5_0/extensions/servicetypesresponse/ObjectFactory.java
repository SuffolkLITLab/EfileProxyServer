
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.servicetypesresponse;

import javax.xml.namespace.QName;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.tyler.ecf.v5_0.extensions.servicetypesresponse package. 
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

    private final static QName _ServiceType_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:servicetypesresponse", "ServiceType");
    private final static QName _ServiceCodeID_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:servicetypesresponse", "ServiceCodeID");
    private final static QName _Description_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:servicetypesresponse", "Description");
    private final static QName _IsEmailRequired_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:servicetypesresponse", "IsEmailRequired");
    private final static QName _IsStreetAddressRequired_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:servicetypesresponse", "IsStreetAddressRequired");
    private final static QName _GetServiceTypesResponseMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:servicetypesresponse", "GetServiceTypesResponseMessage");
    private final static QName _GetServiceTypesResponseMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:servicetypesresponse", "GetServiceTypesResponseMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.tyler.ecf.v5_0.extensions.servicetypesresponse
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
     * Create an instance of {@link GetServiceTypesResponseMessageType }
     * 
     */
    public GetServiceTypesResponseMessageType createGetServiceTypesResponseMessageType() {
        return new GetServiceTypesResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceTypeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceTypeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:servicetypesresponse", name = "ServiceType")
    public JAXBElement<ServiceTypeType> createServiceType(ServiceTypeType value) {
        return new JAXBElement<ServiceTypeType>(_ServiceType_QNAME, ServiceTypeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:servicetypesresponse", name = "ServiceCodeID")
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
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:servicetypesresponse", name = "Description")
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
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:servicetypesresponse", name = "IsEmailRequired")
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
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:servicetypesresponse", name = "IsStreetAddressRequired")
    public JAXBElement<Boolean> createIsStreetAddressRequired(Boolean value) {
        return new JAXBElement<Boolean>(_IsStreetAddressRequired_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceTypesResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetServiceTypesResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:servicetypesresponse", name = "GetServiceTypesResponseMessage")
    public JAXBElement<GetServiceTypesResponseMessageType> createGetServiceTypesResponseMessage(GetServiceTypesResponseMessageType value) {
        return new JAXBElement<GetServiceTypesResponseMessageType>(_GetServiceTypesResponseMessage_QNAME, GetServiceTypesResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:servicetypesresponse", name = "GetServiceTypesResponseMessageAugmentationPoint")
    public JAXBElement<Object> createGetServiceTypesResponseMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetServiceTypesResponseMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
