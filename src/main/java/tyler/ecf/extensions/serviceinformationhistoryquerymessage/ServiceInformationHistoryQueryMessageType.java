
package tyler.ecf.extensions.serviceinformationhistoryquerymessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.proxy.xsd._2.String;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;


/**
 * A message requesting information history concerning the persons entitled to services of filings in a particular court case, together with the electronic addresses and message profiles of their Filing Assembly MDEs and their physical addresses if they are not currently using a Filing Assembly MDE.
 * 
 * &lt;p&gt;Java class for ServiceInformationHistoryQueryMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ServiceInformationHistoryQueryMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QueryMessageType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseTrackingID"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceInformationHistoryQueryMessageType", propOrder = {
    "caseTrackingID"
})
public class ServiceInformationHistoryQueryMessageType
    extends QueryMessageType
{

    @XmlElement(name = "CaseTrackingID", namespace = "http://niem.gov/niem/niem-core/2.0", required = true, nillable = true)
    protected String caseTrackingID;

    /**
     * Gets the value of the caseTrackingID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseTrackingID() {
        return caseTrackingID;
    }

    /**
     * Sets the value of the caseTrackingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseTrackingID(String value) {
        this.caseTrackingID = value;
    }

}
