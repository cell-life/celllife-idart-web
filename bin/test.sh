#!/bin/sh

set -e

BASE_DIR=`dirname $0`

. ${BASE_DIR}/setenv.sh

rm -rf ${BASE_DIR}/target

START=$(date +%s)

echo ${BASE_DIR}
echo ${JAVA_HOME}

# Clean
mvn clean -f ${BASE_DIR}/../pom.xml
