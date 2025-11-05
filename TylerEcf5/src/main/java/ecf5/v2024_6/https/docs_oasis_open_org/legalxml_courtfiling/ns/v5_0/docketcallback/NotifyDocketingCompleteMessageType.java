
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.docketcallback;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CallbackMessageType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.NotifyDocketingCompleteMessageAugmentationType;


/**
 * The message returned from the Court Record MDE to the Filing Review MDE when the functions of entering information onto the docket or register of actions and commiting a filed document(s) to the official court record have been completed, conveying the results of those functions.
 * 
 * <p>Java class for NotifyDocketingCompleteMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotifyDocketingCompleteMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CallbackMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docketcallback}NotifyDocketingCompleteMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "NotifyDocketingCompleteMessageType", propOrder = {
    "notifyDocketingCompleteMessageAugmentationPoint"
})
public class NotifyDocketingCompleteMessageType
    extends CallbackMessageType
{

    @XmlElementRef(name = "NotifyDocketingCompleteMessageAugmentationPoint", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docketcallback", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> notifyDocketingCompleteMessageAugmentationPoint;

    /**
     * Gets the value of the notifyDocketingCompleteMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the notifyDocketingCompleteMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotifyDocketingCompleteMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link NotifyDocketingCompleteMessageAugmentationType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getNotifyDocketingCompleteMessageAugmentationPoint() {
        if (notifyDocketingCompleteMessageAugmentationPoint == null) {
            notifyDocketingCompleteMessageAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.notifyDocketingCompleteMessageAugmentationPoint;
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
