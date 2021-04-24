
package oasis.names.tc.legalxml_courtfiling.schema.xsd.documentresponsemessage_4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The court's response to a request for an electronic document in the court's official record. 
 * 
 * &lt;p&gt;Java class for DocumentResponseMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DocumentResponseMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QueryResponseMessageType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}Document"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentResponseMessageType", propOrder = {
    "document"
})
public class DocumentResponseMessageType
    extends QueryResponseMessageType
{

    @XmlElementRef(name = "Document", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", type = JAXBElement.class)
    protected JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType> document;

    /**
     * Gets the value of the document property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link tyler.ecf.extensions.common.DocumentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType }{@code >}
     *     
     */
    public JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType> getDocument() {
        return document;
    }

    /**
     * Sets the value of the document property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link tyler.ecf.extensions.common.DocumentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType }{@code >}
     *     
     */
    public void setDocument(JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType> value) {
        this.document = value;
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
