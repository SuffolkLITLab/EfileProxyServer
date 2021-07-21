
package oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Within Court Policy, the policies that are accessed dynamically by applications interacting with a court.
 * 
 * <p>Java class for RuntimePolicyParametersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RuntimePolicyParametersType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}PublicKeyInformation" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}CourtCodelist" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RuntimePolicyParametersType", propOrder = {
    "publicKeyInformation",
    "courtCodelist"
})
public class RuntimePolicyParametersType
    extends ComplexObjectType
{

    @XmlElement(name = "PublicKeyInformation")
    protected PublicKeyInformationType publicKeyInformation;
    @XmlElement(name = "CourtCodelist", required = true)
    protected List<CourtCodelistType> courtCodelist;

    /**
     * Gets the value of the publicKeyInformation property.
     * 
     * @return
     *     possible object is
     *     {@link PublicKeyInformationType }
     *     
     */
    public PublicKeyInformationType getPublicKeyInformation() {
        return publicKeyInformation;
    }

    /**
     * Sets the value of the publicKeyInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicKeyInformationType }
     *     
     */
    public void setPublicKeyInformation(PublicKeyInformationType value) {
        this.publicKeyInformation = value;
    }

    /**
     * Gets the value of the courtCodelist property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the courtCodelist property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourtCodelist().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CourtCodelistType }
     * 
     * 
     */
    public List<CourtCodelistType> getCourtCodelist() {
        if (courtCodelist == null) {
            courtCodelist = new ArrayList<CourtCodelistType>();
        }
        return this.courtCodelist;
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
