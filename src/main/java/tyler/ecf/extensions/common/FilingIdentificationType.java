
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.proxy.xsd._2.String;
import gov.niem.niem.structures._2.ReferenceType;


/**
 * &lt;p&gt;Java class for FilingIdentificationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FilingIdentificationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}FilingIdentificationReference"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}CMSID"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilingIdentificationType", propOrder = {
    "filingIdentificationReference",
    "cmsid"
})
public class FilingIdentificationType {

    @XmlElement(name = "FilingIdentificationReference", required = true)
    protected ReferenceType filingIdentificationReference;
    @XmlElement(name = "CMSID", required = true)
    protected String cmsid;

    /**
     * Gets the value of the filingIdentificationReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getFilingIdentificationReference() {
        return filingIdentificationReference;
    }

    /**
     * Sets the value of the filingIdentificationReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setFilingIdentificationReference(ReferenceType value) {
        this.filingIdentificationReference = value;
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

}
