
package gov.niem.niem.niem_core._2;

import java.util.ArrayList;
import java.util.List;
import gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.FilingStatusType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.servicereceiptmessage_4.ServiceRecipientStatusType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.extensions.filingdetailresponsemessage.ServiceRecipientDetailType;


/**
 * <p>Java class for StatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatusType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}StatusText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}StatusDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}StatusDescriptionText" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusType", propOrder = {
    "statusText",
    "statusDate",
    "statusDescriptionText"
})
@XmlSeeAlso({
    ServiceRecipientStatusType.class,
    ServiceRecipientDetailType.class,
    MarriageStatusType.class,
    FilingStatusType.class
})
public class StatusType
    extends ComplexObjectType
{

    @XmlElement(name = "StatusText", nillable = true)
    protected TextType statusText;
    @XmlElement(name = "StatusDate", nillable = true)
    protected DateType statusDate;
    @XmlElement(name = "StatusDescriptionText", nillable = true)
    protected List<TextType> statusDescriptionText;

    /**
     * Gets the value of the statusText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getStatusText() {
        return statusText;
    }

    /**
     * Sets the value of the statusText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setStatusText(TextType value) {
        this.statusText = value;
    }

    /**
     * Gets the value of the statusDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getStatusDate() {
        return statusDate;
    }

    /**
     * Sets the value of the statusDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setStatusDate(DateType value) {
        this.statusDate = value;
    }

    /**
     * Gets the value of the statusDescriptionText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the statusDescriptionText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatusDescriptionText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getStatusDescriptionText() {
        if (statusDescriptionText == null) {
            statusDescriptionText = new ArrayList<TextType>();
        }
        return this.statusDescriptionText;
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
