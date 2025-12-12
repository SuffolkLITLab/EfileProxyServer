
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.common;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.DateType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DocumentAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilingAction" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilingAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}DocumentOptionalService" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilingCommentsText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CourtesyCopiesText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}PreliminaryCopiesText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}MotionTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}RedactionIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}DispositionAction" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilerReferenceNumber" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}DueDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}DeferredUntilDate" minOccurs="0"/&gt;
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
@XmlType(name = "DocumentAugmentationType", propOrder = {
    "filingAction",
    "filingAssociation",
    "documentOptionalService",
    "filingCommentsText",
    "courtesyCopiesText",
    "preliminaryCopiesText",
    "motionTypeCode",
    "redactionIdentification",
    "dispositionAction",
    "filerReferenceNumber",
    "dueDate",
    "deferredUntilDate"
})
public class DocumentAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "FilingAction")
    protected FilingActionType filingAction;
    @XmlElement(name = "FilingAssociation")
    protected List<FilingAssociationType> filingAssociation;
    @XmlElement(name = "DocumentOptionalService")
    protected List<DocumentOptionalServiceType> documentOptionalService;
    @XmlElement(name = "FilingCommentsText")
    protected TextType filingCommentsText;
    @XmlElement(name = "CourtesyCopiesText")
    protected TextType courtesyCopiesText;
    @XmlElement(name = "PreliminaryCopiesText")
    protected TextType preliminaryCopiesText;
    @XmlElement(name = "MotionTypeCode")
    protected TextType motionTypeCode;
    @XmlElement(name = "RedactionIdentification")
    protected IdentificationType redactionIdentification;
    @XmlElement(name = "DispositionAction")
    protected DispositionActionType dispositionAction;
    @XmlElement(name = "FilerReferenceNumber")
    protected TextType filerReferenceNumber;
    @XmlElement(name = "DueDate")
    protected DateType dueDate;
    @XmlElement(name = "DeferredUntilDate")
    protected DateType deferredUntilDate;

    /**
     * Gets the value of the filingAction property.
     * 
     * @return
     *     possible object is
     *     {@link FilingActionType }
     *     
     */
    public FilingActionType getFilingAction() {
        return filingAction;
    }

    /**
     * Sets the value of the filingAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingActionType }
     *     
     */
    public void setFilingAction(FilingActionType value) {
        this.filingAction = value;
    }

    /**
     * Gets the value of the filingAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the filingAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilingAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FilingAssociationType }
     * 
     * 
     */
    public List<FilingAssociationType> getFilingAssociation() {
        if (filingAssociation == null) {
            filingAssociation = new ArrayList<FilingAssociationType>();
        }
        return this.filingAssociation;
    }

    /**
     * Gets the value of the documentOptionalService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the documentOptionalService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentOptionalService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentOptionalServiceType }
     * 
     * 
     */
    public List<DocumentOptionalServiceType> getDocumentOptionalService() {
        if (documentOptionalService == null) {
            documentOptionalService = new ArrayList<DocumentOptionalServiceType>();
        }
        return this.documentOptionalService;
    }

    /**
     * Gets the value of the filingCommentsText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getFilingCommentsText() {
        return filingCommentsText;
    }

    /**
     * Sets the value of the filingCommentsText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setFilingCommentsText(TextType value) {
        this.filingCommentsText = value;
    }

    /**
     * Gets the value of the courtesyCopiesText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCourtesyCopiesText() {
        return courtesyCopiesText;
    }

    /**
     * Sets the value of the courtesyCopiesText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCourtesyCopiesText(TextType value) {
        this.courtesyCopiesText = value;
    }

    /**
     * Gets the value of the preliminaryCopiesText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getPreliminaryCopiesText() {
        return preliminaryCopiesText;
    }

    /**
     * Sets the value of the preliminaryCopiesText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setPreliminaryCopiesText(TextType value) {
        this.preliminaryCopiesText = value;
    }

    /**
     * Gets the value of the motionTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getMotionTypeCode() {
        return motionTypeCode;
    }

    /**
     * Sets the value of the motionTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setMotionTypeCode(TextType value) {
        this.motionTypeCode = value;
    }

    /**
     * Gets the value of the redactionIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getRedactionIdentification() {
        return redactionIdentification;
    }

    /**
     * Sets the value of the redactionIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setRedactionIdentification(IdentificationType value) {
        this.redactionIdentification = value;
    }

    /**
     * Gets the value of the dispositionAction property.
     * 
     * @return
     *     possible object is
     *     {@link DispositionActionType }
     *     
     */
    public DispositionActionType getDispositionAction() {
        return dispositionAction;
    }

    /**
     * Sets the value of the dispositionAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link DispositionActionType }
     *     
     */
    public void setDispositionAction(DispositionActionType value) {
        this.dispositionAction = value;
    }

    /**
     * Gets the value of the filerReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getFilerReferenceNumber() {
        return filerReferenceNumber;
    }

    /**
     * Sets the value of the filerReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setFilerReferenceNumber(TextType value) {
        this.filerReferenceNumber = value;
    }

    /**
     * Gets the value of the dueDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDueDate() {
        return dueDate;
    }

    /**
     * Sets the value of the dueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDueDate(DateType value) {
        this.dueDate = value;
    }

    /**
     * Gets the value of the deferredUntilDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDeferredUntilDate() {
        return deferredUntilDate;
    }

    /**
     * Sets the value of the deferredUntilDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDeferredUntilDate(DateType value) {
        this.deferredUntilDate = value;
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
