
package tyler.ecf.v5_0.extensions.servicetypesrequest;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.AmountType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.RequestMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Message to retrieve service types for a set of codes.
 * 
 * <p>Java class for GetServiceTypesMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetServiceTypesMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RequestMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseTypeCode"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseNewIndicator"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RegisterActionDescriptionCode" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil}AmountInControversy" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:servicetypesrequest}GetServiceTypesMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetServiceTypesMessageType", propOrder = {
    "caseTypeCode",
    "caseNewIndicator",
    "registerActionDescriptionCode",
    "amountInControversy",
    "getServiceTypesMessageAugmentationPoint"
})
public class GetServiceTypesMessageType
    extends RequestMessageType
{

    @XmlElement(name = "CaseTypeCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", required = true)
    protected NormalizedString caseTypeCode;
    @XmlElement(name = "CaseNewIndicator", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", required = true)
    protected Boolean caseNewIndicator;
    @XmlElement(name = "RegisterActionDescriptionCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", required = true)
    protected List<TextType> registerActionDescriptionCode;
    @XmlElement(name = "AmountInControversy", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil")
    protected AmountType amountInControversy;
    @XmlElement(name = "GetServiceTypesMessageAugmentationPoint")
    protected List<Object> getServiceTypesMessageAugmentationPoint;

    /**
     * Gets the value of the caseTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link NormalizedString }
     *     
     */
    public NormalizedString getCaseTypeCode() {
        return caseTypeCode;
    }

    /**
     * Sets the value of the caseTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalizedString }
     *     
     */
    public void setCaseTypeCode(NormalizedString value) {
        this.caseTypeCode = value;
    }

    /**
     * Gets the value of the caseNewIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getCaseNewIndicator() {
        return caseNewIndicator;
    }

    /**
     * Sets the value of the caseNewIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCaseNewIndicator(Boolean value) {
        this.caseNewIndicator = value;
    }

    /**
     * Gets the value of the registerActionDescriptionCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the registerActionDescriptionCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegisterActionDescriptionCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getRegisterActionDescriptionCode() {
        if (registerActionDescriptionCode == null) {
            registerActionDescriptionCode = new ArrayList<TextType>();
        }
        return this.registerActionDescriptionCode;
    }

    /**
     * Gets the value of the amountInControversy property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getAmountInControversy() {
        return amountInControversy;
    }

    /**
     * Sets the value of the amountInControversy property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setAmountInControversy(AmountType value) {
        this.amountInControversy = value;
    }

    /**
     * Gets the value of the getServiceTypesMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getServiceTypesMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetServiceTypesMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetServiceTypesMessageAugmentationPoint() {
        if (getServiceTypesMessageAugmentationPoint == null) {
            getServiceTypesMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getServiceTypesMessageAugmentationPoint;
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
