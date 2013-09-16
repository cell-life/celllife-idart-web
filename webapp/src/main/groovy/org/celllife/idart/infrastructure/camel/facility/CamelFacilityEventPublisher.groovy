package org.celllife.idart.infrastructure.camel.facility

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.facility.FacilityEvent
import org.celllife.idart.domain.facility.FacilityEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.framework.security.Principals.currentUsername

/**
 * Camel Facility Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelFacilityEventPublisher implements FacilityEventPublisher {

    @EndpointInject(uri = "direct:facilityEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(FacilityEvent facilityEvent) {

        facilityEvent.header.username = currentUsername

        producerTemplate.sendBody(objectMapper.writeValueAsString(facilityEvent))
    }
}
