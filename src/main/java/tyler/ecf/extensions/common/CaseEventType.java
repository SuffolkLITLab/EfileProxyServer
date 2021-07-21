
package tyler.ecf.extensions.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CaseEventType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseEventType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:tyler:ecf:extensions:Common}ExtendedDataType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}FilingEvent" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}DocumentAttachmentIdentification" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filingEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilingEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentAttachmentIdentification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentAttachmentIdentification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
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
