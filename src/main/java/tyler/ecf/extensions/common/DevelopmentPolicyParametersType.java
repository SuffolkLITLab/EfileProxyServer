
package tyler.ecf.extensions.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.proxy.xsd._2.AnyURI;
import gov.niem.niem.proxy.xsd._2.Boolean;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DevelopmentPolicyParametersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DevelopmentPolicyParametersType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}DevelopmentPolicyParametersType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}TimeoutMinutes"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}TimeoutResetHour"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}UseComposableSecurity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}ComposableSecurityURI" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}ComposableSecurityTenant" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}ComposableSecurityDefaultRole" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}UseOktaAuthentication" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}OktaAuthenticationURI" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DevelopmentPolicyParametersType", propOrder = {
    "timeoutMinutes",
    "timeoutResetHour",
    "useComposableSecurity",
    "composableSecurityURI",
    "composableSecurityTenant",
    "composableSecurityDefaultRole",
    "useOktaAuthentication",
    "oktaAuthenticationURI"
})
public class DevelopmentPolicyParametersType
    extends oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.DevelopmentPolicyParametersType
{

    @XmlElement(name = "TimeoutMinutes")
    protected int timeoutMinutes;
    @XmlElement(name = "TimeoutResetHour", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar timeoutResetHour;
    @XmlElement(name = "UseComposableSecurity")
    protected Boolean useComposableSecurity;
    @XmlElement(name = "ComposableSecurityURI")
    protected AnyURI composableSecurityURI;
    @XmlElement(name = "ComposableSecurityTenant")
    protected IdentificationType composableSecurityTenant;
    @XmlElement(name = "ComposableSecurityDefaultRole")
    protected List<IdentificationType> composableSecurityDefaultRole;
    @XmlElement(name = "UseOktaAuthentication")
    protected Boolean useOktaAuthentication;
    @XmlElement(name = "OktaAuthenticationURI")
    protected AnyURI oktaAuthenticationURI;

    /**
     * Gets the value of the timeoutMinutes property.
     * 
     */
    public int getTimeoutMinutes() {
        return timeoutMinutes;
    }

    /**
     * Sets the value of the timeoutMinutes property.
     * 
     */
    public void setTimeoutMinutes(int value) {
        this.timeoutMinutes = value;
    }

    /**
     * Gets the value of the timeoutResetHour property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeoutResetHour() {
        return timeoutResetHour;
    }

    /**
     * Sets the value of the timeoutResetHour property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeoutResetHour(XMLGregorianCalendar value) {
        this.timeoutResetHour = value;
    }

    /**
     * Gets the value of the useComposableSecurity property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getUseComposableSecurity() {
        return useComposableSecurity;
    }

    /**
     * Sets the value of the useComposableSecurity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseComposableSecurity(Boolean value) {
        this.useComposableSecurity = value;
    }

    /**
     * Gets the value of the composableSecurityURI property.
     * 
     * @return
     *     possible object is
     *     {@link AnyURI }
     *     
     */
    public AnyURI getComposableSecurityURI() {
        return composableSecurityURI;
    }

    /**
     * Sets the value of the composableSecurityURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyURI }
     *     
     */
    public void setComposableSecurityURI(AnyURI value) {
        this.composableSecurityURI = value;
    }

    /**
     * Gets the value of the composableSecurityTenant property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getComposableSecurityTenant() {
        return composableSecurityTenant;
    }

    /**
     * Sets the value of the composableSecurityTenant property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setComposableSecurityTenant(IdentificationType value) {
        this.composableSecurityTenant = value;
    }

    /**
     * Gets the value of the composableSecurityDefaultRole property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the composableSecurityDefaultRole property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComposableSecurityDefaultRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationType }
     * 
     * 
     */
    public List<IdentificationType> getComposableSecurityDefaultRole() {
        if (composableSecurityDefaultRole == null) {
            composableSecurityDefaultRole = new ArrayList<IdentificationType>();
        }
        return this.composableSecurityDefaultRole;
    }

    /**
     * Gets the value of the useOktaAuthentication property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getUseOktaAuthentication() {
        return useOktaAuthentication;
    }

    /**
     * Sets the value of the useOktaAuthentication property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseOktaAuthentication(Boolean value) {
        this.useOktaAuthentication = value;
    }

    /**
     * Gets the value of the oktaAuthenticationURI property.
     * 
     * @return
     *     possible object is
     *     {@link AnyURI }
     *     
     */
    public AnyURI getOktaAuthenticationURI() {
        return oktaAuthenticationURI;
    }

    /**
     * Sets the value of the oktaAuthenticationURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyURI }
     *     
     */
    public void setOktaAuthenticationURI(AnyURI value) {
        this.oktaAuthenticationURI = value;
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
