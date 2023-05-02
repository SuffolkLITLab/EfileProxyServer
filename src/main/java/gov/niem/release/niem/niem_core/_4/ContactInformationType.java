
package gov.niem.release.niem.niem_core._4;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for how to contact a person or an organization.
 * 
 * <p>Java class for ContactInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContactInformationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ContactMeansAbstract" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ContactEntity" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ContactEntityDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ContactInformationDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ContactResponder" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ContactInformationAvailabilityAbstract" minOccurs="0"/&gt;
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
@XmlType(name = "ContactInformationType", propOrder = {
    "contactMeansAbstract",
    "contactEntity",
    "contactEntityDescriptionText",
    "contactInformationDescriptionText",
    "contactResponder",
    "contactInformationAvailabilityAbstract"
})
public class ContactInformationType
    extends ObjectType
{

    @XmlElementRef(name = "ContactMeansAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> contactMeansAbstract;
    @XmlElement(name = "ContactEntity")
    protected EntityType contactEntity;
    @XmlElement(name = "ContactEntityDescriptionText")
    protected TextType contactEntityDescriptionText;
    @XmlElement(name = "ContactInformationDescriptionText")
    protected TextType contactInformationDescriptionText;
    @XmlElement(name = "ContactResponder", nillable = true)
    protected PersonType contactResponder;
    @XmlElementRef(name = "ContactInformationAvailabilityAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> contactInformationAvailabilityAbstract;

    /**
     * Gets the value of the contactMeansAbstract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the contactMeansAbstract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactMeansAbstract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link AddressType }{@code >}
     * {@link JAXBElement }{@code <}{@link TelephoneNumberType }{@code >}
     * {@link JAXBElement }{@code <}{@link gov.niem.release.niem.proxy.xsd._4.String }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getContactMeansAbstract() {
        if (contactMeansAbstract == null) {
            contactMeansAbstract = new ArrayList<JAXBElement<?>>();
        }
        return this.contactMeansAbstract;
    }

    /**
     * Gets the value of the contactEntity property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getContactEntity() {
        return contactEntity;
    }

    /**
     * Sets the value of the contactEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setContactEntity(EntityType value) {
        this.contactEntity = value;
    }

    /**
     * Gets the value of the contactEntityDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getContactEntityDescriptionText() {
        return contactEntityDescriptionText;
    }

    /**
     * Sets the value of the contactEntityDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setContactEntityDescriptionText(TextType value) {
        this.contactEntityDescriptionText = value;
    }

    /**
     * Gets the value of the contactInformationDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getContactInformationDescriptionText() {
        return contactInformationDescriptionText;
    }

    /**
     * Sets the value of the contactInformationDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setContactInformationDescriptionText(TextType value) {
        this.contactInformationDescriptionText = value;
    }

    /**
     * Gets the value of the contactResponder property.
     * 
     * @return
     *     possible object is
     *     {@link PersonType }
     *     
     */
    public PersonType getContactResponder() {
        return contactResponder;
    }

    /**
     * Sets the value of the contactResponder property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonType }
     *     
     */
    public void setContactResponder(PersonType value) {
        this.contactResponder = value;
    }

    /**
     * Gets the value of the contactInformationAvailabilityAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ContactInformationAvailabilityCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getContactInformationAvailabilityAbstract() {
        return contactInformationAvailabilityAbstract;
    }

    /**
     * Sets the value of the contactInformationAvailabilityAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ContactInformationAvailabilityCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setContactInformationAvailabilityAbstract(JAXBElement<?> value) {
        this.contactInformationAvailabilityAbstract = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
