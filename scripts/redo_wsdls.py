#!/usr/bin/env -S uv run --script
#
# /// script
# requires-python = ">=3.12"
# dependencies = ["requests", "plumbum"]
# ///

"""
To run you must:

* have CXF installed on the PATH env var (really just wsdl2java)
* have maven and Java (21) installed locally

"""

import sys
import os
import re
import requests
import shutil
import glob
from plumbum import local, FG, BG

# Check that wsdl2java and other comands are installed correctly
wsdl2java = local.cmd.wsdl2java
(wsdl2java['-v'] > "/dev/null")
java = local['java']
(java['--version'] > "/dev/null")
mkdir = local['mkdir']
sed = local["gsed"]

bindings_xjb_contents_ecf4 = f"""<?xml version="1.0" ?>
<jaxb:bindings version="3.0" xmlns:jaxb="http://jakarta.ee/xml/ns/jaxb"
  xmlns:xsd="http://www.w3.org/2001/XMLSchema">
    <jaxb:bindings schemaLocation="ecf-11.xsd">
        <jaxb:globalBindings typesafeEnumMaxMembers="2048"/>
    </jaxb:bindings>
</jaxb:bindings>
"""

bindings_xjb_contents_ecf5 = f"""<?xml version="1.0" ?>
<jaxb:bindings version="3.0" xmlns:jaxb="http://jakarta.ee/xml/ns/jaxb"
  xmlns:xsd="http://www.w3.org/2001/XMLSchema">
    <jaxb:bindings schemaLocation="ecfv5-50c18fb2bdc50976.xsd">
        <jaxb:globalBindings typesafeEnumMaxMembers="2048"/>
    </jaxb:bindings>
</jaxb:bindings>
"""

wsdl_templates = {
  "efm_user": """<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions name="EfmUserService" targetNamespace="urn:tyler:efm:services"
    xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
    xmlns:tns="urn:tyler:efm:services"
    xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/">
	<wsdl:import location="../Base-EFMUserService.wsdl"
		namespace="urn:tyler:efm:services" />
    <wsdl:service name="EfmUserService">
        <wsdl:port name="BasicHttpBinding_IEfmUserService"
            binding="tns:BasicHttpBinding_IEfmUserService">
            <soap:address location="https://{domain}.tylertech.cloud/EFM/EFMUserService.svc" />
        </wsdl:port>
        <wsdl:port name="BasicHttpBinding_IEfmUserService1"
            binding="tns:BasicHttpBinding_IEfmUserService1">
            <soap:address
                location="https://{domain}.tylertech.cloud/EFM/EFMUserService.svc/test" />
        </wsdl:port>
    </wsdl:service>
</wsdl:definitions>
""",
  "efm_firm": """<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions name="EfmFirmService" targetNamespace="urn:tyler:efm:services"
    xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
    xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
    xmlns:tns="urn:tyler:efm:services">
	<wsdl:import location="../Base-EFMFirmService.wsdl"
		namespace="urn:tyler:efm:services" />
    <wsdl:service name="EfmFirmService">
        <wsdl:port name="BasicHttpBinding_IEfmFirmService"
            binding="tns:BasicHttpBinding_IEfmFirmService">
            <soap:address location="https://{domain}.tylertech.cloud/EFM/EFMFirmService.svc" />
        </wsdl:port>
        <wsdl:port name="BasicHttpBinding_IEfmFirmService1"
            binding="tns:BasicHttpBinding_IEfmFirmService1">
            <soap:address
                location="https://{domain}.tylertech.cloud/EFM/EFMFirmService.svc/test" />
        </wsdl:port>
    </wsdl:service>
</wsdl:definitions>
""",
  "court_record_4": """<definitions
	xmlns:wsmp="urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0"
	xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
	xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns="http://schemas.xmlsoap.org/wsdl/"
	targetNamespace="urn:tyler:efm:wsdl:WebServicesProfile-Implementation-4.0">
	<import
		namespace="urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0"
		location="../base/ecf-22797dcc66358418.xsd" />
	<service name="CourtRecordMDEService">
		<port name="CourtRecordMDEPort" binding="wsmp:CourtRecordMDEPortSOAPBinding">
			<soap:address
				location="https://{domain}.tylertech.cloud/efm/CourtRecordMDEPort.svc" />
		</port>
	</service>
</definitions>
""",
  "filing_assembly_4": """<definitions
	xmlns:wsmp="urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0"
	xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
	xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns="http://schemas.xmlsoap.org/wsdl/"
	targetNamespace="urn:tyler:efm:wsdl:WebServicesProfile-Implementation-4.0">
	<import
		namespace="urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0"
		location="../base/ecf-22797dcc66358418.xsd" />
	<service name="FilingAssemblyMDEService">
		<port name="FilingAssemblyMDEPort" binding="wsmp:FilingAssemblyMDEPortSOAPBinding">
      <soap:address location="https://efile.suffolklitlab.org/jurisdictions/{jurisdiction}/filingassembly/callbacks/FilingAssemblyMDEPort"/>
		</port>
	</service>
</definitions>
""",
  "filing_review_4": """<definitions xmlns="http://schemas.xmlsoap.org/wsdl/"
	xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
	xmlns:wsmp="urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0"
	xmlns:xsd="http://www.w3.org/2001/XMLSchema"
	targetNamespace="urn:tyler:efm:wsdl:WebServicesProfile-Implementation-4.0">
	<import location="../base/ecf-22797dcc66358418.xsd"
		namespace="urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0" />
	<service name="FilingReviewMDEService">
		<port binding="wsmp:FilingReviewMDEPortSOAPBinding" name="FilingReviewMDEPort">
			<soap:address
				location="https://{domain}.tylertech.cloud/efm/FilingReviewMDEPort.svc" />
		</port>
	</service>
</definitions>
""",
  "service_4": """<definitions
	xmlns:wsmp="urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0"
	xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
	xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns="http://schemas.xmlsoap.org/wsdl/"
	targetNamespace="urn:tyler:efm:wsdl:WebServicesProfile-Implementation-4.0">
	<import
		namespace="urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0"
		location="../base/ecf-22797dcc66358418.xsd" />
	<service name="ServiceMDEService">
		<port name="ServiceMDEPort" binding="wsmp:ServiceMDEPortSOAPBinding">
			<soap:address location="https://{domain}.tylertech.cloud/efm/ServiceMDEPort.svc" />
		</port>
	</service>
</definitions>
""",
  "court_scheduling_4": """<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<definitions xmlns="http://schemas.xmlsoap.org/wsdl/" 
    xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" 
    xmlns:tns="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/WSDL/CourtSchedulingMDE" 
    xmlns:wrapper="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/MessageWrappers" 
    xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy" 
    xmlns:wsrmp="http://docs.oasis-open.org/ws-rx/wsrmp/200702" 
    xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" 
    xmlns:xsd="http://www.w3.org/2001/XMLSchema" 
    targetNamespace="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/WSDL/CourtSchedulingMDE">
  <!-- NOTE(brycew): had to remove 361 at the suggestion of: https://issues.apache.org/jira/browse/CXF-7402 -->
	<wsdl:types>
		<xsd:schema>
			<xsd:import namespace="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/MessageWrappers" schemaLocation="../base/ecf-v5-acb77b04f630a868.xsd"/>
		</xsd:schema>
	</wsdl:types>
	<message name="GetCourtScheduleRequest">
		<part element="wrapper:GetCourtScheduleRequest" name="body"/>
	</message>
	<message name="GetCourtScheduleResponse">
		<part element="wrapper:GetCourtScheduleResponse" name="body"/>
	</message>
	<message name="NotifyCourtDateRequest">
		<part element="wrapper:NotifyCourtDateRequest" name="body"/>
	</message>
	<message name="NotifyCourtDateResponse">
		<part element="wrapper:NotifyCourtDateResponse" name="body"/>
	</message>
	<message name="ReserveCourtDateRequest">
		<part element="wrapper:ReserveCourtDateRequest" name="body"/>
	</message>
	<message name="ReserveCourtDateResponse">
		<part element="wrapper:ReserveCourtDateResponse" name="body"/>
	</message>
	<message name="ReserveCourtDateSyncResponse">
		<part element="wrapper:ReserveCourtDateSyncResponse" name="body"/>
	</message>
  <message name="GetReturnDateRequest">
    <part element="wrapper:ReturnDateRequest" name="body"/>
  </message>
  <message name="GetReturnDateResponse">
    <part element="wrapper:ReturnDateResponse" name="body"/>
  </message>
	<portType name="CourtSchedulingMDE">
		<operation name="GetCourtSchedule">
			<input message="tns:GetCourtScheduleRequest"/>
			<output message="tns:GetCourtScheduleResponse"/>
		</operation>
		<operation name="NotifyCourtDate">
			<input message="tns:NotifyCourtDateRequest"/>
			<output message="tns:NotifyCourtDateResponse"/>
		</operation>
		<!-- NOTE(brycew): modified from original: Tyler docs only mention the Sync version of
			this operation, and it's not possible for Two operations on a port to have the same Arg signature,
		which this and ReserveCourtDateSync do. So this must go. -->
		<!--operation name="ReserveCourtDate">
			<input message="tns:ReserveCourtDateRequest"/>
			<output message="tns:ReserveCourtDateResponse"/>
		</operation-->
		<operation name="ReserveCourtDateSync">
			<input message="tns:ReserveCourtDateRequest"/>
			<output message="tns:ReserveCourtDateSyncResponse"/>
		</operation>
    <operation name="GetReturnDate">
      <input message="tns:GetReturnDateRequest"/>
      <output message="tns:GetReturnDateResponse"/>
    </operation>
	</portType>
	<binding name="CourtSchedulingMDESoap" type="tns:CourtSchedulingMDE">
		<soap:binding style="document" transport="http://schemas.xmlsoap.org/soap/http"/>
		<wsp:PolicyReference URI="#EFMPolicy"/>
		<operation name="GetCourtSchedule">
			<soap:operation soapAction="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/WSDL/CourtSchedulingMDE/GetCourtSchedule"/>
			<input>
				<soap:body use="literal"/>
			</input>
			<output>
				<soap:body use="literal"/>
			</output>
		</operation>
		<operation name="NotifyCourtDate">
			<soap:operation soapAction="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/WSDL/CourtSchedulingMDE/NotifyCourtDate"/>
			<input>
				<soap:body use="literal"/>
			</input>
			<output>
				<soap:body use="literal"/>
			</output>
		</operation>
		<!--operation name="ReserveCourtDate">
			<soap:operation soapAction="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/WSDL/CourtSchedulingMDE/ReserveCourtDate"/>
			<input>
				<soap:body use="literal"/>
			</input>
			<output>
				<soap:body use="literal"/>
			</output>
		</operation-->
		<operation name="ReserveCourtDateSync">
			<soap:operation soapAction="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/WSDL/CourtSchedulingMDE/ReserveCourtDateSync"/>
			<input>
				<soap:body use="literal"/>
			</input>
			<output>
				<soap:body use="literal"/>
			</output>
		</operation>
    <operation name="GetReturnDate">
      <soap:operation soapAction="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/WSDL/CourtSchedulingMDE/GetReturnDate"/>
      <input>
        <soap:body use="literal"/>
      </input>
      <output>
        <soap:body use="literal"/>
      </output>
    </operation>
	</binding>
	<service name="CourtSchedulingMDE">
		<port binding="tns:CourtSchedulingMDESoap" name="CourtSchedulingMDEPort">
		    <!-- NOTE(brycew): manually added location here, the given URL was bad. -->
			<soap:address location="https://{domain}.tylertech.cloud/efm/CourtSchedulingMDE.svc"/>
		</port>
	</service>
	<wsp:UsingPolicy wsdl:required="true"/>
	<wsp:Policy wsu:Id="EFMPolicy">
		<wsp:ExactlyOne>
			<wsp:All>
				<wsoma:OptimizedMimeSerialization xmlns:wsoma="http://schemas.xmlsoap.org/ws/2004/09/policy/optimizedmimeserialization"/>
				<sp:TransportBinding xmlns:sp="http://schemas.xmlsoap.org/ws/2005/07/securitypolicy">
					<wsp:Policy>
						<sp:TransportToken>
							<wsp:Policy>
								<sp:HttpsToken RequireClientCertificate="false"/>
							</wsp:Policy>
						</sp:TransportToken>
						<sp:AlgorithmSuite>
							<wsp:Policy>
								<sp:Basic256/>
							</wsp:Policy>
						</sp:AlgorithmSuite>
						<sp:Layout>
							<wsp:Policy>
								<sp:Lax/>
							</wsp:Policy>
						</sp:Layout>
						<sp:IncludeTimestamp/>
					</wsp:Policy>
				</sp:TransportBinding>
				<sp:EndorsingSupportingTokens xmlns:sp="http://schemas.xmlsoap.org/ws/2005/07/securitypolicy">
					<wsp:Policy>
						<sp:X509Token sp:IncludeToken="http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/AlwaysToRecipient">
							<wsp:Policy>
								<sp:WssX509V3Token10/>
							</wsp:Policy>
						</sp:X509Token>
					</wsp:Policy>
				</sp:EndorsingSupportingTokens>
				<sp:Wss10 xmlns:sp="http://schemas.xmlsoap.org/ws/2005/07/securitypolicy">
					<wsp:Policy>
						<sp:MustSupportRefKeyIdentifier/>
						<sp:MustSupportRefIssuerSerial/>
					</wsp:Policy>
				</sp:Wss10>
			</wsp:All>
		</wsp:ExactlyOne>
	</wsp:Policy>
</definitions>
""",
  "court_policy_5": """<?xml version="1.0" encoding="UTF-8"?>
<definitions targetNamespace="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/CourtPolicyMDE" xmlns:wsmp="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/CourtPolicyMDE" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns="http://schemas.xmlsoap.org/wsdl/">
	<import namespace="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/CourtPolicyMDE" location="../base/CourtPolicyMDE.wsdl"/>
	<import namespace="urn:tyler:ecf:v5.0:extensions:common" location="../base/ecfv5-dd545670aa04333d.xsd"/>
	<service name="CourtPolicyMDEService">
		<port name="CourtPolicyMDE" binding="wsmp:CourtPolicyMDESoap">
			<soap:address location="https://{domain}.tylertech.cloud/efm/v5/CourtPolicyservice.svc"/>
		</port>
	</service>
</definitions>
""",
  "court_record_5": """<?xml version="1.0" encoding="UTF-8"?>

<definitions targetNamespace="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/CourtRecordMDE" xmlns:wsmp="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/CourtRecordMDE" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns="http://schemas.xmlsoap.org/wsdl/">
	<import location="../base/CourtRecordMDE.wsdl" namespace="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/CourtRecordMDE"/>
	<import location="../base/ecfv5-criminal-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:criminal"/>
	<import location="../base/ecfv5-massachusetts-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:massachusetts"/>
	<import location="../base/ecfv5-taxdelinquency-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:taxdelinquency"/>
	<service name="CourtRecordMDEService">
		<port name="CourtRecordMDE" binding="wsmp:CourtRecordMDESoap">
			<soap:address location="https://{domain}.tylertech.cloud/efm/v5/courtrecordservice.svc"/>
		</port>
	</service>
</definitions>
""",
  "court_schedule_5": """<?xml version="1.0" encoding="UTF-8"?>

<definitions targetNamespace="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/CourtSchedulingMDE" xmlns:wsmp="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/CourtSchedulingMDE" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns="http://schemas.xmlsoap.org/wsdl/">
	
	<import location="../base/CourtSchedulingMDE.wsdl" namespace="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/CourtSchedulingMDE"/>
	<import location="../base/ecfv5-criminal-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:criminal"/>
	<import location="../base/ecfv5-massachusetts-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:massachusetts"/>
	<import location="../base/ecfv5-taxdelinquency-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:taxdelinquency"/>
	<import location="../base/ecfv5-43e22a9b317738fe.xsd" namespace="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil"/>
	<service name="CourtSchedulingMDEService">
		<port name="CourtSchedulingMDE" binding="wsmp:CourtSchedulingMDESoap">
			<soap:address location="https://{domain}.tylertech.cloud/efm/v5/courtschedulingservice.svc"/>
		</port>
	</service>
</definitions>
""",
  "filing_review_5": """<?xml version="1.0" encoding="UTF-8"?>

<definitions targetNamespace="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/FilingReviewMDE" xmlns:wsmp="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/FilingReviewMDE" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns="http://schemas.xmlsoap.org/wsdl/">
	<import location="../base/FilingReviewMDE.wsdl" namespace="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/FilingReviewMDE"/>
	<import location="../base/ecfv5-dd545670aa04333d.xsd" namespace="urn:tyler:ecf:v5.0:extensions:common"/>
	<import location="../base/ecfv5-criminal-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:criminal"/>
	<import location="../base/ecfv5-massachusetts-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:massachusetts"/>
	<import location="../base/ecfv5-taxdelinquency-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:taxdelinquency"/>
	<service name="FilingReviewMDEService">
		<port name="FilingReviewMDE" binding="wsmp:FilingReviewMDESoap">
			<soap:address location="https://{domain}.tylertech.cloud/efm/v5/filingreviewservice.svc"/>
		</port>
	</service>
</definitions>
""",
  "filing_assembly_5": """
""",
  "service_5": """<?xml version="1.0" encoding="UTF-8"?>

<definitions xmlns="http://schemas.xmlsoap.org/wsdl/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:wsmp="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/ServiceMDE" xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:xsd="http://www.w3.org/2001/XMLSchema" targetNamespace="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/ServiceMDE">
	<import location="../base/ServiceMDE.wsdl" namespace="https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/ServiceMDE"/>
	<import location="../base/ecfv5-dd545670aa04333d.xsd" namespace="urn:tyler:ecf:v5.0:extensions:common"/>
	<import location="../base/ecfv5-criminal-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:criminal"/>
	<import location="../base/ecfv5-massachusetts-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:massachusetts"/>
	<import location="../base/ecfv5-taxdelinquency-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:taxdelinquency"/>
	<service name="ServiceMDEService">
		<port binding="wsmp:ServiceMDESoap" name="ServiceMDE">
			<soap:address location="https://{domain}.tylertech.cloud/efm/v5/service.svc"/>
		</port>
	</service>
</definitions>
""",
  "tyler_record_5": """<?xml version="1.0" encoding="UTF-8"?>

<definitions targetNamespace="urn:tyler:ecf:v5.0:extensions:TylerCourtRecordMDE" xmlns:wsmp="urn:tyler:ecf:v5.0:extensions:TylerCourtRecordMDE" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns="http://schemas.xmlsoap.org/wsdl/">
	<import location="../base/TylerCourtRecordMDE.wsdl" namespace="urn:tyler:ecf:v5.0:extensions:TylerCourtRecordMDE"/>
	<import location="../base/ecfv5-dd545670aa04333d.xsd" namespace="urn:tyler:ecf:v5.0:extensions:common"/>
	<import location="../base/ecfv5-criminal-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:criminal"/>
	<import location="../base/ecfv5-massachusetts-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:massachusetts"/>
	<import location="../base/ecfv5-taxdelinquency-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:taxdelinquency"/>

	<service name="TylerCourtRecordMDEService">
		<port name="TylerCourtRecordMDE" binding="wsmp:TylerCourtRecordMDESoap">
			<soap:address location="https://{domain}.tylertech.cloud/efm/v5/tylercourtrecordservice.svc"/>
		</port>
	</service>
</definitions>
""",
  "tyler_schedule_5": """<?xml version="1.0" encoding="UTF-8"?>

<definitions targetNamespace="urn:tyler:ecf:v5.0:extensions:TylerCourtSchedulingMDE" xmlns:wsmp="urn:tyler:ecf:v5.0:extensions:TylerCourtSchedulingMDE" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns="http://schemas.xmlsoap.org/wsdl/">
	
	<import location="../base/TylerCourtSchedulingMDE.wsdl" namespace="urn:tyler:ecf:v5.0:extensions:TylerCourtSchedulingMDE"/>

	<service name="TylerCourtSchedulingMDEService">
		<port name="TylerCourtSchedulingMDE" binding="wsmp:TylerCourtSchedulingMDESoap">
			<soap:address location="https:/{domain}.tylertech.cloud/efm/v5/tylercourtschedulingservice.svc"/>
		</port>
	</service>
</definitions>
""",
  "tyler_assembly_5": """<?xml version="1.0" encoding="UTF-8"?>

<definitions targetNamespace="urn:tyler:ecf:v5.0:extensions:TylerFilingAssemblyMDE" xmlns:wsmp="urn:tyler:ecf:v5.0:extensions:TylerFilingAssemblyMDE" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns="http://schemas.xmlsoap.org/wsdl/">
	<import location="../base/TylerFilingAssemblyMDE.wsdl" namespace="urn:tyler:ecf:v5.0:extensions:TylerFilingAssemblyMDE"/>
	<import location="../base/ecfv5-dd545670aa04333d.xsd" namespace="urn:tyler:ecf:v5.0:extensions:common"/>

	<service name="TylerFilingAssemblyMDEService">
		<port name="TylerFilingAssemblyMDE" binding="wsmp:TylerFilingAssemblyMDESoap">
			<soap:address location="https://efile.suffolklitlab.org/jurisdictions/{jurisdiction}/filingassembly/callbacks/FilingAssemblyMDEPort"/>
		</port>
	</service>
</definitions>
""",
  "tyler_review_5": """<?xml version="1.0" encoding="UTF-8"?>

<definitions targetNamespace="urn:tyler:ecf:v5.0:extensions:TylerFilingReviewMDE" xmlns:wsmp="urn:tyler:ecf:v5.0:extensions:TylerFilingReviewMDE" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns="http://schemas.xmlsoap.org/wsdl/">
	<import location="../base/TylerFilingReviewMDE.wsdl" namespace="urn:tyler:ecf:v5.0:extensions:TylerFilingReviewMDE"/>
	<import location="../base/ecfv5-criminal-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:criminal"/>
	<import location="../base/ecfv5-massachusetts-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:massachusetts"/>
	<import location="../base/ecfv5-taxdelinquency-extension.xsd" namespace="urn:tyler:ecf:v5.0:extensions:taxdelinquency"/>
	<service name="TylerFilingReviewMDEService">
		<port name="TylerFilingReviewMDE" binding="wsmp:TylerFilingReviewMDESoap">
			<soap:address location="https://{domain}.tylertech.cloud/efm/v5/filingreviewservice.svc" />
		</port>
	</service>
</definitions>
""",
}

versions = ["v2022_1", "v2024_6", "v2025_0"]
existing_jurisdictions = ["illinois", "vermont", "indiana", "california", "texas", "massachusetts"]

def write_file(path, service_name, domain="", jurisdiction=""):
  with open(path, 'w') as f:
    f.write(wsdl_templates[service_name].format(jurisdiction=jurisdiction, domain=domain))

def add_domain_efm(version, env, juris, start_dir="."):
  domain = make_domain(juris, env)
  efm_prefix = f"{start_dir}/../TylerEfmClient/src/main/resources/wsdl/{version}/{env}/{juris}-EFM"
  write_file(efm_prefix + "UserServiceSingle.svc.wsdl", 'efm_user', domain)
  write_file(efm_prefix + "FirmServiceSingle.svc.wsdl", 'efm_firm', domain)

def add_domain_ecf4(version, env, juris, start_dir="."):
  domain = make_domain(juris, env)
  ecf4_prefix = f"{start_dir}/../TylerEcf4/src/main/resources/wsdl/{version}/{env}/{juris}-ECF-4.0-"
  write_file(ecf4_prefix + "CourtRecordMDEService.wsdl", 'court_record_4', domain)
  write_file(ecf4_prefix + "FilingAssemblyMDEService.wsdl", 'filing_assembly_4', domain, juris)
  write_file(ecf4_prefix + "FilingReviewMDEService.wsdl", 'filing_review_4', domain)
  write_file(ecf4_prefix + "ServiceMDEService.wsdl", 'service_4', domain)

  # The "ecf-5 in ecf-4" bit
  if juris == 'illinois':
    ecf4_prefix = f"{start_dir}/../TylerEcf4/src/main/resources/wsdl/{version}/{env}/{juris}-v5-"
    write_file(ecf4_prefix + "CourtSchedulingMDE.wsdl", 'court_scheduling_4', domain)


def add_domain_ecf5(version, env, juris, start_dir="."):
  domain = make_domain(juris, env)
  ecf5_prefix = f"{start_dir}/../TylerEcf5/src/main/resources/wsdl/{version}/{env}/{juris}-ECF5-"
  write_file(ecf5_prefix + "CourtPolicyMDEService.wsdl", 'court_policy_5', domain)
  write_file(ecf5_prefix + "CourtRecordMDEService.wsdl", 'court_record_5', domain)
  write_file(ecf5_prefix + "CourtSchedulingMDEService.wsdl", 'court_schedule_5', domain)
  write_file(ecf5_prefix + "FilingReviewMDEService.wsdl", 'filing_review_5', domain)
  write_file(ecf5_prefix + "FilingAssemblyMDEService.wsdl", 'filing_assembly_5', domain, juris)
  write_file(ecf5_prefix + "ServiceMDEService.wsdl", 'service_5', domain)
  write_file(ecf5_prefix + "TylerCourtRecordMDEService.wsdl", 'tyler_record_5', domain)
  write_file(ecf5_prefix + "TylerCourtSchedulingMDEService.wsdl", 'tyler_schedule_5', domain)
  write_file(ecf5_prefix + "TylerFilingAssemblyMDEService.wsdl", 'tyler_assembly_5', domain, juris)
  write_file(ecf5_prefix + "TylerFilingReviewMDEService.wsdl", 'tyler_review_5', domain)

def make_domain(jurisdiction, env):
  if env == "prod":
    return jurisdiction
  else:
    return jurisdiction + "-" + env

def add_new_jurisdiction(juris, env):
  """
  params:
    juris: the name of the jurisdiction
    env: either stage or prod
  """

  domain = make_domain(juris, env)

  for version in versions:
    add_domain_efm(version, env, juris)
    add_domain_ecf4(version, env, juris)
    add_domain_ecf5(version, env, juris)

def add_new_efm_version(version, url):
  start_dir = os.getcwd()
  path_prefix = f"../TylerEfmClient/src/main/resources/wsdl/{version}/"
  mkdir['-p', path_prefix] & FG

  efm_user_postfix = "/EFM/EFMUserService.svc?singleWsdl"
  r = requests.get(url + efm_user_postfix)
  content = re.sub("<wsdl:service.*</wsdl:service>", "", r.text, flags=re.DOTALL)
  with open(path_prefix + 'Base-EFMUserService.wsdl', 'w') as f:
    # Remove the service from the single WSDL: it goes in individual jurisdiction files now.
    f.write(content)

  efm_firm_postfix = "/EFM/EFMFirmService.svc?singleWsdl"
  r = requests.get(url + efm_firm_postfix)
  content = re.sub("<wsdl:service.*</wsdl:service>", "", r.text, flags=re.DOTALL)
  with open(path_prefix + 'Base-EFMFirmService.wsdl', 'w') as f:
    # Remove the service from the single WSDL: it goes in individual jurisdiction files now.
    f.write(content)

  # Copy all of the jurisdictions to the new version
  for env in ['prod', 'stage']:
    mkdir['-p', f'{path_prefix}/{env}'] & FG
    for jurisdiction in existing_jurisdictions:
      add_domain_efm(version, env, jurisdiction)

  java_prefix = "../TylerEfmClient/src/main/java/"
  wsdl2java['-xjc-Xts', '-d', java_prefix, '-verbose', f'{path_prefix}/stage/illinois-EFMUserServiceSingle.svc.wsdl'] & FG
  wsdl2java['-xjc-Xts', '-d', java_prefix, '-verbose', f'{path_prefix}/stage/illinois-EFMFirmServiceSingle.svc.wsdl'] & FG

  # TODO: automatically find what latest should go to?
  old_version = "v2025_0"
  os.chdir(f"{java_prefix}/tyler/efm")
  shutil.rmtree(old_version, ignore_errors=True)
  os.rename("latest", old_version)
  files = glob.glob(f"{old_version}/**/**.java", recursive=True)
  for file in files:
    sed["-i", 's/tyler\\.efm\\.latest\\.services/tyler.efm.v2025_0.services/g', file] & FG
    
  mkdir["latest"]
  shutil.move("services", "latest/services")
  latest_files = glob.glob(f"latest/**/**.java", recursive=True)
  for file in latest_files:
    sed["-i", 's/tyler\\.efm\\.services/tyler.efm.latest.services/g', file] & FG

  os.chdir(start_dir)

def add_new_ecf4_version(version, url):
  # TODO: court scheduling for IL?
  start_dir = os.getcwd()
  path_prefix = f"../TylerEcf4/src/main/resources/wsdl/{version}"
  mkdir['-p', f"{path_prefix}/base"] & FG
  os.chdir(f"{path_prefix}/base")
  for ecf_wsdl in ['ECF-4.0-FilingReviewMDEService.wsdl', 'ECF-4.0-FilingAssemblyMDEService.wsdl', 'ECF-4.0-CourtRecordMDEService.wsdl', 'ECF-4.0-ServiceMDEService.wsdl']:
    args = f'{url}/EFM/Schema/{ecf_wsdl} ecf'
    java['-cp', f'{start_dir}/../proxyserver/target/efspserver-with-deps.jar', 'edu.suffolk.litlab.efsp.utils.XsdDownloader', args] & FG
    local.get('rm')['-f', 'ecf.xsd'] & FG

  # The one dumb ECF 5 stuff that's necessary
  args = f'{url}/EFM/Schema/v5/CourtSchedulingMDE.wsdl ecf-v5'
  java['-cp', f'{start_dir}/../proxyserver/target/efspserver-with-deps.jar', 'edu.suffolk.litlab.efsp.utils.XsdDownloader', args] & FG
  # local.get('rm')['-f', 'ecf-v5.xsd'] & FG

  for env in ['prod', 'stage']:
    mkdir['-p', f'{start_dir}/{path_prefix}/{env}'] & FG
    for jurisdiction in existing_jurisdictions:
      add_domain_ecf4(version, env, jurisdiction, start_dir=start_dir)

  with open('bindings.xjb', 'w') as f:
    f.write(bindings_xjb_contents_ecf4)

  unused = input("PAUSE HERE: go edit and add `civil.xsd` and `hs.xsd` to the new version")

  java_prefix = f"{start_dir}/../TylerEcf4/src/main/java/"
  wsdl2java['-xjc-Xts', '-d', java_prefix, f'{start_dir}/{path_prefix}/stage/illinois-ECF-4.0-CourtRecordMDEService.wsdl'] & FG
  wsdl2java['-xjc-Xts', '-d', java_prefix, f'{start_dir}/{path_prefix}/stage/illinois-ECF-4.0-FilingReviewMDEService.wsdl'] & FG
  wsdl2java['-xjc-Xts', '-d', java_prefix, f'{start_dir}/{path_prefix}/stage/illinois-ECF-4.0-FilingAssemblyMDEService.wsdl'] & FG
  wsdl2java['-xjc-Xts', '-d', java_prefix, f'{start_dir}/{path_prefix}/stage/illinois-ECF-4.0-ServiceMDEService.wsdl'] & FG
  wsdl2java['-xjc-Xts', '-d', java_prefix, f'{start_dir}/{path_prefix}/stage/illinois-v5-CourtSchedulingMDE.wsdl'] & FG

  old_version = "v2025_0"
  os.chdir(f"{java_prefix}/ecf4")
  print("moving to old version")
  shutil.rmtree(old_version, ignore_errors=True)
  os.rename("latest", old_version)
  files = glob.glob(f"{old_version}/**/**.java", recursive=True)
  for file in files:
    sed['-i', f's/ecf4\\.latest\\./ecf4.{old_version}./g', file] & FG

  os.chdir(f"{java_prefix}")
  mkdir["ecf4/latest"]
  all_subpkgs = ["gov", "https", "ietf", "oasis", "org", "tyler", "un"]
  for subpkg in all_subpkgs:
    shutil.move(subpkg, f"ecf4/latest/{subpkg}")
  latest_files = glob.glob(f"ecf4/latest/**/**.java", recursive=True)
  long_subpkgs = ["gov", "https", "ietf", "oasis", "org.w3._2000", "tyler", "un"]
  for file in latest_files:
    for subpkg in long_subpkgs:
      sed['-E', '-i', f's/([ (<]){subpkg.replace(".", "\\.")}\\./\\1ecf4.latest.{subpkg}./g', file] & FG

  os.chdir(start_dir)

def add_new_ecf5_version(version, url):
  start_dir = os.getcwd()
  path_prefix = f"../TylerEcf5/src/main/resources/wsdl/{version}"
  mkdir['-p', f"{path_prefix}/base"] & FG

  os.chdir(f"{path_prefix}/base")
  for ecf_wsdl in ['CourtPolicyMDE.wsdl', 'CourtRecordMDE.wsdl', 'CourtSchedulingMDE.wsdl', 'FilingReviewMDE.wsdl', 'ServiceMDE.wsdl', 'TylerCourtRecordMDE.wsdl', 'TylerCourtScheduling.wsdl', 'TylerFilingAssemblyMDE.wsdl', 'TylerFilingReviewMDE.wsdl']:
    args = f'{url}/EFM/Schema/ecf5.0/wsi/schema/{ecf_wsdl} ecf'
    java['-cp', f'{start_dir}/../proxyserver/target/efspserver-with-deps.jar', 'edu.suffolk.litlab.efsp.utils.XsdDownloader', args] & FG
    local.get('rm')['-f', 'ecf.xsd'] & FG

  for env in ['prod', 'stage']:
    mkdir['-p', f'{start_dir}/{path_prefix}/{env}'] & FG
    for jurisdiction in existing_jurisdictions:
      add_domain_ecf5(version, env, jurisdiction, start_dir=start_dir)

  with open('bindings.xjb', 'w') as f:
    f.write(bindings_xjb_contents_ecf4)

  os.chdir(start_dir)

  # TODO: generate the Java objects
  #wsdl2java['-b', 'bindings.xjb', '-xjc-Xts', '-d', '../../../../java', '-verbose', 'ECF-4.0-FilingReviewMDEService.wsdl'] & FG

def main(args):
  if len(sys.argv) <= 1:
    print("Pass in `version` or `jurisdiction`")
    return

  if sys.argv[1] == 'version':
    if len(sys.argv) <= 3:
      print("Need to pass `version <version_number> <url to download from>`")
      return

    #add_new_efm_version(sys.argv[2], sys.argv[3])
    add_new_ecf4_version(sys.argv[2], sys.argv[3])
    #add_new_ecf5_version(sys.argv[2], sys.argv[3])
  elif sys.argv[1] == 'jurisdiction':
    if len(sys.argv) <= 3:
      print("Need to pass `jurisdiction <name> <env>`")
      return
    add_new_jurisdiction(sys.argv[2], sys.argv[3])

if __name__ == '__main__':
  main(sys.argv)
  
