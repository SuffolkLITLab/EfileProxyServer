FROM maven:3.8-eclipse-temurin-21 AS build
# The `[]` is an optional COPY: doesn't copy if those files aren't there (https://stackoverflow.com/a/46801962/11416267)
# They are needed for Tyler API usage, and serving the REST API as HTTPS
COPY pom.xml /app/
COPY TylerEcf4 /app/TylerEcf4/
COPY TylerEcf5 /app/TylerEcf5/
COPY TylerEfmClient /app/TylerEfmClient/
COPY proxyserver/pom.xml proxyserver/enunciate.xml /app/proxyserver/
# Install all of the maven packages, so we don't have to every time we change code
RUN mvn -f /app/pom.xml -DskipTests clean dependency:resolve dependency:go-offline compile

COPY proxyserver /app/proxyserver
RUN mvn -f /app/pom.xml -DskipTests package -PnoDockerTests && cp /app/proxyserver/target/efspserver-with-deps.jar /app/
COPY LICENSE client_sign.propertie[s] quartz.properties Suffolk.pf[x] acme_user.ke[y] acme_domain.ke[y] acme_domain-chain.cr[t] extract-tls-secrets-4.0.0.ja[r] jacocoagent.ja[r] /app/
COPY docker_run_dev.sh /app/

EXPOSE 9000
CMD [ "/bin/sh", "/app/docker_run_dev.sh" ]

FROM eclipse-temurin:21.0.7_6-jre-alpine AS release
COPY --from=build  /app/proxyserver/target/efspserver-with-deps.jar /app/
COPY --from=build  /app/proxyserver/src/main/config /app/src/main/config/
# The `[]` is an optional COPY: doesn't copy if those files aren't there (https://stackoverflow.com/a/46801962/11416267)
# They are needed for Tyler API usage, and serving the REST API as HTTPS
COPY LICENSE client_sign.propertie[s] quartz.properties Suffolk.pf[x] acme_user.ke[y] acme_domain.ke[y] acme_domain-chain.cr[t] /app/
COPY docker_run_script.sh fly_startup_script.sh /app/

EXPOSE 9000
CMD [ "/bin/sh", "/app/docker_run_script.sh" ]
