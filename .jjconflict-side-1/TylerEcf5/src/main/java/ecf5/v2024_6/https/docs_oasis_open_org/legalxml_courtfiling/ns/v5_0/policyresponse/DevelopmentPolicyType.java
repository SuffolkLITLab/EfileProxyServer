
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.MeasureType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.NumericType;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Boolean;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Within Court Policy, the policies that are accessed by a person or organization developing an applications or configuring an application to interact with a court for the purpose of structuring the interactions with that court.  This information is needed once and is not accessed dynamically while interacting with the court.
 * 
 * <p>Java class for DevelopmentPolicyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DevelopmentPolicyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}AcceptConfidentialFilingsIndicator"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}AcceptDocumentsRequiringFeesIndicator"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}AcceptMultipleLeadDocumentsIndicator"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}FilerRequiredToServeIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}FilingFeesMayBeApplicableIndicator"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}MajorDesignElement" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}MaximumAllowedAttachmentPageQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}MaximumAllowedAttachmentSize" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}MaximumAllowedMessageSize" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}SchemaExtension" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}SupportedCaseCategories" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}SupportedSignaturesProfiles" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}URLAttachmentSupportedIndicator"/&gt;
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
@XmlType(name = "DevelopmentPolicyType", propOrder = {
    "acceptConfidentialFilingsIndicator",
    "acceptDocumentsRequiringFeesIndicator",
    "acceptMultipleLeadDocumentsIndicator",
    "filerRequiredToServeIndicator",
    "filingFeesMayBeApplicableIndicator",
    "majorDesignElement",
    "maximumAllowedAttachmentPageQuantity",
    "maximumAllowedAttachmentSize",
    "maximumAllowedMessageSize",
    "schemaExtension",
    "supportedCaseCategories",
    "supportedSignaturesProfiles",
    "urlAttachmentSupportedIndicator"
})
public class DevelopmentPolicyType
    extends ObjectType
{

    @XmlElement(name = "AcceptConfidentialFilingsIndicator", required = true)
    protected Boolean acceptConfidentialFilingsIndicator;
    @XmlElement(name = "AcceptDocumentsRequiringFeesIndicator", required = true)
    protected Boolean acceptDocumentsRequiringFeesIndicator;
    @XmlElement(name = "AcceptMultipleLeadDocumentsIndicator", required = true)
    protected Boolean acceptMultipleLeadDocumentsIndicator;
    @XmlElement(name = "FilerRequiredToServeIndicator")
    protected Boolean filerRequiredToServeIndicator;
    @XmlElement(name = "FilingFeesMayBeApplicableIndicator", required = true)
    protected Boolean filingFeesMayBeApplicableIndicator;
    @XmlElement(name = "MajorDesignElement", required = true)
    protected List<MajorDesignElementType> majorDesignElement;
    @XmlElement(name = "MaximumAllowedAttachmentPageQuantity")
    protected NumericType maximumAllowedAttachmentPageQuantity;
    @XmlElement(name = "MaximumAllowedAttachmentSize")
    protected MeasureType maximumAllowedAttachmentSize;
    @XmlElement(name = "MaximumAllowedMessageSize")
    protected MeasureType maximumAllowedMessageSize;
    @XmlElement(name = "SchemaExtension")
    protected List<SchemaExtensionType> schemaExtension;
    @XmlElement(name = "SupportedCaseCategories", required = true)
    protected List<SupportedCaseCategoriesType> supportedCaseCategories;
    @XmlElement(name = "SupportedSignaturesProfiles", required = true)
    protected List<SupportedSignatureProfilesType> supportedSignaturesProfiles;
    @XmlElement(name = "URLAttachmentSupportedIndicator", required = true)
    protected Boolean urlAttachmentSupportedIndicator;

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
     * Gets the value of the filerRequiredToServeIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getFilerRequiredToServeIndicator() {
        return filerRequiredToServeIndicator;
    }

    /**
     * Sets the value of the filerRequiredToServeIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFilerRequiredToServeIndicator(Boolean value) {
        this.filerRequiredToServeIndicator = value;
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
     * Gets the value of the majorDesignElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the majorDesignElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMajorDesignElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MajorDesignElementType }
     * 
     * 
     */
    public List<MajorDesignElementType> getMajorDesignElement() {
        if (majorDesignElement == null) {
            majorDesignElement = new ArrayList<MajorDesignElementType>();
        }
        return this.majorDesignElement;
    }

    /**
     * Gets the value of the maximumAllowedAttachmentPageQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link NumericType }
     *     
     */
    public NumericType getMaximumAllowedAttachmentPageQuantity() {
        return maximumAllowedAttachmentPageQuantity;
    }

    /**
     * Sets the value of the maximumAllowedAttachmentPageQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link NumericType }
     *     
     */
    public void setMaximumAllowedAttachmentPageQuantity(NumericType value) {
        this.maximumAllowedAttachmentPageQuantity = value;
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
     * Gets the value of the schemaExtension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the schemaExtension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSchemaExtension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SchemaExtensionType }
     * 
     * 
     */
    public List<SchemaExtensionType> getSchemaExtension() {
        if (schemaExtension == null) {
            schemaExtension = new ArrayList<SchemaExtensionType>();
        }
        return this.schemaExtension;
    }

    /**
     * Gets the value of the supportedCaseCategories property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the supportedCaseCategories property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedCaseCategories().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupportedCaseCategoriesType }
     * 
     * 
     */
    public List<SupportedCaseCategoriesType> getSupportedCaseCategories() {
        if (supportedCaseCategories == null) {
            supportedCaseCategories = new ArrayList<SupportedCaseCategoriesType>();
        }
        return this.supportedCaseCategories;
    }

    /**
     * Gets the value of the supportedSignaturesProfiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the supportedSignaturesProfiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedSignaturesProfiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupportedSignatureProfilesType }
     * 
     * 
     */
    public List<SupportedSignatureProfilesType> getSupportedSignaturesProfiles() {
        if (supportedSignaturesProfiles == null) {
            supportedSignaturesProfiles = new ArrayList<SupportedSignatureProfilesType>();
        }
        return this.supportedSignaturesProfiles;
    }

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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
