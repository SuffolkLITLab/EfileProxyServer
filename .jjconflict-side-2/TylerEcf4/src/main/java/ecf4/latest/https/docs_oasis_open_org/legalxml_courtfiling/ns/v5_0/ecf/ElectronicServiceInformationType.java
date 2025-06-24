
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import ecf4.latest.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf4.latest.gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import ecf4.latest.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Information provided by the filing assembly MDE to the court identifying the persons being served electronically with a copy of this filing. This information can constitute the certificate of service for service performed electronically. This information is also provided by the filing assembly MDE to service MDEs to identify persons to whom the service MDEs are required to deliver the filing.
 * 
 * <p>Java class for ElectronicServiceInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ElectronicServiceInformationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ReceivingMDELocationID"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ReceivingMDEProfileCode"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ServiceRecipientID"/&gt;
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
@XmlType(name = "ElectronicServiceInformationType", propOrder = {
    "receivingMDELocationID",
    "receivingMDEProfileCode",
    "serviceRecipientID"
})
public class ElectronicServiceInformationType
    extends ObjectType
{

    @XmlElement(name = "ReceivingMDELocationID", required = true)
    protected IdentificationType receivingMDELocationID;
    @XmlElement(name = "ReceivingMDEProfileCode", required = true)
    protected NormalizedString receivingMDEProfileCode;
    @XmlElement(name = "ServiceRecipientID", required = true)
    protected IdentificationType serviceRecipientID;

    /**
     * Gets the value of the receivingMDELocationID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getReceivingMDELocationID() {
        return receivingMDELocationID;
    }

    /**
     * Sets the value of the receivingMDELocationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setReceivingMDELocationID(IdentificationType value) {
        this.receivingMDELocationID = value;
    }

    /**
     * Gets the value of the receivingMDEProfileCode property.
     * 
     * @return
     *     possible object is
     *     {@link NormalizedString }
     *     
     */
    public NormalizedString getReceivingMDEProfileCode() {
        return receivingMDEProfileCode;
    }

    /**
     * Sets the value of the receivingMDEProfileCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalizedString }
     *     
     */
    public void setReceivingMDEProfileCode(NormalizedString value) {
        this.receivingMDEProfileCode = value;
    }

    /**
     * Gets the value of the serviceRecipientID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getServiceRecipientID() {
        return serviceRecipientID;
    }

    /**
     * Sets the value of the serviceRecipientID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setServiceRecipientID(IdentificationType value) {
        this.serviceRecipientID = value;
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
