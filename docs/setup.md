# Setup

There are two different ways of running this proxy server:

1. Through Docker and Docker Compose. This is how the server will run in prod,
   so you should have and know this setup.
2. Locally on your own machine. This is only recommended for unit tests, as
   some of important unittests cannot run in a docker container. However,
   running the full server locally is *not* recommended.

These instructions are setup for Ubuntu / Windows Subsystem for Linux,
but should be amenable for Macs.

**NOTE**: it can take about 40 minutes to load all of the codes into the database when starting the proxy server
for the first time. This only happens the first time you run it (if you are using docker compose, `docker compose down` remove the downloaded codes).

## Docker

```bash
# Add Docker's official GPG key:
sudo apt-get update
sudo apt-get install ca-certificates curl
sudo install -m 0755 -d /etc/apt/keyrings
sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
sudo chmod a+r /etc/apt/keyrings/docker.asc

# Add the repository to Apt sources:
echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] https://download.docker.com/linux/ubuntu \
  $(. /etc/os-release && echo "${UBUNTU_CODENAME:-$VERSION_CODENAME}") stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

sudo apt-get update
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin

/etc/init.d/docker start
sudo usermod -aG docker $USER 
newgrp docker 
```

If any of this doesn't work, checkout the official instructions for [docker](https://docs.docker.com/engine/install/ubuntu/)
and [docker compose plugin](https://docs.docker.com/compose/install/linux/#install-using-the-repository).

After installing docker compose plugin, you can download the git repo;

```bash
git clone https://github.com/SuffolkLITLab/EfileProxyServer
cd EfileProxyServer
```

Then you'll need to create or download files not present in the git repo, including:

* `Suffolk.pfx`: this is the PKCS12 certificate file that Tyler Technologies gives you to sign
  our communication with them. It's needed to for the server to communicate with any of the Tyler jurisdictions
  (Illinois, Texas, Indiana, California, and Massachusetts).
* `client_sign.properties`: contains the password for unlocking Suffolk.pfx. You can
  see the structure of this file in
  [`client_sign.properties.example`](../client_sign.properties.example) if you
  need to recreate it.

Finally, you run the following commands to build, start, monitor, and stop the server.

```bash
docker compose build # I encourage building the server first, so it can start immediately.
docker compose up -d # `-d` starts it as a background process.
docker compose logs # will print out all of the logs from the proxy server and the database
docker compose down
```

### Docassemble

If you are running the docker container on the same machine as docassemble, you will likely need to add the following changes to your EfileProxyServer repo:

```diff
diff --git a/docker-compose.yml b/docker-compose.yml
index 1617ba05..776776b6 100644
--- a/docker-compose.yml
+++ b/docker-compose.yml
@@ -6,9 +6,9 @@ services:
     # Necessary b/c docassemble is external to the docker network
     ports:
       - target: 9009
-        published: 80
+        published: 9000
       - target: 9000
-        published: 443
+        published: 9001
     env_file: .env
     depends_on:
       - "db"
```

This allows both docassemble and the proxy server to run on the same machine (by default both use the default HTTP and HTTPS ports, 80 and 443).

To communicate with the Efile Proxy Server from docassemble using the [EFSPIntegration package](https://github.com/SuffolkLITLab/docassemble-EFSPIntegration), you will need to add some config values in docassemble's config:

```yml
efile proxy:
  # Once the efile proxy server has started, generated an API Key and past that
  # here; see README.md
  api key: abc123 
  # This can stay the same
  url: http://efspjava:9000/
  # If using JeffNet, you can copy the JeffNet API Key here
  jeffnet api token: abc123
```

## Running unit tests without Docker

Instructions are for Linux. Start with installing everything.

```bash
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt update
sudo apt install openjdk-17-jdk
```

We are using CXF as the SOAP client which supports up to JDK 17.

```bash
sudo apt install maven
git clone git@github.com:SuffolkLITLab/EfileProxyServer.git
cd EfileProxyServer
```

Note: may not be able to run Eclipse with WSL2. VS Code is usable but the only java extensions that work with it routinely take up 24GB of RAM and crash.

To run all of the unit tests in the project, use the following:

```bash
mvn test 
```

## Contents of .env file

See [env.example](../env.example) for the most up to date documentation for this.
