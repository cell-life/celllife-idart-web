package org.celllife.idart.infrastructure.camel.person

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.person.PersonEvent
import org.celllife.idart.domain.person.PersonEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 * Camel Person Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelPersonEventPublisher implements PersonEventPublisher {

    @EndpointInject(uri = "direct:personEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(PersonEvent personEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(personEvent))
    }
}
