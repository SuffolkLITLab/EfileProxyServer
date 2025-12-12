
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.servicecallback;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.DateType;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CallbackMessageType;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ElectronicServiceInformationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.RecipientInformationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.SubmitterInformationType;


/**
 * The asynchronous message from the Filing Review MDE to the Filing Assembly MDE conveying information concerning the service actions on the documents submitted for filing in a ReviewFilingMessage.
 * 
 * <p>Java class for NotifyServiceCompleteMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotifyServiceCompleteMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CallbackMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ElectronicServiceInformation"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ServiceDate"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}SubmitterInformation"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}RecipientInformation"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:servicecallback}NotifyServiceCompleteMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "NotifyServiceCompleteMessageType", propOrder = {
    "electronicServiceInformation",
    "serviceDate",
    "submitterInformation",
    "recipientInformation",
    "notifyServiceCompleteMessageAugmentationPoint"
})
public class NotifyServiceCompleteMessageType
    extends CallbackMessageType
{

    @XmlElement(name = "ElectronicServiceInformation", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", required = true)
    protected ElectronicServiceInformationType electronicServiceInformation;
    @XmlElement(name = "ServiceDate", namespace = "urn:tyler:ecf:v5.0:extensions:common", required = true)
    protected DateType serviceDate;
    @XmlElement(name = "SubmitterInformation", namespace = "urn:tyler:ecf:v5.0:extensions:common", required = true)
    protected SubmitterInformationType submitterInformation;
    @XmlElement(name = "RecipientInformation", namespace = "urn:tyler:ecf:v5.0:extensions:common", required = true)
    protected RecipientInformationType recipientInformation;
    @XmlElement(name = "NotifyServiceCompleteMessageAugmentationPoint")
    protected List<Object> notifyServiceCompleteMessageAugmentationPoint;

    /**
     * Gets the value of the electronicServiceInformation property.
     * 
     * @return
     *     possible object is
     *     {@link ElectronicServiceInformationType }
     *     
     */
    public ElectronicServiceInformationType getElectronicServiceInformation() {
        return electronicServiceInformation;
    }

    /**
     * Sets the value of the electronicServiceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElectronicServiceInformationType }
     *     
     */
    public void setElectronicServiceInformation(ElectronicServiceInformationType value) {
        this.electronicServiceInformation = value;
    }

    /**
     * Gets the value of the serviceDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getServiceDate() {
        return serviceDate;
    }

    /**
     * Sets the value of the serviceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setServiceDate(DateType value) {
        this.serviceDate = value;
    }

    /**
     * Gets the value of the submitterInformation property.
     * 
     * @return
     *     possible object is
     *     {@link SubmitterInformationType }
     *     
     */
    public SubmitterInformationType getSubmitterInformation() {
        return submitterInformation;
    }

    /**
     * Sets the value of the submitterInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubmitterInformationType }
     *     
     */
    public void setSubmitterInformation(SubmitterInformationType value) {
        this.submitterInformation = value;
    }

    /**
     * Gets the value of the recipientInformation property.
     * 
     * @return
     *     possible object is
     *     {@link RecipientInformationType }
     *     
     */
    public RecipientInformationType getRecipientInformation() {
        return recipientInformation;
    }

    /**
     * Sets the value of the recipientInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecipientInformationType }
     *     
     */
    public void setRecipientInformation(RecipientInformationType value) {
        this.recipientInformation = value;
    }

    /**
     * Gets the value of the notifyServiceCompleteMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the notifyServiceCompleteMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotifyServiceCompleteMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getNotifyServiceCompleteMessageAugmentationPoint() {
        if (notifyServiceCompleteMessageAugmentationPoint == null) {
            notifyServiceCompleteMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.notifyServiceCompleteMessageAugmentationPoint;
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
