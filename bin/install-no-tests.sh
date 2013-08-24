#!/bin/sh

BASE_DIR=`dirname $0`

. $BASE_DIR/setenv.sh

rm -rf $BASE_DIR/target

mvn clean install -DskipTests -f $BASE_DIR/../common/pom.xml
mvn clean install -DskipTests -f $BASE_DIR/../domain/pom.xml
mvn clean install -DskipTests -f $BASE_DIR/../webapp/pom.xml
