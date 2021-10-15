package edu.suffolk.litlab.efspserver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.cms.CMSTypedData;
import org.bouncycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeaderSigner {
  private static Logger log = 
      LoggerFactory.getLogger(HeaderSigner.class); 

  private static final String SIGNATUREALGO = "SHA256withRSA";
  private final String pathToKeystore; 
  private final String x509Password;

  /** The string password to the x509 certificate. This password is given by Tyler,
   * and will also unlock the .pfx file.
   *
   * @param pathToKeystore The path to the '.pfx' file that contains Tyler provided X509 certificate
   * @param x509Password the password to the password for that x509 password
   */
  public HeaderSigner(String pathToKeystore, String x509Password) {
    if (pathToKeystore == null || pathToKeystore.isEmpty()) {
      throw new RuntimeException("pathToKeystore cannot be null: did you forget to source .env?");
    }
    if (x509Password == null || x509Password.isEmpty()) {
      throw new RuntimeException("x509 Password cannot be null: did you forget to source .env?");
    }
    this.pathToKeystore = pathToKeystore;
    this.x509Password = x509Password;
  }

  private static byte[] signPkcs7(final byte[] content, final CMSSignedDataGenerator generator)
      throws CMSException, IOException {
    CMSTypedData cmsdata = new CMSProcessableByteArray(content);
    CMSSignedData signeddata = generator.generate(cmsdata, true);
    return signeddata.getEncoded();
  }

  private KeyStore loadKeyStore() throws GeneralSecurityException, IOException {
    KeyStore keystore = KeyStore.getInstance("JKS");
    InputStream is = new FileInputStream(this.pathToKeystore); 
    keystore.load(is, this.x509Password.toCharArray());
    return keystore;
  }

  private CMSSignedDataGenerator setUpProvider(final KeyStore keystore)
      throws GeneralSecurityException, OperatorCreationException, CMSException {
    Security.addProvider(new BouncyCastleProvider());
    String alias = keystore.aliases().nextElement();

    Certificate[] certchain = keystore.getCertificateChain(alias);
    final List<Certificate> certlist = new ArrayList<Certificate>();

    for (int i = 0, length = certchain == null ? 0 : certchain.length; i < length; i++) {
      certlist.add(certchain[i]);
    }

    JcaCertStore certstore = new JcaCertStore(certlist);
    Certificate cert = keystore.getCertificate(alias);

    char[] x509Password = this.x509Password.toCharArray();
    ContentSigner signer = new JcaContentSignerBuilder(SIGNATUREALGO).setProvider("BC")
        .build((PrivateKey) (keystore.getKey(alias, x509Password)));

    CMSSignedDataGenerator generator = new CMSSignedDataGenerator();

    generator.addSignerInfoGenerator(new JcaSignerInfoGeneratorBuilder(
        new JcaDigestCalculatorProviderBuilder().setProvider("BC").build()).build(signer,
            (X509Certificate) cert));

    generator.addCertificates(certstore);
    return generator;
  }

  /** Signs the provided @param content with the X509 certificate, returning
   * the signed string as a base64 encoded string. 
   *
   * @param content The string to be signed
   * @return The base64 encoded string, empty if something went wrong with the cert
   */
  public Optional<String> signedBase64(String content) {
    try {
      byte[] signedBytes = signPkcs7(
          content.getBytes("UTF-8"), 
          setUpProvider(loadKeyStore()));
      return Optional.of(Base64.getEncoder().encodeToString(signedBytes));
    } catch (GeneralSecurityException ex) {
      log.error("Exception when trying to sign info with a X509 cert: " + ex);
    } catch (OperatorCreationException ex) {
      log.error("Exception when trying to sign info with a X509 cert: " + ex);
    } catch (CMSException ex) {
      log.error("Exception when trying to sign info with a X509 cert: " + ex);
    } catch (IOException ex) {
      log.error("Exception when trying to sign info with a X509 cert: " + ex);
    }
    return Optional.empty();
  }

  /**
   * Gets the current timestamp, signs it with an x.509 cert, and returns the
   * signature
   *
   * @return           signed bytes of the timestamp string that has been base 64
   *                   encoded
   */
  public Optional<String> signedCurrentTime() {
    Instant now = Instant.now(Clock.systemUTC());
    String currentTimestamp = now.toString();
    return signedBase64(currentTimestamp);
  }

}
