
package tyler.ecf.extensions.notifyservicemessage;

import javax.xml.namespace.QName;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.extensions.notifyservicemessage package. 
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

    private final static QName _NotifyServiceMessage_QNAME = new QName("urn:tyler:ecf:extensions:NotifyServiceMessage", "NotifyServiceMessage");
    private final static QName _ServiceRecipient_QNAME = new QName("urn:tyler:ecf:extensions:NotifyServiceMessage", "ServiceRecipient");
    private final static QName _ServiceContactID_QNAME = new QName("urn:tyler:ecf:extensions:NotifyServiceMessage", "ServiceContactID");
    private final static QName _SentDate_QNAME = new QName("urn:tyler:ecf:extensions:NotifyServiceMessage", "SentDate");
    private final static QName _Status_QNAME = new QName("urn:tyler:ecf:extensions:NotifyServiceMessage", "Status");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.extensions.notifyservicemessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotifyServiceMessageType }
     * 
     */
    public NotifyServiceMessageType createNotifyServiceMessageType() {
        return new NotifyServiceMessageType();
    }

    /**
     * Create an instance of {@link ServiceRecipientType }
     * 
     */
    public ServiceRecipientType createServiceRecipientType() {
        return new ServiceRecipientType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyServiceMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotifyServiceMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:NotifyServiceMessage", name = "NotifyServiceMessage")
    public JAXBElement<NotifyServiceMessageType> createNotifyServiceMessage(NotifyServiceMessageType value) {
        return new JAXBElement<NotifyServiceMessageType>(_NotifyServiceMessage_QNAME, NotifyServiceMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceRecipientType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceRecipientType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:NotifyServiceMessage", name = "ServiceRecipient")
    public JAXBElement<ServiceRecipientType> createServiceRecipient(ServiceRecipientType value) {
        return new JAXBElement<ServiceRecipientType>(_ServiceRecipient_QNAME, ServiceRecipientType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:NotifyServiceMessage", name = "ServiceContactID")
    public JAXBElement<IdentificationType> createServiceContactID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ServiceContactID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:NotifyServiceMessage", name = "SentDate")
    public JAXBElement<DateType> createSentDate(DateType value) {
        return new JAXBElement<DateType>(_SentDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:NotifyServiceMessage", name = "Status")
    public JAXBElement<TextType> createStatus(TextType value) {
        return new JAXBElement<TextType>(_Status_QNAME, TextType.class, null, value);
    }

}
