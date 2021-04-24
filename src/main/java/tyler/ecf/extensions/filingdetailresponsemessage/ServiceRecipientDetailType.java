
package tyler.ecf.extensions.filingdetailresponsemessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.StatusType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;


/**
 * A value describing the status of electronic service on a particular recipient.
 * 
 * &lt;p&gt;Java class for ServiceRecipientDetailType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ServiceRecipientDetailType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}StatusType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}ServiceRecipientID"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:FilingDetailResponseMessage}StatusCode"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:FilingDetailResponseMessage}ServedRecipient"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}FirmName"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:FilingDetailResponseMessage}IsOpened"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:FilingDetailResponseMessage}ServedDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:FilingDetailResponseMessage}OpenedDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}MailServiceIndicator"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}TrackingNumber" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceRecipientDetailType", propOrder = {
    "serviceRecipientID",
    "statusCode",
    "servedRecipient",
    "firmName",
    "isOpened",
    "servedDate",
    "openedDate",
    "mailServiceIndicator",
    "trackingNumber"
})
public class ServiceRecipientDetailType
    extends StatusType
{

    @XmlElement(name = "ServiceRecipientID", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", required = true)
    protected IdentificationType serviceRecipientID;
    @XmlElement(name = "StatusCode", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String statusCode;
    @XmlElement(name = "ServedRecipient", required = true)
    protected EntityType servedRecipient;
    @XmlElement(name = "FirmName", namespace = "urn:tyler:ecf:extensions:Common", required = true)
    protected TextType firmName;
    @XmlElement(name = "IsOpened")
    protected boolean isOpened;
    @XmlElement(name = "ServedDate")
    protected DateType servedDate;
    @XmlElement(name = "OpenedDate")
    protected DateType openedDate;
    @XmlElement(name = "MailServiceIndicator", namespace = "urn:tyler:ecf:extensions:Common", required = true)
    protected Boolean mailServiceIndicator;
    @XmlElement(name = "TrackingNumber", namespace = "urn:tyler:ecf:extensions:Common")
    protected TextType trackingNumber;

    /**
     * Gets the value of the serviceRecipientID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getServiceRecipientID() {
        return serviceRecipientID;
    }

    /**
     * Sets the value of the serviceRecipientID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setServiceRecipientID(IdentificationType value) {
        this.serviceRecipientID = value;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCode(String value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the servedRecipient property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getServedRecipient() {
        return servedRecipient;
    }

    /**
     * Sets the value of the servedRecipient property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setServedRecipient(EntityType value) {
        this.servedRecipient = value;
    }

    /**
     * Gets the value of the firmName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getFirmName() {
        return firmName;
    }

    /**
     * Sets the value of the firmName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setFirmName(TextType value) {
        this.firmName = value;
    }

    /**
     * Gets the value of the isOpened property.
     * 
     */
    public boolean isIsOpened() {
        return isOpened;
    }

    /**
     * Sets the value of the isOpened property.
     * 
     */
    public void setIsOpened(boolean value) {
        this.isOpened = value;
    }

    /**
     * Gets the value of the servedDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getServedDate() {
        return servedDate;
    }

    /**
     * Sets the value of the servedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setServedDate(DateType value) {
        this.servedDate = value;
    }

    /**
     * Gets the value of the openedDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getOpenedDate() {
        return openedDate;
    }

    /**
     * Sets the value of the openedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setOpenedDate(DateType value) {
        this.openedDate = value;
    }

    /**
     * Gets the value of the mailServiceIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getMailServiceIndicator() {
        return mailServiceIndicator;
    }

    /**
     * Sets the value of the mailServiceIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMailServiceIndicator(Boolean value) {
        this.mailServiceIndicator = value;
    }

    /**
     * Gets the value of the trackingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * Sets the value of the trackingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setTrackingNumber(TextType value) {
        this.trackingNumber = value;
    }

}
