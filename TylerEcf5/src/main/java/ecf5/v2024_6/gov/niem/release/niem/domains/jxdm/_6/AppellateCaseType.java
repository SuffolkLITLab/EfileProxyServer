
package gov.niem.release.niem.domains.jxdm._6;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.CaseType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
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
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}AppellateCaseNotice" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}AppellateCaseOriginalCase" maxOccurs="unbounded" minOccurs="0"/&gt;
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

    @XmlElement(name = "AppellateCaseNotice", nillable = true)
    protected AppellateCaseNoticeType appellateCaseNotice;
    @XmlElement(name = "AppellateCaseOriginalCase", nillable = true)
    protected List<CaseType> appellateCaseOriginalCase;

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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the appellateCaseOriginalCase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppellateCaseOriginalCase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseType }
     * 
     * 
     */
    public List<CaseType> getAppellateCaseOriginalCase() {
        if (appellateCaseOriginalCase == null) {
            appellateCaseOriginalCase = new ArrayList<CaseType>();
        }
        return this.appellateCaseOriginalCase;
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
