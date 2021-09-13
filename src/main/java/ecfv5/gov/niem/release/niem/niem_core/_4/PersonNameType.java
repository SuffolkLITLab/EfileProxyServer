
package ecfv5.gov.niem.release.niem.niem_core._4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.PersonNameCategoryCodeType;
import ecfv5.gov.niem.release.niem.structures._4.ObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a combination of names and/or titles by which a person is known.
 * 
 * <p>Java class for PersonNameType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonNameType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonNamePrefixText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonGivenName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonMiddleName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonSurName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonNameSuffixText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonMaidenName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonFullName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonNameCategoryAbstract" minOccurs="0"/&gt;
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
@XmlType(name = "PersonNameType", propOrder = {
    "personNamePrefixText",
    "personGivenName",
    "personMiddleName",
    "personSurName",
    "personNameSuffixText",
    "personMaidenName",
    "personFullName",
    "personNameCategoryAbstract"
})
public class PersonNameType
    extends ObjectType
{

    @XmlElement(name = "PersonNamePrefixText")
    protected TextType personNamePrefixText;
    @XmlElement(name = "PersonGivenName")
    protected PersonNameTextType personGivenName;
    @XmlElement(name = "PersonMiddleName")
    protected PersonNameTextType personMiddleName;
    @XmlElement(name = "PersonSurName")
    protected PersonNameTextType personSurName;
    @XmlElement(name = "PersonNameSuffixText")
    protected TextType personNameSuffixText;
    @XmlElement(name = "PersonMaidenName")
    protected PersonNameTextType personMaidenName;
    @XmlElement(name = "PersonFullName")
    protected PersonNameTextType personFullName;
    @XmlElementRef(name = "PersonNameCategoryAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personNameCategoryAbstract;

    /**
     * Gets the value of the personNamePrefixText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getPersonNamePrefixText() {
        return personNamePrefixText;
    }

    /**
     * Sets the value of the personNamePrefixText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setPersonNamePrefixText(TextType value) {
        this.personNamePrefixText = value;
    }

    /**
     * Gets the value of the personGivenName property.
     * 
     * @return
     *     possible object is
     *     {@link PersonNameTextType }
     *     
     */
    public PersonNameTextType getPersonGivenName() {
        return personGivenName;
    }

    /**
     * Sets the value of the personGivenName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonNameTextType }
     *     
     */
    public void setPersonGivenName(PersonNameTextType value) {
        this.personGivenName = value;
    }

    /**
     * Gets the value of the personMiddleName property.
     * 
     * @return
     *     possible object is
     *     {@link PersonNameTextType }
     *     
     */
    public PersonNameTextType getPersonMiddleName() {
        return personMiddleName;
    }

    /**
     * Sets the value of the personMiddleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonNameTextType }
     *     
     */
    public void setPersonMiddleName(PersonNameTextType value) {
        this.personMiddleName = value;
    }

    /**
     * Gets the value of the personSurName property.
     * 
     * @return
     *     possible object is
     *     {@link PersonNameTextType }
     *     
     */
    public PersonNameTextType getPersonSurName() {
        return personSurName;
    }

    /**
     * Sets the value of the personSurName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonNameTextType }
     *     
     */
    public void setPersonSurName(PersonNameTextType value) {
        this.personSurName = value;
    }

    /**
     * Gets the value of the personNameSuffixText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getPersonNameSuffixText() {
        return personNameSuffixText;
    }

    /**
     * Sets the value of the personNameSuffixText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setPersonNameSuffixText(TextType value) {
        this.personNameSuffixText = value;
    }

    /**
     * Gets the value of the personMaidenName property.
     * 
     * @return
     *     possible object is
     *     {@link PersonNameTextType }
     *     
     */
    public PersonNameTextType getPersonMaidenName() {
        return personMaidenName;
    }

    /**
     * Sets the value of the personMaidenName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonNameTextType }
     *     
     */
    public void setPersonMaidenName(PersonNameTextType value) {
        this.personMaidenName = value;
    }

    /**
     * Gets the value of the personFullName property.
     * 
     * @return
     *     possible object is
     *     {@link PersonNameTextType }
     *     
     */
    public PersonNameTextType getPersonFullName() {
        return personFullName;
    }

    /**
     * Sets the value of the personFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonNameTextType }
     *     
     */
    public void setPersonFullName(PersonNameTextType value) {
        this.personFullName = value;
    }

    /**
     * Gets the value of the personNameCategoryAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PersonNameCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonNameCategoryAbstract() {
        return personNameCategoryAbstract;
    }

    /**
     * Sets the value of the personNameCategoryAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PersonNameCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonNameCategoryAbstract(JAXBElement<?> value) {
        this.personNameCategoryAbstract = value;
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
