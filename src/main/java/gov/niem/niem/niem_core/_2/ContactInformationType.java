
package gov.niem.niem.niem_core._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ContactInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContactInformationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ContactMeans" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ContactEntity" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ContactEntityDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ContactInformationDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ContactResponder" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactInformationType", propOrder = {
    "contactMeans",
    "contactEntity",
    "contactEntityDescriptionText",
    "contactInformationDescriptionText",
    "contactResponder"
})
public class ContactInformationType
    extends ComplexObjectType
{

    @XmlElementRef(name = "ContactMeans", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> contactMeans;
    @XmlElement(name = "ContactEntity", nillable = true)
    protected EntityType contactEntity;
    @XmlElement(name = "ContactEntityDescriptionText", nillable = true)
    protected TextType contactEntityDescriptionText;
    @XmlElement(name = "ContactInformationDescriptionText", nillable = true)
    protected TextType contactInformationDescriptionText;
    @XmlElement(name = "ContactResponder", nillable = true)
    protected PersonType contactResponder;

    /**
     * Gets the value of the contactMeans property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactMeans property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactMeans().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link AddressType }{@code >}
     * {@link JAXBElement }{@code <}{@link TelephoneNumberType }{@code >}
     * {@link JAXBElement }{@code <}{@link TelephoneNumberType }{@code >}
     * {@link JAXBElement }{@code <}{@link gov.niem.niem.proxy.xsd._2.String }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getContactMeans() {
        if (contactMeans == null) {
            contactMeans = new ArrayList<JAXBElement<?>>();
        }
        return this.contactMeans;
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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
