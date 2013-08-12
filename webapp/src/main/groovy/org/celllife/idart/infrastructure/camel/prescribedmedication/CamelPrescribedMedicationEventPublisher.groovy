package org.celllife.idart.infrastructure.camel.prescribedmedication

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationEvent
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel PrescribedMedication Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelPrescribedMedicationEventPublisher implements PrescribedMedicationEventPublisher {

    @EndpointInject(uri = "direct:prescribedMedicationEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(PrescribedMedicationEvent prescribedMedicationEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(prescribedMedicationEvent))
    }
}
