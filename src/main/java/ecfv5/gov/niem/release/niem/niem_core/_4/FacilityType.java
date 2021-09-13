
package ecfv5.gov.niem.release.niem.niem_core._4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.structures._4.ObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a building, place, or structure that provides a particular service.
 * 
 * <p>Java class for FacilityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FacilityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}FacilityIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}FacilityName" minOccurs="0"/&gt;
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
@XmlType(name = "FacilityType", propOrder = {
    "facilityIdentification",
    "facilityName"
})
public class FacilityType
    extends ObjectType
{

    @XmlElement(name = "FacilityIdentification")
    protected IdentificationType facilityIdentification;
    @XmlElement(name = "FacilityName")
    protected ProperNameTextType facilityName;

    /**
     * Gets the value of the facilityIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getFacilityIdentification() {
        return facilityIdentification;
    }

    /**
     * Sets the value of the facilityIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setFacilityIdentification(IdentificationType value) {
        this.facilityIdentification = value;
    }

    /**
     * Gets the value of the facilityName property.
     * 
     * @return
     *     possible object is
     *     {@link ProperNameTextType }
     *     
     */
    public ProperNameTextType getFacilityName() {
        return facilityName;
    }

    /**
     * Sets the value of the facilityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProperNameTextType }
     *     
     */
    public void setFacilityName(ProperNameTextType value) {
        this.facilityName = value;
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
