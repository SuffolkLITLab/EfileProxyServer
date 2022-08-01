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
2. Start up the docker containers (see [setup.md](setup.md)).
3. Start a bash shell inside the running container: `docker exec -it efileproxyserver_efspjava_1 /bin/bash`
4. Change directories to the app: `cd /usr/src/app`.
5. Run the ACME renewal process: `mvn exec:java@AcmeRenewal renew`.
   If the renewal process succeeded, `acme-domain-chain.crt` and `tls_server_cert.jks`
   should both be present in `/tmp/tls_certs` inside the container and in `src/main/config` outside the container.
6. Exit the bash shell you started, and rebuild and restart the java docker container.

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

Our sources for the above are listed below, refer to them if you don't :
* [https://stackoverflow.com/a/41469242/11416267]
* [https://www.tbs-certificates.co.uk/FAQ/en/ajouter-certificat-intermediaire-keystore-java.html]
* [https://community.datarobot.com/t5/data-prep/how-to-convert-crt-and-key-to-jks-file/td-p/6342]


## Developer Notes: Using the cert in the CXF Server

Next you have to set up the CXF server properly to use it.

The following pages have useful information, but are kinda sparse:

* [https://cxf.apache.org/docs/secure-jax-rs-services.html#SecureJAXRSServices-Configuringendpoints]
* [https://cwiki.apache.org/confluence/display/CXF20DOC/TLS+Configuration]
* [https://cxf.apache.org/docs/standalone-http-transport.html]
* [http://svn.apache.org/repos/asf/cxf/trunk/distribution/src/main/release/samples/jax_rs/basic_https/]

The SpringBusFactory and Bus from the ServerConfig.xml need to be created in
a static block in the Server class, and you need to set the CertPassword to
the CallbackHandler before you create the factory, as it will be used to immediately
unlock the passed in JKS file.

The external address (i.e `ServerFactoryBean.setAddress`) needs to be `https://`, not `http://`. We use `CERT_PASSWORD` to determine if someone is trying to run with TLS,
and if no `CERT_PASSWORD` is present, we use `http://`.

The ServerConfig.xml shouldn't use the `clientAuthentication` elem, as it
expects clients connecting to also have a TLS cert.
