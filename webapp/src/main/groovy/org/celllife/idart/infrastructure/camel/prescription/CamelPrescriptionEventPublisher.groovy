package org.celllife.idart.infrastructure.camel.prescription

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.prescription.PrescriptionEvent
import org.celllife.idart.domain.prescription.PrescriptionEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Prescription Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelPrescriptionEventPublisher implements PrescriptionEventPublisher {

    @EndpointInject(uri = "direct:prescriptionEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(PrescriptionEvent prescriptionEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(prescriptionEvent))
    }
}
