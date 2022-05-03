
package tyler.efm.services;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.2
 * 2022-05-04T11:15:31.098-04:00
 * Generated source version: 3.5.2
 *
 */
public final class IEfmFirmService_BasicHttpBindingIEfmFirmService1_Client {

    private static final QName SERVICE_NAME = new QName("urn:tyler:efm:services", "EfmFirmService");

    private IEfmFirmService_BasicHttpBindingIEfmFirmService1_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = EfmFirmService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        EfmFirmService ss = new EfmFirmService(wsdlURL, SERVICE_NAME);
        IEfmFirmService port = ss.getBasicHttpBindingIEfmFirmService1();

        {
        System.out.println("Invoking getAttorney...");
        tyler.efm.services.schema.getattorneyrequest.GetAttorneyRequestType _getAttorney_getAttorneyRequest = null;
        tyler.efm.services.schema.getattorneyresponse.GetAttorneyResponseType _getAttorney__return = port.getAttorney(_getAttorney_getAttorneyRequest);
        System.out.println("getAttorney.result=" + _getAttorney__return);


        }
        {
        System.out.println("Invoking updatePaymentAccount...");
        tyler.efm.services.schema.updatepaymentaccountrequest.UpdatePaymentAccountRequestType _updatePaymentAccount_updatePaymentAccountRequest = null;
        tyler.efm.services.schema.updatepaymentaccountresponse.UpdatePaymentAccountResponseType _updatePaymentAccount__return = port.updatePaymentAccount(_updatePaymentAccount_updatePaymentAccountRequest);
        System.out.println("updatePaymentAccount.result=" + _updatePaymentAccount__return);


        }
        {
        System.out.println("Invoking getVitalChekPaymentAccountId...");
        tyler.efm.services.schema.getpaymentaccountrequest.GetPaymentAccountRequestType _getVitalChekPaymentAccountId_getPaymentAccountRequest = null;
        tyler.efm.services.schema.getvitalchekpaymentaccountidresponse.GetVitalChekPaymentAccountIdResponseType _getVitalChekPaymentAccountId__return = port.getVitalChekPaymentAccountId(_getVitalChekPaymentAccountId_getPaymentAccountRequest);
        System.out.println("getVitalChekPaymentAccountId.result=" + _getVitalChekPaymentAccountId__return);


        }
        {
        System.out.println("Invoking getPublicList...");
        tyler.efm.services.schema.getpubliclistrequest.GetPublicListRequestType _getPublicList_getPublicListRequest = null;
        tyler.efm.services.schema.servicecontactlistresponse.ServiceContactListResponseType _getPublicList__return = port.getPublicList(_getPublicList_getPublicListRequest);
        System.out.println("getPublicList.result=" + _getPublicList__return);


        }
        {
        System.out.println("Invoking getUser...");
        tyler.efm.services.schema.getuserrequest.GetUserRequestType _getUser_getUserRequest = null;
        tyler.efm.services.schema.getuserresponse.GetUserResponseType _getUser__return = port.getUser(_getUser_getUserRequest);
        System.out.println("getUser.result=" + _getUser__return);


        }
        {
        System.out.println("Invoking getServiceContact...");
        tyler.efm.services.schema.getservicecontactrequest.GetServiceContactRequestType _getServiceContact_getServiceContactRequest = null;
        tyler.efm.services.schema.getservicecontactresponse.GetServiceContactResponseType _getServiceContact__return = port.getServiceContact(_getServiceContact_getServiceContactRequest);
        System.out.println("getServiceContact.result=" + _getServiceContact__return);


        }
        {
        System.out.println("Invoking createPaymentAccount...");
        tyler.efm.services.schema.createpaymentaccountrequest.CreatePaymentAccountRequestType _createPaymentAccount_createPaymentAccountRequest = null;
        tyler.efm.services.schema.createpaymentaccountresponse.CreatePaymentAccountResponseType _createPaymentAccount__return = port.createPaymentAccount(_createPaymentAccount_createPaymentAccountRequest);
        System.out.println("createPaymentAccount.result=" + _createPaymentAccount__return);


        }
        {
        System.out.println("Invoking getNotificationPreferencesList...");
        tyler.efm.services.schema.notificationpreferenceslistresponse.NotificationPreferencesListResponseType _getNotificationPreferencesList__return = port.getNotificationPreferencesList();
        System.out.println("getNotificationPreferencesList.result=" + _getNotificationPreferencesList__return);


        }
        {
        System.out.println("Invoking getGlobalPaymentAccount...");
        tyler.efm.services.schema.getpaymentaccountrequest.GetPaymentAccountRequestType _getGlobalPaymentAccount_getGlobalPaymentAccountRequest = null;
        tyler.efm.services.schema.getpaymentaccountresponse.GetPaymentAccountResponseType _getGlobalPaymentAccount__return = port.getGlobalPaymentAccount(_getGlobalPaymentAccount_getGlobalPaymentAccountRequest);
        System.out.println("getGlobalPaymentAccount.result=" + _getGlobalPaymentAccount__return);


        }
        {
        System.out.println("Invoking updateGlobalPaymentAccount...");
        tyler.efm.services.schema.updatepaymentaccountrequest.UpdatePaymentAccountRequestType _updateGlobalPaymentAccount_updateGlobalPaymentAccountRequest = null;
        tyler.efm.services.schema.updatepaymentaccountresponse.UpdatePaymentAccountResponseType _updateGlobalPaymentAccount__return = port.updateGlobalPaymentAccount(_updateGlobalPaymentAccount_updateGlobalPaymentAccountRequest);
        System.out.println("updateGlobalPaymentAccount.result=" + _updateGlobalPaymentAccount__return);


        }
        {
        System.out.println("Invoking createInactivePaymentAccount...");
        tyler.efm.services.schema.createpaymentaccountrequest.CreatePaymentAccountRequestType _createInactivePaymentAccount_createPaymentAccountRequest = null;
        tyler.efm.services.schema.createpaymentaccountresponse.CreatePaymentAccountResponseType _createInactivePaymentAccount__return = port.createInactivePaymentAccount(_createInactivePaymentAccount_createPaymentAccountRequest);
        System.out.println("createInactivePaymentAccount.result=" + _createInactivePaymentAccount__return);


        }
        {
        System.out.println("Invoking resendActivationEmail...");
        tyler.efm.services.schema.resendactivationemailrequest.ResendActivationEmailRequestType _resendActivationEmail_resendActivationEmailRequest = null;
        tyler.efm.services.schema.baseresponse.BaseResponseType _resendActivationEmail__return = port.resendActivationEmail(_resendActivationEmail_resendActivationEmailRequest);
        System.out.println("resendActivationEmail.result=" + _resendActivationEmail__return);


        }
        {
        System.out.println("Invoking getPaymentAccount...");
        tyler.efm.services.schema.getpaymentaccountrequest.GetPaymentAccountRequestType _getPaymentAccount_getPaymentAccountRequest = null;
        tyler.efm.services.schema.getpaymentaccountresponse.GetPaymentAccountResponseType _getPaymentAccount__return = port.getPaymentAccount(_getPaymentAccount_getPaymentAccountRequest);
        System.out.println("getPaymentAccount.result=" + _getPaymentAccount__return);


        }
        {
        System.out.println("Invoking detachServiceContact...");
        tyler.efm.services.schema.detachservicecontactrequest.DetachServiceContactRequestType _detachServiceContact_detachServiceContactRequest = null;
        tyler.efm.services.schema.baseresponse.BaseResponseType _detachServiceContact__return = port.detachServiceContact(_detachServiceContact_detachServiceContactRequest);
        System.out.println("detachServiceContact.result=" + _detachServiceContact__return);


        }
        {
        System.out.println("Invoking getServiceContactList...");
        tyler.efm.services.schema.servicecontactlistresponse.ServiceContactListResponseType _getServiceContactList__return = port.getServiceContactList();
        System.out.println("getServiceContactList.result=" + _getServiceContactList__return);


        }
        {
        System.out.println("Invoking getUserList...");
        tyler.efm.services.schema.userlistresponse.UserListResponseType _getUserList__return = port.getUserList();
        System.out.println("getUserList.result=" + _getUserList__return);


        }
        {
        System.out.println("Invoking getPaymentAccountTypeList...");
        tyler.efm.services.schema.paymentaccounttypelistresponse.PaymentAccountTypeListResponseType _getPaymentAccountTypeList__return = port.getPaymentAccountTypeList();
        System.out.println("getPaymentAccountTypeList.result=" + _getPaymentAccountTypeList__return);


        }
        {
        System.out.println("Invoking removeUser...");
        tyler.efm.services.schema.removeuserrequest.RemoveUserRequestType _removeUser_removeUserRequest = null;
        tyler.efm.services.schema.baseresponse.BaseResponseType _removeUser__return = port.removeUser(_removeUser_removeUserRequest);
        System.out.println("removeUser.result=" + _removeUser__return);


        }
        {
        System.out.println("Invoking getPaymentAccountList...");
        tyler.efm.services.schema.getpaymentaccountlistrequest.GetPaymentAccountListRequestType _getPaymentAccountList_getPaymentAccountListRequest = null;
        tyler.efm.services.schema.paymentaccountlistresponse.PaymentAccountListResponseType _getPaymentAccountList__return = port.getPaymentAccountList(_getPaymentAccountList_getPaymentAccountListRequest);
        System.out.println("getPaymentAccountList.result=" + _getPaymentAccountList__return);


        }
        {
        System.out.println("Invoking removeAttorney...");
        tyler.efm.services.schema.removeattorneyrequest.RemoveAttorneyRequestType _removeAttorney_removeAttorneyRequest = null;
        tyler.efm.services.schema.baseresponse.BaseResponseType _removeAttorney__return = port.removeAttorney(_removeAttorney_removeAttorneyRequest);
        System.out.println("removeAttorney.result=" + _removeAttorney__return);


        }
        {
        System.out.println("Invoking getGlobalPaymentAccountList...");
        tyler.efm.services.schema.paymentaccountlistresponse.PaymentAccountListResponseType _getGlobalPaymentAccountList__return = port.getGlobalPaymentAccountList();
        System.out.println("getGlobalPaymentAccountList.result=" + _getGlobalPaymentAccountList__return);


        }
        {
        System.out.println("Invoking removeGlobalPaymentAccount...");
        tyler.efm.services.schema.removepaymentaccountrequest.RemovePaymentAccountRequestType _removeGlobalPaymentAccount_removeGlobalPaymentAccountRequest = null;
        tyler.efm.services.schema.baseresponse.BaseResponseType _removeGlobalPaymentAccount__return = port.removeGlobalPaymentAccount(_removeGlobalPaymentAccount_removeGlobalPaymentAccountRequest);
        System.out.println("removeGlobalPaymentAccount.result=" + _removeGlobalPaymentAccount__return);


        }
        {
        System.out.println("Invoking updateUser...");
        tyler.efm.services.schema.updateuserrequest.UpdateUserRequestType _updateUser_updateUserRequest = null;
        tyler.efm.services.schema.updateuserresponse.UpdateUserResponseType _updateUser__return = port.updateUser(_updateUser_updateUserRequest);
        System.out.println("updateUser.result=" + _updateUser__return);


        }
        {
        System.out.println("Invoking attachServiceContact...");
        tyler.efm.services.schema.attachservicecontactrequest.AttachServiceContactRequestType _attachServiceContact_attachServiceContactRequest = null;
        tyler.efm.services.schema.baseresponse.BaseResponseType _attachServiceContact__return = port.attachServiceContact(_attachServiceContact_attachServiceContactRequest);
        System.out.println("attachServiceContact.result=" + _attachServiceContact__return);


        }
        {
        System.out.println("Invoking removeUserRole...");
        tyler.efm.services.schema.removeuserrolerequest.RemoveUserRoleRequestType _removeUserRole_removeUserRoleRequest = null;
        tyler.efm.services.schema.baseresponse.BaseResponseType _removeUserRole__return = port.removeUserRole(_removeUserRole_removeUserRoleRequest);
        System.out.println("removeUserRole.result=" + _removeUserRole__return);


        }
        {
        System.out.println("Invoking getAttorneyList...");
        tyler.efm.services.schema.attorneylistresponse.AttorneyListResponseType _getAttorneyList__return = port.getAttorneyList();
        System.out.println("getAttorneyList.result=" + _getAttorneyList__return);


        }
        {
        System.out.println("Invoking updateServiceContact...");
        tyler.efm.services.schema.updateservicecontactrequest.UpdateServiceContactRequestType _updateServiceContact_updateServiceContactRequest = null;
        tyler.efm.services.schema.updateservicecontactresponse.UpdateServiceContactResponseType _updateServiceContact__return = port.updateServiceContact(_updateServiceContact_updateServiceContactRequest);
        System.out.println("updateServiceContact.result=" + _updateServiceContact__return);


        }
        {
        System.out.println("Invoking removeServiceContact...");
        tyler.efm.services.schema.removeservicecontactrequest.RemoveServiceContactRequestType _removeServiceContact_removeServiceContactRequest = null;
        tyler.efm.services.schema.baseresponse.BaseResponseType _removeServiceContact__return = port.removeServiceContact(_removeServiceContact_removeServiceContactRequest);
        System.out.println("removeServiceContact.result=" + _removeServiceContact__return);


        }
        {
        System.out.println("Invoking addUserRole...");
        tyler.efm.services.schema.adduserrolerequest.AddUserRoleRequestType _addUserRole_addUserRoleRequest = null;
        tyler.efm.services.schema.baseresponse.BaseResponseType _addUserRole__return = port.addUserRole(_addUserRole_addUserRoleRequest);
        System.out.println("addUserRole.result=" + _addUserRole__return);


        }
        {
        System.out.println("Invoking createAttorney...");
        tyler.efm.services.schema.createattorneyrequest.CreateAttorneyRequestType _createAttorney_createAttorneyRequest = null;
        tyler.efm.services.schema.createattorneyresponse.CreateAttorneyResponseType _createAttorney__return = port.createAttorney(_createAttorney_createAttorneyRequest);
        System.out.println("createAttorney.result=" + _createAttorney__return);


        }
        {
        System.out.println("Invoking removePaymentAccount...");
        tyler.efm.services.schema.removepaymentaccountrequest.RemovePaymentAccountRequestType _removePaymentAccount_removePaymentAccountRequest = null;
        tyler.efm.services.schema.baseresponse.BaseResponseType _removePaymentAccount__return = port.removePaymentAccount(_removePaymentAccount_removePaymentAccountRequest);
        System.out.println("removePaymentAccount.result=" + _removePaymentAccount__return);


        }
        {
        System.out.println("Invoking createServiceContact...");
        tyler.efm.services.schema.createservicecontactrequest.CreateServiceContactRequestType _createServiceContact_createServiceContactRequest = null;
        tyler.efm.services.schema.createservicecontactresponse.CreateServiceContactResponseType _createServiceContact__return = port.createServiceContact(_createServiceContact_createServiceContactRequest);
        System.out.println("createServiceContact.result=" + _createServiceContact__return);


        }
        {
        System.out.println("Invoking updateAttorney...");
        tyler.efm.services.schema.updateattorneyrequest.UpdateAttorneyRequestType _updateAttorney_updateAttorneyRequest = null;
        tyler.efm.services.schema.updateattorneyresponse.UpdateAttorneyResponseType _updateAttorney__return = port.updateAttorney(_updateAttorney_updateAttorneyRequest);
        System.out.println("updateAttorney.result=" + _updateAttorney__return);


        }
        {
        System.out.println("Invoking registerUser...");
        tyler.efm.services.schema.registrationrequest.RegistrationRequestType _registerUser_registerUserRequest = null;
        tyler.efm.services.schema.registrationresponse.RegistrationResponseType _registerUser__return = port.registerUser(_registerUser_registerUserRequest);
        System.out.println("registerUser.result=" + _registerUser__return);


        }
        {
        System.out.println("Invoking updateFirm...");
        tyler.efm.services.schema.updatefirmrequest.UpdateFirmRequestType _updateFirm_updateFirmRequest = null;
        tyler.efm.services.schema.baseresponse.BaseResponseType _updateFirm__return = port.updateFirm(_updateFirm_updateFirmRequest);
        System.out.println("updateFirm.result=" + _updateFirm__return);


        }
        {
        System.out.println("Invoking resetUserPassword...");
        tyler.efm.services.schema.resetuserpasswordrequest.ResetUserPasswordRequestType _resetUserPassword_resetUserPasswordRequest = null;
        tyler.efm.services.schema.resetpasswordresponse.ResetPasswordResponseType _resetUserPassword__return = port.resetUserPassword(_resetUserPassword_resetUserPasswordRequest);
        System.out.println("resetUserPassword.result=" + _resetUserPassword__return);


        }
        {
        System.out.println("Invoking getFirm...");
        tyler.efm.services.schema.getfirmresponse.GetFirmResponseType _getFirm__return = port.getFirm();
        System.out.println("getFirm.result=" + _getFirm__return);


        }
        {
        System.out.println("Invoking createGlobalPaymentAccount...");
        tyler.efm.services.schema.createpaymentaccountrequest.CreatePaymentAccountRequestType _createGlobalPaymentAccount_createGlobalPaymentAccountRequest = null;
        tyler.efm.services.schema.createpaymentaccountresponse.CreatePaymentAccountResponseType _createGlobalPaymentAccount__return = port.createGlobalPaymentAccount(_createGlobalPaymentAccount_createGlobalPaymentAccountRequest);
        System.out.println("createGlobalPaymentAccount.result=" + _createGlobalPaymentAccount__return);


        }

        System.exit(0);
    }

}
