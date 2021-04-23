package edu.suffolk.assemblyline.efspserver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.oasis_open.docs.codelist.ns.genericode._1.CodeListDocument;
import org.oasis_open.docs.codelist.ns.genericode._1.Column;
import org.oasis_open.docs.codelist.ns.genericode._1.Key;
import org.oasis_open.docs.codelist.ns.genericode._1.Row;
import org.oasis_open.docs.codelist.ns.genericode._1.Value;

public class CodeDownloader {
  
  /**
   * https://stackoverflow.com/a/1485730/11416267
   *
   * @return
   */
  public InputStream getHtml(String urlToRead, String authHeader) throws Exception {
    URL url = new URL(urlToRead);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("tyl-efm-api", authHeader);
    return conn.getInputStream();
  }

  public void download(String baseUrl) throws Exception {
    HeaderSigner signer = new HeaderSigner();
    String signedTime = signer.signedCurrentTime();
    // TODO(brycew): make this an env variable somehow
    //String baseUrl = "https://illinois-stage.tylerhost.net";
    List<String> codeUrls = Arrays.asList(
        "/CodeService/codes/version/",
        "/CodeService/codes/location/",
        // NOTE: the Tyler docs say this is available from `GetPolicy'. That is wrong.
        "/CodeService/codes/error",
        // NOTE: the below URLs seem to be available both with and without the court code
        // at the end. 
        // TODO(brycew): can tell if court codes will differ if they have a Row in Version codes
        // where the simple value differs from the "0" Row. Need to check both
        "/CodeService/codes/country/",
        "/CodeService/codes/state/",
        "/CodeService/codes/filingstatus/", 
        "/CodeService/codes/datafield/"
        );
    
    List<String> courtURLs = Arrays.asList(
        "/codeservice/codes/casecategory/",
        "/codeservice/codes/casetype/",
        "/codeservice/codes/damageamount/",
        "/codeservice/codes/disclaimerrequirement/",
        "/codeservice/codes/documenttype/",
        "/codeservice/codes/filertype/",
        "/codeservice/codes/filing/",
        "/codeservice/codes/filingcomponent/",
        "/codeservice/codes/optionalservice/",
        "/codeservice/codes/partytype/",
        "/codeservice/codes/procedureremedy/",
        "/codeservice/codes/state/",
        "/codeservice/codes/filingstatus/",
        "/codeservice/codes/namesuffix/",
        "/codeservice/codes/datafield/",
        "/codeservice/codes/servicetype/",
        "/codeservice/codes/filetype/",
        "/codeservice/codes/arrestlocation/",
        "/codeservice/codes/bond/",
        "/codeservice/codes/degree/",
        "/codeservice/codes/lawenforcementunit/",
        "/codeservice/codes/crossreference/",
        "/codeservice/codes/generaloffense/",
        "/codeservice/codes/statutetype/",
        "/codeservice/codes/statute/",
        "/codeservice/codes/language/",
        "/codeservice/codes/physicalfeature/",
        "/codeservice/codes/haircolor/",
        "/codeservice/codes/eyecolor/",
        "/codeservice/codes/ethnicity/",
        "/codeservice/codes/race/",
        "/codeservice/codes/casesubtype/",
        "/codeservice/codes/chargephase/",
        "/codeservice/codes/vehicletype/",
        "/codeservice/codes/vehiclemake/",
        "/codeservice/codes/vehiclecolor/",
        "/codeservice/codes/citationjurisdiction/",
        "/codeservice/codes/motiontype/",
        "/codeservice/codes/question/",
        "/codeservice/codes/answer/"
        );

    for (String urlSuffix : courtURLs) {
      InputStream urlStream = getHtml(baseUrl + urlSuffix + "/henderson/", signedTime); 
      // Write out the zip file
      FileOutputStream fileOut = new FileOutputStream("henderson_" + urlSuffix.replace('/', '_') + ".zip");
      long length = urlStream.transferTo(fileOut);
      System.out.println(length + " bytes transfered for " + urlSuffix);
    }
    
    //ZipFile z = new ZipFile();

    // TODO(brycew): use the version codes to check the checksums of each table, 
    // then see if we need to update
  }

  public static void main(String[] args) throws Exception {
    //readCodes();
    CodeDownloader cd = new CodeDownloader();
    cd.download("https://illinois-stage.tylerhost.net");
    /*
    List<String> codeUrls = Arrays.asList(
        "/CodeService/codes/version/",
        "/CodeService/codes/location/"
        );
    for (String urlSuffix : codeUrls) {
      ZipFile z = new ZipFile(urlSuffix.replace("/", "_") + ".zip");
      ZipEntry ze = z.entries().asIterator().next(); 
      z.getInputStream(ze);
    }
    */
  }
}
