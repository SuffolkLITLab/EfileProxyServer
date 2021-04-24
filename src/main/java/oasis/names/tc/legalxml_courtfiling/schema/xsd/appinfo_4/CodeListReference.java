
package oasis.names.tc.legalxml_courtfiling.schema.xsd.appinfo_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;attribute name="CanonicalURI" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&amp;gt;
 *       &amp;lt;attribute name="CanonicalVersionURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&amp;gt;
 *       &amp;lt;attribute name="LocationURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "CodeListReference")
public class CodeListReference {

    @XmlAttribute(name = "CanonicalURI", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppInfo-4.0", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String canonicalURI;
    @XmlAttribute(name = "CanonicalVersionURI", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppInfo-4.0")
    @XmlSchemaType(name = "anyURI")
    protected String canonicalVersionURI;
    @XmlAttribute(name = "LocationURI", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppInfo-4.0")
    @XmlSchemaType(name = "anyURI")
    protected String locationURI;

    /**
     * Gets the value of the canonicalURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCanonicalURI() {
        return canonicalURI;
    }

    /**
     * Sets the value of the canonicalURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCanonicalURI(String value) {
        this.canonicalURI = value;
    }

    /**
     * Gets the value of the canonicalVersionURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCanonicalVersionURI() {
        return canonicalVersionURI;
    }

    /**
     * Sets the value of the canonicalVersionURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCanonicalVersionURI(String value) {
        this.canonicalVersionURI = value;
    }

    /**
     * Gets the value of the locationURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationURI() {
        return locationURI;
    }

    /**
     * Sets the value of the locationURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationURI(String value) {
        this.locationURI = value;
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
