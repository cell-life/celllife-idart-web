#!/bin/sh

set -e

BASE_DIR=`dirname $0`

. ${BASE_DIR}/setenv.sh

rm -rf ${BASE_DIR}/target

JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk1.7.0_13.jdk/Contents/Home/"
export JAVA_HOME

MAVEN_OPTS="-Xmx1024m -Xms1024m -XX:MaxPermSize=512m"
export MAVEN_OPTS

ant -f ${BASE_DIR}/../jboss/target/celllife-idart-jboss/build.xml jboss-stop