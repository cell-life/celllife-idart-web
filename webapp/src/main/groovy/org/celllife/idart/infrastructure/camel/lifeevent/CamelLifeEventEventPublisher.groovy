package org.celllife.idart.infrastructure.camel.lifeevent

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.lifeevent.LifeEventEvent
import org.celllife.idart.domain.lifeevent.LifeEventEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 * Camel Life Event Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelLifeEventEventPublisher implements LifeEventEventPublisher {

    @EndpointInject(uri = "direct:lifeEventEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(LifeEventEvent lifeEventEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(lifeEventEvent))
    }
}
