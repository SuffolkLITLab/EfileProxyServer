
package gov.niem.niem.niem_core._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseObligationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ObligationRecurrenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObligationRecurrenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}ObligationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ObligationEndDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ObligationPeriodText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ObligationStartDate" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObligationRecurrenceType", propOrder = {
    "obligationEndDate",
    "obligationPeriodText",
    "obligationStartDate"
})
@XmlSeeAlso({
    DomesticCaseObligationType.class
})
public class ObligationRecurrenceType
    extends ObligationType
{

    @XmlElement(name = "ObligationEndDate", nillable = true)
    protected DateType obligationEndDate;
    @XmlElement(name = "ObligationPeriodText", nillable = true)
    protected TextType obligationPeriodText;
    @XmlElement(name = "ObligationStartDate", nillable = true)
    protected DateType obligationStartDate;

    /**
     * Gets the value of the obligationEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getObligationEndDate() {
        return obligationEndDate;
    }

    /**
     * Sets the value of the obligationEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setObligationEndDate(DateType value) {
        this.obligationEndDate = value;
    }

    /**
     * Gets the value of the obligationPeriodText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getObligationPeriodText() {
        return obligationPeriodText;
    }

    /**
     * Sets the value of the obligationPeriodText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setObligationPeriodText(TextType value) {
        this.obligationPeriodText = value;
    }

    /**
     * Gets the value of the obligationStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getObligationStartDate() {
        return obligationStartDate;
    }

    /**
     * Sets the value of the obligationStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setObligationStartDate(DateType value) {
        this.obligationStartDate = value;
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
