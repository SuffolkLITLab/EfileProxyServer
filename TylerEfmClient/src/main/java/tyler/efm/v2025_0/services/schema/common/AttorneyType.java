
package tyler.efm.v2025_0.services.schema.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for AttorneyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttorneyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BarNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MiddleName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="AttorneyID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="FirmID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttorneyType", propOrder = {
    "barNumber",
    "firstName",
    "middleName",
    "lastName",
    "email"
})
public class AttorneyType {

    @XmlElement(name = "BarNumber")
    protected String barNumber;
    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "MiddleName", required = true, nillable = true)
    protected String middleName;
    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "Email", required = true, nillable = true)
    protected String email;
    @XmlAttribute(name = "AttorneyID")
    protected String attorneyID;
    @XmlAttribute(name = "FirmID")
    protected String firmID;

    /**
     * Gets the value of the barNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarNumber() {
        return barNumber;
    }

    /**
     * Sets the value of the barNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarNumber(String value) {
        this.barNumber = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the middleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the value of the middleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiddleName(String value) {
        this.middleName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the attorneyID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttorneyID() {
        return attorneyID;
    }

    /**
     * Sets the value of the attorneyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttorneyID(String value) {
        this.attorneyID = value;
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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
