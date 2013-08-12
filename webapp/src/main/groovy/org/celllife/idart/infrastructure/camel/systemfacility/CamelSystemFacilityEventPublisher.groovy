package org.celllife.idart.infrastructure.camel.systemfacility

import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.systemfacility.SystemFacilityEvent
import org.celllife.idart.domain.systemfacility.SystemFacilityEventPublisher
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel System Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelSystemFacilityEventPublisher implements SystemFacilityEventPublisher {

    @EndpointInject(uri = "direct:systemFacilityEvent") ProducerTemplate producerTemplate

    @Override
    void publish(SystemFacilityEvent systemFacilityEvent) {
        producerTemplate.sendBody(systemFacilityEvent)
    }
}
