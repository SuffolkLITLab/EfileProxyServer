echo "Who will be using this API key? This value will be stored in the server_name field (so no spaces)."
read server_name
fly console --debug --verbose --vm-size shared-cpu-2x --vm-memory 4096 --command "java -cp /app/efspserver-with-deps.jar edu.suffolk.litlab.efsp.db.LoginDatabase \"$server_name\" true true"
