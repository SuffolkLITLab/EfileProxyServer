#!/usr/bin/env python3

"""
To run you must:

* have the python dependencies installed (requests and plumbum)
* have CXF installed on the PATH env var
* have maven and Java (21) installed locally
* have the env variables defined (search for `os.getenv`)
* must have installed this project with maven (`mvn install`)

"""
import os
from plumbum import local, FG

# Check that wsdl2java and other comands are installed correctly
wsdl2java = local.cmd.wsdl2java
wsdl2java['-v'] & FG
os.chdir('src/main/')

all_schemas = [
  "AddUserRoleRequest",
  "AttachServiceContactRequest",
  "AttorneyListResponse",
  "AuthenticateRequest",
  "AuthenticateResponse",
  "BaseRequest",
  "BaseResponse",
  "ChangePasswordRequest",
  "ChangePasswordResponse",
  "Common",
  "CreateAttorneyRequest",
  "CreateAttorneyResponse",
  "CreatePaymentAccountRequest",
  "CreatePaymentAccountResponse",
  "CreateServiceContactRequest",
  "CreateServiceContactResponse",
  "DetachServiceContactRequest",
  "GetAttorneyRequest",
  "GetAttorneyResponse",
  "GetFirmResponse",
  "GetPasswordQuestionRequest",
  "GetPaymentAccountListRequest",
  "GetPaymentAccountRequest",
  "GetPaymentAccountResponse",
  "GetPublicListRequest",
  "GetServiceContactRequest",
  "GetServiceContactResponse",
  "GetUserRequest",
  "GetUserListRequest",
  "GetUserResponse",
  "GetUserListResponse",
  "GetVitalChekPaymentAccountIdResponse",
  "NotificationPreferencesListResponse",
  "NotificationPreferencesResponse",
  "PasswordQuestionResponse",
  "PaymentAccountListResponse",
  "PaymentAccountTypeListResponse",
  "RegistrationRequest",
  "RegistrationResponse",
  "RemoveAttorneyRequest",
  "RemovePaymentAccountRequest",
  "RemoveServiceContactRequest",
  "RemoveUserRequest",
  "ReplaceServiceContactRequest",
  "RemoveUserRoleRequest",
  "ReplaceServiceContactRequest",
  "ReplaceServiceContactRequestType",
  "ResendActivationEmailRequest",
  "ResetPasswordRequest",
  "ResetPasswordResponse",
  "ResetUserPasswordRequest",
  "SelfResendActivationEmailRequest",
  "ServiceContactListResponse",
  "UpdateAttorneyRequest",
  "UpdateAttorneyResponse",
  "UpdateFirmRequest",
  "UpdateNotificationPreferencesRequest",
  "UpdatePaymentAccountRequest",
  "UpdatePaymentAccountResponse",
  "UpdateServiceContactRequest",
  "UpdateServiceContactResponse",
  "UpdateUserRequest",
  "UpdateUserResponse",
  "UserListResponse"
]

version_dir = "v2022_1"
jurisdiction = "illinois"

all_packages = []
for name in all_schemas:
  all_packages.append("-p")
  all_packages.append(f'urn:tyler:efm:services:schema:{name}=tyler.efm.{version_dir}.services.schema.{name.lower()}')
 
stable_args = ['-xjc-Xts', '-d', 'java', '-verbose']

downloaded_fs = ['EFMUserServiceSingle.svc.wsdl', 'EFMFirmServiceSingle.svc.wsdl']

# Regenerated the Java files 
for downloaded in downloaded_fs:
  all_args = stable_args + all_packages + ['-p', f'urn:tyler:efm:services=tyler.efm.{version_dir}.services', f'resources/wsdl/{version_dir}/{jurisdiction}-{downloaded}']
  wsdl2java.bound_command(all_args) & FG
