
package gov.niem.release.niem.domains.cbrn._4;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.codes.cbrncl._4.CredentialsAuthenticatedCodeType;
import gov.niem.release.niem.codes.cbrncl._4.MessageStatusCodeType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.MessageStatusAugmentationType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type to provide success or error feedback on a message that has been received.
 * 
 * <p>Java class for MessageStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageStatusType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/domains/cbrn/4.0/}SystemEventType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/cbrn/4.0/}CredentialsAuthenticatedCode"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/cbrn/4.0/}MessageStatusCode"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/cbrn/4.0/}MessageContentError" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/cbrn/4.0/}MessageHandlingError"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/cbrn/4.0/}ResendRequestIndicator"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/cbrn/4.0/}MessageStatusAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "MessageStatusType", propOrder = {
    "credentialsAuthenticatedCode",
    "messageStatusCode",
    "messageContentError",
    "messageHandlingError",
    "resendRequestIndicator",
    "messageStatusAugmentationPoint"
})
public class MessageStatusType
    extends SystemEventType
{

    @XmlElement(name = "CredentialsAuthenticatedCode", required = true)
    protected CredentialsAuthenticatedCodeType credentialsAuthenticatedCode;
    @XmlElement(name = "MessageStatusCode", required = true)
    protected MessageStatusCodeType messageStatusCode;
    @XmlElement(name = "MessageContentError")
    protected List<MessageContentErrorType> messageContentError;
    @XmlElement(name = "MessageHandlingError", required = true)
    protected MessageErrorType messageHandlingError;
    @XmlElement(name = "ResendRequestIndicator", required = true)
    protected Boolean resendRequestIndicator;
    @XmlElementRef(name = "MessageStatusAugmentationPoint", namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> messageStatusAugmentationPoint;

    /**
     * Gets the value of the credentialsAuthenticatedCode property.
     * 
     * @return
     *     possible object is
     *     {@link CredentialsAuthenticatedCodeType }
     *     
     */
    public CredentialsAuthenticatedCodeType getCredentialsAuthenticatedCode() {
        return credentialsAuthenticatedCode;
    }

    /**
     * Sets the value of the credentialsAuthenticatedCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CredentialsAuthenticatedCodeType }
     *     
     */
    public void setCredentialsAuthenticatedCode(CredentialsAuthenticatedCodeType value) {
        this.credentialsAuthenticatedCode = value;
    }

    /**
     * Gets the value of the messageStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link MessageStatusCodeType }
     *     
     */
    public MessageStatusCodeType getMessageStatusCode() {
        return messageStatusCode;
    }

    /**
     * Sets the value of the messageStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageStatusCodeType }
     *     
     */
    public void setMessageStatusCode(MessageStatusCodeType value) {
        this.messageStatusCode = value;
    }

    /**
     * Gets the value of the messageContentError property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the messageContentError property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageContentError().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MessageContentErrorType }
     * 
     * 
     */
    public List<MessageContentErrorType> getMessageContentError() {
        if (messageContentError == null) {
            messageContentError = new ArrayList<MessageContentErrorType>();
        }
        return this.messageContentError;
    }

    /**
     * Gets the value of the messageHandlingError property.
     * 
     * @return
     *     possible object is
     *     {@link MessageErrorType }
     *     
     */
    public MessageErrorType getMessageHandlingError() {
        return messageHandlingError;
    }

    /**
     * Sets the value of the messageHandlingError property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageErrorType }
     *     
     */
    public void setMessageHandlingError(MessageErrorType value) {
        this.messageHandlingError = value;
    }

    /**
     * Gets the value of the resendRequestIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getResendRequestIndicator() {
        return resendRequestIndicator;
    }

    /**
     * Sets the value of the resendRequestIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setResendRequestIndicator(Boolean value) {
        this.resendRequestIndicator = value;
    }

    /**
     * Gets the value of the messageStatusAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the messageStatusAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageStatusAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link MessageStatusAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getMessageStatusAugmentationPoint() {
        if (messageStatusAugmentationPoint == null) {
            messageStatusAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.messageStatusAugmentationPoint;
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
