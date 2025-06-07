
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.common;

import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.DateType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.OrganizationType;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for RecordDocketingMessageAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecordDocketingMessageAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:tyler:ecf:v5.0:extensions:common}FilingMessageAugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}DocketDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilingProvider" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}WaiverIndicator" minOccurs="0"/&gt;
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
@XmlType(name = "RecordDocketingMessageAugmentationType", propOrder = {
    "docketDate",
    "filingProvider",
    "waiverIndicator"
})
public class RecordDocketingMessageAugmentationType
    extends FilingMessageAugmentationType
{

    @XmlElement(name = "DocketDate")
    protected DateType docketDate;
    @XmlElement(name = "FilingProvider")
    protected OrganizationType filingProvider;
    @XmlElement(name = "WaiverIndicator")
    protected Boolean waiverIndicator;

    /**
     * Gets the value of the docketDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDocketDate() {
        return docketDate;
    }

    /**
     * Sets the value of the docketDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDocketDate(DateType value) {
        this.docketDate = value;
    }

    /**
     * Gets the value of the filingProvider property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationType }
     *     
     */
    public OrganizationType getFilingProvider() {
        return filingProvider;
    }

    /**
     * Sets the value of the filingProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationType }
     *     
     */
    public void setFilingProvider(OrganizationType value) {
        this.filingProvider = value;
    }

    /**
     * Gets the value of the waiverIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getWaiverIndicator() {
        return waiverIndicator;
    }

    /**
     * Sets the value of the waiverIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWaiverIndicator(Boolean value) {
        this.waiverIndicator = value;
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
