
package tyler.ecf.v5_0.extensions.common;

import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.PersonType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for FilingAttorneyEntityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilingAttorneyEntityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}RoleOfPerson" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}AttorneyReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}AttorneyIdentification" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilingAttorneyEntityType", propOrder = {
    "roleOfPerson",
    "attorneyReference",
    "attorneyIdentification"
})
public class FilingAttorneyEntityType {

    @XmlElement(name = "RoleOfPerson", namespace = "http://release.niem.gov/niem/niem-core/4.0/", nillable = true)
    protected PersonType roleOfPerson;
    @XmlElement(name = "AttorneyReference")
    protected ReferenceType attorneyReference;
    @XmlElement(name = "AttorneyIdentification")
    protected IdentificationType attorneyIdentification;

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
     * Gets the value of the attorneyReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getAttorneyReference() {
        return attorneyReference;
    }

    /**
     * Sets the value of the attorneyReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setAttorneyReference(ReferenceType value) {
        this.attorneyReference = value;
    }

    /**
     * Gets the value of the attorneyIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getAttorneyIdentification() {
        return attorneyIdentification;
    }

    /**
     * Sets the value of the attorneyIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setAttorneyIdentification(IdentificationType value) {
        this.attorneyIdentification = value;
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
