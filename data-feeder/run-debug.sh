#!/bin/bash

docker run --rm \
    -e "JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n" \
    -e "SPRING_PROFILES_ACTIVE=prod" \
    --name feeder -t terrabrasilis/data-feeder:$1