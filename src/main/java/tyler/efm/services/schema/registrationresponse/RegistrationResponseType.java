
package tyler.efm.services.schema.registrationresponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import tyler.efm.services.schema.baseresponse.BaseResponseType;


/**
 * &lt;p&gt;Java class for RegistrationResponseType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="RegistrationResponseType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:tyler:efm:services:schema:BaseResponse}BaseResponseType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="FirmID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="PasswordHash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ActivationRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="ExpirationDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistrationResponseType", propOrder = {
    "userID",
    "firmID",
    "passwordHash",
    "activationRequired",
    "expirationDateTime"
})
public class RegistrationResponseType
    extends BaseResponseType
{

    @XmlElement(name = "UserID")
    protected String userID;
    @XmlElement(name = "FirmID")
    protected String firmID;
    @XmlElement(name = "PasswordHash")
    protected String passwordHash;
    @XmlElement(name = "ActivationRequired")
    protected boolean activationRequired;
    @XmlElement(name = "ExpirationDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationDateTime;

    /**
     * Gets the value of the userID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID(String value) {
        this.userID = value;
    }

    /**
     * Gets the value of the firmID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirmID() {
        return firmID;
    }

    /**
     * Sets the value of the firmID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirmID(String value) {
        this.firmID = value;
    }

    /**
     * Gets the value of the passwordHash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Sets the value of the passwordHash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPasswordHash(String value) {
        this.passwordHash = value;
    }

    /**
     * Gets the value of the activationRequired property.
     * 
     */
    public boolean isActivationRequired() {
        return activationRequired;
    }

    /**
     * Sets the value of the activationRequired property.
     * 
     */
    public void setActivationRequired(boolean value) {
        this.activationRequired = value;
    }

    /**
     * Gets the value of the expirationDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationDateTime() {
        return expirationDateTime;
    }

    /**
     * Sets the value of the expirationDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationDateTime(XMLGregorianCalendar value) {
        this.expirationDateTime = value;
    }

}
