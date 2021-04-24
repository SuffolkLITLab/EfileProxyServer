
package oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ElectronicFilingMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.CoreFilingMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.recorddocketingmessage_4.RecordDocketingMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Multi-part message type (required for conformance with WS-I Basic Profile 1.1
 * 
 * &lt;p&gt;Java class for RecordFilingRequestMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="RecordFilingRequestMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}ElectronicFilingMessageType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:RecordDocketingMessage-4.0}RecordDocketingMessage"/&amp;gt;
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
@XmlType(name = "RecordFilingRequestMessageType", propOrder = {
    "recordDocketingMessage",
    "coreFilingMessage"
})
public class RecordFilingRequestMessageType
    extends ElectronicFilingMessageType
{

    @XmlElement(name = "RecordDocketingMessage", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:RecordDocketingMessage-4.0", required = true)
    protected RecordDocketingMessageType recordDocketingMessage;
    @XmlElement(name = "CoreFilingMessage", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CoreFilingMessage-4.0", required = true)
    protected CoreFilingMessageType coreFilingMessage;

    /**
     * Gets the value of the recordDocketingMessage property.
     * 
     * @return
     *     possible object is
     *     {@link RecordDocketingMessageType }
     *     
     */
    public RecordDocketingMessageType getRecordDocketingMessage() {
        return recordDocketingMessage;
    }

    /**
     * Sets the value of the recordDocketingMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordDocketingMessageType }
     *     
     */
    public void setRecordDocketingMessage(RecordDocketingMessageType value) {
        this.recordDocketingMessage = value;
    }

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
