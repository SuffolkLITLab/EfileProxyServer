
package tyler.ecf.v5_0.extensions.batchdetailrequest;

import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.common.PagingAugmentationType;


/**
 * Criteria for select batch to be returned.
 * 
 * <p>Java class for BatchDetailQueryCriteriaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchDetailQueryCriteriaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BatchIdentification"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:batchdetailrequest}IncludeEnvelopeDetailsIndicator"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}PagingAugmentation"/&gt;
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
@XmlType(name = "BatchDetailQueryCriteriaType", propOrder = {
    "batchIdentification",
    "includeEnvelopeDetailsIndicator",
    "pagingAugmentation"
})
public class BatchDetailQueryCriteriaType
    extends ObjectType
{

    @XmlElement(name = "BatchIdentification", namespace = "urn:tyler:ecf:v5.0:extensions:common", required = true)
    protected IdentificationType batchIdentification;
    @XmlElement(name = "IncludeEnvelopeDetailsIndicator", required = true)
    protected Boolean includeEnvelopeDetailsIndicator;
    @XmlElement(name = "PagingAugmentation", namespace = "urn:tyler:ecf:v5.0:extensions:common", required = true)
    protected PagingAugmentationType pagingAugmentation;

    /**
     * Gets the value of the batchIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getBatchIdentification() {
        return batchIdentification;
    }

    /**
     * Sets the value of the batchIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setBatchIdentification(IdentificationType value) {
        this.batchIdentification = value;
    }

    /**
     * Gets the value of the includeEnvelopeDetailsIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIncludeEnvelopeDetailsIndicator() {
        return includeEnvelopeDetailsIndicator;
    }

    /**
     * Sets the value of the includeEnvelopeDetailsIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeEnvelopeDetailsIndicator(Boolean value) {
        this.includeEnvelopeDetailsIndicator = value;
    }

    /**
     * Gets the value of the pagingAugmentation property.
     * 
     * @return
     *     possible object is
     *     {@link PagingAugmentationType }
     *     
     */
    public PagingAugmentationType getPagingAugmentation() {
        return pagingAugmentation;
    }

    /**
     * Sets the value of the pagingAugmentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PagingAugmentationType }
     *     
     */
    public void setPagingAugmentation(PagingAugmentationType value) {
        this.pagingAugmentation = value;
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
