# TODO(brycew): (edit the java config file as well?)
FROM ubuntu:20.04
RUN apt-get update && apt-get install -y software-properties-common && \
    add-apt-repository ppa:openjdk-r/ppa && \
    apt-get update && \ 
    apt-get install -y openjdk-15-jdk openjdk-15-jre maven

COPY . /tmp/EfileProxyServer
RUN cd /tmp/EfileProxyServer && mvn compile && mvn package 

CMD ["/bin/bash", "/tmp/EfileProxyServer/docker_run_script.sh"]
