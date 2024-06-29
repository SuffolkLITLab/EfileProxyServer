
package tyler.efm.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.services.schema.replaceservicecontactrequesttype.ReplaceServiceContactRequestType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ReplaceServiceContactRequest" type="{urn:tyler:efm:services:schema:ReplaceServiceContactRequestType}ReplaceServiceContactRequestType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "replaceServiceContactRequest"
})
@XmlRootElement(name = "ReplaceServiceContact")
public class ReplaceServiceContact {

    @XmlElement(name = "ReplaceServiceContactRequest")
    protected ReplaceServiceContactRequestType replaceServiceContactRequest;

    /**
     * Gets the value of the replaceServiceContactRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ReplaceServiceContactRequestType }
     *     
     */
    public ReplaceServiceContactRequestType getReplaceServiceContactRequest() {
        return replaceServiceContactRequest;
    }

    /**
     * Sets the value of the replaceServiceContactRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplaceServiceContactRequestType }
     *     
     */
    public void setReplaceServiceContactRequest(ReplaceServiceContactRequestType value) {
        this.replaceServiceContactRequest = value;
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
