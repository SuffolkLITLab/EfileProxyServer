
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caserequest;

import javax.xml.namespace.QName;
import gov.niem.release.niem.niem_core._4.DateRangeType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caserequest package. 
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

    private final static QName _CalendarEventTimeRange_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", "CalendarEventTimeRange");
    private final static QName _CaseQueryCriteria_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", "CaseQueryCriteria");
    private final static QName _DocketEntryTimeRange_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", "DocketEntryTimeRange");
    private final static QName _DocketEntryTypeCodeFilterText_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", "DocketEntryTypeCodeFilterText");
    private final static QName _GetCaseRequestMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", "GetCaseRequestMessage");
    private final static QName _GetCaseRequestMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", "GetCaseRequestMessageAugmentationPoint");
    private final static QName _IncludeCalendarEventIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", "IncludeCalendarEventIndicator");
    private final static QName _IncludeDocketEntryIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", "IncludeDocketEntryIndicator");
    private final static QName _IncludeParticipantsIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", "IncludeParticipantsIndicator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caserequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CaseQueryCriteriaType }
     * 
     */
    public CaseQueryCriteriaType createCaseQueryCriteriaType() {
        return new CaseQueryCriteriaType();
    }

    /**
     * Create an instance of {@link GetCaseRequestMessageType }
     * 
     */
    public GetCaseRequestMessageType createGetCaseRequestMessageType() {
        return new GetCaseRequestMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", name = "CalendarEventTimeRange")
    public JAXBElement<DateRangeType> createCalendarEventTimeRange(DateRangeType value) {
        return new JAXBElement<DateRangeType>(_CalendarEventTimeRange_QNAME, DateRangeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseQueryCriteriaType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseQueryCriteriaType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", name = "CaseQueryCriteria")
    public JAXBElement<CaseQueryCriteriaType> createCaseQueryCriteria(CaseQueryCriteriaType value) {
        return new JAXBElement<CaseQueryCriteriaType>(_CaseQueryCriteria_QNAME, CaseQueryCriteriaType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", name = "DocketEntryTimeRange")
    public JAXBElement<DateRangeType> createDocketEntryTimeRange(DateRangeType value) {
        return new JAXBElement<DateRangeType>(_DocketEntryTimeRange_QNAME, DateRangeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", name = "DocketEntryTypeCodeFilterText")
    public JAXBElement<TextType> createDocketEntryTypeCodeFilterText(TextType value) {
        return new JAXBElement<TextType>(_DocketEntryTypeCodeFilterText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCaseRequestMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCaseRequestMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", name = "GetCaseRequestMessage")
    public JAXBElement<GetCaseRequestMessageType> createGetCaseRequestMessage(GetCaseRequestMessageType value) {
        return new JAXBElement<GetCaseRequestMessageType>(_GetCaseRequestMessage_QNAME, GetCaseRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", name = "GetCaseRequestMessageAugmentationPoint")
    public JAXBElement<Object> createGetCaseRequestMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetCaseRequestMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", name = "IncludeCalendarEventIndicator")
    public JAXBElement<Boolean> createIncludeCalendarEventIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_IncludeCalendarEventIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", name = "IncludeDocketEntryIndicator")
    public JAXBElement<Boolean> createIncludeDocketEntryIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_IncludeDocketEntryIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", name = "IncludeParticipantsIndicator")
    public JAXBElement<Boolean> createIncludeParticipantsIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_IncludeParticipantsIndicator_QNAME, Boolean.class, null, value);
    }

}
