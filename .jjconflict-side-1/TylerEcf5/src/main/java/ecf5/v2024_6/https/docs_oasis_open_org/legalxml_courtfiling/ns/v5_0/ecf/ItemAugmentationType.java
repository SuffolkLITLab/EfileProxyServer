
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Boolean;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ItemAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseParticipantRoleCode" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CasePartySelfRepresentationIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ParticipantID" minOccurs="0"/&gt;
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
@XmlType(name = "ItemAugmentationType", propOrder = {
    "caseParticipantRoleCode",
    "casePartySelfRepresentationIndicator",
    "participantID"
})
public class ItemAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "CaseParticipantRoleCode", required = true)
    protected List<TextType> caseParticipantRoleCode;
    @XmlElement(name = "CasePartySelfRepresentationIndicator")
    protected Boolean casePartySelfRepresentationIndicator;
    @XmlElement(name = "ParticipantID")
    protected IdentificationType participantID;

    /**
     * Gets the value of the caseParticipantRoleCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseParticipantRoleCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseParticipantRoleCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getCaseParticipantRoleCode() {
        if (caseParticipantRoleCode == null) {
            caseParticipantRoleCode = new ArrayList<TextType>();
        }
        return this.caseParticipantRoleCode;
    }

    /**
     * Gets the value of the casePartySelfRepresentationIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getCasePartySelfRepresentationIndicator() {
        return casePartySelfRepresentationIndicator;
    }

    /**
     * Sets the value of the casePartySelfRepresentationIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCasePartySelfRepresentationIndicator(Boolean value) {
        this.casePartySelfRepresentationIndicator = value;
    }

    /**
     * Gets the value of the participantID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getParticipantID() {
        return participantID;
    }

    /**
     * Sets the value of the participantID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setParticipantID(IdentificationType value) {
        this.participantID = value;
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
