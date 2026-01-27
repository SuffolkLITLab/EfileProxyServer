
package ecf4.latest.tyler.ecf.extensions.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for RelatedCaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RelatedCaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseTrackingID"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}CaseRelationType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelatedCaseType", propOrder = {
    "caseTrackingID",
    "caseRelationType"
})
public class RelatedCaseType {

    @XmlElement(name = "CaseTrackingID", namespace = "http://niem.gov/niem/niem-core/2.0", required = true, nillable = true)
    protected ecf4.latest.gov.niem.niem.proxy.xsd._2.String caseTrackingID;
    @XmlElement(name = "CaseRelationType", required = true)
    @XmlSchemaType(name = "token")
    protected CaseRelationSimpleType caseRelationType;

    /**
     * Gets the value of the caseTrackingID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.latest.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public ecf4.latest.gov.niem.niem.proxy.xsd._2.String getCaseTrackingID() {
        return caseTrackingID;
    }

    /**
     * Sets the value of the caseTrackingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.latest.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setCaseTrackingID(ecf4.latest.gov.niem.niem.proxy.xsd._2.String value) {
        this.caseTrackingID = value;
    }

    /**
     * Gets the value of the caseRelationType property.
     * 
     * @return
     *     possible object is
     *     {@link CaseRelationSimpleType }
     *     
     */
    public CaseRelationSimpleType getCaseRelationType() {
        return caseRelationType;
    }

    /**
     * Sets the value of the caseRelationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaseRelationSimpleType }
     *     
     */
    public void setCaseRelationType(CaseRelationSimpleType value) {
        this.caseRelationType = value;
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
