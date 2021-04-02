
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.getpubliclistrequest.GetPublicListRequestType;


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
 *         &amp;lt;element name="GetPublicListRequest" type="{urn:tyler:efm:services:schema:GetPublicListRequest}GetPublicListRequestType" minOccurs="0"/&amp;gt;
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

}
