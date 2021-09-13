
package ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filing;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.niem_core._4.CaseType;
import ecfv5.gov.niem.release.niem.niem_core._4.DocumentType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseFilingType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ElectronicServiceInformationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The structure of a Filing including any Payment Information will be documented in this section. This describes the filing transaction between the Filing Assembly MDE and the Filing Review MDE. This information will become part of the Record Docketing between the Filing Review MDE and the Court Record MDE but does not necessarily describe the information that is actually stored in the Court Record.
 * 
 * <p>Java class for FilingMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilingMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseFilingType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ElectronicServiceInformation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing}FilingConnectedDocument" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing}FilingLeadDocument" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}Case"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing}FilingMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "FilingMessageType", propOrder = {
    "electronicServiceInformation",
    "filingConnectedDocument",
    "filingLeadDocument",
    "_case",
    "filingMessageAugmentationPoint"
})
public class FilingMessageType
    extends CaseFilingType
{

    @XmlElement(name = "ElectronicServiceInformation", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf")
    protected List<ElectronicServiceInformationType> electronicServiceInformation;
    @XmlElement(name = "FilingConnectedDocument", nillable = true)
    protected List<DocumentType> filingConnectedDocument;
    @XmlElement(name = "FilingLeadDocument", required = true, nillable = true)
    protected List<DocumentType> filingLeadDocument;
    @XmlElement(name = "Case", namespace = "http://release.niem.gov/niem/niem-core/4.0/", required = true, nillable = true)
    protected CaseType _case;
    @XmlElement(name = "FilingMessageAugmentationPoint")
    protected List<Object> filingMessageAugmentationPoint;

    /**
     * Gets the value of the electronicServiceInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the electronicServiceInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElectronicServiceInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElectronicServiceInformationType }
     * 
     * 
     */
    public List<ElectronicServiceInformationType> getElectronicServiceInformation() {
        if (electronicServiceInformation == null) {
            electronicServiceInformation = new ArrayList<ElectronicServiceInformationType>();
        }
        return this.electronicServiceInformation;
    }

    /**
     * Gets the value of the filingConnectedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filingConnectedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilingConnectedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentType }
     * 
     * 
     */
    public List<DocumentType> getFilingConnectedDocument() {
        if (filingConnectedDocument == null) {
            filingConnectedDocument = new ArrayList<DocumentType>();
        }
        return this.filingConnectedDocument;
    }

    /**
     * Gets the value of the filingLeadDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filingLeadDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilingLeadDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentType }
     * 
     * 
     */
    public List<DocumentType> getFilingLeadDocument() {
        if (filingLeadDocument == null) {
            filingLeadDocument = new ArrayList<DocumentType>();
        }
        return this.filingLeadDocument;
    }

    /**
     * Gets the value of the case property.
     * 
     * @return
     *     possible object is
     *     {@link CaseType }
     *     
     */
    public CaseType getCase() {
        return _case;
    }

    /**
     * Sets the value of the case property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaseType }
     *     
     */
    public void setCase(CaseType value) {
        this._case = value;
    }

    /**
     * Gets the value of the filingMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filingMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilingMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getFilingMessageAugmentationPoint() {
        if (filingMessageAugmentationPoint == null) {
            filingMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.filingMessageAugmentationPoint;
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
