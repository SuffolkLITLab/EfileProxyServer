
package tyler.ecf.extensions.common;

import gov.niem.niem.structures._2.ReferenceType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for FilingIdentificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilingIdentificationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}FilingIdentificationReference"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}CMSID"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
    protected gov.niem.niem.proxy.xsd._2.String cmsid;

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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
