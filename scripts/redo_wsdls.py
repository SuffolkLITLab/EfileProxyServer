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
from plumbum import local, FG, BG

# Check that wsdl2java and other comands are installed correctly
wsdl2java = local.cmd.wsdl2java
wsdl2java['-v'] & FG
java = local['java']
java['--version'] & FG

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
  "efm_user": """
<?xml version="1.0" encoding="utf-8"?>
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
  "efm_firm": """
<?xml version="1.0" encoding="utf-8"?>
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
  "court_record_4": """
<definitions
	xmlns:wsmp="urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0"
	xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
	xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns="http://schemas.xmlsoap.org/wsdl/"
	targetNamespace="urn:tyler:efm:wsdl:WebServicesProfile-Implementation-4.0">
	<import
		namespace="urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0"
		location="../base/ecf-1.xsd" />
	<service name="CourtRecordMDEService">
		<port name="CourtRecordMDEPort" binding="wsmp:CourtRecordMDEPortSOAPBinding">
			<soap:address
				location="https://{domain}.tylertech.cloud/efm/CourtRecordMDEPort.svc" />
		</port>
	</service>
</definitions>
""",
  "filing_assembly_4": """
<definitions
	xmlns:wsmp="urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0"
	xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
	xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns="http://schemas.xmlsoap.org/wsdl/"
	targetNamespace="urn:tyler:efm:wsdl:WebServicesProfile-Implementation-4.0">
	<import
		namespace="urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0"
		location="../base/ecf-1.xsd" />
	<service name="FilingAssemblyMDEService">
		<port name="FilingAssemblyMDEPort" binding="wsmp:FilingAssemblyMDEPortSOAPBinding">
			<soap:address
				location="https://{domain}.tylertech.cloud/efm/FilingAssemblyMDEPort.svc" />
		</port>
	</service>
</definitions>
""",
  "filing_review_4": """
<definitions
	xmlns:wsmp="urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0"
	xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
	xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns="http://schemas.xmlsoap.org/wsdl/"
	targetNamespace="urn:tyler:efm:wsdl:WebServicesProfile-Implementation-4.0">
	<import
		namespace="urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0"
		location="../base/ecf-1.xsd" />
	<service name="FilingAssemblyMDEService">
		<port name="FilingAssemblyMDEPort" binding="wsmp:FilingAssemblyMDEPortSOAPBinding">
			<soap:address
				location="https://{domain}.tylertech.cloud/efm/FilingAssemblyMDEPort.svc" />
		</port>
	</service>
</definitions>
""",
  "service_4": """
<definitions
	xmlns:wsmp="urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0"
	xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
	xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns="http://schemas.xmlsoap.org/wsdl/"
	targetNamespace="urn:tyler:efm:wsdl:WebServicesProfile-Implementation-4.0">
	<import
		namespace="urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0"
		location="../base/ecf-1.xsd" />
	<service name="ServiceMDEService">
		<port name="ServiceMDEPort" binding="wsmp:ServiceMDEPortSOAPBinding">
			<soap:address location="https://{domain}.tylertech.cloud/efm/ServiceMDEPort.svc" />
		</port>
	</service>
</definitions>
""",
  "court_policy_5": """
<?xml version="1.0" encoding="UTF-8"?>
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
  "court_record_5": """
<?xml version="1.0" encoding="UTF-8"?>

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
  "court_schedule_5": """
<?xml version="1.0" encoding="UTF-8"?>

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
  "filing_review_5": """
<?xml version="1.0" encoding="UTF-8"?>

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
  "service_5": """
<?xml version="1.0" encoding="UTF-8"?>

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
  "tyler_record_5": """
<?xml version="1.0" encoding="UTF-8"?>

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
  "tyler_schedule_5": """
<?xml version="1.0" encoding="UTF-8"?>

<definitions targetNamespace="urn:tyler:ecf:v5.0:extensions:TylerCourtSchedulingMDE" xmlns:wsmp="urn:tyler:ecf:v5.0:extensions:TylerCourtSchedulingMDE" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns="http://schemas.xmlsoap.org/wsdl/">
	
	<import location="../base/TylerCourtSchedulingMDE.wsdl" namespace="urn:tyler:ecf:v5.0:extensions:TylerCourtSchedulingMDE"/>

	<service name="TylerCourtSchedulingMDEService">
		<port name="TylerCourtSchedulingMDE" binding="wsmp:TylerCourtSchedulingMDESoap">
			<soap:address location="https:/{domain}.tylertech.cloud/efm/v5/tylercourtschedulingservice.svc"/>
		</port>
	</service>
</definitions>
""",
  "tyler_assembly_5": """
<?xml version="1.0" encoding="UTF-8"?>

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
  "tyler_review_5": """
<?xml version="1.0" encoding="UTF-8"?>

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

def write_file(path, service_name, domain):
  with open(path, 'r') as f:
    f.write(wsdl_templates[service_name].format(domain=domain))

def add_domain_efm(version, env, name):
  domain = make_domain(name, env)
  efm_prefix = f"../TylerEfmClient/src/main/resources/wsdl/{version}/{env}/{name}-EFM"
  write_file(efm_prefix + "UserServiceSingle.svc.wsdl", 'efm_user', domain)
  write_file(efm_prefix + "FirmServiceSingle.svc.wsdl", 'efm_firm', domain)

def add_domain_ecf4(version, env, name):
  domain = make_domain(name, env)
  ecf4_prefix = f"../TylerEcf4/src/main/resources/wsdl/{version}/{env}/{name}-ECF-4.0-"
  write_file(ecf4_prefix + "CourtRecordMDEService.wsdl", 'court_record_4', domain)
  write_file(ecf4_prefix + "FilingAssemblyMDEService.wsdl", 'filing_assembly_4', domain)
  write_file(ecf4_prefix + "FilingReviewMDEService.wsdl", 'filing_review_4', domain)
  write_file(ecf4_prefix + "ServiceMDEService.wsdl", 'service_4', domain)

def add_domain_ecf5(version, env, name):
  domain = make_domain(name, env)
  ecf5_prefix = f"../TylerEcf5/src/main/resources/wsdl/{version}/{env}/{name}-ECF5-"
  write_file(ecf5_prefix + "CourtPolicyMDEService.wsdl", 'court_policy_5', domain)
  write_file(ecf5_prefix + "CourtRecordMDEService.wsdl", 'court_record_5', domain)
  write_file(ecf5_prefix + "CourtSchedulingMDEService.wsdl", 'court_schedule_5', domain)
  write_file(ecf5_prefix + "FilingReviewMDEService.wsdl", 'filing_review_5', domain)
  write_file(ecf5_prefix + "FilingAssemblyMDEService.wsdl", 'filing_assembly_5', domain)
  write_file(ecf5_prefix + "ServiceMDEService.wsdl", 'service_5', domain)
  write_file(ecf5_prefix + "TylerCourtRecordMDEService.wsdl", 'tyler_record_5', domain)
  write_file(ecf5_prefix + "TylerCourtSchedulingMDEService.wsdl", 'tyler_schedule_5', domain)
  write_file(ecf5_prefix + "TylerFilingAssemblyMDEService.wsdl", 'tyler_assembly_5', domain)
  write_file(ecf5_prefix + "TylerFilingReviewMDEService.wsdl", 'tyler_review_5', domain)

def make_domain(jurisdiction, env):
  if env == "prod":
    return jurisdiction
  else:
    return jurisdiction + "-" + env

def add_new_jurisdiction(name, env):
  """
  params:
    name: the name of the jurisdiction
    env: either stage or prod
  """

  domain = make_domain(name, env)

  for version in versions:
    add_domain_efm(version, env, name, domain)
    add_domain_ecf4(version, env, name, domain)
    add_domain_ecf5(version, env, name, domain)

def add_new_efm_version(version, url):
  mkdir = local['mkdir']
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

  # TODO: generate the Java objects
  java_prefix = "../TylerEfmClient/src/main/java/"
  wsdl2java['-xjc-Xts', '-d', java_prefix, '-verbose', f'{path_prefix}/stage/illinois-EFMUserServiceSingle.svc.wsdl'] & FG
  wsdl2java['-xjc-Xts', '-d', java_prefix, '-verbose', f'{path_prefix}/stage/illinois-EFMFirmServiceSingle.svc.wsdl'] & FG
  # TODO: get `sed` to do the package renaming in all generated java files
  print("YOU STILL NEED TO MANUALLY RENAME THE GENERATED PACKAGES!")

def add_new_ecf4_version(version, url):
  # TODO: court scheduling for IL?
  start_dir = os.getcwd()
  path_prefix = f"../TylerEcf4/src/main/resources/wsdl/{version}"
  mkdir = local['mkdir']
  java = local['java']
  mkdir['-p', "{path_prefix}/base"] & FG

  os.chdir(f"{path_prefix}/base")
  for ecf_wsdl in ['ECF-4.0-FilingReviewMDEService.wsdl', 'ECF-4.0-FilingAssemblyMDEService.wsdl', 'ECF-4.0-CourtRecordMDEService.wsdl', 'ECF-4.0-ServiceMDEService.wsdl']:
    args = f'{url}/EFM/Schema/{ecf_wsdl} ecf'
    java['-jar', f'{start_dir}/../proxyserver/target/efspserver-with-deps.jar', 'edu.suffolk.litlab.efsp.utils.XsdDownloader', args] & FG
    local.get('rm')['ecf.xsd', ecf_wsdl] & FG

  for env in ['prod', 'stage']:
    mkdir['-p', f'{path_prefix}/{env}'] & FG
    for jurisdiction in existing_jurisdictions:
      add_domain_ecf4(version, env, jurisdiction)

  with open('bindings.xjb', 'w') as f:
    f.write(bindings_xjb_contents_ecf4)

  os.chdir(start_dir)

  # TODO: generate the Java objects
  #wsdl2java['-b', 'bindings.xjb', '-xjc-Xts', '-d', '../../../../java', '-verbose', 'ECF-4.0-FilingReviewMDEService.wsdl'] & FG

def main(args):
  if sys.argv[1] == 'version':
    add_new_efm_version(sys.argv[2], sys.argv[3])
    add_new_ecf4_version(sys.argv[2], sys.argv[3])
  elif sys.argv[1] == 'jurisdiction':
    add_new_jurisdiction(sys.argv[2], sys.argv[3])

if __name__ == '__main__':
  main(sys.argv)
  
