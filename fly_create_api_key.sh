fly console --debug --verbose --vm-size shared-cpu-2x --vm-memory 4096 --command 'mvn -f /usr/src/app/pom.xml exec:java@LoginDatabase -Dexec.args="localhostServer true true"'
