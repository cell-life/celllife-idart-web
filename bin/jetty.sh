#!/bin/sh

BASE_DIR=`dirname $0`

. $BASE_DIR/setenv.sh

rm -rf $BASE_DIR/target

mvn clean -f $BASE_DIR/../pom.xml
mvn install -f $BASE_DIR/../codegen/pom.xml
mvn install -f $BASE_DIR/../domain/pom.xml

mvn install -DskipTests -Djetty.daemon=false -f $BASE_DIR/../webapp/pom.xml
