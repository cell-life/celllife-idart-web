#!/bin/sh

BASE_DIR=`dirname $0`

. $BASE_DIR/setenv.sh

rm -rf $BASE_DIR/target

MAVEN_OPTS="-Xmx1024m -Xms1024m -XX:MaxPermSize=512m"
export MAVEN_OPTS

JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk1.7.0_13.jdk/Contents/Home/"
export JAVA_HOME

mvn clean install -DskipTests -f $BASE_DIR/../pom.xml
