
package gov.niem.niem.niem_core._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.domains.jxdm._4.AppellateCaseNoticeType;
import gov.niem.niem.iso_639_3._2.LanguageCodeType;
import gov.niem.niem.structures._2.ComplexObjectType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseFilingType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentRenditionMetadataType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentRenditionType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4.MatchingFilingType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for DocumentType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DocumentType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentApplicationName" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentBinary" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentCategoryText" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentDescriptionText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentEffectiveDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentFileControlID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentFiledDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentIdentification" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentInformationCutOffDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentPostDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentReceivedDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentSequenceID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentStatus" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentTitleText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentLanguage" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentSubmitter" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
    DocumentRenditionMetadataType.class,
    DocumentRenditionType.class,
    AppellateCaseNoticeType.class,
    MatchingFilingType.class,
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType.class,
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
    protected gov.niem.niem.proxy.xsd._2.String documentFileControlID;
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
    protected gov.niem.niem.proxy.xsd._2.String documentSequenceID;
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the documentCategoryText property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getDocumentCategoryText().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getDocumentFileControlID() {
        return documentFileControlID;
    }

    /**
     * Sets the value of the documentFileControlID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setDocumentFileControlID(gov.niem.niem.proxy.xsd._2.String value) {
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the documentIdentification property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getDocumentIdentification().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getDocumentSequenceID() {
        return documentSequenceID;
    }

    /**
     * Sets the value of the documentSequenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setDocumentSequenceID(gov.niem.niem.proxy.xsd._2.String value) {
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