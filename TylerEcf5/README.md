# ECF 5 Java Code

This module contains java code [generated by `wsdl2java`](../docs/wsdl2java.md) from the
[Electronic Court Filing v5 standard](https://docs.oasis-open.org/legalxml-courtfiling/ecf/v5.0/ecf-v5.0.html)
WSDL and XML schema files.

ECF v5 is partially used by Tyler Technologies in Illinois to handle court scheduling.
A full implementation of ECF v5 is not present, and is stil [in progress in this GitHub branch](https://github.com/SuffolkLITLab/EfileProxyServer/tree/ecfv5_squash).
Tyler's implementation of ECF v5 is in [a different module](../TylerEcf5/README.md).

This module contains interfaces and implementations of some Major Design Elements (MDEs) from ECF 5:

* [Court Scheduling MDE](src/main/java/https/docs_oasis_open_org/legalxml_courtfiling/ns/v5_0/wsdl/courtschedulingmde/CourtSchedulingMDE_Service.java)
* [Filing Assembly MDE](src/main/java/https/docs_oasis_open_org/legalxml_courtfiling/ns/v5_0/wsdl/filingassemblymde/FilingAssemblyMDE.java)

All other files include the data types that are passed to the interfaces present on these MDEs.

TODO(brycew): the WSDLs / XMLs themselves are still in the `proxyserver` module: they will
eventually be moved here however.

## Difference between this and generated code

* edited javadocs to be able to be compliant (i.e. `&` to `&amp;`, other HTML encoding issues). No substantive changes.