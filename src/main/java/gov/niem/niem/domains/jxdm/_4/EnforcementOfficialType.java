
package gov.niem.niem.domains.jxdm._4;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.ScheduleDayType;
import gov.niem.niem.structures._2.ComplexObjectType;
import gov.niem.niem.structures._2.ReferenceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for EnforcementOfficialType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnforcementOfficialType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}RoleOfPersonReference" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}EnforcementOfficialBadgeIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}EnforcementOfficialUnavailableSchedule" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}EnforcementOfficialUnit" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnforcementOfficialType", propOrder = {
    "roleOfPersonReference",
    "enforcementOfficialBadgeIdentification",
    "enforcementOfficialUnavailableSchedule",
    "enforcementOfficialUnit"
})
public class EnforcementOfficialType
    extends ComplexObjectType
{

    @XmlElement(name = "RoleOfPersonReference", namespace = "http://niem.gov/niem/niem-core/2.0")
    protected ReferenceType roleOfPersonReference;
    @XmlElement(name = "EnforcementOfficialBadgeIdentification", nillable = true)
    protected IdentificationType enforcementOfficialBadgeIdentification;
    @XmlElement(name = "EnforcementOfficialUnavailableSchedule", nillable = true)
    protected ScheduleDayType enforcementOfficialUnavailableSchedule;
    @XmlElement(name = "EnforcementOfficialUnit", nillable = true)
    protected EnforcementUnitType enforcementOfficialUnit;

    /**
     * Gets the value of the roleOfPersonReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getRoleOfPersonReference() {
        return roleOfPersonReference;
    }

    /**
     * Sets the value of the roleOfPersonReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setRoleOfPersonReference(ReferenceType value) {
        this.roleOfPersonReference = value;
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
