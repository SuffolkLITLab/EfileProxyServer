
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

    private final static QName _Role_QNAME = new QName("urn:tyler:efm:services:schema:Common", "Role");
    private final static QName _User_QNAME = new QName("urn:tyler:efm:services:schema:Common", "User");
    private final static QName _ServiceContact_QNAME = new QName("urn:tyler:efm:services:schema:Common", "ServiceContact");
    private final static QName _PaymentAccount_QNAME = new QName("urn:tyler:efm:services:schema:Common", "PaymentAccount");
    private final static QName _PaymentAccountLocationDetails_QNAME = new QName("urn:tyler:efm:services:schema:Common", "PaymentAccountLocationDetails");
    private final static QName _Firm_QNAME = new QName("urn:tyler:efm:services:schema:Common", "Firm");
    private final static QName _Attorney_QNAME = new QName("urn:tyler:efm:services:schema:Common", "Attorney");
    private final static QName _NotificationListItem_QNAME = new QName("urn:tyler:efm:services:schema:Common", "NotificationListItem");
    private final static QName _PaymentAccountTypePaymentAccountTypeCodeId_QNAME = new QName("urn:tyler:efm:services:schema:Common", "PaymentAccountTypeCodeId");
    private final static QName _PaymentAccountTypeCardType_QNAME = new QName("urn:tyler:efm:services:schema:Common", "CardType");
    private final static QName _PaymentAccountTypeCardLast4_QNAME = new QName("urn:tyler:efm:services:schema:Common", "CardLast4");
    private final static QName _PaymentAccountTypeCardMonth_QNAME = new QName("urn:tyler:efm:services:schema:Common", "CardMonth");
    private final static QName _PaymentAccountTypeCardYear_QNAME = new QName("urn:tyler:efm:services:schema:Common", "CardYear");
    private final static QName _PaymentAccountTypeCardHolderName_QNAME = new QName("urn:tyler:efm:services:schema:Common", "CardHolderName");
    private final static QName _PaymentAccountTypeActive_QNAME = new QName("urn:tyler:efm:services:schema:Common", "Active");
    private final static QName _PaymentAccountTypeIsAvailableAtAllLocations_QNAME = new QName("urn:tyler:efm:services:schema:Common", "IsAvailableAtAllLocations");
    private final static QName _ServiceContactTypeIsPublic_QNAME = new QName("urn:tyler:efm:services:schema:Common", "IsPublic");
    private final static QName _ServiceContactTypeIsInFirmMasterList_QNAME = new QName("urn:tyler:efm:services:schema:Common", "IsInFirmMasterList");

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
     * Create an instance of {@link PaymentAccountType }
     * 
     */
    public PaymentAccountType createPaymentAccountType() {
        return new PaymentAccountType();
    }

    /**
     * Create an instance of {@link PaymentAccountLocationDetails }
     * 
     */
    public PaymentAccountLocationDetails createPaymentAccountLocationDetails() {
        return new PaymentAccountLocationDetails();
    }

    /**
     * Create an instance of {@link FirmType }
     * 
     */
    public FirmType createFirmType() {
        return new FirmType();
    }

    /**
     * Create an instance of {@link AttorneyType }
     * 
     */
    public AttorneyType createAttorneyType() {
        return new AttorneyType();
    }

    /**
     * Create an instance of {@link NotificationListItemType }
     * 
     */
    public NotificationListItemType createNotificationListItemType() {
        return new NotificationListItemType();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link PaymentAccountLocation }
     * 
     */
    public PaymentAccountLocation createPaymentAccountLocation() {
        return new PaymentAccountLocation();
    }

    /**
     * Create an instance of {@link ErrorType }
     * 
     */
    public ErrorType createErrorType() {
        return new ErrorType();
    }

    /**
     * Create an instance of {@link PaymentAccountTypeType }
     * 
     */
    public PaymentAccountTypeType createPaymentAccountTypeType() {
        return new PaymentAccountTypeType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RoleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RoleType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "Role")
    public JAXBElement<RoleType> createRole(RoleType value) {
        return new JAXBElement<RoleType>(_Role_QNAME, RoleType.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentAccountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PaymentAccountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "PaymentAccount")
    public JAXBElement<PaymentAccountType> createPaymentAccount(PaymentAccountType value) {
        return new JAXBElement<PaymentAccountType>(_PaymentAccount_QNAME, PaymentAccountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentAccountLocationDetails }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PaymentAccountLocationDetails }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "PaymentAccountLocationDetails")
    public JAXBElement<PaymentAccountLocationDetails> createPaymentAccountLocationDetails(PaymentAccountLocationDetails value) {
        return new JAXBElement<PaymentAccountLocationDetails>(_PaymentAccountLocationDetails_QNAME, PaymentAccountLocationDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FirmType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FirmType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "Firm")
    public JAXBElement<FirmType> createFirm(FirmType value) {
        return new JAXBElement<FirmType>(_Firm_QNAME, FirmType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttorneyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AttorneyType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "Attorney")
    public JAXBElement<AttorneyType> createAttorney(AttorneyType value) {
        return new JAXBElement<AttorneyType>(_Attorney_QNAME, AttorneyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotificationListItemType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotificationListItemType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "NotificationListItem")
    public JAXBElement<NotificationListItemType> createNotificationListItem(NotificationListItemType value) {
        return new JAXBElement<NotificationListItemType>(_NotificationListItem_QNAME, NotificationListItemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "PaymentAccountTypeCodeId", scope = PaymentAccountType.class)
    public JAXBElement<Integer> createPaymentAccountTypePaymentAccountTypeCodeId(Integer value) {
        return new JAXBElement<Integer>(_PaymentAccountTypePaymentAccountTypeCodeId_QNAME, Integer.class, PaymentAccountType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "CardType", scope = PaymentAccountType.class)
    public JAXBElement<String> createPaymentAccountTypeCardType(String value) {
        return new JAXBElement<String>(_PaymentAccountTypeCardType_QNAME, String.class, PaymentAccountType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "CardLast4", scope = PaymentAccountType.class)
    public JAXBElement<Integer> createPaymentAccountTypeCardLast4(Integer value) {
        return new JAXBElement<Integer>(_PaymentAccountTypeCardLast4_QNAME, Integer.class, PaymentAccountType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "CardMonth", scope = PaymentAccountType.class)
    public JAXBElement<Integer> createPaymentAccountTypeCardMonth(Integer value) {
        return new JAXBElement<Integer>(_PaymentAccountTypeCardMonth_QNAME, Integer.class, PaymentAccountType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "CardYear", scope = PaymentAccountType.class)
    public JAXBElement<Integer> createPaymentAccountTypeCardYear(Integer value) {
        return new JAXBElement<Integer>(_PaymentAccountTypeCardYear_QNAME, Integer.class, PaymentAccountType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "CardHolderName", scope = PaymentAccountType.class)
    public JAXBElement<String> createPaymentAccountTypeCardHolderName(String value) {
        return new JAXBElement<String>(_PaymentAccountTypeCardHolderName_QNAME, String.class, PaymentAccountType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "Active", scope = PaymentAccountType.class)
    public JAXBElement<Boolean> createPaymentAccountTypeActive(Boolean value) {
        return new JAXBElement<Boolean>(_PaymentAccountTypeActive_QNAME, Boolean.class, PaymentAccountType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:efm:services:schema:Common", name = "IsAvailableAtAllLocations", scope = PaymentAccountType.class)
    public JAXBElement<Boolean> createPaymentAccountTypeIsAvailableAtAllLocations(Boolean value) {
        return new JAXBElement<Boolean>(_PaymentAccountTypeIsAvailableAtAllLocations_QNAME, Boolean.class, PaymentAccountType.class, value);
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

}
