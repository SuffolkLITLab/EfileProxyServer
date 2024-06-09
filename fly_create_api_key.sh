echo "Who will be using this API key? This value will be stored in the server_name field."
read server_name
fly console --debug --verbose --vm-size shared-cpu-2x --vm-memory 4096 --command "mvn -f /usr/src/app/pom.xml exec:java@LoginDatabase -Dexec.args=\"$server_name true true\""
