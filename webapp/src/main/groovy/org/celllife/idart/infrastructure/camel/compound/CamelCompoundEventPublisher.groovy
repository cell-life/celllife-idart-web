package org.celllife.idart.infrastructure.camel.compound

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.compound.CompoundEvent
import org.celllife.idart.domain.compound.CompoundEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Compound Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelCompoundEventPublisher implements CompoundEventPublisher {

    @EndpointInject(uri = "direct:compoundEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(CompoundEvent compoundEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(compoundEvent))
    }
}
