
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyrequest;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyrequest package. 
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

    private final static QName _GetPolicyRequestMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyrequest", "GetPolicyRequestMessage");
    private final static QName _GetPolicyRequestMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyrequest", "GetPolicyRequestMessageAugmentationPoint");
    private final static QName _PolicyQueryCriteria_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyrequest", "PolicyQueryCriteria");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyrequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPolicyRequestMessageType }
     * 
     */
    public GetPolicyRequestMessageType createGetPolicyRequestMessageType() {
        return new GetPolicyRequestMessageType();
    }

    /**
     * Create an instance of {@link PolicyQueryCriteriaType }
     * 
     */
    public PolicyQueryCriteriaType createPolicyQueryCriteriaType() {
        return new PolicyQueryCriteriaType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPolicyRequestMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPolicyRequestMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyrequest", name = "GetPolicyRequestMessage")
    public JAXBElement<GetPolicyRequestMessageType> createGetPolicyRequestMessage(GetPolicyRequestMessageType value) {
        return new JAXBElement<GetPolicyRequestMessageType>(_GetPolicyRequestMessage_QNAME, GetPolicyRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyrequest", name = "GetPolicyRequestMessageAugmentationPoint")
    public JAXBElement<Object> createGetPolicyRequestMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetPolicyRequestMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolicyQueryCriteriaType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PolicyQueryCriteriaType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyrequest", name = "PolicyQueryCriteria")
    public JAXBElement<PolicyQueryCriteriaType> createPolicyQueryCriteria(PolicyQueryCriteriaType value) {
        return new JAXBElement<PolicyQueryCriteriaType>(_PolicyQueryCriteria_QNAME, PolicyQueryCriteriaType.class, null, value);
    }

}
