#! /bin/sh

set -ex

cd /usr/src/app

# Customize startup if running on Fly.io.
if [ -n "$FLY_MACHINE_ID" ]; then
  ./fly_startup_script.sh
fi

# Add this before the `-cp` line if needed to get exact SOAP envelopes being sent
# -javaagent:extract-tls-secrets-4.0.0.jar=/tmp/secrets/secrets.log \
# Add this when we figure out ThreadPools and Unmarshalling (see #111)
# -Djava.util.concurrent.ForkJoinPool.common.threadFactory=edu.suffolk.litlab.efspserver.JAXBForkJoinWorkerThreadFactory \
# if needed to debug http logs:
# https://stackoverflow.com/questions/53215038/how-to-log-request-response-using-java-net-http-httpclient
exec java \
    -XX:+HeapDumpOnOutOfMemoryError \
    -XX:InitialRAMPercentage=20.0 \
    -XX:MaxRAMPercentage=75.0 \
    -jar target/efspserver-with-deps.jar
