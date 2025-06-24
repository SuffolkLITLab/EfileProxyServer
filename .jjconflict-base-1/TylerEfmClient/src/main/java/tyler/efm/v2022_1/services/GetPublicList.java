
package tyler.efm.v2022_1.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.v2022_1.services.schema.getpubliclistrequest.GetPublicListRequestType;


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
 *         &lt;element name="GetPublicListRequest" type="{urn:tyler:efm:services:schema:GetPublicListRequest}GetPublicListRequestType" minOccurs="0"/&gt;
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
    "getPublicListRequest"
})
@XmlRootElement(name = "GetPublicList")
public class GetPublicList {

    @XmlElement(name = "GetPublicListRequest")
    protected GetPublicListRequestType getPublicListRequest;

    /**
     * Gets the value of the getPublicListRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetPublicListRequestType }
     *     
     */
    public GetPublicListRequestType getGetPublicListRequest() {
        return getPublicListRequest;
    }

    /**
     * Sets the value of the getPublicListRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPublicListRequestType }
     *     
     */
    public void setGetPublicListRequest(GetPublicListRequestType value) {
        this.getPublicListRequest = value;
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
