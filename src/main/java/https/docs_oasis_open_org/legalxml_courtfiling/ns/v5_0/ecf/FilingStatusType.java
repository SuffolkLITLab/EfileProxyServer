
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import gov.niem.release.niem.niem_core._4.StatusType;
import gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A textual description of the reason for the setting of the status in the filingStatusCode.
 * 
 * <p>Java class for FilingStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilingStatusType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}StatusType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}FilingDocketingStatusCode" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}FilingReviewStatusCode"/&gt;
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
@XmlType(name = "FilingStatusType", propOrder = {
    "filingDocketingStatusCode",
    "filingReviewStatusCode"
})
public class FilingStatusType
    extends StatusType
{

    @XmlElement(name = "FilingDocketingStatusCode")
    protected NormalizedString filingDocketingStatusCode;
    @XmlElement(name = "FilingReviewStatusCode", required = true)
    protected NormalizedString filingReviewStatusCode;

    /**
     * Gets the value of the filingDocketingStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link NormalizedString }
     *     
     */
    public NormalizedString getFilingDocketingStatusCode() {
        return filingDocketingStatusCode;
    }

    /**
     * Sets the value of the filingDocketingStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalizedString }
     *     
     */
    public void setFilingDocketingStatusCode(NormalizedString value) {
        this.filingDocketingStatusCode = value;
    }

    /**
     * Gets the value of the filingReviewStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link NormalizedString }
     *     
     */
    public NormalizedString getFilingReviewStatusCode() {
        return filingReviewStatusCode;
    }

    /**
     * Sets the value of the filingReviewStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalizedString }
     *     
     */
    public void setFilingReviewStatusCode(NormalizedString value) {
        this.filingReviewStatusCode = value;
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
