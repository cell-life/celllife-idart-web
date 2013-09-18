package org.celllife.idart.infrastructure.camel.substitutionreason

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonEvent
import org.celllife.idart.domain.substitutionreason.SubstitutionReasonEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.framework.security.Principals.currentUsername

/**
 * Camel Substitution Reason Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelSubstitutionReasonEventPublisher implements SubstitutionReasonEventPublisher {

    @EndpointInject(uri = "direct:substitutionReasonEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(SubstitutionReasonEvent substitutionReasonEvent) {

        substitutionReasonEvent.username = currentUsername

        producerTemplate.sendBody(objectMapper.writeValueAsString(substitutionReasonEvent))
    }
}
