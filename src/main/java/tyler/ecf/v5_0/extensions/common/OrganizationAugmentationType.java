
package tyler.ecf.v5_0.extensions.common;

import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for OrganizationAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}PartyIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilerIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}GroupIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}Agency" minOccurs="0"/&gt;
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
@XmlType(name = "OrganizationAugmentationType", propOrder = {
    "partyIdentification",
    "filerIdentification",
    "groupIdentification",
    "agency"
})
public class OrganizationAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "PartyIdentification")
    protected IdentificationType partyIdentification;
    @XmlElement(name = "FilerIdentification")
    protected IdentificationType filerIdentification;
    @XmlElement(name = "GroupIdentification")
    protected IdentificationType groupIdentification;
    @XmlElement(name = "Agency")
    protected AgencyType agency;

    /**
     * Gets the value of the partyIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getPartyIdentification() {
        return partyIdentification;
    }

    /**
     * Sets the value of the partyIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setPartyIdentification(IdentificationType value) {
        this.partyIdentification = value;
    }

    /**
     * Gets the value of the filerIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getFilerIdentification() {
        return filerIdentification;
    }

    /**
     * Sets the value of the filerIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setFilerIdentification(IdentificationType value) {
        this.filerIdentification = value;
    }

    /**
     * Gets the value of the groupIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getGroupIdentification() {
        return groupIdentification;
    }

    /**
     * Sets the value of the groupIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setGroupIdentification(IdentificationType value) {
        this.groupIdentification = value;
    }

    /**
     * Gets the value of the agency property.
     * 
     * @return
     *     possible object is
     *     {@link AgencyType }
     *     
     */
    public AgencyType getAgency() {
        return agency;
    }

    /**
     * Sets the value of the agency property.
     * 
     * @param value
     *     allowed object is
     *     {@link AgencyType }
     *     
     */
    public void setAgency(AgencyType value) {
        this.agency = value;
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
