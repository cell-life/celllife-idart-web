#!/bin/sh

set -e

BASE_DIR=`dirname $0`

. ${BASE_DIR}/setenv.sh

rm -rf ${BASE_DIR}/target

mvn install -DskipTests -f ${BASE_DIR}/../jboss/pom.xml

ant -f ${BASE_DIR}/../jboss/target/celllife-idart-jboss/build.xml start