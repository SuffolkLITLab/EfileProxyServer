
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caserequest;

import ecf4.latest.gov.niem.release.niem.niem_core._4.DateRangeType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.TextType;
import ecf4.latest.gov.niem.release.niem.proxy.xsd._4.Boolean;
import ecf4.latest.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Criteria limiting the case information to be returned.
 * 
 * <p>Java class for CaseQueryCriteriaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseQueryCriteriaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest}CalendarEventTimeRange" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest}DocketEntryTimeRange" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest}DocketEntryTypeCodeFilterText"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest}IncludeCalendarEventIndicator"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest}IncludeDocketEntryIndicator"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest}IncludeParticipantsIndicator"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CourtEventTypeCode"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseQueryCriteriaType", propOrder = {
    "calendarEventTimeRange",
    "docketEntryTimeRange",
    "docketEntryTypeCodeFilterText",
    "includeCalendarEventIndicator",
    "includeDocketEntryIndicator",
    "includeParticipantsIndicator",
    "courtEventTypeCode"
})
public class CaseQueryCriteriaType
    extends ObjectType
{

    @XmlElement(name = "CalendarEventTimeRange")
    protected DateRangeType calendarEventTimeRange;
    @XmlElement(name = "DocketEntryTimeRange")
    protected DateRangeType docketEntryTimeRange;
    @XmlElement(name = "DocketEntryTypeCodeFilterText", required = true)
    protected TextType docketEntryTypeCodeFilterText;
    @XmlElement(name = "IncludeCalendarEventIndicator", required = true)
    protected Boolean includeCalendarEventIndicator;
    @XmlElement(name = "IncludeDocketEntryIndicator", required = true)
    protected Boolean includeDocketEntryIndicator;
    @XmlElement(name = "IncludeParticipantsIndicator", required = true)
    protected Boolean includeParticipantsIndicator;
    @XmlElement(name = "CourtEventTypeCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", required = true)
    protected TextType courtEventTypeCode;

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
     * Gets the value of the courtEventTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCourtEventTypeCode() {
        return courtEventTypeCode;
    }

    /**
     * Sets the value of the courtEventTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCourtEventTypeCode(TextType value) {
        this.courtEventTypeCode = value;
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
