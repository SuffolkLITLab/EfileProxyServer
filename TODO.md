Stuck on generating Java for https://illinois-stage.tylerhost.net/EFM/Schema/ECF-4.0-FilingReviewMDEService.wsdl
```
WARNING: https://illinois-stage.tylerhost.net/EFM/Schema/constraint/niem/fips_6-4/2.0/fips_6-4.xsd [0,0]: Simple type "USCountyCodeSimpleType" was not mapped to Enum due to EnumMemberSizeCap limit. Facets count: 355, current limit: 256. You can use customization attribute "typesafeEnumMaxMembers" to extend the limit.
```
There are a lot of the above. Seem like a simple fix, just need to add the `typesafeEnumMaxMembers` attribute. But where? There are... Too many ideas.

Current file is:
```
<?xml version="1.0"?>
<jaxb:bindings node="wsdl:definitions/wsdl:types/xsd:schema" version="1.0" 
    xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
    xmlns:jaxb="http://java.sun.com/xml/ns/jabx" 
    xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <jaxb:bindings schemaLocation="https://illinois-stage.tylerhost.net/EFM/Schema/constraint/niem/fbi/2.0/fbi.xsd" node="/xsd:schema">
    <jaxb:globalBindings typesafeEnumMaxMembers="2000" xmlns:jaxb="http://java.sun.com/xml/ns/jaxb"/>
  </jaxb:bindings>
</jaxb:bindings>
```
But it's currently not working. Lots of other variations don't seem to work either. No one can seem to give me a canonical way that this shit
is parsed. None of it makes sense.

* https://mail-archives.apache.org/mod_mbox/cxf-users/200808.mbox/%3C0E36CF63779A934D876C5E7FD29E74EB0122C219@XMBIL123.northgrum.com%3E
* https://web.archive.org/web/20150510123147/https://jax-ws.java.net/nonav/2.1.2/docs/customizations.html
* https://stackoverflow.com/questions/15079913/applying-external-jaxb-binding-file-to-schema-elements-imported-from-wsdl
* https://cxf.apache.org/docs/wsdl-to-java.html
