
package tyler.ecf.extensions.serviceinformationhistoryresponsemessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.TextType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ActionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:ServiceInformationHistoryResponseMessage}ContactAction"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:ServiceInformationHistoryResponseMessage}ActionTimestamp" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActionType", propOrder = {
    "contactAction",
    "actionTimestamp"
})
public class ActionType {

    @XmlElement(name = "ContactAction", required = true)
    protected TextType contactAction;
    @XmlElement(name = "ActionTimestamp")
    protected DateType actionTimestamp;

    /**
     * Gets the value of the contactAction property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getContactAction() {
        return contactAction;
    }

    /**
     * Sets the value of the contactAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setContactAction(TextType value) {
        this.contactAction = value;
    }

    /**
     * Gets the value of the actionTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getActionTimestamp() {
        return actionTimestamp;
    }

    /**
     * Sets the value of the actionTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setActionTimestamp(DateType value) {
        this.actionTimestamp = value;
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
