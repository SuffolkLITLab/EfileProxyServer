#!/bin/bash
#prints the configured Tyler API versions from the given env's properties file

ENV=${1:-stage}
PROPERTIES_FILE="config/application.${ENV}.properties"

if [ ! -f "$PROPERTIES_FILE" ]; then
  echo "Error: could not find $PROPERTIES_FILE"
  exit 1
fi

echo "Tyler versions configured in $PROPERTIES_FILE:"
grep "^edu.suffolk.litlab.efsp.tyler.version\." "$PROPERTIES_FILE" | while IFS='=' read -r key value; do
  jurisdiction=$(echo "$key" | sed 's/.*\.//')
  echo "  $jurisdiction = $(echo "$value" | tr -d ' ')"
done