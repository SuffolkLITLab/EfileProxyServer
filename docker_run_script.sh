#! /bin/sh

set -ex
cd /usr/src/app
# Add this before the `-cp` line if needed to get exact SOAP envelopes being sent
#-javaagent:extract-tls-secrets-4.0.0.jar=/tmp/secrets/secrets.log \
java \
    -cp $(cat cp.txt):target/assemblyline-efsp-0.5.0.jar \
	edu.suffolk.litlab.efspserver.services.EfspServer \
	-Djava.util.logging.config.file=logging.properties \
    -Dlog4j2.formatMsgNoLookups=true
# if needed to debug http logs: https://stackoverflow.com/questions/53215038/how-to-log-request-response-using-java-net-http-httpclient
