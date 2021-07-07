package edu.suffolk.litlab.efspserver.docassemble;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.hubspot.algebra.Result;
import com.opencsv.exceptions.CsvValidationException;
import edu.suffolk.litlab.efspserver.Address;
import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.LegalIssuesTaxonomyCodes;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.services.ExtractError;
import edu.suffolk.litlab.efspserver.services.InterviewToFilingEntityConverter;
import edu.suffolk.litlab.efspserver.services.JsonExtractException;
import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DocassembleToFilingEntityConverter implements InterviewToFilingEntityConverter {

  private static Logger log = LoggerFactory.getLogger(DocassembleToFilingEntityConverter.class); 
  private LegalIssuesTaxonomyCodes codes;
  
  public DocassembleToFilingEntityConverter(InputStream taxonomyCsv) 
      throws CsvValidationException, IOException {
    codes = new LegalIssuesTaxonomyCodes(taxonomyCsv);
  }

  @Override
  public Result<FilingInformation, ExtractError> extractEntities(String interviewContents) {
    SimpleModule module = new SimpleModule();
    module.addDeserializer(FilingDoc.class, 
        new FilingDocDocassembleJacksonDeserializer(FilingDoc.class)); 
    module.addDeserializer(Address.class, new AddressDocassembleJacksonDeserializer(Address.class));
    module.addDeserializer(Person.class, new PersonDocassembleJacksonDeserializer(Person.class));
    module.addDeserializer(FilingInformation.class, 
        new FilingInformationDocassembleJacksonDeserializer(FilingInformation.class, codes));
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(module);
    try {
      FilingInformation entities = mapper.readValue(interviewContents, FilingInformation.class);
      if (entities == null) {
        return Result.err(new ExtractError(ExtractError.Type.MalformedInterview));
      }
      return Result.ok(entities);  
    } catch (JsonExtractException ex) {
      log.warn("Got extract Exception: " + ex);
      return Result.err(ex.getError());
    } catch (JsonProcessingException ex) {
      log.warn("Parsing Exception: " + ex);
      return Result.err(new ExtractError(ExtractError.Type.MalformedInterview));
    }
  }

}
