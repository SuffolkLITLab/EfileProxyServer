
package gov.niem.niem.niem_core._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.domains.jxdm._4.CourtType;
import gov.niem.niem.domains.jxdm._4.EnforcementUnitType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.extensions.common.OrganizationIdentificationType;


/**
 * <p>Java class for OrganizationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}OrganizationIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}OrganizationLocation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}OrganizationName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}OrganizationPrimaryContactInformation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}OrganizationSubUnitName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}OrganizationTaxIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}OrganizationUnitName" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationType", propOrder = {
    "organizationIdentification",
    "organizationLocation",
    "organizationName",
    "organizationPrimaryContactInformation",
    "organizationSubUnitName",
    "organizationTaxIdentification",
    "organizationUnitName"
})
@XmlSeeAlso({
    CourtType.class,
    EnforcementUnitType.class,
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType.class
})
public class OrganizationType
    extends ComplexObjectType
{

    @XmlElementRef(name = "OrganizationIdentification", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends IdentificationType> organizationIdentification;
    @XmlElement(name = "OrganizationLocation", nillable = true)
    protected LocationType organizationLocation;
    @XmlElement(name = "OrganizationName", nillable = true)
    protected TextType organizationName;
    @XmlElement(name = "OrganizationPrimaryContactInformation", nillable = true)
    protected ContactInformationType organizationPrimaryContactInformation;
    @XmlElement(name = "OrganizationSubUnitName", nillable = true)
    protected TextType organizationSubUnitName;
    @XmlElement(name = "OrganizationTaxIdentification", nillable = true)
    protected IdentificationType organizationTaxIdentification;
    @XmlElement(name = "OrganizationUnitName", nillable = true)
    protected TextType organizationUnitName;

    /**
     * Gets the value of the organizationIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OrganizationIdentificationType }{@code >}
     *     
     */
    public JAXBElement<? extends IdentificationType> getOrganizationIdentification() {
        return organizationIdentification;
    }

    /**
     * Sets the value of the organizationIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OrganizationIdentificationType }{@code >}
     *     
     */
    public void setOrganizationIdentification(JAXBElement<? extends IdentificationType> value) {
        this.organizationIdentification = value;
    }

    /**
     * Gets the value of the organizationLocation property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getOrganizationLocation() {
        return organizationLocation;
    }

    /**
     * Sets the value of the organizationLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setOrganizationLocation(LocationType value) {
        this.organizationLocation = value;
    }

    /**
     * Gets the value of the organizationName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getOrganizationName() {
        return organizationName;
    }

    /**
     * Sets the value of the organizationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setOrganizationName(TextType value) {
        this.organizationName = value;
    }

    /**
     * Gets the value of the organizationPrimaryContactInformation property.
     * 
     * @return
     *     possible object is
     *     {@link ContactInformationType }
     *     
     */
    public ContactInformationType getOrganizationPrimaryContactInformation() {
        return organizationPrimaryContactInformation;
    }

    /**
     * Sets the value of the organizationPrimaryContactInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactInformationType }
     *     
     */
    public void setOrganizationPrimaryContactInformation(ContactInformationType value) {
        this.organizationPrimaryContactInformation = value;
    }

    /**
     * Gets the value of the organizationSubUnitName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getOrganizationSubUnitName() {
        return organizationSubUnitName;
    }

    /**
     * Sets the value of the organizationSubUnitName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setOrganizationSubUnitName(TextType value) {
        this.organizationSubUnitName = value;
    }

    /**
     * Gets the value of the organizationTaxIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getOrganizationTaxIdentification() {
        return organizationTaxIdentification;
    }

    /**
     * Sets the value of the organizationTaxIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setOrganizationTaxIdentification(IdentificationType value) {
        this.organizationTaxIdentification = value;
    }

    /**
     * Gets the value of the organizationUnitName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getOrganizationUnitName() {
        return organizationUnitName;
    }

    /**
     * Sets the value of the organizationUnitName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setOrganizationUnitName(TextType value) {
        this.organizationUnitName = value;
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
