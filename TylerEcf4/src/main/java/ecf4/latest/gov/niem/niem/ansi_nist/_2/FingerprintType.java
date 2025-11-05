
package ecf4.latest.gov.niem.niem.ansi_nist._2;

import ecf4.latest.gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for FingerprintType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FingerprintType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/ansi-nist/2.0}FingerPositionCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FingerprintType", propOrder = {
    "fingerPositionCode"
})
@XmlSeeAlso({
   ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.FingerprintType.class
})
public class FingerprintType
    extends ComplexObjectType
{

    @XmlElement(name = "FingerPositionCode", nillable = true)
    protected FPCCodeType fingerPositionCode;

    /**
     * Gets the value of the fingerPositionCode property.
     * 
     * @return
     *     possible object is
     *     {@link FPCCodeType }
     *     
     */
    public FPCCodeType getFingerPositionCode() {
        return fingerPositionCode;
    }

    /**
     * Sets the value of the fingerPositionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link FPCCodeType }
     *     
     */
    public void setFingerPositionCode(FPCCodeType value) {
        this.fingerPositionCode = value;
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
