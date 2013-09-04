package org.celllife.idart.infrastructure.camel.entrysite

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.entrysite.EntrySiteEvent
import org.celllife.idart.domain.entrysite.EntrySiteEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 * Camel Entry Site Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelEntrySiteEventPublisher implements EntrySiteEventPublisher {

    @EndpointInject(uri = "direct:entrySiteEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(EntrySiteEvent entrySiteEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(entrySiteEvent))
    }
}
