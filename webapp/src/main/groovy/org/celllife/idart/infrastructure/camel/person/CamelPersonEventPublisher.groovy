package org.celllife.idart.infrastructure.camel.person

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.person.PersonEvent
import org.celllife.idart.domain.person.PersonEventPublisher

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.framework.security.Principals.currentUsername

/**
 * Camel Person Event Publisher
 */
@Named class CamelPersonEventPublisher implements PersonEventPublisher {

    @EndpointInject(uri = "direct:personEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(PersonEvent personEvent) {

        personEvent.username = currentUsername

        producerTemplate.sendBody(objectMapper.writeValueAsString(personEvent))
    }
}
