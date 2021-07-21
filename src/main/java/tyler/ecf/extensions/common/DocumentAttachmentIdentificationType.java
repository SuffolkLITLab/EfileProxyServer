
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ReferenceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DocumentAttachmentIdentificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentAttachmentIdentificationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}DocumentAttachmentReference"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}DocumentID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}CMSID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}DocumentSecurity" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
    protected gov.niem.niem.proxy.xsd._2.String documentID;
    @XmlElement(name = "CMSID")
    protected gov.niem.niem.proxy.xsd._2.String cmsid;
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
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getDocumentID() {
        return documentID;
    }

    /**
     * Sets the value of the documentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setDocumentID(gov.niem.niem.proxy.xsd._2.String value) {
        this.documentID = value;
    }

    /**
     * Gets the value of the cmsid property.
     * 
     * @return
     *     possible object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getCMSID() {
        return cmsid;
    }

    /**
     * Sets the value of the cmsid property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setCMSID(gov.niem.niem.proxy.xsd._2.String value) {
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
