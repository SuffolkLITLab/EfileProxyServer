package edu.suffolk.litlab.efspserver.services;

import org.shredzone.acme4j.challenge.Http01Challenge;

/** A class that handles Letsencrypt challenges by publishing an ACME token and
 * content for a Http01 challenge.
 */
public interface AcmeChallengePublisher {

  public default boolean setTokenContent(Http01Challenge challenge) {
    return setTokenContent(challenge.getToken(), challenge.getAuthorization());
  }

  public boolean setTokenContent(String token, String content);

  /** Remove the token content, as it shouldn't stay up for too long. */
  public boolean removeTokenContent();
}