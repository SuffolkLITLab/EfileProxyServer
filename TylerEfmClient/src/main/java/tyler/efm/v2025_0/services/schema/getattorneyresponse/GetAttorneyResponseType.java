
package tyler.efm.v2025_0.services.schema.getattorneyresponse;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import tyler.efm.v2025_0.services.schema.baseresponse.BaseResponseType;
import tyler.efm.v2025_0.services.schema.common.AttorneyType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for GetAttorneyResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAttorneyResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:tyler:efm:services:schema:BaseResponse}BaseResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:efm:services:schema:Common}Attorney" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAttorneyResponseType", propOrder = {
    "attorney"
})
public class GetAttorneyResponseType
    extends BaseResponseType
{

    @XmlElement(name = "Attorney", namespace = "urn:tyler:efm:services:schema:Common")
    protected AttorneyType attorney;

    /**
     * Gets the value of the attorney property.
     * 
     * @return
     *     possible object is
     *     {@link AttorneyType }
     *     
     */
    public AttorneyType getAttorney() {
        return attorney;
    }

    /**
     * Sets the value of the attorney property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttorneyType }
     *     
     */
    public void setAttorney(AttorneyType value) {
        this.attorney = value;
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
