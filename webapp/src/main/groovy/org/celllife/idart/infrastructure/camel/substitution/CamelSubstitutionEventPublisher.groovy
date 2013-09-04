package org.celllife.idart.infrastructure.camel.substitution

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.substitution.SubstitutionEvent
import org.celllife.idart.domain.substitution.SubstitutionEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 * Camel Substitution Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelSubstitutionEventPublisher implements SubstitutionEventPublisher {

    @EndpointInject(uri = "direct:substitutionEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(SubstitutionEvent substitutionEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(substitutionEvent))
    }
}
