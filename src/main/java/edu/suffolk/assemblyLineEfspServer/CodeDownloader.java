package edu.suffolk.assemblyLineEfspServer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.cms.CMSTypedData;
import org.bouncycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;

public class CodeDownloader {

    private static final String PATH_TO_KEYSTORE = "Suffolk.pfx";
    private static final String SIGNATUREALGO = "SHA256withRSA";

    byte[] signPkcs7(final byte[] content, final CMSSignedDataGenerator generator) throws Exception {
        CMSTypedData cmsdata = new CMSProcessableByteArray(content);
        CMSSignedData signeddata = generator.generate(cmsdata, true);
        return signeddata.getEncoded();
    }

    KeyStore loadKeyStore() throws Exception {
        KeyStore keystore = KeyStore.getInstance("JKS");
        InputStream is = new FileInputStream(PATH_TO_KEYSTORE);
        keystore.load(is, System.getenv("X509_PASSWORD").toCharArray()); 
        return keystore;
    }

    CMSSignedDataGenerator setUpProvider(final KeyStore keystore) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        String alias = (String) keystore.aliases().nextElement();

        Certificate[] certchain = (Certificate[]) keystore.getCertificateChain(alias);
        final List<Certificate> certlist = new ArrayList<Certificate>();

        for (int i = 0, length = certchain == null ? 0 : certchain.length; i < length; i++) {
            certlist.add(certchain[i]);
        }

        JcaCertStore certstore = new JcaCertStore(certlist);
        Certificate cert = keystore.getCertificate(alias);

        ContentSigner signer = new JcaContentSignerBuilder(SIGNATUREALGO).setProvider("BC").
                build((PrivateKey) (keystore.getKey(alias, System.getenv("X509_PASSWORD").toCharArray()))); 

        CMSSignedDataGenerator generator = new CMSSignedDataGenerator();

        generator.addSignerInfoGenerator(new JcaSignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder().setProvider("BC").
                build()).build(signer, (X509Certificate) cert));

        generator.addCertificates(certstore);
        return generator;
    }
    
    public static String signedBase64(CodeDownloader signer, String content) throws Exception {
        byte[] signedBytes = signer.signPkcs7(content.getBytes("UTF-8"), signer.setUpProvider(signer.loadKeyStore()));
        return Base64.getEncoder().encodeToString(signedBytes);
    }
    
    /**
     * https://stackoverflow.com/a/1485730/11416267
     * @param urlToRead
     * @return
     * @throws Exception
     */
    public static InputStream getHTML(String urlToRead, String auth_header) throws Exception {
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("tyl-efm-api", auth_header);
        return conn.getInputStream();
    }

    public static void main(String[] args) throws Exception {
        CodeDownloader signer = new CodeDownloader();
        // TODO(brycew): use the current time
        String b64_out = signedBase64(signer, "2021-02-22T18:08:00.775Z"); 
        // TODO(brycew): make this an env variable somehow
        String base_url = "https://illinois-stage.tylerhost.net";
        InputStream urlStream = getHTML(base_url + "/CodeService/codes/location", b64_out);
        
        // Write out the zip file
        FileOutputStream file_out = new FileOutputStream("testing_codes.zip");
        long length = urlStream.transferTo(file_out); 
        System.out.println(length + " bytes transfered");
        // TODO(brycew): read back in that zip file
    }
}