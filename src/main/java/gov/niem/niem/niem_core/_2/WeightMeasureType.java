
package gov.niem.niem.niem_core._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.unece_rec20_misc._2.MassCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for WeightMeasureType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="WeightMeasureType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}MeasureType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}WeightUnitCode" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WeightMeasureType", propOrder = {
    "weightUnitCode"
})
public class WeightMeasureType
    extends MeasureType
{

    @XmlElement(name = "WeightUnitCode", nillable = true)
    protected MassCodeType weightUnitCode;

    /**
     * Gets the value of the weightUnitCode property.
     * 
     * @return
     *     possible object is
     *     {@link MassCodeType }
     *     
     */
    public MassCodeType getWeightUnitCode() {
        return weightUnitCode;
    }

    /**
     * Sets the value of the weightUnitCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link MassCodeType }
     *     
     */
    public void setWeightUnitCode(MassCodeType value) {
        this.weightUnitCode = value;
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
