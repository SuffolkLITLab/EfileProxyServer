
package tyler.ecf.v5_0.extensions.common;

import gov.niem.release.niem.niem_core._4.AmountType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.NonNegativeDecimalType;
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
    "serviceFeeAmount"
})
public class DocumentOptionalServiceType
    extends IdentificationType
{

    @XmlElement(name = "MultiplierAmount")
    protected NonNegativeDecimalType multiplierAmount;
    @XmlElement(name = "ServiceFeeAmount")
    protected AmountType serviceFeeAmount;

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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
