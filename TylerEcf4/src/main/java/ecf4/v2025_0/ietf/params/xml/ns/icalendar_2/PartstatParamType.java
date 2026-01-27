
package ecf4.v2025_0.ietf.params.xml.ns.icalendar_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 *        partstat-event   = ("NEEDS-ACTION"    ; Event needs action
 *                         / "ACCEPTED"         ; Event accepted
 *                         / "DECLINED"         ; Event declined
 *                         / "TENTATIVE"        ; Event tentatively
 *                                              ; accepted
 *                         / "DELEGATED"        ; Event delegated
 *                         / x-name             ; Experimental status
 *                         / iana-token)        ; Other IANA-registered
 *                                              ; status
 *        ; These are the participation statuses for a "VEVENT".
 *        ; Default is NEEDS-ACTION.
 * 
 *        partstat-todo    = ("NEEDS-ACTION"    ; To-do needs action
 *                         / "ACCEPTED"         ; To-do accepted
 *                         / "DECLINED"         ; To-do declined
 *                         / "TENTATIVE"        ; To-do tentatively
 *                                              ; accepted
 *                         / "DELEGATED"        ; To-do delegated
 *                         / "COMPLETED"        ; To-do completed
 *                                              ; COMPLETED property has
 *                                              ; DATE-TIME completed
 *                         / "IN-PROCESS"       ; To-do in process of
 *                                              ; being completed
 *                         / x-name             ; Experimental status
 *                         / iana-token)        ; Other IANA-registered
 *                                              ; status
 *        ; These are the participation statuses for a "VTODO".
 *        ; Default is NEEDS-ACTION.
 * 
 *        partstat-jour    = ("NEEDS-ACTION"    ; Journal needs action
 *                         / "ACCEPTED"         ; Journal accepted
 *                         / "DECLINED"         ; Journal declined
 *                         / x-name             ; Experimental status
 *                         / iana-token)        ; Other IANA-registered
 *                                              ; status
 *        ; These are the participation statuses for a "VJOURNAL".
 *        ; Default is NEEDS-ACTION.
 *       
 * 
 * <p>Java class for PartstatParamType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PartstatParamType"&gt;
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
@XmlType(name = "PartstatParamType")
public class PartstatParamType
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
