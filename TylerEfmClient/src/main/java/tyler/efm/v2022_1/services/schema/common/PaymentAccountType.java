
package tyler.efm.v2022_1.services.schema.common;

import java.util.ArrayList;
import java.util.List;
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
 * <p>Java class for PaymentAccountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentAccountType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PaymentAccountTypeCodeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="AccountToken" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="CardType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CardLast4" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="CardMonth" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="CardYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="CardHolderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="IsAvailableAtAllLocations" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="CourtIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="PaymentAccountID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="FirmID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="PaymentAccountTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentAccountType", propOrder = {
    "accountName",
    "paymentAccountTypeCodeId",
    "accountToken",
    "cardType",
    "cardLast4",
    "cardMonth",
    "cardYear",
    "cardHolderName",
    "active",
    "isAvailableAtAllLocations",
    "courtIdentifier"
})
public class PaymentAccountType {

    @XmlElement(name = "AccountName")
    protected String accountName;
    @XmlElementRef(name = "PaymentAccountTypeCodeId", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> paymentAccountTypeCodeId;
    @XmlElement(name = "AccountToken", required = true, nillable = true)
    protected String accountToken;
    @XmlElementRef(name = "CardType", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardType;
    @XmlElementRef(name = "CardLast4", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> cardLast4;
    @XmlElementRef(name = "CardMonth", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> cardMonth;
    @XmlElementRef(name = "CardYear", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> cardYear;
    @XmlElementRef(name = "CardHolderName", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardHolderName;
    @XmlElementRef(name = "Active", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> active;
    @XmlElementRef(name = "IsAvailableAtAllLocations", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> isAvailableAtAllLocations;
    @XmlElement(name = "CourtIdentifier", nillable = true)
    protected List<String> courtIdentifier;
    @XmlAttribute(name = "PaymentAccountID")
    protected String paymentAccountID;
    @XmlAttribute(name = "FirmID")
    protected String firmID;
    @XmlAttribute(name = "PaymentAccountTypeCode")
    protected String paymentAccountTypeCode;

    /**
     * Gets the value of the accountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the value of the accountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountName(String value) {
        this.accountName = value;
    }

    /**
     * Gets the value of the paymentAccountTypeCodeId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getPaymentAccountTypeCodeId() {
        return paymentAccountTypeCodeId;
    }

    /**
     * Sets the value of the paymentAccountTypeCodeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setPaymentAccountTypeCodeId(JAXBElement<Integer> value) {
        this.paymentAccountTypeCodeId = value;
    }

    /**
     * Gets the value of the accountToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountToken() {
        return accountToken;
    }

    /**
     * Sets the value of the accountToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountToken(String value) {
        this.accountToken = value;
    }

    /**
     * Gets the value of the cardType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardType() {
        return cardType;
    }

    /**
     * Sets the value of the cardType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardType(JAXBElement<String> value) {
        this.cardType = value;
    }

    /**
     * Gets the value of the cardLast4 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCardLast4() {
        return cardLast4;
    }

    /**
     * Sets the value of the cardLast4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCardLast4(JAXBElement<Integer> value) {
        this.cardLast4 = value;
    }

    /**
     * Gets the value of the cardMonth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCardMonth() {
        return cardMonth;
    }

    /**
     * Sets the value of the cardMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCardMonth(JAXBElement<Integer> value) {
        this.cardMonth = value;
    }

    /**
     * Gets the value of the cardYear property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCardYear() {
        return cardYear;
    }

    /**
     * Sets the value of the cardYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCardYear(JAXBElement<Integer> value) {
        this.cardYear = value;
    }

    /**
     * Gets the value of the cardHolderName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardHolderName() {
        return cardHolderName;
    }

    /**
     * Sets the value of the cardHolderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardHolderName(JAXBElement<String> value) {
        this.cardHolderName = value;
    }

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setActive(JAXBElement<Boolean> value) {
        this.active = value;
    }

    /**
     * Gets the value of the isAvailableAtAllLocations property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getIsAvailableAtAllLocations() {
        return isAvailableAtAllLocations;
    }

    /**
     * Sets the value of the isAvailableAtAllLocations property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setIsAvailableAtAllLocations(JAXBElement<Boolean> value) {
        this.isAvailableAtAllLocations = value;
    }

    /**
     * Gets the value of the courtIdentifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the courtIdentifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourtIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCourtIdentifier() {
        if (courtIdentifier == null) {
            courtIdentifier = new ArrayList<String>();
        }
        return this.courtIdentifier;
    }

    /**
     * Gets the value of the paymentAccountID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentAccountID() {
        return paymentAccountID;
    }

    /**
     * Sets the value of the paymentAccountID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentAccountID(String value) {
        this.paymentAccountID = value;
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
     * Gets the value of the paymentAccountTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentAccountTypeCode() {
        return paymentAccountTypeCode;
    }

    /**
     * Sets the value of the paymentAccountTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentAccountTypeCode(String value) {
        this.paymentAccountTypeCode = value;
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
