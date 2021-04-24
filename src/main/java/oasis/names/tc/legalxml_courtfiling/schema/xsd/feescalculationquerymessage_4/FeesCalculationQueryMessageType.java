
package oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationquerymessage_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.CoreFilingMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * This query is a request for the total amount of court fees required for filing of one or more documents in a case. 
 * 
 * &lt;p&gt;Java class for FeesCalculationQueryMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FeesCalculationQueryMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QueryMessageType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CoreFilingMessage-4.0}CoreFilingMessage"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeesCalculationQueryMessageType", propOrder = {
    "coreFilingMessage"
})
public class FeesCalculationQueryMessageType
    extends QueryMessageType
{

    @XmlElement(name = "CoreFilingMessage", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CoreFilingMessage-4.0", required = true)
    protected CoreFilingMessageType coreFilingMessage;

    /**
     * Gets the value of the coreFilingMessage property.
     * 
     * @return
     *     possible object is
     *     {@link CoreFilingMessageType }
     *     
     */
    public CoreFilingMessageType getCoreFilingMessage() {
        return coreFilingMessage;
    }

    /**
     * Sets the value of the coreFilingMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoreFilingMessageType }
     *     
     */
    public void setCoreFilingMessage(CoreFilingMessageType value) {
        this.coreFilingMessage = value;
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
