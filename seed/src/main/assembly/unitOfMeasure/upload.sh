#!/bin/sh

curl -D /tmp/headers \
  -u internal:password \
  -XPOST \
  --data-binary @$(cd $(dirname $0); pwd;)/idart.json \
  -H "Content-Type: application/octet-stream" \
  http://localhost:8080/idart/unitsOfMeasure/upload?structure=idart

cat /tmp/headers

curl -D /tmp/headers \
  -u internal:password \
  -XPOST \
  --data-binary @$(cd $(dirname $0); pwd;)/ucum.tsv \
  -H "Content-Type: application/octet-stream" \
  http://localhost:8080/idart/unitsOfMeasure/upload?structure=ucum

cat /tmp/headers

rm /tmp/headers