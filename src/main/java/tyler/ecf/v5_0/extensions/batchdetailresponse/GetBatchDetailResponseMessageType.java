
package tyler.ecf.v5_0.extensions.batchdetailresponse;

import java.util.ArrayList;
import java.util.List;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ResponseMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.common.BatchStatusType;
import tyler.ecf.v5_0.extensions.common.CourtEventAugmentationType;
import tyler.ecf.v5_0.extensions.common.EnvelopeType;


/**
 * Message to return batch detail.
 * 
 * <p>Java class for GetBatchDetailResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetBatchDetailResponseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BatchStatus" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}HearingSchedule" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}Envelope" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:batchdetailresponse}GetBatchDetailResponseMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetBatchDetailResponseMessageType", propOrder = {
    "batchStatus",
    "hearingSchedule",
    "envelope",
    "getBatchDetailResponseMessageAugmentationPoint"
})
public class GetBatchDetailResponseMessageType
    extends ResponseMessageType
{

    @XmlElement(name = "BatchStatus", namespace = "urn:tyler:ecf:v5.0:extensions:common")
    protected BatchStatusType batchStatus;
    @XmlElement(name = "HearingSchedule", namespace = "urn:tyler:ecf:v5.0:extensions:common")
    protected CourtEventAugmentationType hearingSchedule;
    @XmlElement(name = "Envelope", namespace = "urn:tyler:ecf:v5.0:extensions:common")
    protected List<EnvelopeType> envelope;
    @XmlElement(name = "GetBatchDetailResponseMessageAugmentationPoint")
    protected List<Object> getBatchDetailResponseMessageAugmentationPoint;

    /**
     * Gets the value of the batchStatus property.
     * 
     * @return
     *     possible object is
     *     {@link BatchStatusType }
     *     
     */
    public BatchStatusType getBatchStatus() {
        return batchStatus;
    }

    /**
     * Sets the value of the batchStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchStatusType }
     *     
     */
    public void setBatchStatus(BatchStatusType value) {
        this.batchStatus = value;
    }

    /**
     * Gets the value of the hearingSchedule property.
     * 
     * @return
     *     possible object is
     *     {@link CourtEventAugmentationType }
     *     
     */
    public CourtEventAugmentationType getHearingSchedule() {
        return hearingSchedule;
    }

    /**
     * Sets the value of the hearingSchedule property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourtEventAugmentationType }
     *     
     */
    public void setHearingSchedule(CourtEventAugmentationType value) {
        this.hearingSchedule = value;
    }

    /**
     * Gets the value of the envelope property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the envelope property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnvelope().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnvelopeType }
     * 
     * 
     */
    public List<EnvelopeType> getEnvelope() {
        if (envelope == null) {
            envelope = new ArrayList<EnvelopeType>();
        }
        return this.envelope;
    }

    /**
     * Gets the value of the getBatchDetailResponseMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getBatchDetailResponseMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetBatchDetailResponseMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetBatchDetailResponseMessageAugmentationPoint() {
        if (getBatchDetailResponseMessageAugmentationPoint == null) {
            getBatchDetailResponseMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getBatchDetailResponseMessageAugmentationPoint;
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
