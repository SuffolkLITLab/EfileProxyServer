
package tyler.ecf.v5_0.extensions.criminal;

import gov.niem.release.niem.domains.jxdm._6.JudicialOfficialType;
import gov.niem.release.niem.niem_core._4.DateType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for PleaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PleaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}PleaIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}PleaDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}PleaDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}Judge" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}JuryTrialDemandIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}JuryTrialDemandDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}SpeedyTrialDemandIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}SpeedyTrialDemandDate" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PleaType", propOrder = {
    "pleaIdentification",
    "pleaDescriptionText",
    "pleaDate",
    "judge",
    "juryTrialDemandIndicator",
    "juryTrialDemandDate",
    "speedyTrialDemandIndicator",
    "speedyTrialDemandDate"
})
public class PleaType {

    @XmlElement(name = "PleaIdentification")
    protected IdentificationType pleaIdentification;
    @XmlElement(name = "PleaDescriptionText")
    protected TextType pleaDescriptionText;
    @XmlElement(name = "PleaDate")
    protected DateType pleaDate;
    @XmlElement(name = "Judge", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/")
    protected JudicialOfficialType judge;
    @XmlElement(name = "JuryTrialDemandIndicator")
    protected Boolean juryTrialDemandIndicator;
    @XmlElement(name = "JuryTrialDemandDate")
    protected DateType juryTrialDemandDate;
    @XmlElement(name = "SpeedyTrialDemandIndicator")
    protected Boolean speedyTrialDemandIndicator;
    @XmlElement(name = "SpeedyTrialDemandDate")
    protected DateType speedyTrialDemandDate;

    /**
     * Gets the value of the pleaIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getPleaIdentification() {
        return pleaIdentification;
    }

    /**
     * Sets the value of the pleaIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setPleaIdentification(IdentificationType value) {
        this.pleaIdentification = value;
    }

    /**
     * Gets the value of the pleaDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getPleaDescriptionText() {
        return pleaDescriptionText;
    }

    /**
     * Sets the value of the pleaDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setPleaDescriptionText(TextType value) {
        this.pleaDescriptionText = value;
    }

    /**
     * Gets the value of the pleaDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getPleaDate() {
        return pleaDate;
    }

    /**
     * Sets the value of the pleaDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setPleaDate(DateType value) {
        this.pleaDate = value;
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
     * Gets the value of the juryTrialDemandIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getJuryTrialDemandIndicator() {
        return juryTrialDemandIndicator;
    }

    /**
     * Sets the value of the juryTrialDemandIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setJuryTrialDemandIndicator(Boolean value) {
        this.juryTrialDemandIndicator = value;
    }

    /**
     * Gets the value of the juryTrialDemandDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getJuryTrialDemandDate() {
        return juryTrialDemandDate;
    }

    /**
     * Sets the value of the juryTrialDemandDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setJuryTrialDemandDate(DateType value) {
        this.juryTrialDemandDate = value;
    }

    /**
     * Gets the value of the speedyTrialDemandIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getSpeedyTrialDemandIndicator() {
        return speedyTrialDemandIndicator;
    }

    /**
     * Sets the value of the speedyTrialDemandIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSpeedyTrialDemandIndicator(Boolean value) {
        this.speedyTrialDemandIndicator = value;
    }

    /**
     * Gets the value of the speedyTrialDemandDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getSpeedyTrialDemandDate() {
        return speedyTrialDemandDate;
    }

    /**
     * Sets the value of the speedyTrialDemandDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setSpeedyTrialDemandDate(DateType value) {
        this.speedyTrialDemandDate = value;
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
