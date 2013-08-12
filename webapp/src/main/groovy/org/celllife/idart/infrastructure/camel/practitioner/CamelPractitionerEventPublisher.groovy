package org.celllife.idart.infrastructure.camel.practitioner

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.practitioner.PractitionerEvent
import org.celllife.idart.domain.practitioner.PractitionerEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Practitioner Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelPractitionerEventPublisher implements PractitionerEventPublisher {

    @EndpointInject(uri = "direct:practitionerEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(PractitionerEvent practitionerEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(practitionerEvent))
    }
}
