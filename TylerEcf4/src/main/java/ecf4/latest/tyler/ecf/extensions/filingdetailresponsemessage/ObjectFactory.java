
package ecf4.latest.tyler.ecf.extensions.filingdetailresponsemessage;

import javax.xml.namespace.QName;
import ecf4.latest.gov.niem.niem.niem_core._2.DateType;
import ecf4.latest.gov.niem.niem.niem_core._2.EntityType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.tyler.ecf.extensions.filingdetailresponsemessage package. 
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

    private final static QName _EnvelopeFees_QNAME = new QName("urn:tyler:ecf:extensions:FilingDetailResponseMessage", "EnvelopeFees");
    private final static QName _FilingFees_QNAME = new QName("urn:tyler:ecf:extensions:FilingDetailResponseMessage", "FilingFees");
    private final static QName _FilingDetailResponseMessage_QNAME = new QName("urn:tyler:ecf:extensions:FilingDetailResponseMessage", "FilingDetailResponseMessage");
    private final static QName _FilingSubmissionDate_QNAME = new QName("urn:tyler:ecf:extensions:FilingDetailResponseMessage", "FilingSubmissionDate");
    private final static QName _FilingAcceptDate_QNAME = new QName("urn:tyler:ecf:extensions:FilingDetailResponseMessage", "FilingAcceptDate");
    private final static QName _ServiceRecipientDetail_QNAME = new QName("urn:tyler:ecf:extensions:FilingDetailResponseMessage", "ServiceRecipientDetail");
    private final static QName _StatusCode_QNAME = new QName("urn:tyler:ecf:extensions:FilingDetailResponseMessage", "StatusCode");
    private final static QName _ServedRecipient_QNAME = new QName("urn:tyler:ecf:extensions:FilingDetailResponseMessage", "ServedRecipient");
    private final static QName _IsOpened_QNAME = new QName("urn:tyler:ecf:extensions:FilingDetailResponseMessage", "IsOpened");
    private final static QName _ServedDate_QNAME = new QName("urn:tyler:ecf:extensions:FilingDetailResponseMessage", "ServedDate");
    private final static QName _OpenedDate_QNAME = new QName("urn:tyler:ecf:extensions:FilingDetailResponseMessage", "OpenedDate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf4.latest.tyler.ecf.extensions.filingdetailresponsemessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChargeType }
     * 
     */
    public ChargeType createChargeType() {
        return new ChargeType();
    }

    /**
     * Create an instance of {@link FilingDetailResponseMessageType }
     * 
     */
    public FilingDetailResponseMessageType createFilingDetailResponseMessageType() {
        return new FilingDetailResponseMessageType();
    }

    /**
     * Create an instance of {@link ServiceRecipientDetailType }
     * 
     */
    public ServiceRecipientDetailType createServiceRecipientDetailType() {
        return new ServiceRecipientDetailType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingDetailResponseMessage", name = "EnvelopeFees")
    public JAXBElement<ChargeType> createEnvelopeFees(ChargeType value) {
        return new JAXBElement<ChargeType>(_EnvelopeFees_QNAME, ChargeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingDetailResponseMessage", name = "FilingFees")
    public JAXBElement<ChargeType> createFilingFees(ChargeType value) {
        return new JAXBElement<ChargeType>(_FilingFees_QNAME, ChargeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingDetailResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingDetailResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingDetailResponseMessage", name = "FilingDetailResponseMessage")
    public JAXBElement<FilingDetailResponseMessageType> createFilingDetailResponseMessage(FilingDetailResponseMessageType value) {
        return new JAXBElement<FilingDetailResponseMessageType>(_FilingDetailResponseMessage_QNAME, FilingDetailResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingDetailResponseMessage", name = "FilingSubmissionDate")
    public JAXBElement<DateType> createFilingSubmissionDate(DateType value) {
        return new JAXBElement<DateType>(_FilingSubmissionDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingDetailResponseMessage", name = "FilingAcceptDate")
    public JAXBElement<DateType> createFilingAcceptDate(DateType value) {
        return new JAXBElement<DateType>(_FilingAcceptDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceRecipientDetailType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceRecipientDetailType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingDetailResponseMessage", name = "ServiceRecipientDetail")
    public JAXBElement<ServiceRecipientDetailType> createServiceRecipientDetail(ServiceRecipientDetailType value) {
        return new JAXBElement<ServiceRecipientDetailType>(_ServiceRecipientDetail_QNAME, ServiceRecipientDetailType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingDetailResponseMessage", name = "StatusCode")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    public JAXBElement<String> createStatusCode(String value) {
        return new JAXBElement<String>(_StatusCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingDetailResponseMessage", name = "ServedRecipient")
    public JAXBElement<EntityType> createServedRecipient(EntityType value) {
        return new JAXBElement<EntityType>(_ServedRecipient_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingDetailResponseMessage", name = "IsOpened")
    public JAXBElement<Boolean> createIsOpened(Boolean value) {
        return new JAXBElement<Boolean>(_IsOpened_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingDetailResponseMessage", name = "ServedDate")
    public JAXBElement<DateType> createServedDate(DateType value) {
        return new JAXBElement<DateType>(_ServedDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingDetailResponseMessage", name = "OpenedDate")
    public JAXBElement<DateType> createOpenedDate(DateType value) {
        return new JAXBElement<DateType>(_OpenedDate_QNAME, DateType.class, null, value);
    }

}
