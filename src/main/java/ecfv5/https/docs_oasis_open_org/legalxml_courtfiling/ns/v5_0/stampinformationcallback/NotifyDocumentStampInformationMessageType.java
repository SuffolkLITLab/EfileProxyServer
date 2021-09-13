
package ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.stampinformationcallback;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CallbackMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A response to a request for document stamping information.
 * 
 * <p>Java class for NotifyDocumentStampInformationMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotifyDocumentStampInformationMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CallbackMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/stampinformationcallback}NotifyDocumentStampInformationMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "NotifyDocumentStampInformationMessageType", propOrder = {
    "notifyDocumentStampInformationMessageAugmentationPoint"
})
public class NotifyDocumentStampInformationMessageType
    extends CallbackMessageType
{

    @XmlElement(name = "NotifyDocumentStampInformationMessageAugmentationPoint")
    protected List<Object> notifyDocumentStampInformationMessageAugmentationPoint;

    /**
     * Gets the value of the notifyDocumentStampInformationMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notifyDocumentStampInformationMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotifyDocumentStampInformationMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getNotifyDocumentStampInformationMessageAugmentationPoint() {
        if (notifyDocumentStampInformationMessageAugmentationPoint == null) {
            notifyDocumentStampInformationMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.notifyDocumentStampInformationMessageAugmentationPoint;
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
