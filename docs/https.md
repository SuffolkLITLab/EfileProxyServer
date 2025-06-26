# HTTPS / TLS

You probably want your server to use HTTPS, so not everyone on the same network
can read the sensitive information passed to the proxy server in plaintext.

For a simple explainer, see [Julia Evan's Twitter comic about it](https://twitter.com/b0rk/status/809594614147645440/photo/1).

## Getting a Certificate

The first of two steps to using HTTPS is actually getting a signed TLS certificate from a certificate signer.

### Using Let's Encrypt and ACME

We've integrated [Let's Encrypt](https://letsencrypt.org/) support into our server with the [ACME protocol](https://letsencrypt.org/how-it-works/), using [acme4j](https://github.com/shred/acme4j).

We are still working to improve the steps, but current the process is:

1. In your `.env` file, set `USE_LETSENCRYPT=True`, and `CERT_PASSWORD` to a securely generated password, at least 16 characters.
   Something like `openssl rand -base64 12` will generate 16 characters securely.
   * You can also set a `MONITORING_EMAIL` which will be used for email renewal reminders from Lets Encrypt.
2. Start up the docker containers (see [setup.md](setup.md)).
3. Start a shell inside the running container: `docker exec -it efileproxyserver-efspjava-1 /bin/sh`
4. Change directories to the app: `cd /app`.
5. Run the ACME renewal process: `java -cp efspserver-with-deps.jar edu.suffolk.litlab.efspserver.services.acme.AcmeRenewal renew`.
   If the renewal process succeeded, `acme-domain-chain.crt` and `tls_server_cert.jks`
   should both be present in `/tmp/tls_certs` inside the container and in `src/main/config` outside the container.
6. Exit the shell you started, and rebuild and restart the java docker container.

The newly started container should be able to serve HTTPS correctly!

### (Not preferred) From a Certificate Authority

This was the original way we did things, but Let's Encrypt is currently simpler and more secure than
sending around important certificates files. If Let's Encrypt doesn't work for your organization,
you can follow the below steps that we took when we set up HTTPS using a purchased signed certificate.

You can purchase TLS Certificates from providers directly, (for example, [from namecheap](https://www.namecheap.com/security/ssl-certificates/)). You should receive the following files:
* a bundle of certificate authorities who make up the chain of CAs who signed your certificate. In our case, this had a `*.ca-bundle` extension.
* The signed certificate for your website. In our case, this had a `*.crt` extension.
* The private key for your website, sometimes called the domain key. In our case, this had a `*.key` extension.

Once you have those three things, you need to turn convert them into the Java Key Store (JKS) format, which the server can read. You can follow the below steps in a shell with `openssl` and `keytool` installed:

```bash
# Add the full list of CA signers to the cert. Going to the root signer means it's more likely
# for the server to be trusted. Not always necessary, but was in our case.
cat my_domain.ca-bundle my_domain.crt > my_domain.crt
openssl pkcs12 -export -in my_domain.crt -inkey my_domain.key -out my_domain.p12
keytool -importkeystore -srckeystore my_domain.p12 -srcstoretype PKCS12 -destkeystore my_domain.jks -deststoretype JKS
```

Refer to the sources below if you need more details:
* ["Java TLS with Keystores" cheat-sheet](https://stackoverflow.com/a/41469242/11416267)
* [Install a Tomcat cert](https://www.tbs-certificates.co.uk/FAQ/en/ajouter-certificat-intermediaire-keystore-java.html)
* [How to convert *.crt and *.key to *.jks](https://community.datarobot.com/t5/data-prep/how-to-convert-crt-and-key-to-jks-file/td-p/6342)


## Developer Notes: Using the cert in the CXF Server

Once you have the cert, you need to set up the CXF server properly to use it. To do so,
[ServerConfig.xml](https://github.com/SuffolkLITLab/EfileProxyServer/blob/4a25a9f30d7d74d9e0828d142f6b908e1a3532ec/src/main/config/ServerConfig.xml#L33)
needs to point to the `*.jks` file.

See the following files and their code comments for the current setup.

* [EfspServer.java](https://github.com/SuffolkLITLab/EfileProxyServer/blob/main/src/main/java/edu/suffolk/litlab/efspserver/services/EfspServer.java)
* [ServerConfig.xml](https://github.com/SuffolkLITLab/EfileProxyServer/blob/main/src/main/config/ServerConfig.xml)
  * The ServerConfig.xml shouldn't use the `clientAuthentication` elem, as it expects our connecting clients to also have a TLS cert, which isn't how HTTPS traffic usually works.
* [HttpsCallbackHandler.java](https://github.com/SuffolkLITLab/EfileProxyServer/blob/main/src/main/java/edu/suffolk/litlab/efspserver/HttpsCallbackHandler.java)
* [ServiceHelpers.java](https://github.com/SuffolkLITLab/EfileProxyServer/blob/main/src/main/java/edu/suffolk/litlab/efspserver/services/ServiceHelpers.java#L74)
  * The external address (i.e `ServerFactoryBean.setAddress`) needs to be `https://`, not `http://`. We use `CERT_PASSWORD` to determine if someone is trying to run with TLS, and if no `CERT_PASSWORD` is present, we use `http://`.


The following CXF documentation pages have more information, but are kinda sparse:

* [https://cxf.apache.org/docs/secure-jax-rs-services.html#SecureJAXRSServices-Configuringendpoints]
* [https://cwiki.apache.org/confluence/display/CXF20DOC/TLS+Configuration]
* [https://cxf.apache.org/docs/standalone-http-transport.html]
* [http://svn.apache.org/repos/asf/cxf/trunk/distribution/src/main/release/samples/jax_rs/basic_https/]

