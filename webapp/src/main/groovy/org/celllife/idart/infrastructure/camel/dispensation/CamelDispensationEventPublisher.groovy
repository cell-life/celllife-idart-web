package org.celllife.idart.infrastructure.camel.dispensation

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.dispensation.DispensationEvent
import org.celllife.idart.domain.dispensation.DispensationEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.framework.security.Principals.currentUsername

/**
 * Camel Dispensation Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelDispensationEventPublisher implements DispensationEventPublisher {

    @EndpointInject(uri = "direct:dispensationEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(DispensationEvent dispensationEvent) {

        dispensationEvent.username = currentUsername

        producerTemplate.sendBody(objectMapper.writeValueAsString(dispensationEvent))
    }
}
