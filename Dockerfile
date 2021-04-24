# TODO(brycew): (edit the java config file as well?)
FROM ubuntu:20.04
RUN apt-get update && apt-get install -y software-properties-common && \
    add-apt-repository ppa:openjdk-r/ppa && \
    apt-get update && \ 
    apt-get install -y openjdk-15-jdk openjdk-15-jre maven && \
    apt-get install -y postgresql

COPY . /tmp/efileproxyserver
RUN cd /tmp/efileproxyserver && mvn install && mvn compile

# TODO(brycew): This doesn't work, possibly because the resources aren't packaged, or because it's still in the wrong dir
CMD ["/usr/bin/mvn", "-f", "/tmp/efileproxyserver/pom.xml", "exec:java"]
