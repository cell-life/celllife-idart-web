package org.celllife.idart.infrastructure.camel.usersystem

import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.relationship.usersystem.UserSystemEvent
import org.celllife.idart.relationship.usersystem.UserSystemEventPublisher
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel System Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelUserSystemEventPublisher implements UserSystemEventPublisher {

    @EndpointInject(uri = "direct:userSystemEvent") ProducerTemplate producerTemplate

    @Override
    void publish(UserSystemEvent userSystemEvent) {
        producerTemplate.sendBody(userSystemEvent)
    }
}
