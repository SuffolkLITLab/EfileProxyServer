# HTTPS / TLS

You probably want your server to use HTTPS, so not everyone one the same wifi 
can read your passwords in plaintext on the network.

For a simple explainer, see [Julia Evan's Twitter comic about it](https://twitter.com/b0rk/status/809594614147645440/photo/1).

## Getting a Certificate

The first of two steps to using HTTPS is actually getting a signed TLS certificate from a certificate signer.

### From a Certificate Authority

(TODO(brycew-later): document this for the future).

### Using Let's Encrypt and ACME

You can also do this with Let's Encrypt, but unfortunately since we're running on a custom server
software (not nginx or Apache), then it would take a bit more effort to integrate it.
TODO(brycew-later): eventually we should. Look into the below for resources 

* [Lets Encrypt Java Clients](https://letsencrypt.org/docs/client-options/#clients-java)
* [Porunov Java ACME Client](https://github.com/porunov/acme_client) (ACME is the protocol that Let's Encrypt uses)
* [Shred acme4j](https://github.com/shred/acme4j)

## Using that Certificate in the CXF Server

First, turning the certificate into something that Java can consume, namely, a Java Key Store (jks). 

* https://stackoverflow.com/questions/41416050/installing-an-intermediate-chain-certificate-using-java-key-tool
* https://www.tbs-certificates.co.uk/FAQ/en/ajouter-certificat-intermediaire-keystore-java.html
* https://community.datarobot.com/t5/data-prep/how-to-convert-crt-and-key-to-jks-file/td-p/6342

The commands below are how we did it

```bash
# You already have a
# * efile_suffolklitlab_org.ca-bundle
# * efile_suffolklitlab_org.crt 
# * efile.suffolklitlab.org.key
# * efile.suffolklitlab.org.p12
   
java utils.ImportPrivateKey keystore storepass storetype keypass alias certfile keyfile keyfilepass 
openssl pkcs12 -export -in efile_suffolklitlab_org.crt -inkey efile.suffolklitlab.org.key  -out efile.suffolklitlab.org.p12
keytool -importkeystore -srckeystore efile.suffolklitlab.org.p12 -srcstoretype PKCS12 -destkeystore efile.suffolklitlab.org.jks -deststoretype JKS

keytool -printcert -v -file efile.suffolklitlab.org.jks 
keytool -list -v -file efile.suffolklitlab.org.jks 
keytool -list -v -keystore efile.suffolklitlab.org.jks 
keytool -exportcert -rfc -alias mykey -keystore efile.suffolklitlab.org.jks > cert.pem
openssl verify cert.pem
keytool -exportcert -rfc -keystore efile.suffolklitlab.org.jks > cert.pem
keytool -exportcert -rfc -keystore efile.suffolklitlab.org.jks
keytool -list -v -keystore efile.suffolklitlab.org.jks | grep Alias
keytool -exportcert -rfc -Alias 1 -keystore efile.suffolklitlab.org.jks > cert.pem
openssl verify cert.pem
openssl verify efile_suffolklitlab_org.ca-bundle 
vim sectigo.intermediate.crt
cat efile_suffolklitlab_org.ca-bundle efile_suffolklitlab_org.crt > efile_suffolklitlab_org_combined.crt
openssl pkcs12 -export -in efile_suffolklitlab_org_combined.crt -inkey efile.suffolklitlab.org.key -out efile.suffolklitlab.org.combined.p12
keytool -importkeystore -srckeystore efile.suffolklitlab.org.combined.p12 -srcstoretype PKCS12 -destkeystore efile.suffolklitlab.org.combined.jks -deststoretype JKS
keytool -exportcert -rfc -alias 1 -keystore efile.suffolklitlab.org.combined.jks > cert.pem
openssl verify cert.pem 
openssl verify -CAfile sectigo.root.crt -untrusted sectigo.intermediate.crt cert.pem 
keytool -list -v -keystore efile.suffolklitlab.org.combined.jks
keytool -list -v -keystore efile.suffolklitlab.org.combined.jks | grep Alias
cp efile.suffolklitlab.org.combined.jks EFileProxyServer/src/main/config/
```

Next you have to set up the CXF server properly to use it.

The following pages have useful information, but are kinda sparse:

* https://cxf.apache.org/docs/secure-jax-rs-services.html
* http://cxf.apache.org/docs/client-http-transport-including-ssl-support.html
* https://cwiki.apache.org/confluence/display/CXF20DOC/TLS+Configuration
* https://cxf.apache.org/docs/standalone-http-transport.html
* http://svn.apache.org/repos/asf/cxf/trunk/distribution/src/main/release/samples/jax_rs/basic_https/

Some important info:

The SpringBusFactory and Bus from the ServerConfig.xml need to be created in a static block in the Server class,
and you need to set the CertPassword to the CallbackHandler before you create the factory.

You also need to set the address to be `https://`, not `http://`.

The ServerConfig.xml shouldn't use the `clientAuthentication` elem, as it expects clients connecting to also have a
TLS cert.
