
package tyler.ecf.v5_0.extensions.updatefeesresponse;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.AmountType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ResponseMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The response to a UpdateFeesMessage, which may either be 0 indicating no fee is due, a currency amount indicating the fee due upon filing, or unknown indicating that the court case management information system is unable to calculate the fee for the proposed filing.
 * 
 * <p>Java class for UpdateFeesResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateFeesResponseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AllowanceCharge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:updatefeesresponse}UpdateFeesAmount"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:updatefeesresponse}UpdateFeesResponseMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "UpdateFeesResponseMessageType", propOrder = {
    "allowanceCharge",
    "updateFeesAmount",
    "updateFeesResponseMessageAugmentationPoint"
})
public class UpdateFeesResponseMessageType
    extends ResponseMessageType
{

    @XmlElement(name = "AllowanceCharge", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<AllowanceChargeType> allowanceCharge;
    @XmlElement(name = "UpdateFeesAmount", required = true)
    protected AmountType updateFeesAmount;
    @XmlElement(name = "UpdateFeesResponseMessageAugmentationPoint")
    protected List<Object> updateFeesResponseMessageAugmentationPoint;

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
     * Gets the value of the updateFeesAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getUpdateFeesAmount() {
        return updateFeesAmount;
    }

    /**
     * Sets the value of the updateFeesAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setUpdateFeesAmount(AmountType value) {
        this.updateFeesAmount = value;
    }

    /**
     * Gets the value of the updateFeesResponseMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the updateFeesResponseMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUpdateFeesResponseMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getUpdateFeesResponseMessageAugmentationPoint() {
        if (updateFeesResponseMessageAugmentationPoint == null) {
            updateFeesResponseMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.updateFeesResponseMessageAugmentationPoint;
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
