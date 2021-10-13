#!/bin/bash

# Update the Proxy code itself
git fetch --all
git pull origin main

# Update the java docker image
docker pull maven:3.8-openjdk-17

# Update the docassemble docker image
docker pull jhpyle/docassemble && docker pull jhpyle/docassemble-os

# Update postgres
docker pull postgres:14

