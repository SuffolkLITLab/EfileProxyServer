FROM maven:3.8.1-openjdk-15 AS build
COPY pom.xml client_sign.properties Suffolk.pfx /usr/src/app/
# Install all of the maven packages, so we don't have to every time we change code
RUN mvn -f /usr/src/app/pom.xml clean dependency:resolve test package
COPY src /usr/src/app/src
RUN mvn -f /usr/src/app/pom.xml package dependency:build-classpath -Dmdep.outputFile=cp.txt
COPY docker_run_script.sh /usr/src/app

EXPOSE 9000

CMD [ "/bin/sh", "/usr/src/app/docker_run_script.sh" ]
