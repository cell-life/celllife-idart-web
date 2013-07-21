#!/bin/sh

curl -D /tmp/headers \
  -u internal:password \
  -XPOST \
  --data-binary @$(cd $(dirname $0); pwd;)/OrderableDrugForm.xls \
  -H "Content-Type: application/octet-stream" \
  http://localhost:9000/idart/forms/upload?structure=hl7

cat /tmp/headers
rm /tmp/headers