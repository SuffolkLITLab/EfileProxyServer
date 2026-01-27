
package ecf4.latest.gov.niem.release.niem.niem_core._4;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.release.niem.domains.jxdm._6.CourtType;
import ecf4.latest.gov.niem.release.niem.domains.jxdm._6.EnforcementUnitType;
import ecf4.latest.gov.niem.release.niem.structures._4.ObjectType;
import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.OrganizationAugmentationType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a body of people organized for a particular purpose.
 * 
 * <p>Java class for OrganizationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}OrganizationIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}OrganizationLocation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}OrganizationName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}OrganizationPrimaryContactInformation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}OrganizationSubUnitName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}OrganizationTaxIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}OrganizationUnitName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}OrganizationAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "OrganizationType", propOrder = {
    "organizationIdentification",
    "organizationLocation",
    "organizationName",
    "organizationPrimaryContactInformation",
    "organizationSubUnitName",
    "organizationTaxIdentification",
    "organizationUnitName",
    "organizationAugmentationPoint"
})
@XmlSeeAlso({
    CourtType.class,
    EnforcementUnitType.class
})
public class OrganizationType
    extends ObjectType
{

    @XmlElement(name = "OrganizationIdentification")
    protected IdentificationType organizationIdentification;
    @XmlElement(name = "OrganizationLocation", nillable = true)
    protected LocationType organizationLocation;
    @XmlElement(name = "OrganizationName")
    protected TextType organizationName;
    @XmlElement(name = "OrganizationPrimaryContactInformation", nillable = true)
    protected ContactInformationType organizationPrimaryContactInformation;
    @XmlElement(name = "OrganizationSubUnitName")
    protected TextType organizationSubUnitName;
    @XmlElement(name = "OrganizationTaxIdentification")
    protected IdentificationType organizationTaxIdentification;
    @XmlElement(name = "OrganizationUnitName")
    protected TextType organizationUnitName;
    @XmlElementRef(name = "OrganizationAugmentationPoint", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> organizationAugmentationPoint;

    /**
     * Gets the value of the organizationIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getOrganizationIdentification() {
        return organizationIdentification;
    }

    /**
     * Sets the value of the organizationIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setOrganizationIdentification(IdentificationType value) {
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
     * Gets the value of the organizationAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the organizationAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganizationAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link OrganizationAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getOrganizationAugmentationPoint() {
        if (organizationAugmentationPoint == null) {
            organizationAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.organizationAugmentationPoint;
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
