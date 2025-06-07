
package ecf4.latest.ietf.params.xml.ns.icalendar_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 *        reltypeparam       = "RELTYPE" "="
 *                            ("PARENT"    ; Parent relationship - Default
 *                           / "CHILD"     ; Child relationship
 *                           / "SIBLING"   ; Sibling relationship
 *                           / iana-token  ; Some other IANA-registered
 *                                         ; iCalendar relationship type
 *                           / x-name)     ; A non-standard, experimental
 *                                         ; relationship type
 *         Ws-Calendar adds the values
 *                            / "FINISHTOSTART"
 *                            / "FINISHTOFINISH"
 *                            / "STARTTOFINISH"
 *                            / "STARTTOSTART"             
 *                            
 *        ; Default is PARENT
 *       
 * 
 * <p>Java class for ReltypeParamType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReltypeParamType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}TextParameterType"&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReltypeParamType")
public class ReltypeParamType
    extends TextParameterType
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
