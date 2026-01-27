
package tyler.efm.v2025_0.services.schema.common;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ServiceContactType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceContactType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MiddleName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AdministrativeCopy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Address" type="{urn:tyler:efm:services:schema:Common}AddressType" minOccurs="0"/&gt;
 *         &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsPublic" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="IsInFirmMasterList" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="IsUndeliverable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="IsMailServiceContact" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ServiceContactID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="FirmID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="FirmName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="AddByFirmName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceContactType", propOrder = {
    "firstName",
    "middleName",
    "lastName",
    "email",
    "administrativeCopy",
    "address",
    "phoneNumber",
    "isPublic",
    "isInFirmMasterList",
    "isUndeliverable",
    "isMailServiceContact"
})
public class ServiceContactType {

    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "MiddleName", required = true, nillable = true)
    protected String middleName;
    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "AdministrativeCopy")
    protected String administrativeCopy;
    @XmlElement(name = "Address")
    protected AddressType address;
    @XmlElement(name = "PhoneNumber")
    protected String phoneNumber;
    @XmlElementRef(name = "IsPublic", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> isPublic;
    @XmlElementRef(name = "IsInFirmMasterList", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> isInFirmMasterList;
    @XmlElementRef(name = "IsUndeliverable", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> isUndeliverable;
    @XmlElementRef(name = "IsMailServiceContact", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> isMailServiceContact;
    @XmlAttribute(name = "ServiceContactID")
    protected String serviceContactID;
    @XmlAttribute(name = "FirmID")
    protected String firmID;
    @XmlAttribute(name = "FirmName")
    protected String firmName;
    @XmlAttribute(name = "AddByFirmName")
    protected String addByFirmName;

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
     * Gets the value of the administrativeCopy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdministrativeCopy() {
        return administrativeCopy;
    }

    /**
     * Sets the value of the administrativeCopy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdministrativeCopy(String value) {
        this.administrativeCopy = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setAddress(AddressType value) {
        this.address = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the isPublic property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getIsPublic() {
        return isPublic;
    }

    /**
     * Sets the value of the isPublic property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setIsPublic(JAXBElement<Boolean> value) {
        this.isPublic = value;
    }

    /**
     * Gets the value of the isInFirmMasterList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getIsInFirmMasterList() {
        return isInFirmMasterList;
    }

    /**
     * Sets the value of the isInFirmMasterList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setIsInFirmMasterList(JAXBElement<Boolean> value) {
        this.isInFirmMasterList = value;
    }

    /**
     * Gets the value of the isUndeliverable property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getIsUndeliverable() {
        return isUndeliverable;
    }

    /**
     * Sets the value of the isUndeliverable property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setIsUndeliverable(JAXBElement<Boolean> value) {
        this.isUndeliverable = value;
    }

    /**
     * Gets the value of the isMailServiceContact property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getIsMailServiceContact() {
        return isMailServiceContact;
    }

    /**
     * Sets the value of the isMailServiceContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setIsMailServiceContact(JAXBElement<Boolean> value) {
        this.isMailServiceContact = value;
    }

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
     * Gets the value of the firmName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirmName() {
        return firmName;
    }

    /**
     * Sets the value of the firmName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirmName(String value) {
        this.firmName = value;
    }

    /**
     * Gets the value of the addByFirmName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddByFirmName() {
        return addByFirmName;
    }

    /**
     * Sets the value of the addByFirmName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddByFirmName(String value) {
        this.addByFirmName = value;
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
