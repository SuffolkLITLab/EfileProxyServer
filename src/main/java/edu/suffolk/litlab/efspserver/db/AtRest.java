package edu.suffolk.litlab.efspserver.db;

import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

/** The type for the "at_rest" table for API Keys. API Key is not present in this object, 
 * so the hash never permanently leaves the database.
 *
 * @author brycew
 */
public class AtRest {
  public UUID serverId;
  public String serverName;
  public Timestamp created;
  public Map<String, Boolean> enabled;
}