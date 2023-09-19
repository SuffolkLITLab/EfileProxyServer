
package gov.niem.niem.niem_core._2;

import gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for PersonNameType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonNameType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonNamePrefixText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonGivenName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonMiddleName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonSurName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonNameSuffixText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonMaidenName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonFullName" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://niem.gov/niem/niem-core/2.0}personNameCommentText"/&gt;
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
    "personFullName"
})
public class PersonNameType
    extends ComplexObjectType
{

    @XmlElement(name = "PersonNamePrefixText", nillable = true)
    protected TextType personNamePrefixText;
    @XmlElement(name = "PersonGivenName", nillable = true)
    protected PersonNameTextType personGivenName;
    @XmlElement(name = "PersonMiddleName", nillable = true)
    protected PersonNameTextType personMiddleName;
    @XmlElement(name = "PersonSurName", nillable = true)
    protected PersonNameTextType personSurName;
    @XmlElement(name = "PersonNameSuffixText", nillable = true)
    protected TextType personNameSuffixText;
    @XmlElement(name = "PersonMaidenName", nillable = true)
    protected PersonNameTextType personMaidenName;
    @XmlElement(name = "PersonFullName", nillable = true)
    protected PersonNameTextType personFullName;
    @XmlAttribute(name = "personNameCommentText", namespace = "http://niem.gov/niem/niem-core/2.0")
    protected String personNameCommentText;

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
     * Gets the value of the personNameCommentText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonNameCommentText() {
        return personNameCommentText;
    }

    /**
     * Sets the value of the personNameCommentText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonNameCommentText(String value) {
        this.personNameCommentText = value;
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
