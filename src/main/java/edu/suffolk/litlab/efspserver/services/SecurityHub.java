package edu.suffolk.litlab.efspserver.services;

import com.fasterxml.jackson.databind.JsonNode;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.db.LoginDatabase;
import edu.suffolk.litlab.efspserver.db.NewTokens;
import edu.suffolk.litlab.efspserver.jeffnet.JeffNetLogin;
import edu.suffolk.litlab.efspserver.tyler.TylerLogin;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.sql.DataSource;
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
  private final DataSource userDs;

  /**
   * @param userDs Gives connections to the user SQL table
   * @param env the running environment, i.e. which Tyler instance to connect to, "stage" vs "prod"
   * @param jurisdictions a list of Tyler jurisdictions to connect to. See SoapClientChooser.
   */
  public SecurityHub(DataSource userDs, Optional<String> env, List<String> jurisdictions) {
    this.userDs = userDs;
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
   * @param jsonLoginInfo The JSON string with login info for whatever modules it's wants to login
   *     to
   * @return A map of expected Headers that subsequent calls should have to their expected values.
   *     For example, TYLER-TOKEN will have the provided Tyler email + ":" + password Hash, used to
   *     authenticate the user.
   */
  public Optional<NewTokens> login(String apiKey, String jsonLoginInfo) {
    try (LoginDatabase ld = new LoginDatabase(userDs.getConnection())) {
      return ld.login(apiKey, jsonLoginInfo, loginFunctions);
    } catch (SQLException e) {
      log.error(StdLib.strFromException(e));
      return Optional.empty();
    }
  }
}
