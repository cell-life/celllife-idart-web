#!/bin/sh

set -e

BASE_DIR=`dirname $0`

. ${BASE_DIR}/setenv.sh

rm -rf ${BASE_DIR}/target

START=$(date +%s)

# Build Webapp
mvn install -DskipTests -f ${BASE_DIR}/../webapp/pom.xml

# Build JBoss Bundle
mvn install -DskipTests -f ${BASE_DIR}/../jboss/pom.xml

# Start JBoss
ant -f ${BASE_DIR}/../jboss/target/celllife-idart-jboss/build.xml start

END=$(date +%s)

DIFF=$(( $END - $START ))

echo "It took ${DIFF} seconds"

