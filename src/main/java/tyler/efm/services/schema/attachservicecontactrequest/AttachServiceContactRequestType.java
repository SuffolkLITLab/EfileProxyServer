
package tyler.efm.services.schema.attachservicecontactrequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.baserequest.BaseRequestType;


/**
 * &lt;p&gt;Java class for AttachServiceContactRequestType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="AttachServiceContactRequestType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:tyler:efm:services:schema:BaseRequest}BaseRequestType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="ServiceContactID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CaseID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CasePartyID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachServiceContactRequestType", propOrder = {
    "serviceContactID",
    "caseID",
    "casePartyID"
})
public class AttachServiceContactRequestType
    extends BaseRequestType
{

    @XmlElement(name = "ServiceContactID")
    protected String serviceContactID;
    @XmlElement(name = "CaseID")
    protected String caseID;
    @XmlElement(name = "CasePartyID")
    protected String casePartyID;

    /**
     * Gets the value of the serviceContactID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceContactID() {
        return serviceContactID;
    }

    /**
     * Sets the value of the serviceContactID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceContactID(String value) {
        this.serviceContactID = value;
    }

    /**
     * Gets the value of the caseID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseID() {
        return caseID;
    }

    /**
     * Sets the value of the caseID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseID(String value) {
        this.caseID = value;
    }

    /**
     * Gets the value of the casePartyID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCasePartyID() {
        return casePartyID;
    }

    /**
     * Sets the value of the casePartyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCasePartyID(String value) {
        this.casePartyID = value;
    }

}
