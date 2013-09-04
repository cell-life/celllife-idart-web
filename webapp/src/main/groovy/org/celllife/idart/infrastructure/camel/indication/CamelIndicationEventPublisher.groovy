package org.celllife.idart.infrastructure.camel.indication

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.indication.IndicationEvent
import org.celllife.idart.domain.indication.IndicationEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 * Camel Indication Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelIndicationEventPublisher implements IndicationEventPublisher {

    @EndpointInject(uri = "direct:indicationEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(IndicationEvent indicationEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(indicationEvent))
    }
}
