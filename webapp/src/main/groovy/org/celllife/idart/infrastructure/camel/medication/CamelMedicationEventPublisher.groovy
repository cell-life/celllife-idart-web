package org.celllife.idart.infrastructure.camel.medication

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.medication.MedicationEvent
import org.celllife.idart.domain.medication.MedicationEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Medication Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelMedicationEventPublisher implements MedicationEventPublisher {

    @EndpointInject(uri = "direct:medicationEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(MedicationEvent medicationEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(medicationEvent))
    }
}
