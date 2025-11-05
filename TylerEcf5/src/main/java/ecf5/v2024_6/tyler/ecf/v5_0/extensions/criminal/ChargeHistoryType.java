
package tyler.ecf.v5_0.extensions.criminal;

import gov.niem.release.niem.domains.jxdm._6.ChargeType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ChargeHistoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChargeHistoryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/domains/jxdm/6.1/}ChargeType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}ChargeHistoryIdentification" minOccurs="0"/&gt;
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
@XmlType(name = "ChargeHistoryType", propOrder = {
    "chargeHistoryIdentification"
})
public class ChargeHistoryType
    extends ChargeType
{

    @XmlElement(name = "ChargeHistoryIdentification")
    protected IdentificationType chargeHistoryIdentification;

    /**
     * Gets the value of the chargeHistoryIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getChargeHistoryIdentification() {
        return chargeHistoryIdentification;
    }

    /**
     * Sets the value of the chargeHistoryIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setChargeHistoryIdentification(IdentificationType value) {
        this.chargeHistoryIdentification = value;
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
