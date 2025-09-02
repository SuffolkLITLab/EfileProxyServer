package edu.suffolk.litlab.efsp.server.auth;

import com.fasterxml.jackson.databind.JsonNode;
import edu.suffolk.litlab.efsp.db.LoginDatabase;
import edu.suffolk.litlab.efsp.db.model.AtRest;
import edu.suffolk.litlab.efsp.db.model.NewTokens;
import edu.suffolk.litlab.efsp.tyler.TylerEnv;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Language might be loose, but we try to use "Key" as a permanent string (keep it secret!) that you
 * use to authenticate with some system. Kinda like a username and password, but combined as one
 * piece of info, not two.
 *
 * <p>"Token" on the other hand, holds the same purpose, but is ephemeral, and not intended to be
 * saved for a long time. The login token is generated when the server receives an api key, and the
 * client should use the token for subsequent logins, not the key.
 *
 * @author litlab
 */
public class SecurityHub {
  private static final Logger log = LoggerFactory.getLogger(SecurityHub.class);

  private final List<LoginInterface> tylerLoginObjs;
  private final LoginInterface jeffNetLoginObj;
  private final Map<String, Function<JsonNode, Optional<Map<String, String>>>> loginFunctions;
  private final Supplier<LoginDatabase> ldSupplier;

  /**
   * @param ldSupplier Gives connections to the login-related SQL tables
   * @param env the running environment, i.e. which Tyler instance to connect to, "stage" vs "prod"
   * @param jurisdictions a list of Tyler jurisdictions to connect to. See SoapClientChooser.
   */
  public SecurityHub(
      Supplier<LoginDatabase> ldSupplier, Optional<TylerEnv> env, List<String> jurisdictions) {
    this.ldSupplier = ldSupplier;
    if (env.isEmpty() || jurisdictions.isEmpty()) {
      this.tylerLoginObjs = List.of();
    } else {
      this.tylerLoginObjs =
          jurisdictions.stream()
              .map(j -> new TylerLogin(j, env.get()))
              .collect(Collectors.toList());
    }
    this.jeffNetLoginObj = new JeffNetLogin();

    this.loginFunctions =
        Stream.concat(this.tylerLoginObjs.stream(), Stream.of(this.jeffNetLoginObj))
            .collect(Collectors.toMap(lo -> lo.getLoginName(), lo -> (info) -> lo.login(info)));
  }

  /**
   * Actually completes the REST client's login to the server. Completes each login to the EFMFiling
   * Interfaces separately.
   *
   * @param apiKey The api key that the server can use for logging in
   * @param loginInfo The JSON object with login info for whatever modules it's wants to login to
   * @return If the optional is empty, the apikey or one of the attempted logins failed. If not
   *     empty, it contains the new API Tokens that the REST client should now send to the Server,
   *     or an empty token list (which happens when querying Tyler code endpoints before the user is
   *     logged in). For example, TYLER-TOKEN will have the provided Tyler email + ":" + password
   *     Hash, used to authenticate the user.
   */
  public Optional<NewTokens> login(String apiKey, JsonNode loginInfo) {
    log.info("Testing login");
    Optional<AtRest> maybeAtRest = Optional.empty();
    try (LoginDatabase ld = ldSupplier.get()) {
      maybeAtRest = ld.getAtRestInfo(apiKey);
    } catch (SQLException e) {
      log.error("SQL error when logging in: ", e);
      return Optional.empty();
    }
    if (maybeAtRest.isEmpty()) {
      log.error("No server associated with the given API key");
      return Optional.empty();
    }

    AtRest atRest = maybeAtRest.get();

    // TODO(brycew-later): the only hacky part, how can this be modulized?
    if (!loginInfo.isObject()) {
      log.error("Can't login with a json that's not an object: {}", loginInfo.toPrettyString());
      return Optional.empty();
    }
    var newTokens = new HashMap<String, String>();
    Iterable<String> orgs = loginInfo::fieldNames;
    for (String orgName : orgs) {
      orgName = orgName.toLowerCase();
      if (orgName.equalsIgnoreCase("api_key")) {
        continue;
      }
      // TODO(brycew): feels hacky, but we don't want an additional column to the db for each new
      // jurisdiction
      if (!loginFunctions.containsKey(orgName)) {
        log.error(
            "There is no {} to login to: loginFunctions: {}", orgName, loginFunctions.keySet());
        return Optional.empty();
      }

      String permissionsName = orgName;
      if (orgName.contains("-")) {
        permissionsName = orgName.split("-")[0];
      }
      if (!atRest.enabled.containsKey(permissionsName) || !atRest.enabled.get(permissionsName)) {
        log.error("There is no {} to login to: enabled map: {}", permissionsName, atRest.enabled);
        return Optional.empty();
      }
      Optional<Map<String, String>> maybeNewTokens =
          loginFunctions.get(orgName).apply(loginInfo.get(orgName));
      if (maybeNewTokens.isEmpty()) {
        log.warn("Couldn't login to {}", orgName);
        return Optional.empty();
      }
      log.info("New tokens for {}", orgName);
      newTokens.putAll(maybeNewTokens.get());
    }
    if (newTokens.isEmpty()) {
      log.warn("No successful logins occurred: returning empty tokens object");
    }
    return Optional.of(new NewTokens(newTokens));
  }
}
