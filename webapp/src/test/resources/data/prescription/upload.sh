#!/bin/sh

CREDENTIALS="internal:password"
CONTENT_TYPE_HEADER="Content-Type: application/json"
IDART_APPLICATION_ID_HEADER="X-IDART_APPLICATION_ID: 2AEFB796-8501-45C3-A0CE-3818088D338D"

cd $(cd $(dirname $0); pwd;)

#for FILE in `find $(cd $(dirname $0); pwd;) -name *.json`; do
#  curl -XPOST \
#    -D /tmp/headers \
#    -u "${CREDENTIALS}" \
#    -d @$FILE \
#    -H "${CONTENT_TYPE_HEADER}" \
#    http://localhost:9000/idart/prescriptions
#  cat /tmp/headers
#done

curl -XPOST \
 -D /tmp/headers \
 -u "${CREDENTIALS}" \
 -d @0001.json \
 -H "${CONTENT_TYPE_HEADER}" \
 -H "${IDART_APPLICATION_ID_HEADER}" \
 http://localhost:9000/idart/clinics/999999/prescriptions

cat /tmp/headers