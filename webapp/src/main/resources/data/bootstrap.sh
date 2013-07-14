#!/bin/sh

BASE_DIR=$(cd $(dirname $0); pwd;)

# Concepts
sh $BASE_DIR/form/upload.sh
sh $BASE_DIR/route/upload.sh
sh $BASE_DIR/unitOfMeasure/upload.sh

# Instances
sh $BASE_DIR/rawMaterial/upload.sh
sh $BASE_DIR/finishedGood/upload.sh
sh $BASE_DIR/good/upload.sh
sh $BASE_DIR/defaultDosageInstruction/upload.sh