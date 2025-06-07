
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filingstatusrequest;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filingstatusrequest package. 
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

    private final static QName _GetFilingStatusRequestMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filingstatusrequest", "GetFilingStatusRequestMessage");
    private final static QName _GetFilingStatusRequestMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filingstatusrequest", "GetFilingStatusRequestMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filingstatusrequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFilingStatusRequestMessageType }
     * 
     */
    public GetFilingStatusRequestMessageType createGetFilingStatusRequestMessageType() {
        return new GetFilingStatusRequestMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilingStatusRequestMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFilingStatusRequestMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filingstatusrequest", name = "GetFilingStatusRequestMessage")
    public JAXBElement<GetFilingStatusRequestMessageType> createGetFilingStatusRequestMessage(GetFilingStatusRequestMessageType value) {
        return new JAXBElement<GetFilingStatusRequestMessageType>(_GetFilingStatusRequestMessage_QNAME, GetFilingStatusRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filingstatusrequest", name = "GetFilingStatusRequestMessageAugmentationPoint")
    public JAXBElement<Object> createGetFilingStatusRequestMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetFilingStatusRequestMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
