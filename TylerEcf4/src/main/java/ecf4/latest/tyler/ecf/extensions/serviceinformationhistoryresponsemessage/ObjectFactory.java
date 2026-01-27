
package ecf4.latest.tyler.ecf.extensions.serviceinformationhistoryresponsemessage;

import javax.xml.namespace.QName;
import ecf4.latest.gov.niem.niem.niem_core._2.DateType;
import ecf4.latest.gov.niem.niem.niem_core._2.TextType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.tyler.ecf.extensions.serviceinformationhistoryresponsemessage package. 
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

    private final static QName _ServiceInformationHistoryResponseMessage_QNAME = new QName("urn:tyler:ecf:extensions:ServiceInformationHistoryResponseMessage", "ServiceInformationHistoryResponseMessage");
    private final static QName _ServiceRecipient_QNAME = new QName("urn:tyler:ecf:extensions:ServiceInformationHistoryResponseMessage", "ServiceRecipient");
    private final static QName _ContactAction_QNAME = new QName("urn:tyler:ecf:extensions:ServiceInformationHistoryResponseMessage", "ContactAction");
    private final static QName _ActionTimestamp_QNAME = new QName("urn:tyler:ecf:extensions:ServiceInformationHistoryResponseMessage", "ActionTimestamp");
    private final static QName _Action_QNAME = new QName("urn:tyler:ecf:extensions:ServiceInformationHistoryResponseMessage", "Action");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf4.latest.tyler.ecf.extensions.serviceinformationhistoryresponsemessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceInformationHistoryResponseMessageType }
     * 
     */
    public ServiceInformationHistoryResponseMessageType createServiceInformationHistoryResponseMessageType() {
        return new ServiceInformationHistoryResponseMessageType();
    }

    /**
     * Create an instance of {@link ServiceRecipientType }
     * 
     */
    public ServiceRecipientType createServiceRecipientType() {
        return new ServiceRecipientType();
    }

    /**
     * Create an instance of {@link ActionType }
     * 
     */
    public ActionType createActionType() {
        return new ActionType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceInformationHistoryResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceInformationHistoryResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:ServiceInformationHistoryResponseMessage", name = "ServiceInformationHistoryResponseMessage")
    public JAXBElement<ServiceInformationHistoryResponseMessageType> createServiceInformationHistoryResponseMessage(ServiceInformationHistoryResponseMessageType value) {
        return new JAXBElement<ServiceInformationHistoryResponseMessageType>(_ServiceInformationHistoryResponseMessage_QNAME, ServiceInformationHistoryResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceRecipientType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceRecipientType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:ServiceInformationHistoryResponseMessage", name = "ServiceRecipient")
    public JAXBElement<ServiceRecipientType> createServiceRecipient(ServiceRecipientType value) {
        return new JAXBElement<ServiceRecipientType>(_ServiceRecipient_QNAME, ServiceRecipientType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:ServiceInformationHistoryResponseMessage", name = "ContactAction")
    public JAXBElement<TextType> createContactAction(TextType value) {
        return new JAXBElement<TextType>(_ContactAction_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:ServiceInformationHistoryResponseMessage", name = "ActionTimestamp")
    public JAXBElement<DateType> createActionTimestamp(DateType value) {
        return new JAXBElement<DateType>(_ActionTimestamp_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ActionType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:ServiceInformationHistoryResponseMessage", name = "Action")
    public JAXBElement<ActionType> createAction(ActionType value) {
        return new JAXBElement<ActionType>(_Action_QNAME, ActionType.class, null, value);
    }

}
