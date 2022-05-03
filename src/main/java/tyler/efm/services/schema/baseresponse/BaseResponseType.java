
package tyler.efm.services.schema.baseresponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.services.schema.attorneylistresponse.AttorneyListResponseType;
import tyler.efm.services.schema.authenticateresponse.AuthenticateResponseType;
import tyler.efm.services.schema.changepasswordresponse.ChangePasswordResponseType;
import tyler.efm.services.schema.common.ErrorType;
import tyler.efm.services.schema.createattorneyresponse.CreateAttorneyResponseType;
import tyler.efm.services.schema.createpaymentaccountresponse.CreatePaymentAccountResponseType;
import tyler.efm.services.schema.createservicecontactresponse.CreateServiceContactResponseType;
import tyler.efm.services.schema.getattorneyresponse.GetAttorneyResponseType;
import tyler.efm.services.schema.getfirmresponse.GetFirmResponseType;
import tyler.efm.services.schema.getpaymentaccountresponse.GetPaymentAccountResponseType;
import tyler.efm.services.schema.getservicecontactresponse.GetServiceContactResponseType;
import tyler.efm.services.schema.getuserresponse.GetUserResponseType;
import tyler.efm.services.schema.notificationpreferencesresponse.NotificationPreferencesResponseType;
import tyler.efm.services.schema.passwordquestionresponse.PasswordQuestionResponseType;
import tyler.efm.services.schema.paymentaccountlistresponse.PaymentAccountListResponseType;
import tyler.efm.services.schema.paymentaccounttypelistresponse.PaymentAccountTypeListResponseType;
import tyler.efm.services.schema.registrationresponse.RegistrationResponseType;
import tyler.efm.services.schema.resetpasswordresponse.ResetPasswordResponseType;
import tyler.efm.services.schema.servicecontactlistresponse.ServiceContactListResponseType;
import tyler.efm.services.schema.updateattorneyresponse.UpdateAttorneyResponseType;
import tyler.efm.services.schema.updatepaymentaccountresponse.UpdatePaymentAccountResponseType;
import tyler.efm.services.schema.updateservicecontactresponse.UpdateServiceContactResponseType;
import tyler.efm.services.schema.updateuserresponse.UpdateUserResponseType;
import tyler.efm.services.schema.userlistresponse.UserListResponseType;


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
    ResetPasswordResponseType.class,
    PasswordQuestionResponseType.class,
    ChangePasswordResponseType.class,
    AuthenticateResponseType.class,
    GetUserResponseType.class,
    UpdateUserResponseType.class,
    NotificationPreferencesResponseType.class,
    UserListResponseType.class,
    UpdateServiceContactResponseType.class,
    UpdatePaymentAccountResponseType.class,
    UpdateAttorneyResponseType.class,
    ServiceContactListResponseType.class,
    RegistrationResponseType.class,
    PaymentAccountTypeListResponseType.class,
    PaymentAccountListResponseType.class,
    GetServiceContactResponseType.class,
    GetPaymentAccountResponseType.class,
    GetFirmResponseType.class,
    GetAttorneyResponseType.class,
    CreateServiceContactResponseType.class,
    CreatePaymentAccountResponseType.class,
    CreateAttorneyResponseType.class,
    AttorneyListResponseType.class
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
