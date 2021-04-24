
package oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.domains.jxdm._4.CourtType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseFilingType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.servicereceiptmessage_4.ServiceReceiptMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A message returned synchronously to indicate receipt by an MDE of another message. The intent is that this will serve as the synchronous reply to all MDE operations that have an additional asynchronous callback.
 * 
 * &lt;p&gt;Java class for MessageReceiptMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="MessageReceiptMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseFilingType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseCourt"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}Error" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageReceiptMessageType", propOrder = {
    "caseCourt",
    "error"
})
@XmlSeeAlso({
    ServiceReceiptMessageType.class
})
public class MessageReceiptMessageType
    extends CaseFilingType
{

    @XmlElement(name = "CaseCourt", namespace = "http://niem.gov/niem/domains/jxdm/4.0", required = true, nillable = true)
    protected CourtType caseCourt;
    @XmlElement(name = "Error", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0")
    protected List<ErrorType> error;

    /**
     * Gets the value of the caseCourt property.
     * 
     * @return
     *     possible object is
     *     {@link CourtType }
     *     
     */
    public CourtType getCaseCourt() {
        return caseCourt;
    }

    /**
     * Sets the value of the caseCourt property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourtType }
     *     
     */
    public void setCaseCourt(CourtType value) {
        this.caseCourt = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the error property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getError().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ErrorType }
     * 
     * 
     */
    public List<ErrorType> getError() {
        if (error == null) {
            error = new ArrayList<ErrorType>();
        }
        return this.error;
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
