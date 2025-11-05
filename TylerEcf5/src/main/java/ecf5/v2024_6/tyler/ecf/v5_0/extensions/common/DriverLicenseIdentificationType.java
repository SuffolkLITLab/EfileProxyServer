
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.common;

import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.DateType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.ProperNameTextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DriverLicenseIdentificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DriverLicenseIdentificationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}IdentificationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}LocationStateName"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}LicenseExpiration" minOccurs="0"/&gt;
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
@XmlType(name = "DriverLicenseIdentificationType", propOrder = {
    "locationStateName",
    "licenseExpiration"
})
public class DriverLicenseIdentificationType
    extends IdentificationType
{

    @XmlElement(name = "LocationStateName", namespace = "http://release.niem.gov/niem/niem-core/4.0/", required = true)
    protected ProperNameTextType locationStateName;
    @XmlElement(name = "LicenseExpiration")
    protected DateType licenseExpiration;

    /**
     * Gets the value of the locationStateName property.
     * 
     * @return
     *     possible object is
     *     {@link ProperNameTextType }
     *     
     */
    public ProperNameTextType getLocationStateName() {
        return locationStateName;
    }

    /**
     * Sets the value of the locationStateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProperNameTextType }
     *     
     */
    public void setLocationStateName(ProperNameTextType value) {
        this.locationStateName = value;
    }

    /**
     * Gets the value of the licenseExpiration property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getLicenseExpiration() {
        return licenseExpiration;
    }

    /**
     * Sets the value of the licenseExpiration property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setLicenseExpiration(DateType value) {
        this.licenseExpiration = value;
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
