#!/bin/sh

curl -D headers \
  -u internal:password \
  -XPOST \
  --data-binary @$1 \
  -H "Content-Type: application/octet-stream" \
  http://localhost:9000/idart/service/codes/$2?structure=hl7

cat headers