
package ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.reviewfilingcallbackmessage_4;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ElectronicFilingCallbackMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The asynchronous message from the Filing Review MDE to the Filing Assembly MDE conveying information concerning the court's actions on the documents submitted for filing in a CoreFilingMessage.
 * 
 * <p>Java class for ReviewFilingCallbackMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReviewFilingCallbackMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}ElectronicFilingCallbackMessageType"&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReviewFilingCallbackMessageType")
public class ReviewFilingCallbackMessageType
    extends ElectronicFilingCallbackMessageType
{


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
