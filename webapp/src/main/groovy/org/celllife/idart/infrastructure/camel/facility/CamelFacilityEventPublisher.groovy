package org.celllife.idart.infrastructure.camel.facility

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.facility.FacilityEvent
import org.celllife.idart.domain.facility.FacilityEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Facility Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelFacilityEventPublisher implements FacilityEventPublisher {

    @EndpointInject(uri = "direct:facilityEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(FacilityEvent facilityEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(facilityEvent))
    }
}
