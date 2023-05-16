
package tyler.ecf.v5_0.extensions.filingserviceresponse;

import javax.xml.namespace.QName;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.v5_0.extensions.filingserviceresponse package. 
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

    private final static QName _GetFilingServiceResponseMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:filingserviceresponse", "GetFilingServiceResponseMessage");
    private final static QName _MailServiceIndicator_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:filingserviceresponse", "MailServiceIndicator");
    private final static QName _SmtpLog_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:filingserviceresponse", "SmtpLog");
    private final static QName _TrackingNumber_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:filingserviceresponse", "TrackingNumber");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.v5_0.extensions.filingserviceresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFilingServiceResponseMessageType }
     * 
     */
    public GetFilingServiceResponseMessageType createGetFilingServiceResponseMessageType() {
        return new GetFilingServiceResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilingServiceResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFilingServiceResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:filingserviceresponse", name = "GetFilingServiceResponseMessage")
    public JAXBElement<GetFilingServiceResponseMessageType> createGetFilingServiceResponseMessage(GetFilingServiceResponseMessageType value) {
        return new JAXBElement<GetFilingServiceResponseMessageType>(_GetFilingServiceResponseMessage_QNAME, GetFilingServiceResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:filingserviceresponse", name = "MailServiceIndicator")
    public JAXBElement<Boolean> createMailServiceIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_MailServiceIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:filingserviceresponse", name = "SmtpLog")
    public JAXBElement<TextType> createSmtpLog(TextType value) {
        return new JAXBElement<TextType>(_SmtpLog_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:filingserviceresponse", name = "TrackingNumber")
    public JAXBElement<TextType> createTrackingNumber(TextType value) {
        return new JAXBElement<TextType>(_TrackingNumber_QNAME, TextType.class, null, value);
    }

}
