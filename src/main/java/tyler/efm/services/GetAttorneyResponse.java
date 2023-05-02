
package tyler.efm.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.services.schema.getattorneyresponse.GetAttorneyResponseType;


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
 *         &lt;element name="GetAttorneyResponse" type="{urn:tyler:efm:services:schema:GetAttorneyResponse}GetAttorneyResponseType" minOccurs="0"/&gt;
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
    "getAttorneyResponse"
})
@XmlRootElement(name = "GetAttorneyResponse")
public class GetAttorneyResponse {

    @XmlElement(name = "GetAttorneyResponse")
    protected GetAttorneyResponseType getAttorneyResponse;

    /**
     * Gets the value of the getAttorneyResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GetAttorneyResponseType }
     *     
     */
    public GetAttorneyResponseType getGetAttorneyResponse() {
        return getAttorneyResponse;
    }

    /**
     * Sets the value of the getAttorneyResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetAttorneyResponseType }
     *     
     */
    public void setGetAttorneyResponse(GetAttorneyResponseType value) {
        this.getAttorneyResponse = value;
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
