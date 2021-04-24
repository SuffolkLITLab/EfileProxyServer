
package oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.AmountType;
import gov.niem.niem.niem_core._2.ObligationType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A financial responsibility of a party in a case ordered by a court.
 * 
 * &lt;p&gt;Java class for FinancialObligationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FinancialObligationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}ObligationType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}ObligationPaymentAmount" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}ObligationIncomeAttachedIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}ObligationStateDisbursementIndicator" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the obligationPaymentAmount property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getObligationPaymentAmount().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
