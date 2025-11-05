
package ecf4.latest.gov.niem.release.niem.domains.humanservices._4;

import ecf4.latest.gov.niem.release.niem.niem_core._4.AssociationType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.FacilityType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for an association between a juvenile and a facility where the juvenile is directed to reside (e.g., orphanage, detention center, etc.).
 * 
 * <p>Java class for JuvenilePlacementFacilityAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JuvenilePlacementFacilityAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/humanServices/4.0/}PlacementFacility"/&gt;
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
@XmlType(name = "JuvenilePlacementFacilityAssociationType", propOrder = {
    "placementFacility"
})
public class JuvenilePlacementFacilityAssociationType
    extends AssociationType
{

    @XmlElement(name = "PlacementFacility", required = true)
    protected FacilityType placementFacility;

    /**
     * Gets the value of the placementFacility property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityType }
     *     
     */
    public FacilityType getPlacementFacility() {
        return placementFacility;
    }

    /**
     * Sets the value of the placementFacility property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityType }
     *     
     */
    public void setPlacementFacility(FacilityType value) {
        this.placementFacility = value;
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
