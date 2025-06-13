
package tyler.efm.v2022_1.services.schema.common;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.efm.v2022_1.services.schema.common package. 
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

    private final static QName _User_QNAME = new QName("urn:tyler:efm:services:schema:Common", "User");
    private final static QName _ServiceContact_QNAME = new QName("urn:tyler:efm:services:schema:Common", "ServiceContact");
    private final static QName _ServiceContactTypeIsPublic_QNAME = new QName("urn:tyler:efm:services:schema:Common", "IsPublic");
    private final static QName _ServiceContactTypeIsInFirmMasterList_QNAME = new QName("urn:tyler:efm:services:schema:Common", "IsInFirmMasterList");
    private final static QName _ServiceContactTypeIsUndeliverable_QNAME = new QName("urn:tyler:efm:services:schema:Common", "IsUndeliverable");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.efm.v2022_1.services.schema.common
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserType }
     * 
     */
    public UserType createUserType() {
        return new UserType();
    }

    /**
     * Create an instance of {@link ServiceContactType }
     * 
     */
    public ServiceContactType createServiceContactType() {
        return new ServiceContactType();
    }

    /**
     * Create an instance of {@link PaymentAccountLocation }
     * 
     */
    public PaymentAccountLocation createPaymentAccountLocation() {
        return new PaymentAccountLocation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "User")
    public JAXBElement<UserType> createUser(UserType value) {
        return new JAXBElement<UserType>(_User_QNAME, UserType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceContactType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceContactType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "ServiceContact")
    public JAXBElement<ServiceContactType> createServiceContact(ServiceContactType value) {
        return new JAXBElement<ServiceContactType>(_ServiceContact_QNAME, ServiceContactType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "IsPublic", scope = ServiceContactType.class)
    public JAXBElement<Boolean> createServiceContactTypeIsPublic(Boolean value) {
        return new JAXBElement<Boolean>(_ServiceContactTypeIsPublic_QNAME, Boolean.class, ServiceContactType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "IsInFirmMasterList", scope = ServiceContactType.class)
    public JAXBElement<Boolean> createServiceContactTypeIsInFirmMasterList(Boolean value) {
        return new JAXBElement<Boolean>(_ServiceContactTypeIsInFirmMasterList_QNAME, Boolean.class, ServiceContactType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "IsUndeliverable", scope = ServiceContactType.class)
    public JAXBElement<Boolean> createServiceContactTypeIsUndeliverable(Boolean value) {
        return new JAXBElement<Boolean>(_ServiceContactTypeIsUndeliverable_QNAME, Boolean.class, ServiceContactType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "IsUndeliverable", scope = UserType.class)
    public JAXBElement<Boolean> createUserTypeIsUndeliverable(Boolean value) {
        return new JAXBElement<Boolean>(_ServiceContactTypeIsUndeliverable_QNAME, Boolean.class, UserType.class, value);
    }

}
