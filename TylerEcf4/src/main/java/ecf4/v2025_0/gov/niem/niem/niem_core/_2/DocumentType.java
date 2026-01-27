
package ecf4.v2025_0.gov.niem.niem.niem_core._2;

import java.util.ArrayList;
import java.util.List;
import ecf4.v2025_0.gov.niem.niem.domains.jxdm._4.AppellateCaseNoticeType;
import ecf4.v2025_0.gov.niem.niem.iso_639_3._2.LanguageCodeType;
import ecf4.v2025_0.gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseFilingType;
import ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentRenditionMetadataType;
import ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentRenditionType;
import ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4.MatchingFilingType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentApplicationName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentBinary" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentCategoryText" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentEffectiveDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentFileControlID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentFiledDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentIdentification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentInformationCutOffDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentPostDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentReceivedDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentSequenceID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentStatus" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentTitleText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentLanguage" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentSubmitter" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentType", propOrder = {
    "documentApplicationName",
    "documentBinary",
    "documentCategoryText",
    "documentDescriptionText",
    "documentEffectiveDate",
    "documentFileControlID",
    "documentFiledDate",
    "documentIdentification",
    "documentInformationCutOffDate",
    "documentPostDate",
    "documentReceivedDate",
    "documentSequenceID",
    "documentStatus",
    "documentTitleText",
    "documentLanguage",
    "documentSubmitter"
})
@XmlSeeAlso({
    AppellateCaseNoticeType.class,
    DocumentRenditionMetadataType.class,
    DocumentRenditionType.class,
    MatchingFilingType.class,
   ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType.class,
    CaseFilingType.class
})
public class DocumentType
    extends ComplexObjectType
{

    @XmlElement(name = "DocumentApplicationName", nillable = true)
    protected ApplicationNameType documentApplicationName;
    @XmlElement(name = "DocumentBinary", nillable = true)
    protected BinaryType documentBinary;
    @XmlElementRef(name = "DocumentCategoryText", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<TextType>> documentCategoryText;
    @XmlElement(name = "DocumentDescriptionText", nillable = true)
    protected TextType documentDescriptionText;
    @XmlElement(name = "DocumentEffectiveDate", nillable = true)
    protected DateType documentEffectiveDate;
    @XmlElement(name = "DocumentFileControlID", nillable = true)
    protected ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String documentFileControlID;
    @XmlElement(name = "DocumentFiledDate", nillable = true)
    protected DateType documentFiledDate;
    @XmlElement(name = "DocumentIdentification", nillable = true)
    protected List<IdentificationType> documentIdentification;
    @XmlElement(name = "DocumentInformationCutOffDate", nillable = true)
    protected DateType documentInformationCutOffDate;
    @XmlElement(name = "DocumentPostDate", nillable = true)
    protected DateType documentPostDate;
    @XmlElement(name = "DocumentReceivedDate", nillable = true)
    protected DateType documentReceivedDate;
    @XmlElement(name = "DocumentSequenceID", nillable = true)
    protected ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String documentSequenceID;
    @XmlElement(name = "DocumentStatus", nillable = true)
    protected StatusType documentStatus;
    @XmlElement(name = "DocumentTitleText", nillable = true)
    protected TextType documentTitleText;
    @XmlElementRef(name = "DocumentLanguage", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> documentLanguage;
    @XmlElement(name = "DocumentSubmitter", nillable = true)
    protected EntityType documentSubmitter;

    /**
     * Gets the value of the documentApplicationName property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationNameType }
     *     
     */
    public ApplicationNameType getDocumentApplicationName() {
        return documentApplicationName;
    }

    /**
     * Sets the value of the documentApplicationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationNameType }
     *     
     */
    public void setDocumentApplicationName(ApplicationNameType value) {
        this.documentApplicationName = value;
    }

    /**
     * Gets the value of the documentBinary property.
     * 
     * @return
     *     possible object is
     *     {@link BinaryType }
     *     
     */
    public BinaryType getDocumentBinary() {
        return documentBinary;
    }

    /**
     * Sets the value of the documentBinary property.
     * 
     * @param value
     *     allowed object is
     *     {@link BinaryType }
     *     
     */
    public void setDocumentBinary(BinaryType value) {
        this.documentBinary = value;
    }

    /**
     * Gets the value of the documentCategoryText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the documentCategoryText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentCategoryText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<TextType>> getDocumentCategoryText() {
        if (documentCategoryText == null) {
            documentCategoryText = new ArrayList<JAXBElement<TextType>>();
        }
        return this.documentCategoryText;
    }

    /**
     * Gets the value of the documentDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDocumentDescriptionText() {
        return documentDescriptionText;
    }

    /**
     * Sets the value of the documentDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDocumentDescriptionText(TextType value) {
        this.documentDescriptionText = value;
    }

    /**
     * Gets the value of the documentEffectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDocumentEffectiveDate() {
        return documentEffectiveDate;
    }

    /**
     * Sets the value of the documentEffectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDocumentEffectiveDate(DateType value) {
        this.documentEffectiveDate = value;
    }

    /**
     * Gets the value of the documentFileControlID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String getDocumentFileControlID() {
        return documentFileControlID;
    }

    /**
     * Sets the value of the documentFileControlID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setDocumentFileControlID(ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String value) {
        this.documentFileControlID = value;
    }

    /**
     * Gets the value of the documentFiledDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDocumentFiledDate() {
        return documentFiledDate;
    }

    /**
     * Sets the value of the documentFiledDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDocumentFiledDate(DateType value) {
        this.documentFiledDate = value;
    }

    /**
     * Gets the value of the documentIdentification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the documentIdentification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentIdentification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationType }
     * 
     * 
     */
    public List<IdentificationType> getDocumentIdentification() {
        if (documentIdentification == null) {
            documentIdentification = new ArrayList<IdentificationType>();
        }
        return this.documentIdentification;
    }

    /**
     * Gets the value of the documentInformationCutOffDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDocumentInformationCutOffDate() {
        return documentInformationCutOffDate;
    }

    /**
     * Sets the value of the documentInformationCutOffDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDocumentInformationCutOffDate(DateType value) {
        this.documentInformationCutOffDate = value;
    }

    /**
     * Gets the value of the documentPostDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDocumentPostDate() {
        return documentPostDate;
    }

    /**
     * Sets the value of the documentPostDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDocumentPostDate(DateType value) {
        this.documentPostDate = value;
    }

    /**
     * Gets the value of the documentReceivedDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDocumentReceivedDate() {
        return documentReceivedDate;
    }

    /**
     * Sets the value of the documentReceivedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDocumentReceivedDate(DateType value) {
        this.documentReceivedDate = value;
    }

    /**
     * Gets the value of the documentSequenceID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String getDocumentSequenceID() {
        return documentSequenceID;
    }

    /**
     * Sets the value of the documentSequenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setDocumentSequenceID(ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String value) {
        this.documentSequenceID = value;
    }

    /**
     * Gets the value of the documentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getDocumentStatus() {
        return documentStatus;
    }

    /**
     * Sets the value of the documentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setDocumentStatus(StatusType value) {
        this.documentStatus = value;
    }

    /**
     * Gets the value of the documentTitleText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDocumentTitleText() {
        return documentTitleText;
    }

    /**
     * Sets the value of the documentTitleText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDocumentTitleText(TextType value) {
        this.documentTitleText = value;
    }

    /**
     * Gets the value of the documentLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LanguageCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getDocumentLanguage() {
        return documentLanguage;
    }

    /**
     * Sets the value of the documentLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LanguageCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setDocumentLanguage(JAXBElement<?> value) {
        this.documentLanguage = value;
    }

    /**
     * Gets the value of the documentSubmitter property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getDocumentSubmitter() {
        return documentSubmitter;
    }

    /**
     * Sets the value of the documentSubmitter property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setDocumentSubmitter(EntityType value) {
        this.documentSubmitter = value;
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
