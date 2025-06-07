
package ecf4.latest.gov.niem.niem.niem_core._2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for SpeedMeasureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpeedMeasureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}MeasureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}SpeedUnitCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpeedMeasureType", propOrder = {
    "speedUnitCode"
})
public class SpeedMeasureType
    extends MeasureType
{

    @XmlElement(name = "SpeedUnitCode", nillable = true)
    protected ecf4.latest.gov.niem.niem.proxy.xsd._2.String speedUnitCode;

    /**
     * Gets the value of the speedUnitCode property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.latest.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public ecf4.latest.gov.niem.niem.proxy.xsd._2.String getSpeedUnitCode() {
        return speedUnitCode;
    }

    /**
     * Sets the value of the speedUnitCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.latest.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setSpeedUnitCode(ecf4.latest.gov.niem.niem.proxy.xsd._2.String value) {
        this.speedUnitCode = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
