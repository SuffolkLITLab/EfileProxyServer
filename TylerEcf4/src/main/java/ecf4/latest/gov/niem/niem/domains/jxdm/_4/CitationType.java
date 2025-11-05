
package ecf4.latest.gov.niem.niem.domains.jxdm._4;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.niem.niem_core._2.ActivityType;
import ecf4.latest.gov.niem.niem.niem_core._2.IncidentType;
import ecf4.latest.gov.niem.niem.niem_core._2.OrganizationType;
import ecf4.latest.gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CitationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CitationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CitationAgency" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CitationDismissalConditionIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CitationIssuingOfficial" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CitationSubject" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CitationViolation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
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
    "citationIssuingOfficial",
    "citationSubject",
    "citationViolation"
})
public class CitationType
    extends ActivityType
{

    @XmlElement(name = "CitationAgency", nillable = true)
    protected OrganizationType citationAgency;
    @XmlElement(name = "CitationDismissalConditionIndicator", nillable = true)
    protected Boolean citationDismissalConditionIndicator;
    @XmlElement(name = "CitationIssuingOfficial", nillable = true)
    protected EnforcementOfficialType citationIssuingOfficial;
    @XmlElement(name = "CitationSubject", nillable = true)
    protected SubjectType citationSubject;
    @XmlElement(name = "CitationViolation", nillable = true)
    protected List<IncidentType> citationViolation;

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
     * Gets the value of the citationViolation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the citationViolation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCitationViolation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IncidentType }
     * 
     * 
     */
    public List<IncidentType> getCitationViolation() {
        if (citationViolation == null) {
            citationViolation = new ArrayList<IncidentType>();
        }
        return this.citationViolation;
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
