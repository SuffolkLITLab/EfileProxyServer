
package tyler.ecf.v5_0.extensions.common;

import gov.niem.release.niem.niem_core._4.NonNegativeDecimalType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for AttachmentAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttachmentAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilingComponentCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}DocumentTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}PageCount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}OriginalFileName" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}DocumentComments" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}IsRedactedIndicator" minOccurs="0"/&gt;
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
@XmlType(name = "AttachmentAugmentationType", propOrder = {
    "filingComponentCode",
    "documentTypeCode",
    "pageCount",
    "originalFileName",
    "documentComments",
    "isRedactedIndicator"
})
public class AttachmentAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "FilingComponentCode")
    protected TextType filingComponentCode;
    @XmlElement(name = "DocumentTypeCode")
    protected TextType documentTypeCode;
    @XmlElement(name = "PageCount")
    protected NonNegativeDecimalType pageCount;
    @XmlElement(name = "OriginalFileName")
    protected TextType originalFileName;
    @XmlElement(name = "DocumentComments")
    protected TextType documentComments;
    @XmlElement(name = "IsRedactedIndicator")
    protected Boolean isRedactedIndicator;

    /**
     * Gets the value of the filingComponentCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getFilingComponentCode() {
        return filingComponentCode;
    }

    /**
     * Sets the value of the filingComponentCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setFilingComponentCode(TextType value) {
        this.filingComponentCode = value;
    }

    /**
     * Gets the value of the documentTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDocumentTypeCode() {
        return documentTypeCode;
    }

    /**
     * Sets the value of the documentTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDocumentTypeCode(TextType value) {
        this.documentTypeCode = value;
    }

    /**
     * Gets the value of the pageCount property.
     * 
     * @return
     *     possible object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public NonNegativeDecimalType getPageCount() {
        return pageCount;
    }

    /**
     * Sets the value of the pageCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public void setPageCount(NonNegativeDecimalType value) {
        this.pageCount = value;
    }

    /**
     * Gets the value of the originalFileName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getOriginalFileName() {
        return originalFileName;
    }

    /**
     * Sets the value of the originalFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setOriginalFileName(TextType value) {
        this.originalFileName = value;
    }

    /**
     * Gets the value of the documentComments property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDocumentComments() {
        return documentComments;
    }

    /**
     * Sets the value of the documentComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDocumentComments(TextType value) {
        this.documentComments = value;
    }

    /**
     * Gets the value of the isRedactedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIsRedactedIndicator() {
        return isRedactedIndicator;
    }

    /**
     * Sets the value of the isRedactedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRedactedIndicator(Boolean value) {
        this.isRedactedIndicator = value;
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
