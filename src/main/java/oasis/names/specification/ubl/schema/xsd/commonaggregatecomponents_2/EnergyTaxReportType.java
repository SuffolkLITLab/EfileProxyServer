
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxEnergyAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxEnergyBalanceAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxEnergyOnAccountAmountType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for EnergyTaxReportType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="EnergyTaxReportType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxEnergyAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxEnergyOnAccountAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxEnergyBalanceAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxScheme"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnergyTaxReportType", propOrder = {
    "taxEnergyAmount",
    "taxEnergyOnAccountAmount",
    "taxEnergyBalanceAmount",
    "taxScheme"
})
public class EnergyTaxReportType {

    @XmlElement(name = "TaxEnergyAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TaxEnergyAmountType taxEnergyAmount;
    @XmlElement(name = "TaxEnergyOnAccountAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TaxEnergyOnAccountAmountType taxEnergyOnAccountAmount;
    @XmlElement(name = "TaxEnergyBalanceAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TaxEnergyBalanceAmountType taxEnergyBalanceAmount;
    @XmlElement(name = "TaxScheme", required = true)
    protected TaxSchemeType taxScheme;

    /**
     * Gets the value of the taxEnergyAmount property.
     * 
     * @return
     *     possible object is
     *     {@link TaxEnergyAmountType }
     *     
     */
    public TaxEnergyAmountType getTaxEnergyAmount() {
        return taxEnergyAmount;
    }

    /**
     * Sets the value of the taxEnergyAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxEnergyAmountType }
     *     
     */
    public void setTaxEnergyAmount(TaxEnergyAmountType value) {
        this.taxEnergyAmount = value;
    }

    /**
     * Gets the value of the taxEnergyOnAccountAmount property.
     * 
     * @return
     *     possible object is
     *     {@link TaxEnergyOnAccountAmountType }
     *     
     */
    public TaxEnergyOnAccountAmountType getTaxEnergyOnAccountAmount() {
        return taxEnergyOnAccountAmount;
    }

    /**
     * Sets the value of the taxEnergyOnAccountAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxEnergyOnAccountAmountType }
     *     
     */
    public void setTaxEnergyOnAccountAmount(TaxEnergyOnAccountAmountType value) {
        this.taxEnergyOnAccountAmount = value;
    }

    /**
     * Gets the value of the taxEnergyBalanceAmount property.
     * 
     * @return
     *     possible object is
     *     {@link TaxEnergyBalanceAmountType }
     *     
     */
    public TaxEnergyBalanceAmountType getTaxEnergyBalanceAmount() {
        return taxEnergyBalanceAmount;
    }

    /**
     * Sets the value of the taxEnergyBalanceAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxEnergyBalanceAmountType }
     *     
     */
    public void setTaxEnergyBalanceAmount(TaxEnergyBalanceAmountType value) {
        this.taxEnergyBalanceAmount = value;
    }

    /**
     * Gets the value of the taxScheme property.
     * 
     * @return
     *     possible object is
     *     {@link TaxSchemeType }
     *     
     */
    public TaxSchemeType getTaxScheme() {
        return taxScheme;
    }

    /**
     * Sets the value of the taxScheme property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxSchemeType }
     *     
     */
    public void setTaxScheme(TaxSchemeType value) {
        this.taxScheme = value;
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
