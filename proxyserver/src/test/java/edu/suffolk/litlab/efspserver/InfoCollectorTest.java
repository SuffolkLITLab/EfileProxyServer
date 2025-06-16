package edu.suffolk.litlab.efspserver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.suffolk.litlab.efspserver.services.AllWrongCollector;
import edu.suffolk.litlab.efspserver.services.FailFastCollector;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InfoCollectorTest {

  @Test
  public void testFailFastShouldFailOnFirstVar() {
    FailFastCollector collector = new FailFastCollector();
    assertFalse(collector.finished());

    InterviewVariable var = new InterviewVariable("fake_var", "", "text", List.of());
    collector.addOptional(var);
    assertFalse(collector.finished());
    InterviewVariable var2 = new InterviewVariable("fake_var2", "", "text", List.of());
    try {
      collector.addRequired(var2);
      fail("Should have thrown error");
    } catch (FilingError err) {
      // All good
    }
    assertTrue(collector.finished());

    assertFalse(collector.okToSubmit());
  }

  @Test
  public void testFailFastShouldStopOnErr() {
    FailFastCollector collector = new FailFastCollector();
    FilingError err = FilingError.serverError("fake error");
    try {
      collector.error(err);
      fail("Should have thrown Error");
    } catch (FilingError newErr) {
      // All good
    }
    assertTrue(collector.finished());
    assertFalse(collector.okToSubmit());
  }

  @Test
  public void testFailFastShouldTrackStack() {
    FailFastCollector collector = new FailFastCollector();
    try {
      collector.addRequired(collector.requestVar("hi", "", "text"));
      fail("Should have thrown filing error");
    } catch (FilingError err) {
      // N/A
    }
    collector.pushAttributeStack("one");
    collector.pushAttributeStack("two");
    collector.addOptional(collector.requestVar("bye", "", "text"));
    collector.popAttributeStack();
    collector.addOptional(collector.requestVar("and_again", "", "text"));
    assertEquals(collector.getRequired().size(), 1);
    assertEquals(collector.getRequired().get(0).getName(), "hi");
    assertEquals(collector.getOptional().size(), 2);
    assertEquals(collector.getOptional().get(0).getName(), "one.two.bye");
    assertEquals(collector.getOptional().get(1).getName(), "one.and_again");
  }

  @Test
  public void testAllWrongShouldGetAll() throws JsonMappingException, JsonProcessingException {
    AllWrongCollector collector = new AllWrongCollector();
    assertFalse(collector.finished());
    assertTrue(collector.okToSubmit());
    try {
      collector.addRequired(collector.requestVar("hi", "", "text"));
    } catch (FilingError e) {
      fail("Should NOT have thrown a filing error");
    }
    assertFalse(collector.finished());
    assertFalse(collector.okToSubmit());
    String json = collector.jsonSummary();
    ObjectMapper mapper = new ObjectMapper();
    // If it throws, it's not valid JSON
    mapper.readTree(json);

    try {
      collector.error(FilingError.serverError(""));
    } catch (FilingError err) {
      // Expected an error to be thrown!
    }
    assertTrue(collector.finished());
  }
}
