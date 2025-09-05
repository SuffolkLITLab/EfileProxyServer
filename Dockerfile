FROM maven:3.8-eclipse-temurin-21 AS build
ARG CI_COMMIT_SHA
LABEL git-commit=$CI_COMMIT_SHA
# The `[]` is an optional COPY: doesn't copy if those files aren't there (https://stackoverflow.com/a/46801962/11416267)
# They are needed for Tyler API usage
COPY pom.xml /app/
COPY TylerEcf4 /app/TylerEcf4/
COPY TylerEcf5 /app/TylerEcf5/
COPY TylerEfmClient /app/TylerEfmClient/
COPY proxyserver/pom.xml proxyserver/enunciate.xml /app/proxyserver/
# Install all of the maven packages, so we don't have to every time we change code
RUN mvn -f /app/pom.xml -DskipTests clean dependency:resolve dependency:go-offline compile

COPY proxyserver /app/proxyserver
RUN mvn -f /app/pom.xml -DskipTests package -PnoDockerTests -Dbuild.revision=$CI_COMMIT_SHA && cp /app/proxyserver/target/efspserver-with-deps.jar /app/
COPY config /app/
# The `[]` is an optional COPY: doesn't copy if those files aren't there (https://stackoverflow.com/a/46801962/11416267)
# They are needed for Tyler API usage
COPY LICENSE extract-tls-secrets-4.0.0.ja[r] jacocoagent.ja[r] /app/
COPY Docker/docker_run_dev.sh /app/

EXPOSE 9000
CMD [ "/bin/sh", "/app/docker_run_dev.sh" ]

FROM eclipse-temurin:21.0.7_6-jre-alpine AS release
ARG CI_COMMIT_SHA
LABEL git-commit=$CI_COMMIT_SHA
COPY --from=build  /app/proxyserver/target/efspserver-with-deps.jar /app/
COPY config /app/
COPY LICENSE config/client_sign.propertie[s] config/quartz.properties config/Suffolk.pf[x] /app/
COPY Docker/docker_run_script.sh Docker/fly_startup_script.sh /app/

EXPOSE 9000
CMD [ "/bin/sh", "/app/docker_run_script.sh" ]
