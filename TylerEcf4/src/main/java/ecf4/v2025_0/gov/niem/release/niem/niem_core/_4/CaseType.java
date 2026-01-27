
package ecf4.v2025_0.gov.niem.release.niem.niem_core._4;

import java.util.ArrayList;
import java.util.List;
import ecf4.v2025_0.gov.niem.release.niem.domains.humanservices._4.ChildSupportEnforcementCaseType;
import ecf4.v2025_0.gov.niem.release.niem.domains.humanservices._4.JuvenileCaseType;
import ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.AppellateCaseType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for an aggregation of information about a set of related activities and events.
 * 
 * <p>Java class for CaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}CaseTitleText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}CaseTrackingID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}CaseAugmentationPoint" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "CaseType", propOrder = {
    "caseTitleText",
    "caseTrackingID",
    "caseAugmentationPoint"
})
@XmlSeeAlso({
    ChildSupportEnforcementCaseType.class,
    JuvenileCaseType.class,
    AppellateCaseType.class
})
public class CaseType
    extends ActivityType
{

    @XmlElement(name = "CaseTitleText")
    protected TextType caseTitleText;
    @XmlElement(name = "CaseTrackingID")
    protected ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.String caseTrackingID;
    @XmlElementRef(name = "CaseAugmentationPoint", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class)
    protected List<JAXBElement<?>> caseAugmentationPoint;

    /**
     * Gets the value of the caseTitleText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCaseTitleText() {
        return caseTitleText;
    }

    /**
     * Sets the value of the caseTitleText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCaseTitleText(TextType value) {
        this.caseTitleText = value;
    }

    /**
     * Gets the value of the caseTrackingID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.String getCaseTrackingID() {
        return caseTrackingID;
    }

    /**
     * Sets the value of the caseTrackingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setCaseTrackingID(ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.String value) {
        this.caseTrackingID = value;
    }

    /**
     * Gets the value of the caseAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.CaseAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.CaseAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link ecf4.v2025_0.tyler.ecf.v5_0.extensions.common.CaseAugmentationType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getCaseAugmentationPoint() {
        if (caseAugmentationPoint == null) {
            caseAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.caseAugmentationPoint;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
