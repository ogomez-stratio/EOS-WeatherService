FROM frolvlad/alpine-oraclejdk8:slim

VOLUME /tmp

ADD weatherService-0.0.1-SNAPSHOT.jar weatherService.jar

RUN sh -c 'touch /weatherService.jar'

ENV JAVA_OPTS="-Xmx512m -Xms256m"

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /weatherService.jar" ]

