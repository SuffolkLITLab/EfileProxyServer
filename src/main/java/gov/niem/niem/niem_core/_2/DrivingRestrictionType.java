
package gov.niem.niem.niem_core._2;

import gov.niem.niem.ansi_d20._2.DrivingRestrictionCodeType;
import gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DrivingRestrictionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DrivingRestrictionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DrivingRestrictionValue" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DrivingRestrictionEndDate" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DrivingRestrictionType", propOrder = {
    "drivingRestrictionValue",
    "drivingRestrictionEndDate"
})
public class DrivingRestrictionType
    extends ComplexObjectType
{

    @XmlElementRef(name = "DrivingRestrictionValue", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> drivingRestrictionValue;
    @XmlElement(name = "DrivingRestrictionEndDate", nillable = true)
    protected DateType drivingRestrictionEndDate;

    /**
     * Gets the value of the drivingRestrictionValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DrivingRestrictionCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getDrivingRestrictionValue() {
        return drivingRestrictionValue;
    }

    /**
     * Sets the value of the drivingRestrictionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DrivingRestrictionCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setDrivingRestrictionValue(JAXBElement<?> value) {
        this.drivingRestrictionValue = value;
    }

    /**
     * Gets the value of the drivingRestrictionEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDrivingRestrictionEndDate() {
        return drivingRestrictionEndDate;
    }

    /**
     * Sets the value of the drivingRestrictionEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDrivingRestrictionEndDate(DateType value) {
        this.drivingRestrictionEndDate = value;
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
