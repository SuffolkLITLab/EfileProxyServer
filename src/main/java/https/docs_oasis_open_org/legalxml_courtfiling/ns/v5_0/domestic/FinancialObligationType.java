
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.domestic;

import gov.niem.release.niem.niem_core._4.AmountType;
import gov.niem.release.niem.niem_core._4.ObligationType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
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
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}ObligationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic}IncomeAttachedIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic}ObligationPaymentAmount"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/humanServices/4.1/}StateDisbursementIndicator" minOccurs="0"/&gt;
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
@XmlType(name = "FinancialObligationType", propOrder = {
    "incomeAttachedIndicator",
    "obligationPaymentAmount",
    "stateDisbursementIndicator"
})
public class FinancialObligationType
    extends ObligationType
{

    @XmlElement(name = "IncomeAttachedIndicator")
    protected Boolean incomeAttachedIndicator;
    @XmlElement(name = "ObligationPaymentAmount", required = true)
    protected AmountType obligationPaymentAmount;
    @XmlElement(name = "StateDisbursementIndicator", namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/")
    protected Boolean stateDisbursementIndicator;

    /**
     * Gets the value of the incomeAttachedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIncomeAttachedIndicator() {
        return incomeAttachedIndicator;
    }

    /**
     * Sets the value of the incomeAttachedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncomeAttachedIndicator(Boolean value) {
        this.incomeAttachedIndicator = value;
    }

    /**
     * Gets the value of the obligationPaymentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getObligationPaymentAmount() {
        return obligationPaymentAmount;
    }

    /**
     * Sets the value of the obligationPaymentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setObligationPaymentAmount(AmountType value) {
        this.obligationPaymentAmount = value;
    }

    /**
     * Gets the value of the stateDisbursementIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getStateDisbursementIndicator() {
        return stateDisbursementIndicator;
    }

    /**
     * Sets the value of the stateDisbursementIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStateDisbursementIndicator(Boolean value) {
        this.stateDisbursementIndicator = value;
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
