
package tyler.efm.v2022_1.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.v2022_1.services.schema.getfirmresponse.GetFirmResponseType;


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
 *         &lt;element name="GetFirmResponse" type="{urn:tyler:efm:services:schema:GetFirmResponse}GetFirmResponseType" minOccurs="0"/&gt;
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
    "getFirmResponse"
})
@XmlRootElement(name = "GetFirmResponse")
public class GetFirmResponse {

    @XmlElement(name = "GetFirmResponse")
    protected GetFirmResponseType getFirmResponse;

    /**
     * Gets the value of the getFirmResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GetFirmResponseType }
     *     
     */
    public GetFirmResponseType getGetFirmResponse() {
        return getFirmResponse;
    }

    /**
     * Sets the value of the getFirmResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFirmResponseType }
     *     
     */
    public void setGetFirmResponse(GetFirmResponseType value) {
        this.getFirmResponse = value;
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
