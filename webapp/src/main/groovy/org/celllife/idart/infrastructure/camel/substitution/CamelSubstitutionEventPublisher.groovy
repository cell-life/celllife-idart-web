package org.celllife.idart.infrastructure.camel.substitution

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.substitution.SubstitutionEvent
import org.celllife.idart.domain.substitution.SubstitutionEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Substitution Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelSubstitutionEventPublisher implements SubstitutionEventPublisher {

    @EndpointInject(uri = "direct:substitutionEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(SubstitutionEvent substitutionEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(substitutionEvent))
    }
}
