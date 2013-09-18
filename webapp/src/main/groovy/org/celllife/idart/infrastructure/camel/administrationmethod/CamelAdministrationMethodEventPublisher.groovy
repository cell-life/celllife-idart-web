package org.celllife.idart.infrastructure.camel.administrationmethod

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.administrationmethod.AdministrationMethodEvent
import org.celllife.idart.domain.administrationmethod.AdministrationMethodEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.framework.security.Principals.currentUsername

/**
 * Camel Administration Method Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelAdministrationMethodEventPublisher implements AdministrationMethodEventPublisher {

    @EndpointInject(uri = "direct:administrationMethodEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(AdministrationMethodEvent administrationMethodEvent) {

        administrationMethodEvent.username = currentUsername

        producerTemplate.sendBody(objectMapper.writeValueAsString(administrationMethodEvent))
    }
}
