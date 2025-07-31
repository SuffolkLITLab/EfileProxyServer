#!/bin/bash

dotenv -f ../.env run -- java -agentlib:jdwp=transport=dt_socket,server=y,address=5001,suspend=n -jar target/efspserver-with-deps.jar