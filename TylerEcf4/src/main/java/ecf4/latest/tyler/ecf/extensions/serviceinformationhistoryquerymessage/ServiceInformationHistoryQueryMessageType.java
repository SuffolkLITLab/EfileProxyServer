
package ecf4.latest.tyler.ecf.extensions.serviceinformationhistoryquerymessage;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A message requesting information history concerning the persons entitled to services of filings in a particular court case, together with the electronic addresses and message profiles of their Filing Assembly MDEs and their physical addresses if they are not currently using a Filing Assembly MDE.
 * 
 * <p>Java class for ServiceInformationHistoryQueryMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceInformationHistoryQueryMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QueryMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseTrackingID"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
    protected ecf4.latest.gov.niem.niem.proxy.xsd._2.String caseTrackingID;

    /**
     * Gets the value of the caseTrackingID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.latest.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public ecf4.latest.gov.niem.niem.proxy.xsd._2.String getCaseTrackingID() {
        return caseTrackingID;
    }

    /**
     * Sets the value of the caseTrackingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.latest.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setCaseTrackingID(ecf4.latest.gov.niem.niem.proxy.xsd._2.String value) {
        this.caseTrackingID = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
