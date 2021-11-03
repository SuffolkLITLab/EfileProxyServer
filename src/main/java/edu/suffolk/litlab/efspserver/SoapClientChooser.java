package edu.suffolk.litlab.efspserver;

import java.net.URL;
import java.util.Map;
import java.util.Optional;

import tyler.efm.services.EfmFirmService;
import tyler.efm.services.EfmUserService;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.CourtRecordMDEService;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.ServiceMDEService;

public class SoapClientChooser {

  static Map<String, String> efmUserWsdls = Map.of(
      "illinois-stage", "wsdl/EFMUserServiceSingle.svc.wsdl", 
      "illinois-test", "wsdl/test/EFMUserServiceSingle.svc.wsdl");

  static Map<String, String> efmFirmWsdls = Map.of(
      "illinois-stage", "wsdl/EFMFirmServiceSingle.svc.wsdl", 
      "illinois-test", "wsdl/test/EFMFirmServiceSingle.svc.wsdl"); 

  static Map<String, String> serviceMDEWsdls = Map.of(
      "illinois-stage", "wsdl/filingreview/ECF-4.0-ServiceMDEService.wsdl",
      "illinois-test", "wsdl/test/ECF-4.0-ServiceMDEService.wsdl");
  
  static Map<String, String> filingReviewMDEWsdls = Map.of(
      "illinois-stage", "wsdl/filingreview/ECF-4.0-FilingReviewMDEService.wsdl",
      "illinois-test", "wsdl/test/ECF-4.0-FilingReviewMDEService.wsdl");
  
  static Map<String, String> courtRecordMDEWsdls = Map.of(
      "illinois-stage", "wsdl/filingreview/ECF-4.0-CourtRecordMDEService.wsdl",
      "illinois-test", "wsdl/test/ECF-4.0-CourtRecordMDEService.wsdl");
  
  public static Optional<EfmUserService> getEfmUserFactory(String jurisdiction) {
    Optional<URL> url = urlFromString(jurisdiction, efmUserWsdls);
    if (url.isEmpty()) {
      return Optional.empty();
    } else {
      return Optional.of(new EfmUserService(url.get())); 
    }
  }

  public static Optional<EfmFirmService> getEfmFirmFactory(String jurisdiction) {
    Optional<URL> url = urlFromString(jurisdiction, efmFirmWsdls);
    if (url.isEmpty()) {
      return Optional.empty();
    } else {
      return Optional.of(new EfmFirmService(url.get())); 
    }
  }

  public static Optional<FilingReviewMDEService> getFilingReviewFactory(String jurisdiction) {
    Optional<URL> url = urlFromString(jurisdiction, filingReviewMDEWsdls);
    if (url.isEmpty()) {
      return Optional.empty();
    } else {
      return Optional.of(new FilingReviewMDEService(url.get())); 
    }
  }
  
  
  public static Optional<ServiceMDEService> getServiceFactory(String jurisdiction) {
    Optional<URL> url = urlFromString(jurisdiction, serviceMDEWsdls);
    if (url.isEmpty()) {
      return Optional.empty();
    } else {
      return Optional.of(new ServiceMDEService(url.get())); 
    }
  }
  
  public static Optional<CourtRecordMDEService> getCourtRecordFactory(String jurisdiction) {
    Optional<URL> url = urlFromString(jurisdiction, courtRecordMDEWsdls);
    if (url.isEmpty()) {
      return Optional.empty();
    } else {
      return Optional.of(new CourtRecordMDEService(url.get())); 
    }
  }
  private static Optional<URL> urlFromString(String jurisdiction, Map<String, String> jurisToWsdl) {
    if (!jurisToWsdl.containsKey(jurisdiction)) {
      return Optional.empty();
    }
    String wsdlPath = jurisToWsdl.get(jurisdiction);
    URL url = SoapClientChooser.class.getClassLoader().getResource(wsdlPath);
    if (url == null) {
      java.util.logging.Logger.getLogger(ServiceMDEService.class.getName())
             .log(java.util.logging.Level.INFO,
                 "Can not initialize the default wsdl from {0}", "classpath:" + wsdlPath); 
      return Optional.empty();
    }
    
    return Optional.of(url);
  }
}
