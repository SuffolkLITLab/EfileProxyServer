
package tyler.efm.services.schema.baserequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.adduserrolerequest.AddUserRoleRequestType;
import tyler.efm.services.schema.attachservicecontactrequest.AttachServiceContactRequestType;
import tyler.efm.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.services.schema.changepasswordrequest.ChangePasswordRequestType;
import tyler.efm.services.schema.createattorneyrequest.CreateAttorneyRequestType;
import tyler.efm.services.schema.createpaymentaccountrequest.CreatePaymentAccountRequestType;
import tyler.efm.services.schema.createservicecontactrequest.CreateServiceContactRequestType;
import tyler.efm.services.schema.detachservicecontactrequest.DetachServiceContactRequestType;
import tyler.efm.services.schema.getattorneyrequest.GetAttorneyRequestType;
import tyler.efm.services.schema.getpasswordquestionrequest.GetPasswordQuestionRequestType;
import tyler.efm.services.schema.getpaymentaccountrequest.GetPaymentAccountRequestType;
import tyler.efm.services.schema.getservicecontactrequest.GetServiceContactRequestType;
import tyler.efm.services.schema.getuserrequest.GetUserRequestType;
import tyler.efm.services.schema.registrationrequest.RegistrationRequestType;
import tyler.efm.services.schema.removeattorneyrequest.RemoveAttorneyRequestType;
import tyler.efm.services.schema.removepaymentaccountrequest.RemovePaymentAccountRequestType;
import tyler.efm.services.schema.removeservicecontactrequest.RemoveServiceContactRequestType;
import tyler.efm.services.schema.removeuserrequest.RemoveUserRequestType;
import tyler.efm.services.schema.removeuserrolerequest.RemoveUserRoleRequestType;
import tyler.efm.services.schema.resendactivationemailrequest.ResendActivationEmailRequestType;
import tyler.efm.services.schema.resetpasswordrequest.ResetPasswordRequestType;
import tyler.efm.services.schema.resetuserpasswordrequest.ResetUserPasswordRequestType;
import tyler.efm.services.schema.selfresendactivationemailrequest.SelfResendActivationEmailRequestType;
import tyler.efm.services.schema.updateattorneyrequest.UpdateAttorneyRequestType;
import tyler.efm.services.schema.updatefirmrequest.UpdateFirmRequestType;
import tyler.efm.services.schema.updatenotificationpreferencesrequest.UpdateNotificationPreferencesRequestType;
import tyler.efm.services.schema.updatepaymentaccountrequest.UpdatePaymentAccountRequestType;
import tyler.efm.services.schema.updateservicecontactrequest.UpdateServiceContactRequestType;
import tyler.efm.services.schema.updateuserrequest.UpdateUserRequestType;


/**
 * &lt;p&gt;Java class for BaseRequestType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="BaseRequestType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseRequestType")
@XmlSeeAlso({
    GetPaymentAccountRequestType.class,
    DetachServiceContactRequestType.class,
    UpdateFirmRequestType.class,
    ChangePasswordRequestType.class,
    GetAttorneyRequestType.class,
    RegistrationRequestType.class,
    ResetUserPasswordRequestType.class,
    ResendActivationEmailRequestType.class,
    SelfResendActivationEmailRequestType.class,
    UpdateAttorneyRequestType.class,
    RemoveUserRequestType.class,
    CreateServiceContactRequestType.class,
    CreatePaymentAccountRequestType.class,
    AuthenticateRequestType.class,
    RemoveServiceContactRequestType.class,
    GetPasswordQuestionRequestType.class,
    UpdateUserRequestType.class,
    GetUserRequestType.class,
    GetServiceContactRequestType.class,
    CreateAttorneyRequestType.class,
    ResetPasswordRequestType.class,
    RemovePaymentAccountRequestType.class,
    UpdateNotificationPreferencesRequestType.class,
    RemoveUserRoleRequestType.class,
    UpdatePaymentAccountRequestType.class,
    AddUserRoleRequestType.class,
    UpdateServiceContactRequestType.class,
    RemoveAttorneyRequestType.class,
    AttachServiceContactRequestType.class
})
public class BaseRequestType {


}
