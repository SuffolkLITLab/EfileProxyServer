
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.getuserrequest.GetUserRequestType;


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
 *         &amp;lt;element name="GetUserRequest" type="{urn:tyler:efm:services:schema:GetUserRequest}GetUserRequestType" minOccurs="0"/&amp;gt;
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
    "getUserRequest"
})
@XmlRootElement(name = "GetUser")
public class GetUser {

    @XmlElement(name = "GetUserRequest")
    protected GetUserRequestType getUserRequest;

    /**
     * Gets the value of the getUserRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetUserRequestType }
     *     
     */
    public GetUserRequestType getGetUserRequest() {
        return getUserRequest;
    }

    /**
     * Sets the value of the getUserRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetUserRequestType }
     *     
     */
    public void setGetUserRequest(GetUserRequestType value) {
        this.getUserRequest = value;
    }

}
