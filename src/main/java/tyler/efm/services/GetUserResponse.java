
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.getuserresponse.GetUserResponseType;


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
 *         &amp;lt;element name="GetUserResponse" type="{urn:tyler:efm:services:schema:GetUserResponse}GetUserResponseType" minOccurs="0"/&amp;gt;
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
    "getUserResponse"
})
@XmlRootElement(name = "GetUserResponse")
public class GetUserResponse {

    @XmlElement(name = "GetUserResponse")
    protected GetUserResponseType getUserResponse;

    /**
     * Gets the value of the getUserResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GetUserResponseType }
     *     
     */
    public GetUserResponseType getGetUserResponse() {
        return getUserResponse;
    }

    /**
     * Sets the value of the getUserResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetUserResponseType }
     *     
     */
    public void setGetUserResponse(GetUserResponseType value) {
        this.getUserResponse = value;
    }

}
