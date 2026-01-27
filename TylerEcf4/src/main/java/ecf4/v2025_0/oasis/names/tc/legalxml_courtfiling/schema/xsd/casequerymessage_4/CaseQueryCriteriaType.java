
package ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4;

import ecf4.v2025_0.gov.niem.niem.niem_core._2.DateRangeType;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.TextType;
import ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.Boolean;
import ecf4.v2025_0.gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A message requesting a list of cases from a court's case management information system conforming to the parameter or parameters identified in the message.
 * 
 * <p>Java class for CaseQueryCriteriaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseQueryCriteriaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0}IncludeParticipantsIndicator"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0}IncludeDocketEntryIndicator"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0}IncludeCalendarEventIndicator"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0}DocketEntryTypeCodeFilterText"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0}CalendarEventTypeCodeFilterText"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0}DocketEntryTimeRange" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0}CalendarEventTimeRange" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseQueryCriteriaType", propOrder = {
    "includeParticipantsIndicator",
    "includeDocketEntryIndicator",
    "includeCalendarEventIndicator",
    "docketEntryTypeCodeFilterText",
    "calendarEventTypeCodeFilterText",
    "docketEntryTimeRange",
    "calendarEventTimeRange"
})
public class CaseQueryCriteriaType
    extends ComplexObjectType
{

    @XmlElement(name = "IncludeParticipantsIndicator", required = true)
    protected Boolean includeParticipantsIndicator;
    @XmlElement(name = "IncludeDocketEntryIndicator", required = true)
    protected Boolean includeDocketEntryIndicator;
    @XmlElement(name = "IncludeCalendarEventIndicator", required = true)
    protected Boolean includeCalendarEventIndicator;
    @XmlElement(name = "DocketEntryTypeCodeFilterText", required = true)
    protected TextType docketEntryTypeCodeFilterText;
    @XmlElement(name = "CalendarEventTypeCodeFilterText", required = true)
    protected TextType calendarEventTypeCodeFilterText;
    @XmlElement(name = "DocketEntryTimeRange")
    protected DateRangeType docketEntryTimeRange;
    @XmlElement(name = "CalendarEventTimeRange")
    protected DateRangeType calendarEventTimeRange;

    /**
     * Gets the value of the includeParticipantsIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIncludeParticipantsIndicator() {
        return includeParticipantsIndicator;
    }

    /**
     * Sets the value of the includeParticipantsIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeParticipantsIndicator(Boolean value) {
        this.includeParticipantsIndicator = value;
    }

    /**
     * Gets the value of the includeDocketEntryIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIncludeDocketEntryIndicator() {
        return includeDocketEntryIndicator;
    }

    /**
     * Sets the value of the includeDocketEntryIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeDocketEntryIndicator(Boolean value) {
        this.includeDocketEntryIndicator = value;
    }

    /**
     * Gets the value of the includeCalendarEventIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIncludeCalendarEventIndicator() {
        return includeCalendarEventIndicator;
    }

    /**
     * Sets the value of the includeCalendarEventIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeCalendarEventIndicator(Boolean value) {
        this.includeCalendarEventIndicator = value;
    }

    /**
     * Gets the value of the docketEntryTypeCodeFilterText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDocketEntryTypeCodeFilterText() {
        return docketEntryTypeCodeFilterText;
    }

    /**
     * Sets the value of the docketEntryTypeCodeFilterText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDocketEntryTypeCodeFilterText(TextType value) {
        this.docketEntryTypeCodeFilterText = value;
    }

    /**
     * Gets the value of the calendarEventTypeCodeFilterText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCalendarEventTypeCodeFilterText() {
        return calendarEventTypeCodeFilterText;
    }

    /**
     * Sets the value of the calendarEventTypeCodeFilterText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCalendarEventTypeCodeFilterText(TextType value) {
        this.calendarEventTypeCodeFilterText = value;
    }

    /**
     * Gets the value of the docketEntryTimeRange property.
     * 
     * @return
     *     possible object is
     *     {@link DateRangeType }
     *     
     */
    public DateRangeType getDocketEntryTimeRange() {
        return docketEntryTimeRange;
    }

    /**
     * Sets the value of the docketEntryTimeRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRangeType }
     *     
     */
    public void setDocketEntryTimeRange(DateRangeType value) {
        this.docketEntryTimeRange = value;
    }

    /**
     * Gets the value of the calendarEventTimeRange property.
     * 
     * @return
     *     possible object is
     *     {@link DateRangeType }
     *     
     */
    public DateRangeType getCalendarEventTimeRange() {
        return calendarEventTimeRange;
    }

    /**
     * Sets the value of the calendarEventTimeRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRangeType }
     *     
     */
    public void setCalendarEventTimeRange(DateRangeType value) {
        this.calendarEventTimeRange = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
