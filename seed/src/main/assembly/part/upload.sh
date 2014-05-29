#!/bin/sh

set -e

CREDENTIALS="internal:password"
CONTENT_TYPE_HEADER="Content-Type: application/json"

for FILE in `find $(cd $(dirname $0); pwd;) -name "*.json" | xargs ls`; do
  echo $FILE
  curl -XPOST \
    -D /tmp/headers \
    -u "${CREDENTIALS}" \
    -d @$FILE \
    -H "${CONTENT_TYPE_HEADER}" \
    http://localhost:8080/idart/parts
  cat /tmp/headers
  sleep 1
done
