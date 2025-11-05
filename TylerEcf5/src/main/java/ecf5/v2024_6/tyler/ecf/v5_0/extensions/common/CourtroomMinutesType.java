
package tyler.ecf.v5_0.extensions.common;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.domains.jxdm._6.CaseOfficialType;
import gov.niem.release.niem.niem_core._4.EntityType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CourtroomMinutesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CourtroomMinutesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}HearingResultCode"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}CaseOfficial" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseParty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}InterpreterNeeded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}InterpreterLanguage" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CourtroomMinutesType", propOrder = {
    "hearingResultCode",
    "caseOfficial",
    "caseParty",
    "interpreterNeeded",
    "interpreterLanguage"
})
public class CourtroomMinutesType {

    @XmlElement(name = "HearingResultCode", required = true)
    protected TextType hearingResultCode;
    @XmlElement(name = "CaseOfficial", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/")
    protected List<CaseOfficialType> caseOfficial;
    @XmlElement(name = "CaseParty", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf")
    protected List<EntityType> caseParty;
    @XmlElement(name = "InterpreterNeeded")
    protected Boolean interpreterNeeded;
    @XmlElement(name = "InterpreterLanguage")
    protected TextType interpreterLanguage;

    /**
     * Gets the value of the hearingResultCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getHearingResultCode() {
        return hearingResultCode;
    }

    /**
     * Sets the value of the hearingResultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setHearingResultCode(TextType value) {
        this.hearingResultCode = value;
    }

    /**
     * Gets the value of the caseOfficial property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseOfficial property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseOfficial().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseOfficialType }
     * 
     * 
     */
    public List<CaseOfficialType> getCaseOfficial() {
        if (caseOfficial == null) {
            caseOfficial = new ArrayList<CaseOfficialType>();
        }
        return this.caseOfficial;
    }

    /**
     * Gets the value of the caseParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityType }
     * 
     * 
     */
    public List<EntityType> getCaseParty() {
        if (caseParty == null) {
            caseParty = new ArrayList<EntityType>();
        }
        return this.caseParty;
    }

    /**
     * Gets the value of the interpreterNeeded property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getInterpreterNeeded() {
        return interpreterNeeded;
    }

    /**
     * Sets the value of the interpreterNeeded property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInterpreterNeeded(Boolean value) {
        this.interpreterNeeded = value;
    }

    /**
     * Gets the value of the interpreterLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getInterpreterLanguage() {
        return interpreterLanguage;
    }

    /**
     * Sets the value of the interpreterLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setInterpreterLanguage(TextType value) {
        this.interpreterLanguage = value;
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
