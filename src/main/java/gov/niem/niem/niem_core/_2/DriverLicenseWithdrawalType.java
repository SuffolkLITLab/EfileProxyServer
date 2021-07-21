
package gov.niem.niem.niem_core._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DriverLicenseWithdrawalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DriverLicenseWithdrawalType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DriverLicenseWithdrawalEffectiveDate" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DriverLicenseWithdrawalType", propOrder = {
    "driverLicenseWithdrawalEffectiveDate"
})
public class DriverLicenseWithdrawalType
    extends ActivityType
{

    @XmlElement(name = "DriverLicenseWithdrawalEffectiveDate", nillable = true)
    protected DateType driverLicenseWithdrawalEffectiveDate;

    /**
     * Gets the value of the driverLicenseWithdrawalEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDriverLicenseWithdrawalEffectiveDate() {
        return driverLicenseWithdrawalEffectiveDate;
    }

    /**
     * Sets the value of the driverLicenseWithdrawalEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDriverLicenseWithdrawalEffectiveDate(DateType value) {
        this.driverLicenseWithdrawalEffectiveDate = value;
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
