
package oasis.names.tc.legalxml_courtfiling.schema.xsd.servicereceiptmessage_4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.legalxml_courtfiling.schema.xsd.servicereceiptmessage_4 package. 
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

    private final static QName _ServiceReceiptMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:ServiceReceiptMessage-4.0", "ServiceReceiptMessage");
    private final static QName _ServiceRecipientStatus_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:ServiceReceiptMessage-4.0", "ServiceRecipientStatus");
    private final static QName _ServiceStatusCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:ServiceReceiptMessage-4.0", "ServiceStatusCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.legalxml_courtfiling.schema.xsd.servicereceiptmessage_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceReceiptMessageType }
     * 
     */
    public ServiceReceiptMessageType createServiceReceiptMessageType() {
        return new ServiceReceiptMessageType();
    }

    /**
     * Create an instance of {@link ServiceRecipientStatusType }
     * 
     */
    public ServiceRecipientStatusType createServiceRecipientStatusType() {
        return new ServiceRecipientStatusType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceReceiptMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceReceiptMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:ServiceReceiptMessage-4.0", name = "ServiceReceiptMessage")
    public JAXBElement<ServiceReceiptMessageType> createServiceReceiptMessage(ServiceReceiptMessageType value) {
        return new JAXBElement<ServiceReceiptMessageType>(_ServiceReceiptMessage_QNAME, ServiceReceiptMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceRecipientStatusType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceRecipientStatusType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:ServiceReceiptMessage-4.0", name = "ServiceRecipientStatus")
    public JAXBElement<ServiceRecipientStatusType> createServiceRecipientStatus(ServiceRecipientStatusType value) {
        return new JAXBElement<ServiceRecipientStatusType>(_ServiceRecipientStatus_QNAME, ServiceRecipientStatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:ServiceReceiptMessage-4.0", name = "ServiceStatusCode")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    public JAXBElement<String> createServiceStatusCode(String value) {
        return new JAXBElement<String>(_ServiceStatusCode_QNAME, String.class, null, value);
    }

}
