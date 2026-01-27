
package ecf4.v2025_0.gov.niem.niem.domains.jxdm._4;

import ecf4.v2025_0.gov.niem.niem.niem_core._2.ItemValueType;
import ecf4.v2025_0.gov.niem.niem.structures._2.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for PropertyAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}PropertyTotalDamageValue" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyAugmentationType", propOrder = {
    "propertyTotalDamageValue"
})
public class PropertyAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "PropertyTotalDamageValue", nillable = true)
    protected ItemValueType propertyTotalDamageValue;

    /**
     * Gets the value of the propertyTotalDamageValue property.
     * 
     * @return
     *     possible object is
     *     {@link ItemValueType }
     *     
     */
    public ItemValueType getPropertyTotalDamageValue() {
        return propertyTotalDamageValue;
    }

    /**
     * Sets the value of the propertyTotalDamageValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemValueType }
     *     
     */
    public void setPropertyTotalDamageValue(ItemValueType value) {
        this.propertyTotalDamageValue = value;
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
