
package gov.niem.niem.niem_core._2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DriverLicenseBaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DriverLicenseBaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DriverLicenseIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DriverLicenseExpirationDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DriverLicenseIssueDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DriverLicenseRestriction" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
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
    "driverLicenseIssueDate",
    "driverLicenseRestriction"
})
@XmlSeeAlso({
    DriverLicenseType.class
})
public class DriverLicenseBaseType
    extends ComplexObjectType
{

    @XmlElement(name = "DriverLicenseIdentification", nillable = true)
    protected IdentificationType driverLicenseIdentification;
    @XmlElement(name = "DriverLicenseExpirationDate", nillable = true)
    protected DateType driverLicenseExpirationDate;
    @XmlElement(name = "DriverLicenseIssueDate", nillable = true)
    protected DateType driverLicenseIssueDate;
    @XmlElement(name = "DriverLicenseRestriction", nillable = true)
    protected DrivingRestrictionType driverLicenseRestriction;

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
     * Gets the value of the driverLicenseRestriction property.
     * 
     * @return
     *     possible object is
     *     {@link DrivingRestrictionType }
     *     
     */
    public DrivingRestrictionType getDriverLicenseRestriction() {
        return driverLicenseRestriction;
    }

    /**
     * Sets the value of the driverLicenseRestriction property.
     * 
     * @param value
     *     allowed object is
     *     {@link DrivingRestrictionType }
     *     
     */
    public void setDriverLicenseRestriction(DrivingRestrictionType value) {
        this.driverLicenseRestriction = value;
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
