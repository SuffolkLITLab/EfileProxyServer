
package tyler.ecf.extensions.filingserviceresponsemessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;


/**
 * A court's response to a FilingServiceQueryMessage.
 * 
 * &lt;p&gt;Java class for FilingServiceResponseMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FilingServiceResponseMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QueryResponseMessageType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentIdentification"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:FilingServiceResponseMessage}ServiceContactIdentification"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}MailServiceIndicator"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}TrackingNumber" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:FilingServiceResponseMessage}SmtpLog" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilingServiceResponseMessageType", propOrder = {
    "documentIdentification",
    "serviceContactIdentification",
    "mailServiceIndicator",
    "trackingNumber",
    "smtpLog"
})
public class FilingServiceResponseMessageType
    extends QueryResponseMessageType
{

    @XmlElement(name = "DocumentIdentification", namespace = "http://niem.gov/niem/niem-core/2.0", required = true, nillable = true)
    protected IdentificationType documentIdentification;
    @XmlElement(name = "ServiceContactIdentification", required = true)
    protected ServiceContactIdentificationType serviceContactIdentification;
    @XmlElement(name = "MailServiceIndicator", namespace = "urn:tyler:ecf:extensions:Common", required = true)
    protected Boolean mailServiceIndicator;
    @XmlElement(name = "TrackingNumber", namespace = "urn:tyler:ecf:extensions:Common")
    protected TextType trackingNumber;
    @XmlElement(name = "SmtpLog")
    protected TextType smtpLog;

    /**
     * Gets the value of the documentIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getDocumentIdentification() {
        return documentIdentification;
    }

    /**
     * Sets the value of the documentIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setDocumentIdentification(IdentificationType value) {
        this.documentIdentification = value;
    }

    /**
     * Gets the value of the serviceContactIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceContactIdentificationType }
     *     
     */
    public ServiceContactIdentificationType getServiceContactIdentification() {
        return serviceContactIdentification;
    }

    /**
     * Sets the value of the serviceContactIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceContactIdentificationType }
     *     
     */
    public void setServiceContactIdentification(ServiceContactIdentificationType value) {
        this.serviceContactIdentification = value;
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

    /**
     * Gets the value of the smtpLog property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getSmtpLog() {
        return smtpLog;
    }

    /**
     * Sets the value of the smtpLog property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setSmtpLog(TextType value) {
        this.smtpLog = value;
    }

}
