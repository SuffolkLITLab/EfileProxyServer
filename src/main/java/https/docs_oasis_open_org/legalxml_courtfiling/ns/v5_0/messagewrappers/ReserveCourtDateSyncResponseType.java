
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.reservedateresponse.ReserveDateResponseMessageType;


/**
 * <p>Java class for ReserveCourtDateSyncResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReserveCourtDateSyncResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:reservedateresponse}ReserveDateResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReserveCourtDateSyncResponseType", propOrder = {
    "reserveDateResponseMessage"
})
public class ReserveCourtDateSyncResponseType {

    @XmlElement(name = "ReserveDateResponseMessage", namespace = "urn:tyler:ecf:v5.0:extensions:reservedateresponse", required = true)
    protected ReserveDateResponseMessageType reserveDateResponseMessage;

    /**
     * Gets the value of the reserveDateResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link ReserveDateResponseMessageType }
     *     
     */
    public ReserveDateResponseMessageType getReserveDateResponseMessage() {
        return reserveDateResponseMessage;
    }

    /**
     * Sets the value of the reserveDateResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReserveDateResponseMessageType }
     *     
     */
    public void setReserveDateResponseMessage(ReserveDateResponseMessageType value) {
        this.reserveDateResponseMessage = value;
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
