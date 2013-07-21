#!/bin/sh

BASE_DIR=`dirname $0`

. $BASE_DIR/setenv.sh

rm -rf $BASE_DIR/target

JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk1.7.0_13.jdk/Contents/Home/"
export JAVA_HOME

mvn clean -f $BASE_DIR/../pom.xml
mvn install -f $BASE_DIR/../codegen/pom.xml
mvn compile -f $BASE_DIR/../webapp/pom.xml
