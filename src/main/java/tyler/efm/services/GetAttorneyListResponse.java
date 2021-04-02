
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.attorneylistresponse.AttorneyListResponseType;


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
 *         &amp;lt;element name="AttorneyListResponse" type="{urn:tyler:efm:services:schema:AttorneyListResponse}AttorneyListResponseType" minOccurs="0"/&amp;gt;
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
    "attorneyListResponse"
})
@XmlRootElement(name = "GetAttorneyListResponse")
public class GetAttorneyListResponse {

    @XmlElement(name = "AttorneyListResponse")
    protected AttorneyListResponseType attorneyListResponse;

    /**
     * Gets the value of the attorneyListResponse property.
     * 
     * @return
     *     possible object is
     *     {@link AttorneyListResponseType }
     *     
     */
    public AttorneyListResponseType getAttorneyListResponse() {
        return attorneyListResponse;
    }

    /**
     * Sets the value of the attorneyListResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttorneyListResponseType }
     *     
     */
    public void setAttorneyListResponse(AttorneyListResponseType value) {
        this.attorneyListResponse = value;
    }

}
