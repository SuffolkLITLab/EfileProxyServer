
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.partylistrequest;

import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.EntityType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.NonNegativeDecimalType;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.RequestMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for GetPartyListMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetPartyListMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RequestMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:partylistrequest}Party" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilerIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:partylistrequest}MaxNumberOfResults"/&gt;
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
@XmlType(name = "GetPartyListMessageType", propOrder = {
    "party",
    "filerIdentification",
    "maxNumberOfResults"
})
public class GetPartyListMessageType
    extends RequestMessageType
{

    @XmlElement(name = "Party")
    protected EntityType party;
    @XmlElement(name = "FilerIdentification", namespace = "urn:tyler:ecf:v5.0:extensions:common")
    protected IdentificationType filerIdentification;
    @XmlElement(name = "MaxNumberOfResults", required = true)
    protected NonNegativeDecimalType maxNumberOfResults;

    /**
     * Gets the value of the party property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getParty() {
        return party;
    }

    /**
     * Sets the value of the party property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setParty(EntityType value) {
        this.party = value;
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
     * Gets the value of the maxNumberOfResults property.
     * 
     * @return
     *     possible object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public NonNegativeDecimalType getMaxNumberOfResults() {
        return maxNumberOfResults;
    }

    /**
     * Sets the value of the maxNumberOfResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public void setMaxNumberOfResults(NonNegativeDecimalType value) {
        this.maxNumberOfResults = value;
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
