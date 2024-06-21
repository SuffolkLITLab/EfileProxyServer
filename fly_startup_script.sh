#! /bin/sh

set -e

# Download cert from encrypted storage if on fly.io
if test -n "$FLY_MACHINE_ID"; then
  echo "Running Fly.io startup checks..."
  if ! test -f "$PATH_TO_KEYSTORE"; then
    echo "Installing cert"
    apk add --no-cache aws-cli
    aws s3 cp $S3_TO_KEYSTORE_CERT .
  fi
fi
