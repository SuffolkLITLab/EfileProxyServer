
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistresponse;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.release.niem.domains.humanservices._4.ChildSupportEnforcementCaseType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.CaseType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ResponseMessageType;


/**
 * A synchronous response to a GetCaseListQueryMessage.
 * 
 * <p>Java class for GetCaseListResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCaseListResponseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}Case" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistresponse}GetCaseListResponseMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetCaseListResponseMessageType", propOrder = {
    "_case",
    "getCaseListResponseMessageAugmentationPoint"
})
public class GetCaseListResponseMessageType
    extends ResponseMessageType
{

    @XmlElementRef(name = "Case", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends CaseType>> _case;
    @XmlElement(name = "GetCaseListResponseMessageAugmentationPoint")
    protected List<Object> getCaseListResponseMessageAugmentationPoint;

    /**
     * Gets the value of the case property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the case property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ChildSupportEnforcementCaseType }{@code >}
     * {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends CaseType>> getCase() {
        if (_case == null) {
            _case = new ArrayList<JAXBElement<? extends CaseType>>();
        }
        return this._case;
    }

    /**
     * Gets the value of the getCaseListResponseMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getCaseListResponseMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetCaseListResponseMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetCaseListResponseMessageAugmentationPoint() {
        if (getCaseListResponseMessageAugmentationPoint == null) {
            getCaseListResponseMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getCaseListResponseMessageAugmentationPoint;
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
