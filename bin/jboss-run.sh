#!/bin/sh

set -e

BASE_DIR=`dirname $0`

. ${BASE_DIR}/setenv.sh

rm -rf ${BASE_DIR}/target

mvn clean -f ${BASE_DIR}/../pom.xml
mvn install -DskipTests -f ${BASE_DIR}/../common/pom.xml
mvn install -DskipTests -f ${BASE_DIR}/../domain/pom.xml
mvn install -DskipTests -f ${BASE_DIR}/../webapp/pom.xml
mvn install -DskipTests -f ${BASE_DIR}/../jboss/pom.xml

ant -f ${BASE_DIR}/../jboss/target/celllife-idart-jboss/build.xml run