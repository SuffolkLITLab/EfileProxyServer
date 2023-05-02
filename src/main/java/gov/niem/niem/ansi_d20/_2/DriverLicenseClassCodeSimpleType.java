
package gov.niem.niem.ansi_d20._2;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DriverLicenseClassCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="DriverLicenseClassCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="M"/&gt;
 *     &lt;enumeration value="B"/&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="A"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DriverLicenseClassCodeSimpleType")
@XmlEnum
public enum DriverLicenseClassCodeSimpleType {


    /**
     * Class "M" vehicles - Motorcycles, Mopeds, Motor-driven Cycles.
     * 
     */
    M,

    /**
     * Class "B" vehicles - any single vehicle with a GVWR of 26,001 or more pounds, or any such vehicle towing a vehicle not in excess of 10,000 pounds GVWR [49 CFR 383.91(a)(2)]. (Holders of a Class B license may, with the appropriate endorsement, operate all Class C vehicles).
     * 
     */
    B,

    /**
     * Class "C" vehicles - any single vehicle, or combination of vehicles, that meets neither the definition of Group A nor that of Group B, but that either is designed to transport 16 or more passengers including the driver, or is used in the transportation of materials found to be hazardous for the purposes of the Hazardous Materials Transportation Act and which require the motor vehicle to be placarded under the Hazardous Materials Regulations (49 CFR part 172, subpart F) [49 CFR 383.91(a)(3)].
     * 
     */
    C,

    /**
     * Class "A" vehicles - any combination of vehicles with a GCWR of 26,001 or more pounds, provided the GVWR of the vehicle(s) being towed is in excess of 10,000 pounds [49 CFR 383.91(a)(1)]. (Holders of a Class A license may, with the appropriate endorsement, operate all Class B & C vehicles).
     * 
     */
    A;

    public String value() {
        return name();
    }

    public static DriverLicenseClassCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
