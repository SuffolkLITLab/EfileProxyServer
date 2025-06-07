
package ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.qualifieddatatypes_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentCurrencyCodeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentAlternativeCurrencyCodeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentCurrencyCodeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PricingCurrencyCodeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequestedInvoiceCurrencyCodeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SourceCurrencyCodeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TargetCurrencyCodeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxCurrencyCodeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueCurrencyCodeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2.CodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CurrencyCodeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CurrencyCodeType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;restriction base="&lt;urn:oasis:names:specification:ubl:schema:xsd:UnqualifiedDataTypes-2&gt;CodeType"&gt;
 *     &lt;/restriction&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrencyCodeType")
@XmlSeeAlso({
    ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CurrencyCodeType.class,
    DocumentCurrencyCodeType.class,
    PaymentAlternativeCurrencyCodeType.class,
    PaymentCurrencyCodeType.class,
    PricingCurrencyCodeType.class,
    RequestedInvoiceCurrencyCodeType.class,
    SourceCurrencyCodeType.class,
    TargetCurrencyCodeType.class,
    TaxCurrencyCodeType.class,
    ValueCurrencyCodeType.class
})
public class CurrencyCodeType
    extends CodeType
{


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
