
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.domestic;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.domains.jxdm._6.CourtOrderType;
import gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Information concerning a court order in a domestic case.
 * 
 * <p>Java class for DomesticCaseOrderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DomesticCaseOrderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/domains/jxdm/6.1/}CourtOrderType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic}CourtFindingsText" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic}DomesticCaseOrderTypeText" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic}FinancialObligation" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "DomesticCaseOrderType", propOrder = {
    "courtFindingsText",
    "domesticCaseOrderTypeText",
    "financialObligation"
})
public class DomesticCaseOrderType
    extends CourtOrderType
{

    @XmlElement(name = "CourtFindingsText")
    protected TextType courtFindingsText;
    @XmlElement(name = "DomesticCaseOrderTypeText")
    protected TextType domesticCaseOrderTypeText;
    @XmlElement(name = "FinancialObligation")
    protected List<FinancialObligationType> financialObligation;

    /**
     * Gets the value of the courtFindingsText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCourtFindingsText() {
        return courtFindingsText;
    }

    /**
     * Sets the value of the courtFindingsText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCourtFindingsText(TextType value) {
        this.courtFindingsText = value;
    }

    /**
     * Gets the value of the domesticCaseOrderTypeText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDomesticCaseOrderTypeText() {
        return domesticCaseOrderTypeText;
    }

    /**
     * Sets the value of the domesticCaseOrderTypeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDomesticCaseOrderTypeText(TextType value) {
        this.domesticCaseOrderTypeText = value;
    }

    /**
     * Gets the value of the financialObligation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the financialObligation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFinancialObligation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FinancialObligationType }
     * 
     * 
     */
    public List<FinancialObligationType> getFinancialObligation() {
        if (financialObligation == null) {
            financialObligation = new ArrayList<FinancialObligationType>();
        }
        return this.financialObligation;
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
