
package gov.niem.release.niem.codes.cbrncl._4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MessageStatusCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="MessageStatusCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="ActivityCodeFailure"/&gt;
 *     &lt;enumeration value="DataError"/&gt;
 *     &lt;enumeration value="DeviceError"/&gt;
 *     &lt;enumeration value="DuplicateMessage"/&gt;
 *     &lt;enumeration value="ErrorAcknowledgement"/&gt;
 *     &lt;enumeration value="InvalidSchema"/&gt;
 *     &lt;enumeration value="MessageError"/&gt;
 *     &lt;enumeration value="Other"/&gt;
 *     &lt;enumeration value="Success"/&gt;
 *     &lt;enumeration value="SystemError"/&gt;
 *     &lt;enumeration value="UnknownError"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MessageStatusCodeSimpleType")
@XmlEnum
public enum MessageStatusCodeSimpleType {


    /**
     * The message was successfully received by not successfully processed due to an activity code error.
     * 
     */
    @XmlEnumValue("ActivityCodeFailure")
    ACTIVITY_CODE_FAILURE("ActivityCodeFailure"),

    /**
     * The message was successfully received by not successfully processed due to a data error.
     * 
     */
    @XmlEnumValue("DataError")
    DATA_ERROR("DataError"),

    /**
     * The message was successfully received by not successfully processed due to a device error.
     * 
     */
    @XmlEnumValue("DeviceError")
    DEVICE_ERROR("DeviceError"),

    /**
     * The message was successfully received but not processed since it is a duplicate of a message already processed.
     * 
     */
    @XmlEnumValue("DuplicateMessage")
    DUPLICATE_MESSAGE("DuplicateMessage"),

    /**
     * Acknowledgement of receipt of an error message.
     * 
     */
    @XmlEnumValue("ErrorAcknowledgement")
    ERROR_ACKNOWLEDGEMENT("ErrorAcknowledgement"),

    /**
     * The message was received, but was not successfully processed due to an invalid schema.
     * 
     */
    @XmlEnumValue("InvalidSchema")
    INVALID_SCHEMA("InvalidSchema"),

    /**
     * The message was received, but was not successfully processed due to an invalid message error (invalid Message Type, encoding, format, etc.)
     * 
     */
    @XmlEnumValue("MessageError")
    MESSAGE_ERROR("MessageError"),

    /**
     * The message status does not fit any known category.
     * 
     */
    @XmlEnumValue("Other")
    OTHER("Other"),

    /**
     * The message was sucessfully received and accepted.
     * 
     */
    @XmlEnumValue("Success")
    SUCCESS("Success"),

    /**
     * The message was successfully received by not successfully processed due to a system error.
     * 
     */
    @XmlEnumValue("SystemError")
    SYSTEM_ERROR("SystemError"),

    /**
     * The message was not successfully received and/or processed due to an unknown error.
     * 
     */
    @XmlEnumValue("UnknownError")
    UNKNOWN_ERROR("UnknownError");
    private final String value;

    MessageStatusCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MessageStatusCodeSimpleType fromValue(String v) {
        for (MessageStatusCodeSimpleType c: MessageStatusCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
