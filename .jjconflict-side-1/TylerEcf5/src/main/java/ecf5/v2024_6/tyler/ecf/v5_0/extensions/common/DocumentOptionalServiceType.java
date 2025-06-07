
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.common;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.AmountType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.NonNegativeDecimalType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DocumentOptionalServiceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentOptionalServiceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}IdentificationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}MultiplierAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ServiceFeeAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}PartyPayor" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "DocumentOptionalServiceType", propOrder = {
    "multiplierAmount",
    "serviceFeeAmount",
    "partyPayor"
})
public class DocumentOptionalServiceType
    extends IdentificationType
{

    @XmlElement(name = "MultiplierAmount")
    protected NonNegativeDecimalType multiplierAmount;
    @XmlElement(name = "ServiceFeeAmount")
    protected AmountType serviceFeeAmount;
    @XmlElement(name = "PartyPayor")
    protected List<PartyPayorType> partyPayor;

    /**
     * Gets the value of the multiplierAmount property.
     * 
     * @return
     *     possible object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public NonNegativeDecimalType getMultiplierAmount() {
        return multiplierAmount;
    }

    /**
     * Sets the value of the multiplierAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public void setMultiplierAmount(NonNegativeDecimalType value) {
        this.multiplierAmount = value;
    }

    /**
     * Gets the value of the serviceFeeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getServiceFeeAmount() {
        return serviceFeeAmount;
    }

    /**
     * Sets the value of the serviceFeeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setServiceFeeAmount(AmountType value) {
        this.serviceFeeAmount = value;
    }

    /**
     * Gets the value of the partyPayor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the partyPayor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartyPayor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartyPayorType }
     * 
     * 
     */
    public List<PartyPayorType> getPartyPayor() {
        if (partyPayor == null) {
            partyPayor = new ArrayList<PartyPayorType>();
        }
        return this.partyPayor;
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
