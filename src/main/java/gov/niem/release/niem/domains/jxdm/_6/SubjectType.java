
package gov.niem.release.niem.domains.jxdm._6;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.PersonType;
import gov.niem.release.niem.niem_core._4.SupervisionType;
import gov.niem.release.niem.structures._4.ObjectType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.SubjectAugmentationType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a person or organization that is involved or suspected of being involved in a violation of a criminal statute, ordinance or rule.
 * 
 * <p>Java class for SubjectType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}RoleOfPerson"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}SubjectIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}SubjectSupervision" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}SubjectAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "SubjectType", propOrder = {
    "roleOfPerson",
    "subjectIdentification",
    "subjectSupervision",
    "subjectAugmentationPoint"
})
public class SubjectType
    extends ObjectType
{

    @XmlElement(name = "RoleOfPerson", namespace = "http://release.niem.gov/niem/niem-core/4.0/", required = true, nillable = true)
    protected PersonType roleOfPerson;
    @XmlElement(name = "SubjectIdentification")
    protected IdentificationType subjectIdentification;
    @XmlElement(name = "SubjectSupervision")
    protected SupervisionType subjectSupervision;
    @XmlElementRef(name = "SubjectAugmentationPoint", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> subjectAugmentationPoint;

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
     * Gets the value of the subjectAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the subjectAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubjectAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link SubjectAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getSubjectAugmentationPoint() {
        if (subjectAugmentationPoint == null) {
            subjectAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.subjectAugmentationPoint;
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
