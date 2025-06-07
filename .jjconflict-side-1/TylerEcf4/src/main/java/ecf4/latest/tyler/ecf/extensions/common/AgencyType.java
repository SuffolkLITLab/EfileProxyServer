
package ecf4.latest.tyler.ecf.extensions.common;

import ecf4.latest.gov.niem.niem.niem_core._2.IdentificationType;
import ecf4.latest.gov.niem.niem.structures._2.ReferenceType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for AgencyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AgencyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}PartyReference"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}AgencyIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}AgencyOperation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AgencyType", propOrder = {
    "partyReference",
    "agencyIdentification",
    "agencyOperation"
})
public class AgencyType {

    @XmlElement(name = "PartyReference", required = true)
    protected ReferenceType partyReference;
    @XmlElement(name = "AgencyIdentification")
    protected IdentificationType agencyIdentification;
    @XmlElement(name = "AgencyOperation")
    @XmlSchemaType(name = "token")
    protected AgencyOperationType agencyOperation;

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
     * Gets the value of the agencyIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getAgencyIdentification() {
        return agencyIdentification;
    }

    /**
     * Sets the value of the agencyIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setAgencyIdentification(IdentificationType value) {
        this.agencyIdentification = value;
    }

    /**
     * Gets the value of the agencyOperation property.
     * 
     * @return
     *     possible object is
     *     {@link AgencyOperationType }
     *     
     */
    public AgencyOperationType getAgencyOperation() {
        return agencyOperation;
    }

    /**
     * Sets the value of the agencyOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AgencyOperationType }
     *     
     */
    public void setAgencyOperation(AgencyOperationType value) {
        this.agencyOperation = value;
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
