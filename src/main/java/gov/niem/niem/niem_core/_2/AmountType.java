
package gov.niem.niem.niem_core._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.iso_4217._2.CurrencyCodeSimpleType;
import gov.niem.niem.proxy.xsd._2.Decimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for AmountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmountType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://niem.gov/niem/proxy/xsd/2.0&gt;decimal"&gt;
 *       &lt;attribute ref="{http://niem.gov/niem/niem-core/2.0}currencyCode"/&gt;
 *       &lt;attribute ref="{http://niem.gov/niem/niem-core/2.0}currencyText"/&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountType")
public class AmountType
    extends Decimal
{

    @XmlAttribute(name = "currencyCode", namespace = "http://niem.gov/niem/niem-core/2.0")
    protected CurrencyCodeSimpleType currencyCode;
    @XmlAttribute(name = "currencyText", namespace = "http://niem.gov/niem/niem-core/2.0")
    protected String currencyText;

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCodeSimpleType }
     *     
     */
    public CurrencyCodeSimpleType getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCodeSimpleType }
     *     
     */
    public void setCurrencyCode(CurrencyCodeSimpleType value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the currencyText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyText() {
        return currencyText;
    }

    /**
     * Sets the value of the currencyText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyText(String value) {
        this.currencyText = value;
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
