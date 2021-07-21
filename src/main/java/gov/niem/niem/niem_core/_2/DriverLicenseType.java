
package gov.niem.niem.niem_core._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.ansi_d20._2.DriverLicenseClassCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DriverLicenseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DriverLicenseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}DriverLicenseBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DriverLicenseCommercialClass" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DriverLicenseWithdrawal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DriverLicenseType", propOrder = {
    "driverLicenseCommercialClass",
    "driverLicenseWithdrawal"
})
public class DriverLicenseType
    extends DriverLicenseBaseType
{

    @XmlElementRef(name = "DriverLicenseCommercialClass", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> driverLicenseCommercialClass;
    @XmlElement(name = "DriverLicenseWithdrawal", nillable = true)
    protected DriverLicenseWithdrawalType driverLicenseWithdrawal;

    /**
     * Gets the value of the driverLicenseCommercialClass property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DriverLicenseClassCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getDriverLicenseCommercialClass() {
        return driverLicenseCommercialClass;
    }

    /**
     * Sets the value of the driverLicenseCommercialClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DriverLicenseClassCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setDriverLicenseCommercialClass(JAXBElement<?> value) {
        this.driverLicenseCommercialClass = value;
    }

    /**
     * Gets the value of the driverLicenseWithdrawal property.
     * 
     * @return
     *     possible object is
     *     {@link DriverLicenseWithdrawalType }
     *     
     */
    public DriverLicenseWithdrawalType getDriverLicenseWithdrawal() {
        return driverLicenseWithdrawal;
    }

    /**
     * Sets the value of the driverLicenseWithdrawal property.
     * 
     * @param value
     *     allowed object is
     *     {@link DriverLicenseWithdrawalType }
     *     
     */
    public void setDriverLicenseWithdrawal(DriverLicenseWithdrawalType value) {
        this.driverLicenseWithdrawal = value;
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
