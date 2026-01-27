
package ecf4.v2025_0.ietf.params.xml.ns.icalendar_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 *        encodingparam      = "ENCODING" "="
 *                           ( "8BIT"
 *           ; "8bit" text encoding is defined in [RFC2045]
 *                           / "BASE64"
 *           ; "BASE64" binary encoding format is defined in [RFC4648]
 *                           )
 *       busytypevalue = "BUSY" 
 *                     / "BUSY-UNAVAILABLE" 
 *                     / "BUSY-TENTATIVE" 
 *                     / iana-token 
 *                     / x-name
 *                     
 *                     ; Default is "BUSY-UNAVAILABLE".
 *       
 * 
 * <p>Java class for BusytypePropType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusytypePropType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}TextPropertyType"&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusytypePropType")
public class BusytypePropType
    extends TextPropertyType
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
