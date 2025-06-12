
package tyler.ecf.extensions.criminal;

import gov.niem.niem.niem_core._2.AmountType;
import gov.niem.niem.niem_core._2.TextType;
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
 *         &lt;element ref="{urn:tyler:ecf:extensions:Criminal}BondTypeText"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Criminal}BondAmount"/&gt;
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
    "bondTypeText",
    "bondAmount"
})
public class BondType {

    @XmlElement(name = "BondTypeText", required = true)
    protected TextType bondTypeText;
    @XmlElement(name = "BondAmount", required = true)
    protected AmountType bondAmount;

    /**
     * Gets the value of the bondTypeText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getBondTypeText() {
        return bondTypeText;
    }

    /**
     * Sets the value of the bondTypeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setBondTypeText(TextType value) {
        this.bondTypeText = value;
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
