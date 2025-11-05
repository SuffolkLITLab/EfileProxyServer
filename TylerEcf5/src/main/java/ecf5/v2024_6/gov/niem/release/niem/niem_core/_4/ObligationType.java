
package gov.niem.release.niem.niem_core._4;

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
 * A data type for something that is owed to an entity.
 * 
 * <p>Java class for ObligationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObligationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ObligationDueAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ObligationExemption" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ObligationRequirementDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ObligationCategoryText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ObligationEntity"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ObligationRecipient" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ObligationRecurrence" minOccurs="0"/&gt;
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
@XmlType(name = "ObligationType", propOrder = {
    "obligationDueAbstract",
    "obligationExemption",
    "obligationRequirementDescriptionText",
    "obligationCategoryText",
    "obligationEntity",
    "obligationRecipient",
    "obligationRecurrence"
})
public class ObligationType
    extends ObjectType
{

    @XmlElementRef(name = "ObligationDueAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> obligationDueAbstract;
    @XmlElement(name = "ObligationExemption")
    protected ObligationExemptionType obligationExemption;
    @XmlElement(name = "ObligationRequirementDescriptionText")
    protected TextType obligationRequirementDescriptionText;
    @XmlElement(name = "ObligationCategoryText")
    protected TextType obligationCategoryText;
    @XmlElement(name = "ObligationEntity", required = true)
    protected EntityType obligationEntity;
    @XmlElement(name = "ObligationRecipient")
    protected EntityType obligationRecipient;
    @XmlElement(name = "ObligationRecurrence")
    protected ObligationRecurrenceType obligationRecurrence;

    /**
     * Gets the value of the obligationDueAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getObligationDueAbstract() {
        return obligationDueAbstract;
    }

    /**
     * Sets the value of the obligationDueAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setObligationDueAbstract(JAXBElement<?> value) {
        this.obligationDueAbstract = value;
    }

    /**
     * Gets the value of the obligationExemption property.
     * 
     * @return
     *     possible object is
     *     {@link ObligationExemptionType }
     *     
     */
    public ObligationExemptionType getObligationExemption() {
        return obligationExemption;
    }

    /**
     * Sets the value of the obligationExemption property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObligationExemptionType }
     *     
     */
    public void setObligationExemption(ObligationExemptionType value) {
        this.obligationExemption = value;
    }

    /**
     * Gets the value of the obligationRequirementDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getObligationRequirementDescriptionText() {
        return obligationRequirementDescriptionText;
    }

    /**
     * Sets the value of the obligationRequirementDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setObligationRequirementDescriptionText(TextType value) {
        this.obligationRequirementDescriptionText = value;
    }

    /**
     * Gets the value of the obligationCategoryText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getObligationCategoryText() {
        return obligationCategoryText;
    }

    /**
     * Sets the value of the obligationCategoryText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setObligationCategoryText(TextType value) {
        this.obligationCategoryText = value;
    }

    /**
     * Gets the value of the obligationEntity property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getObligationEntity() {
        return obligationEntity;
    }

    /**
     * Sets the value of the obligationEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setObligationEntity(EntityType value) {
        this.obligationEntity = value;
    }

    /**
     * Gets the value of the obligationRecipient property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getObligationRecipient() {
        return obligationRecipient;
    }

    /**
     * Sets the value of the obligationRecipient property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setObligationRecipient(EntityType value) {
        this.obligationRecipient = value;
    }

    /**
     * Gets the value of the obligationRecurrence property.
     * 
     * @return
     *     possible object is
     *     {@link ObligationRecurrenceType }
     *     
     */
    public ObligationRecurrenceType getObligationRecurrence() {
        return obligationRecurrence;
    }

    /**
     * Sets the value of the obligationRecurrence property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObligationRecurrenceType }
     *     
     */
    public void setObligationRecurrence(ObligationRecurrenceType value) {
        this.obligationRecurrence = value;
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
