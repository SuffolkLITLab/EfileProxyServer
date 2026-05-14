package edu.suffolk.litlab.efsp.utils;

import static com.hubspot.assertj.algebra.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class JsonHelpersTest {

  @Test
  public void shouldParseJsonObj() throws JacksonException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node =
        mapper.readTree(
            """
            {
              "87374": "99500"
            }
            """);
    var res = JsonHelpers.unwrapSimpleDict(node);
    assertThat(res).isOk();
    assertThat(res.unwrapOrElseThrow()).isPresent();
    var dict = res.unwrapOrElseThrow().get();
    assertThat(dict).hasSize(1);
    assertThat(dict).contains(Map.entry("87374", "99500"));
  }

  @Test
  public void shouldParseDADict() throws JacksonException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node =
        mapper.readTree(
            """
            {
              "_class" : "DADict",
              "elements": {
                "87374": "99502",
                "76343": "12345"
              }
            }
            """);
    var res = JsonHelpers.unwrapSimpleDict(node);
    assertThat(res).isOk();
    assertThat(res.unwrapOrElseThrow()).isPresent();
    var dict = res.unwrapOrElseThrow().get();
    assertThat(dict).hasSize(2);
    assertThat(dict).contains(Map.entry("87374", "99502"));
    assertThat(dict).contains(Map.entry("76343", "12345"));
  }
}
