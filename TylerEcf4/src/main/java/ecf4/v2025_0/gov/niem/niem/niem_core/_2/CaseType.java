
package ecf4.v2025_0.gov.niem.niem.niem_core._2;

import ecf4.v2025_0.gov.niem.niem.domains.jxdm._4.AppellateCaseType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.bankruptcycase_4.BankruptcyCaseType;
import ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.CitationCaseType;
import ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.CivilCaseType;
import ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.CriminalCaseType;
import ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseType;
import ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.JuvenileCaseType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseTitleText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseCategoryText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseTrackingID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseDocketID" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseType", propOrder = {
    "caseTitleText",
    "caseCategoryText",
    "caseTrackingID",
    "caseDocketID"
})
@XmlSeeAlso({
    CivilCaseType.class,
    AppellateCaseType.class,
    BankruptcyCaseType.class,
    CitationCaseType.class,
    CriminalCaseType.class,
    DomesticCaseType.class,
    JuvenileCaseType.class
})
public class CaseType
    extends ActivityType
{

    @XmlElement(name = "CaseTitleText", nillable = true)
    protected TextType caseTitleText;
    @XmlElement(name = "CaseCategoryText", nillable = true)
    protected TextType caseCategoryText;
    @XmlElement(name = "CaseTrackingID", nillable = true)
    protected ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String caseTrackingID;
    @XmlElement(name = "CaseDocketID", nillable = true)
    protected ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String caseDocketID;

    /**
     * Gets the value of the caseTitleText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCaseTitleText() {
        return caseTitleText;
    }

    /**
     * Sets the value of the caseTitleText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCaseTitleText(TextType value) {
        this.caseTitleText = value;
    }

    /**
     * Gets the value of the caseCategoryText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCaseCategoryText() {
        return caseCategoryText;
    }

    /**
     * Sets the value of the caseCategoryText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCaseCategoryText(TextType value) {
        this.caseCategoryText = value;
    }

    /**
     * Gets the value of the caseTrackingID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String getCaseTrackingID() {
        return caseTrackingID;
    }

    /**
     * Sets the value of the caseTrackingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setCaseTrackingID(ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String value) {
        this.caseTrackingID = value;
    }

    /**
     * Gets the value of the caseDocketID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String getCaseDocketID() {
        return caseDocketID;
    }

    /**
     * Sets the value of the caseDocketID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setCaseDocketID(ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String value) {
        this.caseDocketID = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
