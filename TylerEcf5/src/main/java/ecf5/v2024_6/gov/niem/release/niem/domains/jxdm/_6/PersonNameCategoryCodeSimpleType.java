
package ecf5.v2024_6.gov.niem.release.niem.domains.jxdm._6;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonNameCategoryCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="PersonNameCategoryCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="aka"/&gt;
 *     &lt;enumeration value="alias"/&gt;
 *     &lt;enumeration value="call sign"/&gt;
 *     &lt;enumeration value="dba"/&gt;
 *     &lt;enumeration value="fka"/&gt;
 *     &lt;enumeration value="handle"/&gt;
 *     &lt;enumeration value="moniker"/&gt;
 *     &lt;enumeration value="nickname"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *     &lt;enumeration value="provided"/&gt;
 *     &lt;enumeration value="pseudonym"/&gt;
 *     &lt;enumeration value="unknown"/&gt;
 *     &lt;enumeration value="user id"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PersonNameCategoryCodeSimpleType")
@XmlEnum
public enum PersonNameCategoryCodeSimpleType {


    /**
     * Also known as, e.g., a stage name
     * 
     */
    @XmlEnumValue("aka")
    AKA("aka"),

    /**
     * An assumed or alternate name suspected to be in use for deception; usually involves criminal intent.  A term used in legal proceedings to connect the different names of anyone who has gone by two or more, and whose true name is for any cause doubtful.
     * 
     */
    @XmlEnumValue("alias")
    ALIAS("alias"),

    /**
     * A registered radio identifier used by amateur radio operators; usually a string of alpha-numeric characters.
     * 
     */
    @XmlEnumValue("call sign")
    CALL_SIGN("call sign"),

    /**
     * Doing business as
     * 
     */
    @XmlEnumValue("dba")
    DBA("dba"),

    /**
     * Formerly known as
     * 
     */
    @XmlEnumValue("fka")
    FKA("fka"),

    /**
     * An electronic pseudonym; intended to conceal the user's true identity.  Commonly used areas include the Internet, chatrooms, networks, bulletin board systems (BBS), and Citizen's Band (CB) radio; sometimes used by radio operators as an alternative to a call sign.  May or may not be used for criminal deception.  (also screen name)
     * 
     */
    @XmlEnumValue("handle")
    HANDLE("handle"),

    /**
     * A nickname specifically used by gang members or criminals to hide real identity for criminal purposes.
     * 
     */
    @XmlEnumValue("moniker")
    MONIKER("moniker"),

    /**
     * A descriptive name added to or replacing the actual name of a person, place, or thing.  A familiar or shortened form of a proper name.  (also street name)
     * 
     */
    @XmlEnumValue("nickname")
    NICKNAME("nickname"),

    /**
     * None of the other types is appropriate.  (Explain in text field.)
     * 
     */
    @XmlEnumValue("other")
    OTHER("other"),

    /**
     * A name communicated by an individual directly or through documentation being carried; obtained from the source of the record and which is not known to be an alias or aka name.
     * 
     */
    @XmlEnumValue("provided")
    PROVIDED("provided"),

    /**
     * A fictitious name, especially a pen name; not normally for criminal purposes.
     * 
     */
    @XmlEnumValue("pseudonym")
    PSEUDONYM("pseudonym"),

    /**
     * Indefinite; unsure of this type of name.
     * 
     */
    @XmlEnumValue("unknown")
    UNKNOWN("unknown"),

    /**
     * A number or name which is unique to a particular user of a computer or group of computers which share user information.  A user id is not normally used for criminal intent, unless it is being used without authorization.  An operating system uses the user id to represent the user in its data structures, e.g. the owner of a file or process, the person attempting to access a system resource. (also uid, userid)
     * 
     */
    @XmlEnumValue("user id")
    USER_ID("user id");
    private final String value;

    PersonNameCategoryCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PersonNameCategoryCodeSimpleType fromValue(String v) {
        for (PersonNameCategoryCodeSimpleType c: PersonNameCategoryCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
