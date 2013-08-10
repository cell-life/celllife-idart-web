#!/bin/sh

set -e

BASE_DIR=`dirname $0`

. $BASE_DIR/setenv.sh

rm -rf $BASE_DIR/target

JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk1.7.0_13.jdk/Contents/Home/"
export JAVA_HOME

mvn clean -f $BASE_DIR/../pom.xml
mvn install -f $BASE_DIR/../codegen/pom.xml

ant -f $BASE_DIR/../codegen/target/celllife-idart-codegen/build.xml \
  -Dproject.baseDir=$BASE_DIR/.. \
  -Dproject.baseNamespace=http://www.cell-life.org/idart \
  -Dproject.modelFile=$BASE_DIR/../model/aggregateRoots.json
