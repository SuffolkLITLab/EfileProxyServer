
package tyler.ecf.v5_0.extensions.common;

import gov.niem.release.niem.niem_core._4.DateType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CourtScheduleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CourtScheduleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ScheduleDayStartTime" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ScheduleDayEndTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CourtScheduleType", propOrder = {
    "scheduleDayStartTime",
    "scheduleDayEndTime"
})
public class CourtScheduleType {

    @XmlElement(name = "ScheduleDayStartTime")
    protected DateType scheduleDayStartTime;
    @XmlElement(name = "ScheduleDayEndTime")
    protected DateType scheduleDayEndTime;

    /**
     * Gets the value of the scheduleDayStartTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getScheduleDayStartTime() {
        return scheduleDayStartTime;
    }

    /**
     * Sets the value of the scheduleDayStartTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setScheduleDayStartTime(DateType value) {
        this.scheduleDayStartTime = value;
    }

    /**
     * Gets the value of the scheduleDayEndTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getScheduleDayEndTime() {
        return scheduleDayEndTime;
    }

    /**
     * Sets the value of the scheduleDayEndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setScheduleDayEndTime(DateType value) {
        this.scheduleDayEndTime = value;
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
