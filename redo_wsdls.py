#!/usr/bin/env python3
import os
import requests
from plumbum import local, FG, BG

# Check that wsdl2java and other comands are installed correctly
wsdl2java = local.cmd.wsdl2java
wsdl2java['-h'] & FG
mvn = local['mvn']
mvn['-h'] & FG
mkdir = local['mkdir']
# mkdir['-p', 'wsdl_eater'] & FG
os.chdir('src/main/resources/wsdl')


# Download the services
supported_jurisdictions = [v.strip() for v in os.getenv('TYLER_JURISDICTIONS', 'illinois').split(' ')]
tyler_env = os.getenv('TYLER_ENV', 'stage')

for juris in supported_jurisdictions:
  mkdir['-p', f"{juris}/{tyler_env}"] & FG
  os.chdir(f"{juris}/{tyler_env}")
  r = requests.get(f"https://{juris}-{tyler_env}.tylertech.cloud/EFM/EFMUserService.svc?singleWsdl")
  with open('EFMUserServiceSingle.svc.wsdl', 'w') as f:
    f.write(r.text)

  r = requests.get(f"https://{juris}-{tyler_env}.tylertech.cloud/EFM/EFMFirmService.svc?singleWsdl")
  with open('EFMFirmServiceSingle.svc.wsdl', 'w') as f:
    f.write(r.text)
  print('downloaded EFMFirmService')

  for ecf_wsdl in ['ECF-4.0-FilingReviewMDEService.wsdl', 'ECF-4.0-FilingAssemblyMDEService.wsdl', 'ECF-4.0-CourtRecordMDEService.wsdl', 'ECF-4.0-ServiceMDEService.wsdl']:
    args = f'-Dexec.args="https://{juris}-{tyler_env}.tylertech.cloud/EFM/Schema/{ecf_wsdl} ecf"'
    print(args)
    mvn['-f', '../../../../../../pom.xml', 'exec:java@XsdDownloader', args] & FG
    local.get('mv')['ecf.xsd', ecf_wsdl] & FG
    print(f'downloaded {ecf_wsdl}')
  os.chdir('../../')

mkdir['-p', 'java'] & FG

# Show a diff?
# Need to show for all jurisdictions again

# Write a bindings.xjb
juris = supported_jurisdictions[0]
bindings_xjb_contents = f"""<?xml version="1.0" ?>
<jaxb:bindings version="1.0" xmlns:jaxb="http://java.sun.com/xml/ns/jaxb"
  xmlns:xsd="http://www.w3.org/2001/XMLSchema">
    <jaxb:bindings schemaLocation="ecf-11.xsd">
        <jaxb:globalBindings typesafeEnumMaxMembers="1024"/>
    </jaxb:bindings>
</jaxb:bindings>
"""
os.chdir(f'{juris}/{tyler_env}')

with open('bindings.xjb', 'w') as f:
  f.write(bindings_xjb_contents)

downloaded_fs = ['EFMUserServiceSingle.svc.wsdl', 'EFMFirmServiceSingle.svc.wsdl']

wsdl2java['-client', '-b', 'bindings.xjb', '-xjc-Xts', '-d', '../../../../java', '-verbose', 'ECF-4.0-FilingReviewMDEService.wsdl'] & FG

# Regenerated the Java files 
for downloaded in downloaded_fs:
  wsdl2java['-client', '-xjc-Xts', '-d', '../../../../java', '-verbose', f'{downloaded}'] & FG


