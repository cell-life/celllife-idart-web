package org.celllife.idart.framework.json

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.jsontype.TypeSerializer

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-19
 * Time: 22h27
 */
class IdentifiableSerializer extends JsonSerializer<Object> {

    @Override
    void serialize(Object identifiable,
                   JsonGenerator generator,
                   SerializerProvider provider) throws IOException, JsonProcessingException {

        generator.writeFieldName("ids")
        generator.writeStartArray()
        identifiable.ids.each { id ->
            generator.writeStartObject()
            generator.writeFieldName("system")
            generator.writeString(id.system)
            generator.writeFieldName("value")
            generator.writeString(id.value)
            generator.writeEndObject()
        }
        generator.writeEndArray()
    }

    @Override
    void serializeWithType(Object identifiable,
                           JsonGenerator generator,
                           SerializerProvider provider,
                           TypeSerializer typeSerializer) throws IOException, JsonProcessingException {

        typeSerializer.writeTypePrefixForObject(identifiable, generator)
        serialize(identifiable, generator, provider)
        typeSerializer.writeTypeSuffixForObject(identifiable, generator)
    }
}
