
package ecf4.latest.tyler.ecf.extensions.common;

import ecf4.latest.gov.niem.niem.niem_core._2.AssociationType;
import ecf4.latest.gov.niem.niem.structures._2.ReferenceType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for FilingAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilingAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}PartyReference"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}FilingReference"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
