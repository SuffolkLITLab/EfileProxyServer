
package tyler.ecf.extensions.serviceattachcaselistresponsemessage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.CaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.bankruptcycase_4.BankruptcyCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.CitationCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.CivilCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.CriminalCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.JuvenileCaseType;


/**
 * A synchronous response to a GetServiceAttachCaseListResponseMessage. 
 * 
 * &lt;p&gt;Java class for ServiceAttachCaseListResponseMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ServiceAttachCaseListResponseMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QueryResponseMessageType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}Case" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceAttachCaseListResponseMessageType", propOrder = {
    "_case"
})
public class ServiceAttachCaseListResponseMessageType
    extends QueryResponseMessageType
{

    @XmlElementRef(name = "Case", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends CaseType>> _case;

    /**
     * Gets the value of the case property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the case property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getCase().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link CivilCaseType }{@code >}
     * {@link JAXBElement }{@code <}{@link AppellateCaseType }{@code >}
     * {@link JAXBElement }{@code <}{@link CriminalCaseType }{@code >}
     * {@link JAXBElement }{@code <}{@link CitationCaseType }{@code >}
     * {@link JAXBElement }{@code <}{@link DomesticCaseType }{@code >}
     * {@link JAXBElement }{@code <}{@link BankruptcyCaseType }{@code >}
     * {@link JAXBElement }{@code <}{@link JuvenileCaseType }{@code >}
     * {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends CaseType>> getCase() {
        if (_case == null) {
            _case = new ArrayList<JAXBElement<? extends CaseType>>();
        }
        return this._case;
    }

}
