
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.removeuserrolerequest.RemoveUserRoleRequestType;


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
 *         &amp;lt;element name="RemoveUserRoleRequest" type="{urn:tyler:efm:services:schema:RemoveUserRoleRequest}RemoveUserRoleRequestType" minOccurs="0"/&amp;gt;
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
    "removeUserRoleRequest"
})
@XmlRootElement(name = "RemoveUserRole")
public class RemoveUserRole {

    @XmlElement(name = "RemoveUserRoleRequest")
    protected RemoveUserRoleRequestType removeUserRoleRequest;

    /**
     * Gets the value of the removeUserRoleRequest property.
     * 
     * @return
     *     possible object is
     *     {@link RemoveUserRoleRequestType }
     *     
     */
    public RemoveUserRoleRequestType getRemoveUserRoleRequest() {
        return removeUserRoleRequest;
    }

    /**
     * Sets the value of the removeUserRoleRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemoveUserRoleRequestType }
     *     
     */
    public void setRemoveUserRoleRequest(RemoveUserRoleRequestType value) {
        this.removeUserRoleRequest = value;
    }

}
