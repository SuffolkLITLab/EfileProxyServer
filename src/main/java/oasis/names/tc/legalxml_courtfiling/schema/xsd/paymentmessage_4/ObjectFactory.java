
package oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4 package. 
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

    private final static QName _FeeExceptionReasonCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:PaymentMessage-4.0", "FeeExceptionReasonCode");
    private final static QName _FeeExceptionSupportingText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:PaymentMessage-4.0", "FeeExceptionSupportingText");
    private final static QName _PaymentMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:PaymentMessage-4.0", "PaymentMessage");
    private final static QName _PayerName_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:PaymentMessage-4.0", "PayerName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PaymentMessageType }
     * 
     */
    public PaymentMessageType createPaymentMessageType() {
        return new PaymentMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:PaymentMessage-4.0", name = "FeeExceptionReasonCode")
    public JAXBElement<String> createFeeExceptionReasonCode(String value) {
        return new JAXBElement<String>(_FeeExceptionReasonCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:PaymentMessage-4.0", name = "FeeExceptionSupportingText")
    public JAXBElement<String> createFeeExceptionSupportingText(String value) {
        return new JAXBElement<String>(_FeeExceptionSupportingText_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PaymentMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:PaymentMessage-4.0", name = "PaymentMessage")
    public JAXBElement<PaymentMessageType> createPaymentMessage(PaymentMessageType value) {
        return new JAXBElement<PaymentMessageType>(_PaymentMessage_QNAME, PaymentMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:PaymentMessage-4.0", name = "PayerName")
    public JAXBElement<String> createPayerName(String value) {
        return new JAXBElement<String>(_PayerName_QNAME, String.class, null, value);
    }

}
