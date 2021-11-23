#!/bin/bash

#VERSION=$(git describe --tags --abbrev=0)
VERSION=$(cat redis-api/package.json | grep -oP '(?<="version": ")[^"]*')
export VERSION

# --no-cache
docker build -t terrabrasilis/redis-api:v$VERSION -f redis-api.dockerfile .

# send to dockerhub
# docker login
docker push terrabrasilis/redis-api:v$VERSION