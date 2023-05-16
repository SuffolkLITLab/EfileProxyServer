package edu.suffolk.litlab.efspserver.ecf5;

import java.util.Map;

public class XmlMaps {

  public final Map<String, Object> parties;
  public final Map<String, Object> attorneys;

  public XmlMaps(Map<String, Object> parties, Map<String, Object> attorneys) {
    this.parties = parties;
    this.attorneys = attorneys;
  }
}
