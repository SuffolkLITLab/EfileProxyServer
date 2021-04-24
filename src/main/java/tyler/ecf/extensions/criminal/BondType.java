
package tyler.ecf.extensions.criminal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.AmountType;
import gov.niem.niem.niem_core._2.TextType;


/**
 * &lt;p&gt;Java class for BondType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="BondType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Criminal}BondTypeText"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Criminal}BondAmount"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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

}
