
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.adduserrolerequest.AddUserRoleRequestType;


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
 *         &amp;lt;element name="AddUserRoleRequest" type="{urn:tyler:efm:services:schema:AddUserRoleRequest}AddUserRoleRequestType" minOccurs="0"/&amp;gt;
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
    "addUserRoleRequest"
})
@XmlRootElement(name = "AddUserRole")
public class AddUserRole {

    @XmlElement(name = "AddUserRoleRequest")
    protected AddUserRoleRequestType addUserRoleRequest;

    /**
     * Gets the value of the addUserRoleRequest property.
     * 
     * @return
     *     possible object is
     *     {@link AddUserRoleRequestType }
     *     
     */
    public AddUserRoleRequestType getAddUserRoleRequest() {
        return addUserRoleRequest;
    }

    /**
     * Sets the value of the addUserRoleRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddUserRoleRequestType }
     *     
     */
    public void setAddUserRoleRequest(AddUserRoleRequestType value) {
        this.addUserRoleRequest = value;
    }

}
