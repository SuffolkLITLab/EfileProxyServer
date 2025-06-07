
package ecf4.latest.gov.niem.niem.domains.jxdm._4;

import ecf4.latest.gov.niem.niem.niem_core._2.IdentificationType;
import ecf4.latest.gov.niem.niem.niem_core._2.SupervisionType;
import ecf4.latest.gov.niem.niem.structures._2.ComplexObjectType;
import ecf4.latest.gov.niem.niem.structures._2.ReferenceType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for SubjectType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}RoleOfPersonReference" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}SubjectIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}SubjectSupervision" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubjectType", propOrder = {
    "roleOfPersonReference",
    "subjectIdentification",
    "subjectSupervision"
})
@XmlSeeAlso({
   ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.SubjectType.class,
   ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.SubjectType.class
})
public class SubjectType
    extends ComplexObjectType
{

    @XmlElement(name = "RoleOfPersonReference", namespace = "http://niem.gov/niem/niem-core/2.0")
    protected ReferenceType roleOfPersonReference;
    @XmlElement(name = "SubjectIdentification", nillable = true)
    protected IdentificationType subjectIdentification;
    @XmlElement(name = "SubjectSupervision", nillable = true)
    protected SupervisionType subjectSupervision;

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
     * Gets the value of the subjectIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getSubjectIdentification() {
        return subjectIdentification;
    }

    /**
     * Sets the value of the subjectIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setSubjectIdentification(IdentificationType value) {
        this.subjectIdentification = value;
    }

    /**
     * Gets the value of the subjectSupervision property.
     * 
     * @return
     *     possible object is
     *     {@link SupervisionType }
     *     
     */
    public SupervisionType getSubjectSupervision() {
        return subjectSupervision;
    }

    /**
     * Sets the value of the subjectSupervision property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupervisionType }
     *     
     */
    public void setSubjectSupervision(SupervisionType value) {
        this.subjectSupervision = value;
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
