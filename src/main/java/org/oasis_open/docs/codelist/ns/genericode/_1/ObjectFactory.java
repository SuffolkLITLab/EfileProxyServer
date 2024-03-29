//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.04.16 at 04:29:27 PM UTC 
//


package org.oasis_open.docs.codelist.ns.genericode._1;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.oasis_open.docs.codelist.ns.genericode._1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CodeList_QNAME = new QName("http://docs.oasis-open.org/codelist/ns/genericode/1.0/", "CodeList");
    private final static QName _CodeListSet_QNAME = new QName("http://docs.oasis-open.org/codelist/ns/genericode/1.0/", "CodeListSet");
    private final static QName _ColumnSet_QNAME = new QName("http://docs.oasis-open.org/codelist/ns/genericode/1.0/", "ColumnSet");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.oasis_open.docs.codelist.ns.genericode._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CodeListDocument }
     * 
     */
    public CodeListDocument createCodeListDocument() {
        return new CodeListDocument();
    }

    /**
     * Create an instance of {@link CodeListSetDocument }
     * 
     */
    public CodeListSetDocument createCodeListSetDocument() {
        return new CodeListSetDocument();
    }

    /**
     * Create an instance of {@link ColumnSetDocument }
     * 
     */
    public ColumnSetDocument createColumnSetDocument() {
        return new ColumnSetDocument();
    }

    /**
     * Create an instance of {@link Agency }
     * 
     */
    public Agency createAgency() {
        return new Agency();
    }

    /**
     * Create an instance of {@link Annotation }
     * 
     */
    public Annotation createAnnotation() {
        return new Annotation();
    }

    /**
     * Create an instance of {@link AnyOtherContent }
     * 
     */
    public AnyOtherContent createAnyOtherContent() {
        return new AnyOtherContent();
    }

    /**
     * Create an instance of {@link AnyOtherLanguageContent }
     * 
     */
    public AnyOtherLanguageContent createAnyOtherLanguageContent() {
        return new AnyOtherLanguageContent();
    }

    /**
     * Create an instance of {@link CodeListRef }
     * 
     */
    public CodeListRef createCodeListRef() {
        return new CodeListRef();
    }

    /**
     * Create an instance of {@link CodeListSetRef }
     * 
     */
    public CodeListSetRef createCodeListSetRef() {
        return new CodeListSetRef();
    }

    /**
     * Create an instance of {@link Column }
     * 
     */
    public Column createColumn() {
        return new Column();
    }

    /**
     * Create an instance of {@link ColumnRef }
     * 
     */
    public ColumnRef createColumnRef() {
        return new ColumnRef();
    }

    /**
     * Create an instance of {@link ColumnSet }
     * 
     */
    public ColumnSet createColumnSet() {
        return new ColumnSet();
    }

    /**
     * Create an instance of {@link ColumnSetRef }
     * 
     */
    public ColumnSetRef createColumnSetRef() {
        return new ColumnSetRef();
    }

    /**
     * Create an instance of {@link Data }
     * 
     */
    public Data createData() {
        return new Data();
    }

    /**
     * Create an instance of {@link DataRestrictions }
     * 
     */
    public DataRestrictions createDataRestrictions() {
        return new DataRestrictions();
    }

    /**
     * Create an instance of {@link DatatypeFacet }
     * 
     */
    public DatatypeFacet createDatatypeFacet() {
        return new DatatypeFacet();
    }

    /**
     * Create an instance of {@link GeneralIdentifier }
     * 
     */
    public GeneralIdentifier createGeneralIdentifier() {
        return new GeneralIdentifier();
    }

    /**
     * Create an instance of {@link Identification }
     * 
     */
    public Identification createIdentification() {
        return new Identification();
    }

    /**
     * Create an instance of {@link Key }
     * 
     */
    public Key createKey() {
        return new Key();
    }

    /**
     * Create an instance of {@link KeyColumnRef }
     * 
     */
    public KeyColumnRef createKeyColumnRef() {
        return new KeyColumnRef();
    }

    /**
     * Create an instance of {@link KeyRef }
     * 
     */
    public KeyRef createKeyRef() {
        return new KeyRef();
    }

    /**
     * Create an instance of {@link LongName }
     * 
     */
    public LongName createLongName() {
        return new LongName();
    }

    /**
     * Create an instance of {@link MimeTypedUri }
     * 
     */
    public MimeTypedUri createMimeTypedUri() {
        return new MimeTypedUri();
    }

    /**
     * Create an instance of {@link Row }
     * 
     */
    public Row createRow() {
        return new Row();
    }

    /**
     * Create an instance of {@link ShortName }
     * 
     */
    public ShortName createShortName() {
        return new ShortName();
    }

    /**
     * Create an instance of {@link SimpleCodeList }
     * 
     */
    public SimpleCodeList createSimpleCodeList() {
        return new SimpleCodeList();
    }

    /**
     * Create an instance of {@link SimpleValue }
     * 
     */
    public SimpleValue createSimpleValue() {
        return new SimpleValue();
    }

    /**
     * Create an instance of {@link Value }
     * 
     */
    public Value createValue() {
        return new Value();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeListDocument }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeListDocument }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/codelist/ns/genericode/1.0/", name = "CodeList")
    public JAXBElement<CodeListDocument> createCodeList(CodeListDocument value) {
        return new JAXBElement<CodeListDocument>(_CodeList_QNAME, CodeListDocument.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeListSetDocument }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeListSetDocument }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/codelist/ns/genericode/1.0/", name = "CodeListSet")
    public JAXBElement<CodeListSetDocument> createCodeListSet(CodeListSetDocument value) {
        return new JAXBElement<CodeListSetDocument>(_CodeListSet_QNAME, CodeListSetDocument.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColumnSetDocument }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ColumnSetDocument }{@code >}
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/codelist/ns/genericode/1.0/", name = "ColumnSet")
    public JAXBElement<ColumnSetDocument> createColumnSet(ColumnSetDocument value) {
        return new JAXBElement<ColumnSetDocument>(_ColumnSet_QNAME, ColumnSetDocument.class, null, value);
    }

}
