
package tyler.efm.latest.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.latest.services.schema.baseresponse.BaseResponseType;


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
 *         &lt;element name="AddUserRoleResponse" type="{urn:tyler:efm:services:schema:BaseResponse}BaseResponseType" minOccurs="0"/&gt;
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
    "addUserRoleResponse"
})
@XmlRootElement(name = "AddUserRoleResponse")
public class AddUserRoleResponse {

    @XmlElement(name = "AddUserRoleResponse")
    protected BaseResponseType addUserRoleResponse;

    /**
     * Gets the value of the addUserRoleResponse property.
     * 
     * @return
     *     possible object is
     *     {@link BaseResponseType }
     *     
     */
    public BaseResponseType getAddUserRoleResponse() {
        return addUserRoleResponse;
    }

    /**
     * Sets the value of the addUserRoleResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseResponseType }
     *     
     */
    public void setAddUserRoleResponse(BaseResponseType value) {
        this.addUserRoleResponse = value;
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
