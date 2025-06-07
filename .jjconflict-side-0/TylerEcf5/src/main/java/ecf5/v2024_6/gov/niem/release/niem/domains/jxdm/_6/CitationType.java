
package ecf5.v2024_6.gov.niem.release.niem.domains.jxdm._6;

import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.ActivityType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.OrganizationType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for an official summons to appear in court or pay a fine.
 * 
 * <p>Java class for CitationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CitationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}CitationAgency" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}CitationDismissalConditionIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}CitationDismissalConditionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}CitationIssuingOfficial" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}CitationSubject" minOccurs="0"/&gt;
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
@XmlType(name = "CitationType", propOrder = {
    "citationAgency",
    "citationDismissalConditionIndicator",
    "citationDismissalConditionText",
    "citationIssuingOfficial",
    "citationSubject"
})
public class CitationType
    extends ActivityType
{

    @XmlElement(name = "CitationAgency", nillable = true)
    protected OrganizationType citationAgency;
    @XmlElement(name = "CitationDismissalConditionIndicator")
    protected Boolean citationDismissalConditionIndicator;
    @XmlElement(name = "CitationDismissalConditionText")
    protected TextType citationDismissalConditionText;
    @XmlElement(name = "CitationIssuingOfficial")
    protected EnforcementOfficialType citationIssuingOfficial;
    @XmlElement(name = "CitationSubject")
    protected SubjectType citationSubject;

    /**
     * Gets the value of the citationAgency property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationType }
     *     
     */
    public OrganizationType getCitationAgency() {
        return citationAgency;
    }

    /**
     * Sets the value of the citationAgency property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationType }
     *     
     */
    public void setCitationAgency(OrganizationType value) {
        this.citationAgency = value;
    }

    /**
     * Gets the value of the citationDismissalConditionIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getCitationDismissalConditionIndicator() {
        return citationDismissalConditionIndicator;
    }

    /**
     * Sets the value of the citationDismissalConditionIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCitationDismissalConditionIndicator(Boolean value) {
        this.citationDismissalConditionIndicator = value;
    }

    /**
     * Gets the value of the citationDismissalConditionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCitationDismissalConditionText() {
        return citationDismissalConditionText;
    }

    /**
     * Sets the value of the citationDismissalConditionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCitationDismissalConditionText(TextType value) {
        this.citationDismissalConditionText = value;
    }

    /**
     * Gets the value of the citationIssuingOfficial property.
     * 
     * @return
     *     possible object is
     *     {@link EnforcementOfficialType }
     *     
     */
    public EnforcementOfficialType getCitationIssuingOfficial() {
        return citationIssuingOfficial;
    }

    /**
     * Sets the value of the citationIssuingOfficial property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnforcementOfficialType }
     *     
     */
    public void setCitationIssuingOfficial(EnforcementOfficialType value) {
        this.citationIssuingOfficial = value;
    }

    /**
     * Gets the value of the citationSubject property.
     * 
     * @return
     *     possible object is
     *     {@link SubjectType }
     *     
     */
    public SubjectType getCitationSubject() {
        return citationSubject;
    }

    /**
     * Sets the value of the citationSubject property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubjectType }
     *     
     */
    public void setCitationSubject(SubjectType value) {
        this.citationSubject = value;
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
