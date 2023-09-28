# Developing

See [setup.md](setup.md) to first install the required dependencies and be able to run the server.

## Working with Docassemble

If you are developing integrations to the E-file Proxy on a docassemble server, you need to install
the following packages:
1. [docassemble.AssemblyLine](https://pypi.org/project/docassemble.AssemblyLine/)
1. [docassemble.EFSPIntegration](https://pypi.org/project/docassemble.EFSPIntegration)


## Writing Code

There are two server files that provide important features that can help you understand the server:
* [AdminUserService.java](../src/main/java/edu/suffolk/litlab/efspserver/services/AdminUserService.java).
* [FilingReviewService.java](../src/main/java/edu/suffolk/litlab/efspserver/services/FilingReviewService.java).

See [architecture.md](architecture.md) for a description of the general architecture of the program.

### Adding Libraries

You can search for dependencies using [Maven's search site](https://search.maven.org/), and see more
details about a package on [MVNRepository](https://mvnrepository.com/).

To add new libraries, edit [`pom.xml`](../pom.xml) and add an entry to `<dependencies>`.
Here is an example of when we added the sendgrid library:

```xml
        <dependency>
            <groupId>com.sendgrid</groupId>
            <artifactId>sendgrid-java</artifactId>
            <version>4.7.2</version>
        </dependency>
```

### General Tips
This [REST/JAX book](https://dennis-xlc.gitbooks.io/restful-java-with-jax-rs-2-0-2rd-edition/content/en/part1/chapter3/developing_a_jax_rs_restful_service.html) is a good place to learn about the basics of JAX.

## Debugging SOAP Traffic

Often, if you ask Tyler for assistance, they will want you to give them the exact SOAP request that you are sending.

There are a few ways of doing this:
* add a call to the `Ecf4Helper.objectToXmlFile` method before you call the MDE to print out the entire XML object that you are sending. This is mostly useful for business logic bugs.
* Add an interceptor to you CXF sender. This is useful for checking SOAP / WebService- Security settings. I haven't done this and don't have a recipe for doing so.
* If many SOAP API calls aren't working (i.e. you aren't sure if Tyler's accepting any of the calls), you will
  need to look at the full SOAP envelope. To do so, download [extract-tls-secrets-4.0.0.0.jar](https://github.com/neykov/extract-tls-secrets/releases/tag/v4.0.0), and add the following diff to your repo:

```diff
diff --git a/docker-compose.yml b/docker-compose.yml
index 7692426c..776776b6 100644
--- a/docker-compose.yml
+++ b/docker-compose.yml
@@ -16,15 +16,15 @@ services:
       - type: bind
         source: ./src/main/config
         target: /tmp/tls_certs
+    # Uncomment this for debugging: you can get exact SOAP envelopes being
+    # sent by running wireshark locally
+      - type: bind
+        source: .
+        target: /tmp/secrets
     deploy:
       resources:
         limits:
           memory: 4G
-    # Uncomment this for debugging: you can get exact SOAP envelopes being
-    # sent by running wireshark locally
-    #  - type: bind
-    #    source: .
-    #    target: /tmp/secrets
   db:
     image: "postgres:14"
     shm_size: 256m
diff --git a/docker_run_script.sh b/docker_run_script.sh
index 3d903c53..57028ced 100755
--- a/docker_run_script.sh
+++ b/docker_run_script.sh
@@ -9,6 +9,7 @@ cd /usr/src/app
 # if needed to debug http logs:
 # https://stackoverflow.com/questions/53215038/how-to-log-request-response-using-java-net-http-httpclient
 exec java \
+    -javaagent:extract-tls-secrets-4.0.0.jar=/tmp/secrets/secrets.log \
     -cp $(cat cp.txt):target/efspserver.jar \
     -XX:+HeapDumpOnOutOfMemoryError \
     -XX:InitialRAMPercentage=20.0 \
```

Once you start the server, you can run [wireshark](https://www.wireshark.org/) with the following command:

```bash
sudo wireshark -o tls.keylog_file:$PWD/secrets.log
```

You can then look through your machine's network traffic, and find the Tyler IP, filter on that, and piece together the full SOAP envelope from the decoded packets [^1].

Some misc links that I used while researching:

* [Wireshark tutorial](https://sequentialread.com/how-to-get-a-decrypted-wireshark-packet-capture-from-a-java-application-that-is-talking-https/)
* [The original WS-Security spec document](http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0.pdf)
* [WS-Security Policy stuff](https://www.ibm.com/docs/en/was-liberty/nd?topic=wssml-securing-web-service-by-using-ws-security-policy)

