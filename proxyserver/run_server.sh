#!/bin/bash

cp ../config/* target 
cd target

dotenv -f ../../.env run -- java -agentlib:jdwp=transport=dt_socket,server=y,address=5001,suspend=n -jar efspserver-with-deps.jar