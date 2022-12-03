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

Docker env files are weird, and don't work in normal bash. To read all of the values to the current shell, use:

```bash
cat .env | export $(cut -d= -f1 -)="$(cut -d= -f2 -)"
```

## Testing

You can run tests and get coverage with the following command:

```bash
mvn clean jacoco:prepare-agent verify jacoco:report
```

Then, visit the `target/site/jacoco/index.html` file to see the coverage report.

## Making API Tokens

Run the following command after starting the services with `docker-compose`:

```bash
docker exec -i efileproxyserver-efspjava-1 /usr/bin/mvn -f /usr/src/app/pom.xml exec:java@LoginDatabase -Dexec.args="servername true true"
```

The API token to add to the docassemble config will be printed out.
