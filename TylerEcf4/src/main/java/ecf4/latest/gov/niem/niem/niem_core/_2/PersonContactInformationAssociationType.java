
package ecf4.latest.gov.niem.niem.niem_core._2;

import ecf4.latest.gov.niem.niem.proxy.xsd._2.Boolean;
import ecf4.latest.gov.niem.niem.structures._2.ReferenceType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for PersonContactInformationAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonContactInformationAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonReference"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ContactInformationReference"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ContactInformationIsPrimaryIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ContactInformationIsHomeIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ContactInformationIsWorkIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ContactInformationIsEmergencyIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ContactInformationIsDayIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ContactInformationIsEveningIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ContactInformationIsNightIndicator" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonContactInformationAssociationType", propOrder = {
    "personReference",
    "contactInformationReference",
    "contactInformationIsPrimaryIndicator",
    "contactInformationIsHomeIndicator",
    "contactInformationIsWorkIndicator",
    "contactInformationIsEmergencyIndicator",
    "contactInformationIsDayIndicator",
    "contactInformationIsEveningIndicator",
    "contactInformationIsNightIndicator"
})
public class PersonContactInformationAssociationType
    extends AssociationType
{

    @XmlElement(name = "PersonReference", required = true)
    protected ReferenceType personReference;
    @XmlElement(name = "ContactInformationReference", required = true)
    protected ReferenceType contactInformationReference;
    @XmlElement(name = "ContactInformationIsPrimaryIndicator", nillable = true)
    protected Boolean contactInformationIsPrimaryIndicator;
    @XmlElement(name = "ContactInformationIsHomeIndicator", nillable = true)
    protected Boolean contactInformationIsHomeIndicator;
    @XmlElement(name = "ContactInformationIsWorkIndicator", nillable = true)
    protected Boolean contactInformationIsWorkIndicator;
    @XmlElement(name = "ContactInformationIsEmergencyIndicator", nillable = true)
    protected Boolean contactInformationIsEmergencyIndicator;
    @XmlElement(name = "ContactInformationIsDayIndicator", nillable = true)
    protected Boolean contactInformationIsDayIndicator;
    @XmlElement(name = "ContactInformationIsEveningIndicator", nillable = true)
    protected Boolean contactInformationIsEveningIndicator;
    @XmlElement(name = "ContactInformationIsNightIndicator", nillable = true)
    protected Boolean contactInformationIsNightIndicator;

    /**
     * Gets the value of the personReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getPersonReference() {
        return personReference;
    }

    /**
     * Sets the value of the personReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setPersonReference(ReferenceType value) {
        this.personReference = value;
    }

    /**
     * Gets the value of the contactInformationReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getContactInformationReference() {
        return contactInformationReference;
    }

    /**
     * Sets the value of the contactInformationReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setContactInformationReference(ReferenceType value) {
        this.contactInformationReference = value;
    }

    /**
     * Gets the value of the contactInformationIsPrimaryIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getContactInformationIsPrimaryIndicator() {
        return contactInformationIsPrimaryIndicator;
    }

    /**
     * Sets the value of the contactInformationIsPrimaryIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContactInformationIsPrimaryIndicator(Boolean value) {
        this.contactInformationIsPrimaryIndicator = value;
    }

    /**
     * Gets the value of the contactInformationIsHomeIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getContactInformationIsHomeIndicator() {
        return contactInformationIsHomeIndicator;
    }

    /**
     * Sets the value of the contactInformationIsHomeIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContactInformationIsHomeIndicator(Boolean value) {
        this.contactInformationIsHomeIndicator = value;
    }

    /**
     * Gets the value of the contactInformationIsWorkIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getContactInformationIsWorkIndicator() {
        return contactInformationIsWorkIndicator;
    }

    /**
     * Sets the value of the contactInformationIsWorkIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContactInformationIsWorkIndicator(Boolean value) {
        this.contactInformationIsWorkIndicator = value;
    }

    /**
     * Gets the value of the contactInformationIsEmergencyIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getContactInformationIsEmergencyIndicator() {
        return contactInformationIsEmergencyIndicator;
    }

    /**
     * Sets the value of the contactInformationIsEmergencyIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContactInformationIsEmergencyIndicator(Boolean value) {
        this.contactInformationIsEmergencyIndicator = value;
    }

    /**
     * Gets the value of the contactInformationIsDayIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getContactInformationIsDayIndicator() {
        return contactInformationIsDayIndicator;
    }

    /**
     * Sets the value of the contactInformationIsDayIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContactInformationIsDayIndicator(Boolean value) {
        this.contactInformationIsDayIndicator = value;
    }

    /**
     * Gets the value of the contactInformationIsEveningIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getContactInformationIsEveningIndicator() {
        return contactInformationIsEveningIndicator;
    }

    /**
     * Sets the value of the contactInformationIsEveningIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContactInformationIsEveningIndicator(Boolean value) {
        this.contactInformationIsEveningIndicator = value;
    }

    /**
     * Gets the value of the contactInformationIsNightIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getContactInformationIsNightIndicator() {
        return contactInformationIsNightIndicator;
    }

    /**
     * Sets the value of the contactInformationIsNightIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContactInformationIsNightIndicator(Boolean value) {
        this.contactInformationIsNightIndicator = value;
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
