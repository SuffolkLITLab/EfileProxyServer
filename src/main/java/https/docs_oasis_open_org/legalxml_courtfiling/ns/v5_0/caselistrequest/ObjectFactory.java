
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistrequest;

import javax.xml.namespace.QName;
import gov.niem.release.niem.niem_core._4.EntityType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistrequest package. 
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

    private final static QName _GetCaseListRequestMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistrequest", "GetCaseListRequestMessageAugmentationPoint");
    private final static QName _CaseListQueryCriteria_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistrequest", "CaseListQueryCriteria");
    private final static QName _CaseParticipant_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistrequest", "CaseParticipant");
    private final static QName _GetCaseListRequestMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistrequest", "GetCaseListRequestMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistrequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CaseListQueryCriteriaType }
     * 
     */
    public CaseListQueryCriteriaType createCaseListQueryCriteriaType() {
        return new CaseListQueryCriteriaType();
    }

    /**
     * Create an instance of {@link GetCaseListRequestMessageType }
     * 
     */
    public GetCaseListRequestMessageType createGetCaseListRequestMessageType() {
        return new GetCaseListRequestMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistrequest", name = "GetCaseListRequestMessageAugmentationPoint")
    public JAXBElement<Object> createGetCaseListRequestMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetCaseListRequestMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseListQueryCriteriaType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseListQueryCriteriaType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistrequest", name = "CaseListQueryCriteria")
    public JAXBElement<CaseListQueryCriteriaType> createCaseListQueryCriteria(CaseListQueryCriteriaType value) {
        return new JAXBElement<CaseListQueryCriteriaType>(_CaseListQueryCriteria_QNAME, CaseListQueryCriteriaType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistrequest", name = "CaseParticipant")
    public JAXBElement<EntityType> createCaseParticipant(EntityType value) {
        return new JAXBElement<EntityType>(_CaseParticipant_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCaseListRequestMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCaseListRequestMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistrequest", name = "GetCaseListRequestMessage")
    public JAXBElement<GetCaseListRequestMessageType> createGetCaseListRequestMessage(GetCaseListRequestMessageType value) {
        return new JAXBElement<GetCaseListRequestMessageType>(_GetCaseListRequestMessage_QNAME, GetCaseListRequestMessageType.class, null, value);
    }

}
