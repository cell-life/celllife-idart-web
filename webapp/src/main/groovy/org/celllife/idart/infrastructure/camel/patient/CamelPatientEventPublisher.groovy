package org.celllife.idart.infrastructure.camel.patient

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.patient.PatientEvent
import org.celllife.idart.domain.patient.PatientEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.framework.security.Principals.currentUsername

/**
 * Camel Patient Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelPatientEventPublisher implements PatientEventPublisher {

    @EndpointInject(uri = "direct:patientEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(PatientEvent patientEvent) {

        patientEvent.header.username = currentUsername

        producerTemplate.sendBody(objectMapper.writeValueAsString(patientEvent))
    }
}
