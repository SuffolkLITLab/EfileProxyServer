
package gov.niem.niem.domains.jxdm._4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.DocumentType;
import gov.niem.niem.niem_core._2.TextType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for AppellateCaseNoticeType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="AppellateCaseNoticeType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}DocumentType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}AppellateCaseNoticeReasonText" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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

    @XmlElement(name = "AppellateCaseNoticeReasonText", nillable = true)
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
