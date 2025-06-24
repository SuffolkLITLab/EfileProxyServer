
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.batchlistresponse;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.AmountType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.DateType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.NonNegativeDecimalType;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.BatchStatusType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.CourtEventAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.EnvelopeType;


/**
 * <p>Java class for BatchType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BatchIdentification"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BatchStatus"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}HearingSchedule" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentFiledDate"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}Envelope" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:batchlistresponse}BatchSize" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:batchlistresponse}TotalFees" minOccurs="0"/&gt;
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
@XmlType(name = "BatchType", propOrder = {
    "batchIdentification",
    "batchStatus",
    "hearingSchedule",
    "documentFiledDate",
    "envelope",
    "batchSize",
    "totalFees"
})
public class BatchType
    extends ObjectType
{

    @XmlElement(name = "BatchIdentification", namespace = "urn:tyler:ecf:v5.0:extensions:common", required = true)
    protected IdentificationType batchIdentification;
    @XmlElement(name = "BatchStatus", namespace = "urn:tyler:ecf:v5.0:extensions:common", required = true)
    protected BatchStatusType batchStatus;
    @XmlElement(name = "HearingSchedule", namespace = "urn:tyler:ecf:v5.0:extensions:common")
    protected CourtEventAugmentationType hearingSchedule;
    @XmlElement(name = "DocumentFiledDate", namespace = "http://release.niem.gov/niem/niem-core/4.0/", required = true)
    protected DateType documentFiledDate;
    @XmlElement(name = "Envelope", namespace = "urn:tyler:ecf:v5.0:extensions:common", required = true)
    protected List<EnvelopeType> envelope;
    @XmlElement(name = "BatchSize")
    protected NonNegativeDecimalType batchSize;
    @XmlElement(name = "TotalFees")
    protected AmountType totalFees;

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
     * Gets the value of the documentFiledDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDocumentFiledDate() {
        return documentFiledDate;
    }

    /**
     * Sets the value of the documentFiledDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDocumentFiledDate(DateType value) {
        this.documentFiledDate = value;
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
     * Gets the value of the totalFees property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getTotalFees() {
        return totalFees;
    }

    /**
     * Sets the value of the totalFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setTotalFees(AmountType value) {
        this.totalFees = value;
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
