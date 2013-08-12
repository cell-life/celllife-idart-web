package org.celllife.idart.infrastructure.camel.system

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.system.SystemEvent
import org.celllife.idart.domain.system.SystemEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel System Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelSystemEventPublisher implements SystemEventPublisher {

    @EndpointInject(uri = "direct:systemEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(SystemEvent systemEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(systemEvent))
    }
}
