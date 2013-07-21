package org.celllife.idart.framework.json

import com.fasterxml.jackson.core.JsonEncoding
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.http.HttpOutputMessage
import org.springframework.http.converter.HttpMessageNotWritableException
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl

import java.lang.reflect.Type

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 09h51
 */
class IdartMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

    boolean prefixJson

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException,
            HttpMessageNotWritableException {

        JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
        JsonGenerator jsonGenerator =
            this.objectMapper.getJsonFactory().createJsonGenerator(outputMessage.getBody(), encoding);

        // A workaround for JsonGenerators not applying serialization features
        // https://github.com/FasterXML/jackson-databind/issues/12
        if (this.objectMapper.isEnabled(SerializationFeature.INDENT_OUTPUT)) {
            jsonGenerator.useDefaultPrettyPrinter();
        }

        try {
            if (this.prefixJson) {
                jsonGenerator.writeRaw("{} && ");
            }

            if (object in Iterable) {
                def iterator = ((Iterable) object).iterator()
                if (iterator.hasNext()) {
                    def clazz = iterator.next().class
                    def type = ParameterizedTypeImpl.make(object.class, [clazz] as Type[], null)
                    this.objectMapper.writerWithType(new ExplicitTypeReference(type)).writeValue(jsonGenerator, object);
                    return
                }
            }

            this.objectMapper.writeValue(jsonGenerator, object);
        }
        catch (JsonProcessingException ex) {
            throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
        }
    }
}
