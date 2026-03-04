# Setup

There are two different ways of running this proxy server:

1. Through Docker and Docker Compose. This is how the server will run in prod,
   so you should know this setup.
2. Locally on your own machine. This is only recommended for unit tests, as
   some of important unittests cannot run in a docker container. However,
   running the full server locally is *not* recommended.

These instructions are split into Ubuntu / Windows Subsystem for Linux and Mac.

**NOTE**: it can take about 40 minutes to load all of the codes into the database when starting the proxy server
for the first time. This only happens the first time you run it (if you are using docker compose, `docker compose down` remove the downloaded codes).

## Docker

### Mac

To install Docker on a Mac, you must [install Docker Desktop](https://docs.docker.com/desktop/setup/install/mac-install/). Follow those linked instructions to install both `docker` and `docker compose`.

### Linux

```bash
# Add Docker's official GPG key:
sudo apt update
sudo apt install ca-certificates curl
sudo install -m 0755 -d /etc/apt/keyrings
sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
sudo chmod a+r /etc/apt/keyrings/docker.asc

# Add the repository to Apt sources:
sudo tee /etc/apt/sources.list.d/docker.sources <<EOF
Types: deb
URIs: https://download.docker.com/linux/ubuntu
Suites: $(. /etc/os-release && echo "${UBUNTU_CODENAME:-$VERSION_CODENAME}")
Components: stable
Signed-By: /etc/apt/keyrings/docker.asc
EOF

sudo apt update
sudo apt install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin

/etc/init.d/docker start
sudo usermod -aG docker $USER 
newgrp docker 
```

If any of this doesn't work, checkout the official instructions for [docker](https://docs.docker.com/engine/install/ubuntu/)
and [docker compose plugin](https://docs.docker.com/compose/install/linux/#install-using-the-repository).

## Running with Docker

After installing docker compose plugin, you can download the git repo;

```bash
git clone https://github.com/SuffolkLITLab/EfileProxyServer
cd EfileProxyServer
```

Then you'll need to create or download files not present in the git repo, including:

* `config/Suffolk.pfx`: this is the PKCS12 certificate file that Tyler Technologies gives you to sign
  our communication with them. It's needed to for the server to communicate with any of the Tyler jurisdictions
  (Illinois, Texas, Indiana, California, and Massachusetts).
* `config/client_sign.properties`: contains the password for unlocking Suffolk.pfx. You can
  see the structure of this file in
  [`client_sign.properties.example`](../config/client_sign.properties.example) if you
  need to recreate it.

Finally, you run the following commands to build, start, monitor, and stop the server. Remove the `dev-compose.yml` argument to
build a production version of the images instead.

```bash
docker compose -f dev-compose.yml build # I encourage building the server first, so it can start immediately.
docker compose -f dev-compose.yml up -d --watch # `-d` starts it as a background process, --watch will rebuild and restart the containers when code changes
docker compose -f dev-compose.yml logs # will print out all of the logs from the proxy server and the database
docker compose -f dev-compose.yml down
```

### Docassemble

If you are running the docker container on the same machine as docassemble, use the `-f dev-compose.yml` command
above to allow this server and docassemble to use different HTTP ports.

To communicate with the Efile Proxy Server from docassemble using the [EFSPIntegration package](https://github.com/SuffolkLITLab/docassemble-EFSPIntegration), you will need to add some config values in docassemble's config:

```yml
efile proxy:
  # Once the efile proxy server has started, generated an API Key and past that
  # here; see ../scripts/local_create_api_key.sh
  api key: abc123 
  # This can stay the same
  url: http://host.docker.internal:9100
  # If using JeffNet, you can copy the JeffNet API Key here
  jeffnet api token: abc123
```

## Running locally without Docker

### Mac

Using [Homebrew](https://brew.sh/), install OpenJDK and Maven:

```bash
brew install openjdk@21
brew install maven
```

### Linux

Install OpenJDK and maven using apt.

```bash
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt update
sudo apt install openjdk-21-jdk
sudo apt install maven
```

Note: may not be able to run Eclipse with WSL2. VS Code is usable but the only java extensions that work with it routinely take up 24GB of RAM and crash.

## Running unit tests

To run all of the unit tests in the project, use the following:

```bash
# If not already cloned
git clone git@github.com:SuffolkLITLab/EfileProxyServer.git
cd EfileProxyServer
mvn test 
```

You can also run the server without docker. See [the proxyserver README](../proxyserver/README.md).

## Contents of .env file

See [env.example](../env.example) for the most up to date documentation.


## Next steps

* [operations_guide/index.md](operations_guide/index.md) if you running the server.
* [developing.md](developing.md) if you are writing code for the server