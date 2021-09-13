
package ecfv5.gov.niem.release.niem.domains.jxdm._6;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.codes.fbi_ncic._4.EXLCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for an authorization for an enforcement official to perform a specified action.
 * 
 * <p>Java class for WarrantType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WarrantType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/domains/jxdm/6.0/}CourtOrderType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}WarrantExtraditionLimitationAbstract"/&gt;
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
@XmlType(name = "WarrantType", propOrder = {
    "warrantExtraditionLimitationAbstract"
})
public class WarrantType
    extends CourtOrderType
{

    @XmlElementRef(name = "WarrantExtraditionLimitationAbstract", namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", type = JAXBElement.class)
    protected JAXBElement<?> warrantExtraditionLimitationAbstract;

    /**
     * Gets the value of the warrantExtraditionLimitationAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link EXLCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getWarrantExtraditionLimitationAbstract() {
        return warrantExtraditionLimitationAbstract;
    }

    /**
     * Sets the value of the warrantExtraditionLimitationAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link EXLCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setWarrantExtraditionLimitationAbstract(JAXBElement<?> value) {
        this.warrantExtraditionLimitationAbstract = value;
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
