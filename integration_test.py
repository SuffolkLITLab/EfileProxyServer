#!/usr/bin/env python3

import os
import time
import requests
from docassemble.EFSPIntegration.test import integration_test

from plumbum import local, FG, BG

if not os.path.exists("target"):
  os.mkdir("target")

docker_compose = local.cmd.docker['compose', '-f', 'docker-integration-test.yml']
docker_compose['build'] & FG
docker_compose['up', '-d'] & FG

server_up = False
while not server_up:
  try:
    r = requests.get("http://localhost:9100/")
    if r.ok:
      server_up = True
  except:
    pass
  time.sleep(5)

with open("proxy_stuff.txt") as f:
  for line in f:
    if line.startswith("New Api Key for"):
      proxy_key = line.split(": ")[1].strip()
      break

integration_test.main(base_url="http://localhost:9100/", api_key=proxy_key, user_email=os.getenv("TYLER_USER_EMAIL"), user_password=os.getenv("TYLER_USER_PASSWORD"))

docker_compose['down', '--timeout', '60', '--rmi', 'local'] & FG
