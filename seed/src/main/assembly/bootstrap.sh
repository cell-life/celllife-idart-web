#!/bin/sh

set -e

BASE_DIR=$(cd $(dirname $0); pwd;)

sh $BASE_DIR/facility/upload.sh
sh $BASE_DIR/organisation/upload.sh
sh $BASE_DIR/facilityorganisation/upload.sh
sh $BASE_DIR/part/upload.sh
sh $BASE_DIR/product/upload.sh
sh $BASE_DIR/system/upload.sh
sh $BASE_DIR/systemfacility/upload.sh
sh $BASE_DIR/user/upload.sh
