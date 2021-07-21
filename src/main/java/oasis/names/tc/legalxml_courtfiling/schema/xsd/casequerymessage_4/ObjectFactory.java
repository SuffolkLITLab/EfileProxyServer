
package oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import gov.niem.niem.niem_core._2.DateRangeType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4 package. 
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

    private final static QName _CalendarEventTimeRange_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", "CalendarEventTimeRange");
    private final static QName _CalendarEventTypeCodeFilterText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", "CalendarEventTypeCodeFilterText");
    private final static QName _CaseQueryCriteria_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", "CaseQueryCriteria");
    private final static QName _CaseQueryMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", "CaseQueryMessage");
    private final static QName _DocketEntryTimeRange_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", "DocketEntryTimeRange");
    private final static QName _DocketEntryTypeCodeFilterText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", "DocketEntryTypeCodeFilterText");
    private final static QName _IncludeParticipantsIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", "IncludeParticipantsIndicator");
    private final static QName _IncludeDocketEntryIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", "IncludeDocketEntryIndicator");
    private final static QName _IncludeCalendarEventIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", "IncludeCalendarEventIndicator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4
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
     * Create an instance of {@link CaseQueryMessageType }
     * 
     */
    public CaseQueryMessageType createCaseQueryMessageType() {
        return new CaseQueryMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", name = "CalendarEventTimeRange")
    public JAXBElement<DateRangeType> createCalendarEventTimeRange(DateRangeType value) {
        return new JAXBElement<DateRangeType>(_CalendarEventTimeRange_QNAME, DateRangeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", name = "CalendarEventTypeCodeFilterText")
    public JAXBElement<TextType> createCalendarEventTypeCodeFilterText(TextType value) {
        return new JAXBElement<TextType>(_CalendarEventTypeCodeFilterText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseQueryCriteriaType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseQueryCriteriaType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", name = "CaseQueryCriteria")
    public JAXBElement<CaseQueryCriteriaType> createCaseQueryCriteria(CaseQueryCriteriaType value) {
        return new JAXBElement<CaseQueryCriteriaType>(_CaseQueryCriteria_QNAME, CaseQueryCriteriaType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseQueryMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseQueryMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", name = "CaseQueryMessage")
    public JAXBElement<CaseQueryMessageType> createCaseQueryMessage(CaseQueryMessageType value) {
        return new JAXBElement<CaseQueryMessageType>(_CaseQueryMessage_QNAME, CaseQueryMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", name = "DocketEntryTimeRange")
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
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", name = "DocketEntryTypeCodeFilterText")
    public JAXBElement<TextType> createDocketEntryTypeCodeFilterText(TextType value) {
        return new JAXBElement<TextType>(_DocketEntryTypeCodeFilterText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", name = "IncludeParticipantsIndicator")
    public JAXBElement<Boolean> createIncludeParticipantsIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_IncludeParticipantsIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", name = "IncludeDocketEntryIndicator")
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
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0", name = "IncludeCalendarEventIndicator")
    public JAXBElement<Boolean> createIncludeCalendarEventIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_IncludeCalendarEventIndicator_QNAME, Boolean.class, null, value);
    }

}
