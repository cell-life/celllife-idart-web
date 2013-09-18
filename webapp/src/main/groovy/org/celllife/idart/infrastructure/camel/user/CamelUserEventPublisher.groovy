package org.celllife.idart.infrastructure.camel.user

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.user.UserEvent
import org.celllife.idart.domain.user.UserEventPublisher

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.framework.security.Principals.currentUsername

/**
 * Camel User Event Publisher
 */
@Named class CamelUserEventPublisher implements UserEventPublisher {

    @EndpointInject(uri = "direct:userEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(UserEvent userEvent) {

        userEvent.username = currentUsername

        producerTemplate.sendBody(objectMapper.writeValueAsString(userEvent))
    }
}
