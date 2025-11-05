
package tyler.ecf.v5_0.extensions.updatefeesrequest;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseFilingType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Message to update fees.
 * 
 * <p>Java class for UpdateFeesMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateFeesMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseFilingType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AllowanceCharge" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:updatefeesrequest}UpdateFeesMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:updatefeesrequest}WaiveSecondaryFeesIndicator" minOccurs="0"/&gt;
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
@XmlType(name = "UpdateFeesMessageType", propOrder = {
    "allowanceCharge",
    "updateFeesMessageAugmentationPoint",
    "waiveSecondaryFeesIndicator"
})
public class UpdateFeesMessageType
    extends CaseFilingType
{

    @XmlElement(name = "AllowanceCharge", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2", required = true)
    protected List<AllowanceChargeType> allowanceCharge;
    @XmlElement(name = "UpdateFeesMessageAugmentationPoint")
    protected List<Object> updateFeesMessageAugmentationPoint;
    @XmlElement(name = "WaiveSecondaryFeesIndicator")
    protected Boolean waiveSecondaryFeesIndicator;

    /**
     * Gets the value of the allowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the allowanceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowanceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllowanceChargeType }
     * 
     * 
     */
    public List<AllowanceChargeType> getAllowanceCharge() {
        if (allowanceCharge == null) {
            allowanceCharge = new ArrayList<AllowanceChargeType>();
        }
        return this.allowanceCharge;
    }

    /**
     * Gets the value of the updateFeesMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the updateFeesMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUpdateFeesMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getUpdateFeesMessageAugmentationPoint() {
        if (updateFeesMessageAugmentationPoint == null) {
            updateFeesMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.updateFeesMessageAugmentationPoint;
    }

    /**
     * Gets the value of the waiveSecondaryFeesIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getWaiveSecondaryFeesIndicator() {
        return waiveSecondaryFeesIndicator;
    }

    /**
     * Sets the value of the waiveSecondaryFeesIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWaiveSecondaryFeesIndicator(Boolean value) {
        this.waiveSecondaryFeesIndicator = value;
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
