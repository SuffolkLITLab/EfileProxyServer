
package oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DocumentStatusCodeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentStatusCodeType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;restriction base="&lt;urn:oasis:names:specification:ubl:schema:xsd:QualifiedDataTypes-2&gt;DocumentStatusCodeType"&gt;
 *     &lt;/restriction&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentStatusCodeType")
public class DocumentStatusCodeType
    extends oasis.names.specification.ubl.schema.xsd.qualifieddatatypes_2.DocumentStatusCodeType
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
