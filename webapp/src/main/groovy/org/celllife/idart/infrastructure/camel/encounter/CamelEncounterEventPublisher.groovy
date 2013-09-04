package org.celllife.idart.infrastructure.camel.encounter

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.encounter.EncounterEvent
import org.celllife.idart.domain.encounter.EncounterEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 * Camel Encounter Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelEncounterEventPublisher implements EncounterEventPublisher {

    @EndpointInject(uri = "direct:encounterEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(EncounterEvent encounterEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(encounterEvent))
    }
}
