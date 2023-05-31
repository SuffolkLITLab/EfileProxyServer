
package tyler.ecf.v5_0.extensions.common;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.AmountType;
import gov.niem.release.niem.niem_core._4.CaseType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.NonNegativeDecimalType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for EnvelopeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnvelopeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BatchSequence"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}EnvelopeIdentification"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}Filing" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}Case" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}TotalFees" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnvelopeType", propOrder = {
    "batchSequence",
    "envelopeIdentification",
    "filing",
    "_case",
    "totalFees"
})
public class EnvelopeType {

    @XmlElement(name = "BatchSequence", required = true)
    protected NonNegativeDecimalType batchSequence;
    @XmlElement(name = "EnvelopeIdentification", required = true)
    protected IdentificationType envelopeIdentification;
    @XmlElement(name = "Filing")
    protected List<FilingType> filing;
    @XmlElement(name = "Case", namespace = "http://release.niem.gov/niem/niem-core/4.0/", nillable = true)
    protected CaseType _case;
    @XmlElement(name = "TotalFees")
    protected AmountType totalFees;

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
     * Gets the value of the envelopeIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getEnvelopeIdentification() {
        return envelopeIdentification;
    }

    /**
     * Sets the value of the envelopeIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setEnvelopeIdentification(IdentificationType value) {
        this.envelopeIdentification = value;
    }

    /**
     * Gets the value of the filing property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the filing property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFiling().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FilingType }
     * 
     * 
     */
    public List<FilingType> getFiling() {
        if (filing == null) {
            filing = new ArrayList<FilingType>();
        }
        return this.filing;
    }

    /**
     * Gets the value of the case property.
     * 
     * @return
     *     possible object is
     *     {@link CaseType }
     *     
     */
    public CaseType getCase() {
        return _case;
    }

    /**
     * Sets the value of the case property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaseType }
     *     
     */
    public void setCase(CaseType value) {
        this._case = value;
    }

    /**
     * Gets the value of the totalFees property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getTotalFees() {
        return totalFees;
    }

    /**
     * Sets the value of the totalFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setTotalFees(AmountType value) {
        this.totalFees = value;
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
