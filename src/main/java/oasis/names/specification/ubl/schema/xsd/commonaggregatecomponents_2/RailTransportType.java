
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RailCarIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TrainIDType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for RailTransportType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="RailTransportType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TrainID"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RailCarID" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RailTransportType", propOrder = {
    "trainID",
    "railCarID"
})
public class RailTransportType {

    @XmlElement(name = "TrainID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected TrainIDType trainID;
    @XmlElement(name = "RailCarID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RailCarIDType railCarID;

    /**
     * Gets the value of the trainID property.
     * 
     * @return
     *     possible object is
     *     {@link TrainIDType }
     *     
     */
    public TrainIDType getTrainID() {
        return trainID;
    }

    /**
     * Sets the value of the trainID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrainIDType }
     *     
     */
    public void setTrainID(TrainIDType value) {
        this.trainID = value;
    }

    /**
     * Gets the value of the railCarID property.
     * 
     * @return
     *     possible object is
     *     {@link RailCarIDType }
     *     
     */
    public RailCarIDType getRailCarID() {
        return railCarID;
    }

    /**
     * Sets the value of the railCarID property.
     * 
     * @param value
     *     allowed object is
     *     {@link RailCarIDType }
     *     
     */
    public void setRailCarID(RailCarIDType value) {
        this.railCarID = value;
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
