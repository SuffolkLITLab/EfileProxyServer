
package ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4;

import java.util.ArrayList;
import java.util.List;
import ecf4.v2025_0.gov.niem.niem.domains.jxdm._4.CourtOrderType;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.TextType;
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
 *     &lt;extension base="{http://niem.gov/niem/domains/jxdm/4.0}CourtOrderType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}DomesticCaseOrderTypeText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}CourtFindingsText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}DomesticCaseObligation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DomesticCaseOrderType", propOrder = {
    "domesticCaseOrderTypeText",
    "courtFindingsText",
    "domesticCaseObligation"
})
public class DomesticCaseOrderType
    extends CourtOrderType
{

    @XmlElement(name = "DomesticCaseOrderTypeText")
    protected TextType domesticCaseOrderTypeText;
    @XmlElement(name = "CourtFindingsText")
    protected TextType courtFindingsText;
    @XmlElement(name = "DomesticCaseObligation")
    protected List<DomesticCaseObligationType> domesticCaseObligation;

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
     * Gets the value of the domesticCaseObligation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the domesticCaseObligation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDomesticCaseObligation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DomesticCaseObligationType }
     * 
     * 
     */
    public List<DomesticCaseObligationType> getDomesticCaseObligation() {
        if (domesticCaseObligation == null) {
            domesticCaseObligation = new ArrayList<DomesticCaseObligationType>();
        }
        return this.domesticCaseObligation;
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
