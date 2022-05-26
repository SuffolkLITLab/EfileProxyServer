
package gov.niem.niem.niem_core._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.fbi._2.LISCodeType;
import gov.niem.niem.fbi._2.LSTACodeType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.extensions.common.DocumentOptionalServiceType;
import tyler.ecf.extensions.common.OrganizationIdentificationType;


/**
 * <p>Java class for IdentificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdentificationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}IdentificationID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}IdentificationCategory" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}IdentificationJurisdiction" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}IdentificationSourceText" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentificationType", propOrder = {
    "identificationID",
    "identificationCategory",
    "identificationJurisdiction",
    "identificationSourceText"
})
@XmlSeeAlso({
    tyler.ecf.extensions.filingserviceresponsemessage.ServiceContactIdentificationType.class,
    OrganizationIdentificationType.class,
    DocumentOptionalServiceType.class,
    tyler.ecf.extensions.common.ServiceContactIdentificationType.class,
    tyler.ecf.extensions.filingservicequerymessage.ServiceContactIdentificationType.class
})
public class IdentificationType
    extends ComplexObjectType
{

    @XmlElement(name = "IdentificationID", nillable = true)
    protected gov.niem.niem.proxy.xsd._2.String identificationID;
    @XmlElementRef(name = "IdentificationCategory", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> identificationCategory;
    @XmlElementRef(name = "IdentificationJurisdiction", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> identificationJurisdiction;
    @XmlElement(name = "IdentificationSourceText", nillable = true)
    protected TextType identificationSourceText;

    /**
     * Gets the value of the identificationID property.
     * 
     * @return
     *     possible object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getIdentificationID() {
        return identificationID;
    }

    /**
     * Sets the value of the identificationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setIdentificationID(gov.niem.niem.proxy.xsd._2.String value) {
        this.identificationID = value;
    }

    /**
     * Gets the value of the identificationCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getIdentificationCategory() {
        return identificationCategory;
    }

    /**
     * Sets the value of the identificationCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setIdentificationCategory(JAXBElement<?> value) {
        this.identificationCategory = value;
    }

    /**
     * Gets the value of the identificationJurisdiction property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LISCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LSTACodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getIdentificationJurisdiction() {
        return identificationJurisdiction;
    }

    /**
     * Sets the value of the identificationJurisdiction property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LISCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LSTACodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setIdentificationJurisdiction(JAXBElement<?> value) {
        this.identificationJurisdiction = value;
    }

    /**
     * Gets the value of the identificationSourceText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getIdentificationSourceText() {
        return identificationSourceText;
    }

    /**
     * Sets the value of the identificationSourceText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setIdentificationSourceText(TextType value) {
        this.identificationSourceText = value;
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
