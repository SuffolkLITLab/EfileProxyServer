
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.requestdateresponse;

import java.util.ArrayList;
import java.util.List;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ResponseMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A response listing available court dates
 * 
 * <p>Java class for RequestCourtDateResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestCourtDateResponseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/requestdateresponse}CourtDate" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/requestdateresponse}RequestCourtResponseMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestCourtDateResponseMessageType", propOrder = {
    "courtDate",
    "requestCourtResponseMessageAugmentationPoint"
})
public class RequestCourtDateResponseMessageType
    extends ResponseMessageType
{

    @XmlElement(name = "CourtDate")
    protected List<CourtDateType> courtDate;
    @XmlElement(name = "RequestCourtResponseMessageAugmentationPoint")
    protected List<Object> requestCourtResponseMessageAugmentationPoint;

    /**
     * Gets the value of the courtDate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the courtDate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourtDate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CourtDateType }
     * 
     * 
     */
    public List<CourtDateType> getCourtDate() {
        if (courtDate == null) {
            courtDate = new ArrayList<CourtDateType>();
        }
        return this.courtDate;
    }

    /**
     * Gets the value of the requestCourtResponseMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the requestCourtResponseMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequestCourtResponseMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getRequestCourtResponseMessageAugmentationPoint() {
        if (requestCourtResponseMessageAugmentationPoint == null) {
            requestCourtResponseMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.requestCourtResponseMessageAugmentationPoint;
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
