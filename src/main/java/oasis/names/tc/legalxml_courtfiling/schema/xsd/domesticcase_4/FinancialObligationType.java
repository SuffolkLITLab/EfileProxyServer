
package oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.AmountType;
import gov.niem.niem.niem_core._2.ObligationType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A financial responsibility of a party in a case ordered by a court.
 * 
 * <p>Java class for FinancialObligationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FinancialObligationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}ObligationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}ObligationPaymentAmount" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}ObligationIncomeAttachedIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}ObligationStateDisbursementIndicator" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialObligationType", propOrder = {
    "obligationPaymentAmount",
    "obligationIncomeAttachedIndicator",
    "obligationStateDisbursementIndicator"
})
public class FinancialObligationType
    extends ObligationType
{

    @XmlElement(name = "ObligationPaymentAmount")
    protected List<AmountType> obligationPaymentAmount;
    @XmlElement(name = "ObligationIncomeAttachedIndicator")
    protected Boolean obligationIncomeAttachedIndicator;
    @XmlElement(name = "ObligationStateDisbursementIndicator")
    protected Boolean obligationStateDisbursementIndicator;

    /**
     * Gets the value of the obligationPaymentAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the obligationPaymentAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObligationPaymentAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getObligationPaymentAmount() {
        if (obligationPaymentAmount == null) {
            obligationPaymentAmount = new ArrayList<AmountType>();
        }
        return this.obligationPaymentAmount;
    }

    /**
     * Gets the value of the obligationIncomeAttachedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getObligationIncomeAttachedIndicator() {
        return obligationIncomeAttachedIndicator;
    }

    /**
     * Sets the value of the obligationIncomeAttachedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setObligationIncomeAttachedIndicator(Boolean value) {
        this.obligationIncomeAttachedIndicator = value;
    }

    /**
     * Gets the value of the obligationStateDisbursementIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getObligationStateDisbursementIndicator() {
        return obligationStateDisbursementIndicator;
    }

    /**
     * Sets the value of the obligationStateDisbursementIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setObligationStateDisbursementIndicator(Boolean value) {
        this.obligationStateDisbursementIndicator = value;
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
