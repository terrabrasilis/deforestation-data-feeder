FROM openjdk:8-jdk-alpine

LABEL Jether Rodrigues<jetherrodrigues@gmail.com>

RUN apk update \
  && apk add --no-cache --update tzdata

# define the timezone to run cron
ENV TZ=America/Sao_Paulo

VOLUME /tmp

ARG JAR_FILE
COPY ${JAR_FILE} redis-feeder.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dfile.encoding=UTF-8", "-jar","/redis-feeder.jar"]