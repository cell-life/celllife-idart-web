#!/bin/sh

curl -D /tmp/headers \
  -u internal:password \
  -XPOST \
  --data-binary @$(cd $(dirname $0); pwd;)/RouteOfAdministration.xls \
  -H "Content-Type: application/octet-stream" \
  http://localhost:8080/idart/routes/upload?structure=hl7

cat /tmp/headers
rm /tmp/headers