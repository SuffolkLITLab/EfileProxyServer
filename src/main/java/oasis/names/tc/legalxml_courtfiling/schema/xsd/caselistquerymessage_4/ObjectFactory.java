
package oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import gov.niem.niem.niem_core._2.CaseType;
import gov.niem.niem.niem_core._2.DateRangeType;
import gov.niem.niem.niem_core._2.IdentificationType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4 package. 
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

    private final static QName _CaseListQueryCase_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseListQueryMessage-4.0", "CaseListQueryCase");
    private final static QName _CaseListQueryMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseListQueryMessage-4.0", "CaseListQueryMessage");
    private final static QName _CaseListQueryTimeRange_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseListQueryMessage-4.0", "CaseListQueryTimeRange");
    private final static QName _CaseListQueryCaseParticipant_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseListQueryMessage-4.0", "CaseListQueryCaseParticipant");
    private final static QName _FilingSubmissionSubmitterID_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseListQueryMessage-4.0", "FilingSubmissionSubmitterID");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CaseListQueryMessageType }
     * 
     */
    public CaseListQueryMessageType createCaseListQueryMessageType() {
        return new CaseListQueryMessageType();
    }

    /**
     * Create an instance of {@link CaseParticipantType }
     * 
     */
    public CaseParticipantType createCaseParticipantType() {
        return new CaseParticipantType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseListQueryMessage-4.0", name = "CaseListQueryCase")
    public JAXBElement<CaseType> createCaseListQueryCase(CaseType value) {
        return new JAXBElement<CaseType>(_CaseListQueryCase_QNAME, CaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseListQueryMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseListQueryMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseListQueryMessage-4.0", name = "CaseListQueryMessage")
    public JAXBElement<CaseListQueryMessageType> createCaseListQueryMessage(CaseListQueryMessageType value) {
        return new JAXBElement<CaseListQueryMessageType>(_CaseListQueryMessage_QNAME, CaseListQueryMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseListQueryMessage-4.0", name = "CaseListQueryTimeRange")
    public JAXBElement<DateRangeType> createCaseListQueryTimeRange(DateRangeType value) {
        return new JAXBElement<DateRangeType>(_CaseListQueryTimeRange_QNAME, DateRangeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseParticipantType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseParticipantType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseListQueryMessage-4.0", name = "CaseListQueryCaseParticipant")
    public JAXBElement<CaseParticipantType> createCaseListQueryCaseParticipant(CaseParticipantType value) {
        return new JAXBElement<CaseParticipantType>(_CaseListQueryCaseParticipant_QNAME, CaseParticipantType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseListQueryMessage-4.0", name = "FilingSubmissionSubmitterID")
    public JAXBElement<IdentificationType> createFilingSubmissionSubmitterID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_FilingSubmissionSubmitterID_QNAME, IdentificationType.class, null, value);
    }

}
