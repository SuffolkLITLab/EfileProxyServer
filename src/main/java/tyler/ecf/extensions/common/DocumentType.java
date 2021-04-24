
package tyler.ecf.extensions.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.TextType;


/**
 * Extended DocumentType
 * 
 * &lt;p&gt;Java class for DocumentType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DocumentType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}DocumentType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}FilingCommentsText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}DocumentOptionalService" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}CourtesyCopiesText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}PreliminaryCopiesText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}DocumentAttachmentIdentification" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}FilingAction" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}RedactionIdentification" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}MotionTypeCode" minOccurs="0"/&amp;gt;
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
    extends oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the documentOptionalService property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getDocumentOptionalService().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the documentAttachmentIdentification property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getDocumentAttachmentIdentification().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the redactionIdentification property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getRedactionIdentification().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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

}
