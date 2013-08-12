package org.celllife.idart.infrastructure.camel.encounter

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.encounter.EncounterEvent
import org.celllife.idart.domain.encounter.EncounterEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Encounter Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelEncounterEventPublisher implements EncounterEventPublisher {

    @EndpointInject(uri = "direct:encounterEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(EncounterEvent encounterEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(encounterEvent))
    }
}
