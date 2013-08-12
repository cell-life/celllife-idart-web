package org.celllife.idart.infrastructure.camel.user

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.user.UserEvent
import org.celllife.idart.domain.user.UserEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel User Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelUserEventPublisher implements UserEventPublisher {

    @EndpointInject(uri = "direct:userEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(UserEvent userEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(userEvent))
    }
}
