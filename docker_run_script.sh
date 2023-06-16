#! /bin/sh

set -ex
cd /usr/src/app
# Add this before the `-cp` line if needed to get exact SOAP envelopes being sent
# -javaagent:extract-tls-secrets-4.0.0.jar=/tmp/secrets/secrets.log \
# Add this when we figure out ThreadPools and Unmarshalling (see #111)
# -Djava.util.concurrent.ForkJoinPool.common.threadFactory=edu.suffolk.litlab.efspserver.JAXBForkJoinWorkerThreadFactory \
# if needed to debug http logs:
# https://stackoverflow.com/questions/53215038/how-to-log-request-response-using-java-net-http-httpclient
exec java \
    -cp $(cat cp.txt):target/efspserver.jar \
    -XX:+HeapDumpOnOutOfMemoryError \
    edu.suffolk.litlab.efspserver.services.EfspServer
