
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.criminal;

import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.AmountType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for BondType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BondType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}BondTypeCode"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}BondAmount"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BondType", propOrder = {
    "bondTypeCode",
    "bondAmount"
})
public class BondType {

    @XmlElement(name = "BondTypeCode", required = true)
    protected TextType bondTypeCode;
    @XmlElement(name = "BondAmount", required = true)
    protected AmountType bondAmount;

    /**
     * Gets the value of the bondTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getBondTypeCode() {
        return bondTypeCode;
    }

    /**
     * Sets the value of the bondTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setBondTypeCode(TextType value) {
        this.bondTypeCode = value;
    }

    /**
     * Gets the value of the bondAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getBondAmount() {
        return bondAmount;
    }

    /**
     * Sets the value of the bondAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setBondAmount(AmountType value) {
        this.bondAmount = value;
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
