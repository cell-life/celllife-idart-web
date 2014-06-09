#!/bin/sh

MAVEN_OPTS="-Xmx1024m -Xms1024m -XX:MaxPermSize=512m"
export MAVEN_OPTS

BASE_DIR=$(cd $(dirname $0); pwd)

IDARTWEB_APPLICATION_PROPERTIES=$BASE_DIR/../etc/application.properties
export IDARTWEB_APPLICATION_PROPERTIES