
package tyler.ecf.v5_0.extensions.taxdelinquency;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CaseAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:taxdelinquency}CaseAbstractor" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:taxdelinquency}PartyService" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:taxdelinquency}PropertyAccountNumber" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "CaseAugmentationType", propOrder = {
    "caseAbstractor",
    "partyService",
    "propertyAccountNumber"
})
public class CaseAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "CaseAbstractor")
    protected List<CaseAbstractorType> caseAbstractor;
    @XmlElement(name = "PartyService")
    protected List<PartyServiceType> partyService;
    @XmlElement(name = "PropertyAccountNumber")
    protected List<TextType> propertyAccountNumber;

    /**
     * Gets the value of the caseAbstractor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseAbstractor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseAbstractor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseAbstractorType }
     * 
     * 
     */
    public List<CaseAbstractorType> getCaseAbstractor() {
        if (caseAbstractor == null) {
            caseAbstractor = new ArrayList<CaseAbstractorType>();
        }
        return this.caseAbstractor;
    }

    /**
     * Gets the value of the partyService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the partyService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartyService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartyServiceType }
     * 
     * 
     */
    public List<PartyServiceType> getPartyService() {
        if (partyService == null) {
            partyService = new ArrayList<PartyServiceType>();
        }
        return this.partyService;
    }

    /**
     * Gets the value of the propertyAccountNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the propertyAccountNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyAccountNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getPropertyAccountNumber() {
        if (propertyAccountNumber == null) {
            propertyAccountNumber = new ArrayList<TextType>();
        }
        return this.propertyAccountNumber;
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
