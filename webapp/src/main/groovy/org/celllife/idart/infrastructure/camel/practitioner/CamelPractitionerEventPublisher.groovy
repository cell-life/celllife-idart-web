package org.celllife.idart.infrastructure.camel.practitioner

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.practitioner.PractitionerEvent
import org.celllife.idart.domain.practitioner.PractitionerEventPublisher

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.framework.security.Principals.currentUsername

/**
 * Camel Practitioner Event Publisher
 */
@Named class CamelPractitionerEventPublisher implements PractitionerEventPublisher {

    @EndpointInject(uri = "direct:practitionerEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(PractitionerEvent practitionerEvent) {

        practitionerEvent.username = currentUsername

        producerTemplate.sendBody(objectMapper.writeValueAsString(practitionerEvent))
    }
}
