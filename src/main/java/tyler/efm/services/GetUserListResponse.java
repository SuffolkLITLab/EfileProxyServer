
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.userlistresponse.UserListResponseType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="UserListResponse" type="{urn:tyler:efm:services:schema:UserListResponse}UserListResponseType" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userListResponse"
})
@XmlRootElement(name = "GetUserListResponse")
public class GetUserListResponse {

    @XmlElement(name = "UserListResponse")
    protected UserListResponseType userListResponse;

    /**
     * Gets the value of the userListResponse property.
     * 
     * @return
     *     possible object is
     *     {@link UserListResponseType }
     *     
     */
    public UserListResponseType getUserListResponse() {
        return userListResponse;
    }

    /**
     * Sets the value of the userListResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserListResponseType }
     *     
     */
    public void setUserListResponse(UserListResponseType value) {
        this.userListResponse = value;
    }

}
