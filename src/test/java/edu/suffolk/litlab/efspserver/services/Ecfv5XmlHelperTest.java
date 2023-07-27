package edu.suffolk.litlab.efspserver.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.junit.jupiter.api.Test;

import edu.suffolk.litlab.efspserver.ecf5.Ecf5Helper;
import gov.niem.release.niem.niem_core._4.DateType;

public class Ecfv5XmlHelperTest {

  private static String stringFromXmlDate(DateType date) {
    String xmlStr = Ecf5Helper.objectToXmlStrOrError(date, DateType.class);

    System.out.println(xmlStr);
    // Just grab the string in the date time element.
    return xmlStr.split(":DateTime>")[1].split("</")[0];
  }
  
  @Test
  public void testConvertDate() {
    OffsetDateTime now = OffsetDateTime.of(2021, 12, 8, 16, 32, 58, 123456789, ZoneOffset.UTC); 
    String reserveDate = stringFromXmlDate(Ecf5Helper.convertCourtReserveDate(now, 1)); 
    
    // Tyler has a very specific way that it wants the timestamp to look:
    // Exactly one decimal place for seconds
    assertEquals("2021-12-08", reserveDate.split("T")[0]); 
    assertEquals("16:32:58.1Z", reserveDate.split("T")[1]); 
    
    Instant inst = Instant.ofEpochMilli(1638983486955l);
    String postDate = stringFromXmlDate(Ecf5Helper.convertDateTime(inst, 0));
    
    assertEquals("2021-12-08", postDate.split("T")[0]);
    // No milliseconds and UTC is important
    assertEquals("17:11:26Z", postDate.split("T")[1]);
  }
  
}
