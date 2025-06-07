
package tyler.efm.latest.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import tyler.efm.latest.services.schema.updateattorneyrequest.UpdateAttorneyRequestType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UpdateAttorneyRequest" type="{urn:tyler:efm:services:schema:UpdateAttorneyRequest}UpdateAttorneyRequestType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "updateAttorneyRequest"
})
@XmlRootElement(name = "UpdateAttorney")
public class UpdateAttorney {

    @XmlElement(name = "UpdateAttorneyRequest")
    protected UpdateAttorneyRequestType updateAttorneyRequest;

    /**
     * Gets the value of the updateAttorneyRequest property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateAttorneyRequestType }
     *     
     */
    public UpdateAttorneyRequestType getUpdateAttorneyRequest() {
        return updateAttorneyRequest;
    }

    /**
     * Sets the value of the updateAttorneyRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateAttorneyRequestType }
     *     
     */
    public void setUpdateAttorneyRequest(UpdateAttorneyRequestType value) {
        this.updateAttorneyRequest = value;
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
