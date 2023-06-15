# EfileProxyServer

A separate server that sits between ECF 4.0 EFMs and docassemble, and can create court filings.

[Docassemble-EFSPIntegration](https://github.com/SuffolkLITLab/docassemble-EFSPIntegration/) is an implementation of a client in Python with a reference interface in Docassemble.

## Setup

This is an abbreviated version of installation. Full details are in [setup](docs/setup.md).

These instructions are written for Linux (specifically Ubuntu 20.04), steps for other platforms should be similar.

1. [Install docker](https://docs.docker.com/engine/install/) and docker-compose.
2. Download this repository: In a terminal, you can run `git clone https://github.com/SuffolkLITLab/EfileProxyServer`
3. In the same terminal change directories to where you downloaded the server: `cd EfileProxyServer`, and then build a docker image for this server. `docker-compose build`
4. Run the server image that you just built with `docker-compose up`.

## Env file

Docker env files don't work in normal bash, so if you are running things in your local shell (like when [testing](#testing)), use [direnv](https://direnv.net).

## Making API Tokens

Run the following command after starting the services with `docker-compose`:

```bash
docker exec -i efileproxyserver-efspjava-1 /usr/bin/mvn -f /usr/src/app/pom.xml exec:java@LoginDatabase -Dexec.args="servername true true"
```

The API token to add to the docassemble config will be printed out.

## Testing

You can run tests with `mvn test`. To run integration tests
with coverage, do the following:

```bash
# download a separate jar for jacoco and extract it
wget --output-document=jacoco-0.8.10.zip https://search.maven.org/remotecontent?filepath=org/jacoco/jacoco/0.8.10/jacoco-0.8.10.zip
unzip jacoco-0.8.10.zip
# Setup the EFSPIntegration python side of things; where the actual tests are
pip install plumbum docassemble.EFSPIntegration
# Run the integration test
./integration_test.py
# change the output jacoco.exec file to be owned by you
sudo chown $USER target/jacoco.exec
# run unit tests (without deleting jacoco.exec) and create the report
mvn jacoco:prepare-agent verify jacoco:report
# view the report in your browser
firefox target/site/jacoco/index.html # or chrome, chromium, etc.
```

You shouldn't have an active running instance of the docker compose containers before running `integration_test.py`.
