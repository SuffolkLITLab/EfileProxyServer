
package tyler.efm.v2022_1.services.schema.baserequest;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.v2022_1.services.schema.adduserrolerequest.AddUserRoleRequestType;
import tyler.efm.v2022_1.services.schema.attachservicecontactrequest.AttachServiceContactRequestType;
import tyler.efm.v2022_1.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.v2022_1.services.schema.changepasswordrequest.ChangePasswordRequestType;
import tyler.efm.v2022_1.services.schema.createattorneyrequest.CreateAttorneyRequestType;
import tyler.efm.v2022_1.services.schema.createpaymentaccountrequest.CreatePaymentAccountRequestType;
import tyler.efm.v2022_1.services.schema.createservicecontactrequest.CreateServiceContactRequestType;
import tyler.efm.v2022_1.services.schema.detachservicecontactrequest.DetachServiceContactRequestType;
import tyler.efm.v2022_1.services.schema.getattorneyrequest.GetAttorneyRequestType;
import tyler.efm.v2022_1.services.schema.getpasswordquestionrequest.GetPasswordQuestionRequestType;
import tyler.efm.v2022_1.services.schema.getpaymentaccountlistrequest.GetPaymentAccountListRequestType;
import tyler.efm.v2022_1.services.schema.getpaymentaccountrequest.GetPaymentAccountRequestType;
import tyler.efm.v2022_1.services.schema.getpubliclistrequest.GetPublicListRequestType;
import tyler.efm.v2022_1.services.schema.getservicecontactrequest.GetServiceContactRequestType;
import tyler.efm.v2022_1.services.schema.getuserrequest.GetUserRequestType;
import tyler.efm.v2022_1.services.schema.registrationrequest.RegistrationRequestType;
import tyler.efm.v2022_1.services.schema.removeattorneyrequest.RemoveAttorneyRequestType;
import tyler.efm.v2022_1.services.schema.removepaymentaccountrequest.RemovePaymentAccountRequestType;
import tyler.efm.v2022_1.services.schema.removeservicecontactrequest.RemoveServiceContactRequestType;
import tyler.efm.v2022_1.services.schema.removeuserrequest.RemoveUserRequestType;
import tyler.efm.v2022_1.services.schema.removeuserrolerequest.RemoveUserRoleRequestType;
import tyler.efm.v2022_1.services.schema.resendactivationemailrequest.ResendActivationEmailRequestType;
import tyler.efm.v2022_1.services.schema.resetpasswordrequest.ResetPasswordRequestType;
import tyler.efm.v2022_1.services.schema.resetuserpasswordrequest.ResetUserPasswordRequestType;
import tyler.efm.v2022_1.services.schema.updateattorneyrequest.UpdateAttorneyRequestType;
import tyler.efm.v2022_1.services.schema.updatefirmrequest.UpdateFirmRequestType;
import tyler.efm.v2022_1.services.schema.updatepaymentaccountrequest.UpdatePaymentAccountRequestType;
import tyler.efm.v2022_1.services.schema.updateservicecontactrequest.UpdateServiceContactRequestType;
import tyler.efm.v2022_1.services.schema.updateuserrequest.UpdateUserRequestType;


/**
 * <p>Java class for BaseRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseRequestType")
@XmlSeeAlso({
    RegistrationRequestType.class,
    GetUserRequestType.class,
    AddUserRoleRequestType.class,
    RemoveUserRoleRequestType.class,
    UpdateUserRequestType.class,
    RemoveUserRequestType.class,
    UpdateFirmRequestType.class,
    GetAttorneyRequestType.class,
    UpdateAttorneyRequestType.class,
    CreateAttorneyRequestType.class,
    RemoveAttorneyRequestType.class,
    GetPaymentAccountRequestType.class,
    UpdatePaymentAccountRequestType.class,
    CreatePaymentAccountRequestType.class,
    RemovePaymentAccountRequestType.class,
    GetServiceContactRequestType.class,
    UpdateServiceContactRequestType.class,
    CreateServiceContactRequestType.class,
    RemoveServiceContactRequestType.class,
    AttachServiceContactRequestType.class,
    DetachServiceContactRequestType.class,
    ResetUserPasswordRequestType.class,
    ResendActivationEmailRequestType.class,
    GetPublicListRequestType.class,
    GetPaymentAccountListRequestType.class,
    ChangePasswordRequestType.class,
    AuthenticateRequestType.class,
    ResetPasswordRequestType.class,
    GetPasswordQuestionRequestType.class
})
public class BaseRequestType {


    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
