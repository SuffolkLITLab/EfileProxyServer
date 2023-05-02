
package gov.niem.niem.niem_core._2;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.nonauthoritative_code._2.FamilyKinshipCodeType;
import gov.niem.niem.structures._2.ReferenceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ImmediateFamilyAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImmediateFamilyAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonParentReference"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonChildReference"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}FamilyKinshipCategory" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImmediateFamilyAssociationType", propOrder = {
    "personParentReference",
    "personChildReference",
    "familyKinshipCategory"
})
public class ImmediateFamilyAssociationType
    extends AssociationType
{

    @XmlElement(name = "PersonParentReference", required = true)
    protected ReferenceType personParentReference;
    @XmlElement(name = "PersonChildReference", required = true)
    protected ReferenceType personChildReference;
    @XmlElementRef(name = "FamilyKinshipCategory", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> familyKinshipCategory;

    /**
     * Gets the value of the personParentReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getPersonParentReference() {
        return personParentReference;
    }

    /**
     * Sets the value of the personParentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setPersonParentReference(ReferenceType value) {
        this.personParentReference = value;
    }

    /**
     * Gets the value of the personChildReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getPersonChildReference() {
        return personChildReference;
    }

    /**
     * Sets the value of the personChildReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setPersonChildReference(ReferenceType value) {
        this.personChildReference = value;
    }

    /**
     * Gets the value of the familyKinshipCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FamilyKinshipCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getFamilyKinshipCategory() {
        return familyKinshipCategory;
    }

    /**
     * Sets the value of the familyKinshipCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FamilyKinshipCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setFamilyKinshipCategory(JAXBElement<?> value) {
        this.familyKinshipCategory = value;
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
