#!/bin/sh

. $HOME/.profile

BASE_DIR=$(cd $(dirname $0); pwd)

cd $BASE_DIR

/usr/local/Cellar/node08/0.8.24/bin/npm install

/usr/local/Cellar/node08/0.8.24/bin/node /usr/local/share/npm/bin/bower install

/usr/local/Cellar/node08/0.8.24/bin/node /usr/local/share/npm/bin/grunt --force