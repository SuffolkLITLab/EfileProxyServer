FROM maven:3.8-eclipse-temurin-17-alpine
# The `[]` is an optional COPY: doesn't copy if those files aren't there (https://stackoverflow.com/a/46801962/11416267)
# They are needed for Tyler API usage, and serving the REST API as HTTPS
COPY pom.xml LICENSE client_sign.propertie[s] quartz.properties Suffolk.pf[x] acme_user.ke[y] acme_domain.ke[y] acme_domain-chain.cr[t] extract-tls-secrets-4.0.0.ja[r] jacocoagent.ja[r] /usr/src/app/
# Install all of the maven packages, so we don't have to every time we change code
RUN mvn -f /usr/src/app/pom.xml -DskipTests clean dependency:resolve dependency:go-offline package && mvn -f /usr/src/app/pom.xml test
COPY src /usr/src/app/src
RUN mvn -f /usr/src/app/pom.xml -DskipTests package dependency:build-classpath -Dmdep.outputFile=cp.txt -PnoDockerTests
COPY docker_run_script.sh docker_integration_test.sh /usr/src/app/

EXPOSE 9000

CMD [ "/bin/sh", "/usr/src/app/docker_run_script.sh" ]
