
package ecf5.v2024_6.gov.niem.release.niem.domains.jxdm._6;

import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.DocumentType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a request filed with an appellate court to start an appellate case.
 * 
 * <p>Java class for AppellateCaseNoticeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppellateCaseNoticeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}DocumentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}AppellateCaseNoticeReasonText" minOccurs="0"/&gt;
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
@XmlType(name = "AppellateCaseNoticeType", propOrder = {
    "appellateCaseNoticeReasonText"
})
public class AppellateCaseNoticeType
    extends DocumentType
{

    @XmlElement(name = "AppellateCaseNoticeReasonText")
    protected TextType appellateCaseNoticeReasonText;

    /**
     * Gets the value of the appellateCaseNoticeReasonText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAppellateCaseNoticeReasonText() {
        return appellateCaseNoticeReasonText;
    }

    /**
     * Sets the value of the appellateCaseNoticeReasonText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAppellateCaseNoticeReasonText(TextType value) {
        this.appellateCaseNoticeReasonText = value;
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
