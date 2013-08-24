#!/bin/sh

set -e

BASE_DIR=`dirname $0`

. $BASE_DIR/setenv.sh

rm -rf $BASE_DIR/target

mvn clean install -f $BASE_DIR/../database/pom.xml

ant -f $BASE_DIR/../database/target/celllife-idart-database/build.xml database-recreate