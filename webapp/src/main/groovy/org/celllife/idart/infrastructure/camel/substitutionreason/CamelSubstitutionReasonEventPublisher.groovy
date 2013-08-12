package org.celllife.idart.infrastructure.camel.substitutionreason

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonEvent
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Substitution Reason Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelSubstitutionReasonEventPublisher implements SubstitutionReasonEventPublisher {

    @EndpointInject(uri = "direct:substitutionReasonEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(SubstitutionReasonEvent substitutionReasonEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(substitutionReasonEvent))
    }
}
