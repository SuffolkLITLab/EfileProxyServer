
package gov.niem.niem.niem_core._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ComplexObjectType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.FinancialObligationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ObligationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObligationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ObligationDue" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ObligationExemption" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ObligationRequirementDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ObligationCategoryText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ObligationEntity"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ObligationRecipient" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ObligationRecurrence" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObligationType", propOrder = {
    "obligationDue",
    "obligationExemption",
    "obligationRequirementDescriptionText",
    "obligationCategoryText",
    "obligationEntity",
    "obligationRecipient",
    "obligationRecurrence"
})
@XmlSeeAlso({
    FinancialObligationType.class,
    ObligationRecurrenceType.class
})
public class ObligationType
    extends ComplexObjectType
{

    @XmlElementRef(name = "ObligationDue", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> obligationDue;
    @XmlElement(name = "ObligationExemption", nillable = true)
    protected ObligationExemptionType obligationExemption;
    @XmlElement(name = "ObligationRequirementDescriptionText", nillable = true)
    protected TextType obligationRequirementDescriptionText;
    @XmlElement(name = "ObligationCategoryText", nillable = true)
    protected TextType obligationCategoryText;
    @XmlElement(name = "ObligationEntity", required = true, nillable = true)
    protected EntityType obligationEntity;
    @XmlElement(name = "ObligationRecipient", nillable = true)
    protected EntityType obligationRecipient;
    @XmlElement(name = "ObligationRecurrence", nillable = true)
    protected ObligationRecurrenceType obligationRecurrence;

    /**
     * Gets the value of the obligationDue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getObligationDue() {
        return obligationDue;
    }

    /**
     * Sets the value of the obligationDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setObligationDue(JAXBElement<?> value) {
        this.obligationDue = value;
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
