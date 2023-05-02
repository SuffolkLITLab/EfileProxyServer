
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.allocatedate.AllocateCourtDateMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for AllocateCourtDateRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AllocateCourtDateRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/allocatedate}AllocateCourtDateMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllocateCourtDateRequestType", propOrder = {
    "allocateCourtDateMessage"
})
public class AllocateCourtDateRequestType {

    @XmlElement(name = "AllocateCourtDateMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/allocatedate", required = true)
    protected AllocateCourtDateMessageType allocateCourtDateMessage;

    /**
     * Gets the value of the allocateCourtDateMessage property.
     * 
     * @return
     *     possible object is
     *     {@link AllocateCourtDateMessageType }
     *     
     */
    public AllocateCourtDateMessageType getAllocateCourtDateMessage() {
        return allocateCourtDateMessage;
    }

    /**
     * Sets the value of the allocateCourtDateMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllocateCourtDateMessageType }
     *     
     */
    public void setAllocateCourtDateMessage(AllocateCourtDateMessageType value) {
        this.allocateCourtDateMessage = value;
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
