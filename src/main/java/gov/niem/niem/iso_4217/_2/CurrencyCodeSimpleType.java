
package gov.niem.niem.iso_4217._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for CurrencyCodeSimpleType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="CurrencyCodeSimpleType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&amp;gt;
 *     &amp;lt;enumeration value="MUR"/&amp;gt;
 *     &amp;lt;enumeration value="UZS"/&amp;gt;
 *     &amp;lt;enumeration value="YUM"/&amp;gt;
 *     &amp;lt;enumeration value="SDD"/&amp;gt;
 *     &amp;lt;enumeration value="SHP"/&amp;gt;
 *     &amp;lt;enumeration value="XBD"/&amp;gt;
 *     &amp;lt;enumeration value="IEP"/&amp;gt;
 *     &amp;lt;enumeration value="ATS"/&amp;gt;
 *     &amp;lt;enumeration value="MOP"/&amp;gt;
 *     &amp;lt;enumeration value="PKR"/&amp;gt;
 *     &amp;lt;enumeration value="KHR"/&amp;gt;
 *     &amp;lt;enumeration value="HTG"/&amp;gt;
 *     &amp;lt;enumeration value="ITL"/&amp;gt;
 *     &amp;lt;enumeration value="GTQ"/&amp;gt;
 *     &amp;lt;enumeration value="RUB"/&amp;gt;
 *     &amp;lt;enumeration value="JMD"/&amp;gt;
 *     &amp;lt;enumeration value="TTD"/&amp;gt;
 *     &amp;lt;enumeration value="ZWD"/&amp;gt;
 *     &amp;lt;enumeration value="TZS"/&amp;gt;
 *     &amp;lt;enumeration value="TJS"/&amp;gt;
 *     &amp;lt;enumeration value="CVE"/&amp;gt;
 *     &amp;lt;enumeration value="KZT"/&amp;gt;
 *     &amp;lt;enumeration value="GYD"/&amp;gt;
 *     &amp;lt;enumeration value="WST"/&amp;gt;
 *     &amp;lt;enumeration value="DOP"/&amp;gt;
 *     &amp;lt;enumeration value="ADP"/&amp;gt;
 *     &amp;lt;enumeration value="KPW"/&amp;gt;
 *     &amp;lt;enumeration value="GMD"/&amp;gt;
 *     &amp;lt;enumeration value="ECV"/&amp;gt;
 *     &amp;lt;enumeration value="ERN"/&amp;gt;
 *     &amp;lt;enumeration value="XTS"/&amp;gt;
 *     &amp;lt;enumeration value="AOR"/&amp;gt;
 *     &amp;lt;enumeration value="CLF"/&amp;gt;
 *     &amp;lt;enumeration value="XBC"/&amp;gt;
 *     &amp;lt;enumeration value="TOP"/&amp;gt;
 *     &amp;lt;enumeration value="BBD"/&amp;gt;
 *     &amp;lt;enumeration value="XAU"/&amp;gt;
 *     &amp;lt;enumeration value="LKR"/&amp;gt;
 *     &amp;lt;enumeration value="MTL"/&amp;gt;
 *     &amp;lt;enumeration value="GNF"/&amp;gt;
 *     &amp;lt;enumeration value="GEL"/&amp;gt;
 *     &amp;lt;enumeration value="TPE"/&amp;gt;
 *     &amp;lt;enumeration value="LRD"/&amp;gt;
 *     &amp;lt;enumeration value="LVL"/&amp;gt;
 *     &amp;lt;enumeration value="SCR"/&amp;gt;
 *     &amp;lt;enumeration value="FRF"/&amp;gt;
 *     &amp;lt;enumeration value="MXN"/&amp;gt;
 *     &amp;lt;enumeration value="XFO"/&amp;gt;
 *     &amp;lt;enumeration value="GRD"/&amp;gt;
 *     &amp;lt;enumeration value="MAD"/&amp;gt;
 *     &amp;lt;enumeration value="TND"/&amp;gt;
 *     &amp;lt;enumeration value="MWK"/&amp;gt;
 *     &amp;lt;enumeration value="XAG"/&amp;gt;
 *     &amp;lt;enumeration value="XPF"/&amp;gt;
 *     &amp;lt;enumeration value="JPY"/&amp;gt;
 *     &amp;lt;enumeration value="SLL"/&amp;gt;
 *     &amp;lt;enumeration value="AFA"/&amp;gt;
 *     &amp;lt;enumeration value="MYR"/&amp;gt;
 *     &amp;lt;enumeration value="PGK"/&amp;gt;
 *     &amp;lt;enumeration value="NGN"/&amp;gt;
 *     &amp;lt;enumeration value="STD"/&amp;gt;
 *     &amp;lt;enumeration value="ZMK"/&amp;gt;
 *     &amp;lt;enumeration value="XCD"/&amp;gt;
 *     &amp;lt;enumeration value="BAM"/&amp;gt;
 *     &amp;lt;enumeration value="XBB"/&amp;gt;
 *     &amp;lt;enumeration value="GIP"/&amp;gt;
 *     &amp;lt;enumeration value="CRC"/&amp;gt;
 *     &amp;lt;enumeration value="TMM"/&amp;gt;
 *     &amp;lt;enumeration value="KES"/&amp;gt;
 *     &amp;lt;enumeration value="EUR"/&amp;gt;
 *     &amp;lt;enumeration value="TWD"/&amp;gt;
 *     &amp;lt;enumeration value="SAR"/&amp;gt;
 *     &amp;lt;enumeration value="BWP"/&amp;gt;
 *     &amp;lt;enumeration value="IQD"/&amp;gt;
 *     &amp;lt;enumeration value="CAD"/&amp;gt;
 *     &amp;lt;enumeration value="CHF"/&amp;gt;
 *     &amp;lt;enumeration value="PAB"/&amp;gt;
 *     &amp;lt;enumeration value="GBP"/&amp;gt;
 *     &amp;lt;enumeration value="COP"/&amp;gt;
 *     &amp;lt;enumeration value="ILS"/&amp;gt;
 *     &amp;lt;enumeration value="XAF"/&amp;gt;
 *     &amp;lt;enumeration value="NIO"/&amp;gt;
 *     &amp;lt;enumeration value="ESP"/&amp;gt;
 *     &amp;lt;enumeration value="JOD"/&amp;gt;
 *     &amp;lt;enumeration value="VND"/&amp;gt;
 *     &amp;lt;enumeration value="LYD"/&amp;gt;
 *     &amp;lt;enumeration value="SBD"/&amp;gt;
 *     &amp;lt;enumeration value="MZM"/&amp;gt;
 *     &amp;lt;enumeration value="EEK"/&amp;gt;
 *     &amp;lt;enumeration value="USS"/&amp;gt;
 *     &amp;lt;enumeration value="DZD"/&amp;gt;
 *     &amp;lt;enumeration value="LBP"/&amp;gt;
 *     &amp;lt;enumeration value="BEF"/&amp;gt;
 *     &amp;lt;enumeration value="ZAL"/&amp;gt;
 *     &amp;lt;enumeration value="CLP"/&amp;gt;
 *     &amp;lt;enumeration value="UGX"/&amp;gt;
 *     &amp;lt;enumeration value="HRK"/&amp;gt;
 *     &amp;lt;enumeration value="BZD"/&amp;gt;
 *     &amp;lt;enumeration value="BSD"/&amp;gt;
 *     &amp;lt;enumeration value="LAK"/&amp;gt;
 *     &amp;lt;enumeration value="ROL"/&amp;gt;
 *     &amp;lt;enumeration value="BDT"/&amp;gt;
 *     &amp;lt;enumeration value="MMK"/&amp;gt;
 *     &amp;lt;enumeration value="CYP"/&amp;gt;
 *     &amp;lt;enumeration value="XPD"/&amp;gt;
 *     &amp;lt;enumeration value="MXV"/&amp;gt;
 *     &amp;lt;enumeration value="HKD"/&amp;gt;
 *     &amp;lt;enumeration value="SOS"/&amp;gt;
 *     &amp;lt;enumeration value="KWD"/&amp;gt;
 *     &amp;lt;enumeration value="KRW"/&amp;gt;
 *     &amp;lt;enumeration value="PEN"/&amp;gt;
 *     &amp;lt;enumeration value="AON"/&amp;gt;
 *     &amp;lt;enumeration value="BGN"/&amp;gt;
 *     &amp;lt;enumeration value="AWG"/&amp;gt;
 *     &amp;lt;enumeration value="CDF"/&amp;gt;
 *     &amp;lt;enumeration value="UAH"/&amp;gt;
 *     &amp;lt;enumeration value="NLG"/&amp;gt;
 *     &amp;lt;enumeration value="BRL"/&amp;gt;
 *     &amp;lt;enumeration value="UYU"/&amp;gt;
 *     &amp;lt;enumeration value="MVR"/&amp;gt;
 *     &amp;lt;enumeration value="LUF"/&amp;gt;
 *     &amp;lt;enumeration value="TJR"/&amp;gt;
 *     &amp;lt;enumeration value="DEM"/&amp;gt;
 *     &amp;lt;enumeration value="FKP"/&amp;gt;
 *     &amp;lt;enumeration value="YER"/&amp;gt;
 *     &amp;lt;enumeration value="KMF"/&amp;gt;
 *     &amp;lt;enumeration value="SGD"/&amp;gt;
 *     &amp;lt;enumeration value="AZM"/&amp;gt;
 *     &amp;lt;enumeration value="ANG"/&amp;gt;
 *     &amp;lt;enumeration value="XOF"/&amp;gt;
 *     &amp;lt;enumeration value="SZL"/&amp;gt;
 *     &amp;lt;enumeration value="LSL"/&amp;gt;
 *     &amp;lt;enumeration value="CZK"/&amp;gt;
 *     &amp;lt;enumeration value="XDR"/&amp;gt;
 *     &amp;lt;enumeration value="ECS"/&amp;gt;
 *     &amp;lt;enumeration value="XPT"/&amp;gt;
 *     &amp;lt;enumeration value="CNY"/&amp;gt;
 *     &amp;lt;enumeration value="SVC"/&amp;gt;
 *     &amp;lt;enumeration value="BIF"/&amp;gt;
 *     &amp;lt;enumeration value="CUP"/&amp;gt;
 *     &amp;lt;enumeration value="KYD"/&amp;gt;
 *     &amp;lt;enumeration value="IDR"/&amp;gt;
 *     &amp;lt;enumeration value="PYG"/&amp;gt;
 *     &amp;lt;enumeration value="NOK"/&amp;gt;
 *     &amp;lt;enumeration value="MRO"/&amp;gt;
 *     &amp;lt;enumeration value="ARS"/&amp;gt;
 *     &amp;lt;enumeration value="PTE"/&amp;gt;
 *     &amp;lt;enumeration value="FJD"/&amp;gt;
 *     &amp;lt;enumeration value="SRG"/&amp;gt;
 *     &amp;lt;enumeration value="OMR"/&amp;gt;
 *     &amp;lt;enumeration value="TRL"/&amp;gt;
 *     &amp;lt;enumeration value="SKK"/&amp;gt;
 *     &amp;lt;enumeration value="MKD"/&amp;gt;
 *     &amp;lt;enumeration value="ETB"/&amp;gt;
 *     &amp;lt;enumeration value="NAD"/&amp;gt;
 *     &amp;lt;enumeration value="BMD"/&amp;gt;
 *     &amp;lt;enumeration value="ZAR"/&amp;gt;
 *     &amp;lt;enumeration value="USD"/&amp;gt;
 *     &amp;lt;enumeration value="ALL"/&amp;gt;
 *     &amp;lt;enumeration value="RWF"/&amp;gt;
 *     &amp;lt;enumeration value="SIT"/&amp;gt;
 *     &amp;lt;enumeration value="AED"/&amp;gt;
 *     &amp;lt;enumeration value="QAR"/&amp;gt;
 *     &amp;lt;enumeration value="RUR"/&amp;gt;
 *     &amp;lt;enumeration value="BYR"/&amp;gt;
 *     &amp;lt;enumeration value="NZD"/&amp;gt;
 *     &amp;lt;enumeration value="MNT"/&amp;gt;
 *     &amp;lt;enumeration value="IRR"/&amp;gt;
 *     &amp;lt;enumeration value="VUV"/&amp;gt;
 *     &amp;lt;enumeration value="SEK"/&amp;gt;
 *     &amp;lt;enumeration value="MDL"/&amp;gt;
 *     &amp;lt;enumeration value="SYP"/&amp;gt;
 *     &amp;lt;enumeration value="INR"/&amp;gt;
 *     &amp;lt;enumeration value="HNL"/&amp;gt;
 *     &amp;lt;enumeration value="HUF"/&amp;gt;
 *     &amp;lt;enumeration value="NPR"/&amp;gt;
 *     &amp;lt;enumeration value="THB"/&amp;gt;
 *     &amp;lt;enumeration value="GWP"/&amp;gt;
 *     &amp;lt;enumeration value="PLN"/&amp;gt;
 *     &amp;lt;enumeration value="DKK"/&amp;gt;
 *     &amp;lt;enumeration value="LTL"/&amp;gt;
 *     &amp;lt;enumeration value="ISK"/&amp;gt;
 *     &amp;lt;enumeration value="GHC"/&amp;gt;
 *     &amp;lt;enumeration value="ZRN"/&amp;gt;
 *     &amp;lt;enumeration value="EGP"/&amp;gt;
 *     &amp;lt;enumeration value="VEB"/&amp;gt;
 *     &amp;lt;enumeration value="XBA"/&amp;gt;
 *     &amp;lt;enumeration value="FIM"/&amp;gt;
 *     &amp;lt;enumeration value="AMD"/&amp;gt;
 *     &amp;lt;enumeration value="KGS"/&amp;gt;
 *     &amp;lt;enumeration value="BGL"/&amp;gt;
 *     &amp;lt;enumeration value="XFU"/&amp;gt;
 *     &amp;lt;enumeration value="DJF"/&amp;gt;
 *     &amp;lt;enumeration value="BHD"/&amp;gt;
 *     &amp;lt;enumeration value="AUD"/&amp;gt;
 *     &amp;lt;enumeration value="PHP"/&amp;gt;
 *     &amp;lt;enumeration value="BND"/&amp;gt;
 *     &amp;lt;enumeration value="USN"/&amp;gt;
 *     &amp;lt;enumeration value="MGF"/&amp;gt;
 *     &amp;lt;enumeration value="BTN"/&amp;gt;
 *     &amp;lt;enumeration value="XXX"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "CurrencyCodeSimpleType", namespace = "http://niem.gov/niem/iso_4217/2.0")
@XmlEnum
public enum CurrencyCodeSimpleType {


    /**
     * Mauritius Rupee: Mauritius
     * 
     */
    MUR,

    /**
     * Uzbekistan Sum: Uzbekistan
     * 
     */
    UZS,

    /**
     * New Dinar: Yugoslavia
     * 
     */
    YUM,

    /**
     * Sudanese Dinar: Sudan
     * 
     */
    SDD,

    /**
     * St Helena Pound: St Helena
     * 
     */
    SHP,

    /**
     * European Unit of Account 17 (E.U.A.- 17): Bond Markets Units
     * 
     */
    XBD,

    /**
     * Irish Pound: Ireland
     * 
     */
    IEP,

    /**
     * Schilling: Austria
     * 
     */
    ATS,

    /**
     * Pataca: Macau
     * 
     */
    MOP,

    /**
     * Pakistan Rupee: Pakistan
     * 
     */
    PKR,

    /**
     * Riel: Cambodia
     * 
     */
    KHR,

    /**
     * Gourde: Haiti
     * 
     */
    HTG,

    /**
     * Italian Lira: Italy, San Marino, Vatican City State (Holy See)
     * 
     */
    ITL,

    /**
     * Quetzal: Guatemala
     * 
     */
    GTQ,

    /**
     * Russian Ruble: Russian Federation
     * 
     */
    RUB,

    /**
     * Jamaican Dollar: Jamaica
     * 
     */
    JMD,

    /**
     * Trinidad and Tobago Dollar: Trinidad and Tobago
     * 
     */
    TTD,

    /**
     * Zimbabwe Dollar: Zimbabwe
     * 
     */
    ZWD,

    /**
     * Tanzanian Shilling: Tanzania, United Republic Of
     * 
     */
    TZS,

    /**
     * Somoni: Tajikistan
     * 
     */
    TJS,

    /**
     * Cape Verde Escudo: Cape Verde
     * 
     */
    CVE,

    /**
     * Tenge: Kazakhstan
     * 
     */
    KZT,

    /**
     * Guyana Dollar: Guyana
     * 
     */
    GYD,

    /**
     * Tala: Samoa
     * 
     */
    WST,

    /**
     * Dominican Peso: Dominican Republic
     * 
     */
    DOP,

    /**
     * Andorran Peseta: Andorra
     * 
     */
    ADP,

    /**
     * North Korean Won: Korea, Democratic People's Republic Of
     * 
     */
    KPW,

    /**
     * Dalasi: Gambia
     * 
     */
    GMD,

    /**
     * Unidad de Valor Constante (UVC): Ecuador
     * 
     */
    ECV,

    /**
     * Nakfa: Eritrea
     * 
     */
    ERN,

    /**
     * Codes specifically reserved for testing purposes: 
     * 
     */
    XTS,

    /**
     * Kwanza Reajustado: Angola
     * 
     */
    AOR,

    /**
     * Unidades de fomento: Chile
     * 
     */
    CLF,

    /**
     * European Unit of Account 9 (E.U.A.- 9): Bond Markets Units
     * 
     */
    XBC,

    /**
     * Pa'anga: Tonga
     * 
     */
    TOP,

    /**
     * Barbados Dollar: Barbados
     * 
     */
    BBD,

    /**
     * Gold Bond Markets Units: 
     * 
     */
    XAU,

    /**
     * Sri Lanka Rupee: Sri Lanka
     * 
     */
    LKR,

    /**
     * Maltese Lira: Malta
     * 
     */
    MTL,

    /**
     * Guinea Franc: Guinea
     * 
     */
    GNF,

    /**
     * Lari: Georgia
     * 
     */
    GEL,

    /**
     * Timor Escudo: East Timor
     * 
     */
    TPE,

    /**
     * Liberian Dollar: Liberia
     * 
     */
    LRD,

    /**
     * Latvian Lats: Latvia
     * 
     */
    LVL,

    /**
     * Seychelles Rupee: Seychelles
     * 
     */
    SCR,

    /**
     * French Franc: Andorra, France, French Guiana, French Southern Territories, Guadeloupe, Martinique, Monaco, Reunion, St Pierre and Miquelon
     * 
     */
    FRF,

    /**
     * Mexican Peso: Mexico
     * 
     */
    MXN,

    /**
     * Gold-Franc: Special settlement currencies
     * 
     */
    XFO,

    /**
     * Drachma: Greece
     * 
     */
    GRD,

    /**
     * Moroccan Dirham: Morocco, Western Sahara
     * 
     */
    MAD,

    /**
     * Tunisian Dinar: Tunisia
     * 
     */
    TND,

    /**
     * Kwacha: Malawi
     * 
     */
    MWK,

    /**
     * Silver: Bond Markets Units
     * 
     */
    XAG,

    /**
     * CFP Franc: French Polynesia, New Caledonia, Wallis and Futuna Islands
     * 
     */
    XPF,

    /**
     * Yen: Japan
     * 
     */
    JPY,

    /**
     * Leone: Sierra Leone
     * 
     */
    SLL,

    /**
     * Afghani: Afghanistan
     * 
     */
    AFA,

    /**
     * Malaysian Ringgit: Malaysia
     * 
     */
    MYR,

    /**
     * Kina: Papua New Guinea
     * 
     */
    PGK,

    /**
     * Naira: Nigeria
     * 
     */
    NGN,

    /**
     * Dobra: Sao Tome and Principe
     * 
     */
    STD,

    /**
     * Kwacha: Zambia
     * 
     */
    ZMK,

    /**
     * East Caribbean Dollar: Anguilla, Antigua and Barbuda, Dominica, Grenada, Montserrat, St Kitts - Nevis, Saint Lucia, Saint Vincent and The Grenadines
     * 
     */
    XCD,

    /**
     * Convertible Marks: Bosnia and Herzegovina
     * 
     */
    BAM,

    /**
     * European Monetary Unit (E.M.U.-6): Bond Markets Units
     * 
     */
    XBB,

    /**
     * Gibraltar Pound: Gibraltar
     * 
     */
    GIP,

    /**
     * Costa Rican Colon: Costa Rica
     * 
     */
    CRC,

    /**
     * Manat: Turkmenistan
     * 
     */
    TMM,

    /**
     * Kenyan Shilling: Kenya
     * 
     */
    KES,

    /**
     * Euro: 
     * 
     */
    EUR,

    /**
     * New Taiwan Dollar: Taiwan, Province Of China
     * 
     */
    TWD,

    /**
     * Saudi Riyal: Saudi Arabia
     * 
     */
    SAR,

    /**
     * Pula: Botswana
     * 
     */
    BWP,

    /**
     * Iraqi Dinar: Iraq
     * 
     */
    IQD,

    /**
     * Canadian Dollar: Canada
     * 
     */
    CAD,

    /**
     * Swiss Franc: Liechtenstein, Switzerland
     * 
     */
    CHF,

    /**
     * Balboa: Panama
     * 
     */
    PAB,

    /**
     * Pound Sterling: United Kingdom
     * 
     */
    GBP,

    /**
     * Colombian Peso: Colombia
     * 
     */
    COP,

    /**
     * New Israeli Sheqel: Israel
     * 
     */
    ILS,

    /**
     * CFA Franc BEAC: Cameroon, Central African Republic, Chad, Congo, Equatorial Guinea, Gabon
     * 
     */
    XAF,

    /**
     * Cordoba Oro: Nicaragua
     * 
     */
    NIO,

    /**
     * Spanish Peseta: Andorra, Spain
     * 
     */
    ESP,

    /**
     * Jordanian Dinar: Jordan
     * 
     */
    JOD,

    /**
     * Dong: Vietnam
     * 
     */
    VND,

    /**
     * Libyan Dinar: Libyan Arab Jamahiriya
     * 
     */
    LYD,

    /**
     * Solomon Islands Dollar: Solomon Islands
     * 
     */
    SBD,

    /**
     * Metical: Mozambique
     * 
     */
    MZM,

    /**
     * Kroon: Estonia
     * 
     */
    EEK,

    /**
     * (Same day): United States
     * 
     */
    USS,

    /**
     * Algerian Dinar: Algeria
     * 
     */
    DZD,

    /**
     * Lebanese Pound: Lebanon
     * 
     */
    LBP,

    /**
     * Belgian Franc: Belgium
     * 
     */
    BEF,

    /**
     * (financial Rand): Lesotho
     * 
     */
    ZAL,

    /**
     * Chilean Peso: Chile
     * 
     */
    CLP,

    /**
     * Uganda Shilling: Uganda
     * 
     */
    UGX,

    /**
     * Kuna: Croatia
     * 
     */
    HRK,

    /**
     * Belize Dollar: Belize
     * 
     */
    BZD,

    /**
     * Bahamian Dollar: Bahamas
     * 
     */
    BSD,

    /**
     * Kip: Lao People's Democratic Republic
     * 
     */
    LAK,

    /**
     * Leu: Romania
     * 
     */
    ROL,

    /**
     * Taka: Bangladesh
     * 
     */
    BDT,

    /**
     * Kyat: Myanmar
     * 
     */
    MMK,

    /**
     * Cyprus Pound: Cyprus
     * 
     */
    CYP,

    /**
     * Palladium: Bond Markets Units
     * 
     */
    XPD,

    /**
     * Mexican Unidad de Inversion (UDI): Mexico
     * 
     */
    MXV,

    /**
     * Hong Kong Dollar: Hong Kong
     * 
     */
    HKD,

    /**
     * Somali Shilling: Somalia
     * 
     */
    SOS,

    /**
     * Kuwaiti Dinar: Kuwait
     * 
     */
    KWD,

    /**
     * Won: Korea, Republic Of
     * 
     */
    KRW,

    /**
     * Nuevo Sol: Peru
     * 
     */
    PEN,

    /**
     * New Kwanza: Angola
     * 
     */
    AON,

    /**
     * Bulgarian LEV: Bulgaria
     * 
     */
    BGN,

    /**
     * Aruban Guilder: Aruba
     * 
     */
    AWG,

    /**
     * Franc Congolais: Congo, The Democratic Republic Of
     * 
     */
    CDF,

    /**
     * Hryvnia: Ukraine
     * 
     */
    UAH,

    /**
     * Netherlands Guilder: Netherlands
     * 
     */
    NLG,

    /**
     * Brazilian Real: Brazil
     * 
     */
    BRL,

    /**
     * Peso Uruguayo: Uruguay
     * 
     */
    UYU,

    /**
     * Rufiyaa: Maldives
     * 
     */
    MVR,

    /**
     * Luxembourg Franc: Luxembourg
     * 
     */
    LUF,

    /**
     * Tajik Ruble (old): Tajikistan (Old)
     * 
     */
    TJR,

    /**
     * Deutsche Mark: Germany
     * 
     */
    DEM,

    /**
     * Pound: Falkland Islands (Malvinas)
     * 
     */
    FKP,

    /**
     * Yemeni Rial: Yemen
     * 
     */
    YER,

    /**
     * Comoro Franc: Comoros
     * 
     */
    KMF,

    /**
     * Singapore Dollar: Singapore
     * 
     */
    SGD,

    /**
     * Azerbaijanian Manat: Azerbaijan
     * 
     */
    AZM,

    /**
     * Antillian Guilder: Netherlands Antilles
     * 
     */
    ANG,

    /**
     * CFA Franc BCEAO: Benin, Burkina Faso, Cote D'ivoire, Guinea-Bissau, Mali, Niger, Senegal, Togo
     * 
     */
    XOF,

    /**
     * Lilangeni: Swaziland
     * 
     */
    SZL,

    /**
     * Loti: Lesotho
     * 
     */
    LSL,

    /**
     * Czech Koruna: Czech Republic
     * 
     */
    CZK,

    /**
     * SDR: International Monetary Fund (Imf)
     * 
     */
    XDR,

    /**
     * Sucre: Ecuador
     * 
     */
    ECS,

    /**
     * Platinum: Bond Markets Units
     * 
     */
    XPT,

    /**
     * Yuan Renminbi: China
     * 
     */
    CNY,

    /**
     * El Salvador Colon: El Salvador
     * 
     */
    SVC,

    /**
     * Burundi Franc: Burundi
     * 
     */
    BIF,

    /**
     * Cuban Peso: Cuba
     * 
     */
    CUP,

    /**
     * Cayman Islands Dollar: Cayman Islands
     * 
     */
    KYD,

    /**
     * Rupiah: East Timor, Indonesia
     * 
     */
    IDR,

    /**
     * Guarani: Paraguay
     * 
     */
    PYG,

    /**
     * Norwegian Krone: Bouvet Island, Norway, Svalbard and Jan Mayen Islands
     * 
     */
    NOK,

    /**
     * Ouguiya: Mauritania
     * 
     */
    MRO,

    /**
     * Argentine Peso: Argentina
     * 
     */
    ARS,

    /**
     * Portuguese Escudo: Portugal
     * 
     */
    PTE,

    /**
     * Fiji Dollar: Fiji
     * 
     */
    FJD,

    /**
     * Surinam Guilder: Suriname
     * 
     */
    SRG,

    /**
     * Rial Omani: Oman
     * 
     */
    OMR,

    /**
     * Turkish Lira: Turkey
     * 
     */
    TRL,

    /**
     * Slovak Koruna: Slovakia
     * 
     */
    SKK,

    /**
     * Denar: Macedonia, The Former Yugoslav Republic Of
     * 
     */
    MKD,

    /**
     * Ethiopian Birr: Ethiopia
     * 
     */
    ETB,

    /**
     * Namibia Dollar: Namibia
     * 
     */
    NAD,

    /**
     * Bermudian Dollar: Bermuda
     * 
     */
    BMD,

    /**
     * Rand: Lesotho, Namibia, South Africa
     * 
     */
    ZAR,

    /**
     * US Dollar: American Samoa, British Indian Ocean Territory,, Guam, Haiti, Marshall Islands, Micronesia, Northern Mariana Islands, Palau, Panama, Puerto Rico, Turks and Caicos Islands, United States, United States Minor Outlaying Islands, Virgin Islands (British), Virgin Islands (U.S.)
     * 
     */
    USD,

    /**
     * Lek: Albania
     * 
     */
    ALL,

    /**
     * Rwanda Franc: Rwanda
     * 
     */
    RWF,

    /**
     * Tolar: Slovenia
     * 
     */
    SIT,

    /**
     * UAE Dirham: United Arab Emirates
     * 
     */
    AED,

    /**
     * Qatari Rial: Qatar
     * 
     */
    QAR,

    /**
     * Russian Ruble: Russian Federation
     * 
     */
    RUR,

    /**
     * Belarussian Ruble: Belarus
     * 
     */
    BYR,

    /**
     * New Zealand Dollar: Cook Islands, New Zealand, Niue, Pitcairn, Tokelau
     * 
     */
    NZD,

    /**
     * Tugrik: Mongolia
     * 
     */
    MNT,

    /**
     * Iranian Rial: Iran (Islamic Republic Of)
     * 
     */
    IRR,

    /**
     * Vatu: Vanuatu
     * 
     */
    VUV,

    /**
     * Swedish Krona: Sweden
     * 
     */
    SEK,

    /**
     * Moldovan Leu: Moldova, Republic Of
     * 
     */
    MDL,

    /**
     * Syrian Pound: Syrian Arab Republic
     * 
     */
    SYP,

    /**
     * Indian Rupee: Bhutan, India
     * 
     */
    INR,

    /**
     * Lempira: Honduras
     * 
     */
    HNL,

    /**
     * Forint: Hungary
     * 
     */
    HUF,

    /**
     * Nepalese Rupee: Nepal
     * 
     */
    NPR,

    /**
     * Baht: Thailand
     * 
     */
    THB,

    /**
     * Guinea-Bissau Peso: Guinea-Bissau
     * 
     */
    GWP,

    /**
     * Zloty: Poland
     * 
     */
    PLN,

    /**
     * Danish Krone: Denmark, Faeroe Islands, Greenland
     * 
     */
    DKK,

    /**
     * Lithuanian Litas: Lithuania
     * 
     */
    LTL,

    /**
     * Iceland Krona: Iceland
     * 
     */
    ISK,

    /**
     * Cedi: Ghana
     * 
     */
    GHC,

    /**
     * New Zaire: Zaire
     * 
     */
    ZRN,

    /**
     * Egyptian Pound: Egypt
     * 
     */
    EGP,

    /**
     * Bolivar: Venezuela
     * 
     */
    VEB,

    /**
     * European Composite Unit (EURCO): Bond Markets Units
     * 
     */
    XBA,

    /**
     * Markka: Finland
     * 
     */
    FIM,

    /**
     * Armenian Dram: Armenia
     * 
     */
    AMD,

    /**
     * Som: Kyrgyzstan
     * 
     */
    KGS,

    /**
     * Lev: Bulgaria
     * 
     */
    BGL,

    /**
     * UIC-Franc: Special settlement currencies
     * 
     */
    XFU,

    /**
     * Djibouti Franc: Djibouti
     * 
     */
    DJF,

    /**
     * Bahraini Dinar: Bahrain
     * 
     */
    BHD,

    /**
     * Australian Dollar: Australia, Christmas Island, Cocos (Keeling) Islands, Heard and Mcdonald Islands, Kiribati, Nauru, Norfolk Island, Tuvalu
     * 
     */
    AUD,

    /**
     * Philippine Peso: Philippines
     * 
     */
    PHP,

    /**
     * Brunei Dollar: Brunei Darussalam
     * 
     */
    BND,

    /**
     * (Next day): United States
     * 
     */
    USN,

    /**
     * Malagasy Franc: Madagascar
     * 
     */
    MGF,

    /**
     * Ngultrum: Bhutan
     * 
     */
    BTN,

    /**
     * The codes assigned for transactions where no currency is involved are:: 
     * 
     */
    XXX;

    public String value() {
        return name();
    }

    public static CurrencyCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
