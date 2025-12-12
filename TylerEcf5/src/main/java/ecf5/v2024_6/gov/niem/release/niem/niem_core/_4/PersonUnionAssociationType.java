
package ecf5.v2024_6.gov.niem.release.niem.niem_core._4;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for an association between two persons who are in a state of union with each other.
 * 
 * <p>Java class for PersonUnionAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonUnionAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}PersonAssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonDisunion" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonUnionLocation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonUnionSeparation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonUnionCategoryAbstract" minOccurs="0"/&gt;
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
@XmlType(name = "PersonUnionAssociationType", propOrder = {
    "personDisunion",
    "personUnionLocation",
    "personUnionSeparation",
    "personUnionCategoryAbstract"
})
public class PersonUnionAssociationType
    extends PersonAssociationType
{

    @XmlElement(name = "PersonDisunion")
    protected PersonDisunionType personDisunion;
    @XmlElement(name = "PersonUnionLocation", nillable = true)
    protected LocationType personUnionLocation;
    @XmlElement(name = "PersonUnionSeparation")
    protected PersonUnionSeparationType personUnionSeparation;
    @XmlElementRef(name = "PersonUnionCategoryAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personUnionCategoryAbstract;

    /**
     * Gets the value of the personDisunion property.
     * 
     * @return
     *     possible object is
     *     {@link PersonDisunionType }
     *     
     */
    public PersonDisunionType getPersonDisunion() {
        return personDisunion;
    }

    /**
     * Sets the value of the personDisunion property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonDisunionType }
     *     
     */
    public void setPersonDisunion(PersonDisunionType value) {
        this.personDisunion = value;
    }

    /**
     * Gets the value of the personUnionLocation property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getPersonUnionLocation() {
        return personUnionLocation;
    }

    /**
     * Sets the value of the personUnionLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setPersonUnionLocation(LocationType value) {
        this.personUnionLocation = value;
    }

    /**
     * Gets the value of the personUnionSeparation property.
     * 
     * @return
     *     possible object is
     *     {@link PersonUnionSeparationType }
     *     
     */
    public PersonUnionSeparationType getPersonUnionSeparation() {
        return personUnionSeparation;
    }

    /**
     * Sets the value of the personUnionSeparation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonUnionSeparationType }
     *     
     */
    public void setPersonUnionSeparation(PersonUnionSeparationType value) {
        this.personUnionSeparation = value;
    }

    /**
     * Gets the value of the personUnionCategoryAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PersonUnionCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonUnionCategoryAbstract() {
        return personUnionCategoryAbstract;
    }

    /**
     * Sets the value of the personUnionCategoryAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PersonUnionCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonUnionCategoryAbstract(JAXBElement<?> value) {
        this.personUnionCategoryAbstract = value;
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
