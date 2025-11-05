
package tyler.ecf.v5_0.extensions.common;

import gov.niem.release.niem.niem_core._4.NonNegativeDecimalType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for VehicleRegistrationDateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleRegistrationDateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}RegistrationMonth" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}RegistrationYear"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleRegistrationDateType", propOrder = {
    "registrationMonth",
    "registrationYear"
})
public class VehicleRegistrationDateType {

    @XmlElement(name = "RegistrationMonth")
    protected NonNegativeDecimalType registrationMonth;
    @XmlElement(name = "RegistrationYear", required = true)
    protected NonNegativeDecimalType registrationYear;

    /**
     * Gets the value of the registrationMonth property.
     * 
     * @return
     *     possible object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public NonNegativeDecimalType getRegistrationMonth() {
        return registrationMonth;
    }

    /**
     * Sets the value of the registrationMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public void setRegistrationMonth(NonNegativeDecimalType value) {
        this.registrationMonth = value;
    }

    /**
     * Gets the value of the registrationYear property.
     * 
     * @return
     *     possible object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public NonNegativeDecimalType getRegistrationYear() {
        return registrationYear;
    }

    /**
     * Sets the value of the registrationYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public void setRegistrationYear(NonNegativeDecimalType value) {
        this.registrationYear = value;
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
