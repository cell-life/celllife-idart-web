package org.celllife.idart.infrastructure.camel.prescription

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.prescription.PrescriptionEvent
import org.celllife.idart.domain.prescription.PrescriptionEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 * Camel Prescription Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelPrescriptionEventPublisher implements PrescriptionEventPublisher {

    @EndpointInject(uri = "direct:prescriptionEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(PrescriptionEvent prescriptionEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(prescriptionEvent))
    }
}
