package org.celllife.idart.infrastructure.camel.prescription

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.prescription.PrescriptionEvent
import org.celllife.idart.domain.prescription.PrescriptionEventPublisher

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.framework.security.Principals.currentUsername

/**
 * Camel Prescription Event Publisher
 */
@Named class CamelPrescriptionEventPublisher implements PrescriptionEventPublisher {

    @EndpointInject(uri = "direct:prescriptionEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(PrescriptionEvent prescriptionEvent) {

        prescriptionEvent.username = currentUsername

        producerTemplate.sendBody(objectMapper.writeValueAsString(prescriptionEvent))
    }
}
