# Developer Setup

There are two different ways of running and developing on the proxy server:

1. Through Docker / Docker-Compose. This is how the server will run in production,
   so you do need to have this setup.
2. Locally on your own machine. This is not recommended or supported.
   These instructions are setup for Ubuntu / Windows Subsystem for Linux,
   but should be amenable for Macs.

## Docker

### Main Engine 

The official instructions are [on the docker site itself](https://docs.docker.com/engine/install/ubuntu/).
If those disagree with what's here, then go with those!

```bash
sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg \
    lsb-release
    
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
echo \
  "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null 
  
sudo apt-get update
sudo apt-get install docker-ce docker-ce-cli containerd.io
/etc/init.d/docker start
sudo usermod -aG docker $USER 
newgrp docker 
```

### Docker Compose 

Checkout the main [docker compose](https://docs.docker.com/compose/install/) 

```bash
sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
```

### Docassemble

We've also included a docker-compose file that spins up a docassemble server as well. You can 
use it by:

```bash
docker-compose -f docker-docassemble.yml
```

You will need to add some config values in docassemble's config to allow the docassemble server to communicate with the proxy, you can see [config.example](config.example) for documentation on those values. 

## Local Development 

Start with installing everything.

```bash
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt update
sudo apt install openjdk-15-jdk
```

We are using CXF as the SOAP client which supports up to JDK 15. Maybe could go back to version 11
```bash
sudo apt install maven
git clone git@github.com:SuffolkLITLab/EfileProxyServer.git
git clone git@github.com:SuffolkLITLab/docassemble-EFSPIntegration.git # (this might get merged into Assembly Line eventually)
```

Note: may not be able to run Eclipse with WSL2. VS Code is usable but
not a full IDE.

To run all of the unit tests in the project, use the following:

```bash
cd EfileProxyServer
mvn test 
```
 
## Contents of .env file

See env.example for the most up to date documentation for this.

Copy in `Suffolk.pfx` and `client_sign.properties` (also has the password that is in the .env file)
docker-compose up (this runs both servers and docassemble) (if you want to run in the background, you can add -d flag)

## It can take at least 30-40 minutes to download and start Docassemble on a midrange laptop
## TODO: do we want a way install all of the "stuff" into the Docassemble container?

## NOTE: it can take about 40 minutes to load all of the codes into the database. This only happens the first time you run it.
## If you do a docker-compose down it won't re-download the codes


## Internals

Two main server files:
AdminUserService.java
FilingReviewService.java
Email stuff will get integrated into:

1. FilingReviewService
2. Call back will be part of a new class in the services subfolder (java/edu/suffolk/litlab/efsperver/services/EfmCallback.java

New class will handle responses from Tyler. It should address logging and emailing the user. Probably eventually the state should be saved somewhere, at least for a short time.
We might want to integrate SMS notification in this endpoint too.
How do we want to handle the callback branding? Maybe allow Docassemble to send a template with the filing, so the user can understand who the message comes from?
There is a Jinja2 library for Java--it's maintained by HubSpot.

To install new libraries, we edit pom.xml in the root
Here is the installer for sendgrid:
```xml
        <dependency>
            <groupId>com.sendgrid</groupId>
            <artifactId>sendgrid-java</artifactId>
            <version>4.7.2</version>
        </dependency>
```
And for [twilio](https://www.twilio.com/docs/libraries/java):
```xml
<dependency>
  <groupId>com.twilio.sdk</groupId>
  <artifactId>twilio</artifactId>
  <version>8.15.0</version>
</dependency>       
```
        
## Creating an endpoint
[This REST/JAX book is extremely helpful](https://dennis-xlc.gitbooks.io/restful-java-with-jax-rs-2-0-2rd-edition/content/en/part1/chapter3/developing_a_jax_rs_restful_service.html).

Note: 
* proxy efsp will run on port 80/443

# TODO: we should set up a root endpoint for the proxy server which has a little bit of information about the server

Need to install on the docasemble server:
1. AssemblyLine
1. docassemble-EFSPIntegration
