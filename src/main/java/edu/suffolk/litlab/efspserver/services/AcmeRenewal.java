package edu.suffolk.litlab.efspserver.services;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
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

import edu.suffolk.litlab.efspserver.StdLib;

/** Handles Renewing the Server's HTTPS / TLS certificates using the ACME protocol.
 * 
 * The full process is as follows:
 * - if not already present make a user public/private key pair (i.e. you, the org running the site)
 * - if not already present make a domain public/private key pair (specific to this site's domain)
 * - make a Certificate signing request (CSR) and send to let's encrypt
 *   - in the background, it also creates a special token that is available at a URL path known
 *     to Let's Encrypt that they use to verify we have control of the website at that domain
 * - get back a certificate chain (*.crt) from let's encrypt, showing that our domain public key is
 *   the approved key for our given domain
 * - save the domain private key and the *.crt as a Java Key Store (JKS) file. This is used by
 *   our server to serve the REST API over HTTPS
 */
public class AcmeRenewal {

  // RSA key size of the generated key pairs
  private static final int KEY_SIZE = 2048;

  private final static Logger log =
      LoggerFactory.getLogger(AcmeRenewal.class);

  /** Given that we are handling much of the certificate generation within the running container, 
   * if someone ever decides to restart the container, they would automatically lose their signed
   * certificates. So we save these certs outside the container to the volume, if it's present.
   */
  private static final File USER_KEY_FILE;
  private static final File DOMAIN_KEY_FILE;
  private static final File DOMAIN_CSR_FILE;
  private static final File DOMAIN_CHAIN_FILE;
  private static final File JSK_OUT_FILE_PATH;

  static {
    File dockerVolume = new File("/tmp/tls_certs");
    String prefix = "";
    if (dockerVolume.exists() && dockerVolume.isDirectory()) {
      prefix = "/tmp/tls_certs/";
    } else {
      log.warn("No docker volume at extected location (" + dockerVolume.getAbsolutePath()
          + "), only saving cert files inside container!");
    }
    USER_KEY_FILE = new File(prefix + "acme_user.key");
    DOMAIN_KEY_FILE = new File(prefix + "acme_domain.key");
    DOMAIN_CSR_FILE = new File(prefix + "acme_domain.csr");
    DOMAIN_CHAIN_FILE = new File(prefix + "acme_domain-chain.crt");
    JSK_OUT_FILE_PATH = new File(prefix + "tls_server_cert.jsk");
  }

  private static KeyPair loadOrCreateUserKeyPair() throws IOException {
    USER_KEY_FILE.getParentFile().mkdirs();
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

  private static KeyPair loadOrCreateDomainKeyPair() throws IOException {
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


  public void fetchCertificate(Collection<String> domains, AcmeChallengePublisher publisher, String certPassword) throws IOException, AcmeException {
    KeyPair userKeyPair = loadOrCreateUserKeyPair();

    Session session = new Session("acme://letsencrypt.org/");

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
    log.info("Writing things to a jks file");
    try (FileOutputStream fos = new FileOutputStream(JSK_OUT_FILE_PATH)) {
      fos.write(convertPEMToJKS(DOMAIN_KEY_FILE, DOMAIN_CHAIN_FILE, certPassword));
    } catch (Exception ex) {
      log.error("Error on cert conversion: " + StdLib.strFromException(ex));
    }
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

  private static void authorize(Authorization auth, AcmeChallengePublisher publisher) throws AcmeException, IOException {
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

  /** Converts certificate information from Let's Encrypt (plus our domain private key file) into
   * a java key store.
   * 
   * NOTE(brycew): keytool (since Java 9) says that "The JKS keystore uses a proprietary format.
   * It is recommended to migrate to PKCS12 which is an industry standard format". However, for some
   * reason the TLS for the site won't work with PKCS (even when using pre-signed namecheap certs, 
   * so it's not a new letsencrypt thing). Not sure how to progress.
   * 
   * From https://stackoverflow.com/a/58426371/11416267 
   * @throws NoSuchAlgorithmException
   * @throws IOException
   * @throws InvalidKeySpecException
   * @throws CertificateException
   * @throws KeyStoreException 
   */
  public static byte[] convertPEMToJKS(File keyFile, File certFile, String password) 
      throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, CertificateException, KeyStoreException {
    String alias = "alias";

    // Private Key
    PEMParser pem = new PEMParser(new FileReader(keyFile));
    Object parsedObject = pem.readObject();

    PrivateKeyInfo privateKeyInfo = parsedObject instanceof PEMKeyPair
        ? ((PEMKeyPair) parsedObject).getPrivateKeyInfo()
        : (PrivateKeyInfo) parsedObject;
    PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyInfo.getEncoded());
    KeyFactory factory = KeyFactory.getInstance("RSA");
    PrivateKey key = factory.generatePrivate(privateKeySpec);

    List<X509Certificate> certs = new ArrayList<>();
    X509CertificateHolder certHolder = (X509CertificateHolder) pem.readObject();
    if (certHolder != null) {
      certs.add(new JcaX509CertificateConverter().setProvider("BC").getCertificate(certHolder));
    }
    pem.close();

    // Certificate
    pem = new PEMParser(new FileReader(certFile));
    while ((certHolder = (X509CertificateHolder) pem.readObject()) != null) {
      certs.add(new JcaX509CertificateConverter().setProvider("BC").getCertificate(certHolder));
    }

    // Keystore
    KeyStore ks = KeyStore.getInstance("JKS");
    ks.load(null);

    for (int i = 0; i < certs.size(); i++) {
      ks.setCertificateEntry(alias + "_" + i, certs.get(i));
    }

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    KeyStore keyStore = KeyStore.getInstance("JKS");
    keyStore.load(null);
    keyStore.setKeyEntry(alias, key, password.toCharArray(), certs.toArray(new X509Certificate[certs.size()]));
    keyStore.store(bos, password.toCharArray());
    bos.close();
    pem.close();
    return bos.toByteArray();
  }

  /** Can be run on it's own: writes the token content to be used in two
   * different files that are independently read by the Acme service.
   *
   * Run with `mvn exec:java@AcmeRenewal -Dexec.args="efile.example.com"`.
   * @throws AcmeException
   * @throws IOException */
  public static void main(String... args) throws IOException, AcmeException {
    String password = System.getenv("CERT_PASSWORD");
    if (password == null || password.isBlank()) {
      log.error("Need a cert password! Use env var CERT_PASSWORD");
      return;
    }
    if (args.length == 0) {
      log.info("No domains passed: Writing crt to a jks file");
      try (FileOutputStream fos = new FileOutputStream(JSK_OUT_FILE_PATH)) {
        fos.write(convertPEMToJKS(DOMAIN_KEY_FILE, DOMAIN_CHAIN_FILE, password));
      } catch (Exception ex) {
        log.error("Error on cert conversion: " + StdLib.strFromException(ex));
      }
      return;
    }
    Security.addProvider(new BouncyCastleProvider());
    AcmeRenewal renewal = new AcmeRenewal();
    AcmeChallengePublisher publisher = new AcmeChallengeWriter();
    renewal.fetchCertificate(Arrays.asList(args), publisher, password);
  }
}
