#! /bin/sh

set -ex
cd /usr/src/app
echo $X509_PASSWORD
ls
java -cp $(cat cp.txt):target/assemblyline-efsp-0.0.1-SNAPSHOT.jar edu.suffolk.assemblyline.efspserver.services.EfspServer
#java -cp $(cat cp.txt):target/assemblyline-efsp-0.0.1-SNAPSHOT.jar edu.suffolk.assemblyline.efspserver.CodeUpdater
