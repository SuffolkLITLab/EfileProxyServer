
package ecf4.v2025_0.ietf.params.xml.ns.icalendar_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 *        status          = "STATUS" statparam ":" statvalue CRLF
 * 
 *        statparam       = *(";" other-param)
 * 
 *        statvalue       = (statvalue-event
 *                        /  statvalue-todo
 *                        /  statvalue-jour)
 * 
 *        statvalue-event = "TENTATIVE"    ;Indicates event is tentative.
 *                        / "CONFIRMED"    ;Indicates event is definite.
 *                        / "CANCELLED"    ;Indicates event was cancelled.
 *        ;Status values for a "VEVENT"
 * 
 *        statvalue-todo  = "NEEDS-ACTION" ;Indicates to-do needs action.
 *                        / "COMPLETED"    ;Indicates to-do completed.
 *                        / "IN-PROCESS"   ;Indicates to-do in process of.
 *                        / "CANCELLED"    ;Indicates to-do was cancelled.
 *        ;Status values for "VTODO".
 * 
 *        statvalue-jour  = "DRAFT"        ;Indicates journal is draft.
 *                        / "FINAL"        ;Indicates journal is final.
 *                        / "CANCELLED"    ;Indicates journal is removed.
 *       ;Status values for "VJOURNAL".
 *       
 * 
 * <p>Java class for StatusPropType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatusPropType"&gt;
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
@XmlType(name = "StatusPropType")
public class StatusPropType
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
