package org.celllife.idart.framework.json

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component

/**
 * User: Kevin W. Sewell
 * Date: 2013-06-22
 * Time: 20h23
 */
@Component
class IdartObjectMapper extends ObjectMapper {

    IdartObjectMapper() {

        setSerializationInclusion(JsonInclude.Include.NON_NULL)

        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }
}
