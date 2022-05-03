
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.services.schema.getuserresponse.GetUserResponseType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetUserResponse" type="{urn:tyler:efm:services:schema:GetUserResponse}GetUserResponseType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
