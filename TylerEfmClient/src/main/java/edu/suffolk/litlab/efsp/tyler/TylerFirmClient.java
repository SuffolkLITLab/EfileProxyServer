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
      var resp = v2022Port.getAttorney(Conversion.convert(
        tyler.efm.v2022_1.services.schema.getattorneyrequest.GetAttorneyRequestType.class,
        getAttorneyRequest));
      return Conversion.convert(GetAttorneyResponseType.class, resp);
    } else {
      return latestPort.getAttorney(getAttorneyRequest);
    }
  }

  public UpdatePaymentAccountResponseType updatePaymentAccount(
      UpdatePaymentAccountRequestType updatePaymentAccountRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.updatePaymentAccount(Conversion.convert(
            tyler.efm.v2022_1.services.schema.updatepaymentaccountrequest
              .UpdatePaymentAccountRequestType.class,
              updatePaymentAccountRequest));
      return Conversion.convert(UpdatePaymentAccountResponseType.class, resp);
    } else {
      return latestPort.updatePaymentAccount(updatePaymentAccountRequest);
    }
  }

  public GetVitalChekPaymentAccountIdResponseType getVitalChekPaymentAccountId(
      GetPaymentAccountRequestType getPaymentAccountRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.getVitalChekPaymentAccountId(Conversion.convert(
            tyler.efm.v2022_1.services.schema.getpaymentaccountrequest
              .GetPaymentAccountRequestType.class,
              getPaymentAccountRequest));
      return Conversion.convert(GetVitalChekPaymentAccountIdResponseType.class, resp);
    } else {
      return latestPort.getVitalChekPaymentAccountId(getPaymentAccountRequest);
    }
  }

  public ServiceContactListResponseType getPublicList(
      GetPublicListRequestType getPublicListRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.getPublicList(Conversion.convert(
        tyler.efm.v2022_1.services.schema.getpubliclistrequest.GetPublicListRequestType.class,
        getPublicListRequest));
      return Conversion.convert(ServiceContactListResponseType.class, resp);
    } else {
      return latestPort.getPublicList(getPublicListRequest);
    }
  }

  public GetUserResponseType getUser(GetUserRequestType getUserRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.getUser(Conversion.convert(
        tyler.efm.v2022_1.services.schema.getuserrequest.GetUserRequestType.class,
        getUserRequest));
      return Conversion.convert(GetUserResponseType.class, resp);
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
      var resp = v2022Port.getServiceContact(Conversion.convert(
        tyler.efm.v2022_1.services.schema.getservicecontactrequest.GetServiceContactRequestType.class,
        getServiceContactRequest));
      return Conversion.convert(GetServiceContactResponseType.class, resp);
    } else {
      return latestPort.getServiceContact(getServiceContactRequest);
    }
  }

  public CreatePaymentAccountResponseType createPaymentAccount(
      CreatePaymentAccountRequestType createPaymentAccountRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.createPaymentAccount(Conversion.convert(
            tyler.efm.v2022_1.services.schema.createpaymentaccountrequest.CreatePaymentAccountRequestType.class,
            createPaymentAccountRequest));
      return Conversion.convert(CreatePaymentAccountResponseType.class, resp);
    } else {
      return latestPort.createPaymentAccount(createPaymentAccountRequest);
    }
  }

  public NotificationPreferencesListResponseType getNotificationPreferencesList() {
    if (version == v2022_1) {
      var resp = v2022Port.getNotificationPreferencesList();
      return Conversion.convert(NotificationPreferencesListResponseType.class, resp);
    } else {
      return latestPort.getNotificationPreferencesList();
    }
  }

  public GetPaymentAccountResponseType getGlobalPaymentAccount(
      GetPaymentAccountRequestType getGlobalPaymentAccountRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.getGlobalPaymentAccount(
              Conversion.convert(
                tyler.efm.v2022_1.services.schema.getpaymentaccountrequest.GetPaymentAccountRequestType.class,
                getGlobalPaymentAccountRequest));
      return Conversion.convert(GetPaymentAccountResponseType.class, resp);
    } else {
      return latestPort.getGlobalPaymentAccount(getGlobalPaymentAccountRequest);
    }
  }

  public UpdatePaymentAccountResponseType updateGlobalPaymentAccount(
      UpdatePaymentAccountRequestType updateGlobalPaymentAccountRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.updateGlobalPaymentAccount(
              Conversion.convert(
              tyler.efm.v2022_1.services.schema.updatepaymentaccountrequest.UpdatePaymentAccountRequestType.class,
              updateGlobalPaymentAccountRequest));
      return Conversion.convert(UpdatePaymentAccountResponseType.class, resp);
    } else {
      return latestPort.updateGlobalPaymentAccount(updateGlobalPaymentAccountRequest);
    }
  }

  public CreatePaymentAccountResponseType createInactivePaymentAccount(
      CreatePaymentAccountRequestType createPaymentAccountRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.createInactivePaymentAccount(
              Conversion.convert(
              tyler.efm.v2022_1.services.schema.createpaymentaccountrequest
              .CreatePaymentAccountRequestType.class,
              createPaymentAccountRequest));
      return Conversion.convert(CreatePaymentAccountResponseType.class, resp);
    } else {
      return latestPort.createInactivePaymentAccount(createPaymentAccountRequest);
    }
  }

  public BaseResponseType resendActivationEmail(
      ResendActivationEmailRequestType resendActivationEmailRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.resendActivationEmail(Conversion.convert(
            tyler.efm.v2022_1.services.schema.resendactivationemailrequest.ResendActivationEmailRequestType.class,
            resendActivationEmailRequest));
      return Conversion.convert(BaseResponseType.class, resp);
    } else {
      return latestPort.resendActivationEmail(resendActivationEmailRequest);
    }
  }

  public GetPaymentAccountResponseType getPaymentAccount(
      GetPaymentAccountRequestType getPaymentAccountRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.getPaymentAccount(Conversion.convert(
          tyler.efm.v2022_1.services.schema.getpaymentaccountrequest
              .GetPaymentAccountRequestType.class,
          getPaymentAccountRequest));
      return Conversion.convert(GetPaymentAccountResponseType.class, resp);
    } else {
      return latestPort.getPaymentAccount(getPaymentAccountRequest);
    }
  }

  public BaseResponseType detachServiceContact(
      DetachServiceContactRequestType detachServiceContactRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.detachServiceContact(Conversion.convert(
          tyler.efm.v2022_1.services.schema.detachservicecontactrequest
              .DetachServiceContactRequestType.class,
              detachServiceContactRequest));
      return Conversion.convert(BaseResponseType.class, resp);
    } else {
      return latestPort.detachServiceContact(detachServiceContactRequest);
    }
  }

  public ServiceContactListResponseType getServiceContactList() {
    if (version.equals(TylerVersion.v2022_1)) {
      var resp = v2022Port.getServiceContactList();
      return Conversion.convert(ServiceContactListResponseType.class, resp);
    } else {
      return latestPort.getServiceContactList();
    }
  }

  // TODO v2022
  public UserListResponseType getUserList(GetUserListRequest getUserListRequest) {
    if (version.equals(TylerVersion.v2022_1)) {
      // Can ignore the paging values passed in; just return it all.
      var resp = Conversion.convert(UserListResponseType.class, v2022Port.getUserList());
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
      var resp = v2022Port.getPaymentAccountTypeList();
      return Conversion.convert(PaymentAccountTypeListResponseType.class, resp);
    } else {
      return latestPort.getPaymentAccountTypeList();
    }
  }

  public BaseResponseType removeUser(RemoveUserRequestType removeUserRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.removeUser(Conversion.convert(
        tyler.efm.v2022_1.services.schema.removeuserrequest.RemoveUserRequestType.class,
        removeUserRequest));
      return Conversion.convert(BaseResponseType.class, resp);
    } else {
      return latestPort.removeUser(removeUserRequest);
    }
  }

  public PaymentAccountListResponseType getPaymentAccountList(
      GetPaymentAccountListRequestType getPaymentAccountListRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.getPaymentAccountList(Conversion.convert(
            tyler.efm.v2022_1.services.schema.getpaymentaccountlistrequest
              .GetPaymentAccountListRequestType.class,
            getPaymentAccountListRequest));
      return Conversion.convert(PaymentAccountListResponseType.class, resp);
    } else {
      return latestPort.getPaymentAccountList(getPaymentAccountListRequest);
    }
  }

  public BaseResponseType removeAttorney(RemoveAttorneyRequestType removeAttorneyRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.removeAttorney(Conversion.convert(
          tyler.efm.v2022_1.services.schema.removeattorneyrequest.RemoveAttorneyRequestType.class,
          removeAttorneyRequest));
      return Conversion.convert(CreatePaymentAccountResponseType.class, resp);
    } else {
      return latestPort.removeAttorney(removeAttorneyRequest);
    }
  }

  public PaymentAccountListResponseType getGlobalPaymentAccountList() {
    if (version == v2022_1) {
      var resp = v2022Port.getGlobalPaymentAccountList();
      return Conversion.convert(PaymentAccountListResponseType.class, resp);
    } else {
      return latestPort.getGlobalPaymentAccountList();
    }
  }

  public BaseResponseType removeGlobalPaymentAccount(
      RemovePaymentAccountRequestType removeGlobalPaymentAccountRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.removeGlobalPaymentAccount(
              Conversion.convert(
              tyler.efm.v2022_1.services.schema.removepaymentaccountrequest
              .RemovePaymentAccountRequestType.class,
                removeGlobalPaymentAccountRequest));
      return Conversion.convert(BaseResponseType.class, resp);
    } else {
      return latestPort.removeGlobalPaymentAccount(removeGlobalPaymentAccountRequest);
    }
  }

  public UpdateUserResponseType updateUser(UpdateUserRequestType updateUserRequest) {
    if (version.equals(TylerVersion.v2022_1)) {
      // TODO
      var resp = v2022Port.updateUser(Conversion.convert(
        tyler.efm.v2022_1.services.schema.updateuserrequest.UpdateUserRequestType.class,
        updateUserRequest.getUser()));
      return Conversion.convert(UpdateUserResponseType.class, resp);
    } else {
      return latestPort.updateUser(updateUserRequest);
    }
  }

  public BaseResponseType attachServiceContact(
      AttachServiceContactRequestType attachServiceContactRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.attachServiceContact(Conversion.convert(
            tyler.efm.v2022_1.services.schema.attachservicecontactrequest
              .AttachServiceContactRequestType.class,
            attachServiceContactRequest));
      return Conversion.convert(BaseResponseType.class, resp);
    } else {
      return latestPort.attachServiceContact(attachServiceContactRequest);
    }
  }

  public BaseResponseType removeUserRole(RemoveUserRoleRequestType removeUserRoleRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.removeUserRole(Conversion.convert(
        tyler.efm.v2022_1.services.schema.removeuserrolerequest.RemoveUserRoleRequestType.class,
        removeUserRoleRequest));
      return Conversion.convert(BaseResponseType.class, resp);
    } else {
      return latestPort.removeUserRole(removeUserRoleRequest);
    }
  }

  public AttorneyListResponseType getAttorneyList() {
    if (version == v2022_1) {
      var resp = v2022Port.getAttorneyList();
      return Conversion.convert(AttorneyListResponseType.class, resp);
    } else {
      return latestPort.getAttorneyList();
    }
  }

  public UpdateServiceContactResponseType updateServiceContact(
      UpdateServiceContactRequestType updateServiceContactRequest) {
    if (version.equals(TylerVersion.v2022_1)) {
      var resp =
          v2022Port.updateServiceContact(Conversion.convert(
            tyler.efm.v2022_1.services.schema.updateservicecontactrequest
              .UpdateServiceContactRequestType.class,
            updateServiceContactRequest));
      return Conversion.convert(UpdateServiceContactResponseType.class, resp);
    } else {
      return latestPort.updateServiceContact(updateServiceContactRequest);
    }
  }

  public BaseResponseType removeServiceContact(
      RemoveServiceContactRequestType removeServiceContactRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.removeServiceContact(Conversion.convert(
            tyler.efm.v2022_1.services.schema.removeservicecontactrequest
              .RemoveServiceContactRequestType.class,
            removeServiceContactRequest));
      return Conversion.convert(BaseResponseType.class, resp);
    } else {
      return latestPort.removeServiceContact(removeServiceContactRequest);
    }
  }

  public BaseResponseType addUserRole(AddUserRoleRequestType addUserRoleRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.addUserRole(Conversion.convert(
        tyler.efm.v2022_1.services.schema.adduserrolerequest.AddUserRoleRequestType.class,
        addUserRoleRequest));
      return Conversion.convert(BaseResponseType.class, resp);
    } else {
      return latestPort.addUserRole(addUserRoleRequest);
    }
  }

  public CreateAttorneyResponseType createAttorney(
      CreateAttorneyRequestType createAttorneyRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.createAttorney(Conversion.convert(
          tyler.efm.v2022_1.services.schema.createattorneyrequest.CreateAttorneyRequestType.class,
        createAttorneyRequest));
      return Conversion.convert(CreateAttorneyResponseType.class, resp);
    } else {
      return latestPort.createAttorney(createAttorneyRequest);
    }
  }

  public BaseResponseType removePaymentAccount(
      RemovePaymentAccountRequestType removePaymentAccountRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.removePaymentAccount(Conversion.convert(
            tyler.efm.v2022_1.services.schema.removepaymentaccountrequest
              .RemovePaymentAccountRequestType.class,
            removePaymentAccountRequest));
      return Conversion.convert(BaseResponseType.class, resp);
    } else {
      return latestPort.removePaymentAccount(removePaymentAccountRequest);
    }
  }

  public CreateServiceContactResponseType createServiceContact(
      CreateServiceContactRequestType createServiceContactRequest) {
    if (version.equals(TylerVersion.v2022_1)) {
      var resp =
          v2022Port.createServiceContact(Conversion.convert(
            tyler.efm.v2022_1.services.schema.createservicecontactrequest
              .CreateServiceContactRequestType.class,
            createServiceContactRequest));
      return Conversion.convert(CreateServiceContactResponseType.class, resp);
    } else {
      return latestPort.createServiceContact(createServiceContactRequest);
    }
  }

  public UpdateAttorneyResponseType updateAttorney(
      UpdateAttorneyRequestType updateAttorneyRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.updateAttorney(Conversion.convert(
        tyler.efm.v2022_1.services.schema.updateattorneyrequest.UpdateAttorneyRequestType.class,
        updateAttorneyRequest));
      return Conversion.convert(UpdateAttorneyResponseType.class, resp);
    } else {
      return latestPort.updateAttorney(updateAttorneyRequest);
    }
  }

  public RegistrationResponseType registerUser(RegistrationRequestType registerUserRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.registerUser(Conversion.convert(
        tyler.efm.v2022_1.services.schema.registrationrequest.RegistrationRequestType.class,
        registerUserRequest));
      return Conversion.convert(RegistrationResponseType.class, resp);
    } else {
      return latestPort.registerUser(registerUserRequest);
    }
  }

  public BaseResponseType updateFirm(UpdateFirmRequestType updateFirmRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.updateFirm(Conversion.convert(
        tyler.efm.v2022_1.services.schema.updatefirmrequest.UpdateFirmRequestType.class,
        updateFirmRequest));
      return Conversion.convert(BaseResponseType.class, resp);
    } else {
      return latestPort.updateFirm(updateFirmRequest);
    }
  }

  public ResetPasswordResponseType resetUserPassword(
      ResetUserPasswordRequestType resetUserPasswordRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.resetUserPassword(Conversion.convert(
          tyler.efm.v2022_1.services.schema.resetuserpasswordrequest
              .ResetUserPasswordRequestType.class,
          resetUserPasswordRequest));
      return Conversion.convert(ResetPasswordResponseType.class, resp);
    } else {
      return latestPort.resetUserPassword(resetUserPasswordRequest);
    }
  }

  public GetFirmResponseType getFirm() {
    if (version == v2022_1) {
      return Conversion.convert(GetFirmResponseType.class, v2022Port.getFirm());
    } else {
      return latestPort.getFirm();
    }
  }

  public CreatePaymentAccountResponseType createGlobalPaymentAccount(
      CreatePaymentAccountRequestType createGlobalPaymentAccountRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.createGlobalPaymentAccount(
              Conversion.convert(
              tyler.efm.v2022_1.services.schema.createpaymentaccountrequest
              .CreatePaymentAccountRequestType.class,
              createGlobalPaymentAccountRequest));
      return Conversion.convert(CreatePaymentAccountResponseType.class, resp);
    } else {
      return latestPort.createGlobalPaymentAccount(createGlobalPaymentAccountRequest);
    }
  }
}
