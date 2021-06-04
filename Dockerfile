FROM maven:3.8.1-openjdk-15 AS build
COPY pom.xml docker_run_script.sh client_sign.properties Suffolk.pfx /usr/src/app/
RUN mvn -f /usr/src/app/pom.xml dependency:resolve
COPY src /usr/src/app/src
RUN mvn -f /usr/src/app/pom.xml clean package && mvn -f /usr/src/app/pom.xml dependency:build-classpath -Dmdep.outputFile=cp.txt

#FROM maven:3.8.1-openjdk-15-slim
#COPY --from=build /usr/src/app/target/assemblyline-efsp-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 9000

CMD [ "/bin/sh", "/usr/src/app/docker_run_script.sh" ]
#CMD ["java", "-jar", "/usr/local/lib/demo.jar"]
#CMD ["java", "-cp", "$(cat /usr/src/app/cp.txt):/usr/src/app/target/assemblyline-efsp-0.0.1-SNAPSHOT.jar", "edu.suffolk.assemblyline.efspserver.services.EfspServer"]
