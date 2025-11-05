
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caserequest;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.DateRangeType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Boolean;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Criteria limiting the list of cases to be returned.
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
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest}DocketEntryTypeCodeFilterText" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest}IncludeCalendarEventIndicator"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest}IncludeDocketEntryIndicator"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest}IncludeParticipantsIndicator"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseTrackingID" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CourtEventTypeCode" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}CaseNumberText"/&gt;
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
    "caseTrackingID",
    "courtEventTypeCode",
    "caseNumberText"
})
public class CaseQueryCriteriaType
    extends ObjectType
{

    @XmlElement(name = "CalendarEventTimeRange")
    protected DateRangeType calendarEventTimeRange;
    @XmlElement(name = "DocketEntryTimeRange")
    protected DateRangeType docketEntryTimeRange;
    @XmlElement(name = "DocketEntryTypeCodeFilterText")
    protected List<TextType> docketEntryTypeCodeFilterText;
    @XmlElement(name = "IncludeCalendarEventIndicator", required = true)
    protected Boolean includeCalendarEventIndicator;
    @XmlElement(name = "IncludeDocketEntryIndicator", required = true)
    protected Boolean includeDocketEntryIndicator;
    @XmlElement(name = "IncludeParticipantsIndicator", required = true)
    protected Boolean includeParticipantsIndicator;
    @XmlElement(name = "CaseTrackingID", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf")
    protected IdentificationType caseTrackingID;
    @XmlElement(name = "CourtEventTypeCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf")
    protected List<TextType> courtEventTypeCode;
    @XmlElement(name = "CaseNumberText", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/", required = true)
    protected TextType caseNumberText;

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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the docketEntryTypeCodeFilterText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocketEntryTypeCodeFilterText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getDocketEntryTypeCodeFilterText() {
        if (docketEntryTypeCodeFilterText == null) {
            docketEntryTypeCodeFilterText = new ArrayList<TextType>();
        }
        return this.docketEntryTypeCodeFilterText;
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
     * Gets the value of the caseTrackingID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getCaseTrackingID() {
        return caseTrackingID;
    }

    /**
     * Sets the value of the caseTrackingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setCaseTrackingID(IdentificationType value) {
        this.caseTrackingID = value;
    }

    /**
     * Gets the value of the courtEventTypeCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the courtEventTypeCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourtEventTypeCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getCourtEventTypeCode() {
        if (courtEventTypeCode == null) {
            courtEventTypeCode = new ArrayList<TextType>();
        }
        return this.courtEventTypeCode;
    }

    /**
     * Gets the value of the caseNumberText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCaseNumberText() {
        return caseNumberText;
    }

    /**
     * Sets the value of the caseNumberText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCaseNumberText(TextType value) {
        this.caseNumberText = value;
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
