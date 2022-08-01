# Advanced Topics: Seeing what requests are actually sent using CXF

Rough options:
* Look at the Java object that you are about to send by logging it as a string
  * This is mostly useful with business logic bugs
* Adding an interceptor to the CXF sender (works better when you are testing callbacks to your server)
  * good for people calling your server
  * good for checking if the server is handling the SOAP / WebService- Security settings correctly
* Looking at the exact bits sent over the network using Wireshark
  * same as the above, but more reliable from different contexts, if you can't recompile the source code, etc.

## Wireshark

Rough outline:

* Download a java agent keylogger (https://github.com/jsslkeylog/jsslkeylog, https://github.com/neykov/extract-tls-secrets)
* Get the full command to start the server code (generally in `docker_script.sh`).
* Add the java agent to the start up command (for extract-tls-secrets, it's `-javaagent:extract-tls-scecrets-4.0.0.jar=/tmp/secrets.log -jar ...`)
* Start wireshark by pointing it to the secrets log, i.e. `wireshark -o tls.keylog_file:/tmp/secrets.log`.
* Wireshark should then be able to decode the TLS packets into raw HTTP.
  * Sometimes, I've seen issues where wireshark still decodes the packets correctly, but doesn't properly show it in the GUI. Check out ([this page on the wireshark wiki](https://wiki.wireshark.org/Development/Tips#printing_to_a_console) for ideas on how to possibly fix).

Some misc links that I used while researching:
* https://sequentialread.com/how-to-get-a-decrypted-wireshark-packet-capture-from-a-java-application-that-is-talking-https/
* The original WS-Security spec document: http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0.pdf
* https://www.ibm.com/docs/en/was-liberty/nd?topic=wssml-securing-web-service-by-using-ws-security-policy
