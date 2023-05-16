
package tyler.ecf.v5_0.extensions.batchcallback;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.DateType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.NonNegativeDecimalType;
import gov.niem.release.niem.proxy.xsd._4.NormalizedString;
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
 * The asynchronous message from the Filing Review MDE to the Filing Assembly MDE conveying information concerning the batch actions on the documents submitted for filing in a ReviewFilingMessage.
 * 
 * <p>Java class for NotifyBatchCompleteMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotifyBatchCompleteMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}SendingMDELocationID"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ServiceInteractionProfileCode"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentPostDate"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BatchStatus"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BatchIdentification"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BatchSize"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}HearingSchedule"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}Envelope" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:batchcallback}NotifyBatchCompleteMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotifyBatchCompleteMessageType", propOrder = {
    "sendingMDELocationID",
    "serviceInteractionProfileCode",
    "documentPostDate",
    "batchStatus",
    "batchIdentification",
    "batchSize",
    "hearingSchedule",
    "envelope",
    "notifyBatchCompleteMessageAugmentationPoint"
})
public class NotifyBatchCompleteMessageType {

    @XmlElement(name = "SendingMDELocationID", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", required = true)
    protected IdentificationType sendingMDELocationID;
    @XmlElement(name = "ServiceInteractionProfileCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", required = true)
    protected NormalizedString serviceInteractionProfileCode;
    @XmlElement(name = "DocumentPostDate", namespace = "http://release.niem.gov/niem/niem-core/4.0/", required = true)
    protected DateType documentPostDate;
    @XmlElement(name = "BatchStatus", namespace = "urn:tyler:ecf:v5.0:extensions:common", required = true)
    protected BatchStatusType batchStatus;
    @XmlElement(name = "BatchIdentification", namespace = "urn:tyler:ecf:v5.0:extensions:common", required = true)
    protected IdentificationType batchIdentification;
    @XmlElement(name = "BatchSize", namespace = "urn:tyler:ecf:v5.0:extensions:common", required = true)
    protected NonNegativeDecimalType batchSize;
    @XmlElement(name = "HearingSchedule", namespace = "urn:tyler:ecf:v5.0:extensions:common", required = true)
    protected CourtEventAugmentationType hearingSchedule;
    @XmlElement(name = "Envelope", namespace = "urn:tyler:ecf:v5.0:extensions:common")
    protected List<EnvelopeType> envelope;
    @XmlElement(name = "NotifyBatchCompleteMessageAugmentationPoint")
    protected List<Object> notifyBatchCompleteMessageAugmentationPoint;

    /**
     * Gets the value of the sendingMDELocationID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getSendingMDELocationID() {
        return sendingMDELocationID;
    }

    /**
     * Sets the value of the sendingMDELocationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setSendingMDELocationID(IdentificationType value) {
        this.sendingMDELocationID = value;
    }

    /**
     * Gets the value of the serviceInteractionProfileCode property.
     * 
     * @return
     *     possible object is
     *     {@link NormalizedString }
     *     
     */
    public NormalizedString getServiceInteractionProfileCode() {
        return serviceInteractionProfileCode;
    }

    /**
     * Sets the value of the serviceInteractionProfileCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalizedString }
     *     
     */
    public void setServiceInteractionProfileCode(NormalizedString value) {
        this.serviceInteractionProfileCode = value;
    }

    /**
     * Gets the value of the documentPostDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDocumentPostDate() {
        return documentPostDate;
    }

    /**
     * Sets the value of the documentPostDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDocumentPostDate(DateType value) {
        this.documentPostDate = value;
    }

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
     * Gets the value of the batchSize property.
     * 
     * @return
     *     possible object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public NonNegativeDecimalType getBatchSize() {
        return batchSize;
    }

    /**
     * Sets the value of the batchSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public void setBatchSize(NonNegativeDecimalType value) {
        this.batchSize = value;
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
     * Gets the value of the notifyBatchCompleteMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the notifyBatchCompleteMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotifyBatchCompleteMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getNotifyBatchCompleteMessageAugmentationPoint() {
        if (notifyBatchCompleteMessageAugmentationPoint == null) {
            notifyBatchCompleteMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.notifyBatchCompleteMessageAugmentationPoint;
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
