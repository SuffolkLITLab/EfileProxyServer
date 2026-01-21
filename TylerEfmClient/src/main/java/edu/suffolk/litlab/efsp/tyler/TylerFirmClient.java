package edu.suffolk.litlab.efsp.tyler;

import static edu.suffolk.litlab.efsp.tyler.TylerVersion.v2022_1;

import jakarta.xml.ws.BindingProvider;
import java.util.function.Consumer;
import tyler.efm.EfmFirmService;
import tyler.efm.latest.services.schema.adduserrolerequest.AddUserRoleRequestType;
import tyler.efm.latest.services.schema.attachservicecontactrequest.AttachServiceContactRequestType;
import tyler.efm.latest.services.schema.attorneylistresponse.AttorneyListResponseType;
import tyler.efm.latest.services.schema.baseresponse.BaseResponseType;
import tyler.efm.latest.services.schema.common.PagingType;
import tyler.efm.latest.services.schema.createattorneyrequest.CreateAttorneyRequestType;
import tyler.efm.latest.services.schema.createattorneyresponse.CreateAttorneyResponseType;
import tyler.efm.latest.services.schema.createpaymentaccountrequest.CreatePaymentAccountRequestType;
import tyler.efm.latest.services.schema.createpaymentaccountresponse.CreatePaymentAccountResponseType;
import tyler.efm.latest.services.schema.createservicecontactrequest.CreateServiceContactRequestType;
import tyler.efm.latest.services.schema.createservicecontactresponse.CreateServiceContactResponseType;
import tyler.efm.latest.services.schema.detachservicecontactrequest.DetachServiceContactRequestType;
import tyler.efm.latest.services.schema.getattorneyrequest.GetAttorneyRequestType;
import tyler.efm.latest.services.schema.getattorneyresponse.GetAttorneyResponseType;
import tyler.efm.latest.services.schema.getfirmresponse.GetFirmResponseType;
import tyler.efm.latest.services.schema.getpaymentaccountlistrequest.GetPaymentAccountListRequestType;
import tyler.efm.latest.services.schema.getpaymentaccountrequest.GetPaymentAccountRequestType;
import tyler.efm.latest.services.schema.getpaymentaccountresponse.GetPaymentAccountResponseType;
import tyler.efm.latest.services.schema.getpubliclistrequest.GetPublicListRequestType;
import tyler.efm.latest.services.schema.getservicecontactrequest.GetServiceContactRequestType;
import tyler.efm.latest.services.schema.getservicecontactresponse.GetServiceContactResponseType;
import tyler.efm.latest.services.schema.getuserlistrequest.GetUserListRequest;
import tyler.efm.latest.services.schema.getuserrequest.GetUserRequestType;
import tyler.efm.latest.services.schema.getuserresponse.GetUserResponseType;
import tyler.efm.latest.services.schema.getvitalchekpaymentaccountidresponse.GetVitalChekPaymentAccountIdResponseType;
import tyler.efm.latest.services.schema.notificationpreferenceslistresponse.NotificationPreferencesListResponseType;
import tyler.efm.latest.services.schema.paymentaccountlistresponse.PaymentAccountListResponseType;
import tyler.efm.latest.services.schema.paymentaccounttypelistresponse.PaymentAccountTypeListResponseType;
import tyler.efm.latest.services.schema.registrationrequest.RegistrationRequestType;
import tyler.efm.latest.services.schema.registrationresponse.RegistrationResponseType;
import tyler.efm.latest.services.schema.removeattorneyrequest.RemoveAttorneyRequestType;
import tyler.efm.latest.services.schema.removepaymentaccountrequest.RemovePaymentAccountRequestType;
import tyler.efm.latest.services.schema.removeservicecontactrequest.RemoveServiceContactRequestType;
import tyler.efm.latest.services.schema.removeuserrequest.RemoveUserRequestType;
import tyler.efm.latest.services.schema.removeuserrolerequest.RemoveUserRoleRequestType;
import tyler.efm.latest.services.schema.replaceservicecontactrequest.ReplaceServiceContactRequestType;
import tyler.efm.latest.services.schema.resendactivationemailrequest.ResendActivationEmailRequestType;
import tyler.efm.latest.services.schema.resetpasswordresponse.ResetPasswordResponseType;
import tyler.efm.latest.services.schema.resetuserpasswordrequest.ResetUserPasswordRequestType;
import tyler.efm.latest.services.schema.servicecontactlistresponse.ServiceContactListResponseType;
import tyler.efm.latest.services.schema.updateattorneyrequest.UpdateAttorneyRequestType;
import tyler.efm.latest.services.schema.updateattorneyresponse.UpdateAttorneyResponseType;
import tyler.efm.latest.services.schema.updatefirmrequest.UpdateFirmRequestType;
import tyler.efm.latest.services.schema.updatepaymentaccountrequest.UpdatePaymentAccountRequestType;
import tyler.efm.latest.services.schema.updatepaymentaccountresponse.UpdatePaymentAccountResponseType;
import tyler.efm.latest.services.schema.updateservicecontactrequest.UpdateServiceContactRequestType;
import tyler.efm.latest.services.schema.updateservicecontactresponse.UpdateServiceContactResponseType;
import tyler.efm.latest.services.schema.updateuserrequest.UpdateUserRequestType;
import tyler.efm.latest.services.schema.updateuserresponse.UpdateUserResponseType;
import tyler.efm.latest.services.schema.userlistresponse.UserListResponseType;

public class TylerFirmClient {
  private tyler.efm.latest.services.IEfmFirmService latestPort;
  private tyler.efm.v2022_1.services.IEfmFirmService v2022Port;
  private TylerVersion version;

  private static final WsdlMapper mapper = new WsdlMapperImpl();

  public TylerFirmClient(
      EfmFirmService factory, TylerVersion version, Consumer<BindingProvider> setup) {
    this.version = version;
    switch (version) {
      case v2022_1:
        this.latestPort = null;
        this.v2022Port = factory.getBasicHttpBindingV2022IEfmFirmService();
        setup.accept((BindingProvider) v2022Port);
        break;
      case v2024_6:
        this.latestPort = factory.getBasicHttpBindingIEfmFirmService();
        this.v2022Port = null;
        setup.accept((BindingProvider) latestPort);
        break;
      case v2025_0:
        this.latestPort = factory.getBasicHttpBindingIEfmFirmService();
        this.v2022Port = null;
        setup.accept((BindingProvider) latestPort);
        break;
      default:
        this.latestPort = null;
        this.v2022Port = null;
        break;
    }
    ;
  }

  public GetAttorneyResponseType getAttorney(GetAttorneyRequestType getAttorneyRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.getAttorney(mapper.toV2022(getAttorneyRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.getAttorney(getAttorneyRequest);
    }
  }

  public UpdatePaymentAccountResponseType updatePaymentAccount(
      UpdatePaymentAccountRequestType updatePaymentAccountRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.updatePaymentAccount(mapper.toV2022(updatePaymentAccountRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.updatePaymentAccount(updatePaymentAccountRequest);
    }
  }

  public GetVitalChekPaymentAccountIdResponseType getVitalChekPaymentAccountId(
      GetPaymentAccountRequestType getPaymentAccountRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.getVitalChekPaymentAccountId(mapper.toV2022(getPaymentAccountRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.getVitalChekPaymentAccountId(getPaymentAccountRequest);
    }
  }

  public ServiceContactListResponseType getPublicList(
      GetPublicListRequestType getPublicListRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.getPublicList(mapper.toV2022(getPublicListRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.getPublicList(getPublicListRequest);
    }
  }

  public GetUserResponseType getUser(GetUserRequestType getUserRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.getUser(mapper.toV2022(getUserRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.getUser(getUserRequest);
    }
  }

  public BaseResponseType replaceServiceContact(
      ReplaceServiceContactRequestType replaceServiceContactRequest) {
    if (version == v2022_1) {
      // Doesn't exist in v2022_1. Ignore.
      return null;
    } else {
      return latestPort.replaceServiceContact(replaceServiceContactRequest);
    }
  }

  public GetServiceContactResponseType getServiceContact(
      GetServiceContactRequestType getServiceContactRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.getServiceContact(mapper.toV2022(getServiceContactRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.getServiceContact(getServiceContactRequest);
    }
  }

  public CreatePaymentAccountResponseType createPaymentAccount(
      CreatePaymentAccountRequestType createPaymentAccountRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.createPaymentAccount(mapper.toV2022(createPaymentAccountRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.createPaymentAccount(createPaymentAccountRequest);
    }
  }

  public NotificationPreferencesListResponseType getNotificationPreferencesList() {
    if (version == v2022_1) {
      var resp = v2022Port.getNotificationPreferencesList();
      return mapper.toLatest(resp);
    } else {
      return latestPort.getNotificationPreferencesList();
    }
  }

  public GetPaymentAccountResponseType getGlobalPaymentAccount(
      GetPaymentAccountRequestType getGlobalPaymentAccountRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.getGlobalPaymentAccount(mapper.toV2022(getGlobalPaymentAccountRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.getGlobalPaymentAccount(getGlobalPaymentAccountRequest);
    }
  }

  public UpdatePaymentAccountResponseType updateGlobalPaymentAccount(
      UpdatePaymentAccountRequestType updateGlobalPaymentAccountRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.updateGlobalPaymentAccount(mapper.toV2022(updateGlobalPaymentAccountRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.updateGlobalPaymentAccount(updateGlobalPaymentAccountRequest);
    }
  }

  public CreatePaymentAccountResponseType createInactivePaymentAccount(
      CreatePaymentAccountRequestType createPaymentAccountRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.createInactivePaymentAccount(mapper.toV2022(createPaymentAccountRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.createInactivePaymentAccount(createPaymentAccountRequest);
    }
  }

  public BaseResponseType resendActivationEmail(
      ResendActivationEmailRequestType resendActivationEmailRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.resendActivationEmail(mapper.toV2022(resendActivationEmailRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.resendActivationEmail(resendActivationEmailRequest);
    }
  }

  public GetPaymentAccountResponseType getPaymentAccount(
      GetPaymentAccountRequestType getPaymentAccountRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.getPaymentAccount(mapper.toV2022(getPaymentAccountRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.getPaymentAccount(getPaymentAccountRequest);
    }
  }

  public BaseResponseType detachServiceContact(
      DetachServiceContactRequestType detachServiceContactRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.detachServiceContact(mapper.toV2022(detachServiceContactRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.detachServiceContact(detachServiceContactRequest);
    }
  }

  public ServiceContactListResponseType getServiceContactList() {
    if (version.equals(TylerVersion.v2022_1)) {
      var resp = v2022Port.getServiceContactList();
      return mapper.toLatest(resp);
    } else {
      return latestPort.getServiceContactList();
    }
  }

  // TODO v2022
  public UserListResponseType getUserList(GetUserListRequest getUserListRequest) {
    if (version.equals(TylerVersion.v2022_1)) {
      // Can ignore the paging values passed in; just return it all.
      var resp = mapper.toLatest(v2022Port.getUserList());
      var paging = new PagingType();
      paging.setPageIndex(0);
      paging.setPageSize(resp.getUser().size());
      paging.setTotalSize(resp.getUser().size());
      resp.setPaging(paging);
      return resp;
    } else {
      return latestPort.getUserList(getUserListRequest);
    }
  }

  public PaymentAccountTypeListResponseType getPaymentAccountTypeList() {
    if (version == v2022_1) {
      return mapper.toLatest(v2022Port.getPaymentAccountTypeList());
    } else {
      return latestPort.getPaymentAccountTypeList();
    }
  }

  public BaseResponseType removeUser(RemoveUserRequestType removeUserRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.removeUser(mapper.toV2022(removeUserRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.removeUser(removeUserRequest);
    }
  }

  public PaymentAccountListResponseType getPaymentAccountList(
      GetPaymentAccountListRequestType getPaymentAccountListRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.getPaymentAccountList(mapper.toV2022(getPaymentAccountListRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.getPaymentAccountList(getPaymentAccountListRequest);
    }
  }

  public BaseResponseType removeAttorney(RemoveAttorneyRequestType removeAttorneyRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.removeAttorney(mapper.toV2022(removeAttorneyRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.removeAttorney(removeAttorneyRequest);
    }
  }

  public PaymentAccountListResponseType getGlobalPaymentAccountList() {
    if (version == v2022_1) {
      var resp = v2022Port.getGlobalPaymentAccountList();
      return mapper.toLatest(resp);
    } else {
      return latestPort.getGlobalPaymentAccountList();
    }
  }

  public BaseResponseType removeGlobalPaymentAccount(
      RemovePaymentAccountRequestType removeGlobalPaymentAccountRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.removeGlobalPaymentAccount(mapper.toV2022(removeGlobalPaymentAccountRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.removeGlobalPaymentAccount(removeGlobalPaymentAccountRequest);
    }
  }

  public UpdateUserResponseType updateUser(UpdateUserRequestType updateUserRequest) {
    if (version.equals(TylerVersion.v2022_1)) {
      // TODO
      var resp = v2022Port.updateUser(mapper.toV2022(updateUserRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.updateUser(updateUserRequest);
    }
  }

  public BaseResponseType attachServiceContact(
      AttachServiceContactRequestType attachServiceContactRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.attachServiceContact(mapper.toV2022(attachServiceContactRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.attachServiceContact(attachServiceContactRequest);
    }
  }

  public BaseResponseType removeUserRole(RemoveUserRoleRequestType removeUserRoleRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.removeUserRole(mapper.toV2022(removeUserRoleRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.removeUserRole(removeUserRoleRequest);
    }
  }

  public AttorneyListResponseType getAttorneyList() {
    if (version == v2022_1) {
      var resp = v2022Port.getAttorneyList();
      return mapper.toLatest(resp);
    } else {
      return latestPort.getAttorneyList();
    }
  }

  public UpdateServiceContactResponseType updateServiceContact(
      UpdateServiceContactRequestType updateServiceContactRequest) {
    if (version.equals(TylerVersion.v2022_1)) {
      var resp = v2022Port.updateServiceContact(mapper.toV2022(updateServiceContactRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.updateServiceContact(updateServiceContactRequest);
    }
  }

  public BaseResponseType removeServiceContact(
      RemoveServiceContactRequestType removeServiceContactRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.removeServiceContact(mapper.toV2022(removeServiceContactRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.removeServiceContact(removeServiceContactRequest);
    }
  }

  public BaseResponseType addUserRole(AddUserRoleRequestType addUserRoleRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.addUserRole(mapper.toV2022(addUserRoleRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.addUserRole(addUserRoleRequest);
    }
  }

  public CreateAttorneyResponseType createAttorney(
      CreateAttorneyRequestType createAttorneyRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.createAttorney(mapper.toV2022(createAttorneyRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.createAttorney(createAttorneyRequest);
    }
  }

  public BaseResponseType removePaymentAccount(
      RemovePaymentAccountRequestType removePaymentAccountRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.removePaymentAccount(mapper.toV2022(removePaymentAccountRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.removePaymentAccount(removePaymentAccountRequest);
    }
  }

  public CreateServiceContactResponseType createServiceContact(
      CreateServiceContactRequestType createServiceContactRequest) {
    if (version.equals(TylerVersion.v2022_1)) {
      var resp = v2022Port.createServiceContact(mapper.toV2022(createServiceContactRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.createServiceContact(createServiceContactRequest);
    }
  }

  public UpdateAttorneyResponseType updateAttorney(
      UpdateAttorneyRequestType updateAttorneyRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.updateAttorney(mapper.toV2022(updateAttorneyRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.updateAttorney(updateAttorneyRequest);
    }
  }

  public RegistrationResponseType registerUser(RegistrationRequestType registerUserRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.registerUser(mapper.toV2022(registerUserRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.registerUser(registerUserRequest);
    }
  }

  public BaseResponseType updateFirm(UpdateFirmRequestType updateFirmRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.updateFirm(mapper.toV2022(updateFirmRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.updateFirm(updateFirmRequest);
    }
  }

  public ResetPasswordResponseType resetUserPassword(
      ResetUserPasswordRequestType resetUserPasswordRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.resetUserPassword(mapper.toV2022(resetUserPasswordRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.resetUserPassword(resetUserPasswordRequest);
    }
  }

  public GetFirmResponseType getFirm() {
    if (version == v2022_1) {
      return mapper.toLatest(v2022Port.getFirm());
    } else {
      return latestPort.getFirm();
    }
  }

  public CreatePaymentAccountResponseType createGlobalPaymentAccount(
      CreatePaymentAccountRequestType createGlobalPaymentAccountRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.createGlobalPaymentAccount(mapper.toV2022(createGlobalPaymentAccountRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.createGlobalPaymentAccount(createGlobalPaymentAccountRequest);
    }
  }
}
