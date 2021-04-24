
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.proxy.xsd._2.String;
import gov.niem.niem.structures._2.ReferenceType;


/**
 * &lt;p&gt;Java class for DocumentAttachmentIdentificationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DocumentAttachmentIdentificationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}DocumentAttachmentReference"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}DocumentID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}CMSID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}DocumentSecurity" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentAttachmentIdentificationType", propOrder = {
    "documentAttachmentReference",
    "documentID",
    "cmsid",
    "documentSecurity"
})
public class DocumentAttachmentIdentificationType {

    @XmlElement(name = "DocumentAttachmentReference", required = true)
    protected ReferenceType documentAttachmentReference;
    @XmlElement(name = "DocumentID")
    protected String documentID;
    @XmlElement(name = "CMSID")
    protected String cmsid;
    @XmlElement(name = "DocumentSecurity")
    @XmlSchemaType(name = "token")
    protected DocumentSecurityType documentSecurity;

    /**
     * Gets the value of the documentAttachmentReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getDocumentAttachmentReference() {
        return documentAttachmentReference;
    }

    /**
     * Sets the value of the documentAttachmentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setDocumentAttachmentReference(ReferenceType value) {
        this.documentAttachmentReference = value;
    }

    /**
     * Gets the value of the documentID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentID() {
        return documentID;
    }

    /**
     * Sets the value of the documentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentID(String value) {
        this.documentID = value;
    }

    /**
     * Gets the value of the cmsid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCMSID() {
        return cmsid;
    }

    /**
     * Sets the value of the cmsid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCMSID(String value) {
        this.cmsid = value;
    }

    /**
     * Gets the value of the documentSecurity property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentSecurityType }
     *     
     */
    public DocumentSecurityType getDocumentSecurity() {
        return documentSecurity;
    }

    /**
     * Sets the value of the documentSecurity property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentSecurityType }
     *     
     */
    public void setDocumentSecurity(DocumentSecurityType value) {
        this.documentSecurity = value;
    }

}
