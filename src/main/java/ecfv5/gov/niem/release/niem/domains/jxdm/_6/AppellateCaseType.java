
package ecfv5.gov.niem.release.niem.domains.jxdm._6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.niem_core._4.CaseType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a single case heard by a court to determine if the original case was tried properly and the defendant received a fair trial.
 * 
 * <p>Java class for AppellateCaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppellateCaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}CaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}AppellateCaseNotice" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}AppellateCaseOriginalCase" minOccurs="0"/&gt;
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
@XmlType(name = "AppellateCaseType", propOrder = {
    "appellateCaseNotice",
    "appellateCaseOriginalCase"
})
public class AppellateCaseType
    extends CaseType
{

    @XmlElement(name = "AppellateCaseNotice")
    protected AppellateCaseNoticeType appellateCaseNotice;
    @XmlElement(name = "AppellateCaseOriginalCase", nillable = true)
    protected CaseType appellateCaseOriginalCase;

    /**
     * Gets the value of the appellateCaseNotice property.
     * 
     * @return
     *     possible object is
     *     {@link AppellateCaseNoticeType }
     *     
     */
    public AppellateCaseNoticeType getAppellateCaseNotice() {
        return appellateCaseNotice;
    }

    /**
     * Sets the value of the appellateCaseNotice property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppellateCaseNoticeType }
     *     
     */
    public void setAppellateCaseNotice(AppellateCaseNoticeType value) {
        this.appellateCaseNotice = value;
    }

    /**
     * Gets the value of the appellateCaseOriginalCase property.
     * 
     * @return
     *     possible object is
     *     {@link CaseType }
     *     
     */
    public CaseType getAppellateCaseOriginalCase() {
        return appellateCaseOriginalCase;
    }

    /**
     * Sets the value of the appellateCaseOriginalCase property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaseType }
     *     
     */
    public void setAppellateCaseOriginalCase(CaseType value) {
        this.appellateCaseOriginalCase = value;
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
