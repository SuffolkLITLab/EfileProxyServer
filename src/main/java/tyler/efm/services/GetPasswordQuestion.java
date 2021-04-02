
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.getpasswordquestionrequest.GetPasswordQuestionRequestType;


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
 *         &amp;lt;element name="GetPasswordQuestionRequest" type="{urn:tyler:efm:services:schema:GetPasswordQuestionRequest}GetPasswordQuestionRequestType" minOccurs="0"/&amp;gt;
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
    "getPasswordQuestionRequest"
})
@XmlRootElement(name = "GetPasswordQuestion")
public class GetPasswordQuestion {

    @XmlElement(name = "GetPasswordQuestionRequest")
    protected GetPasswordQuestionRequestType getPasswordQuestionRequest;

    /**
     * Gets the value of the getPasswordQuestionRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetPasswordQuestionRequestType }
     *     
     */
    public GetPasswordQuestionRequestType getGetPasswordQuestionRequest() {
        return getPasswordQuestionRequest;
    }

    /**
     * Sets the value of the getPasswordQuestionRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPasswordQuestionRequestType }
     *     
     */
    public void setGetPasswordQuestionRequest(GetPasswordQuestionRequestType value) {
        this.getPasswordQuestionRequest = value;
    }

}
