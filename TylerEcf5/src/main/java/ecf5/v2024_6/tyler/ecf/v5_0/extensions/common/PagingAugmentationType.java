
package tyler.ecf.v5_0.extensions.common;

import gov.niem.release.niem.niem_core._4.NonNegativeDecimalType;
import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for PagingAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PagingAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}TotalResults" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}PageIndex" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}PageSize" minOccurs="0"/&gt;
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
@XmlType(name = "PagingAugmentationType", propOrder = {
    "totalResults",
    "pageIndex",
    "pageSize"
})
public class PagingAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "TotalResults")
    protected NonNegativeDecimalType totalResults;
    @XmlElement(name = "PageIndex")
    protected NonNegativeDecimalType pageIndex;
    @XmlElement(name = "PageSize")
    protected NonNegativeDecimalType pageSize;

    /**
     * Gets the value of the totalResults property.
     * 
     * @return
     *     possible object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public NonNegativeDecimalType getTotalResults() {
        return totalResults;
    }

    /**
     * Sets the value of the totalResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public void setTotalResults(NonNegativeDecimalType value) {
        this.totalResults = value;
    }

    /**
     * Gets the value of the pageIndex property.
     * 
     * @return
     *     possible object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public NonNegativeDecimalType getPageIndex() {
        return pageIndex;
    }

    /**
     * Sets the value of the pageIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public void setPageIndex(NonNegativeDecimalType value) {
        this.pageIndex = value;
    }

    /**
     * Gets the value of the pageSize property.
     * 
     * @return
     *     possible object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public NonNegativeDecimalType getPageSize() {
        return pageSize;
    }

    /**
     * Sets the value of the pageSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public void setPageSize(NonNegativeDecimalType value) {
        this.pageSize = value;
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
