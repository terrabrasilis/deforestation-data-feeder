#!/bin/bash

docker run -d --rm -e "SPRING_PROFILES_ACTIVE=prod" -p 8090:8080 --name feeder -t terrabrasilis/redis-feeder:$1