
package ecf4.v2025_0.tyler.ecf.extensions.common;

import java.util.ArrayList;
import java.util.List;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Extended DocumentType
 * 
 * <p>Java class for DocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}DocumentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}FilingCommentsText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}DocumentOptionalService" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}CourtesyCopiesText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}PreliminaryCopiesText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}DocumentAttachmentIdentification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}FilingAction" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}RedactionIdentification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}MotionTypeCode" minOccurs="0"/&gt;
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
    "filingCommentsText",
    "documentOptionalService",
    "courtesyCopiesText",
    "preliminaryCopiesText",
    "documentAttachmentIdentification",
    "filingAction",
    "redactionIdentification",
    "motionTypeCode"
})
public class DocumentType
    extends ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType
{

    @XmlElement(name = "FilingCommentsText")
    protected TextType filingCommentsText;
    @XmlElement(name = "DocumentOptionalService")
    protected List<DocumentOptionalServiceType> documentOptionalService;
    @XmlElement(name = "CourtesyCopiesText")
    protected TextType courtesyCopiesText;
    @XmlElement(name = "PreliminaryCopiesText")
    protected TextType preliminaryCopiesText;
    @XmlElement(name = "DocumentAttachmentIdentification")
    protected List<DocumentAttachmentIdentificationType> documentAttachmentIdentification;
    @XmlElement(name = "FilingAction")
    @XmlSchemaType(name = "token")
    protected FilingTypeType filingAction;
    @XmlElement(name = "RedactionIdentification")
    protected List<RedactionIdentificationType> redactionIdentification;
    @XmlElement(name = "MotionTypeCode")
    protected TextType motionTypeCode;

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
     * Gets the value of the documentAttachmentIdentification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the documentAttachmentIdentification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentAttachmentIdentification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentAttachmentIdentificationType }
     * 
     * 
     */
    public List<DocumentAttachmentIdentificationType> getDocumentAttachmentIdentification() {
        if (documentAttachmentIdentification == null) {
            documentAttachmentIdentification = new ArrayList<DocumentAttachmentIdentificationType>();
        }
        return this.documentAttachmentIdentification;
    }

    /**
     * Gets the value of the filingAction property.
     * 
     * @return
     *     possible object is
     *     {@link FilingTypeType }
     *     
     */
    public FilingTypeType getFilingAction() {
        return filingAction;
    }

    /**
     * Sets the value of the filingAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingTypeType }
     *     
     */
    public void setFilingAction(FilingTypeType value) {
        this.filingAction = value;
    }

    /**
     * Gets the value of the redactionIdentification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the redactionIdentification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRedactionIdentification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RedactionIdentificationType }
     * 
     * 
     */
    public List<RedactionIdentificationType> getRedactionIdentification() {
        if (redactionIdentification == null) {
            redactionIdentification = new ArrayList<RedactionIdentificationType>();
        }
        return this.redactionIdentification;
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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
