
package gov.niem.niem.fbi._2;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LISCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="LISCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="VB"/&gt;
 *     &lt;enumeration value="WB"/&gt;
 *     &lt;enumeration value="LH"/&gt;
 *     &lt;enumeration value="BF"/&gt;
 *     &lt;enumeration value="DW"/&gt;
 *     &lt;enumeration value="MR"/&gt;
 *     &lt;enumeration value="NX"/&gt;
 *     &lt;enumeration value="GM"/&gt;
 *     &lt;enumeration value="LY"/&gt;
 *     &lt;enumeration value="GT"/&gt;
 *     &lt;enumeration value="UK"/&gt;
 *     &lt;enumeration value="CA"/&gt;
 *     &lt;enumeration value="TJ"/&gt;
 *     &lt;enumeration value="NZ"/&gt;
 *     &lt;enumeration value="LO"/&gt;
 *     &lt;enumeration value="FG"/&gt;
 *     &lt;enumeration value="SB"/&gt;
 *     &lt;enumeration value="HO"/&gt;
 *     &lt;enumeration value="IR"/&gt;
 *     &lt;enumeration value="BV"/&gt;
 *     &lt;enumeration value="NC"/&gt;
 *     &lt;enumeration value="ZB"/&gt;
 *     &lt;enumeration value="WI"/&gt;
 *     &lt;enumeration value="KI"/&gt;
 *     &lt;enumeration value="FR"/&gt;
 *     &lt;enumeration value="IO"/&gt;
 *     &lt;enumeration value="SO"/&gt;
 *     &lt;enumeration value="MW"/&gt;
 *     &lt;enumeration value="AK"/&gt;
 *     &lt;enumeration value="NK"/&gt;
 *     &lt;enumeration value="UM"/&gt;
 *     &lt;enumeration value="MK"/&gt;
 *     &lt;enumeration value="AP"/&gt;
 *     &lt;enumeration value="MD"/&gt;
 *     &lt;enumeration value="OC"/&gt;
 *     &lt;enumeration value="SF"/&gt;
 *     &lt;enumeration value="PE"/&gt;
 *     &lt;enumeration value="GY"/&gt;
 *     &lt;enumeration value="LB"/&gt;
 *     &lt;enumeration value="YO"/&gt;
 *     &lt;enumeration value="UG"/&gt;
 *     &lt;enumeration value="CQ"/&gt;
 *     &lt;enumeration value="HK"/&gt;
 *     &lt;enumeration value="QU"/&gt;
 *     &lt;enumeration value="DC"/&gt;
 *     &lt;enumeration value="KH"/&gt;
 *     &lt;enumeration value="IE"/&gt;
 *     &lt;enumeration value="JA"/&gt;
 *     &lt;enumeration value="SE"/&gt;
 *     &lt;enumeration value="CV"/&gt;
 *     &lt;enumeration value="LX"/&gt;
 *     &lt;enumeration value="RB"/&gt;
 *     &lt;enumeration value="CR"/&gt;
 *     &lt;enumeration value="II"/&gt;
 *     &lt;enumeration value="FJ"/&gt;
 *     &lt;enumeration value="TG"/&gt;
 *     &lt;enumeration value="SV"/&gt;
 *     &lt;enumeration value="TA"/&gt;
 *     &lt;enumeration value="TV"/&gt;
 *     &lt;enumeration value="HS"/&gt;
 *     &lt;enumeration value="PF"/&gt;
 *     &lt;enumeration value="BX"/&gt;
 *     &lt;enumeration value="TU"/&gt;
 *     &lt;enumeration value="NU"/&gt;
 *     &lt;enumeration value="DL"/&gt;
 *     &lt;enumeration value="SD"/&gt;
 *     &lt;enumeration value="LI"/&gt;
 *     &lt;enumeration value="IU"/&gt;
 *     &lt;enumeration value="GB"/&gt;
 *     &lt;enumeration value="RA"/&gt;
 *     &lt;enumeration value="NI"/&gt;
 *     &lt;enumeration value="DR"/&gt;
 *     &lt;enumeration value="NO"/&gt;
 *     &lt;enumeration value="AR"/&gt;
 *     &lt;enumeration value="LF"/&gt;
 *     &lt;enumeration value="DA"/&gt;
 *     &lt;enumeration value="DJ"/&gt;
 *     &lt;enumeration value="QA"/&gt;
 *     &lt;enumeration value="VV"/&gt;
 *     &lt;enumeration value="IS"/&gt;
 *     &lt;enumeration value="EK"/&gt;
 *     &lt;enumeration value="SQ"/&gt;
 *     &lt;enumeration value="CH"/&gt;
 *     &lt;enumeration value="PI"/&gt;
 *     &lt;enumeration value="JO"/&gt;
 *     &lt;enumeration value="GK"/&gt;
 *     &lt;enumeration value="WD"/&gt;
 *     &lt;enumeration value="HU"/&gt;
 *     &lt;enumeration value="SK"/&gt;
 *     &lt;enumeration value="PA"/&gt;
 *     &lt;enumeration value="MV"/&gt;
 *     &lt;enumeration value="VI"/&gt;
 *     &lt;enumeration value="SP"/&gt;
 *     &lt;enumeration value="KE"/&gt;
 *     &lt;enumeration value="UT"/&gt;
 *     &lt;enumeration value="TM"/&gt;
 *     &lt;enumeration value="NA"/&gt;
 *     &lt;enumeration value="RH"/&gt;
 *     &lt;enumeration value="CS"/&gt;
 *     &lt;enumeration value="BG"/&gt;
 *     &lt;enumeration value="NV"/&gt;
 *     &lt;enumeration value="PW"/&gt;
 *     &lt;enumeration value="AB"/&gt;
 *     &lt;enumeration value="TO"/&gt;
 *     &lt;enumeration value="MC"/&gt;
 *     &lt;enumeration value="MP"/&gt;
 *     &lt;enumeration value="NP"/&gt;
 *     &lt;enumeration value="RV"/&gt;
 *     &lt;enumeration value="ER"/&gt;
 *     &lt;enumeration value="EZ"/&gt;
 *     &lt;enumeration value="MX"/&gt;
 *     &lt;enumeration value="ON"/&gt;
 *     &lt;enumeration value="OI"/&gt;
 *     &lt;enumeration value="DB"/&gt;
 *     &lt;enumeration value="AX"/&gt;
 *     &lt;enumeration value="ET"/&gt;
 *     &lt;enumeration value="CG"/&gt;
 *     &lt;enumeration value="TW"/&gt;
 *     &lt;enumeration value="BK"/&gt;
 *     &lt;enumeration value="PB"/&gt;
 *     &lt;enumeration value="LL"/&gt;
 *     &lt;enumeration value="CB"/&gt;
 *     &lt;enumeration value="ID"/&gt;
 *     &lt;enumeration value="PL"/&gt;
 *     &lt;enumeration value="SI"/&gt;
 *     &lt;enumeration value="PD"/&gt;
 *     &lt;enumeration value="WV"/&gt;
 *     &lt;enumeration value="DH"/&gt;
 *     &lt;enumeration value="AJ"/&gt;
 *     &lt;enumeration value="IQ"/&gt;
 *     &lt;enumeration value="FP"/&gt;
 *     &lt;enumeration value="WS"/&gt;
 *     &lt;enumeration value="DN"/&gt;
 *     &lt;enumeration value="NQ"/&gt;
 *     &lt;enumeration value="LA"/&gt;
 *     &lt;enumeration value="MJ"/&gt;
 *     &lt;enumeration value="NH"/&gt;
 *     &lt;enumeration value="QR"/&gt;
 *     &lt;enumeration value="SY"/&gt;
 *     &lt;enumeration value="FX"/&gt;
 *     &lt;enumeration value="IA"/&gt;
 *     &lt;enumeration value="CW"/&gt;
 *     &lt;enumeration value="BR"/&gt;
 *     &lt;enumeration value="GI"/&gt;
 *     &lt;enumeration value="PC"/&gt;
 *     &lt;enumeration value="TS"/&gt;
 *     &lt;enumeration value="NW"/&gt;
 *     &lt;enumeration value="KU"/&gt;
 *     &lt;enumeration value="TC"/&gt;
 *     &lt;enumeration value="EY"/&gt;
 *     &lt;enumeration value="JE"/&gt;
 *     &lt;enumeration value="BE"/&gt;
 *     &lt;enumeration value="RE"/&gt;
 *     &lt;enumeration value="DM"/&gt;
 *     &lt;enumeration value="ME"/&gt;
 *     &lt;enumeration value="ND"/&gt;
 *     &lt;enumeration value="YT"/&gt;
 *     &lt;enumeration value="KB"/&gt;
 *     &lt;enumeration value="HD"/&gt;
 *     &lt;enumeration value="SJ"/&gt;
 *     &lt;enumeration value="OO"/&gt;
 *     &lt;enumeration value="PN"/&gt;
 *     &lt;enumeration value="RI"/&gt;
 *     &lt;enumeration value="CY"/&gt;
 *     &lt;enumeration value="BT"/&gt;
 *     &lt;enumeration value="MH"/&gt;
 *     &lt;enumeration value="DS"/&gt;
 *     &lt;enumeration value="PO"/&gt;
 *     &lt;enumeration value="RG"/&gt;
 *     &lt;enumeration value="UV"/&gt;
 *     &lt;enumeration value="KW"/&gt;
 *     &lt;enumeration value="OG"/&gt;
 *     &lt;enumeration value="TN"/&gt;
 *     &lt;enumeration value="GN"/&gt;
 *     &lt;enumeration value="FA"/&gt;
 *     &lt;enumeration value="KN"/&gt;
 *     &lt;enumeration value="RL"/&gt;
 *     &lt;enumeration value="GF"/&gt;
 *     &lt;enumeration value="SH"/&gt;
 *     &lt;enumeration value="EN"/&gt;
 *     &lt;enumeration value="AT"/&gt;
 *     &lt;enumeration value="MY"/&gt;
 *     &lt;enumeration value="NY"/&gt;
 *     &lt;enumeration value="KC"/&gt;
 *     &lt;enumeration value="CP"/&gt;
 *     &lt;enumeration value="EE"/&gt;
 *     &lt;enumeration value="OR"/&gt;
 *     &lt;enumeration value="SC"/&gt;
 *     &lt;enumeration value="JN"/&gt;
 *     &lt;enumeration value="SW"/&gt;
 *     &lt;enumeration value="NM"/&gt;
 *     &lt;enumeration value="KY"/&gt;
 *     &lt;enumeration value="DI"/&gt;
 *     &lt;enumeration value="BS"/&gt;
 *     &lt;enumeration value="BA"/&gt;
 *     &lt;enumeration value="VT"/&gt;
 *     &lt;enumeration value="BD"/&gt;
 *     &lt;enumeration value="PM"/&gt;
 *     &lt;enumeration value="CM"/&gt;
 *     &lt;enumeration value="BM"/&gt;
 *     &lt;enumeration value="PT"/&gt;
 *     &lt;enumeration value="CF"/&gt;
 *     &lt;enumeration value="IC"/&gt;
 *     &lt;enumeration value="CO"/&gt;
 *     &lt;enumeration value="VL"/&gt;
 *     &lt;enumeration value="CC"/&gt;
 *     &lt;enumeration value="FS"/&gt;
 *     &lt;enumeration value="RW"/&gt;
 *     &lt;enumeration value="SL"/&gt;
 *     &lt;enumeration value="TP"/&gt;
 *     &lt;enumeration value="BN"/&gt;
 *     &lt;enumeration value="ZR"/&gt;
 *     &lt;enumeration value="ZD"/&gt;
 *     &lt;enumeration value="DG"/&gt;
 *     &lt;enumeration value="MQ"/&gt;
 *     &lt;enumeration value="NG"/&gt;
 *     &lt;enumeration value="SG"/&gt;
 *     &lt;enumeration value="GP"/&gt;
 *     &lt;enumeration value="KP"/&gt;
 *     &lt;enumeration value="GD"/&gt;
 *     &lt;enumeration value="EO"/&gt;
 *     &lt;enumeration value="PK"/&gt;
 *     &lt;enumeration value="US"/&gt;
 *     &lt;enumeration value="DE"/&gt;
 *     &lt;enumeration value="JL"/&gt;
 *     &lt;enumeration value="WA"/&gt;
 *     &lt;enumeration value="SZ"/&gt;
 *     &lt;enumeration value="YU"/&gt;
 *     &lt;enumeration value="IX"/&gt;
 *     &lt;enumeration value="TH"/&gt;
 *     &lt;enumeration value="LE"/&gt;
 *     &lt;enumeration value="MB"/&gt;
 *     &lt;enumeration value="RF"/&gt;
 *     &lt;enumeration value="GA"/&gt;
 *     &lt;enumeration value="AN"/&gt;
 *     &lt;enumeration value="CI"/&gt;
 *     &lt;enumeration value="TE"/&gt;
 *     &lt;enumeration value="CT"/&gt;
 *     &lt;enumeration value="FO"/&gt;
 *     &lt;enumeration value="ZC"/&gt;
 *     &lt;enumeration value="AD"/&gt;
 *     &lt;enumeration value="BJ"/&gt;
 *     &lt;enumeration value="UZ"/&gt;
 *     &lt;enumeration value="MO"/&gt;
 *     &lt;enumeration value="BW"/&gt;
 *     &lt;enumeration value="FL"/&gt;
 *     &lt;enumeration value="BP"/&gt;
 *     &lt;enumeration value="AH"/&gt;
 *     &lt;enumeration value="RY"/&gt;
 *     &lt;enumeration value="EL"/&gt;
 *     &lt;enumeration value="FN"/&gt;
 *     &lt;enumeration value="AA"/&gt;
 *     &lt;enumeration value="MI"/&gt;
 *     &lt;enumeration value="HI"/&gt;
 *     &lt;enumeration value="AI"/&gt;
 *     &lt;enumeration value="MM"/&gt;
 *     &lt;enumeration value="HL"/&gt;
 *     &lt;enumeration value="AO"/&gt;
 *     &lt;enumeration value="TZ"/&gt;
 *     &lt;enumeration value="LT"/&gt;
 *     &lt;enumeration value="AU"/&gt;
 *     &lt;enumeration value="KS"/&gt;
 *     &lt;enumeration value="TF"/&gt;
 *     &lt;enumeration value="SA"/&gt;
 *     &lt;enumeration value="MF"/&gt;
 *     &lt;enumeration value="IY"/&gt;
 *     &lt;enumeration value="PU"/&gt;
 *     &lt;enumeration value="HT"/&gt;
 *     &lt;enumeration value="OS"/&gt;
 *     &lt;enumeration value="BI"/&gt;
 *     &lt;enumeration value="LS"/&gt;
 *     &lt;enumeration value="BU"/&gt;
 *     &lt;enumeration value="IN"/&gt;
 *     &lt;enumeration value="OA"/&gt;
 *     &lt;enumeration value="BY"/&gt;
 *     &lt;enumeration value="OK"/&gt;
 *     &lt;enumeration value="WN"/&gt;
 *     &lt;enumeration value="AQ"/&gt;
 *     &lt;enumeration value="ZO"/&gt;
 *     &lt;enumeration value="GO"/&gt;
 *     &lt;enumeration value="KO"/&gt;
 *     &lt;enumeration value="JI"/&gt;
 *     &lt;enumeration value="OH"/&gt;
 *     &lt;enumeration value="UC"/&gt;
 *     &lt;enumeration value="NF"/&gt;
 *     &lt;enumeration value="GS"/&gt;
 *     &lt;enumeration value="SS"/&gt;
 *     &lt;enumeration value="NN"/&gt;
 *     &lt;enumeration value="GR"/&gt;
 *     &lt;enumeration value="HR"/&gt;
 *     &lt;enumeration value="LU"/&gt;
 *     &lt;enumeration value="SR"/&gt;
 *     &lt;enumeration value="CL"/&gt;
 *     &lt;enumeration value="DF"/&gt;
 *     &lt;enumeration value="JM"/&gt;
 *     &lt;enumeration value="AS"/&gt;
 *     &lt;enumeration value="KZ"/&gt;
 *     &lt;enumeration value="IW"/&gt;
 *     &lt;enumeration value="IB"/&gt;
 *     &lt;enumeration value="VZ"/&gt;
 *     &lt;enumeration value="JU"/&gt;
 *     &lt;enumeration value="NR"/&gt;
 *     &lt;enumeration value="WT"/&gt;
 *     &lt;enumeration value="YY"/&gt;
 *     &lt;enumeration value="NS"/&gt;
 *     &lt;enumeration value="CZ"/&gt;
 *     &lt;enumeration value="VC"/&gt;
 *     &lt;enumeration value="SM"/&gt;
 *     &lt;enumeration value="DT"/&gt;
 *     &lt;enumeration value="IL"/&gt;
 *     &lt;enumeration value="CD"/&gt;
 *     &lt;enumeration value="GE"/&gt;
 *     &lt;enumeration value="GJ"/&gt;
 *     &lt;enumeration value="IT"/&gt;
 *     &lt;enumeration value="AV"/&gt;
 *     &lt;enumeration value="CU"/&gt;
 *     &lt;enumeration value="UY"/&gt;
 *     &lt;enumeration value="MZ"/&gt;
 *     &lt;enumeration value="DP"/&gt;
 *     &lt;enumeration value="CJ"/&gt;
 *     &lt;enumeration value="KK"/&gt;
 *     &lt;enumeration value="BH"/&gt;
 *     &lt;enumeration value="OF"/&gt;
 *     &lt;enumeration value="PG"/&gt;
 *     &lt;enumeration value="ZI"/&gt;
 *     &lt;enumeration value="LC"/&gt;
 *     &lt;enumeration value="PS"/&gt;
 *     &lt;enumeration value="LP"/&gt;
 *     &lt;enumeration value="IM"/&gt;
 *     &lt;enumeration value="TL"/&gt;
 *     &lt;enumeration value="HN"/&gt;
 *     &lt;enumeration value="DV"/&gt;
 *     &lt;enumeration value="DK"/&gt;
 *     &lt;enumeration value="SU"/&gt;
 *     &lt;enumeration value="GC"/&gt;
 *     &lt;enumeration value="ZM"/&gt;
 *     &lt;enumeration value="RU"/&gt;
 *     &lt;enumeration value="MA"/&gt;
 *     &lt;enumeration value="WY"/&gt;
 *     &lt;enumeration value="NE"/&gt;
 *     &lt;enumeration value="BL"/&gt;
 *     &lt;enumeration value="LN"/&gt;
 *     &lt;enumeration value="NB"/&gt;
 *     &lt;enumeration value="VA"/&gt;
 *     &lt;enumeration value="BO"/&gt;
 *     &lt;enumeration value="AF"/&gt;
 *     &lt;enumeration value="WK"/&gt;
 *     &lt;enumeration value="AL"/&gt;
 *     &lt;enumeration value="OM"/&gt;
 *     &lt;enumeration value="NJ"/&gt;
 *     &lt;enumeration value="UR"/&gt;
 *     &lt;enumeration value="AE"/&gt;
 *     &lt;enumeration value="RS"/&gt;
 *     &lt;enumeration value="SN"/&gt;
 *     &lt;enumeration value="BZ"/&gt;
 *     &lt;enumeration value="PR"/&gt;
 *     &lt;enumeration value="KT"/&gt;
 *     &lt;enumeration value="TB"/&gt;
 *     &lt;enumeration value="TY"/&gt;
 *     &lt;enumeration value="AZ"/&gt;
 *     &lt;enumeration value="WE"/&gt;
 *     &lt;enumeration value="HE"/&gt;
 *     &lt;enumeration value="NL"/&gt;
 *     &lt;enumeration value="OT"/&gt;
 *     &lt;enumeration value="EU"/&gt;
 *     &lt;enumeration value="VY"/&gt;
 *     &lt;enumeration value="DO"/&gt;
 *     &lt;enumeration value="ZA"/&gt;
 *     &lt;enumeration value="TT"/&gt;
 *     &lt;enumeration value="XX"/&gt;
 *     &lt;enumeration value="ML"/&gt;
 *     &lt;enumeration value="ES"/&gt;
 *     &lt;enumeration value="CE"/&gt;
 *     &lt;enumeration value="TX"/&gt;
 *     &lt;enumeration value="TD"/&gt;
 *     &lt;enumeration value="MU"/&gt;
 *     &lt;enumeration value="GU"/&gt;
 *     &lt;enumeration value="AG"/&gt;
 *     &lt;enumeration value="LD"/&gt;
 *     &lt;enumeration value="BC"/&gt;
 *     &lt;enumeration value="TR"/&gt;
 *     &lt;enumeration value="BB"/&gt;
 *     &lt;enumeration value="YG"/&gt;
 *     &lt;enumeration value="WF"/&gt;
 *     &lt;enumeration value="TK"/&gt;
 *     &lt;enumeration value="MT"/&gt;
 *     &lt;enumeration value="RR"/&gt;
 *     &lt;enumeration value="FC"/&gt;
 *     &lt;enumeration value="MS"/&gt;
 *     &lt;enumeration value="NT"/&gt;
 *     &lt;enumeration value="RC"/&gt;
 *     &lt;enumeration value="JR"/&gt;
 *     &lt;enumeration value="PV"/&gt;
 *     &lt;enumeration value="GG"/&gt;
 *     &lt;enumeration value="FD"/&gt;
 *     &lt;enumeration value="GZ"/&gt;
 *     &lt;enumeration value="AM"/&gt;
 *     &lt;enumeration value="MG"/&gt;
 *     &lt;enumeration value="WL"/&gt;
 *     &lt;enumeration value="PQ"/&gt;
 *     &lt;enumeration value="BQ"/&gt;
 *     &lt;enumeration value="DD"/&gt;
 *     &lt;enumeration value="MN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "LISCodeSimpleType")
@XmlEnum
public enum LISCodeSimpleType {


    /**
     * British Virgin Islands
     * 
     */
    VB,

    /**
     * West Bank
     * 
     */
    WB,

    /**
     * Lithuania
     * 
     */
    LH,

    /**
     * Bassas Da India (French possession)
     * 
     */
    BF,

    /**
     * CITIZEN BAND POTTAWATOMIE TRIBE
     * 
     */
    DW,

    /**
     * Morelos
     * 
     */
    MR,

    /**
     * Bonaire (Netherlands Antilles)
     * 
     */
    NX,

    /**
     * Guam
     * 
     */
    GM,

    /**
     * Libya
     * 
     */
    LY,

    /**
     * Guatemala
     * 
     */
    GT,

    /**
     * Ukraine
     * 
     */
    UK,

    /**
     * California
     * 
     */
    CA,

    /**
     * Tajikistan
     * 
     */
    TJ,

    /**
     * New Zealand
     * 
     */
    NZ,

    /**
     * Slovenia
     * 
     */
    LO,

    /**
     * French Guiana
     * 
     */
    FG,

    /**
     * Saudi Arabia
     * 
     */
    SB,

    /**
     * Howland Island
     * 
     */
    HO,

    /**
     * Iran
     * 
     */
    IR,

    /**
     * Bolivia
     * 
     */
    BV,

    /**
     * North Carolina
     * 
     */
    NC,

    /**
     * Martinique
     * 
     */
    ZB,

    /**
     * Wisconsin
     * 
     */
    WI,

    /**
     * Kingman Reef
     * 
     */
    KI,

    /**
     * French Southern and Antartic Lands
     * 
     */
    FR,

    /**
     * Indonesia (now includes Portuguese Timor)
     * 
     */
    IO,

    /**
     * Sonora
     * 
     */
    SO,

    /**
     * Midway Islands
     * 
     */
    MW,

    /**
     * Alaska
     * 
     */
    AK,

    /**
     * New Brunswick
     * 
     */
    NK,

    /**
     * Mauritius
     * 
     */
    UM,

    /**
     * Mariana Islands
     * 
     */
    MK,

    /**
     * Armenia
     * 
     */
    AP,

    /**
     * Maryland
     * 
     */
    MD,

    /**
     * Macao (now spelled Macau)
     * 
     */
    OC,

    /**
     * South Africa
     * 
     */
    SF,

    /**
     * Prince Edward Island
     * 
     */
    PE,

    /**
     * Guyana
     * 
     */
    GY,

    /**
     * Liberia
     * 
     */
    LB,

    /**
     * Mayotte
     * 
     */
    YO,

    /**
     * Uganda
     * 
     */
    UG,

    /**
     * Chile
     * 
     */
    CQ,

    /**
     * Hong Kong
     * 
     */
    HK,

    /**
     * Queretaro
     * 
     */
    QU,

    /**
     * District of Columbia
     * 
     */
    DC,

    /**
     * Manahiki Island
     * 
     */
    KH,

    /**
     * Ireland (does not include NorthernIreland, see Northern Ireland)
     * 
     */
    IE,

    /**
     * Japan
     * 
     */
    JA,

    /**
     * Seychelles
     * 
     */
    SE,

    /**
     * Cape Verde Islands
     * 
     */
    CV,

    /**
     * Luxembourg
     * 
     */
    LX,

    /**
     * Republic of Congo, Brazzaville
     * 
     */
    RB,

    /**
     * Costa Rica
     * 
     */
    CR,

    /**
     * India
     * 
     */
    II,

    /**
     * Fiji
     * 
     */
    FJ,

    /**
     * Tonga
     * 
     */
    TG,

    /**
     * Svalbard
     * 
     */
    SV,

    /**
     * Tamaulipas
     * 
     */
    TA,

    /**
     * Ellice Islands (now Tuvalu)
     * 
     */
    TV,

    /**
     * Saint Helena
     * 
     */
    HS,

    /**
     * Parcel Islands
     * 
     */
    PF,

    /**
     * Brunei
     * 
     */
    BX,

    /**
     * Tunisia
     * 
     */
    TU,

    /**
     * Nicaragua
     * 
     */
    NU,

    /**
     * Devil's Lake Sioux Tribe
     * 
     */
    DL,

    /**
     * South Dakota
     * 
     */
    SD,

    /**
     * Liechtenstein
     * 
     */
    LI,

    /**
     * Niue
     * 
     */
    IU,

    /**
     * Gabon
     * 
     */
    GB,

    /**
     * Russia
     * 
     */
    RA,

    /**
     * Northern Ireland
     * 
     */
    NI,

    /**
     * Dominican Republic
     * 
     */
    DR,

    /**
     * New Guinea (now Papua New Guinea)
     * 
     */
    NO,

    /**
     * Arkansas
     * 
     */
    AR,

    /**
     * Slovakia
     * 
     */
    LF,

    /**
     * CHEYENNE & ARAPAHO TRIBES
     * 
     */
    DA,

    /**
     * Coral Sea Islands (Australian territory)
     * 
     */
    DJ,

    /**
     * Qatar
     * 
     */
    QA,

    /**
     * Saint Vincent and the Grenadines
     * 
     */
    VV,

    /**
     * Israel
     * 
     */
    IS,

    /**
     * Equatorial Guinea
     * 
     */
    EK,

    /**
     * Sweden
     * 
     */
    SQ,

    /**
     * Chihuahua
     * 
     */
    CH,

    /**
     * Philippines
     * 
     */
    PI,

    /**
     * Jordan
     * 
     */
    JO,

    /**
     * Gambia, The
     * 
     */
    GK,

    /**
     * WYANDOTTE TRIBE
     * 
     */
    WD,

    /**
     * Hungary
     * 
     */
    HU,

    /**
     * SEMINOLE NATION
     * 
     */
    SK,

    /**
     * Pennsylvania
     * 
     */
    PA,

    /**
     * Maldives
     * 
     */
    MV,

    /**
     * U.S. Virgin Islands
     * 
     */
    VI,

    /**
     * Spain
     * 
     */
    SP,

    /**
     * Kenya
     * 
     */
    KE,

    /**
     * Utah
     * 
     */
    UT,

    /**
     * Tromelin Island (French possession)
     * 
     */
    TM,

    /**
     * Nayarit
     * 
     */
    NA,

    /**
     * Rhodesia (now Zimbabwe)
     * 
     */
    RH,

    /**
     * Cyprus
     * 
     */
    CS,

    /**
     * Belgium
     * 
     */
    BG,

    /**
     * Nevada
     * 
     */
    NV,

    /**
     * PAWNEE TRIBE
     * 
     */
    PW,

    /**
     * Alberta
     * 
     */
    AB,

    /**
     * Togo
     * 
     */
    TO,

    /**
     * Michoacan
     * 
     */
    MC,

    /**
     * Madagascar (included in Malagasy Republic)
     * 
     */
    MP,

    /**
     * Nepal
     * 
     */
    NP,

    /**
     * Socialist Republic of Vietnam
     * 
     */
    RV,

    /**
     * Europa Island (French possession)
     * 
     */
    ER,

    /**
     * Czech Republic
     * 
     */
    EZ,

    /**
     * Mexico (State)
     * 
     */
    MX,

    /**
     * Ontario
     * 
     */
    ON,

    /**
     * Okinawa
     * 
     */
    OI,

    /**
     * Clipperton Island (French possession)
     * 
     */
    DB,

    /**
     * APACHE TRIBE
     * 
     */
    AX,

    /**
     * Eretria
     * 
     */
    ET,

    /**
     * Caroline Islands
     * 
     */
    CG,

    /**
     * Taiwan, Republic of China
     * 
     */
    TW,

    /**
     * Baker Island
     * 
     */
    BK,

    /**
     * Puebla
     * 
     */
    PB,

    /**
     * Leech Lake Band of Chippewa
     * 
     */
    LL,

    /**
     * Colombia
     * 
     */
    CB,

    /**
     * Idaho
     * 
     */
    ID,

    /**
     * Palmyra Atoll
     * 
     */
    PL,

    /**
     * Sinaloa
     * 
     */
    SI,

    /**
     * Palau, Republic of
     * 
     */
    PD,

    /**
     * West Virginia
     * 
     */
    WV,

    /**
     * Benin (formerly Dahomey)
     * 
     */
    DH,

    /**
     * Aruba (now independent of NetherlandsAntilles)
     * 
     */
    AJ,

    /**
     * Iraq
     * 
     */
    IQ,

    /**
     * French Polynesia
     * 
     */
    FP,

    /**
     * Western Samoa
     * 
     */
    WS,

    /**
     * Djibouti
     * 
     */
    DN,

    /**
     * New Caledonia
     * 
     */
    NQ,

    /**
     * Louisiana
     * 
     */
    LA,

    /**
     * Monaco
     * 
     */
    MJ,

    /**
     * New Hampshire
     * 
     */
    NH,

    /**
     * Quintana Roo
     * 
     */
    QR,

    /**
     * Syria
     * 
     */
    SY,

    /**
     * Sac & Fox
     * 
     */
    FX,

    /**
     * Iowa
     * 
     */
    IA,

    /**
     * Central African Republic
     * 
     */
    CW,

    /**
     * Burma
     * 
     */
    BR,

    /**
     * Guinea
     * 
     */
    GI,

    /**
     * Pitcairn,Henderson, Ducie, and OenoIslands
     * 
     */
    PC,

    /**
     * Nevis and Saint Christopher "Kitts"
     * 
     */
    TS,

    /**
     * Norway
     * 
     */
    NW,

    /**
     * Kuwait
     * 
     */
    KU,

    /**
     * Trucial States (now United Arab Emirates)
     * 
     */
    TC,

    /**
     * Egypt (formerly United Arab Republic)
     * 
     */
    EY,

    /**
     * Jersey
     * 
     */
    JE,

    /**
     * Bahrain/Bahrein
     * 
     */
    BE,

    /**
     * Reunion
     * 
     */
    RE,

    /**
     * Dominica
     * 
     */
    DM,

    /**
     * Maine
     * 
     */
    ME,

    /**
     * North Dakota
     * 
     */
    ND,

    /**
     * Yukon (Territory)
     * 
     */
    YT,

    /**
     * Gilbert Islands (now Kiribati)
     * 
     */
    KB,

    /**
     * Honduras
     * 
     */
    HD,

    /**
     * Namibia (South-West Africa)
     * 
     */
    SJ,

    /**
     * OTOE-MISSOURIA TRIBE
     * 
     */
    OO,

    /**
     * PONCA TRIBE
     * 
     */
    PN,

    /**
     * Rhode Island
     * 
     */
    RI,

    /**
     * Ceylon (Now Sri Lanka)
     * 
     */
    CY,

    /**
     * Botswana
     * 
     */
    BT,

    /**
     * Marshall Islands
     * 
     */
    MH,

    /**
     * MIAMI TRIBE
     * 
     */
    DS,

    /**
     * Poland
     * 
     */
    PO,

    /**
     * Gibraltar
     * 
     */
    RG,

    /**
     * Burkina Faso (known as Burkina,formerly Upper Volta)
     * 
     */
    UV,

    /**
     * Kiowa
     * 
     */
    KW,

    /**
     * OSAGE NATION
     * 
     */
    OG,

    /**
     * Tennessee
     * 
     */
    TN,

    /**
     * Greenland
     * 
     */
    GN,

    /**
     * Falkland Islands
     * 
     */
    FA,

    /**
     * North Korea
     * 
     */
    KN,

    /**
     * Red Lake
     * 
     */
    RL,

    /**
     * Guernsey
     * 
     */
    GF,

    /**
     * San Marino
     * 
     */
    SH,

    /**
     * England
     * 
     */
    EN,

    /**
     * Argentina
     * 
     */
    AT,

    /**
     * Malta
     * 
     */
    MY,

    /**
     * New York
     * 
     */
    NY,

    /**
     * Croatia
     * 
     */
    KC,

    /**
     * Cayman Islands
     * 
     */
    CP,

    /**
     * Absentee Shawnee
     * 
     */
    EE,

    /**
     * Oregon
     * 
     */
    OR,

    /**
     * South Carolina
     * 
     */
    SC,

    /**
     * Jan Mayen
     * 
     */
    JN,

    /**
     * Swaziland
     * 
     */
    SW,

    /**
     * New Mexico
     * 
     */
    NM,

    /**
     * Kentucky
     * 
     */
    KY,

    /**
     * Cook Islands
     * 
     */
    DI,

    /**
     * British Solomon Islands (now SolomonIslands)
     * 
     */
    BS,

    /**
     * Baja California (Northern Section)
     * 
     */
    BA,

    /**
     * Vermont
     * 
     */
    VT,

    /**
     * Bahamas, The
     * 
     */
    BD,

    /**
     * Panama
     * 
     */
    PM,

    /**
     * Cameroon
     * 
     */
    CM,

    /**
     * Bermuda
     * 
     */
    BM,

    /**
     * Portugal
     * 
     */
    PT,

    /**
     * Chad
     * 
     */
    CF,

    /**
     * Iceland
     * 
     */
    IC,

    /**
     * Colorado
     * 
     */
    CO,

    /**
     * Navassa Island
     * 
     */
    VL,

    /**
     * Cuba
     * 
     */
    CC,

    /**
     * Federated States of Micronesia
     * 
     */
    FS,

    /**
     * Rwanda
     * 
     */
    RW,

    /**
     * San Luis Potosi
     * 
     */
    SL,

    /**
     * Sao Tome and Principe
     * 
     */
    TP,

    /**
     * Bhutan
     * 
     */
    BN,

    /**
     * Congo Kinshasa, now Zaire
     * 
     */
    ZR,

    /**
     * Macedonia
     * 
     */
    ZD,

    /**
     * Comoros (or Comoros Islands)
     * 
     */
    DG,

    /**
     * Morocco
     * 
     */
    MQ,

    /**
     * Nigeria
     * 
     */
    NG,

    /**
     * Senegal
     * 
     */
    SG,

    /**
     * Guadeloupe
     * 
     */
    GP,

    /**
     * Shakopee
     * 
     */
    KP,

    /**
     * Georgia
     * 
     */
    GD,

    /**
     * Ethiopia
     * 
     */
    EO,

    /**
     * Pakistan
     * 
     */
    PK,

    /**
     * United States of America (USA) (Should beused in the following circumstances:1. To indicate the LIS
     * 
     */
    US,

    /**
     * Delaware
     * 
     */
    DE,

    /**
     * Jalisco
     * 
     */
    JL,

    /**
     * Washington
     * 
     */
    WA,

    /**
     * Switzerland
     * 
     */
    SZ,

    /**
     * Yucatan
     * 
     */
    YU,

    /**
     * Menominee
     * 
     */
    IX,

    /**
     * Thailand
     * 
     */
    TH,

    /**
     * Lesotho
     * 
     */
    LE,

    /**
     * Manitoba
     * 
     */
    MB,

    /**
     * Russian Federation
     * 
     */
    RF,

    /**
     * Georgia
     * 
     */
    GA,

    /**
     * Algeria
     * 
     */
    AN,

    /**
     * Chiapas
     * 
     */
    CI,

    /**
     * Spratly Islands
     * 
     */
    TE,

    /**
     * Connecticut
     * 
     */
    CT,

    /**
     * Faroe Islands
     * 
     */
    FO,

    /**
     * Surinam
     * 
     */
    ZC,

    /**
     * Andorra
     * 
     */
    AD,

    /**
     * Baja California (Southern Section)
     * 
     */
    BJ,

    /**
     * Uzbekistan
     * 
     */
    UZ,

    /**
     * Missouri
     * 
     */
    MO,

    /**
     * Balearic Islands
     * 
     */
    BW,

    /**
     * Florida
     * 
     */
    FL,

    /**
     * Bosnia and Hercegovenia
     * 
     */
    BP,

    /**
     * Ashmore and Cartier Islands
     * 
     */
    AH,

    /**
     * Republic of Yemen
     * 
     */
    RY,

    /**
     * El Salvador
     * 
     */
    EL,

    /**
     * France
     * 
     */
    FN,

    /**
     * Albania
     * 
     */
    AA,

    /**
     * Michigan
     * 
     */
    MI,

    /**
     * Hawaii
     * 
     */
    HI,

    /**
     * Antigua and Barbuda (formerly Antigua)
     * 
     */
    AI,

    /**
     * Mexico (See separate list of MexicanStates; use code MM only when state isunknown)
     * 
     */
    MM,

    /**
     * Hidalgo
     * 
     */
    HL,

    /**
     * Angola
     * 
     */
    AO,

    /**
     * Tanzania, United Republic of
     * 
     */
    TZ,

    /**
     * LATVIA
     * 
     */
    LT,

    /**
     * Austria
     * 
     */
    AU,

    /**
     * Kansas
     * 
     */
    KS,

    /**
     * Tuamotu Archipelago
     * 
     */
    TF,

    /**
     * Sierre Leone (Sierra Leone)
     * 
     */
    SA,

    /**
     * Malawi
     * 
     */
    MF,

    /**
     * Cote d'Ivoire (Ivory Coast)
     * 
     */
    IY,

    /**
     * Peru
     * 
     */
    PU,

    /**
     * Haiti
     * 
     */
    HT,

    /**
     * Oglala Sioux
     * 
     */
    OS,

    /**
     * Burundi
     * 
     */
    BI,

    /**
     * Laos
     * 
     */
    LS,

    /**
     * Bulgaria
     * 
     */
    BU,

    /**
     * Indiana
     * 
     */
    IN,

    /**
     * Oaxaca
     * 
     */
    OA,

    /**
     * Byelarus
     * 
     */
    BY,

    /**
     * Oklahoma
     * 
     */
    OK,

    /**
     * West Indies (for West Indies Islands notfound separately listed)
     * 
     */
    WN,

    /**
     * Azores Islands
     * 
     */
    AQ,

    /**
     * Mozambique
     * 
     */
    ZO,

    /**
     * Glorioso Islands (French possession)
     * 
     */
    GO,

    /**
     * South Korea
     * 
     */
    KO,

    /**
     * Johnston Island
     * 
     */
    JI,

    /**
     * Ohio
     * 
     */
    OH,

    /**
     * Turtle Mtn. Band of Chipewa
     * 
     */
    UC,

    /**
     * Newfoundland (includes Labrador)
     * 
     */
    NF,

    /**
     * South Georgia and the South SandwichIslands
     * 
     */
    GS,

    /**
     * Scotland
     * 
     */
    SS,

    /**
     * Niger
     * 
     */
    NN,

    /**
     * Guerrero
     * 
     */
    GR,

    /**
     * Christmas Island
     * 
     */
    HR,

    /**
     * Saint Lucia
     * 
     */
    LU,

    /**
     * Singapore
     * 
     */
    SR,

    /**
     * Colima
     * 
     */
    CL,

    /**
     * Distrito Federal (Mexico, D. F.)
     * 
     */
    DF,

    /**
     * Jamaica
     * 
     */
    JM,

    /**
     * Australia
     * 
     */
    AS,

    /**
     * Kyrgyzstan
     * 
     */
    KZ,

    /**
     * IOWA TRIBE
     * 
     */
    IW,

    /**
     * Isle of Man
     * 
     */
    IB,

    /**
     * Venezuela
     * 
     */
    VZ,

    /**
     * Juan de Nova Island
     * 
     */
    JU,

    /**
     * Nauru
     * 
     */
    NR,

    /**
     * WICHITA TRIBE
     * 
     */
    WT,

    /**
     * All others (Any foreign country/dependency/territory not included inthe above abbreviation list is t
     * 
     */
    YY,

    /**
     * Nova Scotia
     * 
     */
    NS,

    /**
     * Canal Zone
     * 
     */
    CZ,

    /**
     * Veracruz
     * 
     */
    VC,

    /**
     * Somalia
     * 
     */
    SM,

    /**
     * MUSCOGEE (CREEK) TRIBE
     * 
     */
    DT,

    /**
     * Illinois
     * 
     */
    IL,

    /**
     * Canada(See separate list of CanadianProvinces; use code CD only whenprovince is unknown.)
     * 
     */
    CD,

    /**
     * Germany (East Germany: 1945-1989,for reference only)(West Germany: 1945-1989, for referenceonly)
     * 
     */
    GE,

    /**
     * Grenada
     * 
     */
    GJ,

    /**
     * Italy (includes Sicily and Sardinia)
     * 
     */
    IT,

    /**
     * Azerbaijan
     * 
     */
    AV,

    /**
     * Coahuila
     * 
     */
    CU,

    /**
     * Uruguay
     * 
     */
    UY,

    /**
     * Malaysia
     * 
     */
    MZ,

    /**
     * COMANCHE NATION
     * 
     */
    DP,

    /**
     * Cambodia (formerly Khmer Republic& Kampuchea)
     * 
     */
    CJ,

    /**
     * KICKAPOO TRIBE
     * 
     */
    KK,

    /**
     * Belize (formerly British Honduras)
     * 
     */
    BH,

    /**
     * Norfolk Island
     * 
     */
    OF,

    /**
     * Guinea-Bissau (formerly Portuguese Guinea)
     * 
     */
    PG,

    /**
     * Canary Islands
     * 
     */
    ZI,

    /**
     * Mille Lacs
     * 
     */
    LC,

    /**
     * Saint Pierre and Miquelon
     * 
     */
    PS,

    /**
     * Lac du Flambeau Band of Lake SuperiorChippewa
     * 
     */
    LP,

    /**
     * Madeira Islands
     * 
     */
    IM,

    /**
     * Tlaxcala
     * 
     */
    TL,

    /**
     * New Hebrides (now Vanuatu)
     * 
     */
    HN,

    /**
     * SENECA-CAYUGA TRIBES
     * 
     */
    DV,

    /**
     * Denmark
     * 
     */
    DK,

    /**
     * Sudan
     * 
     */
    SU,

    /**
     * Greece
     * 
     */
    GC,

    /**
     * Zambia
     * 
     */
    ZM,

    /**
     * Romania/Rumania
     * 
     */
    RU,

    /**
     * Massachusetts
     * 
     */
    MA,

    /**
     * Wyoming
     * 
     */
    WY,

    /**
     * Holland (Netherlands)
     * 
     */
    NE,

    /**
     * Bangladesh
     * 
     */
    BL,

    /**
     * Lebanon
     * 
     */
    LN,

    /**
     * Nebraska
     * 
     */
    NB,

    /**
     * Virginia
     * 
     */
    VA,

    /**
     * British Indian Ocean Territory
     * 
     */
    BO,

    /**
     * Afghanistan
     * 
     */
    AF,

    /**
     * Wake Island
     * 
     */
    WK,

    /**
     * Alabama
     * 
     */
    AL,

    /**
     * Oman
     * 
     */
    OM,

    /**
     * New Jersey
     * 
     */
    NJ,

    /**
     * Turkmenistan
     * 
     */
    UR,

    /**
     * Anguilla
     * 
     */
    AE,

    /**
     * Spanish Sahara (now Western Sahara)
     * 
     */
    RS,

    /**
     * Saskatchewan
     * 
     */
    SN,

    /**
     * Brazil
     * 
     */
    BZ,

    /**
     * Puerto Rico
     * 
     */
    PR,

    /**
     * Kazakhstan
     * 
     */
    KT,

    /**
     * Tabasco
     * 
     */
    TB,

    /**
     * Turkey
     * 
     */
    TY,

    /**
     * Arizona
     * 
     */
    AZ,

    /**
     * White Earth
     * 
     */
    WE,

    /**
     * Heard Island and McDonald Island
     * 
     */
    HE,

    /**
     * Nuevo Leon
     * 
     */
    NL,

    /**
     * Oneida Tribe of Indians of Wisconsin
     * 
     */
    OT,

    /**
     * Ecuador
     * 
     */
    EU,

    /**
     * Vatican City
     * 
     */
    VY,

    /**
     * Durango
     * 
     */
    DO,

    /**
     * Zacatecas
     * 
     */
    ZA,

    /**
     * Trinidad and Tobago
     * 
     */
    TT,

    /**
     * Unknown Place of Birth (for use in IIIrecords only)
     * 
     */
    XX,

    /**
     * Mali
     * 
     */
    ML,

    /**
     * Estonia
     * 
     */
    ES,

    /**
     * Campeche
     * 
     */
    CE,

    /**
     * Texas
     * 
     */
    TX,

    /**
     * Trust Territory of the Pacific Islands
     * 
     */
    TD,

    /**
     * Mauritania
     * 
     */
    MU,

    /**
     * Guanajuato
     * 
     */
    GU,

    /**
     * Aguascalientes
     * 
     */
    AG,

    /**
     * Moldova
     * 
     */
    LD,

    /**
     * British Columbia
     * 
     */
    BC,

    /**
     * Turks and Calcos Islands
     * 
     */
    TR,

    /**
     * Barbados
     * 
     */
    BB,

    /**
     * Yugoslavia
     * 
     */
    YG,

    /**
     * Wallis and Futuna (French territory)
     * 
     */
    WF,

    /**
     * Tokelau
     * 
     */
    TK,

    /**
     * Montana
     * 
     */
    MT,

    /**
     * Montserrat
     * 
     */
    RR,

    /**
     * Fond du Lac
     * 
     */
    FC,

    /**
     * Mississippi
     * 
     */
    MS,

    /**
     * Northwest Territories
     * 
     */
    NT,

    /**
     * People's Republic of China
     * 
     */
    RC,

    /**
     * Jarvis Island
     * 
     */
    JR,

    /**
     * Paraquay
     * 
     */
    PV,

    /**
     * Ghana
     * 
     */
    GG,

    /**
     * Finland
     * 
     */
    FD,

    /**
     * Gaza
     * 
     */
    GZ,

    /**
     * American Samoa (Islands)
     * 
     */
    AM,

    /**
     * Mongolia
     * 
     */
    MG,

    /**
     * Wales
     * 
     */
    WL,

    /**
     * Quebec
     * 
     */
    PQ,

    /**
     * Bouvet Island (Norwegian territory)
     * 
     */
    BQ,

    /**
     * Cocos (Keeling) Islands (Australiandependency)
     * 
     */
    DD,

    /**
     * Minnesota
     * 
     */
    MN;

    public String value() {
        return name();
    }

    public static LISCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
