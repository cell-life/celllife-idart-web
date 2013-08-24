#!/bin/sh

BASE_DIR=$(cd $(dirname $0); pwd;)

# Concepts
sh $BASE_DIR/form/upload.sh
sh $BASE_DIR/route/upload.sh
sh $BASE_DIR/unitOfMeasure/upload.sh

# Instances
sh $BASE_DIR/clinic/upload.sh
sh $BASE_DIR/compound/upload.sh
sh $BASE_DIR/counter/upload.sh
sh $BASE_DIR/drug/upload.sh
sh $BASE_DIR/medication/upload.sh
sh $BASE_DIR/defaultDosageInstruction/upload.sh