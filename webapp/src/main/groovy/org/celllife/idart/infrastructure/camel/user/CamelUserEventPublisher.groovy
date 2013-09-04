package org.celllife.idart.infrastructure.camel.user

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.user.UserEvent
import org.celllife.idart.domain.user.UserEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 * Camel User Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelUserEventPublisher implements UserEventPublisher {

    @EndpointInject(uri = "direct:userEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(UserEvent userEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(userEvent))
    }
}
