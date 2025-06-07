#! /bin/sh

set -x
cd /app
if [ -f jacocoagent.jar ]; then
  JACOCO_ARG="-javaagent:jacocoagent.jar=destfile=/tmp/jacoco/jacoco.exec"
fi
if [ -f extract-tls-secrets-4.0.0.jar ]; then
  TLS_SECRETS_ARG="-javaagent:extract-tls-secrets-4.0.0.jar=/tmp/secrets/secrets.log"
fi
java \
    $JACOCO_ARG \
    -cp efspserver-with-deps.jar \
    edu.suffolk.litlab.efsp.db.LoginDatabase integrationTest true true > /tmp/secrets/proxy_stuff.txt
# Add this when we figure out ThreadPools and Unmarshalling (see #111)
# -Djava.util.concurrent.ForkJoinPool.common.threadFactory=edu.suffolk.litlab.efsp.server.JAXBForkJoinWorkerThreadFactory \
# if needed to debug http logs:
# https://stackoverflow.com/questions/53215038/how-to-log-request-response-using-java-net-http-httpclient
exec java \
    $TLS_SECRETS_ARG \
    $JACOCO_ARG \
    -XX:+HeapDumpOnOutOfMemoryError \
    -jar efspserver-with-deps.jar