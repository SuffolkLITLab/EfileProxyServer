echo "Who will be using this API key? This value will be stored in the server_name field (so no spaces)."
read server_name
docker exec -t efileproxyserver-efspjava-1 sh -c "mvn -f /usr/src/app/pom.xml exec:java@LoginDatabase -Dexec.args=\"$server_name true true\""
