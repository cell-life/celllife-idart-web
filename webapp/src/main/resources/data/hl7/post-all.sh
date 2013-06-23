#!/bin/sh

BASE_DIR=`dirname $0`

for i in `find $BASE_DIR -name *.sh`; do
    sh $i
done;