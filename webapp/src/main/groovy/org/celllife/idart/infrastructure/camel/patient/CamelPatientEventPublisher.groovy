package org.celllife.idart.infrastructure.camel.patient

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.patient.PatientEvent
import org.celllife.idart.domain.patient.PatientEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Patient Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelPatientEventPublisher implements PatientEventPublisher {

    @EndpointInject(uri = "direct:patientEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(PatientEvent patientEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(patientEvent))
    }
}
