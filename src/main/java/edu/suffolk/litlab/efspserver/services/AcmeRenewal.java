package edu.suffolk.litlab.efspserver.services;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.security.KeyPair;
import java.security.Security;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.shredzone.acme4j.Account;
import org.shredzone.acme4j.AccountBuilder;
import org.shredzone.acme4j.Authorization;
import org.shredzone.acme4j.Certificate;
import org.shredzone.acme4j.Order;
import org.shredzone.acme4j.Session;
import org.shredzone.acme4j.Status;
import org.shredzone.acme4j.challenge.Http01Challenge;
import org.shredzone.acme4j.exception.AcmeException;
import org.shredzone.acme4j.util.CSRBuilder;
import org.shredzone.acme4j.util.KeyPairUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcmeRenewal {

  private static final File USER_KEY_FILE = new File("acme_user.key");
  private static final File DOMAIN_KEY_FILE = new File("acme_domain.key");
  private static final File DOMAIN_CSR_FILE = new File("acme_domain.csr");
  private static final File DOMAIN_CHAIN_FILE = new File("acme_domain-chain.crt");

  // RSA key size of the generated key pairs
  private static final int KEY_SIZE = 2048;

  private static Logger log =
      LoggerFactory.getLogger(AcmeRenewal.class);

  private KeyPair loadOrCreateUserKeyPair() throws IOException {
    if (USER_KEY_FILE.exists()) {
      try (FileReader fr = new FileReader(USER_KEY_FILE)) {
        return KeyPairUtils.readKeyPair(fr);
      }
    } else {
      KeyPair userKeyPair = KeyPairUtils.createKeyPair(KEY_SIZE);
      try (FileWriter fw = new FileWriter(USER_KEY_FILE)) {
        KeyPairUtils.writeKeyPair(userKeyPair, fw);
      }
      return userKeyPair;
    }
  }

  private KeyPair loadOrCreateDomainKeyPair() throws IOException {
    if (DOMAIN_KEY_FILE.exists()) {
      try (FileReader fr = new FileReader(DOMAIN_KEY_FILE)) {
        return KeyPairUtils.readKeyPair(fr);
      }
    } else {
      KeyPair domainKeyPair = KeyPairUtils.createKeyPair(KEY_SIZE);
      try (FileWriter fw = new FileWriter(DOMAIN_KEY_FILE)) {
        KeyPairUtils.writeKeyPair(domainKeyPair, fw);
      }
      return domainKeyPair;
    }
  }


  public void fetchCertificate(Collection<String> domains, AcmeChallengePublisher publisher) throws IOException, AcmeException {
    KeyPair userKeyPair = loadOrCreateUserKeyPair();

    Session session = new Session("acme://letsencrypt.org/staging");

    // If there is no account yet, create a new one
    Account acct = findOrRegisterAccount(session, userKeyPair);

    // This should not be the userKeyPair!
    KeyPair domainKeyPair = loadOrCreateDomainKeyPair();

    Order order = acct.newOrder().domains(domains).create();

    for (Authorization auth: order.getAuthorizations()) {
      authorize(auth, publisher);
    }

    CSRBuilder csrb = new CSRBuilder();
    csrb.addDomains(domains);
    csrb.sign(domainKeyPair);

    try (Writer out = new FileWriter(DOMAIN_CSR_FILE)) {
      csrb.write(out);
    }

    order.execute(csrb.getEncoded());

    try {
      int attempts = 10;
      while (order.getStatus() != Status.VALID && attempts > 0) {
        attempts -= 1;
        if (order.getStatus() == Status.INVALID) {
          log.error("Order has failed, reason: {}", order.getError());
          throw new AcmeException("Order failed, giving up");
        }

        Thread.sleep(3000L);
        order.update();
      }
    } catch (InterruptedException ex) {
      log.error("interrupted", ex);
      Thread.currentThread().interrupt();
    }

    Certificate certificate = order.getCertificate();
    log.info("Success! The certificate for domains {} has been generated!", domains);
    log.info("Certificate URL: {}", certificate.getLocation());
    try (FileWriter fw = new FileWriter(DOMAIN_CHAIN_FILE)) {
      certificate.writeCertificate(fw);
    }
    // Additionally TODO(brycew):
    // * cat ca-bundle (?) and crt together to make combined crt (?)
    // * openssl to make the combined crt and key into a p12
    // * keytool to make the combined p12 into a JKS (the final product)
    // * (optionally) keytool to export the cert from the jks (alias 1) to a cert.pem to openssl verify
  }

  public Account findOrRegisterAccount(Session session, KeyPair accountKey) throws AcmeException {
    URI tos = session.getMetadata().getTermsOfService();
    if (tos != null) {
      if (!acceptAgreement(tos)) {
        throw new AcmeException("Didn't accept terms of service");
      }
    }
    Account account = new AccountBuilder()
      .agreeToTermsOfService()
      .useKeyPair(accountKey)
      .create(session);

    log.info("Registered a new user, URL: {}", account.getLocation());
    return account;
  }

  private boolean acceptAgreement(URI agreement) {
    // TODO(brycew): can we see if we're in an interactive mode?
    System.out.println("Do you accept the Terms of Service at: " + agreement.toString() + "? (y/n)");
    Scanner cliScanner = new Scanner(System.in);
    String userInput = cliScanner.nextLine().toLowerCase();
    cliScanner.close();
    if (userInput.equals("y") || userInput.equals("yes")) {
      return true;
    } else {
      System.out.print("Did not accept");
      return false;
    }
  }

  private void authorize(Authorization auth, AcmeChallengePublisher publisher) throws AcmeException {
    log.info("Authorization for domain: {}", auth.getIdentifier().getDomain());

    if (auth.getStatus() == Status.VALID) {
      return;
    }

    Http01Challenge challenge = auth.findChallenge(Http01Challenge.class);
    if (challenge == null) {
      throw new AcmeException("Found no " + Http01Challenge.TYPE + " challenge, don't know what to do...");
    }

    StringBuilder msg = new StringBuilder()
        .append("Commencing challenge! You must create a file in the server's base directory, at")
        .append("http://")
        .append(auth.getIdentifier().getDomain())
        .append("/.well-known/acme-challenge/")
        .append(challenge.getToken())
        .append(", with the content:\n\n")
        .append(challenge.getAuthorization());
    log.info(msg.toString());
    if (publisher != null) {
      log.info("Adding to server now...");
      publisher.setTokenContent(challenge);
    }

    // If the challenge is already verified, there's no need to execute it again.
    if (challenge.getStatus() == Status.VALID) {
      return;
    }

    challenge.trigger();

    try {
      int attempts = 10;
      while (challenge.getStatus() != Status.VALID && attempts > 0) {
        attempts -= 1;
        if (challenge.getStatus() == Status.INVALID) {
          log.error("Challenge has failed, reason: {}", challenge.getError());
          throw new AcmeException("Challenge failed, giving up");
        }

        Thread.sleep(3000L);
        challenge.update();
      }
    } catch (InterruptedException ex) {
      log.error("Interrupted", ex);
      Thread.currentThread().interrupt();
    }

    if (challenge.getStatus() != Status.VALID) {
      throw new AcmeException("Failed to pass the challenge for domain " + auth.getIdentifier().getDomain() + ", giving up");
    }

    log.info("Challenge completed!");
    publisher.removeTokenContent();
  }


  /** Can be run on it's own: writes the token content to be used in two 
   * different files that are independently read by the Acme service.
   * 
   * Run with `mvn exec:java@AcmeRenewal -Dexec.args="efile.suffolklitlab.edu"`.
   * @throws AcmeException
   * @throws IOException */
  public static void main(String... args) throws IOException, AcmeException {
    if (args.length == 0) {
      log.error("Usage: AcmeRenewal <domain>...");
      System.exit(1);
    }
    Security.addProvider(new BouncyCastleProvider());
    AcmeRenewal renewal = new AcmeRenewal();
    AcmeChallengePublisher publisher = new AcmeChallengeWriter();
    renewal.fetchCertificate(Arrays.asList(args), publisher);
  }
}
