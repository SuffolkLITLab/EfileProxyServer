
package tyler.ecf.extensions.serviceinformationhistoryresponsemessage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.proxy.xsd._2.String;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;


/**
 * The response to a ServiceInformationHistoryQueryMessage, setting forth the requested extended information.
 * 
 * &lt;p&gt;Java class for ServiceInformationHistoryResponseMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ServiceInformationHistoryResponseMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QueryResponseMessageType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseTrackingID"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:ServiceInformationHistoryResponseMessage}ServiceRecipient" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceInformationHistoryResponseMessageType", propOrder = {
    "caseTrackingID",
    "serviceRecipient"
})
public class ServiceInformationHistoryResponseMessageType
    extends QueryResponseMessageType
{

    @XmlElement(name = "CaseTrackingID", namespace = "http://niem.gov/niem/niem-core/2.0", required = true, nillable = true)
    protected String caseTrackingID;
    @XmlElement(name = "ServiceRecipient")
    protected List<ServiceRecipientType> serviceRecipient;

    /**
     * Gets the value of the caseTrackingID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseTrackingID() {
        return caseTrackingID;
    }

    /**
     * Sets the value of the caseTrackingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseTrackingID(String value) {
        this.caseTrackingID = value;
    }

    /**
     * Gets the value of the serviceRecipient property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the serviceRecipient property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getServiceRecipient().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceRecipientType }
     * 
     * 
     */
    public List<ServiceRecipientType> getServiceRecipient() {
        if (serviceRecipient == null) {
            serviceRecipient = new ArrayList<ServiceRecipientType>();
        }
        return this.serviceRecipient;
    }

}
