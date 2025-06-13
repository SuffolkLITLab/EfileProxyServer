
package tyler.efm.v2022_1.services.schema.baseresponse;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.v2022_1.services.schema.attorneylistresponse.AttorneyListResponseType;
import tyler.efm.v2022_1.services.schema.authenticateresponse.AuthenticateResponseType;
import tyler.efm.v2022_1.services.schema.changepasswordresponse.ChangePasswordResponseType;
import tyler.efm.v2022_1.services.schema.common.ErrorType;
import tyler.efm.v2022_1.services.schema.createattorneyresponse.CreateAttorneyResponseType;
import tyler.efm.v2022_1.services.schema.createpaymentaccountresponse.CreatePaymentAccountResponseType;
import tyler.efm.v2022_1.services.schema.createservicecontactresponse.CreateServiceContactResponseType;
import tyler.efm.v2022_1.services.schema.getattorneyresponse.GetAttorneyResponseType;
import tyler.efm.v2022_1.services.schema.getfirmresponse.GetFirmResponseType;
import tyler.efm.v2022_1.services.schema.getpaymentaccountresponse.GetPaymentAccountResponseType;
import tyler.efm.v2022_1.services.schema.getservicecontactresponse.GetServiceContactResponseType;
import tyler.efm.v2022_1.services.schema.getuserresponse.GetUserResponseType;
import tyler.efm.v2022_1.services.schema.getvitalchekpaymentaccountidresponse.GetVitalChekPaymentAccountIdResponseType;
import tyler.efm.v2022_1.services.schema.notificationpreferenceslistresponse.NotificationPreferencesListResponseType;
import tyler.efm.v2022_1.services.schema.passwordquestionresponse.PasswordQuestionResponseType;
import tyler.efm.v2022_1.services.schema.paymentaccountlistresponse.PaymentAccountListResponseType;
import tyler.efm.v2022_1.services.schema.paymentaccounttypelistresponse.PaymentAccountTypeListResponseType;
import tyler.efm.v2022_1.services.schema.registrationresponse.RegistrationResponseType;
import tyler.efm.v2022_1.services.schema.resetpasswordresponse.ResetPasswordResponseType;
import tyler.efm.v2022_1.services.schema.servicecontactlistresponse.ServiceContactListResponseType;
import tyler.efm.v2022_1.services.schema.updateattorneyresponse.UpdateAttorneyResponseType;
import tyler.efm.v2022_1.services.schema.updatepaymentaccountresponse.UpdatePaymentAccountResponseType;
import tyler.efm.v2022_1.services.schema.updateservicecontactresponse.UpdateServiceContactResponseType;
import tyler.efm.v2022_1.services.schema.updateuserresponse.UpdateUserResponseType;
import tyler.efm.v2022_1.services.schema.userlistresponse.UserListResponseType;


/**
 * <p>Java class for BaseResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Error" type="{urn:tyler:efm:services:schema:Common}ErrorType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseResponseType", propOrder = {
    "error"
})
@XmlSeeAlso({
    RegistrationResponseType.class,
    UserListResponseType.class,
    GetUserResponseType.class,
    UpdateUserResponseType.class,
    GetFirmResponseType.class,
    AttorneyListResponseType.class,
    GetAttorneyResponseType.class,
    UpdateAttorneyResponseType.class,
    CreateAttorneyResponseType.class,
    PaymentAccountTypeListResponseType.class,
    PaymentAccountListResponseType.class,
    GetPaymentAccountResponseType.class,
    GetVitalChekPaymentAccountIdResponseType.class,
    UpdatePaymentAccountResponseType.class,
    CreatePaymentAccountResponseType.class,
    ServiceContactListResponseType.class,
    GetServiceContactResponseType.class,
    UpdateServiceContactResponseType.class,
    CreateServiceContactResponseType.class,
    ResetPasswordResponseType.class,
    NotificationPreferencesListResponseType.class,
    ChangePasswordResponseType.class,
    AuthenticateResponseType.class,
    PasswordQuestionResponseType.class
})
public class BaseResponseType {

    @XmlElement(name = "Error")
    protected ErrorType error;

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorType }
     *     
     */
    public ErrorType getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorType }
     *     
     */
    public void setError(ErrorType value) {
        this.error = value;
    }

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
