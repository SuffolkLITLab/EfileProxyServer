
package tyler.ecf.extensions.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType;


/**
 * &lt;p&gt;Java class for CaseEventType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CaseEventType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:tyler:ecf:extensions:Common}ExtendedDataType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}FilingEvent" maxOccurs="unbounded"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}DocumentAttachmentIdentification" maxOccurs="unbounded"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseEventType", propOrder = {
    "filingEvent",
    "documentAttachmentIdentification"
})
public class CaseEventType
    extends ExtendedDataType
{

    @XmlElement(name = "FilingEvent", required = true)
    protected List<DocumentType> filingEvent;
    @XmlElement(name = "DocumentAttachmentIdentification", required = true)
    protected List<DocumentAttachmentIdentificationType> documentAttachmentIdentification;

    /**
     * Gets the value of the filingEvent property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the filingEvent property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getFilingEvent().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentType }
     * 
     * 
     */
    public List<DocumentType> getFilingEvent() {
        if (filingEvent == null) {
            filingEvent = new ArrayList<DocumentType>();
        }
        return this.filingEvent;
    }

    /**
     * Gets the value of the documentAttachmentIdentification property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the documentAttachmentIdentification property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getDocumentAttachmentIdentification().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentAttachmentIdentificationType }
     * 
     * 
     */
    public List<DocumentAttachmentIdentificationType> getDocumentAttachmentIdentification() {
        if (documentAttachmentIdentification == null) {
            documentAttachmentIdentification = new ArrayList<DocumentAttachmentIdentificationType>();
        }
        return this.documentAttachmentIdentification;
    }

}
