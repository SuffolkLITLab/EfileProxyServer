
package tyler.ecf.extensions.filingserviceresponsemessage;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A court's response to a FilingServiceQueryMessage.
 * 
 * <p>Java class for FilingServiceResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilingServiceResponseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QueryResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentIdentification"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:FilingServiceResponseMessage}ServiceContactIdentification"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}MailServiceIndicator"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}TrackingNumber" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:FilingServiceResponseMessage}SmtpLog" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
