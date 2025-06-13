package edu.suffolk.litlab.efsp.tyler;

import tyler.efm.Conversion;
import tyler.efm.IEfmFirmService;
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
    private IEfmFirmService port;
    private TylerVersion version;

    public TylerFirmClient(IEfmFirmService port, TylerVersion version) {
        this.port = port;
        this.version = version;
    }

    public GetAttorneyResponseType getAttorney(GetAttorneyRequestType getAttorneyRequest) {
        return port.getAttorney(getAttorneyRequest);
    }

    public UpdatePaymentAccountResponseType updatePaymentAccount(UpdatePaymentAccountRequestType updatePaymentAccountRequest) {
        return port.updatePaymentAccount(updatePaymentAccountRequest);
    }

    public GetVitalChekPaymentAccountIdResponseType getVitalChekPaymentAccountId(GetPaymentAccountRequestType getPaymentAccountRequest) {
        return port.getVitalChekPaymentAccountId(getPaymentAccountRequest);
    }

    // TODO: v2022
    public ServiceContactListResponseType getPublicList(GetPublicListRequestType getPublicListRequest) {
        if (version.equals(TylerVersion.v2022_1)) {
            var resp = port.getPublicListV2022(getPublicListRequest);
            var latest_resp = new ServiceContactListResponseType();
            for (var contact : resp.getServiceContact()) {
                latest_resp.getServiceContact().add(Conversion.upgrade(contact));
            }
            return latest_resp;
        } else {
            return port.getPublicList(getPublicListRequest);
        }
    }

    public GetUserResponseType getUser(GetUserRequestType getUserRequest) {
        if (version.equals(TylerVersion.v2022_1)) {
            var type = port.getUserV2022(getUserRequest);
            var resp = new GetUserResponseType();
            resp.setError(type.getError());
            resp.setUser(Conversion.upgrade(type.getUser()));
            return resp;
        } else {
            return port.getUser(getUserRequest);
        }
    }
    //public tyler.efm.v2022_1.services.schema.getuserresponse.GetUserResponseType getUser(

    public BaseResponseType replaceServiceContact(ReplaceServiceContactRequestType replaceServiceContactRequest) {
        return port.replaceServiceContact(replaceServiceContactRequest);
    }

    public GetServiceContactResponseType getServiceContact(GetServiceContactRequestType getServiceContactRequest) {
        if (version.equals(TylerVersion.v2022_1)) {
            var type = port.getServiceContactV2022(getServiceContactRequest);
            var resp = new GetServiceContactResponseType();
            resp.setError(type.getError());
            resp.setServiceContact(Conversion.upgrade(type.getServiceContact()));
            return resp;
        } else {
            return port.getServiceContact(getServiceContactRequest);
        }
    }

    public CreatePaymentAccountResponseType createPaymentAccount(CreatePaymentAccountRequestType createPaymentAccountRequest) {
        return port.createPaymentAccount(createPaymentAccountRequest);
    }

    public NotificationPreferencesListResponseType getNotificationPreferencesList() {
        return port.getNotificationPreferencesList();
    }

    public GetPaymentAccountResponseType getGlobalPaymentAccount(GetPaymentAccountRequestType getGlobalPaymentAccountRequest) {
        return port.getGlobalPaymentAccount(getGlobalPaymentAccountRequest);
    }

    public UpdatePaymentAccountResponseType updateGlobalPaymentAccount(UpdatePaymentAccountRequestType updateGlobalPaymentAccountRequest) {
        return port.updateGlobalPaymentAccount(updateGlobalPaymentAccountRequest);
    }

    public CreatePaymentAccountResponseType createInactivePaymentAccount(CreatePaymentAccountRequestType createPaymentAccountRequest) {
        return port.createInactivePaymentAccount(createPaymentAccountRequest);
    }

    public BaseResponseType resendActivationEmail(ResendActivationEmailRequestType resendActivationEmailRequest) {
        return port.resendActivationEmail(resendActivationEmailRequest);
    }

    public GetPaymentAccountResponseType getPaymentAccount(GetPaymentAccountRequestType getPaymentAccountRequest) {
        return port.getPaymentAccount(getPaymentAccountRequest);
    }

    public BaseResponseType detachServiceContact(DetachServiceContactRequestType detachServiceContactRequest) {
        return port.detachServiceContact(detachServiceContactRequest);
    }

    // TODO v2022
    public ServiceContactListResponseType getServiceContactList() {
        if (version.equals(TylerVersion.v2022_1)) {
            var list = port.getServiceContactListV2022();
            var resp = new ServiceContactListResponseType();
            for (var contact : list.getServiceContact()) {
                resp.getServiceContact().add(Conversion.upgrade(contact));
            }
            return resp;
        } else {
            return port.getServiceContactList();
        }
    }

    // TODO v2022
    public UserListResponseType getUserList(GetUserListRequest getUserListRequest) {
        if (version.equals(TylerVersion.v2022_1)) {
            // Can ignore the paging values passed in; just return it all.
            var resp = new UserListResponseType();
            var list = port.getUserList();
            for (var user : list.getUser()) {
                resp.getUser().add(Conversion.upgrade(user));
            }
            resp.setError(list.getError());
            var paging = new PagingType();
            paging.setPageIndex(0);
            paging.setPageSize(resp.getUser().size());
            paging.setTotalSize(resp.getUser().size());
            resp.setPaging(paging);
            return resp;
        } else {
            return port.getUserList(getUserListRequest);
        }

    }

    public PaymentAccountTypeListResponseType getPaymentAccountTypeList() {
        return port.getPaymentAccountTypeList();
    }

    public BaseResponseType removeUser(RemoveUserRequestType removeUserRequest) {
        return port.removeUser(removeUserRequest);
    }

    public PaymentAccountListResponseType getPaymentAccountList(GetPaymentAccountListRequestType getPaymentAccountListRequest) {
        return port.getPaymentAccountList(getPaymentAccountListRequest);
    }

    public BaseResponseType removeAttorney(RemoveAttorneyRequestType removeAttorneyRequest) {
        return port.removeAttorney(removeAttorneyRequest);
    }

    public PaymentAccountListResponseType getGlobalPaymentAccountList() {
        return port.getGlobalPaymentAccountList();
    }

    public BaseResponseType removeGlobalPaymentAccount(RemovePaymentAccountRequestType removeGlobalPaymentAccountRequest) {
        return port.removeGlobalPaymentAccount(removeGlobalPaymentAccountRequest);
    }

    public UpdateUserResponseType updateUser(UpdateUserRequestType updateUserRequest) {
        if (version.equals(TylerVersion.v2022_1)) {
            var req = new tyler.efm.v2022_1.services.schema.updateuserrequest.UpdateUserRequestType();
            req.setUser(Conversion.downgrade(updateUserRequest.getUser()));
            return port.updateUser(req);
        } else {
            return port.updateUser(updateUserRequest);
        }
    }

    public BaseResponseType attachServiceContact(AttachServiceContactRequestType attachServiceContactRequest) {
        return port.attachServiceContact(attachServiceContactRequest);
    }

    public BaseResponseType removeUserRole(RemoveUserRoleRequestType removeUserRoleRequest) {
        return port.removeUserRole(removeUserRoleRequest);
    }

    public AttorneyListResponseType getAttorneyList() {
        return port.getAttorneyList();
    }

    public UpdateServiceContactResponseType updateServiceContact(UpdateServiceContactRequestType updateServiceContactRequest) {
        if (version.equals(TylerVersion.v2022_1)) {
            var req = new tyler.efm.v2022_1.services.schema.updateservicecontactrequest.UpdateServiceContactRequestType();
            req.setServiceContact(Conversion.downgrade(updateServiceContactRequest.getServiceContact()));
            return port.updateServiceContact(req);
        } else {
            return port.updateServiceContact(updateServiceContactRequest);
        }

    }

    public BaseResponseType removeServiceContact(RemoveServiceContactRequestType removeServiceContactRequest) {
        return port.removeServiceContact(removeServiceContactRequest);
    }

    public BaseResponseType addUserRole(AddUserRoleRequestType addUserRoleRequest) {
        return port.addUserRole(addUserRoleRequest);
    }

    public CreateAttorneyResponseType createAttorney(CreateAttorneyRequestType createAttorneyRequest) {
        return port.createAttorney(createAttorneyRequest);
    }

    public BaseResponseType removePaymentAccount(RemovePaymentAccountRequestType removePaymentAccountRequest) {
        return port.removePaymentAccount(removePaymentAccountRequest);
    }

    public CreateServiceContactResponseType createServiceContact(CreateServiceContactRequestType createServiceContactRequest) {
        if (version.equals(TylerVersion.v2022_1)) {
            var req = new tyler.efm.v2022_1.services.schema.createservicecontactrequest.CreateServiceContactRequestType();
            req.setServiceContact(Conversion.downgrade(createServiceContactRequest.getServiceContact()));
            return port.createServiceContact(req);
        } else {
            return port.createServiceContact(createServiceContactRequest);
        }
    }

    public UpdateAttorneyResponseType updateAttorney(UpdateAttorneyRequestType updateAttorneyRequest) {
        return port.updateAttorney(updateAttorneyRequest);
    }

    public RegistrationResponseType registerUser(RegistrationRequestType registerUserRequest) {
        return port.registerUser(registerUserRequest);
    }

    public BaseResponseType updateFirm(UpdateFirmRequestType updateFirmRequest) {
        return port.updateFirm(updateFirmRequest);
    }

    public ResetPasswordResponseType resetUserPassword(ResetUserPasswordRequestType resetUserPasswordRequest) {
        return port.resetUserPassword(resetUserPasswordRequest);

    }

    public GetFirmResponseType getFirm() {
        return port.getFirm();
    }

    public CreatePaymentAccountResponseType createGlobalPaymentAccount(CreatePaymentAccountRequestType createGlobalPaymentAccountRequest) {
        return port.createGlobalPaymentAccount(createGlobalPaymentAccountRequest);

    }
}
