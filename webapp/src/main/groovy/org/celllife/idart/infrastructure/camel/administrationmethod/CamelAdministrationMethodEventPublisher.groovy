package org.celllife.idart.infrastructure.camel.administrationmethod

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.administrationmethod.AdministrationMethodEvent
import org.celllife.idart.domain.administrationmethod.AdministrationMethodEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Administration Method Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelAdministrationMethodEventPublisher implements AdministrationMethodEventPublisher {

    @EndpointInject(uri = "direct:administrationMethodEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(AdministrationMethodEvent administrationMethodEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(administrationMethodEvent))
    }
}
