
package ietf.params.xml.ns.icalendar_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 *        fbtypeparam        = "FBTYPE" "=" 
 *                          ("FREE" 
 *                           / "BUSY"
 *                           / "BUSY-UNAVAILABLE" 
 *                           / "BUSY-TENTATIVE"
 *                           / x-name  ; Some experimental iCalendar free/busy type.
 *                           / iana-token)
 *                 ; Some other IANA-registered iCalendar free/busy type.
 *        ; Default is BUSY
 *       
 * 
 * <p>Java class for FbtypeParamType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FbtypeParamType"&gt;
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
@XmlType(name = "FbtypeParamType")
public class FbtypeParamType
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
