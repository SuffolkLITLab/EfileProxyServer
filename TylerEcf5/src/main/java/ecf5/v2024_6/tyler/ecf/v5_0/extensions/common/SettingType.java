
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.common;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.domains.jxdm._6.CaseOfficialType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Boolean;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Date;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.DateTime;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for SettingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SettingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}HearingDate"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}HearingStartDateTime"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}HearingEndDateTime"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}IsCancelled" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CancellationCommentText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CancellationReasonCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CourtRoom" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}SessionName"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}CaseOfficial" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}RescheduleType" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}RescheduleReasonCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}RescheduleCommentText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CourtroomMinutes" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SettingType", propOrder = {
    "hearingDate",
    "hearingStartDateTime",
    "hearingEndDateTime",
    "isCancelled",
    "cancellationCommentText",
    "cancellationReasonCode",
    "courtRoom",
    "sessionName",
    "caseOfficial",
    "rescheduleType",
    "rescheduleReasonCode",
    "rescheduleCommentText",
    "courtroomMinutes"
})
public class SettingType {

    @XmlElement(name = "HearingDate", required = true)
    protected Date hearingDate;
    @XmlElement(name = "HearingStartDateTime", required = true)
    protected DateTime hearingStartDateTime;
    @XmlElement(name = "HearingEndDateTime", required = true)
    protected DateTime hearingEndDateTime;
    @XmlElement(name = "IsCancelled")
    protected Boolean isCancelled;
    @XmlElement(name = "CancellationCommentText")
    protected TextType cancellationCommentText;
    @XmlElement(name = "CancellationReasonCode")
    protected TextType cancellationReasonCode;
    @XmlElement(name = "CourtRoom")
    protected TextType courtRoom;
    @XmlElement(name = "SessionName", required = true)
    protected TextType sessionName;
    @XmlElement(name = "CaseOfficial", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/")
    protected List<CaseOfficialType> caseOfficial;
    @XmlElement(name = "RescheduleType")
    protected TextType rescheduleType;
    @XmlElement(name = "RescheduleReasonCode")
    protected TextType rescheduleReasonCode;
    @XmlElement(name = "RescheduleCommentText")
    protected TextType rescheduleCommentText;
    @XmlElement(name = "CourtroomMinutes")
    protected CourtroomMinutesType courtroomMinutes;

    /**
     * Gets the value of the hearingDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getHearingDate() {
        return hearingDate;
    }

    /**
     * Sets the value of the hearingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setHearingDate(Date value) {
        this.hearingDate = value;
    }

    /**
     * Gets the value of the hearingStartDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getHearingStartDateTime() {
        return hearingStartDateTime;
    }

    /**
     * Sets the value of the hearingStartDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setHearingStartDateTime(DateTime value) {
        this.hearingStartDateTime = value;
    }

    /**
     * Gets the value of the hearingEndDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getHearingEndDateTime() {
        return hearingEndDateTime;
    }

    /**
     * Sets the value of the hearingEndDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setHearingEndDateTime(DateTime value) {
        this.hearingEndDateTime = value;
    }

    /**
     * Gets the value of the isCancelled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIsCancelled() {
        return isCancelled;
    }

    /**
     * Sets the value of the isCancelled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCancelled(Boolean value) {
        this.isCancelled = value;
    }

    /**
     * Gets the value of the cancellationCommentText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCancellationCommentText() {
        return cancellationCommentText;
    }

    /**
     * Sets the value of the cancellationCommentText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCancellationCommentText(TextType value) {
        this.cancellationCommentText = value;
    }

    /**
     * Gets the value of the cancellationReasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCancellationReasonCode() {
        return cancellationReasonCode;
    }

    /**
     * Sets the value of the cancellationReasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCancellationReasonCode(TextType value) {
        this.cancellationReasonCode = value;
    }

    /**
     * Gets the value of the courtRoom property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCourtRoom() {
        return courtRoom;
    }

    /**
     * Sets the value of the courtRoom property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCourtRoom(TextType value) {
        this.courtRoom = value;
    }

    /**
     * Gets the value of the sessionName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getSessionName() {
        return sessionName;
    }

    /**
     * Sets the value of the sessionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setSessionName(TextType value) {
        this.sessionName = value;
    }

    /**
     * Gets the value of the caseOfficial property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseOfficial property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseOfficial().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseOfficialType }
     * 
     * 
     */
    public List<CaseOfficialType> getCaseOfficial() {
        if (caseOfficial == null) {
            caseOfficial = new ArrayList<CaseOfficialType>();
        }
        return this.caseOfficial;
    }

    /**
     * Gets the value of the rescheduleType property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getRescheduleType() {
        return rescheduleType;
    }

    /**
     * Sets the value of the rescheduleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setRescheduleType(TextType value) {
        this.rescheduleType = value;
    }

    /**
     * Gets the value of the rescheduleReasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getRescheduleReasonCode() {
        return rescheduleReasonCode;
    }

    /**
     * Sets the value of the rescheduleReasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setRescheduleReasonCode(TextType value) {
        this.rescheduleReasonCode = value;
    }

    /**
     * Gets the value of the rescheduleCommentText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getRescheduleCommentText() {
        return rescheduleCommentText;
    }

    /**
     * Sets the value of the rescheduleCommentText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setRescheduleCommentText(TextType value) {
        this.rescheduleCommentText = value;
    }

    /**
     * Gets the value of the courtroomMinutes property.
     * 
     * @return
     *     possible object is
     *     {@link CourtroomMinutesType }
     *     
     */
    public CourtroomMinutesType getCourtroomMinutes() {
        return courtroomMinutes;
    }

    /**
     * Sets the value of the courtroomMinutes property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourtroomMinutesType }
     *     
     */
    public void setCourtroomMinutes(CourtroomMinutesType value) {
        this.courtroomMinutes = value;
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
