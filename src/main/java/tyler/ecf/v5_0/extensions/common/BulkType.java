
package tyler.ecf.v5_0.extensions.common;

import gov.niem.release.niem.niem_core._4.NonNegativeDecimalType;
import gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for BulkType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BulkType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BulkTitle" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BulkSize"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BulkSubmissionID"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BulkType", propOrder = {
    "bulkTitle",
    "bulkSize",
    "bulkSubmissionID"
})
public class BulkType {

    @XmlElement(name = "BulkTitle")
    protected TextType bulkTitle;
    @XmlElement(name = "BulkSize", required = true)
    protected NonNegativeDecimalType bulkSize;
    @XmlElement(name = "BulkSubmissionID", required = true)
    protected TextType bulkSubmissionID;

    /**
     * Gets the value of the bulkTitle property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getBulkTitle() {
        return bulkTitle;
    }

    /**
     * Sets the value of the bulkTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setBulkTitle(TextType value) {
        this.bulkTitle = value;
    }

    /**
     * Gets the value of the bulkSize property.
     * 
     * @return
     *     possible object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public NonNegativeDecimalType getBulkSize() {
        return bulkSize;
    }

    /**
     * Sets the value of the bulkSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public void setBulkSize(NonNegativeDecimalType value) {
        this.bulkSize = value;
    }

    /**
     * Gets the value of the bulkSubmissionID property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getBulkSubmissionID() {
        return bulkSubmissionID;
    }

    /**
     * Sets the value of the bulkSubmissionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setBulkSubmissionID(TextType value) {
        this.bulkSubmissionID = value;
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
