
package ietf.params.xml.ns.icalendar_2;

import java.math.BigInteger;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ietf.params.xml.ns.icalendar_2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Binary_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "binary");
    private final static QName _Boolean_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "boolean");
    private final static QName _CalAddress_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "cal-address");
    private final static QName _Date_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "date");
    private final static QName _DateTime_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "date-time");
    private final static QName _UtcDateTime_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "utc-date-time");
    private final static QName _Float_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "float");
    private final static QName _Integer_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "integer");
    private final static QName _Period_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "period");
    private final static QName _Until_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "until");
    private final static QName _Count_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "count");
    private final static QName _Text_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "text");
    private final static QName _Time_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "time");
    private final static QName _Uri_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "uri");
    private final static QName _UtcOffset_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "utc-offset");
    private final static QName _BaseParameter_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "baseParameter");
    private final static QName _Altrep_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "altrep");
    private final static QName _Cn_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "cn");
    private final static QName _Cutype_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "cutype");
    private final static QName _DelegatedFrom_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "delegated-from");
    private final static QName _DelegatedTo_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "delegated-to");
    private final static QName _Dir_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "dir");
    private final static QName _Encoding_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "encoding");
    private final static QName _Fmttype_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "fmttype");
    private final static QName _Fbtype_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "fbtype");
    private final static QName _Language_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "language");
    private final static QName _Member_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "member");
    private final static QName _Partstat_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "partstat");
    private final static QName _Range_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "range");
    private final static QName _Related_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "related");
    private final static QName _Reltype_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "reltype");
    private final static QName _Role_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "role");
    private final static QName _Rsvp_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "rsvp");
    private final static QName _SentBy_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "sent-by");
    private final static QName _Tzid_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "tzid");
    private final static QName _ScheduleAgent_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "schedule-agent");
    private final static QName _ScheduleForceSend_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "schedule-force-send");
    private final static QName _ScheduleStatus_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "schedule-status");
    private final static QName _Parameters_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "parameters");
    private final static QName _BaseProperty_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "baseProperty");
    private final static QName _Calscale_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "calscale");
    private final static QName _Method_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "method");
    private final static QName _Prodid_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "prodid");
    private final static QName _Version_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "version");
    private final static QName _Attach_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "attach");
    private final static QName _Categories_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "categories");
    private final static QName _Class_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "class");
    private final static QName _Comment_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "comment");
    private final static QName _Description_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "description");
    private final static QName _Geo_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "geo");
    private final static QName _Location_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "location");
    private final static QName _PercentComplete_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "percent-complete");
    private final static QName _Priority_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "priority");
    private final static QName _Resources_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "resources");
    private final static QName _Status_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "status");
    private final static QName _Summary_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "summary");
    private final static QName _Completed_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "completed");
    private final static QName _Dtend_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "dtend");
    private final static QName _Dtstart_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "dtstart");
    private final static QName _Due_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "due");
    private final static QName _Duration_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "duration");
    private final static QName _Freebusy_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "freebusy");
    private final static QName _Transp_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "transp");
    private final static QName _Tzname_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "tzname");
    private final static QName _Tzoffsetfrom_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "tzoffsetfrom");
    private final static QName _Tzoffsetto_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "tzoffsetto");
    private final static QName _Tzurl_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "tzurl");
    private final static QName _Attendee_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "attendee");
    private final static QName _Contact_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "contact");
    private final static QName _Organizer_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "organizer");
    private final static QName _RecurrenceId_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "recurrence-id");
    private final static QName _Url_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "url");
    private final static QName _Uid_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "uid");
    private final static QName _Exdate_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "exdate");
    private final static QName _Rdate_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "rdate");
    private final static QName _RelatedTo_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "related-to");
    private final static QName _Exrule_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "exrule");
    private final static QName _Rrule_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "rrule");
    private final static QName _Action_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "action");
    private final static QName _Repeat_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "repeat");
    private final static QName _Trigger_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "trigger");
    private final static QName _Created_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "created");
    private final static QName _Dtstamp_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "dtstamp");
    private final static QName _LastModified_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "last-modified");
    private final static QName _Sequence_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "sequence");
    private final static QName _RequestStatus_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "request-status");
    private final static QName _Latitude_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "latitude");
    private final static QName _Longitude_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "longitude");
    private final static QName _Rel_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "rel");
    private final static QName _Link_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "link");
    private final static QName _XBedeworkUid_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-uid");
    private final static QName _XBedeworkCost_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-cost");
    private final static QName _XBedeworkExsynchEndtzid_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-exsynch-endtzid");
    private final static QName _XBedeworkExsynchLastmod_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-exsynch-lastmod");
    private final static QName _XBedeworkExsynchOrganizer_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-exsynch-organizer");
    private final static QName _XBedeworkExsynchStarttzid_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-bedework-exsynch-starttzid");
    private final static QName _XMicrosoftCdoBusystatus_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-microsoft-cdo-busystatus");
    private final static QName _XMicrosoftCdoIntendedstatus_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-microsoft-cdo-intendedstatus");
    private final static QName _Vavailability_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "vavailability");
    private final static QName _VcalendarContainedComponent_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "vcalendarContainedComponent");
    private final static QName _Available_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "available");
    private final static QName _BaseComponent_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "baseComponent");
    private final static QName _Gap_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "gap");
    private final static QName _Granularity_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "granularity");
    private final static QName _Tolerance_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "tolerance");
    private final static QName _Gluon_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "gluon");
    private final static QName _Interval_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "interval");
    private final static QName _XWsCalendarAttach_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-wsCalendar-attach");
    private final static QName _XWscalendarType_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "x-wscalendar-type");
    private final static QName _Artifact_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "artifact");
    private final static QName _ArtifactBase_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "artifactBase");
    private final static QName _Vevent_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "vevent");
    private final static QName _Vtodo_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "vtodo");
    private final static QName _Vjournal_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "vjournal");
    private final static QName _Vfreebusy_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "vfreebusy");
    private final static QName _Vtimezone_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "vtimezone");
    private final static QName _Standard_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "standard");
    private final static QName _Daylight_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "daylight");
    private final static QName _Valarm_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "valarm");
    private final static QName _Icalendar_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "icalendar");
    private final static QName _Vcalendar_QNAME = new QName("urn:ietf:params:xml:ns:icalendar-2.0", "vcalendar");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ietf.params.xml.ns.icalendar_2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PeriodType }
     * 
     */
    public PeriodType createPeriodType() {
        return new PeriodType();
    }

    /**
     * Create an instance of {@link UntilRecurType }
     * 
     */
    public UntilRecurType createUntilRecurType() {
        return new UntilRecurType();
    }

    /**
     * Create an instance of {@link AltrepParamType }
     * 
     */
    public AltrepParamType createAltrepParamType() {
        return new AltrepParamType();
    }

    /**
     * Create an instance of {@link CnParamType }
     * 
     */
    public CnParamType createCnParamType() {
        return new CnParamType();
    }

    /**
     * Create an instance of {@link CutypeParamType }
     * 
     */
    public CutypeParamType createCutypeParamType() {
        return new CutypeParamType();
    }

    /**
     * Create an instance of {@link DelegatedFromParamType }
     * 
     */
    public DelegatedFromParamType createDelegatedFromParamType() {
        return new DelegatedFromParamType();
    }

    /**
     * Create an instance of {@link DelegatedToParamType }
     * 
     */
    public DelegatedToParamType createDelegatedToParamType() {
        return new DelegatedToParamType();
    }

    /**
     * Create an instance of {@link DirParamType }
     * 
     */
    public DirParamType createDirParamType() {
        return new DirParamType();
    }

    /**
     * Create an instance of {@link EncodingParamType }
     * 
     */
    public EncodingParamType createEncodingParamType() {
        return new EncodingParamType();
    }

    /**
     * Create an instance of {@link FmttypeParamType }
     * 
     */
    public FmttypeParamType createFmttypeParamType() {
        return new FmttypeParamType();
    }

    /**
     * Create an instance of {@link FbtypeParamType }
     * 
     */
    public FbtypeParamType createFbtypeParamType() {
        return new FbtypeParamType();
    }

    /**
     * Create an instance of {@link LanguageParamType }
     * 
     */
    public LanguageParamType createLanguageParamType() {
        return new LanguageParamType();
    }

    /**
     * Create an instance of {@link MemberParamType }
     * 
     */
    public MemberParamType createMemberParamType() {
        return new MemberParamType();
    }

    /**
     * Create an instance of {@link PartstatParamType }
     * 
     */
    public PartstatParamType createPartstatParamType() {
        return new PartstatParamType();
    }

    /**
     * Create an instance of {@link RangeParamType }
     * 
     */
    public RangeParamType createRangeParamType() {
        return new RangeParamType();
    }

    /**
     * Create an instance of {@link RelatedParamType }
     * 
     */
    public RelatedParamType createRelatedParamType() {
        return new RelatedParamType();
    }

    /**
     * Create an instance of {@link ReltypeParamType }
     * 
     */
    public ReltypeParamType createReltypeParamType() {
        return new ReltypeParamType();
    }

    /**
     * Create an instance of {@link RoleParamType }
     * 
     */
    public RoleParamType createRoleParamType() {
        return new RoleParamType();
    }

    /**
     * Create an instance of {@link RsvpParamType }
     * 
     */
    public RsvpParamType createRsvpParamType() {
        return new RsvpParamType();
    }

    /**
     * Create an instance of {@link SentByParamType }
     * 
     */
    public SentByParamType createSentByParamType() {
        return new SentByParamType();
    }

    /**
     * Create an instance of {@link TzidParamType }
     * 
     */
    public TzidParamType createTzidParamType() {
        return new TzidParamType();
    }

    /**
     * Create an instance of {@link ScheduleAgentParamType }
     * 
     */
    public ScheduleAgentParamType createScheduleAgentParamType() {
        return new ScheduleAgentParamType();
    }

    /**
     * Create an instance of {@link ScheduleForceSendParamType }
     * 
     */
    public ScheduleForceSendParamType createScheduleForceSendParamType() {
        return new ScheduleForceSendParamType();
    }

    /**
     * Create an instance of {@link ScheduleStatusParamType }
     * 
     */
    public ScheduleStatusParamType createScheduleStatusParamType() {
        return new ScheduleStatusParamType();
    }

    /**
     * Create an instance of {@link ArrayOfParameters }
     * 
     */
    public ArrayOfParameters createArrayOfParameters() {
        return new ArrayOfParameters();
    }

    /**
     * Create an instance of {@link CalscalePropType }
     * 
     */
    public CalscalePropType createCalscalePropType() {
        return new CalscalePropType();
    }

    /**
     * Create an instance of {@link MethodPropType }
     * 
     */
    public MethodPropType createMethodPropType() {
        return new MethodPropType();
    }

    /**
     * Create an instance of {@link ProdidPropType }
     * 
     */
    public ProdidPropType createProdidPropType() {
        return new ProdidPropType();
    }

    /**
     * Create an instance of {@link VersionPropType }
     * 
     */
    public VersionPropType createVersionPropType() {
        return new VersionPropType();
    }

    /**
     * Create an instance of {@link AttachPropType }
     * 
     */
    public AttachPropType createAttachPropType() {
        return new AttachPropType();
    }

    /**
     * Create an instance of {@link CategoriesPropType }
     * 
     */
    public CategoriesPropType createCategoriesPropType() {
        return new CategoriesPropType();
    }

    /**
     * Create an instance of {@link ClassPropType }
     * 
     */
    public ClassPropType createClassPropType() {
        return new ClassPropType();
    }

    /**
     * Create an instance of {@link CommentPropType }
     * 
     */
    public CommentPropType createCommentPropType() {
        return new CommentPropType();
    }

    /**
     * Create an instance of {@link DescriptionPropType }
     * 
     */
    public DescriptionPropType createDescriptionPropType() {
        return new DescriptionPropType();
    }

    /**
     * Create an instance of {@link GeoPropType }
     * 
     */
    public GeoPropType createGeoPropType() {
        return new GeoPropType();
    }

    /**
     * Create an instance of {@link LocationPropType }
     * 
     */
    public LocationPropType createLocationPropType() {
        return new LocationPropType();
    }

    /**
     * Create an instance of {@link PercentCompletePropType }
     * 
     */
    public PercentCompletePropType createPercentCompletePropType() {
        return new PercentCompletePropType();
    }

    /**
     * Create an instance of {@link PriorityPropType }
     * 
     */
    public PriorityPropType createPriorityPropType() {
        return new PriorityPropType();
    }

    /**
     * Create an instance of {@link ResourcesPropType }
     * 
     */
    public ResourcesPropType createResourcesPropType() {
        return new ResourcesPropType();
    }

    /**
     * Create an instance of {@link StatusPropType }
     * 
     */
    public StatusPropType createStatusPropType() {
        return new StatusPropType();
    }

    /**
     * Create an instance of {@link SummaryPropType }
     * 
     */
    public SummaryPropType createSummaryPropType() {
        return new SummaryPropType();
    }

    /**
     * Create an instance of {@link CompletedPropType }
     * 
     */
    public CompletedPropType createCompletedPropType() {
        return new CompletedPropType();
    }

    /**
     * Create an instance of {@link DtendPropType }
     * 
     */
    public DtendPropType createDtendPropType() {
        return new DtendPropType();
    }

    /**
     * Create an instance of {@link DtstartPropType }
     * 
     */
    public DtstartPropType createDtstartPropType() {
        return new DtstartPropType();
    }

    /**
     * Create an instance of {@link DuePropType }
     * 
     */
    public DuePropType createDuePropType() {
        return new DuePropType();
    }

    /**
     * Create an instance of {@link DurationPropType }
     * 
     */
    public DurationPropType createDurationPropType() {
        return new DurationPropType();
    }

    /**
     * Create an instance of {@link FreebusyPropType }
     * 
     */
    public FreebusyPropType createFreebusyPropType() {
        return new FreebusyPropType();
    }

    /**
     * Create an instance of {@link TranspPropType }
     * 
     */
    public TranspPropType createTranspPropType() {
        return new TranspPropType();
    }

    /**
     * Create an instance of {@link TznamePropType }
     * 
     */
    public TznamePropType createTznamePropType() {
        return new TznamePropType();
    }

    /**
     * Create an instance of {@link TzoffsetfromPropType }
     * 
     */
    public TzoffsetfromPropType createTzoffsetfromPropType() {
        return new TzoffsetfromPropType();
    }

    /**
     * Create an instance of {@link TzoffsettoPropType }
     * 
     */
    public TzoffsettoPropType createTzoffsettoPropType() {
        return new TzoffsettoPropType();
    }

    /**
     * Create an instance of {@link TzurlPropType }
     * 
     */
    public TzurlPropType createTzurlPropType() {
        return new TzurlPropType();
    }

    /**
     * Create an instance of {@link AttendeePropType }
     * 
     */
    public AttendeePropType createAttendeePropType() {
        return new AttendeePropType();
    }

    /**
     * Create an instance of {@link ContactPropType }
     * 
     */
    public ContactPropType createContactPropType() {
        return new ContactPropType();
    }

    /**
     * Create an instance of {@link OrganizerPropType }
     * 
     */
    public OrganizerPropType createOrganizerPropType() {
        return new OrganizerPropType();
    }

    /**
     * Create an instance of {@link RecurrenceIdPropType }
     * 
     */
    public RecurrenceIdPropType createRecurrenceIdPropType() {
        return new RecurrenceIdPropType();
    }

    /**
     * Create an instance of {@link UrlPropType }
     * 
     */
    public UrlPropType createUrlPropType() {
        return new UrlPropType();
    }

    /**
     * Create an instance of {@link UidPropType }
     * 
     */
    public UidPropType createUidPropType() {
        return new UidPropType();
    }

    /**
     * Create an instance of {@link ExdatePropType }
     * 
     */
    public ExdatePropType createExdatePropType() {
        return new ExdatePropType();
    }

    /**
     * Create an instance of {@link RdatePropType }
     * 
     */
    public RdatePropType createRdatePropType() {
        return new RdatePropType();
    }

    /**
     * Create an instance of {@link RelatedToPropType }
     * 
     */
    public RelatedToPropType createRelatedToPropType() {
        return new RelatedToPropType();
    }

    /**
     * Create an instance of {@link ExrulePropType }
     * 
     */
    public ExrulePropType createExrulePropType() {
        return new ExrulePropType();
    }

    /**
     * Create an instance of {@link RrulePropType }
     * 
     */
    public RrulePropType createRrulePropType() {
        return new RrulePropType();
    }

    /**
     * Create an instance of {@link ActionPropType }
     * 
     */
    public ActionPropType createActionPropType() {
        return new ActionPropType();
    }

    /**
     * Create an instance of {@link RepeatPropType }
     * 
     */
    public RepeatPropType createRepeatPropType() {
        return new RepeatPropType();
    }

    /**
     * Create an instance of {@link TriggerPropType }
     * 
     */
    public TriggerPropType createTriggerPropType() {
        return new TriggerPropType();
    }

    /**
     * Create an instance of {@link CreatedPropType }
     * 
     */
    public CreatedPropType createCreatedPropType() {
        return new CreatedPropType();
    }

    /**
     * Create an instance of {@link DtstampPropType }
     * 
     */
    public DtstampPropType createDtstampPropType() {
        return new DtstampPropType();
    }

    /**
     * Create an instance of {@link LastModifiedPropType }
     * 
     */
    public LastModifiedPropType createLastModifiedPropType() {
        return new LastModifiedPropType();
    }

    /**
     * Create an instance of {@link SequencePropType }
     * 
     */
    public SequencePropType createSequencePropType() {
        return new SequencePropType();
    }

    /**
     * Create an instance of {@link RequestStatusPropType }
     * 
     */
    public RequestStatusPropType createRequestStatusPropType() {
        return new RequestStatusPropType();
    }

    /**
     * Create an instance of {@link TextParameterType }
     * 
     */
    public TextParameterType createTextParameterType() {
        return new TextParameterType();
    }

    /**
     * Create an instance of {@link LinkPropType }
     * 
     */
    public LinkPropType createLinkPropType() {
        return new LinkPropType();
    }

    /**
     * Create an instance of {@link XBedeworkUidParamType }
     * 
     */
    public XBedeworkUidParamType createXBedeworkUidParamType() {
        return new XBedeworkUidParamType();
    }

    /**
     * Create an instance of {@link XBedeworkCostPropType }
     * 
     */
    public XBedeworkCostPropType createXBedeworkCostPropType() {
        return new XBedeworkCostPropType();
    }

    /**
     * Create an instance of {@link XBedeworkExsynchEndtzidPropType }
     * 
     */
    public XBedeworkExsynchEndtzidPropType createXBedeworkExsynchEndtzidPropType() {
        return new XBedeworkExsynchEndtzidPropType();
    }

    /**
     * Create an instance of {@link XBedeworkExsynchLastmodPropType }
     * 
     */
    public XBedeworkExsynchLastmodPropType createXBedeworkExsynchLastmodPropType() {
        return new XBedeworkExsynchLastmodPropType();
    }

    /**
     * Create an instance of {@link XBedeworkExsynchStarttzidPropType }
     * 
     */
    public XBedeworkExsynchStarttzidPropType createXBedeworkExsynchStarttzidPropType() {
        return new XBedeworkExsynchStarttzidPropType();
    }

    /**
     * Create an instance of {@link XMicrosoftCdoBusystatusPropType }
     * 
     */
    public XMicrosoftCdoBusystatusPropType createXMicrosoftCdoBusystatusPropType() {
        return new XMicrosoftCdoBusystatusPropType();
    }

    /**
     * Create an instance of {@link XMicrosoftCdoIntendedstatusPropType }
     * 
     */
    public XMicrosoftCdoIntendedstatusPropType createXMicrosoftCdoIntendedstatusPropType() {
        return new XMicrosoftCdoIntendedstatusPropType();
    }

    /**
     * Create an instance of {@link VavailabilityType }
     * 
     */
    public VavailabilityType createVavailabilityType() {
        return new VavailabilityType();
    }

    /**
     * Create an instance of {@link VcalendarContainedComponentType }
     * 
     */
    public VcalendarContainedComponentType createVcalendarContainedComponentType() {
        return new VcalendarContainedComponentType();
    }

    /**
     * Create an instance of {@link AvailableType }
     * 
     */
    public AvailableType createAvailableType() {
        return new AvailableType();
    }

    /**
     * Create an instance of {@link DurationParameterType }
     * 
     */
    public DurationParameterType createDurationParameterType() {
        return new DurationParameterType();
    }

    /**
     * Create an instance of {@link TolerancePropType }
     * 
     */
    public TolerancePropType createTolerancePropType() {
        return new TolerancePropType();
    }

    /**
     * Create an instance of {@link WsCalendarGluonType }
     * 
     */
    public WsCalendarGluonType createWsCalendarGluonType() {
        return new WsCalendarGluonType();
    }

    /**
     * Create an instance of {@link WsCalendarIntervalType }
     * 
     */
    public WsCalendarIntervalType createWsCalendarIntervalType() {
        return new WsCalendarIntervalType();
    }

    /**
     * Create an instance of {@link WsCalendarAttachType }
     * 
     */
    public WsCalendarAttachType createWsCalendarAttachType() {
        return new WsCalendarAttachType();
    }

    /**
     * Create an instance of {@link WsCalendarTypeType }
     * 
     */
    public WsCalendarTypeType createWsCalendarTypeType() {
        return new WsCalendarTypeType();
    }

    /**
     * Create an instance of {@link ArtifactType }
     * 
     */
    public ArtifactType createArtifactType() {
        return new ArtifactType();
    }

    /**
     * Create an instance of {@link VeventType }
     * 
     */
    public VeventType createVeventType() {
        return new VeventType();
    }

    /**
     * Create an instance of {@link VtodoType }
     * 
     */
    public VtodoType createVtodoType() {
        return new VtodoType();
    }

    /**
     * Create an instance of {@link VjournalType }
     * 
     */
    public VjournalType createVjournalType() {
        return new VjournalType();
    }

    /**
     * Create an instance of {@link VfreebusyType }
     * 
     */
    public VfreebusyType createVfreebusyType() {
        return new VfreebusyType();
    }

    /**
     * Create an instance of {@link VtimezoneType }
     * 
     */
    public VtimezoneType createVtimezoneType() {
        return new VtimezoneType();
    }

    /**
     * Create an instance of {@link StandardType }
     * 
     */
    public StandardType createStandardType() {
        return new StandardType();
    }

    /**
     * Create an instance of {@link DaylightType }
     * 
     */
    public DaylightType createDaylightType() {
        return new DaylightType();
    }

    /**
     * Create an instance of {@link ValarmType }
     * 
     */
    public ValarmType createValarmType() {
        return new ValarmType();
    }

    /**
     * Create an instance of {@link IcalendarType }
     * 
     */
    public IcalendarType createIcalendarType() {
        return new IcalendarType();
    }

    /**
     * Create an instance of {@link VcalendarType }
     * 
     */
    public VcalendarType createVcalendarType() {
        return new VcalendarType();
    }

    /**
     * Create an instance of {@link RecurType }
     * 
     */
    public RecurType createRecurType() {
        return new RecurType();
    }

    /**
     * Create an instance of {@link BooleanParameterType }
     * 
     */
    public BooleanParameterType createBooleanParameterType() {
        return new BooleanParameterType();
    }

    /**
     * Create an instance of {@link UriParameterType }
     * 
     */
    public UriParameterType createUriParameterType() {
        return new UriParameterType();
    }

    /**
     * Create an instance of {@link CalAddressListParamType }
     * 
     */
    public CalAddressListParamType createCalAddressListParamType() {
        return new CalAddressListParamType();
    }

    /**
     * Create an instance of {@link CalAddressParamType }
     * 
     */
    public CalAddressParamType createCalAddressParamType() {
        return new CalAddressParamType();
    }

    /**
     * Create an instance of {@link ArrayOfProperties }
     * 
     */
    public ArrayOfProperties createArrayOfProperties() {
        return new ArrayOfProperties();
    }

    /**
     * Create an instance of {@link TextPropertyType }
     * 
     */
    public TextPropertyType createTextPropertyType() {
        return new TextPropertyType();
    }

    /**
     * Create an instance of {@link TextListPropertyType }
     * 
     */
    public TextListPropertyType createTextListPropertyType() {
        return new TextListPropertyType();
    }

    /**
     * Create an instance of {@link CalAddressPropertyType }
     * 
     */
    public CalAddressPropertyType createCalAddressPropertyType() {
        return new CalAddressPropertyType();
    }

    /**
     * Create an instance of {@link IntegerPropertyType }
     * 
     */
    public IntegerPropertyType createIntegerPropertyType() {
        return new IntegerPropertyType();
    }

    /**
     * Create an instance of {@link UriPropertyType }
     * 
     */
    public UriPropertyType createUriPropertyType() {
        return new UriPropertyType();
    }

    /**
     * Create an instance of {@link UtcOffsetPropertyType }
     * 
     */
    public UtcOffsetPropertyType createUtcOffsetPropertyType() {
        return new UtcOffsetPropertyType();
    }

    /**
     * Create an instance of {@link DatetimePropertyType }
     * 
     */
    public DatetimePropertyType createDatetimePropertyType() {
        return new DatetimePropertyType();
    }

    /**
     * Create an instance of {@link UtcDatetimePropertyType }
     * 
     */
    public UtcDatetimePropertyType createUtcDatetimePropertyType() {
        return new UtcDatetimePropertyType();
    }

    /**
     * Create an instance of {@link DateDatetimePropertyType }
     * 
     */
    public DateDatetimePropertyType createDateDatetimePropertyType() {
        return new DateDatetimePropertyType();
    }

    /**
     * Create an instance of {@link RecurPropertyType }
     * 
     */
    public RecurPropertyType createRecurPropertyType() {
        return new RecurPropertyType();
    }

    /**
     * Create an instance of {@link TzidPropType }
     * 
     */
    public TzidPropType createTzidPropType() {
        return new TzidPropType();
    }

    /**
     * Create an instance of {@link BusytypePropType }
     * 
     */
    public BusytypePropType createBusytypePropType() {
        return new BusytypePropType();
    }

    /**
     * Create an instance of {@link ArrayOfVavailabilityContainedComponents }
     * 
     */
    public ArrayOfVavailabilityContainedComponents createArrayOfVavailabilityContainedComponents() {
        return new ArrayOfVavailabilityContainedComponents();
    }

    /**
     * Create an instance of {@link ToleranceValueType }
     * 
     */
    public ToleranceValueType createToleranceValueType() {
        return new ToleranceValueType();
    }

    /**
     * Create an instance of {@link ArrayOfGluonContainedComponents }
     * 
     */
    public ArrayOfGluonContainedComponents createArrayOfGluonContainedComponents() {
        return new ArrayOfGluonContainedComponents();
    }

    /**
     * Create an instance of {@link ArrayOfVcalendarContainedComponents }
     * 
     */
    public ArrayOfVcalendarContainedComponents createArrayOfVcalendarContainedComponents() {
        return new ArrayOfVcalendarContainedComponents();
    }

    /**
     * Create an instance of {@link EventTodoComponentType }
     * 
     */
    public EventTodoComponentType createEventTodoComponentType() {
        return new EventTodoComponentType();
    }

    /**
     * Create an instance of {@link ArrayOfEventTodoContainedComponents }
     * 
     */
    public ArrayOfEventTodoContainedComponents createArrayOfEventTodoContainedComponents() {
        return new ArrayOfEventTodoContainedComponents();
    }

    /**
     * Create an instance of {@link ArrayOfTimezoneContainedComponents }
     * 
     */
    public ArrayOfTimezoneContainedComponents createArrayOfTimezoneContainedComponents() {
        return new ArrayOfTimezoneContainedComponents();
    }

    /**
     * Create an instance of {@link AlarmComponentType }
     * 
     */
    public AlarmComponentType createAlarmComponentType() {
        return new AlarmComponentType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "binary")
    public JAXBElement<String> createBinary(String value) {
        return new JAXBElement<String>(_Binary_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "cal-address")
    public JAXBElement<String> createCalAddress(String value) {
        return new JAXBElement<String>(_CalAddress_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "date")
    public JAXBElement<XMLGregorianCalendar> createDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_Date_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "date-time")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "utc-date-time")
    public JAXBElement<XMLGregorianCalendar> createUtcDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_UtcDateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "integer")
    public JAXBElement<BigInteger> createInteger(BigInteger value) {
        return new JAXBElement<BigInteger>(_Integer_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PeriodType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PeriodType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "period")
    public JAXBElement<PeriodType> createPeriod(PeriodType value) {
        return new JAXBElement<PeriodType>(_Period_QNAME, PeriodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UntilRecurType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UntilRecurType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "until")
    public JAXBElement<UntilRecurType> createUntil(UntilRecurType value) {
        return new JAXBElement<UntilRecurType>(_Until_QNAME, UntilRecurType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "count")
    public JAXBElement<BigInteger> createCount(BigInteger value) {
        return new JAXBElement<BigInteger>(_Count_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "text")
    public JAXBElement<String> createText(String value) {
        return new JAXBElement<String>(_Text_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "time")
    public JAXBElement<String> createTime(String value) {
        return new JAXBElement<String>(_Time_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "uri")
    public JAXBElement<String> createUri(String value) {
        return new JAXBElement<String>(_Uri_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "utc-offset")
    public JAXBElement<String> createUtcOffset(String value) {
        return new JAXBElement<String>(_UtcOffset_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BaseParameterType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BaseParameterType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "baseParameter")
    public JAXBElement<BaseParameterType> createBaseParameter(BaseParameterType value) {
        return new JAXBElement<BaseParameterType>(_BaseParameter_QNAME, BaseParameterType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltrepParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AltrepParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "altrep", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<AltrepParamType> createAltrep(AltrepParamType value) {
        return new JAXBElement<AltrepParamType>(_Altrep_QNAME, AltrepParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CnParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CnParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "cn", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<CnParamType> createCn(CnParamType value) {
        return new JAXBElement<CnParamType>(_Cn_QNAME, CnParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CutypeParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CutypeParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "cutype", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<CutypeParamType> createCutype(CutypeParamType value) {
        return new JAXBElement<CutypeParamType>(_Cutype_QNAME, CutypeParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DelegatedFromParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DelegatedFromParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "delegated-from", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<DelegatedFromParamType> createDelegatedFrom(DelegatedFromParamType value) {
        return new JAXBElement<DelegatedFromParamType>(_DelegatedFrom_QNAME, DelegatedFromParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DelegatedToParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DelegatedToParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "delegated-to", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<DelegatedToParamType> createDelegatedTo(DelegatedToParamType value) {
        return new JAXBElement<DelegatedToParamType>(_DelegatedTo_QNAME, DelegatedToParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DirParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "dir", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<DirParamType> createDir(DirParamType value) {
        return new JAXBElement<DirParamType>(_Dir_QNAME, DirParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EncodingParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EncodingParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "encoding", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<EncodingParamType> createEncoding(EncodingParamType value) {
        return new JAXBElement<EncodingParamType>(_Encoding_QNAME, EncodingParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FmttypeParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FmttypeParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "fmttype", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<FmttypeParamType> createFmttype(FmttypeParamType value) {
        return new JAXBElement<FmttypeParamType>(_Fmttype_QNAME, FmttypeParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FbtypeParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FbtypeParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "fbtype", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<FbtypeParamType> createFbtype(FbtypeParamType value) {
        return new JAXBElement<FbtypeParamType>(_Fbtype_QNAME, FbtypeParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LanguageParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LanguageParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "language", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<LanguageParamType> createLanguage(LanguageParamType value) {
        return new JAXBElement<LanguageParamType>(_Language_QNAME, LanguageParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MemberParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MemberParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "member", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<MemberParamType> createMember(MemberParamType value) {
        return new JAXBElement<MemberParamType>(_Member_QNAME, MemberParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartstatParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PartstatParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "partstat", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<PartstatParamType> createPartstat(PartstatParamType value) {
        return new JAXBElement<PartstatParamType>(_Partstat_QNAME, PartstatParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RangeParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RangeParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "range", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<RangeParamType> createRange(RangeParamType value) {
        return new JAXBElement<RangeParamType>(_Range_QNAME, RangeParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelatedParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RelatedParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "related", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<RelatedParamType> createRelated(RelatedParamType value) {
        return new JAXBElement<RelatedParamType>(_Related_QNAME, RelatedParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReltypeParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReltypeParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "reltype", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<ReltypeParamType> createReltype(ReltypeParamType value) {
        return new JAXBElement<ReltypeParamType>(_Reltype_QNAME, ReltypeParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RoleParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RoleParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "role", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<RoleParamType> createRole(RoleParamType value) {
        return new JAXBElement<RoleParamType>(_Role_QNAME, RoleParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RsvpParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RsvpParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "rsvp", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<RsvpParamType> createRsvp(RsvpParamType value) {
        return new JAXBElement<RsvpParamType>(_Rsvp_QNAME, RsvpParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SentByParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SentByParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "sent-by", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<SentByParamType> createSentBy(SentByParamType value) {
        return new JAXBElement<SentByParamType>(_SentBy_QNAME, SentByParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TzidParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TzidParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "tzid", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<TzidParamType> createTzid(TzidParamType value) {
        return new JAXBElement<TzidParamType>(_Tzid_QNAME, TzidParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScheduleAgentParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ScheduleAgentParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "schedule-agent", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<ScheduleAgentParamType> createScheduleAgent(ScheduleAgentParamType value) {
        return new JAXBElement<ScheduleAgentParamType>(_ScheduleAgent_QNAME, ScheduleAgentParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScheduleForceSendParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ScheduleForceSendParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "schedule-force-send", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<ScheduleForceSendParamType> createScheduleForceSend(ScheduleForceSendParamType value) {
        return new JAXBElement<ScheduleForceSendParamType>(_ScheduleForceSend_QNAME, ScheduleForceSendParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScheduleStatusParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ScheduleStatusParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "schedule-status", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<ScheduleStatusParamType> createScheduleStatus(ScheduleStatusParamType value) {
        return new JAXBElement<ScheduleStatusParamType>(_ScheduleStatus_QNAME, ScheduleStatusParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfParameters }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfParameters }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "parameters")
    public JAXBElement<ArrayOfParameters> createParameters(ArrayOfParameters value) {
        return new JAXBElement<ArrayOfParameters>(_Parameters_QNAME, ArrayOfParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BasePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BasePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "baseProperty")
    public JAXBElement<BasePropertyType> createBaseProperty(BasePropertyType value) {
        return new JAXBElement<BasePropertyType>(_BaseProperty_QNAME, BasePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalscalePropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CalscalePropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "calscale", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<CalscalePropType> createCalscale(CalscalePropType value) {
        return new JAXBElement<CalscalePropType>(_Calscale_QNAME, CalscalePropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MethodPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MethodPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "method", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<MethodPropType> createMethod(MethodPropType value) {
        return new JAXBElement<MethodPropType>(_Method_QNAME, MethodPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProdidPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProdidPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "prodid", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<ProdidPropType> createProdid(ProdidPropType value) {
        return new JAXBElement<ProdidPropType>(_Prodid_QNAME, ProdidPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VersionPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VersionPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "version", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<VersionPropType> createVersion(VersionPropType value) {
        return new JAXBElement<VersionPropType>(_Version_QNAME, VersionPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttachPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AttachPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "attach", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<AttachPropType> createAttach(AttachPropType value) {
        return new JAXBElement<AttachPropType>(_Attach_QNAME, AttachPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoriesPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CategoriesPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "categories", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<CategoriesPropType> createCategories(CategoriesPropType value) {
        return new JAXBElement<CategoriesPropType>(_Categories_QNAME, CategoriesPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClassPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClassPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "class", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<ClassPropType> createClass(ClassPropType value) {
        return new JAXBElement<ClassPropType>(_Class_QNAME, ClassPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommentPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CommentPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "comment", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<CommentPropType> createComment(CommentPropType value) {
        return new JAXBElement<CommentPropType>(_Comment_QNAME, CommentPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DescriptionPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DescriptionPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "description", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<DescriptionPropType> createDescription(DescriptionPropType value) {
        return new JAXBElement<DescriptionPropType>(_Description_QNAME, DescriptionPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeoPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeoPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "geo", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<GeoPropType> createGeo(GeoPropType value) {
        return new JAXBElement<GeoPropType>(_Geo_QNAME, GeoPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LocationPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "location", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<LocationPropType> createLocation(LocationPropType value) {
        return new JAXBElement<LocationPropType>(_Location_QNAME, LocationPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PercentCompletePropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PercentCompletePropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "percent-complete", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<PercentCompletePropType> createPercentComplete(PercentCompletePropType value) {
        return new JAXBElement<PercentCompletePropType>(_PercentComplete_QNAME, PercentCompletePropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PriorityPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PriorityPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "priority", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<PriorityPropType> createPriority(PriorityPropType value) {
        return new JAXBElement<PriorityPropType>(_Priority_QNAME, PriorityPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResourcesPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResourcesPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "resources", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<ResourcesPropType> createResources(ResourcesPropType value) {
        return new JAXBElement<ResourcesPropType>(_Resources_QNAME, ResourcesPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatusPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "status", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<StatusPropType> createStatus(StatusPropType value) {
        return new JAXBElement<StatusPropType>(_Status_QNAME, StatusPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SummaryPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SummaryPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "summary", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<SummaryPropType> createSummary(SummaryPropType value) {
        return new JAXBElement<SummaryPropType>(_Summary_QNAME, SummaryPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompletedPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CompletedPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "completed", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<CompletedPropType> createCompleted(CompletedPropType value) {
        return new JAXBElement<CompletedPropType>(_Completed_QNAME, CompletedPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DtendPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DtendPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "dtend", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<DtendPropType> createDtend(DtendPropType value) {
        return new JAXBElement<DtendPropType>(_Dtend_QNAME, DtendPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DtstartPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DtstartPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "dtstart", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<DtstartPropType> createDtstart(DtstartPropType value) {
        return new JAXBElement<DtstartPropType>(_Dtstart_QNAME, DtstartPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DuePropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DuePropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "due", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<DuePropType> createDue(DuePropType value) {
        return new JAXBElement<DuePropType>(_Due_QNAME, DuePropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DurationPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DurationPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "duration", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<DurationPropType> createDuration(DurationPropType value) {
        return new JAXBElement<DurationPropType>(_Duration_QNAME, DurationPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FreebusyPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FreebusyPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "freebusy", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<FreebusyPropType> createFreebusy(FreebusyPropType value) {
        return new JAXBElement<FreebusyPropType>(_Freebusy_QNAME, FreebusyPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TranspPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TranspPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "transp", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<TranspPropType> createTransp(TranspPropType value) {
        return new JAXBElement<TranspPropType>(_Transp_QNAME, TranspPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TznamePropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TznamePropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "tzname", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<TznamePropType> createTzname(TznamePropType value) {
        return new JAXBElement<TznamePropType>(_Tzname_QNAME, TznamePropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TzoffsetfromPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TzoffsetfromPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "tzoffsetfrom", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<TzoffsetfromPropType> createTzoffsetfrom(TzoffsetfromPropType value) {
        return new JAXBElement<TzoffsetfromPropType>(_Tzoffsetfrom_QNAME, TzoffsetfromPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TzoffsettoPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TzoffsettoPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "tzoffsetto", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<TzoffsettoPropType> createTzoffsetto(TzoffsettoPropType value) {
        return new JAXBElement<TzoffsettoPropType>(_Tzoffsetto_QNAME, TzoffsettoPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TzurlPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TzurlPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "tzurl", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<TzurlPropType> createTzurl(TzurlPropType value) {
        return new JAXBElement<TzurlPropType>(_Tzurl_QNAME, TzurlPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttendeePropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AttendeePropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "attendee", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<AttendeePropType> createAttendee(AttendeePropType value) {
        return new JAXBElement<AttendeePropType>(_Attendee_QNAME, AttendeePropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContactPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ContactPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "contact", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<ContactPropType> createContact(ContactPropType value) {
        return new JAXBElement<ContactPropType>(_Contact_QNAME, ContactPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizerPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizerPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "organizer", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<OrganizerPropType> createOrganizer(OrganizerPropType value) {
        return new JAXBElement<OrganizerPropType>(_Organizer_QNAME, OrganizerPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecurrenceIdPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RecurrenceIdPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "recurrence-id", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<RecurrenceIdPropType> createRecurrenceId(RecurrenceIdPropType value) {
        return new JAXBElement<RecurrenceIdPropType>(_RecurrenceId_QNAME, RecurrenceIdPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UrlPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UrlPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "url", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<UrlPropType> createUrl(UrlPropType value) {
        return new JAXBElement<UrlPropType>(_Url_QNAME, UrlPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UidPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UidPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "uid", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<UidPropType> createUid(UidPropType value) {
        return new JAXBElement<UidPropType>(_Uid_QNAME, UidPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExdatePropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExdatePropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "exdate", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<ExdatePropType> createExdate(ExdatePropType value) {
        return new JAXBElement<ExdatePropType>(_Exdate_QNAME, ExdatePropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RdatePropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RdatePropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "rdate", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<RdatePropType> createRdate(RdatePropType value) {
        return new JAXBElement<RdatePropType>(_Rdate_QNAME, RdatePropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelatedToPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RelatedToPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "related-to", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<RelatedToPropType> createRelatedTo(RelatedToPropType value) {
        return new JAXBElement<RelatedToPropType>(_RelatedTo_QNAME, RelatedToPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExrulePropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExrulePropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "exrule", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<ExrulePropType> createExrule(ExrulePropType value) {
        return new JAXBElement<ExrulePropType>(_Exrule_QNAME, ExrulePropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RrulePropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RrulePropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "rrule", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<RrulePropType> createRrule(RrulePropType value) {
        return new JAXBElement<RrulePropType>(_Rrule_QNAME, RrulePropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActionPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ActionPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "action", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<ActionPropType> createAction(ActionPropType value) {
        return new JAXBElement<ActionPropType>(_Action_QNAME, ActionPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RepeatPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RepeatPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "repeat", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<RepeatPropType> createRepeat(RepeatPropType value) {
        return new JAXBElement<RepeatPropType>(_Repeat_QNAME, RepeatPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TriggerPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TriggerPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "trigger", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<TriggerPropType> createTrigger(TriggerPropType value) {
        return new JAXBElement<TriggerPropType>(_Trigger_QNAME, TriggerPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatedPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreatedPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "created", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<CreatedPropType> createCreated(CreatedPropType value) {
        return new JAXBElement<CreatedPropType>(_Created_QNAME, CreatedPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DtstampPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DtstampPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "dtstamp", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<DtstampPropType> createDtstamp(DtstampPropType value) {
        return new JAXBElement<DtstampPropType>(_Dtstamp_QNAME, DtstampPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LastModifiedPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LastModifiedPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "last-modified", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<LastModifiedPropType> createLastModified(LastModifiedPropType value) {
        return new JAXBElement<LastModifiedPropType>(_LastModified_QNAME, LastModifiedPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SequencePropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SequencePropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "sequence", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<SequencePropType> createSequence(SequencePropType value) {
        return new JAXBElement<SequencePropType>(_Sequence_QNAME, SequencePropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestStatusPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RequestStatusPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "request-status", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<RequestStatusPropType> createRequestStatus(RequestStatusPropType value) {
        return new JAXBElement<RequestStatusPropType>(_RequestStatus_QNAME, RequestStatusPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "latitude")
    public JAXBElement<Float> createLatitude(Float value) {
        return new JAXBElement<Float>(_Latitude_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "longitude")
    public JAXBElement<Float> createLongitude(Float value) {
        return new JAXBElement<Float>(_Longitude_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextParameterType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextParameterType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "rel", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<TextParameterType> createRel(TextParameterType value) {
        return new JAXBElement<TextParameterType>(_Rel_QNAME, TextParameterType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinkPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LinkPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "link", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<LinkPropType> createLink(LinkPropType value) {
        return new JAXBElement<LinkPropType>(_Link_QNAME, LinkPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XBedeworkUidParamType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XBedeworkUidParamType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-uid", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<XBedeworkUidParamType> createXBedeworkUid(XBedeworkUidParamType value) {
        return new JAXBElement<XBedeworkUidParamType>(_XBedeworkUid_QNAME, XBedeworkUidParamType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XBedeworkCostPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XBedeworkCostPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-cost", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<XBedeworkCostPropType> createXBedeworkCost(XBedeworkCostPropType value) {
        return new JAXBElement<XBedeworkCostPropType>(_XBedeworkCost_QNAME, XBedeworkCostPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XBedeworkExsynchEndtzidPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XBedeworkExsynchEndtzidPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-exsynch-endtzid", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<XBedeworkExsynchEndtzidPropType> createXBedeworkExsynchEndtzid(XBedeworkExsynchEndtzidPropType value) {
        return new JAXBElement<XBedeworkExsynchEndtzidPropType>(_XBedeworkExsynchEndtzid_QNAME, XBedeworkExsynchEndtzidPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XBedeworkExsynchLastmodPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XBedeworkExsynchLastmodPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-exsynch-lastmod", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<XBedeworkExsynchLastmodPropType> createXBedeworkExsynchLastmod(XBedeworkExsynchLastmodPropType value) {
        return new JAXBElement<XBedeworkExsynchLastmodPropType>(_XBedeworkExsynchLastmod_QNAME, XBedeworkExsynchLastmodPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizerPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizerPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-exsynch-organizer", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<OrganizerPropType> createXBedeworkExsynchOrganizer(OrganizerPropType value) {
        return new JAXBElement<OrganizerPropType>(_XBedeworkExsynchOrganizer_QNAME, OrganizerPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XBedeworkExsynchStarttzidPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XBedeworkExsynchStarttzidPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-bedework-exsynch-starttzid", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<XBedeworkExsynchStarttzidPropType> createXBedeworkExsynchStarttzid(XBedeworkExsynchStarttzidPropType value) {
        return new JAXBElement<XBedeworkExsynchStarttzidPropType>(_XBedeworkExsynchStarttzid_QNAME, XBedeworkExsynchStarttzidPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMicrosoftCdoBusystatusPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMicrosoftCdoBusystatusPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-microsoft-cdo-busystatus", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<XMicrosoftCdoBusystatusPropType> createXMicrosoftCdoBusystatus(XMicrosoftCdoBusystatusPropType value) {
        return new JAXBElement<XMicrosoftCdoBusystatusPropType>(_XMicrosoftCdoBusystatus_QNAME, XMicrosoftCdoBusystatusPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMicrosoftCdoIntendedstatusPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMicrosoftCdoIntendedstatusPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-microsoft-cdo-intendedstatus", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<XMicrosoftCdoIntendedstatusPropType> createXMicrosoftCdoIntendedstatus(XMicrosoftCdoIntendedstatusPropType value) {
        return new JAXBElement<XMicrosoftCdoIntendedstatusPropType>(_XMicrosoftCdoIntendedstatus_QNAME, XMicrosoftCdoIntendedstatusPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VavailabilityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VavailabilityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "vavailability", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "vcalendarContainedComponent")
    public JAXBElement<VavailabilityType> createVavailability(VavailabilityType value) {
        return new JAXBElement<VavailabilityType>(_Vavailability_QNAME, VavailabilityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VcalendarContainedComponentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VcalendarContainedComponentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "vcalendarContainedComponent")
    public JAXBElement<VcalendarContainedComponentType> createVcalendarContainedComponent(VcalendarContainedComponentType value) {
        return new JAXBElement<VcalendarContainedComponentType>(_VcalendarContainedComponent_QNAME, VcalendarContainedComponentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AvailableType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AvailableType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "available", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseComponent")
    public JAXBElement<AvailableType> createAvailable(AvailableType value) {
        return new JAXBElement<AvailableType>(_Available_QNAME, AvailableType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BaseComponentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BaseComponentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "baseComponent")
    public JAXBElement<BaseComponentType> createBaseComponent(BaseComponentType value) {
        return new JAXBElement<BaseComponentType>(_BaseComponent_QNAME, BaseComponentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DurationParameterType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DurationParameterType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "gap", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseParameter")
    public JAXBElement<DurationParameterType> createGap(DurationParameterType value) {
        return new JAXBElement<DurationParameterType>(_Gap_QNAME, DurationParameterType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DurationPropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DurationPropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "granularity", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<DurationPropType> createGranularity(DurationPropType value) {
        return new JAXBElement<DurationPropType>(_Granularity_QNAME, DurationPropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TolerancePropType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TolerancePropType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "tolerance", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<TolerancePropType> createTolerance(TolerancePropType value) {
        return new JAXBElement<TolerancePropType>(_Tolerance_QNAME, TolerancePropType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WsCalendarGluonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WsCalendarGluonType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "gluon", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "vcalendarContainedComponent")
    public JAXBElement<WsCalendarGluonType> createGluon(WsCalendarGluonType value) {
        return new JAXBElement<WsCalendarGluonType>(_Gluon_QNAME, WsCalendarGluonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WsCalendarIntervalType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WsCalendarIntervalType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "interval", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "vcalendarContainedComponent")
    public JAXBElement<WsCalendarIntervalType> createInterval(WsCalendarIntervalType value) {
        return new JAXBElement<WsCalendarIntervalType>(_Interval_QNAME, WsCalendarIntervalType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WsCalendarAttachType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WsCalendarAttachType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-wsCalendar-attach", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<WsCalendarAttachType> createXWsCalendarAttach(WsCalendarAttachType value) {
        return new JAXBElement<WsCalendarAttachType>(_XWsCalendarAttach_QNAME, WsCalendarAttachType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WsCalendarTypeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WsCalendarTypeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "x-wscalendar-type", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseProperty")
    public JAXBElement<WsCalendarTypeType> createXWscalendarType(WsCalendarTypeType value) {
        return new JAXBElement<WsCalendarTypeType>(_XWscalendarType_QNAME, WsCalendarTypeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArtifactType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArtifactType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "artifact")
    public JAXBElement<ArtifactType> createArtifact(ArtifactType value) {
        return new JAXBElement<ArtifactType>(_Artifact_QNAME, ArtifactType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArtifactBaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArtifactBaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "artifactBase")
    public JAXBElement<ArtifactBaseType> createArtifactBase(ArtifactBaseType value) {
        return new JAXBElement<ArtifactBaseType>(_ArtifactBase_QNAME, ArtifactBaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VeventType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VeventType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "vevent", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "vcalendarContainedComponent")
    public JAXBElement<VeventType> createVevent(VeventType value) {
        return new JAXBElement<VeventType>(_Vevent_QNAME, VeventType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VtodoType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VtodoType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "vtodo", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "vcalendarContainedComponent")
    public JAXBElement<VtodoType> createVtodo(VtodoType value) {
        return new JAXBElement<VtodoType>(_Vtodo_QNAME, VtodoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VjournalType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VjournalType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "vjournal", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "vcalendarContainedComponent")
    public JAXBElement<VjournalType> createVjournal(VjournalType value) {
        return new JAXBElement<VjournalType>(_Vjournal_QNAME, VjournalType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VfreebusyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VfreebusyType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "vfreebusy", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "vcalendarContainedComponent")
    public JAXBElement<VfreebusyType> createVfreebusy(VfreebusyType value) {
        return new JAXBElement<VfreebusyType>(_Vfreebusy_QNAME, VfreebusyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VtimezoneType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VtimezoneType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "vtimezone", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "vcalendarContainedComponent")
    public JAXBElement<VtimezoneType> createVtimezone(VtimezoneType value) {
        return new JAXBElement<VtimezoneType>(_Vtimezone_QNAME, VtimezoneType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StandardType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StandardType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "standard", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseComponent")
    public JAXBElement<StandardType> createStandard(StandardType value) {
        return new JAXBElement<StandardType>(_Standard_QNAME, StandardType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DaylightType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DaylightType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "daylight", substitutionHeadNamespace = "urn:ietf:params:xml:ns:icalendar-2.0", substitutionHeadName = "baseComponent")
    public JAXBElement<DaylightType> createDaylight(DaylightType value) {
        return new JAXBElement<DaylightType>(_Daylight_QNAME, DaylightType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValarmType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValarmType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "valarm")
    public JAXBElement<ValarmType> createValarm(ValarmType value) {
        return new JAXBElement<ValarmType>(_Valarm_QNAME, ValarmType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IcalendarType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IcalendarType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "icalendar")
    public JAXBElement<IcalendarType> createIcalendar(IcalendarType value) {
        return new JAXBElement<IcalendarType>(_Icalendar_QNAME, IcalendarType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VcalendarType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VcalendarType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:icalendar-2.0", name = "vcalendar")
    public JAXBElement<VcalendarType> createVcalendar(VcalendarType value) {
        return new JAXBElement<VcalendarType>(_Vcalendar_QNAME, VcalendarType.class, null, value);
    }

}
