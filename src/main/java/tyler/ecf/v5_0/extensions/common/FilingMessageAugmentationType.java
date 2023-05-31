
package tyler.ecf.v5_0.extensions.common;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.AmountType;
import gov.niem.release.niem.niem_core._4.DateType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for FilingMessageAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilingMessageAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}OriginalEnvelopeID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ParentEnvelope" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}AttachServiceContactIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilingParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilingAttorney" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ProcedureRemedy" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilerTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CrossReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}MaxFeeAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CivilAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}EstateAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}HearingSchedule" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}OutOfStateIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ReturnDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}Batch" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}Bulk" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ProviderCharge" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}EnvelopeLevelComment" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FeeSplit" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ReviewDate" minOccurs="0"/&gt;
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
@XmlType(name = "FilingMessageAugmentationType", propOrder = {
    "originalEnvelopeID",
    "parentEnvelope",
    "attachServiceContactIndicator",
    "filingParty",
    "filingAttorney",
    "procedureRemedy",
    "filerTypeCode",
    "crossReference",
    "maxFeeAmount",
    "civilAmount",
    "estateAmount",
    "hearingSchedule",
    "outOfStateIndicator",
    "returnDate",
    "batch",
    "bulk",
    "providerCharge",
    "envelopeLevelComment",
    "feeSplit",
    "reviewDate"
})
@XmlSeeAlso({
    DocumentStampInformationMessageAugmentationType.class,
    RecordDocketingMessageAugmentationType.class
})
public class FilingMessageAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "OriginalEnvelopeID")
    protected IdentificationType originalEnvelopeID;
    @XmlElement(name = "ParentEnvelope")
    protected ParentEnvelopeType parentEnvelope;
    @XmlElement(name = "AttachServiceContactIndicator")
    protected Boolean attachServiceContactIndicator;
    @XmlElement(name = "FilingParty")
    protected FilingPartyEntityType filingParty;
    @XmlElement(name = "FilingAttorney")
    protected FilingAttorneyEntityType filingAttorney;
    @XmlElement(name = "ProcedureRemedy")
    protected ProcedureRemedyType procedureRemedy;
    @XmlElement(name = "FilerTypeCode")
    protected TextType filerTypeCode;
    @XmlElement(name = "CrossReference")
    protected List<CrossReferenceType> crossReference;
    @XmlElement(name = "MaxFeeAmount")
    protected AmountType maxFeeAmount;
    @XmlElement(name = "CivilAmount")
    protected AmountType civilAmount;
    @XmlElement(name = "EstateAmount")
    protected AmountType estateAmount;
    @XmlElement(name = "HearingSchedule")
    protected CourtEventAugmentationType hearingSchedule;
    @XmlElement(name = "OutOfStateIndicator")
    protected Boolean outOfStateIndicator;
    @XmlElement(name = "ReturnDate")
    protected DateType returnDate;
    @XmlElement(name = "Batch")
    protected BatchTypeType batch;
    @XmlElement(name = "Bulk")
    protected BulkType bulk;
    @XmlElement(name = "ProviderCharge")
    protected ProviderChargeType providerCharge;
    @XmlElement(name = "EnvelopeLevelComment")
    protected TextType envelopeLevelComment;
    @XmlElement(name = "FeeSplit")
    protected List<FeeSplitType> feeSplit;
    @XmlElement(name = "ReviewDate")
    protected DateType reviewDate;

    /**
     * Gets the value of the originalEnvelopeID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getOriginalEnvelopeID() {
        return originalEnvelopeID;
    }

    /**
     * Sets the value of the originalEnvelopeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setOriginalEnvelopeID(IdentificationType value) {
        this.originalEnvelopeID = value;
    }

    /**
     * Gets the value of the parentEnvelope property.
     * 
     * @return
     *     possible object is
     *     {@link ParentEnvelopeType }
     *     
     */
    public ParentEnvelopeType getParentEnvelope() {
        return parentEnvelope;
    }

    /**
     * Sets the value of the parentEnvelope property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParentEnvelopeType }
     *     
     */
    public void setParentEnvelope(ParentEnvelopeType value) {
        this.parentEnvelope = value;
    }

    /**
     * Gets the value of the attachServiceContactIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getAttachServiceContactIndicator() {
        return attachServiceContactIndicator;
    }

    /**
     * Sets the value of the attachServiceContactIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAttachServiceContactIndicator(Boolean value) {
        this.attachServiceContactIndicator = value;
    }

    /**
     * Gets the value of the filingParty property.
     * 
     * @return
     *     possible object is
     *     {@link FilingPartyEntityType }
     *     
     */
    public FilingPartyEntityType getFilingParty() {
        return filingParty;
    }

    /**
     * Sets the value of the filingParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingPartyEntityType }
     *     
     */
    public void setFilingParty(FilingPartyEntityType value) {
        this.filingParty = value;
    }

    /**
     * Gets the value of the filingAttorney property.
     * 
     * @return
     *     possible object is
     *     {@link FilingAttorneyEntityType }
     *     
     */
    public FilingAttorneyEntityType getFilingAttorney() {
        return filingAttorney;
    }

    /**
     * Sets the value of the filingAttorney property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingAttorneyEntityType }
     *     
     */
    public void setFilingAttorney(FilingAttorneyEntityType value) {
        this.filingAttorney = value;
    }

    /**
     * Gets the value of the procedureRemedy property.
     * 
     * @return
     *     possible object is
     *     {@link ProcedureRemedyType }
     *     
     */
    public ProcedureRemedyType getProcedureRemedy() {
        return procedureRemedy;
    }

    /**
     * Sets the value of the procedureRemedy property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcedureRemedyType }
     *     
     */
    public void setProcedureRemedy(ProcedureRemedyType value) {
        this.procedureRemedy = value;
    }

    /**
     * Gets the value of the filerTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getFilerTypeCode() {
        return filerTypeCode;
    }

    /**
     * Sets the value of the filerTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setFilerTypeCode(TextType value) {
        this.filerTypeCode = value;
    }

    /**
     * Gets the value of the crossReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the crossReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCrossReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CrossReferenceType }
     * 
     * 
     */
    public List<CrossReferenceType> getCrossReference() {
        if (crossReference == null) {
            crossReference = new ArrayList<CrossReferenceType>();
        }
        return this.crossReference;
    }

    /**
     * Gets the value of the maxFeeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getMaxFeeAmount() {
        return maxFeeAmount;
    }

    /**
     * Sets the value of the maxFeeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setMaxFeeAmount(AmountType value) {
        this.maxFeeAmount = value;
    }

    /**
     * Gets the value of the civilAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getCivilAmount() {
        return civilAmount;
    }

    /**
     * Sets the value of the civilAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setCivilAmount(AmountType value) {
        this.civilAmount = value;
    }

    /**
     * Gets the value of the estateAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getEstateAmount() {
        return estateAmount;
    }

    /**
     * Sets the value of the estateAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setEstateAmount(AmountType value) {
        this.estateAmount = value;
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
     * Gets the value of the outOfStateIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getOutOfStateIndicator() {
        return outOfStateIndicator;
    }

    /**
     * Sets the value of the outOfStateIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOutOfStateIndicator(Boolean value) {
        this.outOfStateIndicator = value;
    }

    /**
     * Gets the value of the returnDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the value of the returnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setReturnDate(DateType value) {
        this.returnDate = value;
    }

    /**
     * Gets the value of the batch property.
     * 
     * @return
     *     possible object is
     *     {@link BatchTypeType }
     *     
     */
    public BatchTypeType getBatch() {
        return batch;
    }

    /**
     * Sets the value of the batch property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchTypeType }
     *     
     */
    public void setBatch(BatchTypeType value) {
        this.batch = value;
    }

    /**
     * Gets the value of the bulk property.
     * 
     * @return
     *     possible object is
     *     {@link BulkType }
     *     
     */
    public BulkType getBulk() {
        return bulk;
    }

    /**
     * Sets the value of the bulk property.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkType }
     *     
     */
    public void setBulk(BulkType value) {
        this.bulk = value;
    }

    /**
     * Gets the value of the providerCharge property.
     * 
     * @return
     *     possible object is
     *     {@link ProviderChargeType }
     *     
     */
    public ProviderChargeType getProviderCharge() {
        return providerCharge;
    }

    /**
     * Sets the value of the providerCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProviderChargeType }
     *     
     */
    public void setProviderCharge(ProviderChargeType value) {
        this.providerCharge = value;
    }

    /**
     * Gets the value of the envelopeLevelComment property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getEnvelopeLevelComment() {
        return envelopeLevelComment;
    }

    /**
     * Sets the value of the envelopeLevelComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setEnvelopeLevelComment(TextType value) {
        this.envelopeLevelComment = value;
    }

    /**
     * Gets the value of the feeSplit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the feeSplit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeeSplit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeeSplitType }
     * 
     * 
     */
    public List<FeeSplitType> getFeeSplit() {
        if (feeSplit == null) {
            feeSplit = new ArrayList<FeeSplitType>();
        }
        return this.feeSplit;
    }

    /**
     * Gets the value of the reviewDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getReviewDate() {
        return reviewDate;
    }

    /**
     * Sets the value of the reviewDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setReviewDate(DateType value) {
        this.reviewDate = value;
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
