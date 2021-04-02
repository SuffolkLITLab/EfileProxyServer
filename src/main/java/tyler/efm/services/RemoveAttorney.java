
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.removeattorneyrequest.RemoveAttorneyRequestType;


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
 *         &amp;lt;element name="RemoveAttorneyRequest" type="{urn:tyler:efm:services:schema:RemoveAttorneyRequest}RemoveAttorneyRequestType" minOccurs="0"/&amp;gt;
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
    "removeAttorneyRequest"
})
@XmlRootElement(name = "RemoveAttorney")
public class RemoveAttorney {

    @XmlElement(name = "RemoveAttorneyRequest")
    protected RemoveAttorneyRequestType removeAttorneyRequest;

    /**
     * Gets the value of the removeAttorneyRequest property.
     * 
     * @return
     *     possible object is
     *     {@link RemoveAttorneyRequestType }
     *     
     */
    public RemoveAttorneyRequestType getRemoveAttorneyRequest() {
        return removeAttorneyRequest;
    }

    /**
     * Sets the value of the removeAttorneyRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemoveAttorneyRequestType }
     *     
     */
    public void setRemoveAttorneyRequest(RemoveAttorneyRequestType value) {
        this.removeAttorneyRequest = value;
    }

}
