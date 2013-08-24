package org.celllife.idart.infrastructure.camel.part

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.part.PartEvent
import org.celllife.idart.domain.part.PartEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Part Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelPartEventPublisher implements PartEventPublisher {

    @EndpointInject(uri = "direct:partEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(PartEvent partEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(partEvent))
    }
}
