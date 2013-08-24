#!/bin/sh

set -e

BASE_DIR=`dirname $0`

. ${BASE_DIR}/setenv.sh

rm -rf ${BASE_DIR}/target

START=$(date +%s)

# Clean
mvn clean -f ${BASE_DIR}/../pom.xml

# Build Database Bundle
mvn install -DskipTests -f ${BASE_DIR}/../database/pom.xml

# Recreate Database
ant -f ${BASE_DIR}/../database/target/celllife-idart-database/build.xml database-recreate

# Build Model and Codegen Bundles
mvn install -DskipTests -f ${BASE_DIR}/../model/pom.xml
mvn install -DskipTests -f ${BASE_DIR}/../codegen/pom.xml

# Regenerate Code
ant -f ${BASE_DIR}/../codegen/target/celllife-idart-codegen/build.xml -Dproject.baseDir=${BASE_DIR}/..

# Build Domain and Webapp
mvn install -DskipTests -f ${BASE_DIR}/../common/pom.xml
mvn install -DskipTests -f ${BASE_DIR}/../domain/pom.xml
mvn install -DskipTests -f ${BASE_DIR}/../webapp/pom.xml

# Build JBoss Bundle
mvn install -DskipTests -f ${BASE_DIR}/../jboss/pom.xml

# Start JBoss
ant -f ${BASE_DIR}/../jboss/target/celllife-idart-jboss/build.xml start

END=$(date +%s)

DIFF=$(( $END - $START ))

echo "It took ${DIFF} seconds"