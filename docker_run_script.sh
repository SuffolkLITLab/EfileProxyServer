#! /bin/bash

set -e
cd /tmp/EfileProxyServer;
source .env

# Only expand stuff after sourcing, otherwise passwords end up in logs
set -x
/usr/bin/mvn exec:java
