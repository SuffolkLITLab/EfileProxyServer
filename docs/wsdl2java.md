# WSDL2Java: Generating the SOAP code

The proxy server uses SOAP to communicate with Tyler's Efiling Manager servers (EFM). 
SOAP describes the procedure calls that can be made to the server using XML. The SOAP library
that we use, CXF, converts these procedure calls, their arguments, and connections to the EFM,
into generated Java classes that the proxy can use and call.

It's possible for Tyler to update some of these procedure calls or the arguments
that they take. For example, the following error (manually formatted) appeared when Tyler updated the GetPolicy API
call to add a new "LocationSpecificURL" parameter to the returned object:

```
efspjava_1  | javax.xml.ws.soap.SOAPFaultException: Unmarshalling Error: unexpected element (uri:"urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", local:"LocationSpecificUrl"). 
    Expected elements are 
        <{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}AcceptMultipleLeadDocumentsIndicator>,
        <{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}EffectiveDate>,
        <{urn:tyler:ecf:extensions:Common}TimeoutResetHour>,
        <{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}SupportedCaseType>,
        <{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}MaximumAllowedAttachmentSize>,
        <{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}FilingFeesMayBeApplicableIndicator>,
        <{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}SupportedSignatureProfileCode>,
        <{urn:tyler:ecf:extensions:Common}TimeoutMinutes>,
        <{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}ExpirationDate>,
        <{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}MaximumAllowedMessageSize>,
        <{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}CourtExtension>,
        <{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}URLAttachmentSupportedIndicator>,
        <{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}AcceptConfidentialFilingsIndicator>,
        <{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}AcceptDocumentsRequiringFeesIndicator>,
        <{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}SupportedOperationName>,
        <{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}SupportedMessageProfileCode> 
efspjava_1  | 	at org.apache.cxf.jaxws.JaxWsClientProxy.mapException(JaxWsClientProxy.java:195)
efspjava_1  | 	at org.apache.cxf.jaxws.JaxWsClientProxy.invoke(JaxWsClientProxy.java:145)
efspjava_1  | 	at jdk.proxy2/jdk.proxy2.$Proxy92.getPolicy(Unknown Source)
efspjava_1  | 	at edu.suffolk.litlab.efspserver.ecf.OasisEcfFiler.prepareFiling(OasisEcfFiler.java:163)
```

This means our generated java classes are out of date, and we'll need to update
them. This document tries to capture the steps needed to update those generated classes.

Tbh, this is a mess. The rough steps are below.

NOTE: the exact links to the SOAP services in this doc aren't really exact: they're examples.
So if a link says `https://jurisdiction-env.tylerhost.net/efm/EFMUserService.svc`, feel free to replace
the subdomain (the `jurisdiction-env` part) with your subdomain, which depends on what jurisdiction your
working in. For us it's mostly `illinois-stage`.

1. Get your hands on `wsdl2java` from the [CXF project](https://cxf.apache.org/). 
   
   You can download the latest CXF `wsdl2java` pre-built binary from 
   [the official website](https://cxf.apache.org/download.html). Download the zip (verifying
   it as well), and then extract it.
   
   You can confirm things are working because you should be able to run `bin/wsdl2java -help` 
   successfully.
   
   If the pre-built binary doesn't work (might happen if you switch to a new version of Java)
   you can build things from source using [the build instructions](https://github.com/apache/cxf/blob/master/BUILDING.txt).
   (though I don't recommend it, maven dosen't give user-friendly errors when things go wrong).

   The instructions are to 
   ```bash
   git clone https://github.com/apache/cxf.git
   cd cxf
   export MAVEN_OPTS="-Xmx2048M"
   mvn -Pfastinstall,everything`
   ```
   If it fails, run the `mvn -Pfastinstall,everything` a few times (because downloading certain dependencies might time out),
   and then on a particular failure that looks like the following:
   ```
   [INFO] Building: wadl-generate-rx/pom.xml
   [INFO]   The build exited with code 1. See /home/litlab/Developer/LITLab/cxf/maven-plugins/wadl2java-plugin/target/it/wadl-generate-rx/build.log for details.
   [INFO]           wadl-generate-rx/pom.xml ......................... FAILED (10.6 s)
   [INFO] Building: wsdl-artifact-resolution/pom.xml
   [INFO]   The build exited with code 1. See /home/litlab/Developer/LITLab/cxf/maven-plugins/wadl2java-plugin/target/it/wsdl-artifact-resolution/build.log for details.
   [INFO]           wsdl-artifact-resolution/pom.xml ................. FAILED (1.4 s)
   ```
   you should go into that directory (cxf/maven-plugins/wadl2java-plugin) and just run `mvn`.
   TODO(brycew-later): this is still black magic to me, IDK what maven does.
 
   Eventually, `mvn -Pfastinstall,everything` should succeed. You can confirm it worked
   because you should be able to run `cxf/distribution/src/main/release/bin/wsdl2java -help`
   successfully.

2. Download the Services:
   CXF works by first ingesting and parsing the entire XSD that a SOAP service uses before
   being able to start the server. This slows down things a little bit, for about 15 seconds to several
   minutes depending on the service. There are two different ways to download the services that Tyler uses:
   1. The Tyler specific services. These are EfmUserService and EfmFirmService: just download them as a single WSDL!
      The main page (<https://jurisdiction-env.tylerhost.net/efm/EFMUserService.svc>) is kind enough to tell us that:
      
      > You can also access the service description as a single file
      
      So you should just download that file at <https://jurisdiction-env.tylerhost.net/EFM/EFMUserService.svc?singleWsdl>.
      for all of the services that you are using.
   
   2. The ECF services: XsdDownloader. These services are externally defined outside of Tyler, so there isn't
      some nice "get me a single WSDL file" endpoint out there, and the definition of the ECF services uses a
      lot of XML schema documents (XSDs). Thus the solution is to locally download all of those XSD files, and
      make them reference the locally downloaded versions and not the server specific files they originally used.
      That's what `edu.suffolk.litlab.efspserver.XsdDownloader` does! It should be setup through 
      the pom file's exec-maven-plugin, and just runs the `main` function. The command is below:
      ```bash
      mvn exec:java@XsdDownloader -Dexec.args="https://jurisdiction-env.tylerhost.net/EFM/Schema/ECF-4.0-FilingReviewMDEService.wsdl ecf"
      ```
      
      This will download all of the ECF files, giving them a single specific prefix. You'll need to move them
      to the `src/main/resources/wsdl/jurisdiction/env/` folder. You'll want to give the `ecf.xsd` file a better name too, 
      probably the specific service that was downloaded.
      
      Once you have downloaded one, the good news is that the XSD for all the rest is exactly the same!
      So instead of running XsdDownloader again, you can just directly visit it's URL and save the file
      to `src/main/resources/wsdl/jurisdiction/env` with a good name. Nice.
      
      The base url of these urls are: https://jurisdiction-env.tylerhost.net/EFM/Schema/
      The full list of these services are:
      * ECF-4.0-FilingReviewMDEService.wsdl
      * ECF-4.0-FilingAssemblyMDEService.wsdl
      * ECF-4.0-CourtRecordMDEService.wsdl
      * ECF-4.0-ServiceMDEService.wsdl
      
      The last one is v5/CourtSchedulingMDE.wsdl. It _doesn't_ have the same XSDs as the rest, as it's based on 
      ECF v5, not ECF v4. So just run 
      ```bash
      mvn exec:java@XsdDownloader -Dexec.args="https://jurisdiction-env.tylerhost.net/EFM/Schema/v5/CourtScheduling.wsdl ecf-v5"
      ```
      and move all the files to a different resource directory, this time `src/main/resources/wsdl/jurisdiction/v5`.
      Don't forget to rename `ecf-v5` to `CourtSchedulingMDE.wsdl`
   

3. Run wsdl2java on a download Operation / Service wsdls that you have downloaded. For example:

   ```bash
   ./wsdl2java -client -b $HOME/bindings.xjb -xjc-Xts -d $HOME/tmp_wsdls/ -verbose ECF-4.0-FilingReviewMDEService.wsdl
   ```
   
   The list of things to this on is:
   * EFMFirmServiceSingle.svc.wsdl
   * EFMUSerServiceSingle.svc.wsdl
   * ECF-4.0-FilingReviewMDEService.wsdl
   * ECF-4.0-FilingAssemblyMDEService.wsdl
   * ECF-4.0-CourtRecordMDEService.wsdl
   * ECF-4.0-ServiceMDEService.wsdl
   

   These options are documented on the [main CXF site](http://cxf.apache.org/docs/wsdl-to-java.html),
   but to break it down:

   * `-b` passes a JAXB binding xml file directly to JAXB. You shouldn't pass it to the EFMFirmServiceSingle.svc.wsdl 
       and EFMUserServiceSingle.svc.wsdl files.
      (NOTE(brycew): this doesn't work perfectly , but you can specify at least one file to expand the Enum members on. :/)
      The file looks like this:
      ```xml
      <?xml version="1.0" ?>
      <jaxb:bindings version="1.0" xmlns:jaxb="http://java.sun.com/xml/ns/jaxb"
	         xmlns:xsd="http://www.w3.org/2001/XMLSchema">
          <jaxb:bindings schemaLocation="filingreview/ecf-11.xsd"> 
              <jaxb:globalBindings typesafeEnumMaxMembers="1024"/>
          </jaxb:bindings>
       </jaxb:bindings>
      ```
   * `-xjc-Xts` makes better `toString` methods. Should honestly be default.
   * `-d` puts all of the generated java into that directory. This is outside of the project root, so I don't accidentaly
     overwrite anything when running the tool.

   For the CourtSchedulingMDE.wsdl, we need to add a sub package, so it doesn't conflict with the ecfv4 generated files from the other
   services. This should be able to be done with the `-p` flag in the [`wsdl2java` tool](https://cxf.apache.org/docs/wsdl-to-java.html).
   However, that flag collapses all of the wsdl namespaces into a single namespace. Generating the java files with the same command above,
   and running the below script on it to add an additional package works instead.

   ```bash
   for fname in `find . -type f`
   do
     sed -i 's/import \(gov.niem.release.niem\|https.docs_oasis_open_org\|ietf.params.xml.ns.icalendar_2\|org.w3._2000._09.xmldsig_\|oasis.names.specification.ubl.schema.xsd\|tyler.ecf.v5_0\|un.unece.uncefact.data.specification\)/import ecfv5.\1/g' $fname
   done
   ```

