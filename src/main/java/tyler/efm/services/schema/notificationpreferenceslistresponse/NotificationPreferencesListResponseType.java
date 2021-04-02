
package tyler.efm.services.schema.notificationpreferenceslistresponse;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.baseresponse.BaseResponseType;
import tyler.efm.services.schema.common.NotificationListItemType;


/**
 * &lt;p&gt;Java class for NotificationPreferencesListResponseType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="NotificationPreferencesListResponseType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:tyler:efm:services:schema:BaseResponse}BaseResponseType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:efm:services:schema:Common}NotificationListItem" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotificationPreferencesListResponseType", propOrder = {
    "notificationListItem"
})
public class NotificationPreferencesListResponseType
    extends BaseResponseType
{

    @XmlElement(name = "NotificationListItem", namespace = "urn:tyler:efm:services:schema:Common")
    protected List<NotificationListItemType> notificationListItem;

    /**
     * Gets the value of the notificationListItem property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the notificationListItem property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getNotificationListItem().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link NotificationListItemType }
     * 
     * 
     */
    public List<NotificationListItemType> getNotificationListItem() {
        if (notificationListItem == null) {
            notificationListItem = new ArrayList<NotificationListItemType>();
        }
        return this.notificationListItem;
    }

}
