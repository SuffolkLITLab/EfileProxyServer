
package ecfv5.gov.niem.release.niem.domains.humanservices._4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.niem_core._4.AssociationType;
import ecfv5.gov.niem.release.niem.niem_core._4.PersonType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for an association between a juvenile and a person with whom the juvenile is directed to reside (e.g., foster parent, grandparent, etc.).
 * 
 * <p>Java class for JuvenilePlacementPersonAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JuvenilePlacementPersonAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/humanServices/4.0/}PlacementPerson"/&gt;
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
@XmlType(name = "JuvenilePlacementPersonAssociationType", propOrder = {
    "placementPerson"
})
public class JuvenilePlacementPersonAssociationType
    extends AssociationType
{

    @XmlElement(name = "PlacementPerson", required = true, nillable = true)
    protected PersonType placementPerson;

    /**
     * Gets the value of the placementPerson property.
     * 
     * @return
     *     possible object is
     *     {@link PersonType }
     *     
     */
    public PersonType getPlacementPerson() {
        return placementPerson;
    }

    /**
     * Sets the value of the placementPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonType }
     *     
     */
    public void setPlacementPerson(PersonType value) {
        this.placementPerson = value;
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
