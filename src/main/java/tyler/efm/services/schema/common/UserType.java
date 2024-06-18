
package tyler.efm.services.schema.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for UserType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MiddleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LastLoginDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="Role" type="{urn:tyler:efm:services:schema:Common}RoleLocationType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="RestrictFiling" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="RestrictFilingComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsUndeliverable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="NotificationContact" type="{urn:tyler:efm:services:schema:Common}NotificationContactType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="UserID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="FirmID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="IsApproved" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="IsActive" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="IsActivated" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="IsLockedOut" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserType", propOrder = {
    "email",
    "firstName",
    "middleName",
    "lastName",
    "lastLoginDate",
    "role",
    "restrictFiling",
    "restrictFilingComment",
    "isUndeliverable",
    "notificationContact",
    "status"
})
public class UserType {

    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "MiddleName")
    protected String middleName;
    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "LastLoginDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastLoginDate;
    @XmlElement(name = "Role")
    protected List<RoleLocationType> role;
    @XmlElement(name = "RestrictFiling")
    protected boolean restrictFiling;
    @XmlElement(name = "RestrictFilingComment")
    protected String restrictFilingComment;
    @XmlElementRef(name = "IsUndeliverable", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> isUndeliverable;
    @XmlElement(name = "NotificationContact")
    protected List<NotificationContactType> notificationContact;
    @XmlElement(name = "Status")
    protected String status;
    @XmlAttribute(name = "UserID")
    protected String userID;
    @XmlAttribute(name = "FirmID")
    protected String firmID;
    @XmlAttribute(name = "IsApproved", required = true)
    protected boolean isApproved;
    @XmlAttribute(name = "IsActive", required = true)
    protected boolean isActive;
    @XmlAttribute(name = "IsActivated", required = true)
    protected boolean isActivated;
    @XmlAttribute(name = "IsLockedOut", required = true)
    protected boolean isLockedOut;

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
     * Gets the value of the lastLoginDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * Sets the value of the lastLoginDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastLoginDate(XMLGregorianCalendar value) {
        this.lastLoginDate = value;
    }

    /**
     * Gets the value of the role property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the role property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoleLocationType }
     * 
     * 
     */
    public List<RoleLocationType> getRole() {
        if (role == null) {
            role = new ArrayList<RoleLocationType>();
        }
        return this.role;
    }

    /**
     * Gets the value of the restrictFiling property.
     * 
     */
    public boolean isRestrictFiling() {
        return restrictFiling;
    }

    /**
     * Sets the value of the restrictFiling property.
     * 
     */
    public void setRestrictFiling(boolean value) {
        this.restrictFiling = value;
    }

    /**
     * Gets the value of the restrictFilingComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRestrictFilingComment() {
        return restrictFilingComment;
    }

    /**
     * Sets the value of the restrictFilingComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRestrictFilingComment(String value) {
        this.restrictFilingComment = value;
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
     * Gets the value of the notificationContact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the notificationContact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotificationContact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NotificationContactType }
     * 
     * 
     */
    public List<NotificationContactType> getNotificationContact() {
        if (notificationContact == null) {
            notificationContact = new ArrayList<NotificationContactType>();
        }
        return this.notificationContact;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

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
     * Gets the value of the isApproved property.
     * 
     */
    public boolean isIsApproved() {
        return isApproved;
    }

    /**
     * Sets the value of the isApproved property.
     * 
     */
    public void setIsApproved(boolean value) {
        this.isApproved = value;
    }

    /**
     * Gets the value of the isActive property.
     * 
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     */
    public void setIsActive(boolean value) {
        this.isActive = value;
    }

    /**
     * Gets the value of the isActivated property.
     * 
     */
    public boolean isIsActivated() {
        return isActivated;
    }

    /**
     * Sets the value of the isActivated property.
     * 
     */
    public void setIsActivated(boolean value) {
        this.isActivated = value;
    }

    /**
     * Gets the value of the isLockedOut property.
     * 
     */
    public boolean isIsLockedOut() {
        return isLockedOut;
    }

    /**
     * Sets the value of the isLockedOut property.
     * 
     */
    public void setIsLockedOut(boolean value) {
        this.isLockedOut = value;
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
