
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import java.util.ArrayList;
import java.util.List;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import gov.niem.niem.structures._2.MetadataType;
import gov.niem.niem.structures._2.ReferenceType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Document descriptors (title, type description, etc.) for the Document. This is meant to include all the information about the document that is needed to index it into the Case Management System and enter it into the Document Management System.
 * 
 * <p>Java class for DocumentMetadataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentMetadataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}MetadataType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}RegisterActionDescriptionText"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}ParentDocumentReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}PriorRelatedDocumentID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}FilingAttorneyID"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}FilingPartyID" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}SpecialHandlingInstructions" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}RedactionRequiredIndicator" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentMetadataType", propOrder = {
    "registerActionDescriptionText",
    "parentDocumentReference",
    "priorRelatedDocumentID",
    "filingAttorneyID",
    "filingPartyID",
    "specialHandlingInstructions",
    "redactionRequiredIndicator"
})
public class DocumentMetadataType
    extends MetadataType
{

    @XmlElement(name = "RegisterActionDescriptionText", namespace = "http://niem.gov/niem/domains/jxdm/4.0", required = true, nillable = true)
    protected TextType registerActionDescriptionText;
    @XmlElement(name = "ParentDocumentReference")
    protected ReferenceType parentDocumentReference;
    @XmlElement(name = "PriorRelatedDocumentID")
    protected IdentificationType priorRelatedDocumentID;
    @XmlElement(name = "FilingAttorneyID", required = true)
    protected IdentificationType filingAttorneyID;
    @XmlElement(name = "FilingPartyID", required = true)
    protected List<IdentificationType> filingPartyID;
    @XmlElement(name = "SpecialHandlingInstructions")
    protected TextType specialHandlingInstructions;
    @XmlElement(name = "RedactionRequiredIndicator")
    protected Boolean redactionRequiredIndicator;

    /**
     * Gets the value of the registerActionDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getRegisterActionDescriptionText() {
        return registerActionDescriptionText;
    }

    /**
     * Sets the value of the registerActionDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setRegisterActionDescriptionText(TextType value) {
        this.registerActionDescriptionText = value;
    }

    /**
     * Gets the value of the parentDocumentReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getParentDocumentReference() {
        return parentDocumentReference;
    }

    /**
     * Sets the value of the parentDocumentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setParentDocumentReference(ReferenceType value) {
        this.parentDocumentReference = value;
    }

    /**
     * Gets the value of the priorRelatedDocumentID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getPriorRelatedDocumentID() {
        return priorRelatedDocumentID;
    }

    /**
     * Sets the value of the priorRelatedDocumentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setPriorRelatedDocumentID(IdentificationType value) {
        this.priorRelatedDocumentID = value;
    }

    /**
     * Gets the value of the filingAttorneyID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getFilingAttorneyID() {
        return filingAttorneyID;
    }

    /**
     * Sets the value of the filingAttorneyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setFilingAttorneyID(IdentificationType value) {
        this.filingAttorneyID = value;
    }

    /**
     * Gets the value of the filingPartyID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the filingPartyID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilingPartyID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationType }
     * 
     * 
     */
    public List<IdentificationType> getFilingPartyID() {
        if (filingPartyID == null) {
            filingPartyID = new ArrayList<IdentificationType>();
        }
        return this.filingPartyID;
    }

    /**
     * Gets the value of the specialHandlingInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getSpecialHandlingInstructions() {
        return specialHandlingInstructions;
    }

    /**
     * Sets the value of the specialHandlingInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setSpecialHandlingInstructions(TextType value) {
        this.specialHandlingInstructions = value;
    }

    /**
     * Gets the value of the redactionRequiredIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getRedactionRequiredIndicator() {
        return redactionRequiredIndicator;
    }

    /**
     * Sets the value of the redactionRequiredIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRedactionRequiredIndicator(Boolean value) {
        this.redactionRequiredIndicator = value;
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
