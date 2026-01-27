
package ecf4.v2025_0.gov.niem.release.niem.niem_core._4;

import ecf4.v2025_0.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a periodic basis on which an obligation must be met.
 * 
 * <p>Java class for ObligationRecurrenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObligationRecurrenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ObligationPeriodText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ObligationDateRange" minOccurs="0"/&gt;
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
@XmlType(name = "ObligationRecurrenceType", propOrder = {
    "obligationPeriodText",
    "obligationDateRange"
})
public class ObligationRecurrenceType
    extends ObjectType
{

    @XmlElement(name = "ObligationPeriodText")
    protected TextType obligationPeriodText;
    @XmlElement(name = "ObligationDateRange")
    protected DateRangeType obligationDateRange;

    /**
     * Gets the value of the obligationPeriodText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getObligationPeriodText() {
        return obligationPeriodText;
    }

    /**
     * Sets the value of the obligationPeriodText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setObligationPeriodText(TextType value) {
        this.obligationPeriodText = value;
    }

    /**
     * Gets the value of the obligationDateRange property.
     * 
     * @return
     *     possible object is
     *     {@link DateRangeType }
     *     
     */
    public DateRangeType getObligationDateRange() {
        return obligationDateRange;
    }

    /**
     * Sets the value of the obligationDateRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRangeType }
     *     
     */
    public void setObligationDateRange(DateRangeType value) {
        this.obligationDateRange = value;
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
