package org.celllife.idart.infrastructure.camel.person

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.person.PersonEvent
import org.celllife.idart.domain.person.PersonEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Person Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelPersonEventPublisher implements PersonEventPublisher {

    @EndpointInject(uri = "direct:personEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(PersonEvent personEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(personEvent))
    }
}
