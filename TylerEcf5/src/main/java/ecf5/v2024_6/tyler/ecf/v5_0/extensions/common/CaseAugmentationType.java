
package tyler.ecf.v5_0.extensions.common;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.AddressType;
import gov.niem.release.niem.niem_core._4.DateType;
import gov.niem.release.niem.niem_core._4.DispositionType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CaseAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CaseSubTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}StatusText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FiledDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}WillFiledDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}QuestionAnswer" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CalendarCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CaseAddress" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CaseSecurity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CaseEvent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}PartialWaiver" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CaseDisposition" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}HasUserFiledIntoCaseIndicator" minOccurs="0"/&gt;
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
@XmlType(name = "CaseAugmentationType", propOrder = {
    "caseSubTypeCode",
    "statusText",
    "filedDate",
    "willFiledDate",
    "questionAnswer",
    "calendarCode",
    "caseAddress",
    "caseSecurity",
    "caseEvent",
    "partialWaiver",
    "caseDisposition",
    "hasUserFiledIntoCaseIndicator"
})
public class CaseAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "CaseSubTypeCode")
    protected TextType caseSubTypeCode;
    @XmlElement(name = "StatusText", namespace = "http://release.niem.gov/niem/niem-core/4.0/")
    protected TextType statusText;
    @XmlElement(name = "FiledDate")
    protected DateType filedDate;
    @XmlElement(name = "WillFiledDate")
    protected DateType willFiledDate;
    @XmlElement(name = "QuestionAnswer")
    protected List<QuestionAnswerType> questionAnswer;
    @XmlElement(name = "CalendarCode")
    protected TextType calendarCode;
    @XmlElement(name = "CaseAddress")
    protected AddressType caseAddress;
    @XmlElement(name = "CaseSecurity")
    @XmlSchemaType(name = "token")
    protected CaseSecurityType caseSecurity;
    @XmlElement(name = "CaseEvent")
    protected List<CaseEventType> caseEvent;
    @XmlElement(name = "PartialWaiver")
    protected PartialWaiverType partialWaiver;
    @XmlElement(name = "CaseDisposition")
    protected DispositionType caseDisposition;
    @XmlElement(name = "HasUserFiledIntoCaseIndicator")
    protected Boolean hasUserFiledIntoCaseIndicator;

    /**
     * Gets the value of the caseSubTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCaseSubTypeCode() {
        return caseSubTypeCode;
    }

    /**
     * Sets the value of the caseSubTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCaseSubTypeCode(TextType value) {
        this.caseSubTypeCode = value;
    }

    /**
     * Gets the value of the statusText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getStatusText() {
        return statusText;
    }

    /**
     * Sets the value of the statusText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setStatusText(TextType value) {
        this.statusText = value;
    }

    /**
     * Gets the value of the filedDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getFiledDate() {
        return filedDate;
    }

    /**
     * Sets the value of the filedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setFiledDate(DateType value) {
        this.filedDate = value;
    }

    /**
     * Gets the value of the willFiledDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getWillFiledDate() {
        return willFiledDate;
    }

    /**
     * Sets the value of the willFiledDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setWillFiledDate(DateType value) {
        this.willFiledDate = value;
    }

    /**
     * Gets the value of the questionAnswer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the questionAnswer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuestionAnswer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuestionAnswerType }
     * 
     * 
     */
    public List<QuestionAnswerType> getQuestionAnswer() {
        if (questionAnswer == null) {
            questionAnswer = new ArrayList<QuestionAnswerType>();
        }
        return this.questionAnswer;
    }

    /**
     * Gets the value of the calendarCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCalendarCode() {
        return calendarCode;
    }

    /**
     * Sets the value of the calendarCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCalendarCode(TextType value) {
        this.calendarCode = value;
    }

    /**
     * Gets the value of the caseAddress property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getCaseAddress() {
        return caseAddress;
    }

    /**
     * Sets the value of the caseAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setCaseAddress(AddressType value) {
        this.caseAddress = value;
    }

    /**
     * Gets the value of the caseSecurity property.
     * 
     * @return
     *     possible object is
     *     {@link CaseSecurityType }
     *     
     */
    public CaseSecurityType getCaseSecurity() {
        return caseSecurity;
    }

    /**
     * Sets the value of the caseSecurity property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaseSecurityType }
     *     
     */
    public void setCaseSecurity(CaseSecurityType value) {
        this.caseSecurity = value;
    }

    /**
     * Gets the value of the caseEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseEventType }
     * 
     * 
     */
    public List<CaseEventType> getCaseEvent() {
        if (caseEvent == null) {
            caseEvent = new ArrayList<CaseEventType>();
        }
        return this.caseEvent;
    }

    /**
     * Gets the value of the partialWaiver property.
     * 
     * @return
     *     possible object is
     *     {@link PartialWaiverType }
     *     
     */
    public PartialWaiverType getPartialWaiver() {
        return partialWaiver;
    }

    /**
     * Sets the value of the partialWaiver property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartialWaiverType }
     *     
     */
    public void setPartialWaiver(PartialWaiverType value) {
        this.partialWaiver = value;
    }

    /**
     * Gets the value of the caseDisposition property.
     * 
     * @return
     *     possible object is
     *     {@link DispositionType }
     *     
     */
    public DispositionType getCaseDisposition() {
        return caseDisposition;
    }

    /**
     * Sets the value of the caseDisposition property.
     * 
     * @param value
     *     allowed object is
     *     {@link DispositionType }
     *     
     */
    public void setCaseDisposition(DispositionType value) {
        this.caseDisposition = value;
    }

    /**
     * Gets the value of the hasUserFiledIntoCaseIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getHasUserFiledIntoCaseIndicator() {
        return hasUserFiledIntoCaseIndicator;
    }

    /**
     * Sets the value of the hasUserFiledIntoCaseIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasUserFiledIntoCaseIndicator(Boolean value) {
        this.hasUserFiledIntoCaseIndicator = value;
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
