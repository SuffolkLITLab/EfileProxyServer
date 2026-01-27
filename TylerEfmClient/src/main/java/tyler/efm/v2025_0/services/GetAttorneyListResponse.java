
package tyler.efm.v2025_0.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import tyler.efm.v2025_0.services.schema.attorneylistresponse.AttorneyListResponseType;

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
 *         &lt;element name="AttorneyListResponse" type="{urn:tyler:efm:services:schema:AttorneyListResponse}AttorneyListResponseType" minOccurs="0"/&gt;
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
