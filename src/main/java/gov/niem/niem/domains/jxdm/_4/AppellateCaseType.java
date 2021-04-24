
package gov.niem.niem.domains.jxdm._4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.CaseType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for AppellateCaseType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="AppellateCaseType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}CaseType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}AppellateCaseNotice" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}AppellateCaseOriginalCase" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppellateCaseType", propOrder = {
    "appellateCaseNotice",
    "appellateCaseOriginalCase"
})
@XmlSeeAlso({
    oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCaseType.class
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the appellateCaseOriginalCase property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getAppellateCaseOriginalCase().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
