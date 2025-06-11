FROM maven:3.8-eclipse-temurin-21 AS build
# The `[]` is an optional COPY: doesn't copy if those files aren't there (https://stackoverflow.com/a/46801962/11416267)
# They are needed for Tyler API usage, and serving the REST API as HTTPS
COPY pom.xml /usr/app/
COPY TylerEcf4 /usr/app/TylerEcf4/
COPY TylerEcf5 /usr/app/TylerEcf5/
COPY TylerEfmClient /usr/app/TylerEfmClient/
COPY proxyserver/pom.xml /usr/app/proxyserver/
# Install all of the maven packages, so we don't have to every time we change code
RUN mvn -f /usr/app/pom.xml -DskipTests clean dependency:resolve dependency:go-offline compile

COPY proxyserver /usr/app/proxyserver
RUN mvn -f /usr/app/pom.xml -DskipTests package -PnoDockerTests

FROM eclipse-temurin:21.0.7_6-jre-alpine AS release
COPY --from=build  /usr/app/proxyserver/target/efspserver-with-deps.jar /app/
COPY --from=build  /usr/app/proxyserver/src/main/config /app/src/main/config/
# The `[]` is an optional COPY: doesn't copy if those files aren't there (https://stackoverflow.com/a/46801962/11416267)
# They are needed for Tyler API usage, and serving the REST API as HTTPS
COPY LICENSE client_sign.propertie[s] quartz.properties Suffolk.pf[x] acme_user.ke[y] acme_domain.ke[y] acme_domain-chain.cr[t] extract-tls-secrets-4.0.0.ja[r] jacocoagent.ja[r] /app/
COPY docker_run_script.sh docker_integration_test.sh fly_startup_script.sh /app/

EXPOSE 9000

CMD [ "/bin/sh", "/app/docker_run_script.sh" ]
