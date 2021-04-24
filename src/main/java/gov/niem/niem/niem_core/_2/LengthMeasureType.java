
package gov.niem.niem.niem_core._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.unece_rec20_misc._2.LengthCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for LengthMeasureType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="LengthMeasureType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}MeasureType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}LengthUnitCode" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LengthMeasureType", propOrder = {
    "lengthUnitCode"
})
public class LengthMeasureType
    extends MeasureType
{

    @XmlElement(name = "LengthUnitCode", nillable = true)
    protected LengthCodeType lengthUnitCode;

    /**
     * Gets the value of the lengthUnitCode property.
     * 
     * @return
     *     possible object is
     *     {@link LengthCodeType }
     *     
     */
    public LengthCodeType getLengthUnitCode() {
        return lengthUnitCode;
    }

    /**
     * Sets the value of the lengthUnitCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthCodeType }
     *     
     */
    public void setLengthUnitCode(LengthCodeType value) {
        this.lengthUnitCode = value;
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
