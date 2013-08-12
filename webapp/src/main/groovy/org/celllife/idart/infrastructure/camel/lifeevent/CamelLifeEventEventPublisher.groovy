package org.celllife.idart.infrastructure.camel.lifeevent

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.lifeevent.LifeEventEvent
import org.celllife.idart.domain.lifeevent.LifeEventEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Life Event Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelLifeEventEventPublisher implements LifeEventEventPublisher {

    @EndpointInject(uri = "direct:lifeEventEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(LifeEventEvent lifeEventEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(lifeEventEvent))
    }
}
