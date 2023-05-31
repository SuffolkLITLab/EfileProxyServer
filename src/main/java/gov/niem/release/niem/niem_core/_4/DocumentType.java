
package gov.niem.release.niem.niem_core._4;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.codes.iso_639_3._4.LanguageCodeType;
import gov.niem.release.niem.domains.jxdm._6.AppellateCaseNoticeType;
import gov.niem.release.niem.structures._4.ObjectType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseFilingType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentRenditionType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ReviewedDocumentType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.common.DocumentSecurityAugmentationType;
import tyler.ecf.v5_0.extensions.common.FilingType;
import tyler.ecf.v5_0.extensions.common.StatusDocumentAugmentationType;


/**
 * A data type for a paper or electronic document.
 * 
 * <p>Java class for DocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentCategoryAbstract" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentSoftwareName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentEffectiveDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentFileControlID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentFiledDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentIdentification" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentReceivedDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentSequenceID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentTitleText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentLanguageAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentSubmitter" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "DocumentType", propOrder = {
    "documentCategoryAbstract",
    "documentSoftwareName",
    "documentDescriptionText",
    "documentEffectiveDate",
    "documentFileControlID",
    "documentFiledDate",
    "documentIdentification",
    "documentReceivedDate",
    "documentSequenceID",
    "documentTitleText",
    "documentLanguageAbstract",
    "documentSubmitter",
    "documentAugmentationPoint"
})
@XmlSeeAlso({
    FilingType.class,
    AppellateCaseNoticeType.class,
    DocumentRenditionType.class,
    ReviewedDocumentType.class,
    CaseFilingType.class
})
public class DocumentType
    extends ObjectType
{

    @XmlElementRef(name = "DocumentCategoryAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> documentCategoryAbstract;
    @XmlElement(name = "DocumentSoftwareName")
    protected SoftwareNameType documentSoftwareName;
    @XmlElement(name = "DocumentDescriptionText")
    protected TextType documentDescriptionText;
    @XmlElement(name = "DocumentEffectiveDate")
    protected DateType documentEffectiveDate;
    @XmlElement(name = "DocumentFileControlID")
    protected gov.niem.release.niem.proxy.xsd._4.String documentFileControlID;
    @XmlElement(name = "DocumentFiledDate")
    protected DateType documentFiledDate;
    @XmlElement(name = "DocumentIdentification", required = true)
    protected List<IdentificationType> documentIdentification;
    @XmlElement(name = "DocumentReceivedDate")
    protected DateType documentReceivedDate;
    @XmlElement(name = "DocumentSequenceID")
    protected gov.niem.release.niem.proxy.xsd._4.String documentSequenceID;
    @XmlElement(name = "DocumentTitleText")
    protected TextType documentTitleText;
    @XmlElementRef(name = "DocumentLanguageAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> documentLanguageAbstract;
    @XmlElement(name = "DocumentSubmitter")
    protected EntityType documentSubmitter;
    @XmlElementRef(name = "DocumentAugmentationPoint", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> documentAugmentationPoint;

    /**
     * Gets the value of the documentCategoryAbstract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the documentCategoryAbstract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentCategoryAbstract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getDocumentCategoryAbstract() {
        if (documentCategoryAbstract == null) {
            documentCategoryAbstract = new ArrayList<JAXBElement<?>>();
        }
        return this.documentCategoryAbstract;
    }

    /**
     * Gets the value of the documentSoftwareName property.
     * 
     * @return
     *     possible object is
     *     {@link SoftwareNameType }
     *     
     */
    public SoftwareNameType getDocumentSoftwareName() {
        return documentSoftwareName;
    }

    /**
     * Sets the value of the documentSoftwareName property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoftwareNameType }
     *     
     */
    public void setDocumentSoftwareName(SoftwareNameType value) {
        this.documentSoftwareName = value;
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
     *     {@link gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public gov.niem.release.niem.proxy.xsd._4.String getDocumentFileControlID() {
        return documentFileControlID;
    }

    /**
     * Sets the value of the documentFileControlID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setDocumentFileControlID(gov.niem.release.niem.proxy.xsd._4.String value) {
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
     *     {@link gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public gov.niem.release.niem.proxy.xsd._4.String getDocumentSequenceID() {
        return documentSequenceID;
    }

    /**
     * Sets the value of the documentSequenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setDocumentSequenceID(gov.niem.release.niem.proxy.xsd._4.String value) {
        this.documentSequenceID = value;
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
     * Gets the value of the documentLanguageAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LanguageCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getDocumentLanguageAbstract() {
        return documentLanguageAbstract;
    }

    /**
     * Sets the value of the documentLanguageAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LanguageCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setDocumentLanguageAbstract(JAXBElement<?> value) {
        this.documentLanguageAbstract = value;
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
     * Gets the value of the documentAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the documentAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link tyler.ecf.v5_0.extensions.common.DocumentAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link DocumentSecurityAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link StatusDocumentAugmentationType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getDocumentAugmentationPoint() {
        if (documentAugmentationPoint == null) {
            documentAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.documentAugmentationPoint;
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
