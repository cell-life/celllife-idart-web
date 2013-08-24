package org.celllife.idart.infrastructure.camel.indication

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.indication.IndicationEvent
import org.celllife.idart.domain.indication.IndicationEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Indication Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelIndicationEventPublisher implements IndicationEventPublisher {

    @EndpointInject(uri = "direct:indicationEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(IndicationEvent indicationEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(indicationEvent))
    }
}