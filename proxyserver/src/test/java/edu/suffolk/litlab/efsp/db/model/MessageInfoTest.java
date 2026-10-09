package edu.suffolk.litlab.efsp.db.model;

import static org.assertj.core.api.Assertions.assertThat;

import edu.suffolk.litlab.efsp.stdlib.SensitiveInfo;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class MessageInfoTest {
  @Test
  public void testNullStuff() {
    var m1 = new MessageInfo(UUID.randomUUID(), null, (String) null, "Subject", null, null, null);

    assertThat(m1.sendgridApiKey()).isEmpty();
  }

  @Test
  public void testOverlay() {
    var m1 =
        new MessageInfo(UUID.randomUUID(), null, Optional.empty(), "Subject", null, null, null);
    var m2 = new MessageInfo(UUID.randomUUID(), "m2@example.com", "abc123", null, null, null, null);

    var overlay = m2.overlayOn(m1);
    assertThat(overlay.subjectLine()).isEqualTo("Subject");
    assertThat(overlay.fromEmail()).isEqualTo("m2@example.com");
    assertThat(overlay.sendgridApiKey()).isPresent().contains(new SensitiveInfo<>("abc123"));
  }

  @Test
  public void testSensitivePrinting() {
    var m1 = new MessageInfo(UUID.randomUUID(), null, "abc123", null, null, null, null);
    assertThat(m1.toString()).doesNotContain("abc123");
  }
}
