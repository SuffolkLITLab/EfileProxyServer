
package ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.stampinformationcallback.NotifyDocumentStampInformationMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for NotifyDocumentStampInformationRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotifyDocumentStampInformationRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/stampinformationcallback}NotifyDocumentStampInformationMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotifyDocumentStampInformationRequestType", propOrder = {
    "notifyDocumentStampInformationMessage"
})
public class NotifyDocumentStampInformationRequestType {

    @XmlElement(name = "NotifyDocumentStampInformationMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/stampinformationcallback", required = true)
    protected NotifyDocumentStampInformationMessageType notifyDocumentStampInformationMessage;

    /**
     * Gets the value of the notifyDocumentStampInformationMessage property.
     * 
     * @return
     *     possible object is
     *     {@link NotifyDocumentStampInformationMessageType }
     *     
     */
    public NotifyDocumentStampInformationMessageType getNotifyDocumentStampInformationMessage() {
        return notifyDocumentStampInformationMessage;
    }

    /**
     * Sets the value of the notifyDocumentStampInformationMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotifyDocumentStampInformationMessageType }
     *     
     */
    public void setNotifyDocumentStampInformationMessage(NotifyDocumentStampInformationMessageType value) {
        this.notifyDocumentStampInformationMessage = value;
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
