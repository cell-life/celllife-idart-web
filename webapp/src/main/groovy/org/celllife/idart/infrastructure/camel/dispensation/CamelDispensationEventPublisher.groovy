package org.celllife.idart.infrastructure.camel.dispensation

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.dispensation.DispensationEvent
import org.celllife.idart.domain.dispensation.DispensationEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Dispensation Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelDispensationEventPublisher implements DispensationEventPublisher {

    @EndpointInject(uri = "direct:dispensationEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(DispensationEvent dispensationEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(dispensationEvent))
    }
}
