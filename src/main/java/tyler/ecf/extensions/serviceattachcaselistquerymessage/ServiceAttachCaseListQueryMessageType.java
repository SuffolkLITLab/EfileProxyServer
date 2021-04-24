
package tyler.ecf.extensions.serviceattachcaselistquerymessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.IdentificationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;


/**
 * This is to get a list of cases attached to a Service Contact.
 * 
 * &lt;p&gt;Java class for ServiceAttachCaseListQueryMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ServiceAttachCaseListQueryMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QueryMessageType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:ServiceAttachCaseListQueryMessage}ServiceContactIdentification"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceAttachCaseListQueryMessageType", propOrder = {
    "serviceContactIdentification"
})
public class ServiceAttachCaseListQueryMessageType
    extends QueryMessageType
{

    @XmlElement(name = "ServiceContactIdentification", required = true)
    protected IdentificationType serviceContactIdentification;

    /**
     * Gets the value of the serviceContactIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getServiceContactIdentification() {
        return serviceContactIdentification;
    }

    /**
     * Sets the value of the serviceContactIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setServiceContactIdentification(IdentificationType value) {
        this.serviceContactIdentification = value;
    }

}
