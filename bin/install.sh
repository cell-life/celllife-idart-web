#!/bin/sh

BASE_DIR=`dirname $0`

. $BASE_DIR/setenv.sh

rm -rf $BASE_DIR/target

MAVEN_OPTS="-Xmx1024m -Xms1024m -XX:MaxPermSize=512m" mvn clean install -f $BASE_DIR/../pom.xml
