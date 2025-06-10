echo "Who will be using this API key? This value will be stored in the server_name field (so no spaces)."
read server_name
docker exec -t efileproxyserver-efspjava-1 sh -c "java -cp /app/efspserver-with-deps.jar edu.suffolk.litlab.efspserver.db.LoginDatabase \"$server_name\" true true"
