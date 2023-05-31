
package tyler.ecf.v5_0.extensions.common;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.proxy.xsd._4.AnyURI;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.proxy.xsd._4.Decimal;
import gov.niem.release.niem.proxy.xsd._4.Time;
import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for GetPolicyResponseMessageAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetPolicyResponseMessageAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}TimeoutMinutes"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}TimeoutResetHour"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}LocationSpecificURI" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}UseComposableSecurity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ComposableSecurityURI" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ComposableSecurityTenant" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ComposableSecurityDefaultRole" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}UseOktaAuthentication" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}OktaAuthenticationURI" minOccurs="0"/&gt;
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
@XmlType(name = "GetPolicyResponseMessageAugmentationType", propOrder = {
    "timeoutMinutes",
    "timeoutResetHour",
    "locationSpecificURI",
    "useComposableSecurity",
    "composableSecurityURI",
    "composableSecurityTenant",
    "composableSecurityDefaultRole",
    "useOktaAuthentication",
    "oktaAuthenticationURI"
})
public class GetPolicyResponseMessageAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "TimeoutMinutes", required = true)
    protected Decimal timeoutMinutes;
    @XmlElement(name = "TimeoutResetHour", required = true)
    protected Time timeoutResetHour;
    @XmlElement(name = "LocationSpecificURI")
    protected AnyURI locationSpecificURI;
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
     * @return
     *     possible object is
     *     {@link Decimal }
     *     
     */
    public Decimal getTimeoutMinutes() {
        return timeoutMinutes;
    }

    /**
     * Sets the value of the timeoutMinutes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Decimal }
     *     
     */
    public void setTimeoutMinutes(Decimal value) {
        this.timeoutMinutes = value;
    }

    /**
     * Gets the value of the timeoutResetHour property.
     * 
     * @return
     *     possible object is
     *     {@link Time }
     *     
     */
    public Time getTimeoutResetHour() {
        return timeoutResetHour;
    }

    /**
     * Sets the value of the timeoutResetHour property.
     * 
     * @param value
     *     allowed object is
     *     {@link Time }
     *     
     */
    public void setTimeoutResetHour(Time value) {
        this.timeoutResetHour = value;
    }

    /**
     * Gets the value of the locationSpecificURI property.
     * 
     * @return
     *     possible object is
     *     {@link AnyURI }
     *     
     */
    public AnyURI getLocationSpecificURI() {
        return locationSpecificURI;
    }

    /**
     * Sets the value of the locationSpecificURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyURI }
     *     
     */
    public void setLocationSpecificURI(AnyURI value) {
        this.locationSpecificURI = value;
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
     * returned list will be present inside the Jakarta XML Binding object.
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
