
package tyler.ecf.v5_0.extensions.batchlistrequest;

import java.util.ArrayList;
import java.util.List;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.RequestMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Message to retrieve batches.
 * 
 * <p>Java class for GetBatchListMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetBatchListMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RequestMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:batchlistrequest}BatchListQueryCriteria"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:batchlistrequest}GetBatchListMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetBatchListMessageType", propOrder = {
    "batchListQueryCriteria",
    "getBatchListMessageAugmentationPoint"
})
public class GetBatchListMessageType
    extends RequestMessageType
{

    @XmlElement(name = "BatchListQueryCriteria", required = true)
    protected BatchListQueryCriteriaType batchListQueryCriteria;
    @XmlElement(name = "GetBatchListMessageAugmentationPoint")
    protected List<Object> getBatchListMessageAugmentationPoint;

    /**
     * Gets the value of the batchListQueryCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link BatchListQueryCriteriaType }
     *     
     */
    public BatchListQueryCriteriaType getBatchListQueryCriteria() {
        return batchListQueryCriteria;
    }

    /**
     * Sets the value of the batchListQueryCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchListQueryCriteriaType }
     *     
     */
    public void setBatchListQueryCriteria(BatchListQueryCriteriaType value) {
        this.batchListQueryCriteria = value;
    }

    /**
     * Gets the value of the getBatchListMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getBatchListMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetBatchListMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetBatchListMessageAugmentationPoint() {
        if (getBatchListMessageAugmentationPoint == null) {
            getBatchListMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getBatchListMessageAugmentationPoint;
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
