# EfileProxyServer

A separate server that sits between ECF 4.0 EFMs and docassemble, and can create court filings.

[Docassemble-EFSPIntegration](https://github.com/SuffolkLITLab/docassemble-EFSPIntegration/) is an implementation of a client in Python with a reference interface in Docassemble.

## Setup

This is an abbreviated version of installation. Full details are in [setup](docs/setup.md).

These instructions are written for Linux (specifically Ubuntu 20.04), steps for other platforms should be similar.

1. [Install docker](https://docs.docker.com/engine/install/) and [docker compose](https://docs.docker.com/compose/install/).
2. Download this repository: In a terminal, you can run `git clone https://github.com/SuffolkLITLab/EfileProxyServer`
3. In the same terminal change directories to where you downloaded the server: `cd EfileProxyServer`, and then build a docker image for this server. `docker compose build`
4. Run the server image that you just built with `docker compose up`.

## Env file

Docker env files can't be directly used in `bash`, so if you are running things in your local shell (like when [testing](#testing)), use [direnv](https://direnv.net).

## Making API Tokens

Run the following command after starting the services with `docker compose`:

```bash
docker exec -i efileproxyserver-efspjava-1 /usr/bin/java -cp /usr/src/app/target/efspserver-with-deps.jar edu.suffolk.litlab.efspserver.db.LoginDatabase \"servername\" true true
```

The API token to add to the docassemble config will be printed out.

## Testing

You can run tests with `mvn test`. By default, all tests will run, but you can also limit the types of tests that you run with different maven profiles.

* `mvn -PnoDockerTests test` will avoid tests that use docker. The Database tests spin up little docker containers to ensure that the queries work with Postgres. However, when this server is packaged up and run in a docker container, the nested docker enginer isn't available for the tests to run. So we need a way to avoid running those tests when packaging within docker.
* `mvn -Preproducible test` will avoid tests that changes on Tyler's side might break, i.e. anything that makes a connection to a staging server. Useful for running on PRs, as we don't want to block PRs on unrelated issues.
* `mvn -PtylerBreakable test` will **only** run tests that make a connection to Tyler staging servers. These are important to run routinely to ensure that we are aware of potentially breaking changes from the Tyler side.

These testing groups are maintained with [JUnit's Tag](https://junit.org/junit5/docs/current/user-guide/#writing-tests-tagging-and-filtering) feature; each tag is specified in the profile's `<group>` or `<excludedGroup>` in the [pom.xml](pom.xml).

### Integration Tests

Close any active running instance of the docker compose containers before running `integration_test.py`.

To run integration tests with coverage, do the following:

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

## Making Code Changes

Everything you need should be in [CONTRIBUTING.md](CONTRIBUTING.md).

