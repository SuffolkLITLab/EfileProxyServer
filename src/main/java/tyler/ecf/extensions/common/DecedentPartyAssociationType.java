
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.structures._2.ReferenceType;


/**
 * &lt;p&gt;Java class for DecedentPartyAssociationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DecedentPartyAssociationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}PartyReference"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonDeathDate"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DecedentPartyAssociationType", propOrder = {
    "partyReference",
    "personDeathDate"
})
public class DecedentPartyAssociationType {

    @XmlElement(name = "PartyReference", required = true)
    protected ReferenceType partyReference;
    @XmlElement(name = "PersonDeathDate", namespace = "http://niem.gov/niem/niem-core/2.0", required = true, nillable = true)
    protected DateType personDeathDate;

    /**
     * Gets the value of the partyReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getPartyReference() {
        return partyReference;
    }

    /**
     * Sets the value of the partyReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setPartyReference(ReferenceType value) {
        this.partyReference = value;
    }

    /**
     * Gets the value of the personDeathDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getPersonDeathDate() {
        return personDeathDate;
    }

    /**
     * Sets the value of the personDeathDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setPersonDeathDate(DateType value) {
        this.personDeathDate = value;
    }

}
