FROM anapsix/alpine-java

MAINTAINER Cris Daniluk <cris.daniluk@ctr.salientcrgt.com>
ENV JAVA_OPTS="-Dspring.profiles.active=development"

RUN mkdir /opt/springboot
COPY target/fec-ef-app-0.0.1-SNAPSHOT.jar /opt/springboot/

ENTRYPOINT ["/opt/jdk/bin/java"]
CMD ["-jar", "/opt/springboot/fec-ef-app-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
