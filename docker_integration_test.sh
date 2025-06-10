#! /bin/sh

set -x
cd /app
java \
    -javaagent:jacocoagent.jar=destfile=/tmp/jacoco/jacoco.exec \
    -cp efspserver-with-deps.jar \
    edu.suffolk.litlab.efspserver.db.LoginDatabase integrationTest true true > /tmp/secrets/proxy_stuff.txt
# Add this before the `-cp` line if needed to get exact SOAP envelopes being sent
# -javaagent:extract-tls-secrets-4.0.0.jar=/tmp/secrets/secrets.log \
# Add this when we figure out ThreadPools and Unmarshalling (see #111)
# -Djava.util.concurrent.ForkJoinPool.common.threadFactory=edu.suffolk.litlab.efspserver.JAXBForkJoinWorkerThreadFactory \
# if needed to debug http logs:
# https://stackoverflow.com/questions/53215038/how-to-log-request-response-using-java-net-http-httpclient
exec java \
    -javaagent:extract-tls-secrets-4.0.0.jar=/tmp/secrets/secrets.log \
    -javaagent:jacocoagent.jar=destfile=/tmp/jacoco/jacoco.exec \
    -XX:+HeapDumpOnOutOfMemoryError \
    -jar efspserver-with-deps.jar