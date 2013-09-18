package org.celllife.idart.infrastructure.camel.prescribedmedication

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationEvent
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.framework.security.Principals.currentUsername

/**
 * Camel PrescribedMedication Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelPrescribedMedicationEventPublisher implements PrescribedMedicationEventPublisher {

    @EndpointInject(uri = "direct:prescribedMedicationEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(PrescribedMedicationEvent prescribedMedicationEvent) {

        prescribedMedicationEvent.username = currentUsername

        producerTemplate.sendBody(objectMapper.writeValueAsString(prescribedMedicationEvent))
    }
}
