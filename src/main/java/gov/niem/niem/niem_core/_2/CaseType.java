
package gov.niem.niem.niem_core._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.domains.jxdm._4.AppellateCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.bankruptcycase_4.BankruptcyCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.CitationCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.CivilCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.CriminalCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.JuvenileCaseType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for CaseType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CaseType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}ActivityType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseTitleText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseCategoryText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseTrackingID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseDocketID" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
    CitationCaseType.class,
    JuvenileCaseType.class,
    DomesticCaseType.class,
    CivilCaseType.class,
    AppellateCaseType.class,
    BankruptcyCaseType.class,
    CriminalCaseType.class
})
public class CaseType
    extends ActivityType
{

    @XmlElement(name = "CaseTitleText", nillable = true)
    protected TextType caseTitleText;
    @XmlElement(name = "CaseCategoryText", nillable = true)
    protected TextType caseCategoryText;
    @XmlElement(name = "CaseTrackingID", nillable = true)
    protected gov.niem.niem.proxy.xsd._2.String caseTrackingID;
    @XmlElement(name = "CaseDocketID", nillable = true)
    protected gov.niem.niem.proxy.xsd._2.String caseDocketID;

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
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getCaseTrackingID() {
        return caseTrackingID;
    }

    /**
     * Sets the value of the caseTrackingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setCaseTrackingID(gov.niem.niem.proxy.xsd._2.String value) {
        this.caseTrackingID = value;
    }

    /**
     * Gets the value of the caseDocketID property.
     * 
     * @return
     *     possible object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getCaseDocketID() {
        return caseDocketID;
    }

    /**
     * Sets the value of the caseDocketID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setCaseDocketID(gov.niem.niem.proxy.xsd._2.String value) {
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
