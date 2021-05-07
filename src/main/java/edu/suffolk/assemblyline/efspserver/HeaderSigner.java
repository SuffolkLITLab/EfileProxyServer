package edu.suffolk.assemblyline.efspserver;

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

public class HeaderSigner {

  private static final String PATH_TO_KEYSTORE = "Suffolk.pfx";
  private static final String SIGNATUREALGO = "SHA256withRSA";
  private final String x509Password;

  public HeaderSigner(String x509Password) {
    if (x509Password == null || x509Password.isEmpty()) {
      throw new RuntimeException("x509 Password cannot be null: did you forget to source .env");
    }
    this.x509Password = x509Password;
  }

  byte[] signPkcs7(final byte[] content, final CMSSignedDataGenerator generator)
      throws CMSException, IOException {
    CMSTypedData cmsdata = new CMSProcessableByteArray(content);
    CMSSignedData signeddata = generator.generate(cmsdata, true);
    return signeddata.getEncoded();
  }

  KeyStore loadKeyStore() throws GeneralSecurityException, IOException {
    KeyStore keystore = KeyStore.getInstance("JKS");
    InputStream is = new FileInputStream(PATH_TO_KEYSTORE);
    keystore.load(is, this.x509Password.toCharArray());
    return keystore;
  }

  CMSSignedDataGenerator setUpProvider(final KeyStore keystore)
      throws GeneralSecurityException, OperatorCreationException, CMSException {
    Security.addProvider(new BouncyCastleProvider());
    String alias = (String) keystore.aliases().nextElement();

    Certificate[] certchain = (Certificate[]) keystore.getCertificateChain(alias);
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

  public String signedBase64(String content)
      throws GeneralSecurityException, OperatorCreationException, CMSException, IOException {
    byte[] signedBytes = signPkcs7(content.getBytes("UTF-8"), setUpProvider(loadKeyStore()));
    return Base64.getEncoder().encodeToString(signedBytes);
  }

  /**
   * Gets the current timestamp, signs it with an x.509 cert, and returns the
   * signature
   *
   * @return           signed bytes of the timestamp string that has been base 64
   *                   encoded
   * @throws Exception TODO(brycew) need to make more specific
   */
  public String signedCurrentTime()
      throws GeneralSecurityException, OperatorCreationException, CMSException, IOException {
    Instant now = Instant.now(Clock.systemUTC());
    String currentTimestamp = now.toString();
    return signedBase64(currentTimestamp);
  }

}
