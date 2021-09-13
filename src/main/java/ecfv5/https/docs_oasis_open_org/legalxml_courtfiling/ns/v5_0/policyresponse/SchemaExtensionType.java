
package ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.proxy.xsd._4.AnyURI;
import ecfv5.gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A structure representing the court-specific extensions for the court associated with this Court Policy.
 * 
 * <p>Java class for SchemaExtensionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SchemaExtensionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}ExtensionType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}ExtensionElementName" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}MajorDesignElementTypeCode" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}OperationNameCode" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "SchemaExtensionType", propOrder = {
    "extensionElementName",
    "majorDesignElementTypeCode",
    "operationNameCode"
})
public class SchemaExtensionType
    extends ExtensionType
{

    @XmlElement(name = "ExtensionElementName", required = true)
    protected List<AnyURI> extensionElementName;
    @XmlElement(name = "MajorDesignElementTypeCode", required = true)
    protected List<NormalizedString> majorDesignElementTypeCode;
    @XmlElement(name = "OperationNameCode", required = true)
    protected List<NormalizedString> operationNameCode;

    /**
     * Gets the value of the extensionElementName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extensionElementName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtensionElementName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnyURI }
     * 
     * 
     */
    public List<AnyURI> getExtensionElementName() {
        if (extensionElementName == null) {
            extensionElementName = new ArrayList<AnyURI>();
        }
        return this.extensionElementName;
    }

    /**
     * Gets the value of the majorDesignElementTypeCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the majorDesignElementTypeCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMajorDesignElementTypeCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NormalizedString }
     * 
     * 
     */
    public List<NormalizedString> getMajorDesignElementTypeCode() {
        if (majorDesignElementTypeCode == null) {
            majorDesignElementTypeCode = new ArrayList<NormalizedString>();
        }
        return this.majorDesignElementTypeCode;
    }

    /**
     * Gets the value of the operationNameCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operationNameCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperationNameCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NormalizedString }
     * 
     * 
     */
    public List<NormalizedString> getOperationNameCode() {
        if (operationNameCode == null) {
            operationNameCode = new ArrayList<NormalizedString>();
        }
        return this.operationNameCode;
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
