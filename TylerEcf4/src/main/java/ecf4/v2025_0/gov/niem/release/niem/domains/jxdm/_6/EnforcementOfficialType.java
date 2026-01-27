
package ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6;

import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.PersonType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.ScheduleDayType;
import ecf4.v2025_0.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a person involved in the enforcement of law.
 * 
 * <p>Java class for EnforcementOfficialType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnforcementOfficialType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}RoleOfPerson"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}EnforcementOfficialBadgeIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}EnforcementOfficialUnavailableSchedule" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}EnforcementOfficialUnit" minOccurs="0"/&gt;
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
@XmlType(name = "EnforcementOfficialType", propOrder = {
    "roleOfPerson",
    "enforcementOfficialBadgeIdentification",
    "enforcementOfficialUnavailableSchedule",
    "enforcementOfficialUnit"
})
public class EnforcementOfficialType
    extends ObjectType
{

    @XmlElement(name = "RoleOfPerson", namespace = "http://release.niem.gov/niem/niem-core/4.0/", required = true, nillable = true)
    protected PersonType roleOfPerson;
    @XmlElement(name = "EnforcementOfficialBadgeIdentification")
    protected IdentificationType enforcementOfficialBadgeIdentification;
    @XmlElement(name = "EnforcementOfficialUnavailableSchedule")
    protected ScheduleDayType enforcementOfficialUnavailableSchedule;
    @XmlElement(name = "EnforcementOfficialUnit")
    protected EnforcementUnitType enforcementOfficialUnit;

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
     * Gets the value of the enforcementOfficialBadgeIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getEnforcementOfficialBadgeIdentification() {
        return enforcementOfficialBadgeIdentification;
    }

    /**
     * Sets the value of the enforcementOfficialBadgeIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setEnforcementOfficialBadgeIdentification(IdentificationType value) {
        this.enforcementOfficialBadgeIdentification = value;
    }

    /**
     * Gets the value of the enforcementOfficialUnavailableSchedule property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleDayType }
     *     
     */
    public ScheduleDayType getEnforcementOfficialUnavailableSchedule() {
        return enforcementOfficialUnavailableSchedule;
    }

    /**
     * Sets the value of the enforcementOfficialUnavailableSchedule property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleDayType }
     *     
     */
    public void setEnforcementOfficialUnavailableSchedule(ScheduleDayType value) {
        this.enforcementOfficialUnavailableSchedule = value;
    }

    /**
     * Gets the value of the enforcementOfficialUnit property.
     * 
     * @return
     *     possible object is
     *     {@link EnforcementUnitType }
     *     
     */
    public EnforcementUnitType getEnforcementOfficialUnit() {
        return enforcementOfficialUnit;
    }

    /**
     * Sets the value of the enforcementOfficialUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnforcementUnitType }
     *     
     */
    public void setEnforcementOfficialUnit(EnforcementUnitType value) {
        this.enforcementOfficialUnit = value;
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
