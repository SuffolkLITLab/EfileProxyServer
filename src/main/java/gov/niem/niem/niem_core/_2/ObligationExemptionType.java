
package gov.niem.niem.niem_core._2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ObligationExemptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObligationExemptionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}FinancialObligationExemptionAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ObligationExemptionDescriptionText" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
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
    extends ComplexObjectType
{

    @XmlElement(name = "FinancialObligationExemptionAmount", nillable = true)
    protected AmountType financialObligationExemptionAmount;
    @XmlElement(name = "ObligationExemptionDescriptionText", nillable = true)
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
