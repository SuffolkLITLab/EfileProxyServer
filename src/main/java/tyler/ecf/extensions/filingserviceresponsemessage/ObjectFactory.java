
package tyler.ecf.extensions.filingserviceresponsemessage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import gov.niem.niem.niem_core._2.TextType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.extensions.filingserviceresponsemessage package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
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

    private final static QName _FilingServiceResponseMessage_QNAME = new QName("urn:tyler:ecf:extensions:FilingServiceResponseMessage", "FilingServiceResponseMessage");
    private final static QName _ServiceContactIdentification_QNAME = new QName("urn:tyler:ecf:extensions:FilingServiceResponseMessage", "ServiceContactIdentification");
    private final static QName _SmtpLog_QNAME = new QName("urn:tyler:ecf:extensions:FilingServiceResponseMessage", "SmtpLog");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.extensions.filingserviceresponsemessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FilingServiceResponseMessageType }
     * 
     */
    public FilingServiceResponseMessageType createFilingServiceResponseMessageType() {
        return new FilingServiceResponseMessageType();
    }

    /**
     * Create an instance of {@link ServiceContactIdentificationType }
     * 
     */
    public ServiceContactIdentificationType createServiceContactIdentificationType() {
        return new ServiceContactIdentificationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingServiceResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingServiceResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingServiceResponseMessage", name = "FilingServiceResponseMessage")
    public JAXBElement<FilingServiceResponseMessageType> createFilingServiceResponseMessage(FilingServiceResponseMessageType value) {
        return new JAXBElement<FilingServiceResponseMessageType>(_FilingServiceResponseMessage_QNAME, FilingServiceResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceContactIdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceContactIdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingServiceResponseMessage", name = "ServiceContactIdentification")
    public JAXBElement<ServiceContactIdentificationType> createServiceContactIdentification(ServiceContactIdentificationType value) {
        return new JAXBElement<ServiceContactIdentificationType>(_ServiceContactIdentification_QNAME, ServiceContactIdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingServiceResponseMessage", name = "SmtpLog")
    public JAXBElement<TextType> createSmtpLog(TextType value) {
        return new JAXBElement<TextType>(_SmtpLog_QNAME, TextType.class, null, value);
    }

}
