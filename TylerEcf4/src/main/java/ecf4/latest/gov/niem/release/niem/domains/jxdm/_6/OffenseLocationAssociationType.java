
package ecf4.latest.gov.niem.release.niem.domains.jxdm._6;

import ecf4.latest.gov.niem.release.niem.niem_core._4.AssociationType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.LocationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a relationship between an offense and a location at which the offense occurred.
 * 
 * <p>Java class for OffenseLocationAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OffenseLocationAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}Offense" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}Location" minOccurs="0"/&gt;
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
@XmlType(name = "OffenseLocationAssociationType", propOrder = {
    "offense",
    "location"
})
public class OffenseLocationAssociationType
    extends AssociationType
{

    @XmlElement(name = "Offense", nillable = true)
    protected OffenseType offense;
    @XmlElement(name = "Location", namespace = "http://release.niem.gov/niem/niem-core/4.0/", nillable = true)
    protected LocationType location;

    /**
     * Gets the value of the offense property.
     * 
     * @return
     *     possible object is
     *     {@link OffenseType }
     *     
     */
    public OffenseType getOffense() {
        return offense;
    }

    /**
     * Sets the value of the offense property.
     * 
     * @param value
     *     allowed object is
     *     {@link OffenseType }
     *     
     */
    public void setOffense(OffenseType value) {
        this.offense = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setLocation(LocationType value) {
        this.location = value;
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
