
package tyler.ecf.v5_0.extensions.common;

import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.NonNegativeDecimalType;
import gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for BatchTypeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchTypeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BatchIdentification"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BatchName" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BatchSize"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BatchSequence"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BatchType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchTypeType", propOrder = {
    "batchIdentification",
    "batchName",
    "batchSize",
    "batchSequence",
    "batchType"
})
public class BatchTypeType {

    @XmlElement(name = "BatchIdentification", required = true)
    protected IdentificationType batchIdentification;
    @XmlElement(name = "BatchName")
    protected TextType batchName;
    @XmlElement(name = "BatchSize", required = true)
    protected NonNegativeDecimalType batchSize;
    @XmlElement(name = "BatchSequence", required = true)
    protected NonNegativeDecimalType batchSequence;
    @XmlElement(name = "BatchType")
    protected TextType batchType;

    /**
     * Gets the value of the batchIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getBatchIdentification() {
        return batchIdentification;
    }

    /**
     * Sets the value of the batchIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setBatchIdentification(IdentificationType value) {
        this.batchIdentification = value;
    }

    /**
     * Gets the value of the batchName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getBatchName() {
        return batchName;
    }

    /**
     * Sets the value of the batchName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setBatchName(TextType value) {
        this.batchName = value;
    }

    /**
     * Gets the value of the batchSize property.
     * 
     * @return
     *     possible object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public NonNegativeDecimalType getBatchSize() {
        return batchSize;
    }

    /**
     * Sets the value of the batchSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public void setBatchSize(NonNegativeDecimalType value) {
        this.batchSize = value;
    }

    /**
     * Gets the value of the batchSequence property.
     * 
     * @return
     *     possible object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public NonNegativeDecimalType getBatchSequence() {
        return batchSequence;
    }

    /**
     * Sets the value of the batchSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public void setBatchSequence(NonNegativeDecimalType value) {
        this.batchSequence = value;
    }

    /**
     * Gets the value of the batchType property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getBatchType() {
        return batchType;
    }

    /**
     * Sets the value of the batchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setBatchType(TextType value) {
        this.batchType = value;
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
