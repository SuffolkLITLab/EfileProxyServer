
package ecf5.v2024_6.gov.niem.release.niem.domains.humanservices._4;

import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.PersonType;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a juvenile.
 * 
 * <p>Java class for JuvenileType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JuvenileType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}RoleOfPerson"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/humanServices/4.1/}JuvenileAugmentationPoint"/&gt;
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
@XmlType(name = "JuvenileType", propOrder = {
    "roleOfPerson",
    "juvenileAugmentationPoint"
})
public class JuvenileType
    extends ObjectType
{

    @XmlElement(name = "RoleOfPerson", namespace = "http://release.niem.gov/niem/niem-core/4.0/", required = true, nillable = true)
    protected PersonType roleOfPerson;
    @XmlElement(name = "JuvenileAugmentationPoint", required = true)
    protected Object juvenileAugmentationPoint;

    /**
     * Gets the value of the roleOfPerson property.
     * 
     * @return
     *     possible object is
     *     {@link PersonType }
     *     
     */
    public PersonType getRoleOfPerson() {
        return roleOfPerson;
    }

    /**
     * Sets the value of the roleOfPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonType }
     *     
     */
    public void setRoleOfPerson(PersonType value) {
        this.roleOfPerson = value;
    }

    /**
     * Gets the value of the juvenileAugmentationPoint property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getJuvenileAugmentationPoint() {
        return juvenileAugmentationPoint;
    }

    /**
     * Sets the value of the juvenileAugmentationPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setJuvenileAugmentationPoint(Object value) {
        this.juvenileAugmentationPoint = value;
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
