#! /bin/sh

set -e

# Download cert from encrypted storage if on fly.io
if test -n "$FLY_MACHINE_ID"; then
  echo "Running Fly.io startup checks..."
  if ! test -f "$PATH_TO_KEYSTORE"; then
    echo "Installing cert"
    apt update && apt install awscli
    aws s3 cp "$S3_TO_KEYSTORE_CERT" .
  fi
  if ! test -f "client_sign.properties"; then
    echo "Installing client_sign.properties"
    apt update && apt install awscli
    aws s3 cp "$S3_TO_CLIENT_SIGN_PROPERTIES" .
  fi
fi
