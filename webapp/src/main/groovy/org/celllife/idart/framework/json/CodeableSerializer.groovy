package org.celllife.idart.framework.json

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-19
 * Time: 22h27
 */
class CodeableSerializer extends JsonSerializer<Object> {

    @Override
    void serialize(Object codeable,
                   JsonGenerator generator,
                   SerializerProvider provider) throws IOException, JsonProcessingException {

        generator.writeStartObject()
        generator.writeFieldName("codes")
        generator.writeObject(codeable.codes)
        generator.writeEndObject()
    }
}
