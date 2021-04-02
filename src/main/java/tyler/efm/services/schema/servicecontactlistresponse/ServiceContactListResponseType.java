
package tyler.efm.services.schema.servicecontactlistresponse;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.baseresponse.BaseResponseType;
import tyler.efm.services.schema.common.ServiceContactType;


/**
 * &lt;p&gt;Java class for ServiceContactListResponseType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ServiceContactListResponseType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:tyler:efm:services:schema:BaseResponse}BaseResponseType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ServiceContact" type="{urn:tyler:efm:services:schema:Common}ServiceContactType" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceContactListResponseType", propOrder = {
    "serviceContact"
})
public class ServiceContactListResponseType
    extends BaseResponseType
{

    @XmlElement(name = "ServiceContact")
    protected List<ServiceContactType> serviceContact;

    /**
     * Gets the value of the serviceContact property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the serviceContact property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getServiceContact().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceContactType }
     * 
     * 
     */
    public List<ServiceContactType> getServiceContact() {
        if (serviceContact == null) {
            serviceContact = new ArrayList<ServiceContactType>();
        }
        return this.serviceContact;
    }

}
