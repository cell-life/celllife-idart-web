#!/bin/sh

. $HOME/.profile

BASE_DIR=$(cd $(dirname $0); pwd)

cd $BASE_DIR

/usr/local/bin/node /usr/local/share/npm/bin/grunt --force watch