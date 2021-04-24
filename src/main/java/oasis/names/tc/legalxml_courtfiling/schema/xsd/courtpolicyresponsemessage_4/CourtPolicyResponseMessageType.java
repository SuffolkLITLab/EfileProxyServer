
package oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.IdentificationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The response to a request for a court's Court Policy.
 * 
 * &lt;p&gt;Java class for CourtPolicyResponseMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CourtPolicyResponseMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QueryResponseMessageType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}PolicyVersionID"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}PolicyLastUpdateDate"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}RuntimePolicyParameters"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}DevelopmentPolicyParameters"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CourtPolicyResponseMessageType", propOrder = {
    "policyVersionID",
    "policyLastUpdateDate",
    "runtimePolicyParameters",
    "developmentPolicyParameters"
})
public class CourtPolicyResponseMessageType
    extends QueryResponseMessageType
{

    @XmlElement(name = "PolicyVersionID", required = true)
    protected IdentificationType policyVersionID;
    @XmlElement(name = "PolicyLastUpdateDate", required = true)
    protected DateType policyLastUpdateDate;
    @XmlElement(name = "RuntimePolicyParameters", required = true)
    protected RuntimePolicyParametersType runtimePolicyParameters;
    @XmlElementRef(name = "DevelopmentPolicyParameters", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", type = JAXBElement.class)
    protected JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.DevelopmentPolicyParametersType> developmentPolicyParameters;

    /**
     * Gets the value of the policyVersionID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getPolicyVersionID() {
        return policyVersionID;
    }

    /**
     * Sets the value of the policyVersionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setPolicyVersionID(IdentificationType value) {
        this.policyVersionID = value;
    }

    /**
     * Gets the value of the policyLastUpdateDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getPolicyLastUpdateDate() {
        return policyLastUpdateDate;
    }

    /**
     * Sets the value of the policyLastUpdateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setPolicyLastUpdateDate(DateType value) {
        this.policyLastUpdateDate = value;
    }

    /**
     * Gets the value of the runtimePolicyParameters property.
     * 
     * @return
     *     possible object is
     *     {@link RuntimePolicyParametersType }
     *     
     */
    public RuntimePolicyParametersType getRuntimePolicyParameters() {
        return runtimePolicyParameters;
    }

    /**
     * Sets the value of the runtimePolicyParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuntimePolicyParametersType }
     *     
     */
    public void setRuntimePolicyParameters(RuntimePolicyParametersType value) {
        this.runtimePolicyParameters = value;
    }

    /**
     * Gets the value of the developmentPolicyParameters property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link tyler.ecf.extensions.common.DevelopmentPolicyParametersType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.DevelopmentPolicyParametersType }{@code >}
     *     
     */
    public JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.DevelopmentPolicyParametersType> getDevelopmentPolicyParameters() {
        return developmentPolicyParameters;
    }

    /**
     * Sets the value of the developmentPolicyParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link tyler.ecf.extensions.common.DevelopmentPolicyParametersType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.DevelopmentPolicyParametersType }{@code >}
     *     
     */
    public void setDevelopmentPolicyParameters(JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.DevelopmentPolicyParametersType> value) {
        this.developmentPolicyParameters = value;
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
