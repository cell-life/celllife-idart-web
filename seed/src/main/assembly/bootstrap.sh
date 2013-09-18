#!/bin/sh

BASE_DIR=$(cd $(dirname $0); pwd;)

# Concepts
sh $BASE_DIR/form/upload.sh
sh $BASE_DIR/route/upload.sh
sh $BASE_DIR/unitOfMeasure/upload.sh

# Instances
sh $BASE_DIR/counter/upload.sh
sh $BASE_DIR/facility/upload.sh
sh $BASE_DIR/facilityorganisation/upload.sh
sh $BASE_DIR/part/upload.sh
sh $BASE_DIR/product/upload.sh
sh $BASE_DIR/system/upload.sh
sh $BASE_DIR/systemfacility/upload.sh
sh $BASE_DIR/defaultDosageInstruction/upload.sh