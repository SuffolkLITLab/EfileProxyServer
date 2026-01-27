
package ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4;

import java.util.ArrayList;
import java.util.List;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.DateType;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.MeasureType;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.TextType;
import ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.AnyURI;
import ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.Boolean;
import ecf4.v2025_0.gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Within Court Policy, the policies that are accessed by a person or organization developing an applications or configuring an application to interact with a court for the purpose of structuring the interactions with that court. This information is needed once and is not accessed dynamically while interacting with the court.
 * 
 * <p>Java class for DevelopmentPolicyParametersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DevelopmentPolicyParametersType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}URLAttachmentSupportedIndicator"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}AcceptDocumentsRequiringFeesIndicator"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}AcceptConfidentialFilingsIndicator"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}AcceptMultipleLeadDocumentsIndicator"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}LocationSpecificUrl" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}MaximumAllowedAttachmentSize" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}MaximumAllowedMessageSize" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}SupportedMessageProfileCode" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}SupportedSignatureProfileCode" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}SupportedOperationName" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}SupportedCaseType" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}CourtExtension" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}FilingFeesMayBeApplicableIndicator"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}EffectiveDate"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}ExpirationDate" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DevelopmentPolicyParametersType", propOrder = {
    "urlAttachmentSupportedIndicator",
    "acceptDocumentsRequiringFeesIndicator",
    "acceptConfidentialFilingsIndicator",
    "acceptMultipleLeadDocumentsIndicator",
    "locationSpecificUrl",
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
   ecf4.v2025_0.tyler.ecf.extensions.common.DevelopmentPolicyParametersType.class
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
    @XmlElement(name = "LocationSpecificUrl")
    protected AnyURI locationSpecificUrl;
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
     * Gets the value of the locationSpecificUrl property.
     * 
     * @return
     *     possible object is
     *     {@link AnyURI }
     *     
     */
    public AnyURI getLocationSpecificUrl() {
        return locationSpecificUrl;
    }

    /**
     * Sets the value of the locationSpecificUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyURI }
     *     
     */
    public void setLocationSpecificUrl(AnyURI value) {
        this.locationSpecificUrl = value;
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the supportedMessageProfileCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedMessageProfileCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the supportedSignatureProfileCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedSignatureProfileCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the supportedOperationName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedOperationName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the supportedCaseType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedCaseType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the courtExtension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourtExtension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
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
