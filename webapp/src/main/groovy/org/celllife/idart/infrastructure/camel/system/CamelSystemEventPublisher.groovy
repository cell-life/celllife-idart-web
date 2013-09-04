package org.celllife.idart.infrastructure.camel.system

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.system.SystemEvent
import org.celllife.idart.domain.system.SystemEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 * Camel System Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelSystemEventPublisher implements SystemEventPublisher {

    @EndpointInject(uri = "direct:systemEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(SystemEvent systemEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(systemEvent))
    }
}
