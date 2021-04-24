
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.AssociationType;
import gov.niem.niem.structures._2.ReferenceType;


/**
 * &lt;p&gt;Java class for FilingAssociationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FilingAssociationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}AssociationType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}PartyReference"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}FilingReference"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilingAssociationType", propOrder = {
    "partyReference",
    "filingReference"
})
public class FilingAssociationType
    extends AssociationType
{

    @XmlElement(name = "PartyReference", required = true)
    protected ReferenceType partyReference;
    @XmlElement(name = "FilingReference", required = true)
    protected ReferenceType filingReference;

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
     * Gets the value of the filingReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getFilingReference() {
        return filingReference;
    }

    /**
     * Sets the value of the filingReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setFilingReference(ReferenceType value) {
        this.filingReference = value;
    }

}
