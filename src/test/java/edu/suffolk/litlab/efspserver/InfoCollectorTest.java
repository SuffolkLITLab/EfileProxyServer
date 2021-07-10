package edu.suffolk.litlab.efspserver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.suffolk.litlab.efspserver.services.ExtractError;
import edu.suffolk.litlab.efspserver.services.FailFastCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InfoCollectorTest {
  
  @Test
  public void testfailFastShouldFailOnFirstVar() {
    FailFastCollector collector = new FailFastCollector();
    assertFalse(collector.finished());
    
    InterviewVariable var = new InterviewVariable("fake_var", "", "text", List.of());
    collector.addOptional(var);
    assertFalse(collector.finished());
    InterviewVariable var2 = new InterviewVariable("fake_var2", "", "text", List.of());
    collector.addRequired(var2);
    assertTrue(collector.finished());

    assertFalse(collector.okToSubmit());
  }
  
  @Test
  public void testfailFastShouldStopOnErr() {
    FailFastCollector collector = new FailFastCollector();
    ExtractError err = ExtractError.serverError("fake error");
    collector.error(err);
    assertTrue(collector.finished());
    assertFalse(collector.okToSubmit());
  }

}
