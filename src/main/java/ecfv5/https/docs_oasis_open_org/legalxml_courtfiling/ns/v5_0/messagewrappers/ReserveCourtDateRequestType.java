
package ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reservedate.ReserveCourtDateMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ReserveCourtDateRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReserveCourtDateRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reservedate}ReserveCourtDateMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReserveCourtDateRequestType", propOrder = {
    "reserveCourtDateMessage"
})
public class ReserveCourtDateRequestType {

    @XmlElement(name = "ReserveCourtDateMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reservedate", required = true)
    protected ReserveCourtDateMessageType reserveCourtDateMessage;

    /**
     * Gets the value of the reserveCourtDateMessage property.
     * 
     * @return
     *     possible object is
     *     {@link ReserveCourtDateMessageType }
     *     
     */
    public ReserveCourtDateMessageType getReserveCourtDateMessage() {
        return reserveCourtDateMessage;
    }

    /**
     * Sets the value of the reserveCourtDateMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReserveCourtDateMessageType }
     *     
     */
    public void setReserveCourtDateMessage(ReserveCourtDateMessageType value) {
        this.reserveCourtDateMessage = value;
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
