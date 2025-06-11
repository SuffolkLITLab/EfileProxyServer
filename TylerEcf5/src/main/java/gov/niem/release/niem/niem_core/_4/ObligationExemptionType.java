
package gov.niem.release.niem.niem_core._4;

import gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a waival or dismissal of an obligation.
 * 
 * <p>Java class for ObligationExemptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObligationExemptionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}FinancialObligationExemptionAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ObligationExemptionDescriptionText" minOccurs="0"/&gt;
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
@XmlType(name = "ObligationExemptionType", propOrder = {
    "financialObligationExemptionAmount",
    "obligationExemptionDescriptionText"
})
public class ObligationExemptionType
    extends ObjectType
{

    @XmlElement(name = "FinancialObligationExemptionAmount")
    protected AmountType financialObligationExemptionAmount;
    @XmlElement(name = "ObligationExemptionDescriptionText")
    protected TextType obligationExemptionDescriptionText;

    /**
     * Gets the value of the financialObligationExemptionAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getFinancialObligationExemptionAmount() {
        return financialObligationExemptionAmount;
    }

    /**
     * Sets the value of the financialObligationExemptionAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setFinancialObligationExemptionAmount(AmountType value) {
        this.financialObligationExemptionAmount = value;
    }

    /**
     * Gets the value of the obligationExemptionDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getObligationExemptionDescriptionText() {
        return obligationExemptionDescriptionText;
    }

    /**
     * Sets the value of the obligationExemptionDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setObligationExemptionDescriptionText(TextType value) {
        this.obligationExemptionDescriptionText = value;
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
