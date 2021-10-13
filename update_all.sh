#!/bin/bash

# Update the Proxy code itself
git fetch --all
git pull origin main

# Update the java, debian, and postgres base docker images
docker pull maven:3.8-openjdk-17 && 
    docker pull debian:testing
    docker pull postgres:14

# Update the docassemble docker image
git clone https://github.com/jhpyle/docassemble-os
(cd docassemble-os && docker build . -t jhpyle/docassemble-os)
git clone https://github.com/jhpyle/docassemble
(cd docassemble && docker build . -t jhpyle/docassemble)

