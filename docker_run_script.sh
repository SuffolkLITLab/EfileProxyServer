#! /bin/sh

set -ex
cd /usr/src/app
java -cp $(cat cp.txt):target/assemblyline-efsp-0.3.3.jar \
	edu.suffolk.litlab.efspserver.services.EfspServer \
	-Djava.util.logging.config.file=logging.properties
# if needed to debug http logs: https://stackoverflow.com/questions/53215038/how-to-log-request-response-using-java-net-http-httpclient
