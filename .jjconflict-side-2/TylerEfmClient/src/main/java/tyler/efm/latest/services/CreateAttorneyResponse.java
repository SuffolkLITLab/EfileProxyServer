
package tyler.efm.latest.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import tyler.efm.latest.services.schema.createattorneyresponse.CreateAttorneyResponseType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


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
 *         &lt;element name="CreateAttorneyResponse" type="{urn:tyler:efm:services:schema:CreateAttorneyResponse}CreateAttorneyResponseType" minOccurs="0"/&gt;
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
    "createAttorneyResponse"
})
@XmlRootElement(name = "CreateAttorneyResponse")
public class CreateAttorneyResponse {

    @XmlElement(name = "CreateAttorneyResponse")
    protected CreateAttorneyResponseType createAttorneyResponse;

    /**
     * Gets the value of the createAttorneyResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CreateAttorneyResponseType }
     *     
     */
    public CreateAttorneyResponseType getCreateAttorneyResponse() {
        return createAttorneyResponse;
    }

    /**
     * Sets the value of the createAttorneyResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateAttorneyResponseType }
     *     
     */
    public void setCreateAttorneyResponse(CreateAttorneyResponseType value) {
        this.createAttorneyResponse = value;
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
