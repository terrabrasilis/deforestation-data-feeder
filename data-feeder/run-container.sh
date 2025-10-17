#!/bin/bash

docker run -d --rm -e "SPRING_PROFILES_ACTIVE=prod" \
--name feeder -t terrabrasilis/data-feeder:$1