
package ecf5.v2024_6.gov.niem.release.niem.domains.jxdm._6;

import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.DateType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for an authorization issued to a driver granting driving privileges.
 * 
 * <p>Java class for DriverLicenseBaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DriverLicenseBaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}DriverLicenseIdentification"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}DriverLicenseExpirationDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}DriverLicenseIssueDate" minOccurs="0"/&gt;
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
@XmlType(name = "DriverLicenseBaseType", propOrder = {
    "driverLicenseIdentification",
    "driverLicenseExpirationDate",
    "driverLicenseIssueDate"
})
@XmlSeeAlso({
    DriverLicenseType.class
})
public class DriverLicenseBaseType
    extends ObjectType
{

    @XmlElement(name = "DriverLicenseIdentification", required = true)
    protected IdentificationType driverLicenseIdentification;
    @XmlElement(name = "DriverLicenseExpirationDate")
    protected DateType driverLicenseExpirationDate;
    @XmlElement(name = "DriverLicenseIssueDate")
    protected DateType driverLicenseIssueDate;

    /**
     * Gets the value of the driverLicenseIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getDriverLicenseIdentification() {
        return driverLicenseIdentification;
    }

    /**
     * Sets the value of the driverLicenseIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setDriverLicenseIdentification(IdentificationType value) {
        this.driverLicenseIdentification = value;
    }

    /**
     * Gets the value of the driverLicenseExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDriverLicenseExpirationDate() {
        return driverLicenseExpirationDate;
    }

    /**
     * Sets the value of the driverLicenseExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDriverLicenseExpirationDate(DateType value) {
        this.driverLicenseExpirationDate = value;
    }

    /**
     * Gets the value of the driverLicenseIssueDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDriverLicenseIssueDate() {
        return driverLicenseIssueDate;
    }

    /**
     * Sets the value of the driverLicenseIssueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDriverLicenseIssueDate(DateType value) {
        this.driverLicenseIssueDate = value;
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
