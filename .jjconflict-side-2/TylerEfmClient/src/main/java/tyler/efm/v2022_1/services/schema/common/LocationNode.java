
package tyler.efm.v2022_1.services.schema.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for LocationNode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocationNode"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NodeID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="CourtIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocationNode", propOrder = {
    "nodeID",
    "courtIdentifier"
})
public class LocationNode {

    @XmlElement(name = "NodeID")
    protected int nodeID;
    @XmlElement(name = "CourtIdentifier")
    protected String courtIdentifier;

    /**
     * Gets the value of the nodeID property.
     * 
     */
    public int getNodeID() {
        return nodeID;
    }

    /**
     * Sets the value of the nodeID property.
     * 
     */
    public void setNodeID(int value) {
        this.nodeID = value;
    }

    /**
     * Gets the value of the courtIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourtIdentifier() {
        return courtIdentifier;
    }

    /**
     * Sets the value of the courtIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourtIdentifier(String value) {
        this.courtIdentifier = value;
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
