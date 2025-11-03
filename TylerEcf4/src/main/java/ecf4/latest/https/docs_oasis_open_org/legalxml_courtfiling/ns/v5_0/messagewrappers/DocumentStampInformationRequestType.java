
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.stampinformation.DocumentStampInformationMessageType;


/**
 * <p>Java class for DocumentStampInformationRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentStampInformationRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/stampinformation}DocumentStampInformationMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentStampInformationRequestType", propOrder = {
    "documentStampInformationMessage"
})
public class DocumentStampInformationRequestType {

    @XmlElement(name = "DocumentStampInformationMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/stampinformation", required = true)
    protected DocumentStampInformationMessageType documentStampInformationMessage;

    /**
     * Gets the value of the documentStampInformationMessage property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentStampInformationMessageType }
     *     
     */
    public DocumentStampInformationMessageType getDocumentStampInformationMessage() {
        return documentStampInformationMessage;
    }

    /**
     * Sets the value of the documentStampInformationMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentStampInformationMessageType }
     *     
     */
    public void setDocumentStampInformationMessage(DocumentStampInformationMessageType value) {
        this.documentStampInformationMessage = value;
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
