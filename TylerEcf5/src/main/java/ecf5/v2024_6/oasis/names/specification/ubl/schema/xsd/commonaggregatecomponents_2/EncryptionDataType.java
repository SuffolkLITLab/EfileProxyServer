
package ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MessageFormatType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Encryption Data. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Details of an encryption process&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Encryption Data&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for EncryptionDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EncryptionDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MessageFormat"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EncryptionCertificateAttachment" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EncryptionCertificatePathChain" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EncryptionSymmetricAlgorithm" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EncryptionDataType", propOrder = {
    "messageFormat",
    "encryptionCertificateAttachment",
    "encryptionCertificatePathChain",
    "encryptionSymmetricAlgorithm"
})
public class EncryptionDataType {

    @XmlElement(name = "MessageFormat", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected MessageFormatType messageFormat;
    @XmlElement(name = "EncryptionCertificateAttachment")
    protected AttachmentType encryptionCertificateAttachment;
    @XmlElement(name = "EncryptionCertificatePathChain")
    protected List<EncryptionCertificatePathChainType> encryptionCertificatePathChain;
    @XmlElement(name = "EncryptionSymmetricAlgorithm")
    protected List<EncryptionSymmetricAlgorithmType> encryptionSymmetricAlgorithm;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Encryption Data. Message Format. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The format of the encrypted message.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Encryption Data&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Message Format&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link MessageFormatType }
     *     
     */
    public MessageFormatType getMessageFormat() {
        return messageFormat;
    }

    /**
     * Sets the value of the messageFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageFormatType }
     *     
     */
    public void setMessageFormat(MessageFormatType value) {
        this.messageFormat = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Encryption Data. Encryption Certificate_ Attachment. Attachment&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A reference to the certificate used in the encryption process.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Encryption Data&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Encryption Certificate&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Attachment&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Attachment&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Attachment&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link AttachmentType }
     *     
     */
    public AttachmentType getEncryptionCertificateAttachment() {
        return encryptionCertificateAttachment;
    }

    /**
     * Sets the value of the encryptionCertificateAttachment property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttachmentType }
     *     
     */
    public void setEncryptionCertificateAttachment(AttachmentType value) {
        this.encryptionCertificateAttachment = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Encryption Data. Encryption Certificate Path Chain&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A reference to the path chain defined for the encryption process.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Encryption Data&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Encryption Certificate Path Chain&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Encryption Certificate Path Chain&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Encryption Certificate Path Chain&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the encryptionCertificatePathChain property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the encryptionCertificatePathChain property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEncryptionCertificatePathChain().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EncryptionCertificatePathChainType }
     * 
     * 
     */
    public List<EncryptionCertificatePathChainType> getEncryptionCertificatePathChain() {
        if (encryptionCertificatePathChain == null) {
            encryptionCertificatePathChain = new ArrayList<EncryptionCertificatePathChainType>();
        }
        return this.encryptionCertificatePathChain;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Encryption Data. Encryption Symmetric Algorithm&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A reference to the symmetric algorithm used for the encryption process.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Encryption Data&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Encryption Symmetric Algorithm&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Encryption Symmetric Algorithm&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Encryption Symmetric Algorithm&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the encryptionSymmetricAlgorithm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the encryptionSymmetricAlgorithm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEncryptionSymmetricAlgorithm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EncryptionSymmetricAlgorithmType }
     * 
     * 
     */
    public List<EncryptionSymmetricAlgorithmType> getEncryptionSymmetricAlgorithm() {
        if (encryptionSymmetricAlgorithm == null) {
            encryptionSymmetricAlgorithm = new ArrayList<EncryptionSymmetricAlgorithmType>();
        }
        return this.encryptionSymmetricAlgorithm;
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
