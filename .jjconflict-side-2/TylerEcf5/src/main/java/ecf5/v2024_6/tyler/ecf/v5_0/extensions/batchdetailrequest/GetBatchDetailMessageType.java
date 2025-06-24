
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.batchdetailrequest;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.RequestMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Message to retrieve batches.
 * 
 * <p>Java class for GetBatchDetailMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetBatchDetailMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RequestMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:batchdetailrequest}BatchDetailQueryCriteria"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:batchdetailrequest}GetBatchDetailMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetBatchDetailMessageType", propOrder = {
    "batchDetailQueryCriteria",
    "getBatchDetailMessageAugmentationPoint"
})
public class GetBatchDetailMessageType
    extends RequestMessageType
{

    @XmlElement(name = "BatchDetailQueryCriteria", required = true)
    protected BatchDetailQueryCriteriaType batchDetailQueryCriteria;
    @XmlElement(name = "GetBatchDetailMessageAugmentationPoint")
    protected List<Object> getBatchDetailMessageAugmentationPoint;

    /**
     * Gets the value of the batchDetailQueryCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link BatchDetailQueryCriteriaType }
     *     
     */
    public BatchDetailQueryCriteriaType getBatchDetailQueryCriteria() {
        return batchDetailQueryCriteria;
    }

    /**
     * Sets the value of the batchDetailQueryCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchDetailQueryCriteriaType }
     *     
     */
    public void setBatchDetailQueryCriteria(BatchDetailQueryCriteriaType value) {
        this.batchDetailQueryCriteria = value;
    }

    /**
     * Gets the value of the getBatchDetailMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getBatchDetailMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetBatchDetailMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetBatchDetailMessageAugmentationPoint() {
        if (getBatchDetailMessageAugmentationPoint == null) {
            getBatchDetailMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getBatchDetailMessageAugmentationPoint;
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
