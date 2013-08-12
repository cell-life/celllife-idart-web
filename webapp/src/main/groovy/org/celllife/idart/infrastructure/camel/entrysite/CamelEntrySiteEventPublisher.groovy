package org.celllife.idart.infrastructure.camel.entrysite

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.entrysite.EntrySiteEvent
import org.celllife.idart.domain.entrysite.EntrySiteEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Entry Site Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelEntrySiteEventPublisher implements EntrySiteEventPublisher {

    @EndpointInject(uri = "direct:entrySiteEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(EntrySiteEvent entrySiteEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(entrySiteEvent))
    }
}
