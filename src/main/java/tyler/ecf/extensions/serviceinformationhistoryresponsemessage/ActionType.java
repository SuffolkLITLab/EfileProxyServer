
package tyler.ecf.extensions.serviceinformationhistoryresponsemessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.TextType;


/**
 * &lt;p&gt;Java class for ActionType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ActionType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:ServiceInformationHistoryResponseMessage}ContactAction"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:ServiceInformationHistoryResponseMessage}ActionTimestamp" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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

}
