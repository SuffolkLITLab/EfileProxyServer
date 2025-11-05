
package ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A court's response to a FilingListQueryMessage.
 * 
 * <p>Java class for FilingListResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilingListResponseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QueryResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FilingListResponseMessage-4.0}MatchingFiling" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilingListResponseMessageType", propOrder = {
    "matchingFiling"
})
public class FilingListResponseMessageType
    extends QueryResponseMessageType
{

    @XmlElement(name = "MatchingFiling")
    protected List<MatchingFilingType> matchingFiling;

    /**
     * Gets the value of the matchingFiling property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the matchingFiling property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMatchingFiling().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MatchingFilingType }
     * 
     * 
     */
    public List<MatchingFilingType> getMatchingFiling() {
        if (matchingFiling == null) {
            matchingFiling = new ArrayList<MatchingFilingType>();
        }
        return this.matchingFiling;
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
