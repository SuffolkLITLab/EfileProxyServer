#! /bin/sh

set -ex

cd /app/

# Customize startup if running on Fly.io.
if [ -n "$FLY_MACHINE_ID" ]; then
  ./fly_startup_script.sh
fi

# Add this when we figure out ThreadPools and Unmarshalling (see #111)
# -Djava.util.concurrent.ForkJoinPool.common.threadFactory=edu.suffolk.litlab.efspserver.JAXBForkJoinWorkerThreadFactory \
# if needed to debug http logs:
# https://stackoverflow.com/questions/53215038/how-to-log-request-response-using-java-net-http-httpclient
exec java \
    -XX:+HeapDumpOnOutOfMemoryError \
    -XX:InitialRAMPercentage=20.0 \
    -XX:MaxRAMPercentage=75.0 \
    -jar efspserver-with-deps.jar
