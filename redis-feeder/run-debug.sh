#!/bin/bash

docker run --rm \
    -e "JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n" \
    -e "SPRING_PROFILES_ACTIVE=prod" \
    -p 8090:8080 -p 5005:5005 --name feeder -t terrabrasilis/redis-feeder:$1