#!/bin/sh

BASE_DIR=$(cd $(dirname $0); pwd;)

CREDENTIALS="internal:password"
CONTENT_TYPE_HEADER="Content-Type: application/json"

cd ${BASE_DIR}

for FILE in `ls *.json`; do
  curl -XPOST \
    -D /tmp/headers \
    -u "${CREDENTIALS}" \
    -d @$FILE \
    -H "${CONTENT_TYPE_HEADER}" \
    http://localhost:9000/idart/atcClassifications
  cat /tmp/headers
done

cd -