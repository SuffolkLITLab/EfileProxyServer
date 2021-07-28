# EfileProxyServer

A separate server that sits between ECF 4.0 EFMs and docassemble, and can create court filings.

TODO(brycew): more details to come!

## Setup

This server is setup using docker. To run, follow the following steps:

These instructions are written for Linux (specifically Ubuntu 20.04), steps for other platforms should be similar.

1. [Install docker](https://docs.docker.com/engine/install/).
2. Download this repository: In a terminal, you can run `git clone https://github.com/SuffolkLITLab/EfileProxyServer`
3. In the same terminal change directories to where you downloaded the server: `cd EfileProxyServer`, and then build a docker image for this server. `docker build . -t efspjava`
4. Run the server image that you just built with `docker run efspjava`.

## Env file

Docker env files are weird, and don't work in normal bash. To read all of the values to the current shell, use:

```bash
cat .env | export $(cut -d= -f1 -)="$(cut -d= -f2 -)"
```

## Testing

You can run tests and get coverage with the following command:
```
mvn clean jacoco:prepare-agent verify jacoco:report
```

Then, visit the `target/site/jacoco/index.html` file to see the coverage report.

## Making API Tokens

Login to the java docker container, cd to `/usr/src/app`, and run the following, which will
add a single server to the database.

```
mvn exec:java@LoginAddUser -Dexec.args="localhostServer true true"
```
