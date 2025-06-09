echo "Who will be using this API key? This value will be stored in the server_name field (so no spaces)."
read server_name
fly console --config fly.production.toml --debug --verbose --vm-size shared-cpu-2x --vm-memory 4096 --command "java -cp /usr/src/app/target/efspserver-with-deps.jar edu.suffolk.litlab.efspserver.db.LoginDatabase \"$server_name\" true true"
