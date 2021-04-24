
package oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.domains.jxdm._4.StatuteType;
import gov.niem.niem.niem_core._2.IncidentType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * An act or behavior that would not constitute a crime if committed by an adult, which will subject a juvenile to adjudication as a delinquent by a court. Examples include truancy and refusal to abide by a parent's orders or direction.
 * 
 * &lt;p&gt;Java class for StatusOffenseActType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="StatusOffenseActType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}IncidentType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0}StatusOffenseActStatute"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusOffenseActType", propOrder = {
    "statusOffenseActStatute"
})
public class StatusOffenseActType
    extends IncidentType
{

    @XmlElement(name = "StatusOffenseActStatute", required = true)
    protected StatuteType statusOffenseActStatute;

    /**
     * Gets the value of the statusOffenseActStatute property.
     * 
     * @return
     *     possible object is
     *     {@link StatuteType }
     *     
     */
    public StatuteType getStatusOffenseActStatute() {
        return statusOffenseActStatute;
    }

    /**
     * Sets the value of the statusOffenseActStatute property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatuteType }
     *     
     */
    public void setStatusOffenseActStatute(StatuteType value) {
        this.statusOffenseActStatute = value;
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
