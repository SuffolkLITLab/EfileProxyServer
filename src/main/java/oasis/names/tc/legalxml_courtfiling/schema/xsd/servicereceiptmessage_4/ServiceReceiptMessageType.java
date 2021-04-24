
package oasis.names.tc.legalxml_courtfiling.schema.xsd.servicereceiptmessage_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A synchronous response by a Filing Assembly MDE acknowledging receipt of a service message for one of its clients.
 * 
 * &lt;p&gt;Java class for ServiceReceiptMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ServiceReceiptMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:MessageReceiptMessage-4.0}MessageReceiptMessageType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:ServiceReceiptMessage-4.0}ServiceRecipientStatus" maxOccurs="unbounded"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceReceiptMessageType", propOrder = {
    "serviceRecipientStatus"
})
public class ServiceReceiptMessageType
    extends MessageReceiptMessageType
{

    @XmlElement(name = "ServiceRecipientStatus", required = true)
    protected List<ServiceRecipientStatusType> serviceRecipientStatus;

    /**
     * Gets the value of the serviceRecipientStatus property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the serviceRecipientStatus property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getServiceRecipientStatus().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceRecipientStatusType }
     * 
     * 
     */
    public List<ServiceRecipientStatusType> getServiceRecipientStatus() {
        if (serviceRecipientStatus == null) {
            serviceRecipientStatus = new ArrayList<ServiceRecipientStatusType>();
        }
        return this.serviceRecipientStatus;
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
