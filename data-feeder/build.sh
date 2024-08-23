#!/bin/bash

## the pom.xml was configured to command MVN INSTALL already install, build and push to Docker HUB
mvn install

## build data-feeder
#mvn install dockerfile:build

## push data-feeder (terrabrasilis/data-feeder:0.0.1)
#docker login && mvn dockerfile:push