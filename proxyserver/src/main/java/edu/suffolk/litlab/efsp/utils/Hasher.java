package edu.suffolk.litlab.efsp.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.bouncycastle.util.encoders.Hex;

public class Hasher {

  /**
   * Returns a hash of the given input string. Used to hash user IDs and API keys (neither of which
   * need salt, as they're already random).
   */
  public static String makeHash(String input) {
    if (input == null) {
      return "";
    }

    try {
      var shaHasher = MessageDigest.getInstance("SHA-256");
      return new String(Hex.encode(shaHasher.digest(input.getBytes(StandardCharsets.UTF_8))));
    } catch (NoSuchAlgorithmException ex) {
      throw new AssertionError(ex);
    }
  }
}
