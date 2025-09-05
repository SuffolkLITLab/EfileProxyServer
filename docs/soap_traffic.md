# Debugging SOAP Traffic

Often, if you ask Tyler for assistance, they will want you to give them the exact SOAP request that you are sending.

There are a few ways of doing this:
* add a call to the `Ecf4Helper.objectToXmlFile` method before you call the MDE to print out the entire XML object that you are sending. This is mostly useful for business logic bugs.
* Add an interceptor to you CXF sender. This is useful for checking SOAP / WebService- Security settings. I haven't done this and don't have a recipe for doing so.
* If many SOAP API calls aren't working (i.e. you aren't sure if Tyler's accepting any of the calls), you will
  need to look at the full SOAP envelope. To do so, download [extract-tls-secrets-4.0.0.0.jar](https://github.com/neykov/extract-tls-secrets/releases/tag/v4.0.0), and run the server using the `dev-compose.yml` docker compose config.

Once you start the server, you can run [wireshark](https://www.wireshark.org/) with the following command:

```bash
sudo wireshark -o tls.keylog_file:$PWD/secrets.log
```

You can then look through your machine's network traffic, and find the Tyler IP, filter on that, and piece together the full SOAP envelope from the decoded packets [^1].

Some misc links that I used while researching:

* [Wireshark tutorial](https://sequentialread.com/how-to-get-a-decrypted-wireshark-packet-capture-from-a-java-application-that-is-talking-https/)
* [The original WS-Security spec document](http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0.pdf)
* [WS-Security Policy stuff](https://www.ibm.com/docs/en/was-liberty/nd?topic=wssml-securing-web-service-by-using-ws-security-policy)