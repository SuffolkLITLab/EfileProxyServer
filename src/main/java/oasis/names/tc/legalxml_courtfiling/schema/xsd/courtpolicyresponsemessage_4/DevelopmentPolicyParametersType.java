
package oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.MeasureType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Within Court Policy, the policies that are accessed by a person or organization developing an applications or configuring an application to interact with a court for the purpose of structuring the interactions with that court. This information is needed once and is not accessed dynamically while interacting with the court.
 * 
 * &lt;p&gt;Java class for DevelopmentPolicyParametersType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DevelopmentPolicyParametersType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}URLAttachmentSupportedIndicator"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}AcceptDocumentsRequiringFeesIndicator"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}AcceptConfidentialFilingsIndicator"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}AcceptMultipleLeadDocumentsIndicator"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}MaximumAllowedAttachmentSize" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}MaximumAllowedMessageSize" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}SupportedMessageProfileCode" maxOccurs="unbounded"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}SupportedSignatureProfileCode" maxOccurs="unbounded"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}SupportedOperationName" maxOccurs="unbounded"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}SupportedCaseType" maxOccurs="unbounded"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}CourtExtension" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}FilingFeesMayBeApplicableIndicator"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}EffectiveDate"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}ExpirationDate" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DevelopmentPolicyParametersType", propOrder = {
    "urlAttachmentSupportedIndicator",
    "acceptDocumentsRequiringFeesIndicator",
    "acceptConfidentialFilingsIndicator",
    "acceptMultipleLeadDocumentsIndicator",
    "maximumAllowedAttachmentSize",
    "maximumAllowedMessageSize",
    "supportedMessageProfileCode",
    "supportedSignatureProfileCode",
    "supportedOperationName",
    "supportedCaseType",
    "courtExtension",
    "filingFeesMayBeApplicableIndicator",
    "effectiveDate",
    "expirationDate"
})
@XmlSeeAlso({
    tyler.ecf.extensions.common.DevelopmentPolicyParametersType.class
})
public class DevelopmentPolicyParametersType
    extends ComplexObjectType
{

    @XmlElement(name = "URLAttachmentSupportedIndicator", required = true)
    protected Boolean urlAttachmentSupportedIndicator;
    @XmlElement(name = "AcceptDocumentsRequiringFeesIndicator", required = true)
    protected Boolean acceptDocumentsRequiringFeesIndicator;
    @XmlElement(name = "AcceptConfidentialFilingsIndicator", required = true)
    protected Boolean acceptConfidentialFilingsIndicator;
    @XmlElement(name = "AcceptMultipleLeadDocumentsIndicator", required = true)
    protected Boolean acceptMultipleLeadDocumentsIndicator;
    @XmlElement(name = "MaximumAllowedAttachmentSize")
    protected MeasureType maximumAllowedAttachmentSize;
    @XmlElement(name = "MaximumAllowedMessageSize")
    protected MeasureType maximumAllowedMessageSize;
    @XmlElement(name = "SupportedMessageProfileCode", required = true)
    protected List<TextType> supportedMessageProfileCode;
    @XmlElement(name = "SupportedSignatureProfileCode", required = true)
    protected List<TextType> supportedSignatureProfileCode;
    @XmlElement(name = "SupportedOperationName", required = true)
    protected List<OperationNameType> supportedOperationName;
    @XmlElement(name = "SupportedCaseType", required = true)
    protected List<CaseTypeCodeType> supportedCaseType;
    @XmlElement(name = "CourtExtension")
    protected List<CourtExtensionType> courtExtension;
    @XmlElement(name = "FilingFeesMayBeApplicableIndicator", required = true)
    protected Boolean filingFeesMayBeApplicableIndicator;
    @XmlElement(name = "EffectiveDate", required = true)
    protected DateType effectiveDate;
    @XmlElement(name = "ExpirationDate")
    protected DateType expirationDate;

    /**
     * Gets the value of the urlAttachmentSupportedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getURLAttachmentSupportedIndicator() {
        return urlAttachmentSupportedIndicator;
    }

    /**
     * Sets the value of the urlAttachmentSupportedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setURLAttachmentSupportedIndicator(Boolean value) {
        this.urlAttachmentSupportedIndicator = value;
    }

    /**
     * Gets the value of the acceptDocumentsRequiringFeesIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getAcceptDocumentsRequiringFeesIndicator() {
        return acceptDocumentsRequiringFeesIndicator;
    }

    /**
     * Sets the value of the acceptDocumentsRequiringFeesIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAcceptDocumentsRequiringFeesIndicator(Boolean value) {
        this.acceptDocumentsRequiringFeesIndicator = value;
    }

    /**
     * Gets the value of the acceptConfidentialFilingsIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getAcceptConfidentialFilingsIndicator() {
        return acceptConfidentialFilingsIndicator;
    }

    /**
     * Sets the value of the acceptConfidentialFilingsIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAcceptConfidentialFilingsIndicator(Boolean value) {
        this.acceptConfidentialFilingsIndicator = value;
    }

    /**
     * Gets the value of the acceptMultipleLeadDocumentsIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getAcceptMultipleLeadDocumentsIndicator() {
        return acceptMultipleLeadDocumentsIndicator;
    }

    /**
     * Sets the value of the acceptMultipleLeadDocumentsIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAcceptMultipleLeadDocumentsIndicator(Boolean value) {
        this.acceptMultipleLeadDocumentsIndicator = value;
    }

    /**
     * Gets the value of the maximumAllowedAttachmentSize property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getMaximumAllowedAttachmentSize() {
        return maximumAllowedAttachmentSize;
    }

    /**
     * Sets the value of the maximumAllowedAttachmentSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setMaximumAllowedAttachmentSize(MeasureType value) {
        this.maximumAllowedAttachmentSize = value;
    }

    /**
     * Gets the value of the maximumAllowedMessageSize property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getMaximumAllowedMessageSize() {
        return maximumAllowedMessageSize;
    }

    /**
     * Sets the value of the maximumAllowedMessageSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setMaximumAllowedMessageSize(MeasureType value) {
        this.maximumAllowedMessageSize = value;
    }

    /**
     * Gets the value of the supportedMessageProfileCode property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the supportedMessageProfileCode property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getSupportedMessageProfileCode().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getSupportedMessageProfileCode() {
        if (supportedMessageProfileCode == null) {
            supportedMessageProfileCode = new ArrayList<TextType>();
        }
        return this.supportedMessageProfileCode;
    }

    /**
     * Gets the value of the supportedSignatureProfileCode property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the supportedSignatureProfileCode property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getSupportedSignatureProfileCode().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getSupportedSignatureProfileCode() {
        if (supportedSignatureProfileCode == null) {
            supportedSignatureProfileCode = new ArrayList<TextType>();
        }
        return this.supportedSignatureProfileCode;
    }

    /**
     * Gets the value of the supportedOperationName property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the supportedOperationName property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getSupportedOperationName().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link OperationNameType }
     * 
     * 
     */
    public List<OperationNameType> getSupportedOperationName() {
        if (supportedOperationName == null) {
            supportedOperationName = new ArrayList<OperationNameType>();
        }
        return this.supportedOperationName;
    }

    /**
     * Gets the value of the supportedCaseType property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the supportedCaseType property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getSupportedCaseType().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link CaseTypeCodeType }
     * 
     * 
     */
    public List<CaseTypeCodeType> getSupportedCaseType() {
        if (supportedCaseType == null) {
            supportedCaseType = new ArrayList<CaseTypeCodeType>();
        }
        return this.supportedCaseType;
    }

    /**
     * Gets the value of the courtExtension property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the courtExtension property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getCourtExtension().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link CourtExtensionType }
     * 
     * 
     */
    public List<CourtExtensionType> getCourtExtension() {
        if (courtExtension == null) {
            courtExtension = new ArrayList<CourtExtensionType>();
        }
        return this.courtExtension;
    }

    /**
     * Gets the value of the filingFeesMayBeApplicableIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getFilingFeesMayBeApplicableIndicator() {
        return filingFeesMayBeApplicableIndicator;
    }

    /**
     * Sets the value of the filingFeesMayBeApplicableIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFilingFeesMayBeApplicableIndicator(Boolean value) {
        this.filingFeesMayBeApplicableIndicator = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setEffectiveDate(DateType value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setExpirationDate(DateType value) {
        this.expirationDate = value;
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
