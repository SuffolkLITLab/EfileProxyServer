
package ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment;

import javax.xml.namespace.QName;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.PersonType;
import ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment package. 
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

    private final static QName _CorrectedPaymentIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/payment", "CorrectedPaymentIndicator");
    private final static QName _Payer_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/payment", "Payer");
    private final static QName _PaymentMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/payment", "PaymentMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/payment", name = "CorrectedPaymentIndicator")
    public JAXBElement<Boolean> createCorrectedPaymentIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_CorrectedPaymentIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/payment", name = "Payer")
    public JAXBElement<PersonType> createPayer(PersonType value) {
        return new JAXBElement<PersonType>(_Payer_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PaymentMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/payment", name = "PaymentMessage")
    public JAXBElement<PaymentMessageType> createPaymentMessage(PaymentMessageType value) {
        return new JAXBElement<PaymentMessageType>(_PaymentMessage_QNAME, PaymentMessageType.class, null, value);
    }

}
