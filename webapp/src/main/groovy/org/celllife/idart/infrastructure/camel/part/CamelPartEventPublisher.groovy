package org.celllife.idart.infrastructure.camel.part

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.part.PartEvent
import org.celllife.idart.domain.part.PartEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 * Camel Part Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelPartEventPublisher implements PartEventPublisher {

    @EndpointInject(uri = "direct:partEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(PartEvent partEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(partEvent))
    }
}
