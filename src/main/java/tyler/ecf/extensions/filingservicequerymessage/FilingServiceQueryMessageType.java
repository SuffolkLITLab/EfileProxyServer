
package tyler.ecf.extensions.filingservicequerymessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.IdentificationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;


/**
 * This is query to get service smtp details by Filing Id/Service Contact Id.
 * 
 * &lt;p&gt;Java class for FilingServiceQueryMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FilingServiceQueryMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QueryMessageType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentIdentification"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:FilingServiceQueryMessage}ServiceContactIdentification"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilingServiceQueryMessageType", propOrder = {
    "documentIdentification",
    "serviceContactIdentification"
})
public class FilingServiceQueryMessageType
    extends QueryMessageType
{

    @XmlElement(name = "DocumentIdentification", namespace = "http://niem.gov/niem/niem-core/2.0", required = true, nillable = true)
    protected IdentificationType documentIdentification;
    @XmlElement(name = "ServiceContactIdentification", required = true)
    protected ServiceContactIdentificationType serviceContactIdentification;

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

}
