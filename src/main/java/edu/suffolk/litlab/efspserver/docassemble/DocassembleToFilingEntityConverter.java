package edu.suffolk.litlab.efspserver.docassemble;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.hubspot.algebra.Result;
import com.opencsv.exceptions.CsvValidationException;
import edu.suffolk.litlab.efspserver.Address;
import edu.suffolk.litlab.efspserver.Filing;
import edu.suffolk.litlab.efspserver.FilingStuff;
import edu.suffolk.litlab.efspserver.LegalIssuesTaxonomyCodes;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.services.ExtractError;
import edu.suffolk.litlab.efspserver.services.InterviewToFilingEntityConverter;
import edu.suffolk.litlab.efspserver.services.JsonExtractException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class DocassembleToFilingEntityConverter implements InterviewToFilingEntityConverter {

  private static Logger log = Logger.getLogger("mylogger"); 
  private LegalIssuesTaxonomyCodes codes;
  
  public DocassembleToFilingEntityConverter(InputStream taxonomyCsv) 
      throws CsvValidationException, IOException {
    codes = new LegalIssuesTaxonomyCodes(taxonomyCsv);
  }

  @Override
  public Result<FilingStuff, ExtractError> extractEntities(String interviewContents) {
    SimpleModule module = new SimpleModule();
    module.addDeserializer(Filing.class, new FilingDocassembleJacksonDeserializer(Filing.class)); 
    module.addDeserializer(Address.class, new AddressDocassembleJacksonDeserializer(Address.class));
    module.addDeserializer(Person.class, new PersonDocassembleJacksonDeserializer(Person.class));
    module.addDeserializer(FilingStuff.class, 
        new FilingStuffDocassembleJacksonDeserializer(FilingStuff.class, codes));
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(module);
    try {
      FilingStuff entities = mapper.readValue(interviewContents, FilingStuff.class);
      if (entities == null) {
        return Result.err(new ExtractError(ExtractError.Type.MalformedInterview));
      }
      return Result.ok(entities);  
    } catch (JsonExtractException ex) {
      log.warning("Got extract Exception: " + ex);
      return Result.err(ex.getError());
    } catch (JsonProcessingException ex) {
      log.warning("Parsing Exception: " + ex);
      return Result.err(new ExtractError(ExtractError.Type.MalformedInterview));
    }
  }

}
