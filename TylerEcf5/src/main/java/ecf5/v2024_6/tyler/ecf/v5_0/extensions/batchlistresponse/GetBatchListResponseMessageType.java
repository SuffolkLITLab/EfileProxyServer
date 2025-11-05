
package tyler.ecf.v5_0.extensions.batchlistresponse;

import java.util.ArrayList;
import java.util.List;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ResponseMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Message to return batches.
 * 
 * <p>Java class for GetBatchListResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetBatchListResponseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:batchlistresponse}Batch" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:batchlistresponse}GetBatchListResponseMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetBatchListResponseMessageType", propOrder = {
    "batch",
    "getBatchListResponseMessageAugmentationPoint"
})
public class GetBatchListResponseMessageType
    extends ResponseMessageType
{

    @XmlElement(name = "Batch")
    protected List<BatchType> batch;
    @XmlElement(name = "GetBatchListResponseMessageAugmentationPoint")
    protected List<Object> getBatchListResponseMessageAugmentationPoint;

    /**
     * Gets the value of the batch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the batch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BatchType }
     * 
     * 
     */
    public List<BatchType> getBatch() {
        if (batch == null) {
            batch = new ArrayList<BatchType>();
        }
        return this.batch;
    }

    /**
     * Gets the value of the getBatchListResponseMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getBatchListResponseMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetBatchListResponseMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetBatchListResponseMessageAugmentationPoint() {
        if (getBatchListResponseMessageAugmentationPoint == null) {
            getBatchListResponseMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getBatchListResponseMessageAugmentationPoint;
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
