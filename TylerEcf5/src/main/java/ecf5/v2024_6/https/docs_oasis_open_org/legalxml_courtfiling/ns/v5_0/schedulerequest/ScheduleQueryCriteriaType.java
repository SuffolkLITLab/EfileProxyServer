
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.schedulerequest;

import ecf5.v2024_6.gov.niem.release.niem.domains.jxdm._6.JudicialOfficialType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.DateRangeType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Criteria limiting the schedule information to be returned.
 * 
 * <p>Java class for ScheduleQueryCriteriaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScheduleQueryCriteriaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CourtEventTypeCode"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}CourtAdministrativeUnitText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}Judge" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DateRange" minOccurs="0"/&gt;
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
@XmlType(name = "ScheduleQueryCriteriaType", propOrder = {
    "caseTypeCode",
    "courtEventTypeCode",
    "courtAdministrativeUnitText",
    "judge",
    "dateRange"
})
public class ScheduleQueryCriteriaType
    extends ObjectType
{

    @XmlElement(name = "CaseTypeCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf")
    protected NormalizedString caseTypeCode;
    @XmlElement(name = "CourtEventTypeCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", required = true)
    protected TextType courtEventTypeCode;
    @XmlElement(name = "CourtAdministrativeUnitText", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/")
    protected TextType courtAdministrativeUnitText;
    @XmlElement(name = "Judge", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/")
    protected JudicialOfficialType judge;
    @XmlElement(name = "DateRange", namespace = "http://release.niem.gov/niem/niem-core/4.0/")
    protected DateRangeType dateRange;

    /**
     * Gets the value of the caseTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link NormalizedString }
     *     
     */
    public NormalizedString getCaseTypeCode() {
        return caseTypeCode;
    }

    /**
     * Sets the value of the caseTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalizedString }
     *     
     */
    public void setCaseTypeCode(NormalizedString value) {
        this.caseTypeCode = value;
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
     * Gets the value of the courtAdministrativeUnitText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCourtAdministrativeUnitText() {
        return courtAdministrativeUnitText;
    }

    /**
     * Sets the value of the courtAdministrativeUnitText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCourtAdministrativeUnitText(TextType value) {
        this.courtAdministrativeUnitText = value;
    }

    /**
     * Gets the value of the judge property.
     * 
     * @return
     *     possible object is
     *     {@link JudicialOfficialType }
     *     
     */
    public JudicialOfficialType getJudge() {
        return judge;
    }

    /**
     * Sets the value of the judge property.
     * 
     * @param value
     *     allowed object is
     *     {@link JudicialOfficialType }
     *     
     */
    public void setJudge(JudicialOfficialType value) {
        this.judge = value;
    }

    /**
     * Gets the value of the dateRange property.
     * 
     * @return
     *     possible object is
     *     {@link DateRangeType }
     *     
     */
    public DateRangeType getDateRange() {
        return dateRange;
    }

    /**
     * Sets the value of the dateRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRangeType }
     *     
     */
    public void setDateRange(DateRangeType value) {
        this.dateRange = value;
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
