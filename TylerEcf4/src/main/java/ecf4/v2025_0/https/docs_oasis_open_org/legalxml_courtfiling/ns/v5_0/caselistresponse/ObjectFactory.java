
package ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistresponse;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistresponse package. 
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

    private final static QName _GetCaseListResponseMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistresponse", "GetCaseListResponseMessage");
    private final static QName _GetCaseListResponseMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistresponse", "GetCaseListResponseMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCaseListResponseMessageType }
     * 
     */
    public GetCaseListResponseMessageType createGetCaseListResponseMessageType() {
        return new GetCaseListResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCaseListResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCaseListResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistresponse", name = "GetCaseListResponseMessage")
    public JAXBElement<GetCaseListResponseMessageType> createGetCaseListResponseMessage(GetCaseListResponseMessageType value) {
        return new JAXBElement<GetCaseListResponseMessageType>(_GetCaseListResponseMessage_QNAME, GetCaseListResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistresponse", name = "GetCaseListResponseMessageAugmentationPoint")
    public JAXBElement<Object> createGetCaseListResponseMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetCaseListResponseMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
